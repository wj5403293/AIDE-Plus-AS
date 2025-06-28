import gradleExt.Versions
import gradleExt.copyDirectory

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

val namespaceHashMap = mutableMapOf(
    "app_rewrite" to "com.aide.ui.rewrite",
    "appAideBase" to "com.aide.ui.base"
)


android {

    val currentProject = project.layout.projectDirectory.asFile
    val currentProjectName = currentProject.name
    val rootProjectDir = File(currentProject.parentFile, "AIDE-Plus")
    namespace = namespaceHashMap[currentProjectName]
    compileSdk = Versions.compileSdk

    defaultConfig {
        minSdk = Versions.minSdk
    }

    sourceSets {
        val main by getting
        main.apply {
            try {
                val manifestFile =
                    rootProjectDir.resolve("${currentProjectName}/src/main/AndroidManifest.xml")
                val newManifestFile =
                    currentProject.resolve("AndroidManifest.xml")
                // 复制和替换 AndroidManifest
                if (newManifestFile.exists()) {
                    newManifestFile.delete()
                }
                if (manifestFile.exists()) {
                    manifestFile.copyTo(newManifestFile)
                    // 替换掉原本的包名防止合并的时候出现异常
                    val content = newManifestFile.readText()
                    val pattern = "package=\".*?\"".toRegex()
                    val updatedContent = content.replace(pattern, "")
                    newManifestFile.writeText(updatedContent)
                    manifest.srcFile(newManifestFile)
                }

                val javaSrcDir = rootProjectDir.resolve("${currentProjectName}/src/main/java")
                if (javaSrcDir.exists()) {
                    java.setSrcDirs(listOf(javaSrcDir, rootDir.resolve("Rewrite/java")))
                }

                val resSrcDir = rootProjectDir.resolve("${currentProjectName}/src/main/res")
                val newResDir = currentProject.resolve("res")
                if (newResDir.exists()) {
                    newResDir.deleteRecursively()
                }
                if (resSrcDir.exists()) {
                    // 复制res到新目录
                    copyDirectory(
                        resSrcDir,
                        newResDir,
                        { _ -> }
                    )
                    if (currentProject.absolutePath.endsWith("appAideBase")) {
                        val valueAttrXml = rootDir.resolve("Submodule/AIDE/attrs.xml")
                        currentProject.resolve("res/values/attrs.xml").apply {
                            valueAttrXml.copyTo(this,true)
                        }
                    } else if (currentProject.absolutePath.endsWith("app_rewrite")) {
                        val valueColorXml = rootDir.resolve("Submodule/AIDE/colors.xml")
                        currentProject.resolve("res/values-v21/colors.xml").apply {
                            valueColorXml.copyTo(this,true)
                        }
                        currentProject.resolve("res/values-v21/colors_ui.xml")
                            .apply { if (exists()) delete() }
                    }
                    res.setSrcDirs(listOf(newResDir,rootDir.resolve("Rewrite/res")))
                }

                val jniLibsSrcDir = rootProjectDir.resolve("${currentProjectName}/src/main/jniLibs")
                if (jniLibsSrcDir.exists()) {
                    jniLibs.setSrcDirs(listOf(jniLibsSrcDir))
                }

                val assetsSrcDir = rootProjectDir.resolve("${currentProjectName}/src/main/assets")
                if (assetsSrcDir.exists()) {
                    assets.setSrcDirs(listOf(assetsSrcDir,rootDir.resolve("Rewrite/assets")))
                }

                val resourcesSrcDir =
                    rootProjectDir.resolve("${currentProjectName}/src/main/resources")
                if (resourcesSrcDir.exists()) {
                    resources.setSrcDirs(listOf(resourcesSrcDir))
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }

}
