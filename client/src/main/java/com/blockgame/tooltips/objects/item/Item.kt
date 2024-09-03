package com.blockgame.tooltips.objects.item

import com.blockgame.tooltips.common.MinMaxValue
import com.blockgame.tooltips.common.interfaces.IItem
import com.blockgame.tooltips.objects.Mod
import com.blockgame.tooltips.objects.ids.AbilityModifierId
import com.blockgame.tooltips.objects.ids.StatId
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.annotations.JsonAdapter
import com.google.gson.reflect.TypeToken
import net.minecraft.text.Text
import net.minecraft.util.Formatting

class Item(
	override val id: String,
	override val revisionId: Int? = null,
) : IItem {

	@JsonAdapter(CachedItem.StatIdMapTypeAdapter::class)
	override val stats = mutableMapOf<StatId, MinMaxValue>()
	override val abilities = mutableListOf<Ability>()
	override val mods = mutableListOf<ItemMod>()

	constructor(
		id: String,
		statsToMinMaxValues: MutableMap<com.blockgame.tooltips.objects.deprecated.StatId, MinMaxValue>,
	) : this(id) {
		statsToMinMaxValues.forEach { (legacyStatId, minMaxValue) ->
			val statId = StatId.getById(legacyStatId.name)
			if (statId == StatId.UNKNOWN) {
				return@forEach
			}
			this.stats[statId] = minMaxValue
		}
	}

	constructor(
		id: String,
		statsToMinMaxValues: MutableMap<com.blockgame.tooltips.objects.deprecated.StatId, MinMaxValue>,
		abilities: List<Ability>,
	) : this(id, statsToMinMaxValues) {
		this.abilities.addAll(abilities)
	}

	constructor(
		id: String,
		statsToMinMaxValues: MutableMap<com.blockgame.tooltips.objects.deprecated.StatId, MinMaxValue>,
		abilities: List<Ability>,
		mods: List<ItemMod>,
	) : this(id, statsToMinMaxValues, abilities) {
		this.mods.addAll(mods)
	}


//	fun getStatToMinMaxValueByStatName(statNameRaw: String): Triple<StatId, MinMaxValue, Double?>? {
//		if (statNameRaw.length < 2 || statNameRaw.indexOf(":") == -1) {
//			return null
//		}
//		// statNameRaw = "⚒ Blunt Power: 10.2%"
//		val statNameString = statNameRaw.trim().substring(1).trim() // "Blunt Power: 10.2%"
//		val statName = statNameString.substring(0, statNameString.indexOf(":")).trim() // "Blunt Power"
////		val value = statNameString.substring(statNameString.indexOf(":") + 1)
////			.replace("%", "").toDoubleOrNull() // 10.2
//
//		return stats.asSequence()
//			.filter {
//				it.key.statName.trim() == statName
//			}.map {
//				Triple(it.key, it.value, this.
//			}.firstOrNull()
//	}

	fun getPercentageText(statId: StatId, value: Double): Text? {
		val minMaxValue = this.stats[statId]
			?: return null

		val percentage = minMaxValue.getPercentage(statId.convertValue(value))

		val color = when {
			percentage < 0.25 -> Formatting.RED
			percentage < 0.5 -> Formatting.GOLD
			percentage < 0.75 -> Formatting.YELLOW
			percentage < 1 -> Formatting.AQUA
			percentage <= 1.0 -> Formatting.LIGHT_PURPLE
			percentage > 1 -> Formatting.DARK_AQUA
			else -> Formatting.WHITE
		}

		return Text.literal("[").formatted(Formatting.DARK_GRAY)
			.append(Text.literal("${(percentage * 100).toInt()}%").formatted(color))
			.append(Text.literal("]")).formatted(Formatting.DARK_GRAY)
	}

	fun getPercentageText(ability: Ability, abilityModifierId: AbilityModifierId, value: Double): Text? {
		val minMaxValue = this.abilities.firstOrNull { it.id == ability.id }?.abilityModifiers?.get(abilityModifierId)
			?: return null

		val percentage = minMaxValue.getPercentage(value)

		val color = when {
			percentage < 0.25 -> Formatting.RED
			percentage < 0.5 -> Formatting.GOLD
			percentage < 0.75 -> Formatting.YELLOW
			percentage < 1 -> Formatting.AQUA
			percentage <= 1.0 -> Formatting.LIGHT_PURPLE
			percentage > 1 -> Formatting.DARK_AQUA
			else -> Formatting.WHITE
		}

		return Text.literal("[").formatted(Formatting.DARK_GRAY)
			.append(Text.literal("${(percentage * 100).toInt()}%").formatted(color))
			.append(Text.literal("]")).formatted(Formatting.DARK_GRAY)
	}

	fun getPercentageText(mod: Mod, statId: StatId, value: Double): Text? {
		val minMaxValue = this.mods.firstOrNull { it.displayNameStripped == mod.displayNameStripped }?.stats?.get(statId)
			?: return null

		val percentage = minMaxValue.getPercentage(statId.convertValue(value))

		val color = when {
			percentage < 0.25 -> Formatting.RED
			percentage < 0.5 -> Formatting.GOLD
			percentage < 0.75 -> Formatting.YELLOW
			percentage < 1 -> Formatting.AQUA
			percentage <= 1.0 -> Formatting.LIGHT_PURPLE
			percentage > 1 -> Formatting.DARK_AQUA
			else -> Formatting.WHITE
		}

		return Text.literal("[").formatted(Formatting.DARK_GRAY)
			.append(Text.literal("${(percentage * 100).toInt()}%").formatted(color))
			.append(Text.literal("]")).formatted(Formatting.DARK_GRAY)
	}

	fun getRangeText(statId: StatId): Text? {
		val minMaxValue = this.stats[statId]
			?: return null

		return if (minMaxValue.min == minMaxValue.max) {
			Text.literal("[").formatted(Formatting.DARK_GRAY)
				.append(Text.literal(statId.getFormattedValue(minMaxValue.min, true)).formatted(Formatting.GREEN))
				.append(Text.literal("]")).formatted(Formatting.DARK_GRAY)
		} else {
			Text.literal("[").formatted(Formatting.DARK_GRAY)
				.append(Text.literal("${statId.getFormattedValue(minMaxValue.min, true)} - ${statId.getFormattedValue(minMaxValue.max, true)}").formatted(Formatting.GREEN))
				.append(Text.literal("]")).formatted(Formatting.DARK_GRAY)
		}
	}

	fun getRangeText(ability: Ability, abilityModifierId: AbilityModifierId): Text? {
		val minMaxValue = this.abilities.firstOrNull { it.id == ability.id }?.abilityModifiers?.get(abilityModifierId)
			?: return null

		return if (minMaxValue.min == minMaxValue.max) {
			Text.literal("[").formatted(Formatting.DARK_GRAY)
				.append(Text.literal(abilityModifierId.getFormattedValue(minMaxValue.min, true)).formatted(Formatting.GREEN))
				.append(Text.literal("]")).formatted(Formatting.DARK_GRAY)
		} else {
			Text.literal("[").formatted(Formatting.DARK_GRAY)
				.append(Text.literal("${abilityModifierId.getFormattedValue(minMaxValue.min, true)} - ${abilityModifierId.getFormattedValue(minMaxValue.max, true)}").formatted(Formatting.GREEN))
				.append(Text.literal("]")).formatted(Formatting.DARK_GRAY)
		}
	}

	fun getRangeText(mod: Mod, statId: StatId): Text? {
		val minMaxValue = this.mods.firstOrNull { it.displayNameStripped == mod.displayNameStripped }?.stats?.get(statId)
			?: return null

		return if (minMaxValue.min == minMaxValue.max) {
			Text.literal("[").formatted(Formatting.DARK_GRAY)
				.append(Text.literal(statId.getFormattedValue(minMaxValue.min, true)).formatted(Formatting.GREEN))
				.append(Text.literal("]")).formatted(Formatting.DARK_GRAY)
		} else {
			Text.literal("[").formatted(Formatting.DARK_GRAY)
				.append(Text.literal("${statId.getFormattedValue(minMaxValue.min, true)} - ${statId.getFormattedValue(minMaxValue.max, true)}").formatted(Formatting.GREEN))
				.append(Text.literal("]")).formatted(Formatting.DARK_GRAY)
		}
	}

}