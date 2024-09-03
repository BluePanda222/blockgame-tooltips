package com.blockgame.tooltips.objects.deprecated

import com.blockgame.tooltips.objects.deprecated.StatId.ValueType
import com.blockgame.tooltips.objects.deprecated.StatId.ValueType.FLAT
import com.blockgame.tooltips.objects.deprecated.StatId.ValueType.PERCENTAGE
import net.minecraft.util.Formatting
import java.util.*

@Deprecated("Use AbilityModifierId from objects.v2 instead.")
enum class AbilityModifierId(
	val displayName: String,
	val internalName: String,
	val color: Formatting,
	val valueType: ValueType,
) {
	DAMAGE(			" >| Damage", 			"damage", 			Formatting.GRAY, ValueType.FLAT),
	HEAL(			" >| Heal", 				"heal", 			Formatting.GRAY, ValueType.FLAT),
	COOLDOWN(		" >| Cooldown", 			"cooldown", 		Formatting.GRAY, ValueType.FLAT),
	DURATION(		" >| Duration", 			"duration", 		Formatting.GRAY, ValueType.FLAT),
	IGNITE(			" >| Ignite", 			"ignite", 			Formatting.GRAY, ValueType.FLAT),
	ANGLE(			" >| Angle", 			"angle", 			Formatting.GRAY, ValueType.FLAT),
	FORCE(			" >| Force", 			"force", 			Formatting.GRAY, ValueType.FLAT),
	RADIUS(			" >| Radius", 			"radius", 			Formatting.GRAY, ValueType.FLAT),
	BLESS_DURATION(	" >| Bless Duration", 	"duration", 		Formatting.GRAY, ValueType.FLAT),
	BLESS_STRENGTH(	" >| Bless Strength", 	"amplifier", 		Formatting.GRAY, ValueType.FLAT),
	CURSE_DURATION(	" >| Curse Duration", 	"duration", 		Formatting.GRAY, ValueType.FLAT),
	CURSE_STRENGTH(	" >| Curse Strength", 	"amplifier", 		Formatting.GRAY, ValueType.FLAT),
	SLOW_DURATION(	" >| Slow Duration", 	"slow-duration",	Formatting.GRAY, ValueType.FLAT),
	;

	fun getFormattedValue(oldValue: Double, ignoreConversions: Boolean): String {
		var value = oldValue
		if (ignoreConversions) {
			value = oldValue
		}

		return when (valueType) {
			FLAT -> String.format(Locale.ROOT, "%.2f", value)
			PERCENTAGE -> String.format(Locale.ROOT, "%.2f", value) + "%"
			ValueType.UNKNOWN -> value.toString()
		}
	}


	companion object {

		fun getByDisplayNameByTextWithoutPrefix(displayNameWithoutPrefix: String): AbilityModifierId? {
			return entries.firstOrNull { it.displayName.substring(4) == displayNameWithoutPrefix }
		}

	}

}