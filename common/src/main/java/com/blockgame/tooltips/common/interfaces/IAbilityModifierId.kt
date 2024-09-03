package com.blockgame.tooltips.common.interfaces

import com.blockgame.tooltips.common.ValueType

interface IAbilityModifierId {

	val name: String
	val displayName: String
	val internalName: String
	val valueType: ValueType

}