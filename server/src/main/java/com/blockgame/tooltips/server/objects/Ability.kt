package com.blockgame.tooltips.server.objects

import com.blockgame.tooltips.common.MinMaxValue
import com.blockgame.tooltips.common.interfaces.IAbility
import com.blockgame.tooltips.server.json.AbilityModifierMapTypeAdapter
import com.google.gson.annotations.JsonAdapter

class Ability(
	override val id: String,
	override var displayName: String,
	override val castMode: String,
	@JsonAdapter(AbilityModifierMapTypeAdapter::class)
	override val abilityModifiers: MutableMap<AbilityModifierId, MinMaxValue>,
) : IAbility {

	init {
		updateDisplayName()
	}

	fun updateDisplayName() {
		displayName = abilityIdsToDisplayNames[id]
			?: run {
				println("Unknown ability ID: $id")
				id
			}
	}

	fun merge(other: Ability) {
		// Merge ability modifiers
		other.abilityModifiers.forEach { (abilityModifierId, value) ->
			val existingAbilityModifier = abilityModifiers[abilityModifierId]
			if (existingAbilityModifier != null) {
				existingAbilityModifier.merge(value)
			} else {
				abilityModifiers[abilityModifierId] = value
			}
		}
	}

	companion object {

		val abilityIdsToDisplayNames = mutableMapOf(
			"ROCK_AND_AWE" to "Rock And Awe",
			"FROSTBOLT" to "Frostbolt",
			"FIREBOLT" to "Firebolt",
			"PRESSURE_WAVE" to "Pressure Wave",
			"COLLAPSING_EARTH" to "Collapsing Earth",
			"LIFE_DRAIN" to "Life Drain",
			"FLASH_HEAL" to "Flash Heal",
			"REGENERATION" to "Regeneration",
			"RING_OF_MERCY" to "Ring of Mercy",
			"CORRUPTION" to "Corruption",
			"COMBO_ATTACK" to "Combo Attack",
			"LEAP" to "Leap",
			"FIERY_SHOUT" to "Fiery Shout",
			"POISON" to "Poison",
			"WITHER" to "Wither",
			"SLOW" to "Slow",
			"BURN" to "Burn",

			"SELF_HEAL" to "Self Heal",
			"MARTYR" to "Martyr",
			"SWIFTNESS" to "Swiftness",
			"GRAND_HEAL" to "Grand Heal",
			"EXPLOSIVE_TURKEY" to "Explosive Turkey",
			"BLACK_HOLE" to "Black Hole",
			"OVERLOAD" to "Overload",
			"FIRE_METEOR" to "Fire Meteor",
		)

	}

}