package com.blockgame.tooltips.objects.ids

import com.blockgame.tooltips.BlockgameTooltipsClient
import com.blockgame.tooltips.common.MinMaxValue
import com.blockgame.tooltips.common.ValueType
import com.blockgame.tooltips.common.interfaces.IStatId
import com.blockgame.tooltips.config.ModConfig
import com.blockgame.tooltips.util.FileUtil
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import java.util.*
import kotlin.NoSuchElementException
import kotlin.math.roundToInt

class StatId(
	override val name: String,
	override val statNameRaw: String,
	override val statName: String,
	override val valueType: ValueType,
) : IStatId {

	fun getStatWith2DecimalPlacesText(oldValue: Double): Text {
		val value = if (this.name == "MOVEMENT_SPEED") {
			oldValue * 1000 // move decimal place 3 places to the right
		} else if (this.name == "KNOCKBACK_RESISTANCE") {
			oldValue * 100 // move decimal place 2 places to the right
		} else {
			oldValue
		}

		val valueStr = String.format(Locale.ROOT, "%.2f", value) // trim value to 2 decimal places
		var prefix = when (this.valueType) {
			ValueType.FLAT -> "+"
			ValueType.PERCENTAGE -> "+"
			ValueType.UNKNOWN -> "+"
		}
		val suffix = when (this.valueType) {
			ValueType.FLAT -> ""
			ValueType.PERCENTAGE -> "%"
			ValueType.UNKNOWN -> ""
		}
		if (value < 0) { // when value is negative, don't show the prefix
			prefix = ""
		}
		val valueStrFormatted = prefix + valueStr + suffix

		val valueStrColor = when {
			value < 0 -> Formatting.DARK_RED
			value > 0 -> Formatting.DARK_GREEN
			else -> Formatting.GRAY
		}

		return Text.literal("  " + this.statNameRaw + ": ").formatted(Formatting.GRAY).append(Text.literal(valueStrFormatted).formatted(valueStrColor))
	}

	fun getFormattedValue(value: Double, ignoreConversions: Boolean): String {
		return when (valueType) {
			ValueType.FLAT -> String.format(Locale.ROOT, "%.2f", value)
			ValueType.PERCENTAGE -> String.format(Locale.ROOT, "%.2f", value) + "%"
			ValueType.UNKNOWN -> value.toString()
		}
	}

	fun convertValue(oldValue: Double): Double {
		return if (this.name == "MOVEMENT_SPEED") {
			oldValue * 1000 // move decimal place 3 places to the right
		} else if (this.name == "KNOCKBACK_RESISTANCE") {
			oldValue * 100 // move decimal place 2 places to the right
		} else {
			oldValue
		}
	}

	fun getPercentage(currentValueNotConverted: Double, minMaxValue: MinMaxValue): Double {
		if (minMaxValue.min == minMaxValue.max) {
			return 1.0
		}
		val currentValue = convertValue(currentValueNotConverted)
		val min = convertValue(minMaxValue.min)
		val max = convertValue(minMaxValue.max)

		val currentValueRounded2Decimals = (currentValue * 100).roundToInt() / 100.0
		val minRounded2Decimals = (min * 100).roundToInt() / 100.0
		val maxRounded2Decimals = (max * 100).roundToInt() / 100.0

		return if (minRounded2Decimals < 0.0 && maxRounded2Decimals < 0.0) {
			1 - ((currentValueRounded2Decimals - minRounded2Decimals) / (maxRounded2Decimals - minRounded2Decimals))
		} else {
			(currentValueRounded2Decimals - minRounded2Decimals) / (maxRounded2Decimals - minRounded2Decimals)
		}
	}

	override fun toString(): String {
		return name
	}


	companion object {

		val registry = mutableMapOf<String, StatId>()

		val entries
			get() = registry.values

		val UNKNOWN = StatId("UNKNOWN", "Can't recognise that Stat.", "Can't recognise that Stat.", ValueType.UNKNOWN)

		const val STATS_FILE = "${BlockgameTooltipsClient.MOD_ID}.stats.json"


		init {
			register(UNKNOWN)

			// TODO - Change when Networking is implemented
//			if (FileUtil.checkIfFileExists(ModConfig.configDirectoryPath, STATS_FILE)) {
//				loadFile()
//			} else {
				FileUtil.getFileFromResourceAsStream("default/$STATS_FILE").use { inputStream ->
					val jsonStr = inputStream.bufferedReader().use { reader -> reader.readText() }
					FileUtil.writeToFile(jsonStr, ModConfig.configDirectoryPath, STATS_FILE)
					loadFile()
				}
//			}
		}

		fun saveFile() {
			val jsonStr = listToJsonString(registry.values.toList())
			FileUtil.writeToFile(jsonStr, ModConfig.configDirectoryPath, STATS_FILE)
		}

		fun loadFile() {
			val jsonStr: String
			try {
				jsonStr = FileUtil.readFromFile(ModConfig.configDirectoryPath, STATS_FILE)
			} catch (e: Exception) {
				BlockgameTooltipsClient.LOGGER.error("Failed to load stats file.")
				e.printStackTrace()
				return
			}
			val list: List<StatId>
			try {
				list = listFromJsonString(jsonStr)
			} catch (e: Exception) {
				BlockgameTooltipsClient.LOGGER.error("Failed to parse stats file.")
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