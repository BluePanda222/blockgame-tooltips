package com.blockgame.tooltips.logging

import com.blockgame.tooltips.BlockgameTooltipsClient
import com.blockgame.tooltips.BlockgameTooltipsClient.MOD_ID
import com.blockgame.tooltips.common.MinMaxValue
import com.blockgame.tooltips.config.ModConfig.configDirectoryPath
import com.blockgame.tooltips.objects.Gemstone
import com.blockgame.tooltips.objects.Mod
import com.blockgame.tooltips.objects.Stat
import com.blockgame.tooltips.objects.ids.AbilityModifierId
import com.blockgame.tooltips.objects.item.Ability
import com.blockgame.tooltips.objects.item.CachedItem
import com.blockgame.tooltips.objects.item.ItemMod
import com.google.gson.JsonElement
import com.google.gson.JsonParser
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents
import net.minecraft.client.MinecraftClient
import net.minecraft.client.item.TooltipContext
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound
import net.minecraft.nbt.NbtElement
import net.minecraft.text.ClickEvent
import net.minecraft.text.HoverEvent
import net.minecraft.text.Style
import net.minecraft.text.Text
import java.io.File


object ItemLogger {

	val cachedItems = mutableListOf<CachedItem>()
	private var tickCounter = 0

	init {
		val loadedItems = loadFromFile()
		loadedItems.forEach { cachedItem ->
			addItem(cachedItem)
		}

		ClientTickEvents.END_CLIENT_TICK.register(ClientTickEvents.EndTick { _: MinecraftClient ->
			if (tickCounter % (20 * 60) == 0) { // 1 minute
				logCacheSilent()
				tickCounter = 0
			}
			tickCounter++
		})
		ServerPlayConnectionEvents.DISCONNECT.register { _, _ ->
			logCacheSilent()
		}
	}

	fun addItem(cachedItem: CachedItem) {
		if (cachedItems.asSequence().filter { it.id == cachedItem.id && it.revisionId == cachedItem.revisionId }.count() == 0) {
			cachedItems.add(cachedItem)
		} else {
			cachedItems.removeIf { it.id == cachedItem.id && it.revisionId == cachedItem.revisionId }
			cachedItems.add(cachedItem)
		}
	}

	fun logCacheSilent() {
		val jsonStr: String
		try {
			jsonStr = CachedItem.listToJsonString(cachedItems)
		} catch (e: Exception) {
			BlockgameTooltipsClient.LOGGER.error("Failed to convert cache to json")
			e.printStackTrace()
			return
		}
		try {
			writeToFileSilent(jsonStr)
		} catch (e: Exception) {
			BlockgameTooltipsClient.LOGGER.error("Failed to write cache to file")
			e.printStackTrace()
		}
	}

	fun logCache() {
		MinecraftClient.getInstance().player?.sendMessage(Text.of("Logging cache... ${cachedItems.size} items"), false)
		println("Logging cache... ${cachedItems.size} items")

		val loggedItems = cachedItems.toList()
		val jsonStr = CachedItem.listToJsonString(loggedItems)
		writeToFile(jsonStr)
	}

	private fun writeToFile(string: String) {
		val configDirectory = File(configDirectoryPath)
		if (!configDirectory.exists()) {
			configDirectory.mkdir()
		}

		val configFile = File(configDirectory, "$MOD_ID.cache.json")
		configFile.writeText(string)

		MinecraftClient.getInstance().player?.sendMessage(Text.literal("Cache logged to ${configFile.name}")
			.setStyle(Style.EMPTY
				.withClickEvent(ClickEvent(ClickEvent.Action.OPEN_FILE, configFile.absolutePath))
				.withHoverEvent(HoverEvent(HoverEvent.Action.SHOW_TEXT, Text.of("Click to open")))
			), false)
		println("Cache logged to ${configFile.name}")
	}

	private fun writeToFileSilent(string: String) {
		val configDirectory = File(configDirectoryPath)
		if (!configDirectory.exists()) {
			configDirectory.mkdir()
		}

		val configFile = File(configDirectory, "$MOD_ID.cache.json")
		configFile.writeText(string)
	}

