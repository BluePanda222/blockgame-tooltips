package com.blockgame.tooltips.server.playerdata

import com.blockgame.tooltips.common.MinMaxValue

object LegacyParser {

	fun parseLegacyFileContent(string: String) {
		val lines = string.split("\n").filter { it.isNotBlank() }

		// group lines into sections of 7 lines
		val sections = mutableListOf<List<String>>()
		var currentSection = mutableListOf<String>()
		lines.forEach {
			currentSection.add(it)
			if (currentSection.size == 7) {
				sections.add(currentSection)
				currentSection = mutableListOf()
			}
		}

/*
LoggedItem(
	id: SPARKING_SILK_BOOTS,
	loreRawStringLines: [],
	statsToMinMaxValues: {MMOITEMS_PVP_DAMAGE_REDUCTION=MinMaxValue(min=1.8989996645960432, max=1.8989996645960432), MMOITEMS_PVE_DAMAGE_REDUCTION=MinMaxValue(min=1.5814498168561524, max=1.5814498168561524), MMOITEMS_DAMAGE_REDUCTION=MinMaxValue(min=-5.104731332145889, max=-5.104731332145889), MMOITEMS_MAGIC_DAMAGE=MinMaxValue(min=2.0365433552624497, max=2.0365433552624497), MMOITEMS_CRITICAL_STRIKE_POWER=MinMaxValue(min=10.377838184523965, max=10.377838184523965), MMOITEMS_DEFENSE=MinMaxValue(min=3.7991822793124266, max=3.7991822793124266)},
	historyStatsToMinMaxValues: {d8c5bc32-4b29-45a6-a222-a57225c8256e-MOD=(PVE_DAMAGE_REDUCTION, MinMaxValue(min=1.5814498168561524, max=1.5814498168561524))},
	abilities: []
)
LoggedItem(
	id: DJEDI_CHESTPLATE,
	loreRawStringLines: [],
	statsToMinMaxValues: {},
	historyStatsToMinMaxValues: {},
	abilities: []
)
LoggedItem(
	id: ACOLYTE_BOOTS,
	loreRawStringLines: [],
	statsToMinMaxValues: {MMOITEMS_PROJECTILE_DAMAGE=MinMaxValue(min=3.0548939806292674, max=3.248785198890023), MMOITEMS_DAMAGE_REDUCTION=MinMaxValue(min=-4.9131279321438655, max=-4.552416855986231), MMOITEMS_PVP_DAMAGE=MinMaxValue(min=5.5, max=5.5), MMOITEMS_THAUMATURGY_DAMAGE=MinMaxValue(min=2.751456144950766, max=7.4610107092768585), MMOITEMS_WEAPON_DAMAGE=MinMaxValue(min=3.114529871087662, max=10.197034324589692), MMOITEMS_MAGIC_DAMAGE=MinMaxValue(min=6.036644170247616, max=13.398760779402302), MMOITEMS_DEFENSE=MinMaxValue(min=5.855136350994187, max=8.99075363560196), MMOITEMS_CRITICAL_STRIKE_POWER=MinMaxValue(min=13.949294909567326, max=15.47890242770289), MMOITEMS_PVE_DAMAGE_REDUCTION=MinMaxValue(min=2.25, max=2.25), MMOITEMS_CRITICAL_STRIKE_CHANCE=MinMaxValue(min=3.6271452342151407, max=3.887322521267232), MMOITEMS_MOVEMENT_SPEED=MinMaxValue(min=0.00277828671864992, max=0.00277828671864992)},
	historyStatsToMinMaxValues: {4272d7d2-d42d-4268-925b-d2757882424f-MOD=(CRITICAL_STRIKE_POWER, MinMaxValue(min=15.47890242770289, max=15.47890242770289)), 8407a4ee-5c55-4335-a294-5fd34ebdab8b-MOD=(THAUMATURGY_DAMAGE, MinMaxValue(min=2.751456144950766, max=2.751456144950766)), c87e59b0-30fd-44cf-925c-d642f4211d57-MOD=(PVE_DAMAGE_REDUCTION, MinMaxValue(min=2.25, max=2.25)), 5e25e0d8-735e-4288-b229-bdd1e822f7a8-MOD=(THAUMATURGY_DAMAGE, MinMaxValue(min=3.070407412711292, max=3.070407412711292)), 27de6cf6-7e8a-436f-969b-42214f6ee0cc-MOD=(MOVEMENT_SPEED, MinMaxValue(min=0.00277828671864992, max=0.00277828671864992))},
	abilities: []
)
LoggedItem(
	id: QUIVER_TACKY,
	loreRawStringLines: [],
	statsToMinMaxValues: {MMOITEMS_ADDITIONAL_EXPERIENCE=MinMaxValue(min=16.7773, max=16.7773), MMOITEMS_ADDITIONAL_EXPERIENCE_FISHING=MinMaxValue(min=8.5726, max=8.5726), MMOITEMS_SKILL_ARCHAEOLOGY=MinMaxValue(min=1.0, max=1.0), MMOITEMS_ADDITIONAL_EXPERIENCE_ARCHAEOLOGY=MinMaxValue(min=8.1383, max=8.1383), MMOITEMS_ADDITIONAL_EXPERIENCE_MINING=MinMaxValue(min=8.0868, max=8.0868), MMOITEMS_SKILL_MINING=MinMaxValue(min=1.0, max=1.0), MMOITEMS_ADDITIONAL_EXPERIENCE_RUNECARVING=MinMaxValue(min=7.8805, max=7.8805), MMOITEMS_SKILL_LOGGING=MinMaxValue(min=1.0, max=1.0), MMOITEMS_ADDITIONAL_EXPERIENCE_HERBALISM=MinMaxValue(min=16.4593, max=16.4593)},
	historyStatsToMinMaxValues: {RUNECARVING_ADVANCEMENT_5=(ADDITIONAL_EXPERIENCE_HERBALISM, MinMaxValue(min=7.9344, max=7.9344))},
	abilities: [LoggedAbility(id=SLOW, castMode=ARROW_HIT, modifiersToMinMaxValues={duration=MinMaxValue(min=4.0, max=4.0), cooldown=MinMaxValue(min=0.0, max=0.0), amplifier=MinMaxValue(min=1.0, max=1.0)})]
)
*/

		// parse each section
		sections.forEach { section ->
			val id = section[1].substringAfter("id: ").substringBefore(",")

			var statsToMinMaxValues: Map<String, MinMaxValue> = mutableMapOf()
			if (section[3].substringAfter("statsToMinMaxValues: {").substringBefore("}") != "") {
				val str = section[3].substringAfter("statsToMinMaxValues: {").substringBefore("},")
				statsToMinMaxValues = str.split("), ").associate {
					val key = it.substringBefore("=").replace("MMOITEMS_", "")
					val min = it.substringAfter("min=").substringBefore(",").toDouble()
					val max = it.substringAfter("max=").replace(")", "").toDouble()
					key to MinMaxValue(min, max)
				}
			}

			var historyStatsToMinMaxValues: Map<String, Map<String, MinMaxValue>> = mutableMapOf()
			if (section[4].substringAfter("historyStatsToMinMaxValues: {").substringBefore("}") != "") {
				val str = section[4].substringAfter("historyStatsToMinMaxValues: {").substringBefore("},")
				historyStatsToMinMaxValues = str.split("), ").associate {
					val key = it.substringBefore("=(")
					val key2 = it.substringAfter("=(").substringBefore(",")
					val min = it.substringAfter("min=").substringBefore(",").toDouble()
					val max = it.substringAfter("max=").replace(")", "").toDouble()
					key to mapOf(key2 to MinMaxValue(min, max))
				}
			}

			// abilities: [LoggedAbility(id=SLOW, castMode=ARROW_HIT, modifiersToMinMaxValues={duration=MinMaxValue(min=4.0, max=4.0), cooldown=MinMaxValue(min=0.0, max=0.0), amplifier=MinMaxValue(min=1.0, max=1.0)})]
			var abilities: MutableList<Ability> = mutableListOf()
			if (section[5].substringAfter("abilities: [").substringBefore("]") != "") {
				val str = section[5].substringAfter("abilities: [").substringBefore("]")
				abilities = str.split("}), ").map {
					val id = it.substringAfter("id=").substringBefore(",")
					val castMode = it.substringAfter("castMode=").substringBefore(",")
					val modifiersToMinMaxValues = it.substringAfter("modifiersToMinMaxValues={").substringBefore("}").split("), ").associate {
						val key = it.substringBefore("=")
						val min = it.substringAfter("min=").substringBefore(",").toDouble()
						val max = it.substringAfter("max=").replace(")", "").replace("}", "").toDouble()
						key to MinMaxValue(min, max)
					}
					Ability(id, castMode, modifiersToMinMaxValues)
				}.toMutableList()
			}

			if (abilities.isNotEmpty()) {
				println("id: $id")
			}
//			println("id: $id")
//			statsToMinMaxValues.forEach { (key, value) ->
//				println("$key: $value")
//			}
//			historyStatsToMinMaxValues.forEach { (key, value) ->
//				println("$key: $value")
//			}
			abilities.forEach {
				println(it)
			}
		}

	}

	data class Ability(val id: String, val castMode: String, val modifiersToMinMaxValues: Map<String, MinMaxValue>)

}