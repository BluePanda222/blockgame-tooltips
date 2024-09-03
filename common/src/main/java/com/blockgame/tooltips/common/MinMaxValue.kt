package com.blockgame.tooltips.common

import kotlin.math.roundToInt

data class MinMaxValue(
	var min: Double,
	var max: Double
) {

	fun getPercentageWithoutConvert(currentValue: Double): Double {
		if (this.min == this.max) {
			return 1.0
		}

		val currentValueRounded2Decimals = (currentValue * 100).roundToInt() / 100.0
		val minRounded2Decimals = (this.min * 100).roundToInt() / 100.0
		val maxRounded2Decimals = (this.max * 100).roundToInt() / 100.0

		return if (minRounded2Decimals < 0.0 && maxRounded2Decimals < 0.0) {
			1 - ((currentValueRounded2Decimals - minRounded2Decimals) / (maxRounded2Decimals - minRounded2Decimals))
		} else {
			(currentValueRounded2Decimals - minRounded2Decimals) / (maxRounded2Decimals - minRounded2Decimals)
		}
	}

	fun merge(value: MinMaxValue) {
		this.min = minOf(this.min, value.min)
		this.max = maxOf(this.max, value.max)
	}

}