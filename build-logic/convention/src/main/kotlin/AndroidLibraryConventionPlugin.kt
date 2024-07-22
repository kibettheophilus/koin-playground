import com.android.build.gradle.LibraryExtension
import com.google.devtools.ksp.gradle.KspExtension
import com.theophiluskibet.libs
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("com.google.devtools.ksp")
            }

            extensions.configure<LibraryExtension> {
                // For KSP
                libraryVariants.configureEach {
                    sourceSets {
                        getByName(name) {
                            kotlin.srcDir("build/generated/ksp/$name/kotlin")
                        }
                    }
                }

                compileSdk = 34
                defaultConfig {
                    minSdk = 24
                }
                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_17
                    targetCompatibility = JavaVersion.VERSION_17
                }
            }

            extensions.configure<KspExtension> {
                arg("KOIN_CONFIG_CHECK", "true")
            }

            dependencies {
                add("implementation", libs.findBundle("koin").get())
                add("ksp", libs.findLibrary("koin.compiler").get())
            }
        }
    }
}