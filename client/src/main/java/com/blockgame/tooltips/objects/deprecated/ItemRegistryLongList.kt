package com.blockgame.tooltips.objects.deprecated

import com.blockgame.tooltips.common.MinMaxValue
import com.blockgame.tooltips.objects.item.Ability
import com.blockgame.tooltips.objects.item.Item
import com.blockgame.tooltips.objects.item.ItemMod

@Deprecated("Marked for removal")
object ItemRegistryLongList {

	val itemList = mutableListOf<Item>(


		// TODO - this is a test item
		Item("T4_RANDOM_MACE", mutableMapOf(
			StatId.BLOCK_COOLDOWN_REDUCTION to MinMaxValue(9.0, 11.0),
			StatId.HEALTH_REGENERATION to MinMaxValue(0.2, 0.22), // TODO - this is different than the value from the npcs...

			StatId.ATTACK_DAMAGE to MinMaxValue(15.3, 18.7),
			StatId.ATTACK_SPEED to MinMaxValue(1.0, 1.0),
			StatId.BLUNT_POWER to MinMaxValue(1.8, 2.2),
			StatId.BLUNT_RATING to MinMaxValue(27.0, 33.0),
		), listOf(
			Ability("ROCK_AND_AWE", "Rock And Awe", "RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.DAMAGE to MinMaxValue(18.0, 22.0),
				AbilityModifierId.SLOW_DURATION to MinMaxValue(4.0, 6.0),
				AbilityModifierId.COOLDOWN to MinMaxValue(18.0, 22.0),
				AbilityModifierId.RADIUS to MinMaxValue(4.0, 6.0),
			)),
		), listOf(
			ItemMod("&dCorrupted", mutableMapOf(
				StatId.DAMAGE_REDUCTION to MinMaxValue(-2.0, -5.1),
				StatId.PVE_DAMAGE_REDUCTION to MinMaxValue(3.0, 4.0),
				StatId.PVP_DAMAGE to MinMaxValue(5.0, 7.0),
			)),
			ItemMod("&6Scalding", mutableMapOf(
				StatId.ATTACK_DAMAGE to MinMaxValue(2.0, 4.0),
			)),
		)),


