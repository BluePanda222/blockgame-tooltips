package com.blockgame.tooltips.objects

import com.blockgame.tooltips.objects.ids.StatId

data class Stat(
	var id: StatId, // BLUNT_POWER
	var value: Double, // 2.0822
) {

	constructor(
		idStr: String,
		value: Double,
	) : this(StatId.getById(idStr), value)

}
