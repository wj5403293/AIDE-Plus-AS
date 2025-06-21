plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "me.zhanghai.android.appiconloader"
    compileSdk = 35

    defaultConfig {
        minSdk = 24
    }

}

dependencies {

    api(libs.bundles.google.androidx)

    // glide
    implementation(libs.io.github.bumptech.glide)
    annotationProcessor(libs.io.github.bumptech.glideCompiler)

    //coil
    implementation(libs.io.coil.kt.base)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}