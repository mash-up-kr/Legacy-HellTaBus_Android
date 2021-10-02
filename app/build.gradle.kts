plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 30
    buildToolsVersion = "30.0.3"
    
    defaultConfig {
        applicationId = "com.mashup.helltabus"
        minSdk = 23
        targetSdk = 30
        versionCode = buildsrc.Versions.App.major * 1000 +
            buildsrc.Versions.App.feature * 100 +
            buildsrc.Versions.App.regular * 10 +
            buildsrc.Versions.App.minor
        versionName =
            "${buildsrc.Versions.App.major}.${buildsrc.Versions.App.feature}.${buildsrc.Versions.App.regular}.${buildsrc.Versions.App.minor}"
        
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    implementation(project(":presentation"))
    implementation(project(":domain"))
    implementation(project(":data"))

    // Material
    implementation(buildsrc.Libs.material)

    // Hilt
    implementation(buildsrc.Libs.Hilt.hilt)
    implementation("androidx.test:monitor:1.4.0")
    implementation(buildsrc.Libs.Hilt.viewModel)
    kapt(buildsrc.Libs.Hilt.androidCompiler)
    kapt(buildsrc.Libs.Hilt.hiltCompiler)
}
