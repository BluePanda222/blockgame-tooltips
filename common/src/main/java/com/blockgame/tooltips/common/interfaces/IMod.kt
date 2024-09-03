package com.blockgame.tooltips.common.interfaces

import com.blockgame.tooltips.common.MinMaxValue

interface IMod {

	var displayName: String // §dCorrupted
	val stats: MutableMap<out IStatId, MinMaxValue>

	val displayNameStripped
		get() = this.displayName
			.replace("[", "")
			.replace("]", "")
			.replace("\"", "")

}