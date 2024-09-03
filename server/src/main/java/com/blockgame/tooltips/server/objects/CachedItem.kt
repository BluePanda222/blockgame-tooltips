package com.blockgame.tooltips.server.objects

import com.blockgame.tooltips.common.MinMaxValue
import com.blockgame.tooltips.common.interfaces.ICachedItem
import com.blockgame.tooltips.server.json.StatIdMapTypeAdapter
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.annotations.JsonAdapter
import com.google.gson.reflect.TypeToken

class CachedItem(
	override val id: String,
	override var revisionId: Int?,
	@JsonAdapter(StatIdMapTypeAdapter::class)
	override val stats: MutableMap<StatId, MinMaxValue>,
	override val abilities: MutableList<Ability>,
	override val mods: MutableList<Mod>,
	override var lore: MutableList<String>?,
) : ICachedItem {

	fun merge(other: CachedItem) {
		if (this.revisionId == null && other.revisionId != null) {
			this.revisionId = other.revisionId
			return
		}
		if (this.revisionId != other.revisionId) {
			println("Revision ID mismatch: ${this.revisionId} != ${other.revisionId} of item ${this.id} and ${other.id}")
			return
		}

		// Merge stats
		other.stats.forEach { (statId, value) ->
			val existingStat = stats[statId]
			if (existingStat != null) {
				existingStat.merge(value)
			} else {
				stats[statId] = value
			}
		}

		// Merge abilities
		other.abilities.forEach { ability ->
			val existingAbility = abilities.firstOrNull { it.id == ability.id }
			if (existingAbility != null) {
				existingAbility.merge(ability)
			} else {
				abilities.add(ability)
			}
		}

		// Merge mods
		other.mods.forEach { mod ->
			val existingMod = mods.firstOrNull { it.displayNameStripped == mod.displayNameStripped }
			if (existingMod != null) {
				existingMod.merge(mod)
			} else {
				mods.add(mod)
			}
		}

		// Replace lore
		lore?.clear()
		if (lore == null) {
			lore = other.lore
		} else {
			lore?.addAll(other.lore ?: emptyList())
		}
	}

	companion object {

		fun fromJsonString(json: String): CachedItem {
			val gson: Gson = GsonBuilder().create()
			return gson.fromJson(json, CachedItem::class.java)
		}

		fun listToJsonString(items: List<CachedItem>): String {
			val builder = GsonBuilder()
			builder.setPrettyPrinting()
			val gson: Gson = builder.create()
			return gson.toJson(items)
		}

		fun listFromJsonString(json: String): List<CachedItem> {
			val builder = GsonBuilder()
			val gson: Gson = builder.create()
			val type = object : TypeToken<List<CachedItem>>() {}.type
			return gson.fromJson(json, type)
		}

	}

}