# WeatherNowAndLater

**WeatherNowAndLater** is an Android application that provides weather information—including current conditions and a multi-day forecast—for a user-specified city. The project is built using a modular, clean architecture with separate modules for core utilities, data handling, and feature-specific UIs. Dependency Injection is managed with Dagger Hilt, and the UI is implemented using Jetpack Compose. The app includes unit tests to ensure reliability.

---

## Table of Contents

- [Overview](#overview)
- [Architecture and Modules](#architecture-and-modules)
- [Features](#features)
- [CI/CD Pipeline](#cicd-pipeline)
- [Testing](#testing)
- [Screenshots](#screenshots)
- [How to Run](#how-to-run)
- [License](#license)

---

## Overview

**WeatherNowAndLater** is designed for a clean and modular approach to displaying weather data. It retrieves current conditions and a multi-day forecast for a given city using remote API calls and presents the data in a responsive UI with Jetpack Compose. The app is built with both MVVM and MVI patterns for different features, making it scalable and maintainable.

---

## Architecture and Modules

The project is divided into the following modules:

- **App Module:**  
  Contains the main entry point of the application including the `MainActivity`, which hosts the navigation graph and combined screens that integrate UI components from feature modules.

- **Core Module:**  
  Provides common utilities such as reusable Composables (e.g., for weather icons and Lottie animations).

- **Data Module:**  
  Manages remote data sources and DTOs.

- **Features Modules:**  
  - **CityInput Module:**  
    Implements the UI and logic for allowing users to input a city name. Uses MVVM for state management and persists the city in local storage.
  - **CurrentWeather Module:**  
    Displays current weather details (temperature, condition, icons, etc.) using MVVM and integrates with the Data module.
  - **Forecast Module:**  
    Shows a multi-day weather forecast using an MVI pattern. This module groups forecast data by day, calculates min/max temperatures, and displays custom icons.

---

## Features

- **Clean Architecture & Modularization:**  
  The code is organized to separate UI, domain logic, and data sources across distinct modules.

- **Dependency Injection (Dagger Hilt):**  
  All dependencies are managed using Dagger Hilt, ensuring scalable and testable code.

- **Modern UI with Jetpack Compose:**  
  The UI uses Jetpack Compose for a responsive, dynamic design.

- **CI/CD Pipeline:**  
  A GitHub Actions workflow (conceptually configured) automatically:
  - Lints the code,
  - Runs unit tests,
  - Builds the release APK,
  - And uploads the APK as an artifact for easy download.

- **Testing:**  
  Comprehensive unit tests have been implemented:
  - **CityInputViewModelTest** ensures proper handling of user input and navigation.
  - **CurrentWeatherViewModelTest** verifies state transitions during weather fetching.
  - **ForecastViewModelTest** (using an MVI architecture) confirms proper forecast data processing and state emissions.
  - **Mappers Testing:** Additional unit tests have been written to validate data mappers that convert API DTOs into domain models.

---

## CI/CD Pipeline

The project uses GitHub Actions for the CI/CD pipeline. The CI configuration is set up to automatically build and test the app on every push or pull request to the `main` branch. It checks out the code, sets up JDK 17, caches Gradle dependencies, validates the Gradle wrapper, builds a release APK, runs unit tests, and uploads the APK as an artifact.

---

## Screenshots

Below are key screenshots of the app arranged side-by-side:

| ![City Input Screen](![Image](https://github.com/user-attachments/assets/76ebf582-1320-46ba-979f-e3d47b446696)) | ![Current Weather Screen](![Image](https://github.com/user-attachments/assets/fdc4589b-859e-4f5c-800c-2c66ee209d9f)) | ![Forecast Screen](![Image](https://github.com/user-attachments/assets/5ba4cb52-ab8f-4c2e-b4b8-f9175a40c570)) |
| --------------------------------------------- | --------------------------------------------- | --------------------------------------------- |

---

## How to Run

### Prerequisites
- **Android Studio** or your preferred IDE.
- **JDK 17** installed locally.
- Gradle version as specified in `gradle-wrapper.properties`.
- GitHub Actions is configured to run CI/CD automatically on push.

### Steps

1. **Clone the Repository:**
   ```bash
   git clone <repository-url>
   cd WeatherNowAndLater
