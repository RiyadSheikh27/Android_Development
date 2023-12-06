plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id ("kotlin-android")
    id ("kotlin-kapt")
    id ("dagger.hilt.android.plugin")
}

android {
    namespace = "com.rakibcse99.profileviewapps"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.rakibcse99.profileviewapps"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}
dependencies {

    //noinspection GradleDependency
    implementation("com.google.dagger:hilt-android:2.44")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation ("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    kapt("com.google.dagger:hilt-compiler:2.47")

    implementation ("androidx.navigation:navigation-fragment-ktx:2.7.4")
    implementation ("androidx.navigation:navigation-ui-ktx:2.7.4")
    implementation ("androidx.databinding:databinding-runtime:8.1.2")
    implementation ("com.google.android.gms:play-services-auth-api-phone:18.0.1")
    //viewmodel
    val lifecycle_version = "2.6.1"
    //noinspection GradleDependency
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    //lifecycle and viewModel
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    //coroutines
    val coroutinesVersion = "1.6.0"
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    //noinspection GradleDependency
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")

    // paging

    val retrofitVersion = "2.9.0"
    implementation ("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation ("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    // define a BOM and its version
    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.9.3"))
    debugImplementation ("com.github.chuckerteam.chucker:library:4.0.0")
    implementation ("com.squareup.okhttp3:logging-interceptor")
    // glide libary image load
    implementation ("com.github.bumptech.glide:glide:4.15.1")
    implementation("com.facebook.shimmer:shimmer:0.5.0")

}