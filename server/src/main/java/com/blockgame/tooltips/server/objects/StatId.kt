package com.blockgame.tooltips.server.objects

import com.blockgame.tooltips.common.ValueType
import com.blockgame.tooltips.common.interfaces.IStatId
import com.blockgame.tooltips.server.BlockgameTooltipsServer
import com.blockgame.tooltips.server.file.FileUtil
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

class StatId(
	override val name: String,
	override val statNameRaw: String,
	override val statName: String,
	override val valueType: ValueType,
) : IStatId {

	override fun toString(): String {
		return name
	}


	companion object {

		val registry = mutableMapOf<String, StatId>()

		val entries
			get() = registry.values

		val UNKNOWN = StatId("UNKNOWN", "Can't recognise that Stat.", "Can't recognise that Stat.", ValueType.UNKNOWN)

		const val STATS_FILE = "${BlockgameTooltipsServer.MOD_ID}.stats.json"


		init {
			register(UNKNOWN)

			if (FileUtil.checkIfFileExists(FileUtil.configDirectoryPath, STATS_FILE)) {
				loadFile()
			} else {
				FileUtil.getFileFromResourceAsStream("default/$STATS_FILE").use { inputStream ->
					val jsonStr = inputStream.bufferedReader().use { reader -> reader.readText() }
					FileUtil.writeToFile(jsonStr, FileUtil.configDirectoryPath, STATS_FILE)
					loadFile()
				}
			}
		}

		fun saveFile() {
			val jsonStr = listToJsonString(registry.values.toList())
			FileUtil.writeToFile(jsonStr, FileUtil.configDirectoryPath, STATS_FILE)
		}

		fun loadFile() {
			val jsonStr: String
			try {
				jsonStr = FileUtil.readFromFile(FileUtil.configDirectoryPath, STATS_FILE)
			} catch (e: Exception) {
				println("Failed to load stats file.")
				e.printStackTrace()
				return
			}
			val list: List<StatId>
			try {
				list = listFromJsonString(jsonStr)
			} catch (e: Exception) {
				println("Failed to parse stats file.")
				e.printStackTrace()
				return
			}
			list.forEach { register(it) }
		}

		fun listToJsonString(items: List<StatId>): String {
			val gson: Gson = GsonBuilder().setPrettyPrinting().create()
			return gson.toJson(items)
		}

		fun listFromJsonString(json: String): List<StatId> {
			val gson: Gson = GsonBuilder().create()
			val type = object : TypeToken<List<StatId>>() {}.type
			return gson.fromJson(json, type)
		}


		fun register(statId: StatId) {
			registry[statId.name] = statId
		}

		fun getById(idStr: String): StatId {
			return try {
				registry.getValue(idStr)
			} catch (e: NoSuchElementException) {
				UNKNOWN
			}
		}

		fun getByRawStatName(statNameRaw: String): StatId? {
			if (statNameRaw.length < 3) {
				return null
			}
			// statNameRaw = "⚒ Blunt Power: 10.2%"
			val statNameString = statNameRaw.trim().substring(statNameRaw.indexOfFirst { it == ' ' } + 1).trim() // "Blunt Power: 10.2%"

			val statName = if (statNameString.indexOf(":") == -1) {
				statNameString
			} else {
				statNameString.substring(0, statNameString.indexOf(":")).trim() // "Blunt Power"
			}

			return registry.values.firstOrNull { it.statName == statName }
		}

	}

}