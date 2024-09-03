package com.blockgame.tooltips

import com.blockgame.tooltips.config.ModConfig
import com.blockgame.tooltips.logging.ItemLogger
import com.blockgame.tooltips.objects.*
import com.blockgame.tooltips.objects.ids.StatId
import com.blockgame.tooltips.objects.item.Item
import com.blockgame.tooltips.objects.item.ItemRegistry
import com.blockgame.tooltips.objects.ids.AbilityModifierId
import com.blockgame.tooltips.objects.ids.RuneId
import com.blockgame.tooltips.objects.item.Ability
import com.google.gson.JsonElement
import com.google.gson.JsonParser
import net.minecraft.client.MinecraftClient
import net.minecraft.client.util.InputUtil
import net.minecraft.nbt.NbtCompound
import net.minecraft.text.MutableText
import net.minecraft.text.Text
import net.minecraft.util.Formatting


/*
	This code is spaghetti. Only proceed with a fork and enough parmesan.
*/

object ItemStackHandler {

	fun getLists(nbt: NbtCompound?): Triple<MutableSet<Gemstone>, ArrayList<Mod>, ArrayList<Stat>> {
		val gemstonesList = mutableSetOf<Gemstone>()
		val modsList = ArrayList<Mod>()
		val statsList = ArrayList<Stat>()

		// return empty lists if not an MMOITEMS item
		if (nbt == null || !nbt.contains("MMOITEMS_ITEM_TYPE")) {
			return Triple(gemstonesList, modsList, statsList)
		}

		if (nbt.contains("MMOITEMS_GEM_STONES")
			&& nbt.getString("MMOITEMS_GEM_STONES").isNotEmpty()
			&& !nbt.getString("MMOITEMS_GEM_STONES").startsWith("[]")
		) {
			try {
				val jsonString = nbt.getString("MMOITEMS_GEM_STONES")

				val jsonElement = JsonParser.parseString(jsonString)
				val jsonObject = jsonElement.asJsonObject

				val gemstones = jsonObject.getAsJsonArray("Gemstones")

				gemstones.forEach { jsonElement2: JsonElement ->
					val jsonObject2 = jsonElement2.asJsonObject
					val historyUuid = jsonObject2["History"].asString
					val name = jsonObject2["Name"].asString
					val id = jsonObject2["Id"].asString
					val gemstone = Gemstone(id, historyUuid)
					gemstonesList.add(gemstone)
				}
			} catch (e: Exception) {
				e.printStackTrace()
			}
		}

		if (nbt.contains("HSTRY_NAME")
			&& nbt.getString("HSTRY_NAME").isNotEmpty()
			&& !nbt.getString("HSTRY_NAME").startsWith("[]")
		) {
			try {
				val jsonString = nbt.getString("HSTRY_NAME")

				val jsonElement = JsonParser.parseString(jsonString)
				val jsonObject = jsonElement.asJsonObject

				val mods = jsonObject.getAsJsonArray("Mod")

				mods.forEach { mod ->
					mod.asJsonObject.entrySet().forEach { entry: Map.Entry<String, JsonElement> ->
						val key = entry.key // 'be289e2d-5c8c-4027-9b93-6dc0e5d2c046':[{'MMOITEMS_NAME_PRE_ñstr':'&6Haunted'}]"
						val values = entry.value.asJsonArray

						values.forEach { jsonElement2: JsonElement ->
							jsonElement2.asJsonObject.entrySet().forEach { entry2: Map.Entry<String, JsonElement> ->
								val key2 = entry2.key // MMOITEMS_NAME_PRE_ñstr
								val value = entry2.value.asString // &6Haunted
								if (key2 == "MMOITEMS_NAME_PRE_ñstr" || key2 == "MMOITEMS_NAME_SUF_ñstr") {
									modsList.add(Mod(value, key))
								}
							}
						}

					}
				}
			} catch (e: Exception) {
				e.printStackTrace()
			}
		}

		nbt.keys.filter { key: String -> key.startsWith("HSTRY_") }
			.forEach { historyKey: String? ->  // HSTRY_BLUNT_POWER
				try {
					val jsonString = nbt.getString(historyKey)
					val jsonElement = JsonParser.parseString(jsonString)
					val jsonObject = jsonElement.asJsonObject
					val statStr = jsonObject["Stat"].asString
					val ogStory = jsonObject.getAsJsonArray("OGStory")
					val gemStory = jsonObject.getAsJsonArray("Gemstory")
					val modStory = jsonObject.getAsJsonArray("Mod")

					ogStory?.forEach { jsonElement2: JsonElement ->
						jsonElement2.asJsonObject.entrySet().forEach { entry: Map.Entry<String, JsonElement> ->
							var error = false
							var value: Double? = null
							try {
								val key = entry.key // MMOITEMS_BLUNT_POWER_ñdbl
								value = entry.value.asDouble // 2.0822
							} catch (e: Exception) {
								error = true
							} finally {
								if (!error && value != null) {
									statsList.add(Stat(statStr, value))
								}
							}
						}
					}

					gemStory?.forEach { jsonElement2: JsonElement ->
						jsonElement2.asJsonObject.entrySet().forEach { entry: Map.Entry<String, JsonElement> ->
							val key =
								entry.key // {'be289e2d-5c8c-4027-9b93-6dc0e5d2c046':[{'MMOITEMS_BLUNT_POWER_ñdbl':0.0845}]}, ..."

							gemstonesList.firstOrNull { gemstone: Gemstone -> gemstone.historyUuid == key }
								?.let { gemstone: Gemstone ->
									val value = entry.value.asJsonArray // [{'MMOITEMS_BLUNT_POWER_ñdbl':0.0845}]
									value.forEach { jsonElement3: JsonElement ->
										jsonElement3.asJsonObject.entrySet()
											.forEach { entry2: Map.Entry<String, JsonElement> ->
												var error = false
												var value2: Double? = null
												try {
													val key2 = entry2.key // MMOITEMS_BLUNT_POWER_ñdbl
													value2 = entry2.value.asDouble
												} catch (e: Exception) {
													error = true
												} finally {
													if (!error && value2 != null) {
														gemstone.stats.add(Stat(statStr, value2)) // BLUNT_POWER, 0.0845
													}
												}
											}
									}
								}
						}
					}

					modStory?.forEach { modJsonElement: JsonElement ->
						modJsonElement.asJsonObject.entrySet().forEach { entry: Map.Entry<String, JsonElement> ->
							val key =
								entry.key // {'be289e2d-5c8c-4027-9b93-6dc0e5d2c046':[{'MMOITEMS_BLUNT_POWER_ñdbl':0.0845}]}, ..."

							val mod = modsList.firstOrNull { mod: Mod -> mod.historyUuid == key }
								?: modsList.firstOrNull { mod: Mod -> mod.displayName.contains("&dCorrupted") }
								?: run {
									return@run null
								}
							mod?.let { mod: Mod ->
								val value = entry.value.asJsonArray // [{'MMOITEMS_BLUNT_POWER_ñdbl':0.0845}]
								value.forEach { jsonElement3: JsonElement ->
									jsonElement3.asJsonObject.entrySet()
										.forEach { entry2: Map.Entry<String, JsonElement> ->
											var modError = false
											var modValue: Double? = null
											try {
												val key3 = entry2.key // MMOITEMS_BLUNT_POWER_ñdbl
												modValue = entry2.value.asDouble
											} catch (e: Exception) {
												modError = true
											} finally {
												if (!modError && modValue != null) {
													mod?.stats?.add(Stat(statStr, modValue))
//														?: statsList.add(Stat(statStr, modValue)) // add to stats list if mod is null
												}
											}
										}
								}
							}
						}
					}

				} catch (e: Exception) {
//                e.printStackTrace();
				}
			}

		// adds stats that don't have a history section but are still in the item to the stats list
		nbt.keys.filter { key: String ->
			StatId.entries.map { it.name.uppercase() }.contains(key.uppercase().replace("MMOITEMS_", ""))
//				&& statsList.none { it.id.statName == key }
				&& !nbt.contains("HSTRY_${key.uppercase().replace("MMOITEMS_", "")}")
		}.forEach { statKey: String ->  // HSTRY_BLUNT_POWER
			val value = nbt.getDouble(statKey.uppercase())
			statsList.add(Stat(statKey.uppercase().replace("MMOITEMS_", ""), value))
		}

		return Triple(gemstonesList, modsList, statsList)
	}