	private fun loadFromFile(): List<CachedItem> {
		val configDirectory = File(configDirectoryPath)
		if (!configDirectory.exists()) {
			configDirectory.mkdir()
		}

		val configFile = File(configDirectory, "$MOD_ID.cache.json")
		if (!configFile.exists()) {
			return emptyList()
		}

		val jsonStr: String
		try {
			jsonStr = configFile.readText()
		} catch (e: Exception) {
			BlockgameTooltipsClient.LOGGER.error("Failed to load cache from file")
			e.printStackTrace()
			return emptyList()
		}
		val list: List<CachedItem>
		try {
			list = CachedItem.listFromJsonString(jsonStr)
		} catch (e: Exception) {
			BlockgameTooltipsClient.LOGGER.error("Failed to parse cache from file")
			e.printStackTrace()
			return emptyList()
		}
		return list
	}


	fun logItemStacks(list: MutableList<ItemStack>) {
		val client = MinecraftClient.getInstance()
		list.forEach { stack ->
			// by accessing this method, the logItem method will eventually be called
			stack.getTooltip(
				client.player,
				if (client.options.advancedItemTooltips) TooltipContext.Default.ADVANCED else TooltipContext.Default.BASIC
			)
		}
	}

	fun logSocketedGemstones(
		gemstonesList: MutableSet<Gemstone>
	) {
		gemstonesList.forEach { gemstone: Gemstone ->
			val id = gemstone.id.name.uppercase()

			val cachedItem = if (cachedItems.asSequence().filter { it.id == id }.count() > 0) {
				cachedItems.first { it.id == id }
			} else {
				return@forEach
			}

			gemstone.stats.forEach gemstoneForEach@{ stat: Stat ->
				val statKey = stat.id
				val value = stat.id.convertValue(stat.value)

				val minMaxValue = if (cachedItem.stats.containsKey(statKey)) {
					cachedItem.stats[statKey]!!
				} else {
					MinMaxValue(value, value)
				}

				if (value < minMaxValue.min) {
					minMaxValue.min = value
				}
				if (value > minMaxValue.max) {
					minMaxValue.max = value
				}

				cachedItem.stats[statKey] = minMaxValue
			}
		}
	}

