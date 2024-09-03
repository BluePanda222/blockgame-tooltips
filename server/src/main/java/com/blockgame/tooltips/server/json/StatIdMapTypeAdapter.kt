package com.blockgame.tooltips.server.json

import com.blockgame.tooltips.common.MinMaxValue
import com.blockgame.tooltips.server.objects.StatId
import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter

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