	fun appendAbilityStatsToText(
		item: Item?,
		loreLine: Text,
		currentTextImmutable: Text,
		abilityMap: MutableMap<String, MutableList<Pair<String, Double>>>? = null, // <abilityId, <modifierInternalName, value>> // <CORRUPTION, <duration, 5.0>>
		abilityMaybeNull: Ability? = null
	) {
		if (item != null) {
			val currentText = currentTextImmutable as? MutableText
				?: return // not a mutable text

			val ability = abilityMaybeNull
				?: return
			val abilityList = abilityMap?.get(ability.id)
				?: return

			abilityList.forEach { (modifierInternalName, currentValueAbility) ->
				loreLine.string.let { loreLine -> // " >| Curse Strength: 1"
					if (loreLine.isNotEmpty() && loreLine.startsWith(" >| ")) {
						loreLine.trim().substring(3, loreLine.trim().indexOf(":")).let let2@{ modifierName -> // "Curse Strength"
							val abilityModifierId = AbilityModifierId.getByDisplayNameByTextWithoutPrefix(modifierName)
							if (abilityModifierId != null) {
								if (abilityModifierId.internalName != modifierInternalName) {
									return@let2
								}

								if (!InputUtil.isKeyPressed(MinecraftClient.getInstance().window.handle, ModConfig.values.showMinMaxValues)) {
									val percentageText = item.getPercentageText(ability, abilityModifierId, currentValueAbility)
									if (percentageText != null) {
										currentText.append(Text.literal(" ")).append(percentageText).styled { it.withItalic(false) }
										return
									} else {
										val errorText = Text.literal("Could not find value for modifier: ${abilityModifierId.name}")
										currentText.append(Text.literal(" ")).append(errorText).styled { it.withItalic(false) }
										return
									}
								} else {
									val rangeText = item.getRangeText(ability, abilityModifierId)
									if (rangeText != null) {
										currentText.append(Text.literal(" ")).append(rangeText).styled { it.withItalic(false) }
										return
									} else {
										val errorText = Text.literal("Could not find value for modifier: ${abilityModifierId.name}")
										currentText.append(Text.literal(" ")).append(errorText).styled { it.withItalic(false) }
										return
									}
								}

							}
						}
					}
				}
			}


		}
	}

