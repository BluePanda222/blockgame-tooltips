package com.blockgame.tooltips.mixin.client;

import com.blockgame.tooltips.BlockgameTooltipsClient;
import com.blockgame.tooltips.ItemStackHandler;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.*;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {

    @Shadow
    public abstract @Nullable NbtCompound getNbt();

    @Shadow public abstract Item getItem();

    @Inject(method = "getTooltip", at = @At("TAIL"))
    private void getTooltip(@Nullable PlayerEntity player, TooltipContext context, CallbackInfoReturnable<List<Text>> ci) {
        if (BlockgameTooltipsClient.INSTANCE == null) {
            return;
        }

        NbtCompound nbt = this.getNbt();
        var loreReturnValue = ci.getReturnValue();

        ItemStackHandler.INSTANCE.modifyLore(nbt, loreReturnValue);
    }

}
