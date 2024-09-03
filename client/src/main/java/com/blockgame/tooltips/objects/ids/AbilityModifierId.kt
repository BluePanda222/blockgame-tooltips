package com.blockgame.tooltips.objects.ids

import com.blockgame.tooltips.BlockgameTooltipsClient
import com.blockgame.tooltips.common.ValueType
import com.blockgame.tooltips.common.interfaces.IAbilityModifierId
import com.blockgame.tooltips.config.ModConfig
import com.blockgame.tooltips.util.FileUtil
import com.google.gson.*
import com.google.gson.reflect.TypeToken
import java.util.*

class AbilityModifierId(
	override val name: String,
	override val displayName: String,
	override val internalName: String,
	override val valueType: ValueType,
) : IAbilityModifierId {

	fun getFormattedValue(oldValue: Double, ignoreConversions: Boolean): String {
		var value = oldValue
		if (ignoreConversions) {
			value = oldValue
		}

		return when (valueType) {
			ValueType.FLAT -> String.format(Locale.ROOT, "%.1f", value)
			ValueType.PERCENTAGE -> String.format(Locale.ROOT, "%.1f", value) + "%"
			ValueType.UNKNOWN -> value.toString()
		}
	}


	companion object {

		val registry = mutableMapOf<String, AbilityModifierId>()

		const val ABILITY_FILE = "${BlockgameTooltipsClient.MOD_ID}.ability.json"


		init {
			// TODO - Change when Networking is implemented
//			if (FileUtil.checkIfFileExists(ModConfig.configDirectoryPath, ABILITY_FILE)) {
//				loadFile()
//			} else {
				FileUtil.getFileFromResourceAsStream("default/$ABILITY_FILE").use { inputStream ->
					val jsonStr = inputStream.bufferedReader().use { reader -> reader.readText() }
					FileUtil.writeToFile(jsonStr, ModConfig.configDirectoryPath, ABILITY_FILE)
					loadFile()
				}
//			}
		}

		fun saveFile() {
			val jsonStr = listToJsonString(registry.values.toList())
			FileUtil.writeToFile(jsonStr, ModConfig.configDirectoryPath, ABILITY_FILE)
		}

		fun loadFile() {
			val jsonStr: String
			try {
				jsonStr = FileUtil.readFromFile(ModConfig.configDirectoryPath, ABILITY_FILE)
			} catch (e: Exception) {
				BlockgameTooltipsClient.LOGGER.error("Failed to load ability file.")
				e.printStackTrace()
				return
			}
			val list: List<AbilityModifierId>
			try {
				list = listFromJsonString(jsonStr)
			} catch (e: Exception) {
				BlockgameTooltipsClient.LOGGER.error("Failed to parse ability file.")
				e.printStackTrace()
				return
			}
			list.forEach { register(it) }
		}

		fun listToJsonString(items: List<AbilityModifierId>): String {
			val gson: Gson = GsonBuilder().setPrettyPrinting().create()
			return gson.toJson(items)
		}

		fun listFromJsonString(json: String): List<AbilityModifierId> {
			val gson: Gson = GsonBuilder().create()
			val type = object : TypeToken<List<AbilityModifierId>>() {}.type
			return gson.fromJson(json, type)
		}


		fun register(abilityModifierId: AbilityModifierId) {
			registry[abilityModifierId.name] = abilityModifierId
		}

		fun getById(idStr: String): AbilityModifierId? {
			return registry[idStr]
		}

		fun getByDisplayNameByTextWithoutPrefix(displayNameWithoutPrefix: String): AbilityModifierId? {
			return registry.values.firstOrNull { it.displayName.substring(4) == displayNameWithoutPrefix }
		}

	}

}