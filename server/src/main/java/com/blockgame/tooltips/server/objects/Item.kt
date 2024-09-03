package com.blockgame.tooltips.server.objects

import com.blockgame.tooltips.common.MinMaxValue
import com.blockgame.tooltips.common.interfaces.IItem
import com.blockgame.tooltips.server.json.StatIdMapTypeAdapter
import com.google.gson.annotations.JsonAdapter

class Item(
	override val id: String,
	override val revisionId: Int?,
	@JsonAdapter(StatIdMapTypeAdapter::class)
	override val stats: MutableMap<StatId, MinMaxValue>,
	override val abilities: MutableList<Ability>,
	override val mods: MutableList<Mod>,
) : IItem {



}