package com.blockgame.tooltips.util

import java.io.File
import java.io.InputStream

object FileUtil {

	fun writeToFile(string: String, directory: String, fileName: String) {
		val configDirectory = File(directory)
		if (!configDirectory.exists()) {
			configDirectory.mkdir()
		}

		val configFile = File(configDirectory, fileName)
		configFile.writeText(string)
	}

	fun readFromFile(directory: String, fileName: String): String {
		val configFile = File(directory, fileName)
		return configFile.readText()
	}

	fun checkIfFileExists(directory: String, fileName: String): Boolean {
		val configFile = File(directory, fileName)
		return configFile.exists()
	}

	fun getFileFromResourceAsStream(fileName: String): InputStream {
		val classLoader = javaClass.classLoader
		val inputStream = classLoader.getResourceAsStream(fileName)

		requireNotNull(inputStream) { "file not found! $fileName" }
		return inputStream
	}

}