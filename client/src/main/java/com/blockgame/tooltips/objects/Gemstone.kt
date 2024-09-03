package com.blockgame.tooltips.objects

import com.blockgame.tooltips.objects.ids.RuneId

class Gemstone(
	var id: RuneId, // RUNECARVING_OFFENSE_5
	var historyUuid: String // be289e2d-5c8c-4027-9b93-6dc0e5d2c046
) {

	constructor(
		idStr: String,
		historyUuid: String,
	) : this(RuneId.getById(idStr), historyUuid)

	var stats: ArrayList<Stat> = ArrayList()

}
