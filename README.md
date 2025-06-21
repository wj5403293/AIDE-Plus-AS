![AIDEPlus](https://socialify.git.ci/AndroidIDE-CN/AIDE-Plus/image?description=1&font=KoHo&forks=1&issues=1&logo=https%3A%2F%2Fraw.githubusercontent.com%2FAndroidIDE-CN%2FAIDE-Plus%2Frefs%2Fheads%2F2.3%2F.idea%2Ficon.svg&name=1&owner=1&pattern=Circuit+Board&pulls=1&stargazers=1&theme=Auto)

> [!TIP]
> This project can only run on Gradle  
> For AIDE+ bootstrapping, please visit the **Main Project**

[**English**](README.md) 👈 |  
[中文](README_zh.md)

# 🛠️ AIDE-Plus

- [**Main Project**](https://github.com/AndroidIDE-CN/AIDE-Plus)

## 🪪 Repository Information
[![GitHub contributors](https://img.shields.io/github/contributors/AndroidIDE-CN/AIDE-Plus)](https://github.com/AndroidIDE-CN/AIDE-Plus/graphs/contributors)
[![GitHub last commit](https://img.shields.io/github/last-commit/AndroidIDE-CN/AIDE-Plus)](https://github.com/AndroidIDE-CN/AIDE-Plus/commits/)
[![Repository Size](https://img.shields.io/github/repo-size/AndroidIDE-CN/AIDE-Plus)](https://github.com/AndroidIDE-CN/AIDE-Plus)
[![GitHub Release](https://img.shields.io/github/v/release/AndroidIDE-CN/AIDE-Plus)](https://github.com/AndroidIDE-CN/AIDE-Plus/releases)
[![Total downloads](https://img.shields.io/github/downloads/AndroidIDE-CN/AIDE-Plus/total)](https://github.com/AndroidIDE-CN/AIDE-Plus/releases)

## 📝 Implemented Features
- [x] Build service optimization and rewrite
- [x] Replaced aapt with aapt2
- [x] Replaced dx with D8
- [x] Partial Java 8 syntax support (default syntax analysis)
- [x] Partial Java 9 syntax support (default syntax analysis)
- [x] Partial Java 11 syntax support (default syntax analysis)
- [x] Java 23 compilation (via ecj, requires enabling in settings)
- [x] Java formatting fixes (via ecj, requires enabling in settings)
- [x] Custom class parser for high-version class features
- [x] Implemented `runtimeOnly`, `compileOnly`, and `libgdxNatives`
- [x] Rewritten Gradle parser
- [x] New Maven downloader (BOM support added)
- [x] Application cold-start optimization
- [x] Added additional syntax highlighting
- [x] Obfuscation using D8
- [x] Replaced AIDE default framework with AndroidX
- [x] Partially deobfuscated AIDE's dex
- [x] Customizable code colors
- [x] ViewBinding support
- [x] ~~DataBinding support~~
- [x] Manifest merger tool update
- [x] Fixed silent installation and added support for more installers (Shizuku)
- [x] New UI implementation
- [x] Fixed completion and highlighting loss issues
- [x] Fixed keystore creation issues
- [x] ApkSign now supports v1-v3 signatures
- [x] Added basic syntax completions
- [x] Fixed Git integration issues
- [x] APK resource alignment
- [x] Android API support for Java projects
- [x] Lambda implementation (ecj) [fbf450d](https://github.com/AndroidIDE-CN/AIDE-Plus/commit/fbf450dba15ccaf51a7a6dd77db300d50551e98b)
- [x] CMake build support [e702347](https://github.com/AndroidIDE-CN/AIDE-Plus/commit/e702347df0c10b718df5aeb4798402802334e310)
- [x] Modified XML completion logic [0ecb637](https://github.com/AndroidIDE-CN/AIDE-Plus/commit/f7960418b9326231d55726514f10385396e9e8b6)
- [x] Added `exclude` support (exclude group: "xxx", module: "xxx")
- [x] Rewritten file explorer

### 🏗️ Planned Features
- [ ] Enhanced completions (LSP)
- [ ] APKs/AAB generation (not implemented)
- [ ] Manifest file editor
- [ ] Vector asset importer
- [ ] Rewritten layout visualizer

## 🌠 Related Resources
- [AIDE-Ndk-Install](https://github.com/ZeroAicy/AIDE-Ndk-Install) NDK Installer
- [AIDE-Repair](https://github.com/ZeroAicy/AIDE-Repair) Deobfuscation tool

# 📬️ Contact Information
- QQ Groups
  * [487145957](https://qm.qq.com/q/W0WJq5qne2)
  * [1002980489](https://qm.qq.com/q/W0WJq5qne2)
- [QQ Channel](https://pd.qq.com/s/auq589py2)
- [Website](https://plus.androidide.cn)

# 🏅 Special Thanks
> [!TIP]
> Contact us if you or your project should be listed here
### 😎 Project Contributors
- [@墨凡尘轩](https://github.com/ZeroAicy) Project Founder
- [@烂泥扶上墙](https://github.com/eirv) Project Collaborator
- [@原罪](https://github.com/neu233) Project Collaborator
- [@0047ol](https://github.com/0047ol) Project Collaborator
- [@hujiayucc](https://github.com/hujiayucc) Project Collaborator
- [@dev-bz](https://github.com/dev-bz) Provided assistance
### 🐱 Integrated Open-Source Projects
- [AndroidIDE](https://github.com/AndroidIDEOfficial/AndroidIDE)
- [Termux-app](https://github.com/termux/termux-app)
- [AIDE-Pro](https://github.com/AndroidIDE-CN/)
- [material-components-android](https://github.com/material-components/material-components-android)
- [androidx](https://github.com/androidx/androidx)
- [JetBrains-kotlin](https://github.com/JetBrains/kotlin)
- [google-apksig](https://android.googlesource.com/platform/tools/apksig)
- [Android-Build-Tools](https://android.googlesource.com/platform/frameworks/base/+/refs/heads/main/tools)
- [google-prefab](https://github.com/google/prefab)
- [plexus-utils](https://github.com/codehaus-plexus/plexus-utils)
- [maven-model](https://github.com/apache/maven)
- [commons-io](https://github.com/apache/commons-io)
- [desugar_jdk_libs](https://github.com/google/desugar_jdk_libs)
- [guava](https://github.com/google/guava)
- [gson](https://github.com/google/gson)
- [BRV](https://github.com/liangjingkanji/BRV)
- [TinyPinyin](https://github.com/promeG/TinyPinyin)
- [libsu](https://github.com/topjohnwu/libsu)
- [HiddenApiBypass](https://github.com/LSPosed/HiddenApiBypass)
- [XXPermissions](https://github.com/getActivity/XXPermissions)
- [MultiLanguages](https://github.com/getActivity/MultiLanguages)
- [okhttp](https://github.com/square/okhttp)
- [CXHttp](https://github.com/zhzc0x/CXHttp)
- [AndroidUtilCode](https://github.com/Blankj/AndroidUtilCode)
- [ViewBindingKTX](https://github.com/DylanCaiCoding/ViewBindingKTX)
- [SVG-Android](https://github.com/MegatronKing/SVG-Android)
- [android-ColorPickerPreference](https://github.com/attenzione/android-ColorPickerPreference)
- [Shizuku](https://github.com/RikkaApps/Shizuku)
- [protobuf](https://github.com/protocolbuffers/protobuf)
- [ksp](https://github.com/google/ksp)
- [Markwon](https://github.com/noties/Markwon)
- [osgi](https://github.com/osgi/osgi)
- [Java Formatter](https://github.com/eclipse-platform/eclipse.platform.text)
- [ECJ](https://github.com/eclipse-jdt/eclipse.jdt.core)
- [jgit](https://github.com/eclipse-jgit/jgit)
- [bc-java](https://github.com/bcgit/bc-java)
- [jdom](https://github.com/hunterhacker/jdom)
- [svg2android](https://github.com/RomainPiel/svg2android)
- [androidsvg](https://github.com/BigBadaboom/androidsvg)
- [FastScroll-Everywhere](https://github.com/Mixiaoxiao/FastScroll-Everywhere)
- [AppIconLoader](https://github.com/zhanghai/AppIconLoader)
- [Glide](https://github.com/bumptech/glide)
- ~~[jsoup](https://github.com/jhy/jsoup)~~
- ~~[zip4j](https://github.com/srikanth-lingala/zip4j)~~
- ~~[intellij-deps-trove4j](https://github.com/JetBrains/intellij-deps-trove4j)~~
- ~~[PhotoView](https://github.com/chrisbanes/PhotoView)~~
- ~~[SmartRefreshLayout](https://github.com/scwang90/SmartRefreshLayout)~~
- ~~[sora-editor](https://github.com/Rosemoe/sora-editor)~~
- ~~[Java Compiler for Android](https://github.com/itsaky/nb-javac-android)~~
- ~~[BlackObfuscator](https://github.com/CodingGay/BlackObfuscator)~~
- ~~[google-java-format](https://github.com/google/google-java-format)~~
- ~~[Kotlin-Formatting](https://github.com/facebook/ktfmt)~~
- ~~[google-auto](https://github.com/google/auto)~~
- ~~[JetBrains-compose-multiplatform](https://github.com/JetBrains/compose-multiplatform)~~
- ~~[VisualXML](https://github.com/Coyamo/VisualXML)~~
- ~~[App-UI-Designer](https://github.com/timscriptov/App-UI-Designer)~~
- ~~[RichPath](https://github.com/tarek360/RichPath)~~
- ~~[TreeView](https://github.com/dingyi222666/TreeView)~~
- ~~[Kotlinc-android](https://github.com/Cosmic-Ide/kotlinc-android)~~
- ~~[LSPosed](https://github.com/LSPosed/LSPosed)~~
- ~~[aosp-android-jar](https://github.com/Reginer/aosp-android-jar)~~
### 😊 Resource About
- [Github](https://github.com/)
- [Icon8](https://igoutu.cn/)
- [Google](https://fonts.google.com/icons)
- [Material3 Theme](https://material-foundation.github.io/material-theme-builder/)
- [Maven Repository](https://mvnrepository.com/)
- [Iconfont](https://www.iconfont.cn/)