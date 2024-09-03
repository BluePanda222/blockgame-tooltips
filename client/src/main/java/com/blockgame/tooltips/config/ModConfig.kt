package com.blockgame.tooltips.config

import com.blockgame.tooltips.BlockgameTooltipsClient.MOD_ID
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import me.shedaniel.clothconfig2.api.ConfigBuilder
import me.shedaniel.clothconfig2.api.ConfigCategory
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder
import net.fabricmc.loader.api.FabricLoader
import net.minecraft.client.gui.screen.Screen
import net.minecraft.client.util.InputUtil
import net.minecraft.text.MutableText
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import net.minecraft.util.Identifier
import java.io.File

object ModConfig {

	val json = Json {
		encodeDefaults = true
		ignoreUnknownKeys = true
		prettyPrint = true
	}
	val configDirectoryPath: String
		get() = FabricLoader.getInstance().configDir.toString() + "\\" + MOD_ID

	var values = ConfigVariables()

	@JvmStatic
	fun getConfigScreen(previousScreen: Screen? = null): Screen {
		val builder: ConfigBuilder = ConfigBuilder.create()
			.setParentScreen(previousScreen)
			.setTitle(Text.translatable("blockgametooltips.config.title").formatted(Formatting.AQUA))
			.setSavingRunnable {
				val configDirectory = File(configDirectoryPath)
				if (!configDirectory.exists()) {
					configDirectory.mkdir()
				}

				val configFile = File(configDirectory, "$MOD_ID.json")
				configFile.writeText(json.encodeToString(ConfigVariables.serializer(), values))
			}
			.setDefaultBackgroundTexture(Identifier.of("minecraft", "textures/block/dark_prismarine.png"))
		val entryBuilder = builder.entryBuilder()

		val mainCategory = builder.getOrCreateCategory(Text.translatable("$MOD_ID.category.main"))
		builder.setFallbackCategory(mainCategory)

		addKeyBindOptions(mainCategory, builder, entryBuilder)
		addToggleOptions(mainCategory, builder, entryBuilder)

		return builder.build()
	}


	fun load() {
		val configDirectory = File(configDirectoryPath)
		if (!configDirectory.exists()) {
			configDirectory.mkdir()
		}
		val configFile = File(configDirectory, "$MOD_ID.json")
		if (!configFile.exists()) {
			configFile.createNewFile()
			configFile.writeText(json.encodeToString(ConfigVariables.serializer(), values))
		}
		val json = Json {
			prettyPrint = true
			ignoreUnknownKeys = true
			encodeDefaults = true
		}
		values = json.decodeFromString(ConfigVariables.serializer(), configFile.readText())
	}

	private fun addKeyBindOptions(category: ConfigCategory, builder: ConfigBuilder, entryBuilder: ConfigEntryBuilder) {
		val keyBinds = entryBuilder.startSubCategory(Text.translatable("$MOD_ID.category.keyBinds"))
		keyBinds.setExpanded(true)

		keyBinds.add(
			entryBuilder.startKeyCodeField(Text.translatable("$MOD_ID.key.show"), InputUtil.Type.KEYSYM.createFromCode(values.show))
				.setDefaultValue(InputUtil.Type.KEYSYM.createFromCode(ConfigVariables().show))
				.setTooltip(Text.translatable("$MOD_ID.key.show.tooltip"))
				.setKeySaveConsumer { values.show = it.code }
				.build()
		)
		keyBinds.add(
			entryBuilder.startKeyCodeField(Text.translatable("$MOD_ID.key.showMinMaxValues"), InputUtil.Type.KEYSYM.createFromCode(values.showMinMaxValues))
				.setDefaultValue(InputUtil.Type.KEYSYM.createFromCode(ConfigVariables().showMinMaxValues))
				.setTooltip(Text.translatable("$MOD_ID.key.showMinMaxValues.tooltip"))
				.setKeySaveConsumer { values.showMinMaxValues = it.code }
				.build()
		)

		category.addEntry(keyBinds.build())
	}

	private fun addToggleOptions(category: ConfigCategory, builder: ConfigBuilder, entryBuilder: ConfigEntryBuilder) {
		val toggles = entryBuilder.startSubCategory(Text.translatable("$MOD_ID.category.toggles"))
		toggles.setExpanded(true)

		toggles.add(
			entryBuilder.startEnumSelector(Text.translatable("$MOD_ID.key.tooltipType"), TooltipType::class.java, values.tooltipType)
				.setDefaultValue(ConfigVariables().tooltipType)
				.setTooltip(Text.translatable("$MOD_ID.key.tooltipType.tooltip"))
				.setSaveConsumer { values.tooltipType = it }
				.setEnumNameProvider { (it as? TooltipType)?.translatable ?: Text.of(it.toString()) }
				.build()
		)

		category.addEntry(toggles.build())
	}

	@Serializable
	data class ConfigVariables(
		var show: Int = InputUtil.GLFW_KEY_LEFT_CONTROL,
		var showMinMaxValues: Int = InputUtil.GLFW_KEY_LEFT_SHIFT,
		var tooltipType: TooltipType = TooltipType.INLINE
	)

	enum class TooltipType(
		val translatable: MutableText
	) {
		INLINE(Text.translatable("$MOD_ID.tooltipType.inline")),
		WINDOW(Text.translatable("$MOD_ID.tooltipType.window"))
		;
	}

}