	fun appendModStatsToText(
		item: Item?,
		mod: Mod,
		stat: Stat,
		currentTextImmutable: Text,
	) {
		if (item != null) {
			val currentText = currentTextImmutable as? MutableText
				?: return // not a mutable text

			if (!InputUtil.isKeyPressed(MinecraftClient.getInstance().window.handle, ModConfig.values.showMinMaxValues)) { //  InputUtil.GLFW_KEY_LEFT_SHIFT
				val percentageText = item.getPercentageText(mod, stat.id, stat.value)
				if (percentageText != null) {
					currentText.append(Text.literal(" ")).append(percentageText).styled { it.withItalic(false) }
					return
				} else {
					val errorText = Text.literal("Could not find value for stat: ${stat.id}")
					currentText.append(Text.literal(" ")).append(errorText).styled { it.withItalic(false) }
					return
				}
			} else {
				val rangeText = item.getRangeText(mod, stat.id)
				if (rangeText != null) {
					currentText.append(Text.literal(" ")).append(rangeText).styled { it.withItalic(false) }
					return
				} else {
					val errorText = Text.literal("Could not find value for stat: ${stat.id}")
					currentText.append(Text.literal(" ")).append(errorText).styled { it.withItalic(false) }
					return
				}
			}
		}
	}

