package com.blockgame.tooltips.objects.item

import com.blockgame.tooltips.BlockgameTooltipsClient
import com.blockgame.tooltips.config.ModConfig
import com.blockgame.tooltips.objects.deprecated.ItemRegistryLongList
import com.blockgame.tooltips.util.FileUtil
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

object ItemRegistry {

	val itemList = mutableSetOf<Item>()

	const val ITEMS_FILE = "${BlockgameTooltipsClient.MOD_ID}.items.json"


	init {
		// TODO - Change when Networking is implemented
//		if (FileUtil.checkIfFileExists(ModConfig.configDirectoryPath, ITEMS_FILE)) {
//			loadFile()
//		} else {
			FileUtil.getFileFromResourceAsStream("default/$ITEMS_FILE").use { inputStream ->
				val jsonStr = inputStream.bufferedReader().use { reader -> reader.readText() }
				FileUtil.writeToFile(jsonStr, ModConfig.configDirectoryPath, ITEMS_FILE)
				loadFile()
			}
//		}

//		itemList.addAll(ItemRegistryLongList.itemList)
//		saveFile()
	}

	fun saveFile() {
		val jsonStr = listToJsonString(itemList.toList())
		FileUtil.writeToFile(jsonStr, ModConfig.configDirectoryPath, ITEMS_FILE)
	}

	fun loadFile() {
		val jsonStr: String
		try {
			jsonStr = FileUtil.readFromFile(ModConfig.configDirectoryPath, ITEMS_FILE)
		} catch (e: Exception) {
			BlockgameTooltipsClient.LOGGER.error("Failed to load items file.")
			e.printStackTrace()
			return
		}
		try {
			val list = listFromJsonString(jsonStr)
			list.forEach { register(it) }
		} catch (e: Exception) {
			BlockgameTooltipsClient.LOGGER.error("Failed to parse items file.")
			e.printStackTrace()
		}
	}

	fun listToJsonString(items: List<Item>): String {
		val gson: Gson = GsonBuilder().setPrettyPrinting().create()
		return gson.toJson(items)
	}

	fun listFromJsonString(json: String): List<Item> {
		val gson: Gson = GsonBuilder().create()
		val type = object : TypeToken<List<Item>>() {}.type
		return gson.fromJson(json, type)
	}


	fun register(item: Item) {
		itemList.add(item)
	}

	fun getById(id: String, revisionId: Int?): Item? {
		return itemList.find { it.id == id && it.revisionId == revisionId }
			?: itemList.find { it.id == id }
	}


}