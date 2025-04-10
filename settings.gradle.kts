pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        mavenLocal()
    }
}

rootProject.name = "WeatherNowAndLater"
include(":app", ":core", ":data")
include(":features:cityinput", ":features:currentweather", ":features:forecast")

project(":features:cityinput").projectDir = file("features/cityinput")
project(":features:currentweather").projectDir = file("features/currentweather")
project(":features:forecast").projectDir = file("features/forecast")