	fun appendStatsToText(
		item: Item?,
		stat: Stat?,
		currentTextImmutable: Text,
	) {
		if (item != null) {
			val currentText = currentTextImmutable as? MutableText
				?: return // not a mutable text

			if (stat != null) {
				val currentValue = stat.value

				if (!InputUtil.isKeyPressed(MinecraftClient.getInstance().window.handle, ModConfig.values.showMinMaxValues)) { //  InputUtil.GLFW_KEY_LEFT_SHIFT
					run {
						if (currentValue != null) {
							val percentageText = item.getPercentageText(stat.id, currentValue)
							if (percentageText != null) {
								currentText.append(Text.literal(" ")).append(percentageText).styled { it.withItalic(false) }
								return
							}
						} else {
							val errorText = Text.literal("Could not find value for stat: ${stat.id}")
							currentText.append(Text.literal(" ")).append(errorText).styled { it.withItalic(false) }
							return
						}
					}
				} else {
					val rangeText = item.getRangeText(stat.id)
					if (rangeText != null) {
						currentText.append(Text.literal(" ")).append(rangeText).styled { it.withItalic(false) }
						return
					}
				}
			}
		}
	}

	private fun getAllStatsFromNbt(nbt: NbtCompound?): MutableList<Stat> {
		val statsList = mutableListOf<Stat>()
		if (nbt == null) {
			return statsList
		}

		nbt.keys.filter { key: String ->
			StatId.entries.map { it.name.uppercase() }.contains(key.uppercase().replace("MMOITEMS_", ""))
		}.forEach { statKey: String ->  // HSTRY_BLUNT_POWER
			val value = nbt.getDouble(statKey.uppercase())
			statsList.add(Stat(statKey.uppercase().replace("MMOITEMS_", ""), value))
		}

		return statsList
	}


	fun getNewLore(nbt: NbtCompound?): MutableList<Text>? {
		val (gemstonesList, modsList, statsList) = getLists(nbt)
		val loreReturnValue = mutableListOf<Text>()
//		ItemLogger.logItem(nbt, loreReturnValue, gemstonesList, modsList, statsList)

		val MMOITEMS_ITEM_ID = nbt?.getString("MMOITEMS_ITEM_ID")
		val MMOITEMS_REVISION_ID = nbt?.getInt("MMOITEMS_REVISION_ID")
		if (MMOITEMS_ITEM_ID != null && MMOITEMS_ITEM_ID.startsWith("RUNECARVING_")) {
			return null // don't show anything in the separate tooltip
		}

		if (gemstonesList.isEmpty() && modsList.isEmpty() && statsList.isEmpty()) {
			return null
		}

		if (statsList.isNotEmpty() || gemstonesList.isNotEmpty() || modsList.isNotEmpty()) {
			if (!InputUtil.isKeyPressed(MinecraftClient.getInstance().window.handle, ModConfig.values.show)) { // GLFW_KEY_LEFT_SHIFT
				return null
			}
		}

		loreReturnValue.add(Text.empty())

		if (statsList.isNotEmpty()) {
			loreReturnValue.add(Text.literal(" Original Stats: ").formatted(Formatting.GOLD))

			statsList.forEach { stat ->
				val txt = stat.id.getStatWith2DecimalPlacesText(stat.value)
				MMOITEMS_ITEM_ID?.let {
					appendStatsToText(ItemRegistry.getById(MMOITEMS_ITEM_ID, MMOITEMS_REVISION_ID), stat, txt)
				}
				loreReturnValue.add(txt)
			}
			loreReturnValue.add(Text.empty())
		}

		if (modsList.isNotEmpty()) {
			modsList.forEach { mod ->
				loreReturnValue.add(mod.getText())
				mod.stats.forEach { stat ->
					val txt = stat.id.getStatWith2DecimalPlacesText(stat.value)
					// Don't know the values for the Modifier stats // TODO: find a way to get the values
					MMOITEMS_ITEM_ID?.let {
						appendModStatsToText(ItemRegistry.getById(MMOITEMS_ITEM_ID, MMOITEMS_REVISION_ID), mod, stat, txt)
					}
					loreReturnValue.add(txt)
				}
				loreReturnValue.add(Text.empty())
			}
		}

		if (gemstonesList.isNotEmpty()) {
			gemstonesList.sortedBy { it.historyUuid }.forEach { gemstone ->
				loreReturnValue.add(gemstone.id.getText())
				gemstone.stats.forEach { stat ->
					val txt = stat.id.getStatWith2DecimalPlacesText(stat.value)
					gemstone.id.name.let {
						appendStatsToText(ItemRegistry.getById(it, MMOITEMS_REVISION_ID), stat, txt)
					}
					loreReturnValue.add(txt)
				}
				loreReturnValue.add(Text.empty())
			}
		}


		return loreReturnValue
	}

