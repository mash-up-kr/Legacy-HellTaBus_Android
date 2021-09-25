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

        sourceSets {
            getByName("main").java.srcDir("src/main/kotlin")
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
    implementation(project(":domain"))
    
    // Kotlin
    implementation(buildsrc.Libs.Kotlin.stdlib)
    
    // OkHttp
    implementation(platform(buildsrc.Libs.Network.OkHttp.bom))
    implementation(buildsrc.Libs.Network.OkHttp.okhttp)
    implementation(buildsrc.Libs.Network.OkHttp.logging)
    
    // Retrofit
    api(buildsrc.Libs.Network.Retrofit.retrofit)
    api(buildsrc.Libs.Network.Retrofit.gsonConverter)
    
    // Retrofit - Coroutine network response adapter
    //api "com.github.haroldadmin:NetworkResponseAdapter:4.1.0"
    
    // An adaptation of the JSR-310 backport for Android.
    implementation("com.jakewharton.threetenabp:threetenabp:1.2.1")
    testImplementation("org.threeten:threetenbp:1.4.0")
    
    // Test
    androidTestApi(buildsrc.Libs.AndroidX.Test.junit)
    androidTestApi(buildsrc.Libs.AndroidX.Test.espressoCore)

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1")
}