	fun logItem(
		nbt: NbtCompound?,
		loreReturnValue: List<Text>,
		gemstonesList: MutableSet<Gemstone>,
		modsList: MutableList<Mod>,
		statsList: MutableList<Stat>
	) {
		if (nbt == null) {
			return
		}

		val MMOITEMS_ITEM_ID = nbt.getString("MMOITEMS_ITEM_ID")
		if (MMOITEMS_ITEM_ID.isNullOrEmpty()) {
			return
		}

		if (loreReturnValue.any { it.string.contains("Left-Click to craft!") || it.string.contains("Conditions:") || it.string.contains("Ingredients:") }) {
			return
		}

		val MMOITEMS_REVISION_ID = nbt.getInt("MMOITEMS_REVISION_ID")

		val cachedItem = if (cachedItems.asSequence().filter { it.id == MMOITEMS_ITEM_ID && it.revisionId == MMOITEMS_REVISION_ID }.count() > 0) {
			cachedItems.first { it.id == MMOITEMS_ITEM_ID && it.revisionId == MMOITEMS_REVISION_ID }
		} else {
			val cachedItem = CachedItem(MMOITEMS_ITEM_ID, MMOITEMS_REVISION_ID)
			addItem(cachedItem)
			cachedItem
		}

		logSocketedGemstones(gemstonesList)

		nbt.getCompound("display")?.let { displayNbt ->
			val loreList = displayNbt.getList("Lore", NbtElement.STRING_TYPE.toInt())
			val lore = loreList.map {
				val str = it.asString()
				val text = Text.Serializer.fromJson(str)
				text?.string
					?: "<null>"
			}
			cachedItem.lore.clear()
			cachedItem.lore.addAll(lore)
		}

		val MMOITEMS_ABILITY = nbt.getString("MMOITEMS_ABILITY")
		if (!MMOITEMS_ABILITY.isNullOrEmpty() && MMOITEMS_ABILITY != "[]") {
			val jsonString = MMOITEMS_ABILITY
			val jsonElement = JsonParser.parseString(jsonString)
			val jsonArray = jsonElement.asJsonArray

			val abilityList = mutableListOf<Ability>()

			jsonArray.forEach { jsonElement2: JsonElement ->
				val id = jsonElement2.asJsonObject["Id"].asString // CORRUPTION
				val castMode = jsonElement2.asJsonObject["CastMode"].asString
				val modifiers = jsonElement2.asJsonObject["Modifiers"].asJsonObject

				val loggedAbility = if (cachedItem.abilities.any { it.id == id }) {
					cachedItem.abilities.first { it.id == id }
				} else {
					val cachedAbility = Ability(id, id, castMode)
					cachedItem.abilities.add(cachedAbility)
					cachedAbility
				}

				modifiers.entrySet().forEach modifiersForEach@{ entry: Map.Entry<String, JsonElement> ->
					val internalName = entry.key // duration

					val potentialAbilityModifierIds =
						AbilityModifierId.registry.entries.filter { it.value.internalName == internalName }
					if (potentialAbilityModifierIds.isEmpty()) {
						return@modifiersForEach
					}
					val abilityModifierId = if (potentialAbilityModifierIds.size == 1) {
						potentialAbilityModifierIds.first().value
					} else {
						var foundAbilityModifierId: AbilityModifierId? = null
						potentialAbilityModifierIds.forEach { (key, value) ->
							if (loreReturnValue.any { it.string.startsWith(value.displayName) }) {
								foundAbilityModifierId = value
							}
						}
						foundAbilityModifierId
					} ?: return@modifiersForEach

					val value = entry.value.asDouble // 5.0

					val minMaxValue = if (loggedAbility.abilityModifiers.containsKey(abilityModifierId)) {
						loggedAbility.abilityModifiers[abilityModifierId]!!
					} else {
						val minMax = MinMaxValue(value, value)
						minMax
					}

					if (value < minMaxValue.min) {
						minMaxValue.min = value
					}
					if (value > minMaxValue.max) {
						minMaxValue.max = value
					}

					loggedAbility.abilityModifiers[abilityModifierId] = minMaxValue
				}

				abilityList.add(loggedAbility)
			}
		}


//		nbt.keys.filter { key: String ->
//			key.uppercase().startsWith("MMOITEMS_")
//		}.forEach { statKey: String -> // HSTRY_BLUNT_POWER
//			if (nbt.getType(statKey) != NbtElement.DOUBLE_TYPE) {
//				return@forEach
//			}
//
//			val oldValue = nbt.getDouble(statKey.uppercase())
//			val statId = StatId.getById(statKey.replace("MMOITEMS_", "").uppercase())
//			val value = if (statId == StatId.UNKNOWN) {
//				oldValue
//			} else {
//				statId.convertValue(oldValue)
//			}
//
//			val minMaxValue = if (cachedItem.stats.containsKey(statKey)) {
//				cachedItem.stats[statKey]!!
//			} else {
//				MinMaxValue(value, value)
//			}
//
//			if (value < minMaxValue.min) {
//				minMaxValue.min = value
//			}
//			if (value > minMaxValue.max) {
//				minMaxValue.max = value
//			}
//
//			cachedItem.stats[statKey] = minMaxValue
//		}

		statsList.forEach { stat: Stat ->
			val statKey = stat.id
			val value = stat.value

			val minMaxValue = if (cachedItem.stats.containsKey(statKey)) {
				cachedItem.stats[statKey]!!
			} else {
				MinMaxValue(value, value)
			}

			if (value < minMaxValue.min) {
				minMaxValue.min = value
			}
			if (value > minMaxValue.max) {
				minMaxValue.max = value
			}

			cachedItem.stats[statKey] = minMaxValue
		}

		modsList.forEach { mod: Mod ->
			val id = mod.displayNameStripped

			mod.stats.forEach modForEach@{ stat: Stat ->
				val statKey = stat.id
				val value = stat.id.convertValue(stat.value)

				if (cachedItem.mods.any { it.displayNameStripped == id }) {
					val list = cachedItem.mods.firstOrNull { it.displayNameStripped == id }?.stats
						?: return@modForEach

					list.entries.firstOrNull { it.key == statKey }?.let { (_, minMaxValue) ->
						if (value < minMaxValue.min) {
							minMaxValue.min = value
						}
						if (value > minMaxValue.max) {
							minMaxValue.max = value
						}
					} ?: run {
						val minMaxValue = MinMaxValue(value, value)
						if (value < minMaxValue.min) {
							minMaxValue.min = value
						}
						if (value > minMaxValue.max) {
							minMaxValue.max = value
						}

						list[statKey] = minMaxValue
					}
				} else {
					val minMaxValue = MinMaxValue(value, value)
					if (value < minMaxValue.min) {
						minMaxValue.min = value
					}
					if (value > minMaxValue.max) {
						minMaxValue.max = value
					}

					cachedItem.mods.add(ItemMod(mod.displayName, mutableMapOf(statKey to minMaxValue)))
				}
			}
		}



	}

}