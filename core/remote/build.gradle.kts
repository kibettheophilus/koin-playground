plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlin.serialization)
}

ksp {
    arg("KOIN_CONFIG_CHECK", "true")
}

dependencies {
    // koin
    implementation(libs.bundles.koin)
    ksp(libs.koin.compiler)

    // ktor
    implementation(libs.bundles.ktor)

    testImplementation("io.ktor:ktor-client-mock:2.3.11")
}


android {
    namespace = "com.theophiluskibet.remote"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
        targetSdk = 34
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    // For KSP
    libraryVariants.configureEach {
        kotlin.sourceSets {
            getByName(name) {
                kotlin.srcDir("build/generated/ksp/${name}/kotlin")
            }
        }
    }
}
