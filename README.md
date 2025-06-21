![AIDEPlus](https://socialify.git.ci/AndroidIDE-CN/AIDE-Plus-AS/image?description=1&font=KoHo&forks=1&issues=1&logo=https%3A%2F%2Fraw.githubusercontent.com%2FAndroidIDE-CN%2FAIDE-Plus%2Frefs%2Fheads%2F2.3%2F.idea%2Ficon.svg&name=1&owner=1&pattern=Circuit+Board&pulls=1&stargazers=1&theme=Auto)


> [!TIP]
> This project is built using Android Studio
> It uses Kotlin, so AIDE+ cannot be self-hosted
> If you want self-hosting, please visit the main project



**English** 👈 |
[**中文**](README_zh.md)


# 🛠️ AIDE-Plus

- [Main Project](https://github.com/AndroidIDE-CN/AIDE-Plus)

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
- [x] Implementation of some Java 8 syntax (default syntax analysis)
- [x] Implementation of some Java 9 syntax (default syntax analysis)
- [x] Implementation of some Java 11 syntax (default syntax analysis)
- [x] Java 23 compilation (implemented through ecj, needs to be enabled in settings)
- [x] High version Java formatting (implemented through ecj, needs to be enabled in settings)
- [x] Custom class parser to implement high version class features
- [x] Implemented `runtimeOnly`, `compileOnly`, `libgdxNatives`
- [x] Rewritten Gradle parser
- [x] New Maven downloader (bom supported)
- [x] Application cold start optimization
- [x] Added more syntax highlighting
- [x] Using D8 for obfuscation
- [x] Replaced AIDE default framework with Androidx
- [x] Restored some of AIDE's dex obfuscation
- [x] Custom code colors
- [x] ViewBinding support
- [x] DataBinding support
- [x] Manifest merger tool update
- [x] Fixed silent installation and support for more installers (shizuku)
- [x] New UI implementation
- [x] Fixed completion and highlighting loss issues
- [x] Fixed signature creation issues
- [x] ApkSign now supports v1-v4 signatures
- [x] Added some basic syntax completions
- [x] Fixed git issues within the software
- [x] APK resource alignment
- [x] Java projects support Android API
- [x] Lambda implementation (ecj) [fbf450d](https://github.com/AndroidIDE-CN/AIDE-Plus/commit/fbf450dba15ccaf51a7a6dd77db300d50551e98b)
- [x] CMake build support [e702347](https://github.com/AndroidIDE-CN/AIDE-Plus/commit/e702347df0c10b718df5aeb4798402802334e310)
- [x] Modified XML completion logic [0ecb637](https://github.com/neu233/AIDE-Plus/commit/0ecb637e6cb672723df77925e5642fd4b6016c39)
- [x] File browser rewritten


### 🏗️ Planned Features
- [ ] More completions (LSP)
- [ ] Apks/AAB generation (not added)
- [ ] Manifest file editing
- [ ] Vector graphics acquisition
- [ ] Layout visualization rewrite

## 🌠 Related Resources
- [AIDE-Ndk-Install](https://github.com/ZeroAicy/AIDE-Ndk-Install) NDK Installer
- [AIDE-Repair](https://github.com/ZeroAicy/AIDE-Repair) Deobfuscation

# 📬️ Related Information
- QQ Groups
  * [487145957](https://qm.qq.com/q/W0WJq5qne2)
  * [1002980489](https://qm.qq.com/q/W0WJq5qne2)
- [QQ Channel](https://pd.qq.com/s/auq589py2)
- [Website](https://plus.androidide.cn)

# 🏅 Special Thanks
> [!TIP]
> If you or your project is not listed, please contact us to add it

### 😎 Project Related
- [@墨凡尘轩](https://github.com/ZeroAicy) Project Founder
- [@烂泥扶上墙](https://github.com/eirv) Project Collaborator
- [@原罪](https://github.com/neu233) Project Collaborator
- [@0047ol](https://github.com/0047ol) Project Collaborator
- [@hujiayucc](https://github.com/hujiayucc) Project Collaborator
- [@dev-bz](https://github.com/dev-bz) (不知者来此) Provided assistance

### 🐱 Open Source Integration
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
- ~~[jsoup](https://github.com/jhy/jsoup)~~
- ~~[zip4j](https://github.com/srikanth-lingala/zip4j)~~
- ~~[intellij-deps-trove4j](https://github.com/JetBrains/intellij-deps-trove4j)~~
- ~~[PhotoView](https://github.com/chrisbanes/PhotoView)~~
- ~~[SmartRefreshLayout](https://github.com/scwang90/SmartRefreshLayout)~~
- ~~[sora-editor](https://github.com/Rosemoe/sora-editor)~~
- ~~[Java Compiler for Android](https://github.com/itsaky/nb-javac-android)~~
- ~~[Glide](https://github.com/bumptech/glide)~~
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
### 😊 Related Resources
- [Github](https://github.com/)
- [Icon8](https://igoutu.cn/)
- [Google](https://fonts.google.com/icons)
- [Material3 Theme](https://material-foundation.github.io/material-theme-builder/)
- [Maven Repository](https://mvnrepository.com/)
- [阿里矢量图](https://www.iconfont.cn/)

