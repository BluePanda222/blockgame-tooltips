package com.blockgame.tooltips.mixin.client;

import com.blockgame.tooltips.ItemStackHandler;
import com.blockgame.tooltips.config.ModConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.tooltip.TooltipComponent;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mixin(HandledScreen.class)
public abstract class HandledScreenMixin<T extends ScreenHandler> {

    @Shadow
    protected Slot focusedSlot;

    @Final
    @Shadow
    protected T handler;

    @Inject(method = "drawMouseoverTooltip", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screen/ingame/HandledScreen;getTooltipFromItem(Lnet/minecraft/item/ItemStack;)Ljava/util/List;"))
    protected void drawMouseoverTooltip(DrawContext context, int x, int y, CallbackInfo ci) {
        if (ModConfig.INSTANCE.getValues().getTooltipType() != ModConfig.TooltipType.WINDOW) {
            return;
        }

        if (this.handler.getCursorStack().isEmpty() && this.focusedSlot != null && this.focusedSlot.hasStack()) {
            var lore = ItemStackHandler.INSTANCE.getNewLore(this.focusedSlot.getStack().getNbt());
            if (lore == null) {
                return;
            }

            List<TooltipComponent> components = lore.stream().map(Text::asOrderedText).map(TooltipComponent::of).collect(Collectors.toList());

            int i = 0;
            int j = components.size() == 1 ? -2 : 0;
            for (TooltipComponent tooltipComponent : components) {
                int k = tooltipComponent.getWidth(MinecraftClient.getInstance().textRenderer);
                if (k > i) {
                    i = k;
                }
                j += tooltipComponent.getHeight();
            }
            int width = i;
            int height = j;

            var newX = x - width - 10;
//            var newY = y - height / 2;
            var newY = y;

            context.drawTooltip(MinecraftClient.getInstance().textRenderer, lore, Optional.empty(), newX, newY);
        }
    }

}
