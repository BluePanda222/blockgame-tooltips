package com.blockgame.tooltips.server.objects

import com.blockgame.tooltips.common.ValueType
import com.blockgame.tooltips.common.interfaces.IAbilityModifierId
import com.blockgame.tooltips.server.BlockgameTooltipsServer
import com.blockgame.tooltips.server.file.FileUtil
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

class AbilityModifierId(
	override val name: String,
	override val displayName: String,
	override val internalName: String,
	override val valueType: ValueType,
) : IAbilityModifierId {

	companion object {

		val registry = mutableMapOf<String, AbilityModifierId>()

		const val ABILITY_FILE = "${BlockgameTooltipsServer.MOD_ID}.ability.json"


		init {
			if (FileUtil.checkIfFileExists(FileUtil.configDirectoryPath, ABILITY_FILE)) {
				loadFile()
			} else {
				FileUtil.getFileFromResourceAsStream("default/$ABILITY_FILE").use { inputStream ->
					val jsonStr = inputStream.bufferedReader().use { reader -> reader.readText() }
					FileUtil.writeToFile(jsonStr, FileUtil.configDirectoryPath, ABILITY_FILE)
					loadFile()
				}
			}
		}

		fun saveFile() {
			val jsonStr = listToJsonString(registry.values.toList())
			FileUtil.writeToFile(jsonStr, FileUtil.configDirectoryPath, ABILITY_FILE)
		}

		fun loadFile() {
			val jsonStr: String
			try {
				jsonStr = FileUtil.readFromFile(FileUtil.configDirectoryPath, ABILITY_FILE)
			} catch (e: Exception) {
				println("Failed to load ability file.")
				e.printStackTrace()
				return
			}
			val list: List<AbilityModifierId>
			try {
				list = listFromJsonString(jsonStr)
			} catch (e: Exception) {
				println("Failed to parse ability file.")
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