		Item("RUNECARVING_DEFENSE_1", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(0.55, 0.67),
			StatId.FALL_DAMAGE_REDUCTION to MinMaxValue(0.45, 0.55),
			StatId.PVE_DAMAGE_REDUCTION to MinMaxValue(0.50, 0.61),
			StatId.BLOCK_POWER to MinMaxValue(0.35, 0.43),
			StatId.BLOCK_RATING to MinMaxValue(0.35, 0.43),
			StatId.BLOCK_COOLDOWN_REDUCTION to MinMaxValue(0.10, 0.12),
			StatId.MAX_HEALTH to MinMaxValue(0.70, 0.86),
			StatId.KNOCKBACK_RESISTANCE to MinMaxValue(0.90, 1.10),
		)),
		Item("RUNECARVING_DEFENSE_2", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(1.1, 1.34),
			StatId.FALL_DAMAGE_REDUCTION to MinMaxValue(0.9, 1.1),
			StatId.PVE_DAMAGE_REDUCTION to MinMaxValue(1.0, 1.22),
			StatId.BLOCK_POWER to MinMaxValue(0.7, 0.86),
			StatId.BLOCK_RATING to MinMaxValue(0.7, 0.86),
			StatId.BLOCK_COOLDOWN_REDUCTION to MinMaxValue(0.2, 0.24),
			StatId.MAX_HEALTH to MinMaxValue(1.4, 1.71),
			StatId.KNOCKBACK_RESISTANCE to MinMaxValue(1.8, 2.2),
		)),
		Item("RUNECARVING_DEFENSE_3", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(1.65, 2.02),
			StatId.FALL_DAMAGE_REDUCTION to MinMaxValue(1.35, 1.65),
			StatId.PVE_DAMAGE_REDUCTION to MinMaxValue(1.5, 1.83),
			StatId.BLOCK_POWER to MinMaxValue(1.05, 1.28),
			StatId.BLOCK_RATING to MinMaxValue(1.05, 1.28),
			StatId.BLOCK_COOLDOWN_REDUCTION to MinMaxValue(0.3, 0.37),
			StatId.MAX_HEALTH to MinMaxValue(2.1, 2.57),
			StatId.KNOCKBACK_RESISTANCE to MinMaxValue(2.7, 3.3),
		)),
		Item("RUNECARVING_DEFENSE_4", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(2.2, 2.69),
			StatId.FALL_DAMAGE_REDUCTION to MinMaxValue(1.8, 2.2),
			StatId.PVE_DAMAGE_REDUCTION to MinMaxValue(2.0, 2.44),
			StatId.BLOCK_POWER to MinMaxValue(1.4, 1.71),
			StatId.BLOCK_RATING to MinMaxValue(1.4, 1.71),
			StatId.BLOCK_COOLDOWN_REDUCTION to MinMaxValue(0.4, 0.49),
			StatId.MAX_HEALTH to MinMaxValue(2.8, 3.42),
			StatId.KNOCKBACK_RESISTANCE to MinMaxValue(3.6, 4.4),
		)),
		Item("RUNECARVING_DEFENSE_5", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(2.75, 3.36), // 3.3508316625383845 // TODO - rn something is wrong with that. // Tooltip says 3.4
			StatId.FALL_DAMAGE_REDUCTION to MinMaxValue(2.25, 2.75),
			StatId.PVE_DAMAGE_REDUCTION to MinMaxValue(2.5, 3.06),
			StatId.BLOCK_POWER to MinMaxValue(1.75, 2.14),
			StatId.BLOCK_RATING to MinMaxValue(1.75, 2.14),
			StatId.BLOCK_COOLDOWN_REDUCTION to MinMaxValue(0.5, 0.61),
			StatId.MAX_HEALTH to MinMaxValue(3.5, 4.28),
			StatId.KNOCKBACK_RESISTANCE to MinMaxValue(4.5, 5.5),
		)),
		Item("RUNECARVING_OFFENSE_1", mutableMapOf(
			StatId.CRITICAL_STRIKE_CHANCE to MinMaxValue(0.25, 0.31),
			StatId.CRITICAL_STRIKE_POWER to MinMaxValue(0.98, 1.19),
			StatId.BLUNT_POWER to MinMaxValue(0.015, 0.018),
			StatId.BLUNT_RATING to MinMaxValue(0.3, 0.37),
			StatId.PVE_DAMAGE to MinMaxValue(0.5, 0.61),
			StatId.WEAPON_DAMAGE to MinMaxValue(1.25, 1.53),
			StatId.MAGIC_DAMAGE to MinMaxValue(1.25, 1.53),
			StatId.THAUMATURGY_DAMAGE to MinMaxValue(1.25, 1.53),
			StatId.PROJECTILE_DAMAGE to MinMaxValue(1.25, 1.53),
			StatId.COOLDOWN_REDUCTION to MinMaxValue(0.18, 0.21),
			StatId.MOVEMENT_SPEED to MinMaxValue(0.1, 0.12),
		)),
		Item("RUNECARVING_OFFENSE_2", mutableMapOf(
			StatId.CRITICAL_STRIKE_CHANCE to MinMaxValue(0.5, 0.61),
			StatId.CRITICAL_STRIKE_POWER to MinMaxValue(1.95, 2.38),
			StatId.BLUNT_POWER to MinMaxValue(0.03, 0.037),
			StatId.BLUNT_RATING to MinMaxValue(0.6, 0.73),
			StatId.PVE_DAMAGE to MinMaxValue(1.0, 1.22),
			StatId.WEAPON_DAMAGE to MinMaxValue(2.5, 3.06),
			StatId.MAGIC_DAMAGE to MinMaxValue(2.5, 3.06),
			StatId.THAUMATURGY_DAMAGE to MinMaxValue(2.5, 3.06),
			StatId.PROJECTILE_DAMAGE to MinMaxValue(2.5, 3.06),
			StatId.COOLDOWN_REDUCTION to MinMaxValue(0.35, 0.43),
			StatId.MOVEMENT_SPEED to MinMaxValue(0.2, 0.24),
		)),
		Item("RUNECARVING_OFFENSE_3", mutableMapOf(
			StatId.CRITICAL_STRIKE_CHANCE to MinMaxValue(0.75, 0.92),
			StatId.CRITICAL_STRIKE_POWER to MinMaxValue(2.93, 3.58),
			StatId.BLUNT_POWER to MinMaxValue(0.045, 0.055),
			StatId.BLUNT_RATING to MinMaxValue(0.9, 1.1),
			StatId.PVE_DAMAGE to MinMaxValue(1.5, 1.83),
			StatId.WEAPON_DAMAGE to MinMaxValue(3.75, 4.58),
			StatId.MAGIC_DAMAGE to MinMaxValue(3.75, 4.58),
			StatId.THAUMATURGY_DAMAGE to MinMaxValue(3.75, 4.58),
			StatId.PROJECTILE_DAMAGE to MinMaxValue(3.75, 4.58),
			StatId.COOLDOWN_REDUCTION to MinMaxValue(0.53, 0.64),
			StatId.MOVEMENT_SPEED to MinMaxValue(0.3, 0.37),
		)),
		Item("RUNECARVING_OFFENSE_4", mutableMapOf(
			StatId.CRITICAL_STRIKE_CHANCE to MinMaxValue(1.0, 1.22),
			StatId.CRITICAL_STRIKE_POWER to MinMaxValue(3.9, 4.77),
			StatId.BLUNT_POWER to MinMaxValue(0.06, 0.073),
			StatId.BLUNT_RATING to MinMaxValue(1.2, 1.47),
			StatId.PVE_DAMAGE to MinMaxValue(2.0, 2.44),
			StatId.WEAPON_DAMAGE to MinMaxValue(5.0, 6.11),
			StatId.MAGIC_DAMAGE to MinMaxValue(5.0, 6.11),
			StatId.THAUMATURGY_DAMAGE to MinMaxValue(5.0, 6.11),
			StatId.PROJECTILE_DAMAGE to MinMaxValue(5.0, 6.11),
			StatId.COOLDOWN_REDUCTION to MinMaxValue(0.7, 0.86),
			StatId.MOVEMENT_SPEED to MinMaxValue(0.4, 0.49),
		)),
		Item("RUNECARVING_OFFENSE_5", mutableMapOf(
			StatId.CRITICAL_STRIKE_CHANCE to MinMaxValue(1.25, 1.53),
			StatId.CRITICAL_STRIKE_POWER to MinMaxValue(4.88, 5.96),
			StatId.BLUNT_POWER to MinMaxValue(0.075, 0.092),
			StatId.BLUNT_RATING to MinMaxValue(1.5, 1.83),
			StatId.PVE_DAMAGE to MinMaxValue(2.5, 3.06),
			StatId.WEAPON_DAMAGE to MinMaxValue(6.25, 7.64),
			StatId.MAGIC_DAMAGE to MinMaxValue(6.25, 7.64),
			StatId.THAUMATURGY_DAMAGE to MinMaxValue(6.25, 7.64),
			StatId.PROJECTILE_DAMAGE to MinMaxValue(6.25, 7.64),
			StatId.COOLDOWN_REDUCTION to MinMaxValue(0.88, 1.07),
			StatId.MOVEMENT_SPEED to MinMaxValue(0.5, 0.616),
		)),
		Item("RUNECARVING_ADVANCEMENT_1", mutableMapOf(
			StatId.ADDITIONAL_EXPERIENCE to MinMaxValue(1.5, 1.83),
			StatId.ADDITIONAL_EXPERIENCE_HERBALISM to MinMaxValue(1.5, 1.83),
			StatId.ADDITIONAL_EXPERIENCE_ARCHAEOLOGY to MinMaxValue(1.5, 1.83),
			StatId.ADDITIONAL_EXPERIENCE_LOGGING to MinMaxValue(1.5, 1.83),
			StatId.ADDITIONAL_EXPERIENCE_FISHING to MinMaxValue(1.5, 1.83),
			StatId.ADDITIONAL_EXPERIENCE_RUNECARVING to MinMaxValue(1.5, 1.83),
			StatId.ADDITIONAL_EXPERIENCE_MINING to MinMaxValue(1.5, 1.83),
			StatId.ADDITIONAL_EXPERIENCE_COOKING to MinMaxValue(1.5, 1.83),
		)),
		Item("RUNECARVING_ADVANCEMENT_2", mutableMapOf(
			StatId.ADDITIONAL_EXPERIENCE to MinMaxValue(3.0, 3.67),
			StatId.ADDITIONAL_EXPERIENCE_HERBALISM to MinMaxValue(3.0, 3.67),
			StatId.ADDITIONAL_EXPERIENCE_ARCHAEOLOGY to MinMaxValue(3.0, 3.67),
			StatId.ADDITIONAL_EXPERIENCE_LOGGING to MinMaxValue(3.0, 3.67),
			StatId.ADDITIONAL_EXPERIENCE_FISHING to MinMaxValue(3.0, 3.67),
			StatId.ADDITIONAL_EXPERIENCE_RUNECARVING to MinMaxValue(3.0, 3.67),
			StatId.ADDITIONAL_EXPERIENCE_MINING to MinMaxValue(3.0, 3.67),
			StatId.ADDITIONAL_EXPERIENCE_COOKING to MinMaxValue(3.0, 3.67),
		)),
		Item("RUNECARVING_ADVANCEMENT_3", mutableMapOf(
			StatId.ADDITIONAL_EXPERIENCE to MinMaxValue(4.5, 5.5),
			StatId.ADDITIONAL_EXPERIENCE_HERBALISM to MinMaxValue(4.5, 5.5),
			StatId.ADDITIONAL_EXPERIENCE_ARCHAEOLOGY to MinMaxValue(4.5, 5.5),
			StatId.ADDITIONAL_EXPERIENCE_LOGGING to MinMaxValue(4.5, 5.5),
			StatId.ADDITIONAL_EXPERIENCE_FISHING to MinMaxValue(4.5, 5.5),
			StatId.ADDITIONAL_EXPERIENCE_RUNECARVING to MinMaxValue(4.5, 5.5),
			StatId.ADDITIONAL_EXPERIENCE_MINING to MinMaxValue(4.5, 5.5),
			StatId.ADDITIONAL_EXPERIENCE_COOKING to MinMaxValue(4.5, 5.5),
		)),
		Item("RUNECARVING_ADVANCEMENT_4", mutableMapOf(
			StatId.ADDITIONAL_EXPERIENCE to MinMaxValue(6.0, 7.33),
			StatId.ADDITIONAL_EXPERIENCE_HERBALISM to MinMaxValue(6.0, 7.33),
			StatId.ADDITIONAL_EXPERIENCE_ARCHAEOLOGY to MinMaxValue(6.0, 7.33),
			StatId.ADDITIONAL_EXPERIENCE_LOGGING to MinMaxValue(6.0, 7.33),
			StatId.ADDITIONAL_EXPERIENCE_FISHING to MinMaxValue(6.0, 7.33),
			StatId.ADDITIONAL_EXPERIENCE_RUNECARVING to MinMaxValue(6.0, 7.33),
			StatId.ADDITIONAL_EXPERIENCE_MINING to MinMaxValue(6.0, 7.33),
			StatId.ADDITIONAL_EXPERIENCE_COOKING to MinMaxValue(6.0, 7.33),
		)),
		Item("RUNECARVING_ADVANCEMENT_5", mutableMapOf(
			StatId.ADDITIONAL_EXPERIENCE to MinMaxValue(7.5, 9.17),
			StatId.ADDITIONAL_EXPERIENCE_HERBALISM to MinMaxValue(7.5, 9.17),
			StatId.ADDITIONAL_EXPERIENCE_ARCHAEOLOGY to MinMaxValue(7.5, 9.17),
			StatId.ADDITIONAL_EXPERIENCE_LOGGING to MinMaxValue(7.5, 9.17),
			StatId.ADDITIONAL_EXPERIENCE_FISHING to MinMaxValue(7.5, 9.17),
			StatId.ADDITIONAL_EXPERIENCE_RUNECARVING to MinMaxValue(7.5, 9.17),
			StatId.ADDITIONAL_EXPERIENCE_MINING to MinMaxValue(7.5, 9.17),
			StatId.ADDITIONAL_EXPERIENCE_COOKING to MinMaxValue(7.5, 9.17),
		)),



		Item("WOODEN_HELMET", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(7.2, 8.8),
			StatId.MAX_HEALTH to MinMaxValue(1.8, 2.2),
			StatId.HEALING_RECEIVED to MinMaxValue(0.9, 1.1),
		)),
		Item("WOODEN_CHESTPLATE", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(12.6, 15.4),
			StatId.MAX_HEALTH to MinMaxValue(1.8, 2.2),
			StatId.HEALING_RECEIVED to MinMaxValue(0.9, 1.1),
		)),
		Item("WOODEN_LEGGINGS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(10.8, 13.2),
			StatId.MAX_HEALTH to MinMaxValue(1.8, 2.2),
			StatId.HEALING_RECEIVED to MinMaxValue(0.9, 1.1),
		)),
		Item("WOODEN_BOOTS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(7.2, 8.8),
			StatId.MAX_HEALTH to MinMaxValue(1.8, 2.2),
			StatId.HEALING_RECEIVED to MinMaxValue(0.9, 1.1),
		)),
		Item("WOODEN_SHIELD", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(5.4, 6.6),
			StatId.BLOCK_POWER to MinMaxValue(11.25, 13.8),
			StatId.BLOCK_RATING to MinMaxValue(11.25, 13.8),
			StatId.MAX_HEALTH to MinMaxValue(4.5, 5.5),
		)),
		Item("WOODEN_MACE", mutableMapOf(
			StatId.BLOCK_COOLDOWN_REDUCTION to MinMaxValue(2.2, 2.8),
			StatId.HEALTH_REGENERATION to MinMaxValue(0.0, 0.1),

			StatId.ATTACK_DAMAGE to MinMaxValue(7.2, 8.8),
			StatId.ATTACK_SPEED to MinMaxValue(1.0, 1.0),
			StatId.BLUNT_POWER to MinMaxValue(1.8, 2.2),
			StatId.BLUNT_RATING to MinMaxValue(27.0, 33.0),
		)),

		Item("COPPER_HELMET", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(14.4, 17.6),
			StatId.MAX_HEALTH to MinMaxValue(3.6, 4.4),
			StatId.HEALING_RECEIVED to MinMaxValue(1.8, 2.2),
		)),
		Item("COPPER_CHESTPLATE", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(25.2, 30.8),
			StatId.MAX_HEALTH to MinMaxValue(3.6, 4.4),
			StatId.HEALING_RECEIVED to MinMaxValue(1.8, 2.2),
		)),
		Item("COPPER_LEGGINGS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(21.6, 26.4),
			StatId.MAX_HEALTH to MinMaxValue(3.6, 4.4),
			StatId.HEALING_RECEIVED to MinMaxValue(1.8, 2.2),
		)),
		Item("COPPER_BOOTS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(14.4, 17.6),
			StatId.MAX_HEALTH to MinMaxValue(3.6, 4.4),
			StatId.HEALING_RECEIVED to MinMaxValue(1.8, 2.2),
		)),
		Item("COPPER_SHIELD", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(10.8, 13.2),
			StatId.BLOCK_POWER to MinMaxValue(13.5, 16.5),
			StatId.BLOCK_RATING to MinMaxValue(13.5, 16.5),
			StatId.MAX_HEALTH to MinMaxValue(9.0, 11.0),
		)),
		Item("COPPER_MACE", mutableMapOf(
			StatId.BLOCK_COOLDOWN_REDUCTION to MinMaxValue(4.5, 5.5),
			StatId.HEALTH_REGENERATION to MinMaxValue(0.1, 0.1),

			StatId.ATTACK_DAMAGE to MinMaxValue(9.9, 12.1),
			StatId.ATTACK_SPEED to MinMaxValue(1.0, 1.0),
			StatId.BLUNT_POWER to MinMaxValue(1.8, 2.2),
			StatId.BLUNT_RATING to MinMaxValue(27.0, 33.0),
		)),

		Item("STEEL_HELMET", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(21.6, 26.4),
			StatId.MAX_HEALTH to MinMaxValue(5.4, 6.6),
			StatId.HEALING_RECEIVED to MinMaxValue(2.7, 3.3),
		)),
		Item("STEEL_CHESTPLATE", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(37.8, 46.2),
			StatId.MAX_HEALTH to MinMaxValue(5.4, 6.6),
			StatId.HEALING_RECEIVED to MinMaxValue(2.7, 3.3),
		)),
		Item("STEEL_LEGGINGS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(32.4, 39.6),
			StatId.MAX_HEALTH to MinMaxValue(5.4, 6.6),
			StatId.HEALING_RECEIVED to MinMaxValue(2.7, 3.3),
		)),
		Item("STEEL_BOOTS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(21.6, 26.4),
			StatId.MAX_HEALTH to MinMaxValue(5.4, 6.6),
			StatId.HEALING_RECEIVED to MinMaxValue(2.7, 3.3),
		)),
		Item("BONE_SHIELD", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(16.2, 19.8),
			StatId.BLOCK_POWER to MinMaxValue(15.8, 19.2),
			StatId.BLOCK_RATING to MinMaxValue(15.8, 19.2),
			StatId.MAX_HEALTH to MinMaxValue(13.5, 16.5),
		)),
		Item("UNSETTLING_MACE", mutableMapOf(
			StatId.BLOCK_COOLDOWN_REDUCTION to MinMaxValue(6.8, 8.2),
			StatId.HEALTH_REGENERATION to MinMaxValue(0.1, 0.2),

			StatId.ATTACK_DAMAGE to MinMaxValue(12.6, 15.4),
			StatId.ATTACK_SPEED to MinMaxValue(1.0, 1.0),
			StatId.BLUNT_POWER to MinMaxValue(1.8, 2.2),
			StatId.BLUNT_RATING to MinMaxValue(27.0, 33.0),
		)),

		Item("BLOODSNOUT_BRUTE_HELMET", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(28.8, 35.2),
			StatId.MAX_HEALTH to MinMaxValue(7.2, 8.8),
			StatId.HEALING_RECEIVED to MinMaxValue(3.6, 4.4),
		)),
		Item("BLOODSNOUT_BRUTE_CHESTPLATE", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(50.4, 61.6),
			StatId.MAX_HEALTH to MinMaxValue(7.2, 8.8),
			StatId.HEALING_RECEIVED to MinMaxValue(3.6, 4.4),
		)),
		Item("BLOODSNOUT_BRUTE_LEGGINGS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(43.2, 52.8),
			StatId.MAX_HEALTH to MinMaxValue(7.2, 8.8),
			StatId.HEALING_RECEIVED to MinMaxValue(3.6, 4.4),
		)),
		Item("BLOODSNOUT_BRUTE_BOOTS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(28.8, 35.2),
			StatId.MAX_HEALTH to MinMaxValue(7.2, 8.8),
			StatId.HEALING_RECEIVED to MinMaxValue(3.6, 4.4),
		)),
		Item("BLOODSNOUT_SHIELD", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(21.6, 26.4),
			StatId.BLOCK_POWER to MinMaxValue(18.0, 22.0),
			StatId.BLOCK_RATING to MinMaxValue(18.0, 22.0),
			StatId.MAX_HEALTH to MinMaxValue(18.0, 22.0),
		)),
		Item("BLOODSNOUT_MACE", mutableMapOf(
			StatId.BLOCK_COOLDOWN_REDUCTION to MinMaxValue(9.0, 11.0),
			StatId.HEALTH_REGENERATION to MinMaxValue(0.2, 0.22), // TODO - this is different than the value from the npcs...

			StatId.ATTACK_DAMAGE to MinMaxValue(15.3, 18.7),
			StatId.ATTACK_SPEED to MinMaxValue(1.0, 1.0),
			StatId.BLUNT_POWER to MinMaxValue(1.8, 2.2),
			StatId.BLUNT_RATING to MinMaxValue(27.0, 33.0),
		)),

		Item("MAAHES_HELMET", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(36.0, 44.0),
			StatId.MAX_HEALTH to MinMaxValue(9.0, 11.0),
			StatId.HEALING_RECEIVED to MinMaxValue(4.5, 5.5),
		)),
		Item("MAAHES_CHESTPLATE", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(63.0, 77.0),
			StatId.MAX_HEALTH to MinMaxValue(9.0, 11.0),
			StatId.HEALING_RECEIVED to MinMaxValue(4.5, 5.5),
		)),
		Item("MAAHES_LEGGINGS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(54.0, 66.0),
			StatId.MAX_HEALTH to MinMaxValue(9.0, 11.0),
			StatId.HEALING_RECEIVED to MinMaxValue(4.5, 5.5),
		)),
		Item("MAAHES_BOOTS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(36.0, 44.0),
			StatId.MAX_HEALTH to MinMaxValue(9.0, 11.0),
			StatId.HEALING_RECEIVED to MinMaxValue(4.5, 5.5),
		)),
		Item("MAAHES_SHIELD", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(27.0, 33.0),
			StatId.BLOCK_POWER to MinMaxValue(20.2, 24.8),
			StatId.BLOCK_RATING to MinMaxValue(20.2, 24.8),
			StatId.MAX_HEALTH to MinMaxValue(22.5, 27.5),
		)),
		Item("MAAHES_MACE", mutableMapOf(
			StatId.BLOCK_COOLDOWN_REDUCTION to MinMaxValue(11.2, 13.8),
			StatId.HEALTH_REGENERATION to MinMaxValue(0.2, 0.3),

			StatId.ATTACK_DAMAGE to MinMaxValue(18.9, 23.1),
			StatId.ATTACK_SPEED to MinMaxValue(1.0, 1.0),
			StatId.BLUNT_POWER to MinMaxValue(1.8, 2.2),
			StatId.BLUNT_RATING to MinMaxValue(27.0, 33.0),
		)),

		Item("GUARDIAN_HELMET", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(43.2, 52.8),
			StatId.MAX_HEALTH to MinMaxValue(10.8, 13.2),
			StatId.HEALING_RECEIVED to MinMaxValue(5.4, 6.6),
		)),
		Item("GUARDIAN_CHESTPLATE", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(75.6, 92.4),
			StatId.MAX_HEALTH to MinMaxValue(10.8, 13.2),
			StatId.HEALING_RECEIVED to MinMaxValue(5.4, 6.6),
		)),
		Item("GUARDIAN_LEGGINGS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(64.8, 79.2),
			StatId.MAX_HEALTH to MinMaxValue(10.8, 13.2),
			StatId.HEALING_RECEIVED to MinMaxValue(5.4, 6.6),
		)),
		Item("GUARDIAN_BOOTS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(43.2, 52.8),
			StatId.MAX_HEALTH to MinMaxValue(10.8, 13.2),
			StatId.HEALING_RECEIVED to MinMaxValue(5.4, 6.6),
		)),



		Item("CACTUS_HELMET", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(5.4, 6.6),
			StatId.WEAPON_DAMAGE to MinMaxValue(0.9, 1.1),
		)),
		Item("CACTUS_CHESTPLATE", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(10.8, 13.2),
			StatId.WEAPON_DAMAGE to MinMaxValue(0.9, 1.1),
		)),
		Item("CACTUS_LEGGINGS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(9.0, 11.0),
			StatId.WEAPON_DAMAGE to MinMaxValue(0.9, 1.1),
		)),
		Item("CACTUS_BOOTS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(5.4, 6.6),
			StatId.WEAPON_DAMAGE to MinMaxValue(0.9, 1.1),
		)),
		Item("TOTEM_CACTUS", mutableMapOf(
			StatId.WEAPON_DAMAGE to MinMaxValue(5.4, 6.6),
			StatId.KNOCKBACK_RESISTANCE to MinMaxValue(4.5, 5.5),
			StatId.MOVEMENT_SPEED to MinMaxValue(3.3, 3.3),
		)),
		Item("CACTUS_SWORD", mutableMapOf(
			StatId.ATTACK_DAMAGE to MinMaxValue(8.1, 9.9),
			StatId.ATTACK_SPEED to MinMaxValue(1.0, 1.0),
			StatId.CRITICAL_STRIKE_CHANCE to MinMaxValue(4.5, 5.5),
			StatId.CRITICAL_STRIKE_POWER to MinMaxValue(18.0, 22.0),
		)),

		Item("STONE_HELMET", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(10.8, 13.2),
			StatId.WEAPON_DAMAGE to MinMaxValue(1.8, 2.2),
		)),
		Item("STONE_CHESTPLATE", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(21.6, 26.4),
			StatId.WEAPON_DAMAGE to MinMaxValue(1.8, 2.2),
		)),
		Item("STONE_LEGGINGS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(18.0, 22.0),
			StatId.WEAPON_DAMAGE to MinMaxValue(1.8, 2.2),
		)),
		Item("STONE_BOOTS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(10.8, 13.2),
			StatId.WEAPON_DAMAGE to MinMaxValue(1.8, 2.2),
		)),
		Item("TOTEM_STONE", mutableMapOf(
			StatId.WEAPON_DAMAGE to MinMaxValue(10.8, 13.2),
			StatId.KNOCKBACK_RESISTANCE to MinMaxValue(9.0, 11.0),
			StatId.MOVEMENT_SPEED to MinMaxValue(6.6, 6.6),
		)),
		Item("STONE_SWORD", mutableMapOf(
			StatId.ATTACK_DAMAGE to MinMaxValue(10.8, 13.2),
			StatId.ATTACK_SPEED to MinMaxValue(1.0, 1.0),
			StatId.CRITICAL_STRIKE_CHANCE to MinMaxValue(4.5, 5.5),
			StatId.CRITICAL_STRIKE_POWER to MinMaxValue(18.0, 22.0),
		)),

		Item("MYTHRIL_HELMET", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(16.2, 19.8),
			StatId.WEAPON_DAMAGE to MinMaxValue(2.7, 3.3),
		)),
		Item("MYTHRIL_CHESTPLATE", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(32.4, 39.6),
			StatId.WEAPON_DAMAGE to MinMaxValue(2.7, 3.3),
		)),
		Item("MYTHRIL_LEGGINGS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(27.0, 33.0),
			StatId.WEAPON_DAMAGE to MinMaxValue(2.7, 3.3),
		)),
		Item("MYTHRIL_BOOTS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(16.2, 19.8),
			StatId.WEAPON_DAMAGE to MinMaxValue(2.7, 3.3),
		)),
		Item("TOTEM_UNSETTLING", mutableMapOf(
			StatId.WEAPON_DAMAGE to MinMaxValue(16.2, 19.8),
			StatId.KNOCKBACK_RESISTANCE to MinMaxValue(13.5, 16.5),
			StatId.MOVEMENT_SPEED to MinMaxValue(9.9, 9.9),
		)),
		Item("UNSETTLING_BLADE", mutableMapOf(
			StatId.ATTACK_DAMAGE to MinMaxValue(13.5, 16.5),
			StatId.ATTACK_SPEED to MinMaxValue(1.0, 1.0),
			StatId.CRITICAL_STRIKE_CHANCE to MinMaxValue(4.5, 5.5),
			StatId.CRITICAL_STRIKE_POWER to MinMaxValue(18.0, 22.0),
		)),

		Item("BLOODSNOUT_SLAYER_HELMET", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(21.6, 26.4),
			StatId.WEAPON_DAMAGE to MinMaxValue(3.6, 4.4),
		)),
		Item("BLOODSNOUT_SLAYER_CHESTPLATE", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(43.2, 52.8),
			StatId.WEAPON_DAMAGE to MinMaxValue(3.6, 4.4),
		)),
		Item("BLOODSNOUT_SLAYER_LEGGINGS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(36.0, 44.0),
			StatId.WEAPON_DAMAGE to MinMaxValue(3.6, 4.4),
		)),
		Item("BLOODSNOUT_SLAYER_BOOTS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(21.6, 26.4),
			StatId.WEAPON_DAMAGE to MinMaxValue(3.6, 4.4),
		)),
		Item("TOTEM_BLOODSNOUT", mutableMapOf(
			StatId.WEAPON_DAMAGE to MinMaxValue(21.6, 26.4),
			StatId.KNOCKBACK_RESISTANCE to MinMaxValue(18.0, 22.0),
			StatId.MOVEMENT_SPEED to MinMaxValue(13.2, 13.2),
		)),
		Item("BLOODSNOUT_BLADE", mutableMapOf(
			StatId.ATTACK_DAMAGE to MinMaxValue(16.2, 19.8),
			StatId.ATTACK_SPEED to MinMaxValue(1.0, 1.0),
			StatId.CRITICAL_STRIKE_CHANCE to MinMaxValue(4.5, 5.5),
			StatId.CRITICAL_STRIKE_POWER to MinMaxValue(18.0, 22.0),
		)),

		Item("MONTU_HELMET", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(27.0, 33.0),
			StatId.WEAPON_DAMAGE to MinMaxValue(4.5, 5.5),
		)),
		Item("MONTU_CHESTPLATE", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(54.0, 66.0),
			StatId.WEAPON_DAMAGE to MinMaxValue(4.5, 5.5),
		)),
		Item("MONTU_LEGGINGS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(45.0, 55.0),
			StatId.WEAPON_DAMAGE to MinMaxValue(4.5, 5.5),
		)),
		Item("MONTU_BOOTS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(27.0, 33.0),
			StatId.WEAPON_DAMAGE to MinMaxValue(4.5, 5.5),
		)),
		Item("TOTEM_MONTU", mutableMapOf(
			StatId.WEAPON_DAMAGE to MinMaxValue(27.0, 33.0),
			StatId.KNOCKBACK_RESISTANCE to MinMaxValue(22.5, 27.5),
			StatId.MOVEMENT_SPEED to MinMaxValue(13.5, 16.5), // TODO - check if this is really correct
		)),
		Item("MONTU_BLADE", mutableMapOf(
			StatId.ATTACK_DAMAGE to MinMaxValue(18.9, 23.1),
			StatId.ATTACK_SPEED to MinMaxValue(1.0, 1.0),
			StatId.CRITICAL_STRIKE_CHANCE to MinMaxValue(4.5, 5.5),
			StatId.CRITICAL_STRIKE_POWER to MinMaxValue(18.0, 22.0),
		)),

		Item("WARRIORS_HELMET", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(32.4, 39.6), // 32.4 - 27.0 = 5.4 // 5.2 / 2 = 2.7
			StatId.WEAPON_DAMAGE to MinMaxValue(5.4, 6.6),
		)),
		Item("WARRIORS_CHESTPLATE", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(64.8, 79.2),
			StatId.WEAPON_DAMAGE to MinMaxValue(5.4, 6.6),
		)),
		Item("WARRIORS_LEGGINGS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(54.0, 66.0),
			StatId.WEAPON_DAMAGE to MinMaxValue(5.4, 6.6),
		)),
		Item("WARRIORS_BOOTS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(32.4, 39.6),
			StatId.WEAPON_DAMAGE to MinMaxValue(5.4, 6.6),
		)),



		Item("SILK_HELMET", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(1.8, 2.2),
			StatId.MAGIC_DAMAGE to MinMaxValue(0.9, 1.1),
		)),
		Item("SILK_CHESTPLATE", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(7.2, 8.8),
			StatId.MAGIC_DAMAGE to MinMaxValue(0.9, 1.1),
		)),
		Item("SILK_LEGGINGS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(5.4, 6.6),
			StatId.MAGIC_DAMAGE to MinMaxValue(0.9, 1.1),
		)),
		Item("SILK_BOOTS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(1.8, 2.2),
			StatId.MAGIC_DAMAGE to MinMaxValue(0.9, 1.1),
		)),
		Item("FOCUS_WIND", mutableMapOf(
			StatId.MAGIC_DAMAGE to MinMaxValue(5.4, 6.6),
			StatId.FALL_DAMAGE_REDUCTION to MinMaxValue(4.5, 5.5),
		)),

		Item("SPARKING_SILK_HELMET", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(3.6, 4.4),
			StatId.MAGIC_DAMAGE to MinMaxValue(1.8, 2.2),
		)),
		Item("SPARKING_SILK_CHESTPLATE", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(14.4, 17.6),
			StatId.MAGIC_DAMAGE to MinMaxValue(1.8, 2.2),
		)),
		Item("SPARKING_SILK_LEGGINGS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(10.8, 13.2),
			StatId.MAGIC_DAMAGE to MinMaxValue(1.8, 2.2),
		)),
		Item("SPARKING_SILK_BOOTS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(3.6, 4.4),
			StatId.MAGIC_DAMAGE to MinMaxValue(1.8, 2.2),
		)),
		Item("FOCUS_SLIME", mutableMapOf(
			StatId.MAGIC_DAMAGE to MinMaxValue(10.8, 13.2),
			StatId.FALL_DAMAGE_REDUCTION to MinMaxValue(9.0, 11.0),
		)),

		Item("ACOLYTE_HELMET", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(5.4, 6.6),
			StatId.MAGIC_DAMAGE to MinMaxValue(2.7, 3.3),
		)),
		Item("ACOLYTE_CHESTPLATE", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(21.6, 26.4),
			StatId.MAGIC_DAMAGE to MinMaxValue(2.7, 3.3),
		)),
		Item("ACOLYTE_LEGGINGS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(16.2, 19.8),
			StatId.MAGIC_DAMAGE to MinMaxValue(2.7, 3.3),
		)),
		Item("ACOLYTE_BOOTS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(5.4, 6.6),
			StatId.MAGIC_DAMAGE to MinMaxValue(2.7, 3.3),
		)),
		Item("FOCUS_UNSETTLING", mutableMapOf(
			StatId.MAGIC_DAMAGE to MinMaxValue(16.2, 19.8),
			StatId.FALL_DAMAGE_REDUCTION to MinMaxValue(13.5, 16.5),
		)),

		Item("BLOODSNOUT_MAGI_HELMET", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(7.2, 8.8),
			StatId.MAGIC_DAMAGE to MinMaxValue(3.6, 4.4),
		)),
		Item("BLOODSNOUT_MAGI_CHESTPLATE", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(28.8, 35.2),
			StatId.MAGIC_DAMAGE to MinMaxValue(3.6, 4.4),
		)),
		Item("BLOODSNOUT_MAGI_LEGGINGS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(21.6, 26.4),
			StatId.MAGIC_DAMAGE to MinMaxValue(3.6, 4.4),
		)),
		Item("BLOODSNOUT_MAGI_BOOTS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(7.2, 8.8),
			StatId.MAGIC_DAMAGE to MinMaxValue(3.6, 4.4),
		)),
		Item("FOCUS_BLOODSNOUT", mutableMapOf(
			StatId.MAGIC_DAMAGE to MinMaxValue(21.6, 26.4),
			StatId.FALL_DAMAGE_REDUCTION to MinMaxValue(18.0, 22.0),
		)),

		Item("DJEDI_HELMET", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(9.0, 11.0),
			StatId.MAGIC_DAMAGE to MinMaxValue(4.5, 5.5),
		)),
		Item("DJEDI_CHESTPLATE", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(36.0, 44.0),
			StatId.MAGIC_DAMAGE to MinMaxValue(4.5, 5.5),
		)),
		Item("DJEDI_LEGGINGS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(27.0, 33.0),
			StatId.MAGIC_DAMAGE to MinMaxValue(4.5, 5.5),
		)),
		Item("DJEDI_BOOTS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(9.0, 11.0),
			StatId.MAGIC_DAMAGE to MinMaxValue(4.5, 5.5),
		)),
		Item("FOCUS_DJEDI", mutableMapOf(
			StatId.MAGIC_DAMAGE to MinMaxValue(27.0, 33.0),
			StatId.FALL_DAMAGE_REDUCTION to MinMaxValue(22.5, 27.5),
		)),

		Item("WIZARDS_HELMET", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(10.8, 13.2),
			StatId.MAGIC_DAMAGE to MinMaxValue(5.4, 6.6),
		)),
		Item("WIZARDS_CHESTPLATE", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(43.2, 52.8),
			StatId.MAGIC_DAMAGE to MinMaxValue(5.4, 6.6),
		)),
		Item("WIZARDS_LEGGINGS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(32.4, 39.6),
			StatId.MAGIC_DAMAGE to MinMaxValue(5.4, 6.6),
		)),
		Item("WIZARDS_BOOTS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(10.8, 13.2),
			StatId.MAGIC_DAMAGE to MinMaxValue(5.4, 6.6),
		)),

		Item("TOME_FROSTBOLT_1", mutableMapOf(), mutableListOf(
			Ability("FROSTBOLT", "Frostbolt", "RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.DAMAGE to MinMaxValue(13.5, 16.5),
				AbilityModifierId.COOLDOWN to MinMaxValue(2.0, 2.0),
			)),
		)),
		Item("TOME_FROSTBOLT_2", mutableMapOf(), mutableListOf(
			Ability("FROSTBOLT", "Frostbolt", "RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.DAMAGE to MinMaxValue(16.2, 19.8),
				AbilityModifierId.COOLDOWN to MinMaxValue(2.0, 2.0),
			)),
		)),
		Item("TOME_FROSTBOLT_3", mutableMapOf(), mutableListOf(
			Ability("FROSTBOLT", "Frostbolt", "RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.DAMAGE to MinMaxValue(18.9, 23.1),
				AbilityModifierId.COOLDOWN to MinMaxValue(2.0, 2.0),
			)),
		)),
		Item("TOME_FROSTBOLT_4", mutableMapOf(), mutableListOf(
			Ability("FROSTBOLT", "Frostbolt", "RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.DAMAGE to MinMaxValue(21.6, 26.4),
				AbilityModifierId.COOLDOWN to MinMaxValue(2.0, 2.0),
			)),
		)),
		Item("TOME_FROSTBOLT_5", mutableMapOf(), mutableListOf(
			Ability("FROSTBOLT", "Frostbolt", "RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.DAMAGE to MinMaxValue(24.3, 29.7),
				AbilityModifierId.COOLDOWN to MinMaxValue(2.0, 2.0),
			)),
		)),
		Item("TOME_FROSTBOLT_6", mutableMapOf(), mutableListOf(
			Ability("FROSTBOLT", "Frostbolt", "RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.DAMAGE to MinMaxValue(27.0, 33.0),
				AbilityModifierId.COOLDOWN to MinMaxValue(2.0, 2.0),
			)),
		)),

		Item("TOME_FIREBOLT_1", mutableMapOf(), mutableListOf(
			Ability("FIREBOLT", "Firebolt", "RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.DAMAGE to MinMaxValue(10.8, 13.2),
				AbilityModifierId.IGNITE to MinMaxValue(4.0, 4.0),
				AbilityModifierId.COOLDOWN to MinMaxValue(2.0, 2.0),
			)),
		)),
		Item("TOME_FIREBOLT_2", mutableMapOf(), mutableListOf(
			Ability("FIREBOLT", "Firebolt", "RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.DAMAGE to MinMaxValue(13.5, 16.5),
				AbilityModifierId.IGNITE to MinMaxValue(5.0, 5.0),
				AbilityModifierId.COOLDOWN to MinMaxValue(2.0, 2.0),
			)),
		)),
		Item("TOME_FIREBOLT_3", mutableMapOf(), mutableListOf(
			Ability("FIREBOLT", "Firebolt", "RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.DAMAGE to MinMaxValue(16.2, 19.8),
				AbilityModifierId.IGNITE to MinMaxValue(5.0, 5.0),
				AbilityModifierId.COOLDOWN to MinMaxValue(2.0, 2.0),
			)),
		)),
		Item("TOME_FIREBOLT_4", mutableMapOf(), mutableListOf(
			Ability("FIREBOLT", "Firebolt", "RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.DAMAGE to MinMaxValue(18.9, 23.1), // 19.4
				AbilityModifierId.IGNITE to MinMaxValue(5.0, 5.0),
				AbilityModifierId.COOLDOWN to MinMaxValue(2.0, 2.0),
			)),
		)),
		Item("TOME_FIREBOLT_5", mutableMapOf(), mutableListOf(
			Ability("FIREBOLT", "Firebolt", "RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.DAMAGE to MinMaxValue(21.6, 26.4),
				AbilityModifierId.IGNITE to MinMaxValue(5.0, 5.0),
				AbilityModifierId.COOLDOWN to MinMaxValue(2.0, 2.0),
			)),
		)),
		Item("TOME_FIREBOLT_6", mutableMapOf(), mutableListOf(
			Ability("FIREBOLT", "Firebolt", "RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.DAMAGE to MinMaxValue(24.3, 29.7),
				AbilityModifierId.IGNITE to MinMaxValue(5.0, 5.0),
				AbilityModifierId.COOLDOWN to MinMaxValue(2.0, 2.0),
			)),
		)),

		Item("TOME_PRESSURE_WAVE_1", mutableMapOf(), mutableListOf(
			Ability("PRESSURE_WAVE", "Pressure Wave", "RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.DAMAGE to MinMaxValue(2.7, 3.3),
				AbilityModifierId.COOLDOWN to MinMaxValue(10.0, 10.0),
				AbilityModifierId.ANGLE to MinMaxValue(59.4, 61.8), // TODO - guess
				AbilityModifierId.FORCE to MinMaxValue(5.0, 10.0), // TODO - guess
			)),
		)),
		Item("TOME_PRESSURE_WAVE_2", mutableMapOf(), mutableListOf(
			Ability("PRESSURE_WAVE", "Pressure Wave", "RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.DAMAGE to MinMaxValue(5.4, 6.6),
				AbilityModifierId.COOLDOWN to MinMaxValue(10.0, 10.0),
				AbilityModifierId.ANGLE to MinMaxValue(59.4, 61.8), // TODO - guess
				AbilityModifierId.FORCE to MinMaxValue(5.0, 10.0), // TODO - guess
			)),
		)),
		Item("TOME_PRESSURE_WAVE_3", mutableMapOf(), mutableListOf(
			Ability("PRESSURE_WAVE", "Pressure Wave", "RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.DAMAGE to MinMaxValue(8.1, 9.9),
				AbilityModifierId.COOLDOWN to MinMaxValue(10.0, 10.0),
				AbilityModifierId.ANGLE to MinMaxValue(59.4, 61.8), // TODO - guess
				AbilityModifierId.FORCE to MinMaxValue(5.0, 10.0), // TODO - guess
			)),
		)),
		Item("TOME_PRESSURE_WAVE_4", mutableMapOf(), mutableListOf(
			Ability("PRESSURE_WAVE", "Pressure Wave", "RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.DAMAGE to MinMaxValue(10.8, 13.2),
				AbilityModifierId.COOLDOWN to MinMaxValue(10.0, 10.0),
				AbilityModifierId.ANGLE to MinMaxValue(59.4, 61.8), // TODO - guess
				AbilityModifierId.FORCE to MinMaxValue(5.0, 10.0), // TODO - guess
			)),
		)),
		Item("TOME_PRESSURE_WAVE_5", mutableMapOf(), mutableListOf(
			Ability("PRESSURE_WAVE", "Pressure Wave", "RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.DAMAGE to MinMaxValue(13.5, 16.5),
				AbilityModifierId.COOLDOWN to MinMaxValue(10.0, 10.0),
				AbilityModifierId.ANGLE to MinMaxValue(59.4, 61.8), // TODO - guess
				AbilityModifierId.FORCE to MinMaxValue(5.0, 10.0), // TODO - guess
			)),
		)),
		Item("TOME_PRESSURE_WAVE_6", mutableMapOf(), mutableListOf(
			Ability("PRESSURE_WAVE", "Pressure Wave", "RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.DAMAGE to MinMaxValue(16.2, 19.8),
				AbilityModifierId.COOLDOWN to MinMaxValue(10.0, 10.0),
				AbilityModifierId.ANGLE to MinMaxValue(59.4, 61.8), // TODO - guess
				AbilityModifierId.FORCE to MinMaxValue(5.0, 10.0), // TODO - guess
			)),
		)),

		Item("TOME_COLLAPSING_EARTH_1", mutableMapOf(), mutableListOf(
			Ability("COLLAPSING_EARTH", "Collapsing Earth", "RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.DAMAGE to MinMaxValue(5.4, 6.6),
				AbilityModifierId.COOLDOWN to MinMaxValue(10.0, 10.0),
				AbilityModifierId.RADIUS to MinMaxValue(2.5, 2.5),
			)),
		)),
		Item("TOME_COLLAPSING_EARTH_2", mutableMapOf(), mutableListOf(
			Ability("COLLAPSING_EARTH", "Collapsing Earth", "RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.DAMAGE to MinMaxValue(8.1, 9.9),
				AbilityModifierId.COOLDOWN to MinMaxValue(10.0, 10.0),
				AbilityModifierId.RADIUS to MinMaxValue(2.5, 2.5),
			)),
		)),
		Item("TOME_COLLAPSING_EARTH_3", mutableMapOf(), mutableListOf(
			Ability("COLLAPSING_EARTH", "Collapsing Earth", "RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.DAMAGE to MinMaxValue(10.8, 13.2),
				AbilityModifierId.COOLDOWN to MinMaxValue(10.0, 10.0),
				AbilityModifierId.RADIUS to MinMaxValue(2.5, 2.5),
			)),
		)),
		Item("TOME_COLLAPSING_EARTH_4", mutableMapOf(), mutableListOf(
			Ability("COLLAPSING_EARTH", "Collapsing Earth", "RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.DAMAGE to MinMaxValue(13.5, 16.5),
				AbilityModifierId.COOLDOWN to MinMaxValue(10.0, 10.0),
				AbilityModifierId.RADIUS to MinMaxValue(2.5, 2.5),
			)),
		)),
		Item("TOME_COLLAPSING_EARTH_5", mutableMapOf(), mutableListOf(
			Ability("COLLAPSING_EARTH", "Collapsing Earth", "RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.DAMAGE to MinMaxValue(16.2, 19.8),
				AbilityModifierId.COOLDOWN to MinMaxValue(10.0, 10.0),
				AbilityModifierId.RADIUS to MinMaxValue(2.5, 2.5),
			)),
		)),
		Item("TOME_COLLAPSING_EARTH_6", mutableMapOf(), mutableListOf(
			Ability("COLLAPSING_EARTH", "Collapsing Earth", "RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.DAMAGE to MinMaxValue(18.9, 23.1),
				AbilityModifierId.COOLDOWN to MinMaxValue(10.0, 10.0),
				AbilityModifierId.RADIUS to MinMaxValue(2.5, 2.5),
			)),
		)),



		Item("SHOTCALLER_HELMET", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(3.6, 4.4),
			StatId.PROJECTILE_DAMAGE to MinMaxValue(0.9, 1.1),
		)),
		Item("SHOTCALLER_CHESTPLATE", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(9.0, 11.0),
			StatId.PROJECTILE_DAMAGE to MinMaxValue(0.9, 1.1),
		)),
		Item("SHOTCALLER_LEGGINGS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(7.2, 8.8),
			StatId.PROJECTILE_DAMAGE to MinMaxValue(0.9, 1.1),
		)),
		Item("SHOTCALLER_BOOTS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(3.6, 4.4),
			StatId.PROJECTILE_DAMAGE to MinMaxValue(0.9, 1.1),
		)),
		Item("STRONG_BOW", mutableMapOf(
			StatId.ATTACK_DAMAGE to MinMaxValue(9.0, 11.0),
			StatId.CRITICAL_STRIKE_CHANCE to MinMaxValue(5.4, 6.6),
			StatId.CRITICAL_STRIKE_POWER to MinMaxValue(21.6, 26.4),

			StatId.PROJECTILE_DAMAGE to MinMaxValue(5.4, 6.6),
			StatId.ARROW_VELOCITY to MinMaxValue(1.1, 1.3),
		)),

		Item("RANGER_HELMET", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(7.2, 8.8),
			StatId.PROJECTILE_DAMAGE to MinMaxValue(1.8, 2.2),
		)),
		Item("RANGER_CHESTPLATE", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(18.0, 22.0),
			StatId.PROJECTILE_DAMAGE to MinMaxValue(1.8, 2.2),
		)),
		Item("RANGER_LEGGINGS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(14.4, 17.6),
			StatId.PROJECTILE_DAMAGE to MinMaxValue(1.8, 2.2),
		)),
		Item("RANGER_BOOTS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(7.2, 8.8),
			StatId.PROJECTILE_DAMAGE to MinMaxValue(1.8, 2.2),
		)),
		Item("SKELETAL_BOW", mutableMapOf(
			StatId.ATTACK_DAMAGE to MinMaxValue(13.5, 16.5),
			StatId.CRITICAL_STRIKE_CHANCE to MinMaxValue(6.3, 7.7),
			StatId.CRITICAL_STRIKE_POWER to MinMaxValue(25.2, 30.8),

			StatId.PROJECTILE_DAMAGE to MinMaxValue(10.8, 13.2),
			StatId.ARROW_VELOCITY to MinMaxValue(1.1, 1.3),
		)),

		Item("SHARPSHOOTER_HELMET", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(10.8, 13.2),
			StatId.PROJECTILE_DAMAGE to MinMaxValue(2.7, 3.3),
		)),
		Item("SHARPSHOOTER_CHESTPLATE", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(27.0, 33.0),
			StatId.PROJECTILE_DAMAGE to MinMaxValue(2.7, 3.3),
		)),
		Item("SHARPSHOOTER_LEGGINGS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(21.6, 26.4),
			StatId.PROJECTILE_DAMAGE to MinMaxValue(2.7, 3.3),
		)),
		Item("SHARPSHOOTER_BOOTS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(10.8, 13.2),
			StatId.PROJECTILE_DAMAGE to MinMaxValue(2.7, 3.3),
		)),
		Item("UNSETTLING_BOW", mutableMapOf(
			StatId.ATTACK_DAMAGE to MinMaxValue(18.0, 22.0),
			StatId.CRITICAL_STRIKE_CHANCE to MinMaxValue(7.2, 8.8),
			StatId.CRITICAL_STRIKE_POWER to MinMaxValue(28.8, 35.2),

			StatId.PROJECTILE_DAMAGE to MinMaxValue(16.2, 19.8),
			StatId.ARROW_VELOCITY to MinMaxValue(1.1, 1.3),
		)),

		Item("BLOODSNOUT_RANGER_HELMET", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(14.4, 17.6),
			StatId.PROJECTILE_DAMAGE to MinMaxValue(3.6, 4.4),
		)),
		Item("BLOODSNOUT_RANGER_CHESTPLATE", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(36.0, 44.0),
			StatId.PROJECTILE_DAMAGE to MinMaxValue(3.6, 4.4),
		)),
		Item("BLOODSNOUT_RANGER_LEGGINGS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(28.8, 35.2),
			StatId.PROJECTILE_DAMAGE to MinMaxValue(3.6, 4.4),
		)),
		Item("BLOODSNOUT_RANGER_BOOTS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(14.4, 17.6),
			StatId.PROJECTILE_DAMAGE to MinMaxValue(3.6, 4.4),
		)),
		Item("PIGGLY_WIGGLY_BOW", mutableMapOf(
			StatId.ATTACK_DAMAGE to MinMaxValue(22.5, 27.5),
			StatId.CRITICAL_STRIKE_CHANCE to MinMaxValue(8.1, 9.9),
			StatId.CRITICAL_STRIKE_POWER to MinMaxValue(32.4, 39.6),

			StatId.PROJECTILE_DAMAGE to MinMaxValue(21.6, 26.4),
			StatId.ARROW_VELOCITY to MinMaxValue(1.1, 1.3),
		)),

		Item("SATET_HELMET", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(18.0, 22.0),
			StatId.PROJECTILE_DAMAGE to MinMaxValue(4.5, 5.5),
		)),
		Item("SATET_CHESTPLATE", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(45.0, 55.0),
			StatId.PROJECTILE_DAMAGE to MinMaxValue(4.5, 5.5),
		)),
		Item("SATET_LEGGINGS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(36.0, 44.0),
			StatId.PROJECTILE_DAMAGE to MinMaxValue(4.5, 5.5),
		)),
		Item("SATET_BOOTS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(18.0, 22.0),
			StatId.PROJECTILE_DAMAGE to MinMaxValue(4.5, 5.5),
		)),
		Item("SATET_BOW", mutableMapOf(
			StatId.ATTACK_DAMAGE to MinMaxValue(27.0, 33.0),
			StatId.CRITICAL_STRIKE_CHANCE to MinMaxValue(9.0, 11.0),
			StatId.CRITICAL_STRIKE_POWER to MinMaxValue(36.0, 44.0),

			StatId.PROJECTILE_DAMAGE to MinMaxValue(27.0, 33.0),
			StatId.ARROW_VELOCITY to MinMaxValue(1.1, 1.3),
		)),

		Item("MARKSMAN_HELMET", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(21.6, 26.4),
			StatId.PROJECTILE_DAMAGE to MinMaxValue(5.4, 6.6),
		)),
		Item("MARKSMAN_CHESTPLATE", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(54.0, 66.0),
			StatId.PROJECTILE_DAMAGE to MinMaxValue(5.4, 6.6),
		)),
		Item("MARKSMAN_LEGGINGS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(43.2, 52.8),
			StatId.PROJECTILE_DAMAGE to MinMaxValue(5.4, 6.6),
		)),
		Item("MARKSMAN_BOOTS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(21.6, 26.4),
			StatId.PROJECTILE_DAMAGE to MinMaxValue(5.4, 6.6),
		)),

		Item("QUIVER_FLINT", mutableMapOf(
			StatId.PROJECTILE_DAMAGE to MinMaxValue(9.0, 11.0),
		)),
		Item("QUIVER_SERRATED", mutableMapOf(
			StatId.PROJECTILE_DAMAGE to MinMaxValue(18.0, 22.0),
		)),

		Item("QUIVER_POISON", mutableMapOf()),
		Item("QUIVER_VENOM", mutableMapOf()),

		Item("QUIVER_ROTTEN", mutableMapOf()),
		Item("QUIVER_HORRIFYING", mutableMapOf()),

		Item("QUIVER_TACKY", mutableMapOf()),
		Item("QUIVER_STICKY", mutableMapOf()),

		Item("QUIVER_BURNING", mutableMapOf()),
		Item("QUIVER_SATET", mutableMapOf()),



		Item("WOOL_HELMET", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(1.8, 2.2),
			StatId.THAUMATURGY_DAMAGE to MinMaxValue(1.8, 2.2),
			StatId.COOLDOWN_REDUCTION to MinMaxValue(0.5, 0.6),
		)),
		Item("WOOL_CHESTPLATE", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(7.2, 8.8),
			StatId.THAUMATURGY_DAMAGE to MinMaxValue(1.8, 2.2),
			StatId.COOLDOWN_REDUCTION to MinMaxValue(0.5, 0.6),
		)),
		Item("WOOL_LEGGINGS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(5.4, 6.6),
			StatId.THAUMATURGY_DAMAGE to MinMaxValue(1.8, 2.2),
			StatId.COOLDOWN_REDUCTION to MinMaxValue(0.5, 0.6),
		)),
		Item("WOOL_BOOTS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(1.8, 2.2),
			StatId.THAUMATURGY_DAMAGE to MinMaxValue(1.8, 2.2),
			StatId.COOLDOWN_REDUCTION to MinMaxValue(0.5, 0.6),
		)),
		Item("IMPLEMENT_CAUTERIZING", mutableMapOf(
			StatId.THAUMATURGY_DAMAGE to MinMaxValue(4.5, 5.5),
			StatId.HEALTH_REGENERATION to MinMaxValue(0.01, 0.01),
			StatId.COOLDOWN_REDUCTION to MinMaxValue(0.9, 1.1),
		)),

		Item("BLESSED_WOOL_HELMET", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(3.6, 4.4),
			StatId.THAUMATURGY_DAMAGE to MinMaxValue(3.6, 4.4),
			StatId.COOLDOWN_REDUCTION to MinMaxValue(0.9, 1.1),
		)),
		Item("BLESSED_WOOL_CHESTPLATE", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(14.4, 17.6),
			StatId.THAUMATURGY_DAMAGE to MinMaxValue(3.6, 4.4),
			StatId.COOLDOWN_REDUCTION to MinMaxValue(0.9, 1.1),
		)),
		Item("BLESSED_WOOL_LEGGINGS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(10.8, 13.2),
			StatId.THAUMATURGY_DAMAGE to MinMaxValue(3.6, 4.4),
			StatId.COOLDOWN_REDUCTION to MinMaxValue(0.9, 1.1),
		)),
		Item("BLESSED_WOOL_BOOTS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(3.6, 4.4),
			StatId.THAUMATURGY_DAMAGE to MinMaxValue(3.6, 4.4),
			StatId.COOLDOWN_REDUCTION to MinMaxValue(0.9, 1.1),
		)),
		Item("IMPLEMENT_GUIDING", mutableMapOf(
			StatId.THAUMATURGY_DAMAGE to MinMaxValue(9.0, 11.0),
			StatId.HEALTH_REGENERATION to MinMaxValue(0.02, 0.02),
			StatId.COOLDOWN_REDUCTION to MinMaxValue(1.8, 2.2),
		)),

		Item("SANCTIFIED_HELMET", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(5.4, 6.6),
			StatId.THAUMATURGY_DAMAGE to MinMaxValue(5.4, 6.6),
			StatId.COOLDOWN_REDUCTION to MinMaxValue(1.4, 1.6),
		)),
		Item("SANCTIFIED_CHESTPLATE", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(21.6, 26.4),
			StatId.THAUMATURGY_DAMAGE to MinMaxValue(5.4, 6.6),
			StatId.COOLDOWN_REDUCTION to MinMaxValue(1.4, 1.6),
		)),
		Item("SANCTIFIED_LEGGINGS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(16.2, 19.8),
			StatId.THAUMATURGY_DAMAGE to MinMaxValue(5.4, 6.6),
			StatId.COOLDOWN_REDUCTION to MinMaxValue(1.4, 1.6),
		)),
		Item("SANCTIFIED_BOOTS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(5.4, 6.6),
			StatId.THAUMATURGY_DAMAGE to MinMaxValue(5.4, 6.6),
			StatId.COOLDOWN_REDUCTION to MinMaxValue(1.4, 1.6),
		)),
		Item("IMPLEMENT_BRAND", mutableMapOf(
			StatId.THAUMATURGY_DAMAGE to MinMaxValue(13.5, 16.5),
			StatId.HEALTH_REGENERATION to MinMaxValue(0.03, 0.03),
			StatId.COOLDOWN_REDUCTION to MinMaxValue(2.7, 3.3),
		)),

		Item("BLOODSNOUT_HEALER_HELMET", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(7.2, 8.8),
			StatId.THAUMATURGY_DAMAGE to MinMaxValue(7.2, 8.8),
			StatId.COOLDOWN_REDUCTION to MinMaxValue(1.8, 2.2),
		)),
		Item("BLOODSNOUT_HEALER_CHESTPLATE", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(28.8, 35.2),
			StatId.THAUMATURGY_DAMAGE to MinMaxValue(7.2, 8.8),
			StatId.COOLDOWN_REDUCTION to MinMaxValue(1.8, 2.2),
		)),
		Item("BLOODSNOUT_HEALER_LEGGINGS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(21.6, 26.4),
			StatId.THAUMATURGY_DAMAGE to MinMaxValue(7.2, 8.8),
			StatId.COOLDOWN_REDUCTION to MinMaxValue(1.8, 2.2),
		)),
		Item("BLOODSNOUT_HEALER_BOOTS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(7.2, 8.8),
			StatId.THAUMATURGY_DAMAGE to MinMaxValue(7.2, 8.8),
			StatId.COOLDOWN_REDUCTION to MinMaxValue(1.8, 2.2),
		)),
		Item("IMPLEMENT_CALLER", mutableMapOf(
			StatId.THAUMATURGY_DAMAGE to MinMaxValue(18.0, 22.0),
			StatId.HEALTH_REGENERATION to MinMaxValue(0.04, 0.04),
			StatId.COOLDOWN_REDUCTION to MinMaxValue(3.6, 4.4),
		)),

		Item("HEKA_HELMET", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(9.0, 11.0),
			StatId.THAUMATURGY_DAMAGE to MinMaxValue(9.0, 11.0),
			StatId.COOLDOWN_REDUCTION to MinMaxValue(2.2, 2.8),
		)),
		Item("HEKA_CHESTPLATE", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(36.0, 44.0),
			StatId.THAUMATURGY_DAMAGE to MinMaxValue(9.0, 11.0),
			StatId.COOLDOWN_REDUCTION to MinMaxValue(2.2, 2.8),
		)),
		Item("HEKA_LEGGINGS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(27.0, 33.0),
			StatId.THAUMATURGY_DAMAGE to MinMaxValue(9.0, 11.0),
			StatId.COOLDOWN_REDUCTION to MinMaxValue(2.2, 2.8),
		)),
		Item("HEKA_BOOTS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(9.0, 11.0),
			StatId.THAUMATURGY_DAMAGE to MinMaxValue(9.0, 11.0),
			StatId.COOLDOWN_REDUCTION to MinMaxValue(2.2, 2.8),
		)),
		Item("IMPLEMENT_HEKA", mutableMapOf(
			StatId.THAUMATURGY_DAMAGE to MinMaxValue(22.5, 27.5),
			StatId.HEALTH_REGENERATION to MinMaxValue(0.05, 0.05),
			StatId.COOLDOWN_REDUCTION to MinMaxValue(4.5, 5.5),
		)),

		Item("THAUMATURGE_HELMET", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(10.8, 13.2),
			StatId.THAUMATURGY_DAMAGE to MinMaxValue(10.8, 13.2),
			StatId.COOLDOWN_REDUCTION to MinMaxValue(2.2, 2.8), // TODO - this value might be wrong
		)),
		Item("THAUMATURGE_CHESTPLATE", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(43.2, 52.8),
			StatId.THAUMATURGY_DAMAGE to MinMaxValue(10.8, 13.2),
			StatId.COOLDOWN_REDUCTION to MinMaxValue(2.2, 2.8), // TODO - this value might be wrong
		)),
		Item("THAUMATURGE_LEGGINGS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(32.4, 39.6),
			StatId.THAUMATURGY_DAMAGE to MinMaxValue(10.8, 13.2),
			StatId.COOLDOWN_REDUCTION to MinMaxValue(2.2, 2.8), // TODO - this value might be wrong
		)),
		Item("THAUMATURGE_BOOTS", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(10.8, 13.2),
			StatId.THAUMATURGY_DAMAGE to MinMaxValue(10.8, 13.2),
			StatId.COOLDOWN_REDUCTION to MinMaxValue(2.2, 2.8), // TODO - this value might be wrong
		)),

		Item("TOME_LIFE_DRAIN_1", mutableMapOf(), mutableListOf(
			Ability("LIFE_DRAIN", "Life Drain","RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.DAMAGE to MinMaxValue(7.2, 8.8),
				AbilityModifierId.COOLDOWN to MinMaxValue(2.0, 2.0),
				AbilityModifierId.HEAL to MinMaxValue(0.45, 0.55),
			)),
		)),
		Item("TOME_LIFE_DRAIN_2", mutableMapOf(), mutableListOf(
			Ability("LIFE_DRAIN", "Life Drain","RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.DAMAGE to MinMaxValue(8.1, 9.9),
				AbilityModifierId.COOLDOWN to MinMaxValue(2.0, 2.0),
				AbilityModifierId.HEAL to MinMaxValue(0.9, 1.1),
			)),
		)),
		Item("TOME_LIFE_DRAIN_3", mutableMapOf(), mutableListOf(
			Ability("LIFE_DRAIN", "Life Drain","RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.DAMAGE to MinMaxValue(9.0, 11.0),
				AbilityModifierId.COOLDOWN to MinMaxValue(2.0, 2.0),
				AbilityModifierId.HEAL to MinMaxValue(1.35, 1.65),
			)),
		)),
		Item("TOME_LIFE_DRAIN_4", mutableMapOf(), mutableListOf(
			Ability("LIFE_DRAIN", "Life Drain","RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.DAMAGE to MinMaxValue(9.9, 12.1),
				AbilityModifierId.COOLDOWN to MinMaxValue(2.0, 2.0),
				AbilityModifierId.HEAL to MinMaxValue(1.8, 2.2),
			)),
		)),
		Item("TOME_LIFE_DRAIN_5", mutableMapOf(), mutableListOf(
			Ability("LIFE_DRAIN", "Life Drain","RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.DAMAGE to MinMaxValue(10.8, 13.2),
				AbilityModifierId.COOLDOWN to MinMaxValue(2.0, 2.0),
				AbilityModifierId.HEAL to MinMaxValue(2.25, 2.75),
			)),
		)),
		Item("TOME_LIFE_DRAIN_6", mutableMapOf(), mutableListOf(
			Ability("LIFE_DRAIN", "Life Drain","RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.DAMAGE to MinMaxValue(11.7, 14.3),
				AbilityModifierId.COOLDOWN to MinMaxValue(2.0, 2.0),
				AbilityModifierId.HEAL to MinMaxValue(2.7, 3.3),
			)),
		)),

		Item("TOME_FLASH_HEAL_1", mutableMapOf(), mutableListOf(
			Ability("FLASH_HEAL", "Flash Heal","RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.COOLDOWN to MinMaxValue(2.0, 2.0),
				AbilityModifierId.HEAL to MinMaxValue(0.9, 1.1),
			)),
		)),
		Item("TOME_FLASH_HEAL_2", mutableMapOf(), mutableListOf(
			Ability("FLASH_HEAL", "Flash Heal","RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.COOLDOWN to MinMaxValue(2.0, 2.0),
				AbilityModifierId.HEAL to MinMaxValue(1.8, 2.2),
			)),
		)),
		Item("TOME_FLASH_HEAL_3", mutableMapOf(), mutableListOf(
			Ability("FLASH_HEAL", "Flash Heal","RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.COOLDOWN to MinMaxValue(2.0, 2.0),
				AbilityModifierId.HEAL to MinMaxValue(2.7, 3.3),
			)),
		)),
		Item("TOME_FLASH_HEAL_4", mutableMapOf(), mutableListOf(
			Ability("FLASH_HEAL", "Flash Heal","RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.COOLDOWN to MinMaxValue(2.0, 2.0),
				AbilityModifierId.HEAL to MinMaxValue(3.6, 4.4),
			)),
		)),
		Item("TOME_FLASH_HEAL_5", mutableMapOf(), mutableListOf(
			Ability("FLASH_HEAL", "Flash Heal","RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.COOLDOWN to MinMaxValue(2.0, 2.0),
				AbilityModifierId.HEAL to MinMaxValue(4.5, 5.5),
			)),
		)),
		Item("TOME_FLASH_HEAL_6", mutableMapOf(), mutableListOf(
			Ability("FLASH_HEAL", "Flash Heal","RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.COOLDOWN to MinMaxValue(2.0, 2.0),
				AbilityModifierId.HEAL to MinMaxValue(5.4, 6.6),
			)),
		)),

		Item("TOME_REGENERATION_1", mutableMapOf(), mutableListOf(
			Ability("REGENERATION", "Regeneration","RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.DURATION to MinMaxValue(20.0, 20.0),
				AbilityModifierId.COOLDOWN to MinMaxValue(20.0, 20.0),
				AbilityModifierId.HEAL to MinMaxValue(9.0, 11.0),
			)),
		)),
		Item("TOME_REGENERATION_2", mutableMapOf(), mutableListOf(
			Ability("REGENERATION", "Regeneration","RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.DURATION to MinMaxValue(20.0, 20.0),
				AbilityModifierId.COOLDOWN to MinMaxValue(20.0, 20.0),
				AbilityModifierId.HEAL to MinMaxValue(13.5, 16.5),
			)),
		)),
		Item("TOME_REGENERATION_3", mutableMapOf(), mutableListOf(
			Ability("REGENERATION", "Regeneration","RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.DURATION to MinMaxValue(20.0, 20.0),
				AbilityModifierId.COOLDOWN to MinMaxValue(20.0, 20.0),
				AbilityModifierId.HEAL to MinMaxValue(18.0, 22.0),
			)),
		)),
		Item("TOME_REGENERATION_4", mutableMapOf(), mutableListOf(
			Ability("REGENERATION", "Regeneration","RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.DURATION to MinMaxValue(20.0, 20.0),
				AbilityModifierId.COOLDOWN to MinMaxValue(20.0, 20.0),
				AbilityModifierId.HEAL to MinMaxValue(22.5, 27.5),
			)),
		)),
		Item("TOME_REGENERATION_5", mutableMapOf(), mutableListOf(
			Ability("REGENERATION", "Regeneration","RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.DURATION to MinMaxValue(20.0, 20.0),
				AbilityModifierId.COOLDOWN to MinMaxValue(20.0, 20.0),
				AbilityModifierId.HEAL to MinMaxValue(27.0, 33.0),
			)),
		)),
		Item("TOME_REGENERATION_6", mutableMapOf(), mutableListOf(
			Ability("REGENERATION", "Regeneration","RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.DURATION to MinMaxValue(20.0, 20.0),
				AbilityModifierId.COOLDOWN to MinMaxValue(20.0, 20.0),
				AbilityModifierId.HEAL to MinMaxValue(31.5, 38.5),
			)),
		)),

		Item("TOME_RING_OF_MERCY_1", mutableMapOf(), mutableListOf(
			Ability("RING_OF_MERCY", "Ring of Mercy","RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.BLESS_DURATION to MinMaxValue(3.0, 3.0),
				AbilityModifierId.COOLDOWN to MinMaxValue(20.0, 20.0),
				AbilityModifierId.HEAL to MinMaxValue(2.7, 3.3),
				AbilityModifierId.BLESS_STRENGTH to MinMaxValue(1.0, 1.0),
				AbilityModifierId.RADIUS to MinMaxValue(2.5, 2.5),
			)),
		)),
		Item("TOME_RING_OF_MERCY_2", mutableMapOf(), mutableListOf(
			Ability("RING_OF_MERCY", "Ring of Mercy","RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.BLESS_DURATION to MinMaxValue(3.0, 3.0),
				AbilityModifierId.COOLDOWN to MinMaxValue(20.0, 20.0),
				AbilityModifierId.HEAL to MinMaxValue(5.4, 6.6),
				AbilityModifierId.BLESS_STRENGTH to MinMaxValue(2.0, 2.0),
				AbilityModifierId.RADIUS to MinMaxValue(2.5, 2.5),
			)),
		)),
		Item("TOME_RING_OF_MERCY_3", mutableMapOf(), mutableListOf(
			Ability("RING_OF_MERCY", "Ring of Mercy","RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.BLESS_DURATION to MinMaxValue(3.0, 3.0),
				AbilityModifierId.COOLDOWN to MinMaxValue(20.0, 20.0),
				AbilityModifierId.HEAL to MinMaxValue(8.1, 9.9),
				AbilityModifierId.BLESS_STRENGTH to MinMaxValue(3.0, 3.0),
				AbilityModifierId.RADIUS to MinMaxValue(2.5, 2.5),
			)),
		)),
		Item("TOME_RING_OF_MERCY_4", mutableMapOf(), mutableListOf(
			Ability("RING_OF_MERCY", "Ring of Mercy","RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.BLESS_DURATION to MinMaxValue(3.0, 3.0),
				AbilityModifierId.COOLDOWN to MinMaxValue(20.0, 20.0),
				AbilityModifierId.HEAL to MinMaxValue(10.8, 13.2),
				AbilityModifierId.BLESS_STRENGTH to MinMaxValue(4.0, 4.0),
				AbilityModifierId.RADIUS to MinMaxValue(2.5, 2.5),
			)),
		)),
		Item("TOME_RING_OF_MERCY_5", mutableMapOf(), mutableListOf(
			Ability("RING_OF_MERCY", "Ring of Mercy","RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.BLESS_DURATION to MinMaxValue(3.0, 3.0),
				AbilityModifierId.COOLDOWN to MinMaxValue(20.0, 20.0),
				AbilityModifierId.HEAL to MinMaxValue(13.5, 16.5),
				AbilityModifierId.BLESS_STRENGTH to MinMaxValue(5.0, 5.0),
				AbilityModifierId.RADIUS to MinMaxValue(2.5, 2.5),
			)),
		)),
		Item("TOME_RING_OF_MERCY_6", mutableMapOf(), mutableListOf(
			Ability("RING_OF_MERCY", "Ring of Mercy","RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.BLESS_DURATION to MinMaxValue(3.0, 3.0),
				AbilityModifierId.COOLDOWN to MinMaxValue(20.0, 20.0),
				AbilityModifierId.HEAL to MinMaxValue(16.2, 19.8),
				AbilityModifierId.BLESS_STRENGTH to MinMaxValue(5.0, 5.0),
				AbilityModifierId.RADIUS to MinMaxValue(2.5, 2.5),
			)),
		)),

		Item("TOME_CORRUPTION_1", mutableMapOf(), mutableListOf(
			Ability("CORRUPTION", "Corruption","RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.CURSE_DURATION to MinMaxValue(5.0, 5.0),
				AbilityModifierId.DAMAGE to MinMaxValue(2.7, 3.3),
				AbilityModifierId.COOLDOWN to MinMaxValue(10.0, 10.0),
				AbilityModifierId.CURSE_STRENGTH to MinMaxValue(1.0, 1.0),
				AbilityModifierId.RADIUS to MinMaxValue(2.5, 2.5),
			)),
		)),
		Item("TOME_CORRUPTION_2", mutableMapOf(), mutableListOf(
			Ability("CORRUPTION", "Corruption","RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.CURSE_DURATION to MinMaxValue(5.0, 5.0),
				AbilityModifierId.DAMAGE to MinMaxValue(5.4, 6.6),
				AbilityModifierId.COOLDOWN to MinMaxValue(10.0, 10.0),
				AbilityModifierId.CURSE_STRENGTH to MinMaxValue(1.0, 1.0),
				AbilityModifierId.RADIUS to MinMaxValue(2.5, 2.5),
			)),
		)),
		Item("TOME_CORRUPTION_3", mutableMapOf(), mutableListOf(
			Ability("CORRUPTION", "Corruption","RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.CURSE_DURATION to MinMaxValue(5.0, 5.0),
				AbilityModifierId.DAMAGE to MinMaxValue(10.8, 13.2),
				AbilityModifierId.COOLDOWN to MinMaxValue(10.0, 10.0),
				AbilityModifierId.CURSE_STRENGTH to MinMaxValue(1.0, 1.0),
				AbilityModifierId.RADIUS to MinMaxValue(2.5, 2.5),
			)),
		)),
		Item("TOME_CORRUPTION_4", mutableMapOf(), mutableListOf(
			Ability("CORRUPTION", "Corruption","RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.CURSE_DURATION to MinMaxValue(5.0, 5.0),
				AbilityModifierId.DAMAGE to MinMaxValue(2.7, 3.3),
				AbilityModifierId.COOLDOWN to MinMaxValue(10.0, 10.0),
				AbilityModifierId.CURSE_STRENGTH to MinMaxValue(1.0, 1.0),
				AbilityModifierId.RADIUS to MinMaxValue(2.5, 2.5),
			)),
		)),
		Item("TOME_CORRUPTION_5", mutableMapOf(), mutableListOf(
			Ability("CORRUPTION", "Corruption","RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.CURSE_DURATION to MinMaxValue(5.0, 5.0),
				AbilityModifierId.DAMAGE to MinMaxValue(13.5, 16.5),
				AbilityModifierId.COOLDOWN to MinMaxValue(10.0, 10.0),
				AbilityModifierId.CURSE_STRENGTH to MinMaxValue(1.0, 1.0),
				AbilityModifierId.RADIUS to MinMaxValue(2.5, 2.5),
			)),
		)),
		Item("TOME_CORRUPTION_6", mutableMapOf(), mutableListOf(
			Ability("CORRUPTION", "Corruption","RIGHT_CLICK", mutableMapOf(
				AbilityModifierId.CURSE_DURATION to MinMaxValue(5.0, 5.0),
				AbilityModifierId.DAMAGE to MinMaxValue(16.2, 19.8),
				AbilityModifierId.COOLDOWN to MinMaxValue(10.0, 10.0),
				AbilityModifierId.CURSE_STRENGTH to MinMaxValue(1.0, 1.0),
				AbilityModifierId.RADIUS to MinMaxValue(2.5, 2.5),
			)),
		)),

		/*
			SKILL_HERBALISM("☘ Herbalism Skill", Formatting.GRAY, ValueType.FLAT),
			SKILL_ARCHAEOLOGY("☠ Archaeology Skill", Formatting.GRAY, ValueType.FLAT),
			SKILL_LOGGING("\uD83E\uDE93 Logging Skill", Formatting.GRAY, ValueType.FLAT),
			SKILL_FISHING("\uD83C\uDFA3 Fishing Skill", Formatting.GRAY, ValueType.FLAT),
			SKILL_MINING("⛏ Mining Skill", Formatting.GRAY, ValueType.FLAT),
			SKILL_RUNECARVING("ᚱ Runecarving Skill", Formatting.GRAY, ValueType.FLAT),

			SKILL_COOKING("\uD83C\uDF56 Cooking Skill", Formatting.GRAY, ValueType.FLAT),
		*/

		Item("BOTANIST_HELMET_1", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(1.9, 2.1),
			StatId.ADDITIONAL_EXPERIENCE_HERBALISM to MinMaxValue(18.0, 22.0),
		)),
		Item("BOTANIST_CHESTPLATE_1", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(7.6, 8.4),
			StatId.ADDITIONAL_EXPERIENCE_HERBALISM to MinMaxValue(18.0, 22.0),
		)),
		Item("BOTANIST_LEGGINGS_1", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(5.7, 6.3),
			StatId.ADDITIONAL_EXPERIENCE_HERBALISM to MinMaxValue(18.0, 22.0),
		)),
		Item("BOTANIST_BOOTS_1", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(1.9, 2.1),
			StatId.ADDITIONAL_EXPERIENCE_HERBALISM to MinMaxValue(18.0, 22.0),
		)),
		Item("WOODEN_HOE", mutableMapOf(
			StatId.ATTACK_DAMAGE to MinMaxValue(1.8, 2.2),
			StatId.ATTACK_SPEED to MinMaxValue(1.0, 1.0),
			StatId.CRITICAL_STRIKE_CHANCE to MinMaxValue(2.5, 2.5),

			StatId.ADDITIONAL_EXPERIENCE_HERBALISM to MinMaxValue(18.0, 22.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(2.0, 2.0),
		)),
		Item("AUGMENT_HERBALISM_1", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(2.7, 3.3),
			StatId.ADDITIONAL_EXPERIENCE_HERBALISM to MinMaxValue(10.0, 10.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(2.0, 2.0),
		)),

		Item("BOTANIST_HELMET_2", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(3.8, 4.2),
			StatId.ADDITIONAL_EXPERIENCE_HERBALISM to MinMaxValue(36.0, 44.0),
		)),
		Item("BOTANIST_CHESTPLATE_2", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(15.2, 16.8),
			StatId.ADDITIONAL_EXPERIENCE_HERBALISM to MinMaxValue(36.0, 44.0),
		)),
		Item("BOTANIST_LEGGINGS_2", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(11.4, 12.6),
			StatId.ADDITIONAL_EXPERIENCE_HERBALISM to MinMaxValue(36.0, 44.0),
		)),
		Item("BOTANIST_BOOTS_2", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(3.8, 4.2),
			StatId.ADDITIONAL_EXPERIENCE_HERBALISM to MinMaxValue(36.0, 44.0),
		)),
		Item("BRASS_HOE", mutableMapOf(
			StatId.ATTACK_DAMAGE to MinMaxValue(2.9, 3.6),
			StatId.ATTACK_SPEED to MinMaxValue(1.0, 1.0),
			StatId.CRITICAL_STRIKE_CHANCE to MinMaxValue(2.5, 2.5),

			StatId.ADDITIONAL_EXPERIENCE_HERBALISM to MinMaxValue(36.0, 44.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(4.0, 4.0),
		)),
		Item("AUGMENT_HERBALISM_2", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(5.4, 6.6),
			StatId.ADDITIONAL_EXPERIENCE_HERBALISM to MinMaxValue(20.0, 20.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(4.0, 4.0),
		)),

		Item("BOTANIST_HELMET_3", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(5.7, 6.3),
			StatId.ADDITIONAL_EXPERIENCE_HERBALISM to MinMaxValue(54.0, 66.0),
		)),
		Item("BOTANIST_CHESTPLATE_3", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(22.8, 25.2),
			StatId.ADDITIONAL_EXPERIENCE_HERBALISM to MinMaxValue(54.0, 66.0),
		)),
		Item("BOTANIST_LEGGINGS_3", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(17.1, 18.9),
			StatId.ADDITIONAL_EXPERIENCE_HERBALISM to MinMaxValue(54.0, 66.0),
		)),
		Item("BOTANIST_BOOTS_3", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(5.7, 6.3),
			StatId.ADDITIONAL_EXPERIENCE_HERBALISM to MinMaxValue(54.0, 66.0),
		)),
		Item("SKYSTEEL_HOE", mutableMapOf(
			StatId.ATTACK_DAMAGE to MinMaxValue(4.0, 5.0),
			StatId.ATTACK_SPEED to MinMaxValue(1.0, 1.0),
			StatId.CRITICAL_STRIKE_CHANCE to MinMaxValue(2.5, 2.5),

			StatId.ADDITIONAL_EXPERIENCE_HERBALISM to MinMaxValue(54.0, 66.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(6.0, 6.0),
		)),
		Item("AUGMENT_HERBALISM_3", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(8.1, 9.9),
			StatId.ADDITIONAL_EXPERIENCE_HERBALISM to MinMaxValue(30.0, 30.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(6.0, 6.0),
		)),

		Item("BOTANIST_HELMET_4", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(7.6, 8.4),
			StatId.ADDITIONAL_EXPERIENCE_HERBALISM to MinMaxValue(72.0, 88.0),
		)),
		Item("BOTANIST_CHESTPLATE_4", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(30.4, 33.6),
			StatId.ADDITIONAL_EXPERIENCE_HERBALISM to MinMaxValue(72.0, 88.0),
		)),
		Item("BOTANIST_LEGGINGS_4", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(22.8, 25.2),
			StatId.ADDITIONAL_EXPERIENCE_HERBALISM to MinMaxValue(72.0, 88.0),
		)),
		Item("BOTANIST_BOOTS_4", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(7.6, 8.4),
			StatId.ADDITIONAL_EXPERIENCE_HERBALISM to MinMaxValue(76.0, 84.0),
		)),
		Item("SHIMMERGLASS_HOE", mutableMapOf(
			StatId.ATTACK_DAMAGE to MinMaxValue(5.2, 6.4),
			StatId.ATTACK_SPEED to MinMaxValue(1.0, 1.0),
			StatId.CRITICAL_STRIKE_CHANCE to MinMaxValue(2.5, 2.5),

			StatId.ADDITIONAL_EXPERIENCE_HERBALISM to MinMaxValue(72.0, 88.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(8.0, 8.0),
		)),
		Item("AUGMENT_HERBALISM_4", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(10.8, 13.2),
			StatId.ADDITIONAL_EXPERIENCE_HERBALISM to MinMaxValue(40.0, 40.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(8.0, 8.0),
		)),

		Item("BOTANIST_HELMET_5", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(9.5, 10.5),
			StatId.ADDITIONAL_EXPERIENCE_HERBALISM to MinMaxValue(90.0, 110.0),
		)),
		Item("BOTANIST_CHESTPLATE_5", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(38.0, 42.0),
			StatId.ADDITIONAL_EXPERIENCE_HERBALISM to MinMaxValue(90.0, 110.0),
		)),
		Item("BOTANIST_LEGGINGS_5", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(28.5, 31.5),
			StatId.ADDITIONAL_EXPERIENCE_HERBALISM to MinMaxValue(90.0, 110.0),
		)),
		Item("BOTANIST_BOOTS_5", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(9.5, 10.5),
			StatId.ADDITIONAL_EXPERIENCE_HERBALISM to MinMaxValue(95.0, 105.0),
		)),
		Item("MAGISTEEL_HOE", mutableMapOf(
			StatId.ATTACK_DAMAGE to MinMaxValue(6.3, 7.7),
			StatId.ATTACK_SPEED to MinMaxValue(1.0, 1.0),
			StatId.CRITICAL_STRIKE_CHANCE to MinMaxValue(2.5, 2.5),

			StatId.ADDITIONAL_EXPERIENCE_HERBALISM to MinMaxValue(90.0, 110.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(10.0, 10.0),
		)),
		Item("AUGMENT_HERBALISM_5", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(13.5, 16.5),
			StatId.ADDITIONAL_EXPERIENCE_HERBALISM to MinMaxValue(50.0, 50.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(10.0, 108.0),
		)),



		Item("ARCHAEOLOGIST_HELMET_1", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(1.9, 2.1),
			StatId.ADDITIONAL_EXPERIENCE_ARCHAEOLOGY to MinMaxValue(18.0, 22.0),
		)),
		Item("ARCHAEOLOGIST_CHESTPLATE_1", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(7.6, 8.4),
			StatId.ADDITIONAL_EXPERIENCE_ARCHAEOLOGY to MinMaxValue(18.0, 22.0),
		)),
		Item("ARCHAEOLOGIST_LEGGINGS_1", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(5.7, 6.3),
			StatId.ADDITIONAL_EXPERIENCE_ARCHAEOLOGY to MinMaxValue(18.0, 22.0),
		)),
		Item("ARCHAEOLOGIST_BOOTS_1", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(1.9, 2.1),
			StatId.ADDITIONAL_EXPERIENCE_ARCHAEOLOGY to MinMaxValue(18.0, 22.0),
		)),
		Item("WOODEN_SHOVEL", mutableMapOf(
			StatId.ATTACK_DAMAGE to MinMaxValue(1.8, 2.2),
			StatId.ATTACK_SPEED to MinMaxValue(1.0, 1.0),
			StatId.CRITICAL_STRIKE_CHANCE to MinMaxValue(2.5, 2.5),

			StatId.ADDITIONAL_EXPERIENCE_ARCHAEOLOGY to MinMaxValue(18.0, 22.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(2.0, 2.0),
		)),
		Item("AUGMENT_ARCHAEOLOGY_1", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(2.7, 3.3),
			StatId.ADDITIONAL_EXPERIENCE_ARCHAEOLOGY to MinMaxValue(10.0, 10.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(2.0, 2.0),
		)),

		Item("ARCHAEOLOGIST_HELMET_2", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(3.8, 4.2),
			StatId.ADDITIONAL_EXPERIENCE_ARCHAEOLOGY to MinMaxValue(36.0, 44.0),
		)),
		Item("ARCHAEOLOGIST_CHESTPLATE_2", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(15.2, 16.8),
			StatId.ADDITIONAL_EXPERIENCE_ARCHAEOLOGY to MinMaxValue(36.0, 44.0),
		)),
		Item("ARCHAEOLOGIST_LEGGINGS_2", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(11.4, 12.6),
			StatId.ADDITIONAL_EXPERIENCE_ARCHAEOLOGY to MinMaxValue(36.0, 44.0),
		)),
		Item("ARCHAEOLOGIST_BOOTS_2", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(3.8, 4.2),
			StatId.ADDITIONAL_EXPERIENCE_ARCHAEOLOGY to MinMaxValue(36.0, 44.0),
		)),
		Item("BRASS_SHOVEL", mutableMapOf(
			StatId.ATTACK_DAMAGE to MinMaxValue(2.9, 3.6),
			StatId.ATTACK_SPEED to MinMaxValue(1.0, 1.0),
			StatId.CRITICAL_STRIKE_CHANCE to MinMaxValue(2.5, 2.5),

			StatId.ADDITIONAL_EXPERIENCE_ARCHAEOLOGY to MinMaxValue(36.0, 44.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(4.0, 4.0),
		)),
		Item("AUGMENT_ARCHAEOLOGY_2", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(5.4, 6.6),
			StatId.ADDITIONAL_EXPERIENCE_ARCHAEOLOGY to MinMaxValue(20.0, 20.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(4.0, 4.0),
		)),

		Item("ARCHAEOLOGIST_HELMET_3", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(5.7, 6.3),
			StatId.ADDITIONAL_EXPERIENCE_ARCHAEOLOGY to MinMaxValue(54.0, 66.0),
		)),
		Item("ARCHAEOLOGIST_CHESTPLATE_3", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(22.8, 25.2),
			StatId.ADDITIONAL_EXPERIENCE_ARCHAEOLOGY to MinMaxValue(54.0, 66.0),
		)),
		Item("ARCHAEOLOGIST_LEGGINGS_3", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(17.1, 18.9),
			StatId.ADDITIONAL_EXPERIENCE_ARCHAEOLOGY to MinMaxValue(54.0, 66.0),
		)),
		Item("ARCHAEOLOGIST_BOOTS_3", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(5.7, 6.3),
			StatId.ADDITIONAL_EXPERIENCE_ARCHAEOLOGY to MinMaxValue(54.0, 66.0),
		)),
		Item("SKYSTEEL_SHOVEL", mutableMapOf(
			StatId.ATTACK_DAMAGE to MinMaxValue(4.0, 5.0),
			StatId.ATTACK_SPEED to MinMaxValue(1.0, 1.0),
			StatId.CRITICAL_STRIKE_CHANCE to MinMaxValue(2.5, 2.5),

			StatId.ADDITIONAL_EXPERIENCE_ARCHAEOLOGY to MinMaxValue(54.0, 66.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(6.0, 6.0),
		)),
		Item("AUGMENT_ARCHAEOLOGY_3", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(8.1, 9.9),
			StatId.ADDITIONAL_EXPERIENCE_ARCHAEOLOGY to MinMaxValue(30.0, 30.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(6.0, 6.0),
		)),

		Item("ARCHAEOLOGIST_HELMET_4", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(7.6, 8.4),
			StatId.ADDITIONAL_EXPERIENCE_ARCHAEOLOGY to MinMaxValue(72.0, 88.0),
		)),
		Item("ARCHAEOLOGIST_CHESTPLATE_4", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(30.4, 33.6),
			StatId.ADDITIONAL_EXPERIENCE_ARCHAEOLOGY to MinMaxValue(72.0, 88.0),
		)),
		Item("ARCHAEOLOGIST_LEGGINGS_4", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(22.8, 25.2),
			StatId.ADDITIONAL_EXPERIENCE_ARCHAEOLOGY to MinMaxValue(72.0, 88.0),
		)),
		Item("ARCHAEOLOGIST_BOOTS_4", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(7.6, 8.4),
			StatId.ADDITIONAL_EXPERIENCE_ARCHAEOLOGY to MinMaxValue(76.0, 84.0),
		)),
		Item("SHIMMERGLASS_SHOVEL", mutableMapOf(
			StatId.ATTACK_DAMAGE to MinMaxValue(5.2, 6.4),
			StatId.ATTACK_SPEED to MinMaxValue(1.0, 1.0),
			StatId.CRITICAL_STRIKE_CHANCE to MinMaxValue(2.5, 2.5),

			StatId.ADDITIONAL_EXPERIENCE_ARCHAEOLOGY to MinMaxValue(72.0, 88.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(8.0, 8.0),
		)),
		Item("AUGMENT_ARCHAEOLOGY_4", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(10.8, 13.2),
			StatId.ADDITIONAL_EXPERIENCE_ARCHAEOLOGY to MinMaxValue(40.0, 40.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(8.0, 8.0),
		)),

		Item("ARCHAEOLOGIST_HELMET_5", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(9.5, 10.5),
			StatId.ADDITIONAL_EXPERIENCE_ARCHAEOLOGY to MinMaxValue(90.0, 110.0),
		)),
		Item("ARCHAEOLOGIST_CHESTPLATE_5", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(38.0, 42.0),
			StatId.ADDITIONAL_EXPERIENCE_ARCHAEOLOGY to MinMaxValue(90.0, 110.0),
		)),
		Item("ARCHAEOLOGIST_LEGGINGS_5", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(28.5, 31.5),
			StatId.ADDITIONAL_EXPERIENCE_ARCHAEOLOGY to MinMaxValue(90.0, 110.0),
		)),
		Item("ARCHAEOLOGIST_BOOTS_5", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(9.5, 10.5),
			StatId.ADDITIONAL_EXPERIENCE_ARCHAEOLOGY to MinMaxValue(95.0, 105.0),
		)),
		Item("MAGISTEEL_SHOVEL", mutableMapOf(
			StatId.ATTACK_DAMAGE to MinMaxValue(6.3, 7.7),
			StatId.ATTACK_SPEED to MinMaxValue(1.0, 1.0),
			StatId.CRITICAL_STRIKE_CHANCE to MinMaxValue(2.5, 2.5),

			StatId.ADDITIONAL_EXPERIENCE_ARCHAEOLOGY to MinMaxValue(90.0, 110.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(10.0, 10.0),
		)),
		Item("AUGMENT_ARCHAEOLOGY_5", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(13.5, 16.5),
			StatId.ADDITIONAL_EXPERIENCE_ARCHAEOLOGY to MinMaxValue(50.0, 50.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(10.0, 108.0),
		)),



		Item("LUMBERJACK_HELMET_1", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(1.9, 2.1),
			StatId.ADDITIONAL_EXPERIENCE_LOGGING to MinMaxValue(18.0, 22.0),
		)),
		Item("LUMBERJACK_CHESTPLATE_1", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(7.6, 8.4),
			StatId.ADDITIONAL_EXPERIENCE_LOGGING to MinMaxValue(18.0, 22.0),
		)),
		Item("LUMBERJACK_LEGGINGS_1", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(5.7, 6.3),
			StatId.ADDITIONAL_EXPERIENCE_LOGGING to MinMaxValue(18.0, 22.0),
		)),
		Item("LUMBERJACK_BOOTS_1", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(1.9, 2.1),
			StatId.ADDITIONAL_EXPERIENCE_LOGGING to MinMaxValue(18.0, 22.0),
		)),
		Item("WOODEN_AXE", mutableMapOf(
			StatId.ATTACK_DAMAGE to MinMaxValue(1.8, 2.2),
			StatId.ATTACK_SPEED to MinMaxValue(1.0, 1.0),
			StatId.CRITICAL_STRIKE_CHANCE to MinMaxValue(2.5, 2.5),

			StatId.ADDITIONAL_EXPERIENCE_LOGGING to MinMaxValue(18.0, 22.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(2.0, 2.0),
		)),
		Item("AUGMENT_LOGGING_1", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(2.7, 3.3),
			StatId.ADDITIONAL_EXPERIENCE_LOGGING to MinMaxValue(10.0, 10.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(2.0, 2.0),
		)),

		Item("LUMBERJACK_HELMET_2", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(3.8, 4.2),
			StatId.ADDITIONAL_EXPERIENCE_LOGGING to MinMaxValue(36.0, 44.0),
		)),
		Item("LUMBERJACK_CHESTPLATE_2", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(15.2, 16.8),
			StatId.ADDITIONAL_EXPERIENCE_LOGGING to MinMaxValue(36.0, 44.0),
		)),
		Item("LUMBERJACK_LEGGINGS_2", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(11.4, 12.6),
			StatId.ADDITIONAL_EXPERIENCE_LOGGING to MinMaxValue(36.0, 44.0),
		)),
		Item("LUMBERJACK_BOOTS_2", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(3.8, 4.2),
			StatId.ADDITIONAL_EXPERIENCE_LOGGING to MinMaxValue(36.0, 44.0),
		)),
		Item("BRASS_AXE", mutableMapOf(
			StatId.ATTACK_DAMAGE to MinMaxValue(2.9, 3.6),
			StatId.ATTACK_SPEED to MinMaxValue(1.0, 1.0),
			StatId.CRITICAL_STRIKE_CHANCE to MinMaxValue(2.5, 2.5),

			StatId.ADDITIONAL_EXPERIENCE_LOGGING to MinMaxValue(36.0, 44.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(4.0, 4.0),
		)),
		Item("AUGMENT_LOGGING_2", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(5.4, 6.6),
			StatId.ADDITIONAL_EXPERIENCE_LOGGING to MinMaxValue(20.0, 20.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(4.0, 4.0),
		)),

		Item("LUMBERJACK_HELMET_3", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(5.7, 6.3),
			StatId.ADDITIONAL_EXPERIENCE_LOGGING to MinMaxValue(54.0, 66.0),
		)),
		Item("LUMBERJACK_CHESTPLATE_3", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(22.8, 25.2),
			StatId.ADDITIONAL_EXPERIENCE_LOGGING to MinMaxValue(54.0, 66.0),
		)),
		Item("LUMBERJACK_LEGGINGS_3", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(17.1, 18.9),
			StatId.ADDITIONAL_EXPERIENCE_LOGGING to MinMaxValue(54.0, 66.0),
		)),
		Item("LUMBERJACK_BOOTS_3", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(5.7, 6.3),
			StatId.ADDITIONAL_EXPERIENCE_LOGGING to MinMaxValue(54.0, 66.0),
		)),
		Item("SKYSTEEL_AXE", mutableMapOf(
			StatId.ATTACK_DAMAGE to MinMaxValue(4.0, 5.0),
			StatId.ATTACK_SPEED to MinMaxValue(1.0, 1.0),
			StatId.CRITICAL_STRIKE_CHANCE to MinMaxValue(2.5, 2.5),

			StatId.ADDITIONAL_EXPERIENCE_LOGGING to MinMaxValue(54.0, 66.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(6.0, 6.0),
		)),
		Item("AUGMENT_LOGGING_3", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(8.1, 9.9),
			StatId.ADDITIONAL_EXPERIENCE_LOGGING to MinMaxValue(30.0, 30.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(6.0, 6.0),
		)),

		Item("LUMBERJACK_HELMET_4", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(7.6, 8.4),
			StatId.ADDITIONAL_EXPERIENCE_LOGGING to MinMaxValue(72.0, 88.0),
		)),
		Item("LUMBERJACK_CHESTPLATE_4", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(30.4, 33.6),
			StatId.ADDITIONAL_EXPERIENCE_LOGGING to MinMaxValue(72.0, 88.0),
		)),
		Item("LUMBERJACK_LEGGINGS_4", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(22.8, 25.2),
			StatId.ADDITIONAL_EXPERIENCE_LOGGING to MinMaxValue(72.0, 88.0),
		)),
		Item("LUMBERJACK_BOOTS_4", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(7.6, 8.4),
			StatId.ADDITIONAL_EXPERIENCE_LOGGING to MinMaxValue(76.0, 84.0),
		)),
		Item("SHIMMERGLASS_AXE", mutableMapOf(
			StatId.ATTACK_DAMAGE to MinMaxValue(5.2, 6.4),
			StatId.ATTACK_SPEED to MinMaxValue(1.0, 1.0),
			StatId.CRITICAL_STRIKE_CHANCE to MinMaxValue(2.5, 2.5),

			StatId.ADDITIONAL_EXPERIENCE_LOGGING to MinMaxValue(72.0, 88.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(8.0, 8.0),
		)),
		Item("AUGMENT_LOGGING_4", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(10.8, 13.2),
			StatId.ADDITIONAL_EXPERIENCE_LOGGING to MinMaxValue(40.0, 40.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(8.0, 8.0),
		)),

		Item("LUMBERJACK_HELMET_5", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(9.5, 10.5),
			StatId.ADDITIONAL_EXPERIENCE_LOGGING to MinMaxValue(90.0, 110.0),
		)),
		Item("LUMBERJACK_CHESTPLATE_5", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(38.0, 42.0),
			StatId.ADDITIONAL_EXPERIENCE_LOGGING to MinMaxValue(90.0, 110.0),
		)),
		Item("LUMBERJACK_LEGGINGS_5", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(28.5, 31.5),
			StatId.ADDITIONAL_EXPERIENCE_LOGGING to MinMaxValue(90.0, 110.0),
		)),
		Item("LUMBERJACK_BOOTS_5", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(9.5, 10.5),
			StatId.ADDITIONAL_EXPERIENCE_LOGGING to MinMaxValue(95.0, 105.0),
		)),
		Item("MAGISTEEL_AXE", mutableMapOf(
			StatId.ATTACK_DAMAGE to MinMaxValue(6.3, 7.7),
			StatId.ATTACK_SPEED to MinMaxValue(1.0, 1.0),
			StatId.CRITICAL_STRIKE_CHANCE to MinMaxValue(2.5, 2.5),

			StatId.ADDITIONAL_EXPERIENCE_LOGGING to MinMaxValue(90.0, 110.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(10.0, 10.0),
		)),
		Item("AUGMENT_LOGGING_5", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(13.5, 16.5),
			StatId.ADDITIONAL_EXPERIENCE_LOGGING to MinMaxValue(50.0, 50.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(10.0, 108.0),
		)),



		Item("FISHERMAN_HELMET_1", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(1.9, 2.1),
			StatId.ADDITIONAL_EXPERIENCE_FISHING to MinMaxValue(18.0, 22.0),
		)),
		Item("FISHERMAN_CHESTPLATE_1", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(7.6, 8.4),
			StatId.ADDITIONAL_EXPERIENCE_FISHING to MinMaxValue(18.0, 22.0),
		)),
		Item("FISHERMAN_LEGGINGS_1", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(5.7, 6.3),
			StatId.ADDITIONAL_EXPERIENCE_FISHING to MinMaxValue(18.0, 22.0),
		)),
		Item("FISHERMAN_BOOTS_1", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(1.9, 2.1),
			StatId.ADDITIONAL_EXPERIENCE_FISHING to MinMaxValue(18.0, 22.0),
		)),
		Item("STRONG_FISHINGPOLE", mutableMapOf(
			StatId.ATTACK_DAMAGE to MinMaxValue(2.2, 2.8),
			StatId.ATTACK_SPEED to MinMaxValue(1.0, 1.0),
			StatId.CRITICAL_STRIKE_CHANCE to MinMaxValue(2.5, 2.5),

			StatId.CRITICAL_FISHING_CHANCE to MinMaxValue(0.9, 1.1),
			StatId.ADDITIONAL_EXPERIENCE_FISHING to MinMaxValue(18.0, 22.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(2.0, 2.0),
		)),
		Item("AUGMENT_FISHING_1", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(2.7, 3.3),
			StatId.ADDITIONAL_EXPERIENCE_FISHING to MinMaxValue(10.0, 10.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(2.0, 2.0),
		)),

		Item("FISHERMAN_HELMET_2", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(3.8, 4.2),
			StatId.ADDITIONAL_EXPERIENCE_FISHING to MinMaxValue(36.0, 44.0),
		)),
		Item("FISHERMAN_CHESTPLATE_2", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(15.2, 16.8),
			StatId.ADDITIONAL_EXPERIENCE_FISHING to MinMaxValue(36.0, 44.0),
		)),
		Item("FISHERMAN_LEGGINGS_2", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(11.4, 12.6),
			StatId.ADDITIONAL_EXPERIENCE_FISHING to MinMaxValue(36.0, 44.0),
		)),
		Item("FISHERMAN_BOOTS_2", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(3.8, 4.2),
			StatId.ADDITIONAL_EXPERIENCE_FISHING to MinMaxValue(36.0, 44.0),
		)),
		Item("BRASS_FISHINGPOLE", mutableMapOf(
			StatId.ATTACK_DAMAGE to MinMaxValue(2.2, 2.8),
			StatId.ATTACK_SPEED to MinMaxValue(1.0, 1.0),
			StatId.CRITICAL_STRIKE_CHANCE to MinMaxValue(2.5, 2.5),

			StatId.CRITICAL_FISHING_CHANCE to MinMaxValue(1.8, 2.2),
			StatId.ADDITIONAL_EXPERIENCE_FISHING to MinMaxValue(36.0, 44.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(4.0, 4.0),
		)),
		Item("AUGMENT_FISHING_2", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(5.4, 6.6),
			StatId.ADDITIONAL_EXPERIENCE_FISHING to MinMaxValue(20.0, 20.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(4.0, 4.0),
		)),

		Item("FISHERMAN_HELMET_3", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(5.7, 6.3),
			StatId.ADDITIONAL_EXPERIENCE_FISHING to MinMaxValue(54.0, 66.0),
		)),
		Item("FISHERMAN_CHESTPLATE_3", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(22.8, 25.2),
			StatId.ADDITIONAL_EXPERIENCE_FISHING to MinMaxValue(54.0, 66.0),
		)),
		Item("FISHERMAN_LEGGINGS_3", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(17.1, 18.9),
			StatId.ADDITIONAL_EXPERIENCE_FISHING to MinMaxValue(54.0, 66.0),
		)),
		Item("FISHERMAN_BOOTS_3", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(5.7, 6.3),
			StatId.ADDITIONAL_EXPERIENCE_FISHING to MinMaxValue(54.0, 66.0),
		)),
		Item("SKYSTEEL_FISHINGPOLE", mutableMapOf(
			StatId.ATTACK_DAMAGE to MinMaxValue(2.2, 2.8),
			StatId.ATTACK_SPEED to MinMaxValue(1.0, 1.0),
			StatId.CRITICAL_STRIKE_CHANCE to MinMaxValue(2.5, 2.5),

			StatId.CRITICAL_FISHING_CHANCE to MinMaxValue(2.7, 3.3),
			StatId.ADDITIONAL_EXPERIENCE_FISHING to MinMaxValue(54.0, 66.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(6.0, 6.0),
		)),
		Item("AUGMENT_FISHING_3", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(8.1, 9.9),
			StatId.ADDITIONAL_EXPERIENCE_FISHING to MinMaxValue(30.0, 30.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(6.0, 6.0),
		)),

		Item("FISHERMAN_HELMET_4", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(7.6, 8.4),
			StatId.ADDITIONAL_EXPERIENCE_FISHING to MinMaxValue(72.0, 88.0),
		)),
		Item("FISHERMAN_CHESTPLATE_4", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(30.4, 33.6),
			StatId.ADDITIONAL_EXPERIENCE_FISHING to MinMaxValue(72.0, 88.0),
		)),
		Item("FISHERMAN_LEGGINGS_4", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(22.8, 25.2),
			StatId.ADDITIONAL_EXPERIENCE_FISHING to MinMaxValue(72.0, 88.0),
		)),
		Item("FISHERMAN_BOOTS_4", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(7.6, 8.4),
			StatId.ADDITIONAL_EXPERIENCE_FISHING to MinMaxValue(76.0, 84.0),
		)),
		Item("SHIMMERGLASS_FISHINGPOLE", mutableMapOf(
			StatId.ATTACK_DAMAGE to MinMaxValue(2.2, 2.8),
			StatId.ATTACK_SPEED to MinMaxValue(1.0, 1.0),
			StatId.CRITICAL_STRIKE_CHANCE to MinMaxValue(2.5, 2.5),

			StatId.CRITICAL_FISHING_CHANCE to MinMaxValue(3.6, 4.4),
			StatId.ADDITIONAL_EXPERIENCE_FISHING to MinMaxValue(72.0, 88.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(8.0, 8.0),
		)),
		Item("AUGMENT_FISHING_4", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(10.8, 13.2),
			StatId.ADDITIONAL_EXPERIENCE_FISHING to MinMaxValue(40.0, 40.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(8.0, 8.0),
		)),

		Item("FISHERMAN_HELMET_5", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(9.5, 10.5),
			StatId.ADDITIONAL_EXPERIENCE_FISHING to MinMaxValue(90.0, 110.0),
		)),
		Item("FISHERMAN_CHESTPLATE_5", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(38.0, 42.0),
			StatId.ADDITIONAL_EXPERIENCE_FISHING to MinMaxValue(90.0, 110.0),
		)),
		Item("FISHERMAN_LEGGINGS_5", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(28.5, 31.5),
			StatId.ADDITIONAL_EXPERIENCE_FISHING to MinMaxValue(90.0, 110.0),
		)),
		Item("FISHERMAN_BOOTS_5", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(9.5, 10.5),
			StatId.ADDITIONAL_EXPERIENCE_FISHING to MinMaxValue(95.0, 105.0),
		)),
		Item("MAGISTEEL_FISHINGPOLE", mutableMapOf(
			StatId.ATTACK_DAMAGE to MinMaxValue(2.2, 2.8),
			StatId.ATTACK_SPEED to MinMaxValue(1.0, 1.0),
			StatId.CRITICAL_STRIKE_CHANCE to MinMaxValue(2.5, 2.5),

			StatId.CRITICAL_FISHING_CHANCE to MinMaxValue(4.5, 5.5),
			StatId.ADDITIONAL_EXPERIENCE_FISHING to MinMaxValue(90.0, 110.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(10.0, 10.0),
		)),
		Item("AUGMENT_FISHING_5", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(13.5, 16.5),
			StatId.ADDITIONAL_EXPERIENCE_FISHING to MinMaxValue(50.0, 50.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(10.0, 108.0),
		)),



		Item("MINER_HELMET_1", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(1.9, 2.1),
			StatId.ADDITIONAL_EXPERIENCE_MINING to MinMaxValue(18.0, 22.0),
		)),
		Item("MINER_CHESTPLATE_1", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(7.6, 8.4),
			StatId.ADDITIONAL_EXPERIENCE_MINING to MinMaxValue(18.0, 22.0),
		)),
		Item("MINER_LEGGINGS_1", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(5.7, 6.3),
			StatId.ADDITIONAL_EXPERIENCE_MINING to MinMaxValue(18.0, 22.0),
		)),
		Item("MINER_BOOTS_1", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(1.9, 2.1),
			StatId.ADDITIONAL_EXPERIENCE_MINING to MinMaxValue(18.0, 22.0),
		)),
		Item("WOODEN_PICKAXE", mutableMapOf(
			StatId.ATTACK_DAMAGE to MinMaxValue(1.8, 2.2),
			StatId.ATTACK_SPEED to MinMaxValue(1.0, 1.0),
			StatId.CRITICAL_STRIKE_CHANCE to MinMaxValue(2.5, 2.5),

			StatId.ADDITIONAL_EXPERIENCE_MINING to MinMaxValue(18.0, 22.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(2.0, 2.0),
		)),
		Item("AUGMENT_MINING_1", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(2.7, 3.3),
			StatId.ADDITIONAL_EXPERIENCE_MINING to MinMaxValue(10.0, 10.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(2.0, 2.0),
		)),

		Item("MINER_HELMET_2", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(3.8, 4.2),
			StatId.ADDITIONAL_EXPERIENCE_MINING to MinMaxValue(36.0, 44.0),
		)),
		Item("MINER_CHESTPLATE_2", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(15.2, 16.8),
			StatId.ADDITIONAL_EXPERIENCE_MINING to MinMaxValue(36.0, 44.0),
		)),
		Item("MINER_LEGGINGS_2", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(11.4, 12.6),
			StatId.ADDITIONAL_EXPERIENCE_MINING to MinMaxValue(36.0, 44.0),
		)),
		Item("MINER_BOOTS_2", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(3.8, 4.2),
			StatId.ADDITIONAL_EXPERIENCE_MINING to MinMaxValue(36.0, 44.0),
		)),
		Item("BRASS_PICKAXE", mutableMapOf(
			StatId.ATTACK_DAMAGE to MinMaxValue(2.9, 3.6),
			StatId.ATTACK_SPEED to MinMaxValue(1.0, 1.0),
			StatId.CRITICAL_STRIKE_CHANCE to MinMaxValue(2.5, 2.5),

			StatId.ADDITIONAL_EXPERIENCE_MINING to MinMaxValue(36.0, 44.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(4.0, 4.0),
		)),
		Item("AUGMENT_FISHING_2", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(5.4, 6.6),
			StatId.ADDITIONAL_EXPERIENCE_MINING to MinMaxValue(20.0, 20.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(4.0, 4.0),
		)),

		Item("MINER_HELMET_3", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(5.7, 6.3),
			StatId.ADDITIONAL_EXPERIENCE_MINING to MinMaxValue(54.0, 66.0),
		)),
		Item("MINER_CHESTPLATE_3", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(22.8, 25.2),
			StatId.ADDITIONAL_EXPERIENCE_MINING to MinMaxValue(54.0, 66.0),
		)),
		Item("MINER_LEGGINGS_3", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(17.1, 18.9),
			StatId.ADDITIONAL_EXPERIENCE_MINING to MinMaxValue(54.0, 66.0),
		)),
		Item("MINER_BOOTS_3", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(5.7, 6.3),
			StatId.ADDITIONAL_EXPERIENCE_MINING to MinMaxValue(54.0, 66.0),
		)),
		Item("SKYSTEEL_PICKAXE", mutableMapOf(
			StatId.ATTACK_DAMAGE to MinMaxValue(4.0, 5.0),
			StatId.ATTACK_SPEED to MinMaxValue(1.0, 1.0),
			StatId.CRITICAL_STRIKE_CHANCE to MinMaxValue(2.5, 2.5),

			StatId.ADDITIONAL_EXPERIENCE_MINING to MinMaxValue(54.0, 66.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(6.0, 6.0),
		)),
		Item("AUGMENT_FISHING_3", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(8.1, 9.9),
			StatId.ADDITIONAL_EXPERIENCE_MINING to MinMaxValue(30.0, 30.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(6.0, 6.0),
		)),

		Item("MINER_HELMET_4", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(7.6, 8.4),
			StatId.ADDITIONAL_EXPERIENCE_MINING to MinMaxValue(72.0, 88.0),
		)),
		Item("MINER_CHESTPLATE_4", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(30.4, 33.6),
			StatId.ADDITIONAL_EXPERIENCE_MINING to MinMaxValue(72.0, 88.0),
		)),
		Item("MINER_LEGGINGS_4", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(22.8, 25.2),
			StatId.ADDITIONAL_EXPERIENCE_MINING to MinMaxValue(72.0, 88.0),
		)),
		Item("MINER_BOOTS_4", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(7.6, 8.4),
			StatId.ADDITIONAL_EXPERIENCE_MINING to MinMaxValue(76.0, 84.0),
		)),
		Item("SHIMMERGLASS_PICKAXE", mutableMapOf(
			StatId.ATTACK_DAMAGE to MinMaxValue(5.2, 6.4),
			StatId.ATTACK_SPEED to MinMaxValue(1.0, 1.0),
			StatId.CRITICAL_STRIKE_CHANCE to MinMaxValue(2.5, 2.5),

			StatId.ADDITIONAL_EXPERIENCE_MINING to MinMaxValue(72.0, 88.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(8.0, 8.0),
		)),
		Item("AUGMENT_FISHING_4", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(10.8, 13.2),
			StatId.ADDITIONAL_EXPERIENCE_MINING to MinMaxValue(40.0, 40.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(8.0, 8.0),
		)),

		Item("MINER_HELMET_5", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(9.5, 10.5),
			StatId.ADDITIONAL_EXPERIENCE_MINING to MinMaxValue(90.0, 110.0),
		)),
		Item("MINER_CHESTPLATE_5", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(38.0, 42.0),
			StatId.ADDITIONAL_EXPERIENCE_MINING to MinMaxValue(90.0, 110.0),
		)),
		Item("MINER_LEGGINGS_5", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(28.5, 31.5),
			StatId.ADDITIONAL_EXPERIENCE_MINING to MinMaxValue(90.0, 110.0),
		)),
		Item("MINER_BOOTS_5", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(9.5, 10.5),
			StatId.ADDITIONAL_EXPERIENCE_MINING to MinMaxValue(95.0, 105.0),
		)),
		Item("MAGISTEEL_PICKAXE", mutableMapOf(
			StatId.ATTACK_DAMAGE to MinMaxValue(6.3, 7.7),
			StatId.ATTACK_SPEED to MinMaxValue(1.0, 1.0),
			StatId.CRITICAL_STRIKE_CHANCE to MinMaxValue(2.5, 2.5),

			StatId.ADDITIONAL_EXPERIENCE_MINING to MinMaxValue(90.0, 110.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(10.0, 10.0),
		)),
		Item("AUGMENT_FISHING_5", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(13.5, 16.5),
			StatId.ADDITIONAL_EXPERIENCE_MINING to MinMaxValue(50.0, 50.0),
			StatId.SKILL_ARCHAEOLOGY to MinMaxValue(10.0, 108.0),
		)),



		Item("RUNECARVER_HELMET_1", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(1.9, 2.1),
			StatId.ADDITIONAL_EXPERIENCE_RUNECARVING to MinMaxValue(18.0, 22.0),
		)),
		Item("RUNECARVER_CHESTPLATE_1", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(7.6, 8.4),
			StatId.ADDITIONAL_EXPERIENCE_RUNECARVING to MinMaxValue(18.0, 22.0),
		)),
		Item("RUNECARVER_LEGGINGS_1", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(5.7, 6.3),
			StatId.ADDITIONAL_EXPERIENCE_RUNECARVING to MinMaxValue(18.0, 22.0),
		)),
		Item("RUNECARVER_BOOTS_1", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(1.9, 2.1),
			StatId.ADDITIONAL_EXPERIENCE_RUNECARVING to MinMaxValue(18.0, 22.0),
		)),

		Item("RUNECARVER_HELMET_2", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(3.8, 4.2),
			StatId.ADDITIONAL_EXPERIENCE_RUNECARVING to MinMaxValue(36.0, 44.0),
		)),
		Item("RUNECARVER_CHESTPLATE_2", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(15.2, 16.8),
			StatId.ADDITIONAL_EXPERIENCE_RUNECARVING to MinMaxValue(36.0, 44.0),
		)),
		Item("RUNECARVER_LEGGINGS_2", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(11.4, 12.6),
			StatId.ADDITIONAL_EXPERIENCE_RUNECARVING to MinMaxValue(36.0, 44.0),
		)),
		Item("RUNECARVER_BOOTS_2", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(3.8, 4.2),
			StatId.ADDITIONAL_EXPERIENCE_RUNECARVING to MinMaxValue(36.0, 44.0),
		)),

		Item("RUNECARVER_HELMET_3", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(5.7, 6.3),
			StatId.ADDITIONAL_EXPERIENCE_RUNECARVING to MinMaxValue(54.0, 66.0),
		)),
		Item("RUNECARVER_CHESTPLATE_3", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(22.8, 25.2),
			StatId.ADDITIONAL_EXPERIENCE_RUNECARVING to MinMaxValue(54.0, 66.0),
		)),
		Item("RUNECARVER_LEGGINGS_3", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(17.1, 18.9),
			StatId.ADDITIONAL_EXPERIENCE_RUNECARVING to MinMaxValue(54.0, 66.0),
		)),
		Item("RUNECARVER_BOOTS_3", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(5.7, 6.3),
			StatId.ADDITIONAL_EXPERIENCE_RUNECARVING to MinMaxValue(54.0, 66.0),
		)),

		Item("RUNECARVER_HELMET_4", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(7.6, 8.4),
			StatId.ADDITIONAL_EXPERIENCE_RUNECARVING to MinMaxValue(72.0, 88.0),
		)),
		Item("RUNECARVER_CHESTPLATE_4", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(30.4, 33.6),
			StatId.ADDITIONAL_EXPERIENCE_RUNECARVING to MinMaxValue(72.0, 88.0),
		)),
		Item("RUNECARVER_LEGGINGS_4", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(22.8, 25.2),
			StatId.ADDITIONAL_EXPERIENCE_RUNECARVING to MinMaxValue(72.0, 88.0),
		)),
		Item("RUNECARVER_BOOTS_4", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(7.6, 8.4),
			StatId.ADDITIONAL_EXPERIENCE_RUNECARVING to MinMaxValue(76.0, 84.0),
		)),

		Item("RUNECARVER_HELMET_5", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(9.5, 10.5),
			StatId.ADDITIONAL_EXPERIENCE_RUNECARVING to MinMaxValue(90.0, 110.0),
		)),
		Item("RUNECARVER_CHESTPLATE_5", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(38.0, 42.0),
			StatId.ADDITIONAL_EXPERIENCE_RUNECARVING to MinMaxValue(90.0, 110.0),
		)),
		Item("RUNECARVER_LEGGINGS_5", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(28.5, 31.5),
			StatId.ADDITIONAL_EXPERIENCE_RUNECARVING to MinMaxValue(90.0, 110.0),
		)),
		Item("RUNECARVER_BOOTS_5", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(9.5, 10.5),
			StatId.ADDITIONAL_EXPERIENCE_RUNECARVING to MinMaxValue(95.0, 105.0),
		)),



		Item("CHEF_HELMET_1", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(1.9, 2.1),
			StatId.ADDITIONAL_EXPERIENCE_COOKING to MinMaxValue(18.0, 22.0),
		)),
		Item("CHEF_CHESTPLATE_1", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(7.6, 8.4),
			StatId.ADDITIONAL_EXPERIENCE_COOKING to MinMaxValue(18.0, 22.0),
		)),
		Item("CHEF_LEGGINGS_1", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(5.7, 6.3),
			StatId.ADDITIONAL_EXPERIENCE_COOKING to MinMaxValue(18.0, 22.0),
		)),
		Item("CHEF_BOOTS_1", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(1.9, 2.1),
			StatId.ADDITIONAL_EXPERIENCE_COOKING to MinMaxValue(18.0, 22.0),
		)),

		Item("CHEF_HELMET_2", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(3.8, 4.2),
			StatId.ADDITIONAL_EXPERIENCE_COOKING to MinMaxValue(36.0, 44.0),
		)),
		Item("CHEF_CHESTPLATE_2", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(15.2, 16.8),
			StatId.ADDITIONAL_EXPERIENCE_COOKING to MinMaxValue(36.0, 44.0),
		)),
		Item("CHEF_LEGGINGS_2", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(11.4, 12.6),
			StatId.ADDITIONAL_EXPERIENCE_COOKING to MinMaxValue(36.0, 44.0),
		)),
		Item("CHEF_BOOTS_2", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(3.8, 4.2),
			StatId.ADDITIONAL_EXPERIENCE_COOKING to MinMaxValue(36.0, 44.0),
		)),

		Item("CHEF_HELMET_3", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(5.7, 6.3),
			StatId.ADDITIONAL_EXPERIENCE_COOKING to MinMaxValue(54.0, 66.0),
		)),
		Item("CHEF_CHESTPLATE_3", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(22.8, 25.2),
			StatId.ADDITIONAL_EXPERIENCE_COOKING to MinMaxValue(54.0, 66.0),
		)),
		Item("CHEF_LEGGINGS_3", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(17.1, 18.9),
			StatId.ADDITIONAL_EXPERIENCE_COOKING to MinMaxValue(54.0, 66.0),
		)),
		Item("CHEF_BOOTS_3", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(5.7, 6.3),
			StatId.ADDITIONAL_EXPERIENCE_COOKING to MinMaxValue(54.0, 66.0),
		)),

		Item("CHEF_HELMET_4", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(7.6, 8.4),
			StatId.ADDITIONAL_EXPERIENCE_COOKING to MinMaxValue(72.0, 88.0),
		)),
		Item("CHEF_CHESTPLATE_4", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(30.4, 33.6),
			StatId.ADDITIONAL_EXPERIENCE_COOKING to MinMaxValue(72.0, 88.0),
		)),
		Item("CHEF_LEGGINGS_4", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(22.8, 25.2),
			StatId.ADDITIONAL_EXPERIENCE_COOKING to MinMaxValue(72.0, 88.0),
		)),
		Item("CHEF_BOOTS_4", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(7.6, 8.4),
			StatId.ADDITIONAL_EXPERIENCE_COOKING to MinMaxValue(76.0, 84.0),
		)),

		Item("CHEF_HELMET_5", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(9.5, 10.5),
			StatId.ADDITIONAL_EXPERIENCE_COOKING to MinMaxValue(90.0, 110.0),
		)),
		Item("CHEF_CHESTPLATE_5", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(38.0, 42.0),
			StatId.ADDITIONAL_EXPERIENCE_COOKING to MinMaxValue(90.0, 110.0),
		)),
		Item("CHEF_LEGGINGS_5", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(28.5, 31.5),
			StatId.ADDITIONAL_EXPERIENCE_COOKING to MinMaxValue(90.0, 110.0),
		)),
		Item("CHEF_BOOTS_5", mutableMapOf(
			StatId.DEFENSE to MinMaxValue(9.5, 10.5),
			StatId.ADDITIONAL_EXPERIENCE_COOKING to MinMaxValue(95.0, 105.0),
		)),

	)

}