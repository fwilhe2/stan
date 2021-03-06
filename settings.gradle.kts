pluginManagement {
    resolutionStrategy {
        eachPlugin {
            // Work around https://github.com/gradle/gradle/issues/1697.
            if (requested.id.namespace != "org.gradle" && requested.version == null) {
                val versionPropertyName = if (requested.id.id.startsWith("org.jetbrains.kotlin.")) {
                    "kotlinPluginVersion"
                } else {
                    val pluginNameNoSuffix = requested.id.name.split('-').joinToString("") {
                        it.capitalize()
                    }.decapitalize().let { pluginName ->
                        pluginName.takeUnless { it.toLowerCase().endsWith("plugin") } ?: pluginName.dropLast(6)
                    }


                    "${pluginNameNoSuffix}PluginVersion"
                }

                logger.info("Checking for plugin version property '$versionPropertyName'.")

                gradle.rootProject.properties[versionPropertyName]?.let { version ->
                    logger.info("Setting '${requested.id.id}' plugin version to $version.")
                    useVersion(version.toString())
                } ?: logger.warn("No version specified for plugin '${requested.id.id}' and property " +
                        "'$versionPropertyName' does not exist.")
            }
        }
    }
}

include("cli")
include("gui")
include("lib")
