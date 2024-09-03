package com.blockgame.tooltips.server.json

import com.blockgame.tooltips.common.MinMaxValue
import com.blockgame.tooltips.server.objects.AbilityModifierId
import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter

class AbilityModifierMapTypeAdapter : TypeAdapter<Map<AbilityModifierId, MinMaxValue>>() {
	override fun write(out: JsonWriter, value: Map<AbilityModifierId, MinMaxValue>?) {
		if (value == null) {
			out.nullValue()
			return
		}
		out.beginObject()
		value.forEach { (abilityModifierId, minMaxValue) ->
			out.name(abilityModifierId.name)
			out.beginObject()
			out.name("min").value(minMaxValue.min)
			out.name("max").value(minMaxValue.max)
			out.endObject()
		}
		out.endObject()
	}
	override fun read(`in`: JsonReader): Map<AbilityModifierId, MinMaxValue> {
		val map = mutableMapOf<AbilityModifierId, MinMaxValue>()
		`in`.beginObject()
		while (`in`.hasNext()) {
			val abilityModifierId = AbilityModifierId.getById(`in`.nextName())
			if (abilityModifierId == null) {
				`in`.skipValue()
				continue
			}
			`in`.beginObject()
			val min = `in`.nextName()
			val minValue = `in`.nextDouble()
			val max = `in`.nextName()
			val maxValue = `in`.nextDouble()
			`in`.endObject()
			map[abilityModifierId] = MinMaxValue(minValue, maxValue)
		}
		`in`.endObject()
		return map
	}
}
