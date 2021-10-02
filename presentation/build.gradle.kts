plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
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
        
        dataBinding {
            isEnabled = true
        }
        
        viewBinding {
            isEnabled = true
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
    
    // Android
    implementation(buildsrc.Libs.AndroidX.appcompat)
    implementation(buildsrc.Libs.AndroidX.constraintLayout)
    implementation(buildsrc.Libs.AndroidX.recyclerView)
    
    // Android KTX
    implementation(buildsrc.Libs.AndroidX.coreKtx)
    implementation(buildsrc.Libs.AndroidX.fragmentKtx)
    implementation(buildsrc.Libs.AndroidX.collectionKtx)
    
    // Android Architecture Components
    implementation(buildsrc.Libs.AndroidX.Lifecycle.viewModel)
    implementation(buildsrc.Libs.AndroidX.Lifecycle.liveData)
    implementation(buildsrc.Libs.AndroidX.Lifecycle.reactiveStream)
    implementation(buildsrc.Libs.AndroidX.Lifecycle.common)
    
    // Hilt
    implementation(buildsrc.Libs.Hilt.hilt)
    implementation("androidx.test:monitor:1.4.0")
    implementation(buildsrc.Libs.Hilt.viewModel)
    kapt(buildsrc.Libs.Hilt.androidCompiler)
    kapt(buildsrc.Libs.Hilt.hiltCompiler)
    
    // Material
    implementation(buildsrc.Libs.material)
    
    // OkHttp
    implementation(platform(buildsrc.Libs.Network.OkHttp.bom))
    implementation(buildsrc.Libs.Network.OkHttp.okhttp)
    implementation(buildsrc.Libs.Network.OkHttp.logging)
    
    // Retrofit
    implementation(buildsrc.Libs.Network.Retrofit.retrofit)
    implementation(buildsrc.Libs.Network.Retrofit.gsonConverter)
    
    // Retrofit - Coroutine network response adapter
    //api "com.github.haroldadmin:NetworkResponseAdapter:4.1.0"
    
    // Glide
    implementation(buildsrc.Libs.Glide.glide)
    implementation(buildsrc.Libs.Glide.integration)
    implementation(buildsrc.Libs.Glide.transformation)
    kapt(buildsrc.Libs.Glide.compiler)
    
    // An adaptation of the JSR-310 backport for Android.
    implementation("com.jakewharton.threetenabp:threetenabp:1.2.1")
    testImplementation("org.threeten:threetenbp:1.4.0")
    
    // Test
    androidTestApi(buildsrc.Libs.AndroidX.Test.junit)
    androidTestApi(buildsrc.Libs.AndroidX.Test.espressoCore)
}
