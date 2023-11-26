
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.newsinshorts"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.newsinshorts"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Dependencies.coreKtx)
    implementation(Dependencies.lifecycleRuntime)
    implementation(Dependencies.activityCompose)
    implementation(platform(Dependencies.composeBom))
    implementation(Dependencies.ComposeUI)
    implementation(Dependencies.ComposeGraphics)
    implementation(Dependencies.ComposeToolingPreview)
    implementation(Dependencies.Composematerial3)
    implementation(project(mapOf("path" to ":buildSrc")))
    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.testExtJunit)
    androidTestImplementation(Dependencies.testEspresso)
    androidTestImplementation(platform(Dependencies.composeBomTest))
    androidTestImplementation(Dependencies.testJunit4)
    debugImplementation(Dependencies.tooling)
    debugImplementation(Dependencies.testManifest)

    implementation(project(Modules.utilities))
    
    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltCompiler)

    // For instrumentation tests
    androidTestImplementation(Dependencies.androidTestImplementaiton)
    kaptAndroidTest(Dependencies.androidTestAnnotationProcess)

    // For local unit tests
    testImplementation(Dependencies.hiltAndroidTesting)
    kaptTest(Dependencies.hiltCompilerTest)

    implementation(Dependencies.hiltNavigationCompose)

    implementation(Dependencies.retrofit)
    implementation(Dependencies.gsonConverter)
    implementation(Dependencies.okhttp)
    implementation(Dependencies.moshi)
    implementation(Dependencies.moshiConverter)
    implementation(Dependencies.loggingInterceptor)
}

kapt {
    correctErrorTypes = true
}