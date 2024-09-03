package com.blockgame.tooltips.mixin.client;

import com.blockgame.tooltips.BlockgameTooltipsClient;
import com.blockgame.tooltips.logging.ItemLogger;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.packet.s2c.play.InventoryS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public class ClientPlayNetworkHandlerMixin {

    @Inject(method = "onInventory", at = @At("HEAD"))
    public void onInventory(InventoryS2CPacket packet, CallbackInfo info) {
        if (BlockgameTooltipsClient.INSTANCE == null) {
            return;
        }
        ItemLogger.INSTANCE.logItemStacks(packet.getContents());
    }

}
