package com.blockgame.tooltips.common.interfaces

import com.blockgame.tooltips.common.MinMaxValue

interface IAbility {

	val id: String // CORRUPTION
	val displayName: String // Corruption
	val castMode: String // RIGHT_CLICK
	val abilityModifiers: MutableMap<out IAbilityModifierId, MinMaxValue>

}