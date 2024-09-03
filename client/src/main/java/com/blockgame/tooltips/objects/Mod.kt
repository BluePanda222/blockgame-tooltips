package com.blockgame.tooltips.objects

import net.minecraft.text.Text

data class Mod(
	var displayName: String, // RUNECARVING_OFFENSE_5 // §dCorrupted
	var historyUuid: String // be289e2d-5c8c-4027-9b93-6dc0e5d2c046
) {

	var stats: ArrayList<Stat> = ArrayList()

	val displayNameStripped
		get() = this.displayName
			.replace("[", "")
			.replace("]", "")
			.replace("\"", "")

	fun getText(): Text {
		val txt = this.displayName
			.replace("[", "")
			.replace("]", "")
			.replace("\"", "")
		return Text.literal(" ").append(Text.literal(txt.replace("&", "§")))
	}

}