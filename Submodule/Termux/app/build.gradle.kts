
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("aide-termux.project")
}

dependencies {
    api(projects.submodule.termux.termuxShared)
    api(projects.submodule.termux.terminalView)
    api(projects.submodule.termux.terminalEmulator)
}