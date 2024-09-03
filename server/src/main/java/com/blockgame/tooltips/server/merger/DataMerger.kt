package com.blockgame.tooltips.server.merger

import com.blockgame.tooltips.server.objects.CachedItem

object DataMerger {

	fun mergeCachedItems(cachedItems1: List<CachedItem>, cachedItems2: List<CachedItem>): MutableList<CachedItem> {
		val mergedItems = mutableListOf<CachedItem>()

		// Add all items from the first list
		mergedItems.addAll(cachedItems1)

		cachedItems2.forEach { item2 ->
			// Check if the item is already in the list
			val existingItem = mergedItems.firstOrNull { it.id == item2.id && it.revisionId == item2.revisionId }
				?: mergedItems.firstOrNull { it.id == item2.id && it.revisionId == null }

			if (existingItem != null) {
				// If the item is already in the list, merge the data
				existingItem.merge(item2)
			} else {
				// If the item is not in the list, add it
				mergedItems.add(item2)
			}
		}

		// Return the merged list
		return mergedItems
	}

}