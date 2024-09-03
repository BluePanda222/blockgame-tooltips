import java.net.URI

allprojects {
	repositories {
		maven {
			name = "Fabric"
			url = URI("https://maven.fabricmc.net/")
		}
		maven { url = URI("https://maven.shedaniel.me/") }
		maven { url = URI("https://maven.terraformersmc.com/releases/") }
		mavenCentral()
	}
}

plugins {
	`java-library`
}

dependencies {
}
