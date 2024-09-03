package com.blockgame.tooltips.objects.item

import com.blockgame.tooltips.common.MinMaxValue
import com.blockgame.tooltips.common.interfaces.IAbility
import com.blockgame.tooltips.objects.ids.AbilityModifierId
import com.google.gson.TypeAdapter
import com.google.gson.annotations.JsonAdapter
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter

data class Ability(
	override val id: String, // CORRUPTION
	override val displayName: String, // Corruption
	override val castMode: String, // RIGHT_CLICK
) : IAbility {

	@JsonAdapter(AbilityModifierMapTypeAdapter::class)
	override val abilityModifiers = mutableMapOf<AbilityModifierId, MinMaxValue>()

	constructor(
		id: String,
		displayName: String,
		castMode: String,
		modifiersToMinMaxValues: MutableMap<com.blockgame.tooltips.objects.deprecated.AbilityModifierId, MinMaxValue>,
	) : this(id, displayName, castMode) {
		modifiersToMinMaxValues.forEach { (legacyStatId, minMaxValue) ->
			val statId = AbilityModifierId.getById(legacyStatId.name)
				?: return@forEach
			this.abilityModifiers[statId] = minMaxValue
		}
	}


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

	override fun toString(): String {
		return "Ability(id='$id', displayName='$displayName', castMode='$castMode', modifiers=${abilityModifiers})"
	}

}