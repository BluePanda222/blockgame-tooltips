package com.blockgame.tooltips.common.interfaces

import com.blockgame.tooltips.common.MinMaxValue

interface IItem {

	val id: String
	val revisionId: Int?

	val stats: MutableMap<out IStatId, MinMaxValue>
	val abilities: MutableList<out IAbility>
	val mods: MutableList<out IMod>

}
