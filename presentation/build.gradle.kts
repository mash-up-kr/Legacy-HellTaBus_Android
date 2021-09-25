plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = 30
    buildToolsVersion = "30.0.3"

    defaultConfig {
        minSdk = 23
        targetSdk = 30

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        viewBinding {
            isEnabled = true
        }
    }

    buildTypes {
        getByName("release")  {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    // Kotlin
    api(buildsrc.Libs.Kotlin.stdlib)

    // Android
    api(buildsrc.Libs.AndroidX.appcompat)
    api(buildsrc.Libs.AndroidX.constraintLayout)
    api(buildsrc.Libs.AndroidX.recyclerView)

    // Android KTX
    api(buildsrc.Libs.AndroidX.coreKtx)
    api(buildsrc.Libs.AndroidX.fragmentKtx)
    api(buildsrc.Libs.AndroidX.collectionKtx)

    // Android Architecture Components
    api(buildsrc.Libs.AndroidX.Lifecycle.viewModel)
    api(buildsrc.Libs.AndroidX.Lifecycle.liveData)
    api(buildsrc.Libs.AndroidX.Lifecycle.reactiveStream)
    api(buildsrc.Libs.AndroidX.Lifecycle.common)

    // Material
    api(buildsrc.Libs.material)

    // OkHttp
    api(platform(buildsrc.Libs.Network.OkHttp.bom))
    api(buildsrc.Libs.Network.OkHttp.okhttp)
    api(buildsrc.Libs.Network.OkHttp.logging)

    // Retrofit
    api(buildsrc.Libs.Network.Retrofit.retrofit)
    api(buildsrc.Libs.Network.Retrofit.gsonConverter)

    // Retrofit - Coroutine network response adapter
    //api "com.github.haroldadmin:NetworkResponseAdapter:4.1.0"

    // Glide
    api(buildsrc.Libs.Glide.glide)
    kapt(buildsrc.Libs.Glide.compiler)
    api(buildsrc.Libs.Glide.integration)
    api(buildsrc.Libs.Glide.transformation)

    // An adaptation of the JSR-310 backport for Android.
    api("com.jakewharton.threetenabp:threetenabp:1.2.1")
    testImplementation("org.threeten:threetenbp:1.4.0")

    // Test
    androidTestApi(buildsrc.Libs.AndroidX.Test.junit)
    androidTestApi(buildsrc.Libs.AndroidX.Test.espressoCore)
}