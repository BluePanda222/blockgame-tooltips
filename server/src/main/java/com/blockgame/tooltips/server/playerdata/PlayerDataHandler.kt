package com.blockgame.tooltips.server.playerdata

import com.blockgame.tooltips.server.BlockgameTooltipsServer
import com.blockgame.tooltips.server.file.FileUtil
import com.blockgame.tooltips.server.objects.Ability
import com.blockgame.tooltips.server.objects.CachedItem
import java.io.File

object PlayerDataHandler {

	fun writeToFile(list: List<CachedItem>, username: String) {
		val playerDataDirectory = File(FileUtil.playerDataDirectoryPath)
		if (!playerDataDirectory.exists()) {
			playerDataDirectory.mkdir()
		}
		val playerDirectory = File(playerDataDirectory, username)
		if (!playerDirectory.exists()) {
			playerDirectory.mkdir()
		}

		val configFile = File(playerDirectory, "${BlockgameTooltipsServer.MOD_ID}.cache.json")
		val jsonStr = CachedItem.listToJsonString(list)
		configFile.writeText(jsonStr)
	}


	fun loadFromFile(username: String): List<CachedItem> {
		val playerDataDirectory = File(FileUtil.playerDataDirectoryPath)
		if (!playerDataDirectory.exists()) {
			playerDataDirectory.mkdir()
		}
		val playerDirectory = File(playerDataDirectory, username)
		if (!playerDirectory.exists()) {
			playerDirectory.mkdir()
		}

		val configFile = File(playerDirectory, "${BlockgameTooltipsServer.MOD_ID}.cache.json")
		if (!configFile.exists()) {
			return emptyList()
		}

		val jsonStr: String
		try {
			jsonStr = configFile.readText()
		} catch (e: Exception) {
			println("Failed to load cache from file")
			e.printStackTrace()
			return emptyList()
		}
		val list: List<CachedItem>
		try {
			list = CachedItem.listFromJsonString(jsonStr)
		} catch (e: Exception) {
			println("Failed to parse cache from file")
			e.printStackTrace()
			return emptyList()
		}

		list.forEach { item -> item.abilities.forEach { ability: Ability -> ability.updateDisplayName() } }

		return list
	}

	fun loadLegacyFromFile(username: String): List<CachedItem> {
		val playerDataDirectory = File(FileUtil.playerDataDirectoryPath)
		if (!playerDataDirectory.exists()) {
			playerDataDirectory.mkdir()
		}
		val playerDirectory = File(playerDataDirectory, username)
		if (!playerDirectory.exists()) {
			playerDirectory.mkdir()
		}

		val configFile = File(playerDirectory, "legacy.txt")
		if (!configFile.exists()) {
			return emptyList()
		}

		val string: String
		try {
			string = configFile.readText()
		} catch (e: Exception) {
			println("Failed to load cache from file")
			e.printStackTrace()
			return emptyList()
		}
		val list: List<CachedItem>
		try {
			LegacyParser.parseLegacyFileContent(string)
//			list = CachedItem.listFromJsonString(string)
		} catch (e: Exception) {
			println("Failed to parse cache from file")
			e.printStackTrace()
			return emptyList()
		}

//		list.forEach { item -> item.abilities.forEach { ability: Ability -> ability.updateDisplayName() } }

//		return list
		return emptyList()
	}

}