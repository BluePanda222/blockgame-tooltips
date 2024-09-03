package com.blockgame.tooltips.objects.item

import com.blockgame.tooltips.common.MinMaxValue
import com.blockgame.tooltips.common.interfaces.IMod
import com.blockgame.tooltips.objects.ids.StatId
import com.blockgame.tooltips.objects.item.CachedItem.StatIdMapTypeAdapter
import com.google.gson.annotations.JsonAdapter

class ItemMod(
	override var displayName: String, // §dCorrupted
	@JsonAdapter(StatIdMapTypeAdapter::class)
	override val stats: MutableMap<StatId, MinMaxValue>,
) : IMod {

	constructor(
		displayName: String, // §dCorrupted
		stats: MutableMap<com.blockgame.tooltips.objects.deprecated.StatId, MinMaxValue>,
		forReasonsThatThisIsLegacyAndJavaHatesMeBecauseSameSignature: Boolean = false,
	) : this(displayName, mutableMapOf<StatId, MinMaxValue>()) {
		stats.forEach { (legacyStatId, minMaxValue) ->
			val statId = StatId.getById(legacyStatId.name)
			if (statId == StatId.UNKNOWN) {
				return@forEach
			}
			this.stats[statId] = minMaxValue
		}
	}

}