	fun modifyLore(nbt: NbtCompound?, loreReturnValue: MutableList<Text>) {
		val (gemstonesList, modsList, statsList) = getLists(nbt)
		ItemLogger.logItem(nbt, loreReturnValue, gemstonesList, modsList, statsList)

		val MMOITEMS_ITEM_ID = nbt?.getString("MMOITEMS_ITEM_ID")
		val MMOITEMS_REVISION_ID = nbt?.getInt("MMOITEMS_REVISION_ID")

		if (loreReturnValue.any { it.string.contains("Left-Click to craft!") || it.string.contains("Conditions:") || it.string.contains("Ingredients:") }) {
			return
		}

		if (MMOITEMS_ITEM_ID != null && MMOITEMS_ITEM_ID.startsWith("RUNECARVING_")) {
			val runecarvingStatsList = getAllStatsFromNbt(nbt)

			loreReturnValue.forEach { text ->
				val txt = text.string.trim()
				val statId = StatId.getByRawStatName(txt)
					?: return@forEach
				val stat = runecarvingStatsList.firstOrNull { it.id == statId }
					?: return@forEach

				if (txt.isNotEmpty()) {
					val item = ItemRegistry.getById(MMOITEMS_ITEM_ID, MMOITEMS_REVISION_ID)
					appendStatsToText(item, stat, text)
				}
			}
		}

		val MMOITEMS_ABILITY = nbt?.getString("MMOITEMS_ABILITY")
		if (MMOITEMS_ITEM_ID != null && !MMOITEMS_ABILITY.isNullOrEmpty() && MMOITEMS_ABILITY != "[]") {
			val jsonString = MMOITEMS_ABILITY
			val jsonElement = JsonParser.parseString(jsonString)
			val jsonArray = jsonElement.asJsonArray

			val abilityMap = mutableMapOf<String, MutableList<Pair<String, Double>>>()

			val item = ItemRegistry.getById(MMOITEMS_ITEM_ID, MMOITEMS_REVISION_ID)
			if (item != null) {
				jsonArray.forEach { jsonElement2: JsonElement ->
					val id = jsonElement2.asJsonObject["Id"].asString // CORRUPTION
//					val castMode = jsonElement2.asJsonObject["CastMode"].asString
					val modifiers = jsonElement2.asJsonObject["Modifiers"].asJsonObject

					abilityMap[id] = mutableListOf()
					modifiers.entrySet().forEach { entry: Map.Entry<String, JsonElement> ->
						val key = entry.key // duration
						val value = entry.value.asDouble // 5.0

						abilityMap[id]?.add(Pair(key, value))
					}
				}
			}

			var currentAbility: Ability? = null
			loreReturnValue.toMutableList().forEachIndexed { _, text -> // make a copy
				val txt = text.string.trim() // ">| Right Click ||| Frostbolt" // " >| Damage: 1.0"
				if (txt.isNotEmpty() && txt.startsWith(">| ")) { // start of the ability section with the ability name
					// txt = ">| Right Click ||| Corruption"
					val abilityNameLine = txt.substring(3).trim() // "Right Click ||| Corruption" // "Damage: 1.0"

					if (abilityNameLine.indexOf("|||") != -1) {
						val abilityName = abilityNameLine.substring(abilityNameLine.indexOf("|||") + 4).trim() // "Corruption" // null
						abilityName.let let1@{ abilityName ->
							item?.abilities?.firstOrNull { it.displayName == abilityName.trim() }?.let let2@{ ability ->
								currentAbility = ability
								return@let1
							}
						}
					} else {
						currentAbility?.let { ability ->
							appendAbilityStatsToText(item, text, text, abilityMap, ability)
						}
					}
				}
			}
		}

		if (gemstonesList.isEmpty() && modsList.isEmpty() && statsList.isEmpty() && MMOITEMS_ABILITY.isNullOrEmpty() && (MMOITEMS_ITEM_ID == null || !MMOITEMS_ITEM_ID.startsWith("RUNECARVING_"))) {
			return
		}


		var keybindText: MutableText? = null
		if (statsList.isNotEmpty() || gemstonesList.isNotEmpty() || modsList.isNotEmpty() || MMOITEMS_ABILITY != null || MMOITEMS_ITEM_ID?.startsWith("RUNECARVING_") == true) {
			val windowHandle = MinecraftClient.getInstance().window.handle

			windowHandle.let appendKeybindInfo@{
				// if <show> key is not pressed:
				// <showMinMaxValues>
				var addEmptyLines = false
				var (key, infoString) = if (!InputUtil.isKeyPressed(windowHandle, ModConfig.values.show)) {
					InputUtil.Type.KEYSYM.createFromCode(ModConfig.values.show) to "for more info"
				} else if (!InputUtil.isKeyPressed(windowHandle, ModConfig.values.showMinMaxValues)) {
					InputUtil.Type.KEYSYM.createFromCode(ModConfig.values.showMinMaxValues) to "for stat ranges"
				} else {
					addEmptyLines = true
					null to ""
//					return@appendKeybindInfo
				}

				// if no stats, gemstones, or mods, but there is an ability -> show keybind for stat ranges
				if (statsList.isEmpty() && gemstonesList.isEmpty() && modsList.isEmpty()
					&& (MMOITEMS_ABILITY != null || MMOITEMS_ITEM_ID?.startsWith("RUNECARVING_") == true)
					) {
					if (!InputUtil.isKeyPressed(windowHandle, ModConfig.values.showMinMaxValues)) {
						key = InputUtil.Type.KEYSYM.createFromCode(ModConfig.values.showMinMaxValues)
						infoString = "for stat ranges"
					} else {
						addEmptyLines = true
//						return@appendKeybindInfo
					}
				}

				if (!addEmptyLines) {
					keybindText = Text.literal("[").formatted(Formatting.GRAY)
						.append(key.localizedText).formatted(Formatting.GRAY)
						.append(Text.literal("] $infoString").formatted(Formatting.GRAY))
				}

				loreReturnValue.forEachIndexed { index, text -> // make a copy
					val txt = text.string.trim()
					if (txt.isNotEmpty() && txt.startsWith("Tier:")) {
						// yes its reversed, but it's okay because we insert
						// result:
						// "[key] for more info"
						// "<empty line>"
						// "Tier: ..."
						if (addEmptyLines) {
							loreReturnValue.add(index, Text.empty())
							loreReturnValue.add(index, Text.empty())
							return@appendKeybindInfo
						} else {
							keybindText?.let { keybindTextNotNull ->
								loreReturnValue.add(index, Text.empty())
								loreReturnValue.add(index, keybindTextNotNull)
								return@appendKeybindInfo
							}
						}
					}
				}
			}
		}

		// check if keybind is pressed to show more info
		if (!InputUtil.isKeyPressed(MinecraftClient.getInstance().window.handle, ModConfig.values.show)) {
			return
		}

		// add it here, so it still adds the "for more info" text as above.
		if (ModConfig.values.tooltipType != ModConfig.TooltipType.INLINE) {
			return
		}


		var firstFoundIndex: Int? = null
		val completedGemstonesList = HashSet<Gemstone>()
		var index = 0
		loreReturnValue.toList().iterator().forEach { text -> // make a copy
			if (firstFoundIndex == null) {
				val txt = text.string.trim()

				if (txt.isNotEmpty() && txt.substring(1).trim().startsWith("Empty")) {
					firstFoundIndex = index
				}
				if (txt.isNotEmpty() && txt.startsWith(">| ")) { // no .trim() !!!
					firstFoundIndex = index
				}
				keybindText?.let { keybindTextNotNull ->
					if (txt.isNotEmpty() && txt.startsWith(keybindTextNotNull.string)) {
						firstFoundIndex = index
					}
				}
				if (txt.isNotEmpty() && txt.startsWith("Tier:")) {
					firstFoundIndex = index
				}
			}
			if (gemstonesList.isNotEmpty() && RuneId.getByRuneName(text.string) != null) {
				gemstonesList.sortedBy { it.historyUuid }.filter { !completedGemstonesList.contains(it) }.firstOrNull { gemstone: Gemstone -> gemstone.id == RuneId.getByRuneName(text.string) }
					?.let { gemstone: Gemstone ->
						completedGemstonesList.add(gemstone)
						gemstone.stats.forEach { stat ->
							if (firstFoundIndex == null) {
								firstFoundIndex = index
							}
							val txt = stat.id.getStatWith2DecimalPlacesText(stat.value)
							gemstone.id.name.let {
								appendStatsToText(ItemRegistry.getById(it, MMOITEMS_REVISION_ID), stat, txt)
							}
							loreReturnValue.add(++index, txt)
						}
						if (completedGemstonesList.size < gemstonesList.size) {
							loreReturnValue.add(++index, Text.empty())
						}
					}
			}
			index++
		}

		if (statsList.isNotEmpty()) {
			var index = firstFoundIndex
				?: (loreReturnValue.size - 1)

			loreReturnValue.add(index++, Text.literal(" Original Stats: ").formatted(Formatting.GOLD))

			statsList.forEach { stat ->
				val txt = stat.id.getStatWith2DecimalPlacesText(stat.value)
				MMOITEMS_ITEM_ID?.let {
					appendStatsToText(ItemRegistry.getById(MMOITEMS_ITEM_ID, MMOITEMS_REVISION_ID), stat, txt)
				}

				loreReturnValue.add(index++, txt)
			}
			loreReturnValue.add(index++, Text.empty())
			firstFoundIndex = index
		}

		if (modsList.isNotEmpty()) {
			var index = firstFoundIndex
				?: (loreReturnValue.size - 1)

			modsList.forEach { mod ->
				loreReturnValue.add(index++, mod.getText())
				mod.stats.forEach { stat ->
					val txt = stat.id.getStatWith2DecimalPlacesText(stat.value)
					// Don't know the values for the Modifier stats // TODO: find a way to get the values
					MMOITEMS_ITEM_ID?.let {
						appendModStatsToText(ItemRegistry.getById(MMOITEMS_ITEM_ID, MMOITEMS_REVISION_ID), mod, stat, txt)
					}
					loreReturnValue.add(index++, txt)
				}
				loreReturnValue.add(index++, Text.empty())
			}
			firstFoundIndex = index
		}


	}

}