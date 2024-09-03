package com.blockgame.tooltips.config

import com.terraformersmc.modmenu.api.ConfigScreenFactory
import com.terraformersmc.modmenu.api.ModMenuApi
import net.minecraft.client.MinecraftClient

class ModMenuIntegration : ModMenuApi {

	override fun getModConfigScreenFactory(): ConfigScreenFactory<*> {
		return ConfigScreenFactory { ModConfig.getConfigScreen(MinecraftClient.getInstance().currentScreen) }
	}

}
