import xyz.jpenilla.resourcefactory.paper.PaperPluginYaml

plugins {
    java
    id("xyz.jpenilla.resource-factory-paper-convention") version "1.2.1"
    id("xyz.jpenilla.run-paper") version "2.3.1"
}

description = "MBedwars Expansion for MiniPlaceholders"
version = "1.0.0-SNAPSHOT"

dependencies {
    compileOnly("io.github.miniplaceholders:miniplaceholders-api:2.3.0")
    compileOnly("io.papermc.paper:paper-api:1.21-R0.1-SNAPSHOT")
    compileOnly("de.marcely.bedwars:API:5.5.3")
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://repo.marcely.de/repository/maven-public/")
}

java.toolchain.languageVersion.set(JavaLanguageVersion.of(21))

tasks {
    compileJava {
        options.encoding = Charsets.UTF_8.name()
    }
    runServer {
        minecraftVersion("1.21.4")
        downloadPlugins {
            modrinth("miniplaceholders", "wck4v0R0")
        }
    }
}

paperPluginYaml {
    main = "io.github.miniplaceholders.expansion.mbedwars.paper.PaperPlugin"
    apiVersion = "1.21"
    authors.add("FabianAdrian")
    foliaSupported = true
    dependencies {
        server {
            register("MiniPlaceholders") {
                required = true
                load = PaperPluginYaml.Load.BEFORE
            }
            register("MBedwars") {
                required = true
                load = PaperPluginYaml.Load.BEFORE
            }
        }
    }
}
