package com.blockgame.tooltips.objects.deprecated

import com.blockgame.tooltips.objects.deprecated.StatId.ValueType.*
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import java.util.*

@Deprecated("Use StatId from objects.v2 instead.")
enum class StatId(
	val statNameRaw: String,
	val statName: String,
	val color: Formatting,
	val valueType: ValueType,
) {
	ATTACK_DAMAGE("\uD83D\uDDE1 Attack Damage", "Attack Damage", Formatting.GRAY, ValueType.FLAT),
	ATTACK_SPEED("\uD83D\uDDE1 Attack Speed", "Attack Speed", Formatting.GRAY, ValueType.FLAT),

	CRITICAL_STRIKE_POWER("\uD83D\uDDE1 Critical Power", "Critical Power", Formatting.GRAY, ValueType.PERCENTAGE),
	CRITICAL_STRIKE_CHANCE("\uD83D\uDDE1 Critical Chance", "Critical Chance", Formatting.GRAY, ValueType.PERCENTAGE),

	BLUNT_POWER("⚒ Blunt Power", "Blunt Power", Formatting.GRAY, ValueType.FLAT),
	BLUNT_RATING("⚒ Blunt Rating", "Blunt Rating", Formatting.GRAY, ValueType.PERCENTAGE),

	BLOCK_POWER("⛨ Block Power", "Block Power", Formatting.GRAY, ValueType.PERCENTAGE),
	BLOCK_RATING("⛨ Block Rating", "Block Rating", Formatting.GRAY, ValueType.PERCENTAGE),
	BLOCK_COOLDOWN_REDUCTION("⛨ Block Cooldown Reduction", "Block Cooldown Reduction", Formatting.GRAY, ValueType.PERCENTAGE),

	PVE_DAMAGE("\uD83D\uDDE1 PvE Damage", "PvE Damage", Formatting.GRAY, ValueType.PERCENTAGE),
	PVE_DAMAGE_REDUCTION("⛨ PvE Damage Reduction", "PvE Damage Reduction", Formatting.GRAY, ValueType.PERCENTAGE),

	PVP_DAMAGE("\uD83D\uDDE1 PvP Damage", "PvP Damage", Formatting.GRAY, ValueType.PERCENTAGE),
	PVP_DAMAGE_REDUCTION("⛨ PvP Damage Reduction", "PvP Damage Reduction", Formatting.GRAY, ValueType.PERCENTAGE),

	MAGIC_DAMAGE("☄ Magic Damage", "Magic Damage", Formatting.GRAY, ValueType.PERCENTAGE),
	PROJECTILE_DAMAGE("\uD83C\uDFF9 Projectile Damage", "Projectile Damage", Formatting.GRAY, ValueType.PERCENTAGE),
	WEAPON_DAMAGE("\uD83D\uDDE1 Weapon Damage", "Weapon Damage", Formatting.GRAY, ValueType.PERCENTAGE),
	THAUMATURGY_DAMAGE("☮ Thaumaturgy Power", "Thaumaturgy Power", Formatting.GRAY, ValueType.PERCENTAGE),

	DAMAGE_REDUCTION("⛨ Damage Reduction", "Damage Reduction", Formatting.GRAY, ValueType.PERCENTAGE),
	FALL_DAMAGE_REDUCTION("⛨ Fall Damage Reduction", "Fall Damage Reduction", Formatting.GRAY, ValueType.PERCENTAGE),

	DEFENSE("⛨ Defense", "Defense", Formatting.GRAY, ValueType.FLAT),

	ADDITIONAL_EXPERIENCE_HERBALISM("☘ Herbalism EXP", "Herbalism EXP", Formatting.GRAY, ValueType.PERCENTAGE),
	ADDITIONAL_EXPERIENCE_ARCHAEOLOGY("☠ Archaeology EXP", "Archaeology EXP", Formatting.GRAY, ValueType.PERCENTAGE),
	ADDITIONAL_EXPERIENCE_LOGGING("\uD83E\uDE93 Logging EXP", "Logging EXP", Formatting.GRAY, ValueType.PERCENTAGE),
	ADDITIONAL_EXPERIENCE_FISHING("\uD83C\uDFA3 Fishing EXP", "Fishing EXP", Formatting.GRAY, ValueType.PERCENTAGE),
	ADDITIONAL_EXPERIENCE_RUNECARVING("ᚱ Runecarving EXP", "Runecarving EXP", Formatting.GRAY, ValueType.PERCENTAGE),
	ADDITIONAL_EXPERIENCE_MINING("⛏ Mining EXP", "Mining EXP", Formatting.GRAY, ValueType.PERCENTAGE),
	ADDITIONAL_EXPERIENCE_COOKING("\uD83C\uDF56 Cooking EXP", "Cooking EXP", Formatting.GRAY, ValueType.PERCENTAGE),
	ADDITIONAL_EXPERIENCE("∞ Class EXP", "Class EXP", Formatting.GRAY, ValueType.PERCENTAGE),

	CRITICAL_FISHING_CHANCE("\uD83C\uDFA3 Critical Fishing Chance", "Critical Fishing Chance", Formatting.GRAY, ValueType.FLAT),

	SKILL_HERBALISM("☘ Herbalism Skill", "Herbalism Skill", Formatting.GRAY, ValueType.FLAT),
	SKILL_ARCHAEOLOGY("☠ Archaeology Skill", "Archaeology Skill", Formatting.GRAY, ValueType.FLAT),
	SKILL_LOGGING("\uD83E\uDE93 Logging Skill", "Logging Skill", Formatting.GRAY, ValueType.FLAT),
	SKILL_FISHING("\uD83C\uDFA3 Fishing Skill", "Fishing Skill", Formatting.GRAY, ValueType.FLAT),
	SKILL_RUNECARVING("ᚱ Runecarving Skill", "Runecarving Skill", Formatting.GRAY, ValueType.FLAT),
	SKILL_COOKING("\uD83C\uDF56 Cooking Skill", "Cooking Skill", Formatting.GRAY, ValueType.FLAT),
	SKILL_MINING("⛏ Mining Skill", "Mining Skill", Formatting.GRAY, ValueType.FLAT),

	COOLDOWN_REDUCTION("⏳ Cooldown Reduction", "Cooldown Reduction", Formatting.GRAY, ValueType.PERCENTAGE),

	MOVEMENT_SPEED("⌚ Movement Speed", "Movement Speed", Formatting.GRAY, ValueType.PERCENTAGE),

	ARROW_VELOCITY("\uD83C\uDFF9 Arrow Velocity", "Arrow Velocity", Formatting.GRAY, ValueType.FLAT),

	MAX_HEALTH("❤ Health", "Health", Formatting.GRAY, ValueType.FLAT),
	HEALTH_REGENERATION("❤ Health Regeneration", "Health Regeneration", Formatting.GRAY, ValueType.FLAT),
	HEALING_RECEIVED("❤ Healing Received", "Healing Received", Formatting.GRAY, ValueType.PERCENTAGE),

	KNOCKBACK_RESISTANCE("⛨ Knockback Resistance", "Knockback Resistance", Formatting.GRAY, ValueType.PERCENTAGE),

//	NAME("NAME", Formatting.RED, ValueType.UNKNOWN),
//	ENCHANTS("ENCHANTS", Formatting.RED, ValueType.UNKNOWN),
//	LORE("LORE", Formatting.RED, ValueType.UNKNOWN),
	UNKNOWN("Can't recognise that Stat.", "Can't recognise that Stat.", Formatting.RED, ValueType.UNKNOWN)
	;

	fun getStatWith2DecimalPlacesText(oldValue: Double): Text {
		val value = if (this == MOVEMENT_SPEED) {
			oldValue * 1000 // move decimal place 3 places to the right
		} else if (this == KNOCKBACK_RESISTANCE) {
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

		return Text.literal("  " + this.statNameRaw + ": ").formatted(this.color).append(Text.literal(valueStrFormatted).formatted(valueStrColor))
	}

	fun getFormattedValue(oldValue: Double, ignoreConversions: Boolean): String {
		var value = if (this == MOVEMENT_SPEED) {
			oldValue * 1000 // move decimal place 3 places to the right
		} else if (this == KNOCKBACK_RESISTANCE) {
			oldValue * 100 // move decimal place 2 places to the right
		} else {
			oldValue
		}
		// TODO - remove ignoreConversions parameter properly. conversion is not needed here.
		if (ignoreConversions) {
			value = oldValue
		}

		return when (valueType) {
			FLAT -> String.format(Locale.ROOT, "%.2f", value)
			PERCENTAGE -> String.format(Locale.ROOT, "%.2f", value) + "%"
			ValueType.UNKNOWN -> value.toString()
		}
	}

	fun convertValue(oldValue: Double): Double {
		return if (this == MOVEMENT_SPEED) {
			oldValue * 1000 // move decimal place 3 places to the right
		} else if (this == KNOCKBACK_RESISTANCE) {
			oldValue * 100 // move decimal place 2 places to the right
		} else {
			oldValue
		}
	}


	enum class ValueType {
		FLAT,
		PERCENTAGE,
		UNKNOWN,
		;
	}

	companion object {

		fun getById(idStr: String): StatId {
			return try {
				StatId.valueOf(idStr.uppercase())
			} catch (e: IllegalArgumentException) {
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

			return entries.firstOrNull { it.statName == statName }
		}

	}

}