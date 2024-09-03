package com.blockgame.tooltips.server

import com.blockgame.tooltips.server.merger.DataMerger
import com.blockgame.tooltips.server.objects.AbilityModifierId
import com.blockgame.tooltips.server.objects.CachedItem
import com.blockgame.tooltips.server.objects.StatId
import com.blockgame.tooltips.server.playerdata.PlayerDataHandler

class Main {

	companion object {

		@JvmStatic
		fun main(args: Array<String>) {
			println("Hello WORLD!")
			BlockgameTooltipsServer.MOD_ID



			println("Hello, BlockgameTooltipsServer!")

			AbilityModifierId // Load AbilityModifierId
			StatId // Load StatId
			PlayerDataHandler // Load PlayerDataHandler



//			// legacy:
//			PlayerDataHandler.loadLegacyFromFile("Neglex")
//			return


			val players = listOf("BluePanda22", "Neglex")

			val mergedData = PlayerDataHandler.loadFromFile("merged")

			var mergedList: List<CachedItem> = mergedData
			players.forEach { player ->
				val playerData = PlayerDataHandler.loadFromFile(player)
				mergedList = DataMerger.mergeCachedItems(mergedList, playerData)
			}
			PlayerDataHandler.writeToFile(mergedList, "merged")


			val stringSet = mutableSetOf<String>()
			mergedList.forEach {
				it.abilities.forEach { ability ->
					stringSet.add("${ability.id} - ${ability.displayName}")
				}
			}
			stringSet.forEach {
				println(it)
			}
		}

	}

}