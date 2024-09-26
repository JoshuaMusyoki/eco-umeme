plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.realm.kotlin)
}

android {
    namespace = "com.ecoumeme.ecoumeme"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.ecoumeme.ecoumeme"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation("io.insert-koin:koin-android:3.6.0-Beta4")
    implementation("io.insert-koin:koin-androidx-compose:3.6.0-Beta4")
    implementation("io.insert-koin:koin-androidx-workmanager:3.6.0-Beta4")
    implementation("io.insert-koin:koin-androidx-navigation:3.6.0-Beta4")
    //implementation("io.insert-koin:koin-androidx-viewmodel:3.6.0-Beta4")
    //api(libs.koin.core)
    //api(libs.koin.core)
    //implementation(libs.koin.compose)
    //implementation(libs.koin.compose.viewmodel)
    //implementation(libs.koin.androidx.compose)
    //implementation(libs.koin.androidx.)
    implementation(libs.ktor.client.okhttp)
    implementation(libs.lifecycle.viewmodel)
    implementation(libs.navigation.compose)

    implementation(libs.bundles.ktor)
    implementation(libs.coil.compose.core)
    implementation(libs.coil.network.ktor)
    implementation(libs.coil.compose)

    implementation(libs.realm.core)

    //implementation(project.dependencies.platform("io.insert-koin:koin-bom:$koin_version"))
}