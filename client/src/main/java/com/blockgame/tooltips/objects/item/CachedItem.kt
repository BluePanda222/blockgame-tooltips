package com.blockgame.tooltips.objects.item

import com.blockgame.tooltips.common.MinMaxValue
import com.blockgame.tooltips.common.interfaces.IAbility
import com.blockgame.tooltips.common.interfaces.ICachedItem
import com.blockgame.tooltips.common.interfaces.IMod
import com.blockgame.tooltips.common.interfaces.IStatId
import com.blockgame.tooltips.objects.ids.AbilityModifierId
import com.blockgame.tooltips.objects.ids.StatId
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.TypeAdapter
import com.google.gson.annotations.JsonAdapter
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter

data class CachedItem(
	override val id: String,
	override val revisionId: Int?,
) : ICachedItem {

	@JsonAdapter(StatIdMapTypeAdapter::class)
	override val stats = mutableMapOf<StatId, MinMaxValue>()
	override val abilities = mutableListOf<Ability>()
	override val mods = mutableListOf<ItemMod>()
	override val lore = mutableListOf<String>()


	fun toJsonString(): String {
		val gson: Gson = GsonBuilder().setPrettyPrinting().create()
		return gson.toJson(this)
	}


	class StatIdMapTypeAdapter : TypeAdapter<Map<StatId, MinMaxValue>>() {
		override fun write(out: JsonWriter, value: Map<StatId, MinMaxValue>?) {
			if (value == null) {
				out.nullValue()
				return
			}
			out.beginObject()
			value.forEach { (statId, minMaxValue) ->
				if (statId == StatId.UNKNOWN) {
					return@forEach
				}
				out.name(statId.name)
				out.beginObject()
				out.name("min").value(minMaxValue.min)
				out.name("max").value(minMaxValue.max)
				out.endObject()
			}
			out.endObject()
		}

		override fun read(`in`: JsonReader): Map<StatId, MinMaxValue> {
			val map = mutableMapOf<StatId, MinMaxValue>()
			`in`.beginObject()
			while (`in`.hasNext()) {
				val statId = StatId.getById(`in`.nextName())
				if (statId == StatId.UNKNOWN) {
					`in`.skipValue()
					continue
				}
				`in`.beginObject()
				val min = `in`.nextName()
				val minValue = `in`.nextDouble()
				val max = `in`.nextName()
				val maxValue = `in`.nextDouble()
				`in`.endObject()
				map[statId] = MinMaxValue(minValue, maxValue)
			}
			`in`.endObject()
			return map
		}
	}


	companion object {

		fun fromJsonString(json: String): CachedItem {
			val gson: Gson = GsonBuilder().create()
			return gson.fromJson(json, CachedItem::class.java)
		}

		fun listToJsonString(items: List<CachedItem>): String {
			val builder = GsonBuilder()
//			builder.registerTypeAdapter(AbilityModifierId::class.java, AbilityModifierId.Serializer())
			builder.setPrettyPrinting()
			val gson: Gson = builder.create()
			return gson.toJson(items)
		}

		fun listFromJsonString(json: String): List<CachedItem> {
			val builder = GsonBuilder()
//			builder.registerTypeAdapter(AbilityModifierId::class.java, AbilityModifierId.Serializer())
			val gson: Gson = builder.create()
			val type = object : TypeToken<List<CachedItem>>() {}.type
			return gson.fromJson(json, type)
		}

	}

}