package com.blockgame.tooltips.server.objects

import com.blockgame.tooltips.common.MinMaxValue
import com.blockgame.tooltips.common.interfaces.IMod
import com.blockgame.tooltips.server.json.StatIdMapTypeAdapter
import com.google.gson.annotations.JsonAdapter

class Mod(
	override var displayName: String,
	@JsonAdapter(StatIdMapTypeAdapter::class)
	override val stats: MutableMap<StatId, MinMaxValue>,
) : IMod {

	fun merge(other: Mod) {
		// Merge stats
		other.stats.forEach { (statId, value) ->
			val existingStat = stats[statId]
			if (existingStat != null) {
				existingStat.merge(value)
			} else {
				stats[statId] = value
			}
		}
	}

}