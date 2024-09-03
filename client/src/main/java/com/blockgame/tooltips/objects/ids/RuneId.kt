package com.blockgame.tooltips.objects.ids

import net.minecraft.text.Text
import net.minecraft.util.Formatting

enum class RuneId(
	val runeName: String,
	val color: Formatting,
) {
	RUNECARVING_OFFENSE_5("ᚱ Violence - Rank 5", Formatting.GOLD),
	RUNECARVING_OFFENSE_4("ᚱ Violence - Rank 4", Formatting.DARK_RED),
	RUNECARVING_OFFENSE_3("ᚱ Violence - Rank 3", Formatting.DARK_PURPLE),
	RUNECARVING_OFFENSE_2("ᚱ Violence - Rank 2", Formatting.AQUA),
	RUNECARVING_OFFENSE_1("ᚱ Violence - Rank 1", Formatting.GREEN),
	RUNECARVING_DEFENSE_5("ᚱ Serenity - Rank 5", Formatting.GOLD),
	RUNECARVING_DEFENSE_4("ᚱ Serenity - Rank 4", Formatting.DARK_RED),
	RUNECARVING_DEFENSE_3("ᚱ Serenity - Rank 3", Formatting.DARK_PURPLE),
	RUNECARVING_DEFENSE_2("ᚱ Serenity - Rank 2", Formatting.AQUA),
	RUNECARVING_DEFENSE_1("ᚱ Serenity - Rank 1", Formatting.GREEN),
	RUNECARVING_EMPOWERED_5("ᚱ Adrenaline - Rank 5", Formatting.GOLD),
	RUNECARVING_EMPOWERED_4("ᚱ Adrenaline - Rank 4", Formatting.DARK_RED),
	RUNECARVING_EMPOWERED_3("ᚱ Bloodrush - Rank 3", Formatting.DARK_PURPLE),
	RUNECARVING_EMPOWERED_2("ᚱ Martyr - Rank 2", Formatting.AQUA),
	RUNECARVING_EMPOWERED_1("ᚱ Bloodrush - Rank 1", Formatting.GREEN),
	RUNECARVING_MUDDLED_5("ᚱ Muddled - Rank 5", Formatting.GOLD),
	RUNECARVING_MUDDLED_4("ᚱ Muddled - Rank 4", Formatting.DARK_RED),
	RUNECARVING_MUDDLED_3("ᚱ Muddled - Rank 3", Formatting.DARK_PURPLE),
	RUNECARVING_MUDDLED_2("ᚱ Muddled - Rank 2", Formatting.AQUA),
	RUNECARVING_MUDDLED_1("ᚱ Muddled - Rank 1", Formatting.GREEN),
	RUNECARVING_PVP_5("ᚱ Murder - Rank 5", Formatting.GOLD),
	RUNECARVING_PVP_4("ᚱ Murder - Rank 4", Formatting.DARK_RED),
	RUNECARVING_PVP_3("ᚱ Murder - Rank 3", Formatting.DARK_PURPLE),
	RUNECARVING_PVP_2("ᚱ Murder - Rank 2", Formatting.AQUA),
	RUNECARVING_PVP_1("ᚱ Murder - Rank 1", Formatting.GREEN),
	RUNECARVING_ADVANCEMENT_5("ᚱ Clarity - Rank 5", Formatting.GOLD),
	RUNECARVING_ADVANCEMENT_4("ᚱ Clarity - Rank 4", Formatting.DARK_RED),
	RUNECARVING_ADVANCEMENT_3("ᚱ Clarity - Rank 3", Formatting.DARK_PURPLE),
	RUNECARVING_ADVANCEMENT_2("ᚱ Clarity - Rank 2", Formatting.AQUA),
	RUNECARVING_ADVANCEMENT_1("ᚱ Clarity - Rank 1", Formatting.GREEN),
	UNKNOWN("Can't recognise that Rune.", Formatting.RED),
	;

	fun getText(): Text {
		return Text.literal(" ").formatted(Formatting.GRAY).append(Text.literal(this.runeName).formatted(this.color))
	}


	companion object {

		fun getById(idStr: String): RuneId {
			return try {
				RuneId.valueOf(idStr.uppercase())
			} catch (e: IllegalArgumentException) {
				UNKNOWN
			}
		}

		fun getByRuneName(runeName: String): RuneId? {
			return entries.firstOrNull { it.runeName == runeName }
				?: entries.firstOrNull { it.runeName.trim() == runeName.trim() }
				?: entries.filter { it.runeName.trim().isNotEmpty() && runeName.trim().isNotEmpty() }.firstOrNull {
//					System.out.println("${it.runeName.trim().substring(1)} == ${runeName.trim().substring(1)}")
					it.runeName.trim().substring(1) == runeName.trim().substring(1)
				}
		}

	}

}