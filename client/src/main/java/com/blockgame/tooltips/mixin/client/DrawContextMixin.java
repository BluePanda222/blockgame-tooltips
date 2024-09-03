package com.blockgame.tooltips.mixin.client;

import com.blockgame.tooltips.ItemStackHandler;
import com.blockgame.tooltips.config.ModConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.tooltip.TooltipComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.text.StringVisitable;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mixin(DrawContext.class)
public class DrawContextMixin {

    @Unique
    private DrawContextInvoker betterThis = ((DrawContextInvoker) this);

    @Inject(method = "drawItemTooltip", at = @At("RETURN"))
    public void drawItemTooltip(TextRenderer textRenderer, ItemStack stack, int x, int y, CallbackInfo ci) {
        if (ModConfig.INSTANCE.getValues().getTooltipType() != ModConfig.TooltipType.WINDOW) {
            return;
        }

        var lore = ItemStackHandler.INSTANCE.getNewLore(stack.getNbt());
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

        betterThis.drawTooltip(textRenderer, lore, Optional.empty(), newX, newY);
    }

}
