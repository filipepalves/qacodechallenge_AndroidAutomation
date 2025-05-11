# Automated Tests for QA Code Challenge (Appium - Android)

This repository contains automated test suites for the QA Code Challenge Android application, developed by Filipe Preto Alves, using Appium with Java and the Page Object Model (POM) pattern.

## Table of Contents

- [Introduction](#introduction)
- [Project Structure](#project-structure)
- [Setup](#setup)
- [Test Organization](#test-organization)
- [Authentication (Android)](#authentication-android)
- [Running Tests](#running-tests)
- [Appium Configuration (Capabilities)](#appium-configuration-capabilities)
- [Reporting](#reporting)
- [Resources](#resources)
- [Troubleshooting](#troubleshooting)
- [License](#license)

## Introduction

This repository provides automated tests for the Android application QA Code Challenge. The goal is to ensure the application's stability and reliability by automating key functionalities using Appium for mobile automation.

## Project Structure

```

qacodechallengeHostelWorld/
├── .idea/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── Android/
│   │           ├── Android_BaseTest.java        # Base class for Android tests (setup, teardown)
│   │           ├── Android_Environment.java     # Environment-related configurations
│   │           ├── Android_Locators.java        # Centralized locators for Android elements
│   │           └── Android_TestUtilities.java   # Utility functions for Android tests
│   │       └── Strings/
│   ├── resources/
│   │   └── log4j2.xml                          # Logging configuration
├── test/
│   └── Android/
│       ├── Login1stTime/                      # Test cases for the initial login flow
│       └── LoginScreen/                       # Test cases for the login screen
├── TestSuites/
│   └── AndroidTests_FullRegression.xml      # TestNG suite for full regression testing
├── target/
├── pom.xml                                  # Maven project configuration
└── README.md                                # This file
```


**Explanation of Key Directories:**

* `src/main/java/Android/`: Contains core classes for the Android test project, including a base test class, environment configurations, locators, and utility functions.
* `src/main/java/Strings/`: Likely contains string resources used within the application or tests.
* `src/resources/`: Holds configuration files, such as the Log4j2 configuration for logging.
* `src/test/Android/Login1stTime/`: Contains test cases specifically for the initial login scenario.
* `src/test/Android/LoginScreen/`: Contains test cases related to the login screen functionality.
* `TestSuites/`: Includes TestNG suite definition files (e.g., `AndroidTests_FullRegression.xml`) for organizing and running test sets.
* `target/`: The default output directory for Maven build artifacts.
* `pom.xml`: The Maven project configuration file, defining dependencies and build settings.
* `README.md`: This file, providing an overview of the project.

## Setup

### Prerequisites

Ensure you have the following installed:

* **Java Development Kit (JDK):** Version 17 or higher (verify with `java -version`).
* **Maven:** For managing dependencies and running tests (verify with `mvn -version`).
* **Android SDK:** Installed and `ANDROID_HOME` environment variable configured (verify with `echo $ANDROID_HOME`).
* **Appium Server:** Installed and running (can be started manually or programmatically).
* **Android Emulator/Simulator or Real Device:** Configured for testing.

### Installation

1.  **Clone the Repository:**
    ```bash
    git clone <github.com/filipepalves/qacodechallengeHostelWorld/>
    cd qacodechallengeHostelWorld
    ```

2.  **Verify Dependencies:**
    Maven will automatically manage the dependencies defined in the `pom.xml` file during the build process.

3.  **Configure Test Environment:**
    * Ensure the Appium Server is running.
    * Set up an Android emulator/simulator or connect a real Android device.
    * Configure the desired capabilities for Appium in your test setup (likely within `Android_BaseTest.java` or a related configuration). This includes details like `platformName`, `deviceName`, `appPackage`, `appActivity`, and the Appium server URL.

## Test Organization

Test cases are located under the `src/test/Android/` directory, organized into subdirectories like `Login1stTime` and `LoginScreen`, indicating the specific functionalities being tested. TestNG annotations (e.g., `@Test`) within the Java files define the individual test methods. Test suites for running groups of tests are defined in the `TestSuites/` directory (e.g., `AndroidTests_FullRegression.xml`).

## Authentication (Android)

Authentication testing for the Android application likely involves interacting with the user interface elements on the login screens. Test cases within the `LoginScreen` directory (and potentially `Login1stTime` for initial login scenarios) will automate the process of entering credentials and verifying successful or unsuccessful login attempts. Strategies to avoid repeated logins might be implemented in the `Android_BaseTest.java` or through specific test flow designs.

## Running Tests

You can execute the tests using Maven and TestNG:

1.  **Run all tests defined in the `pom.xml`:**
    ```bash
    mvn test
    ```

2.  **Run a specific test suite (e.g., the full regression suite):**
    ```bash
    mvn -Dsurefire.suiteXmlFiles=TestSuites/AndroidTests_FullRegression.xml test
    ```

3.  **Run a specific test class:**
    ```bash
    mvn -Dtest=com.Android.LoginScreen test
    ```

## Appium Configuration (Capabilities)

The configuration for Appium, defining how it interacts with your Android device or emulator, is typically set up in the `Android_BaseTest.java` file. This involves defining Desired Capabilities such as `platformName`, `deviceName`, `appPackage`, `appActivity`, and the URL of the Appium server. These capabilities tell Appium which device/application to automate.

Refer to the [official Appium documentation](http://appium.io/docs/en/caps/) for a comprehensive list of available capabilities.

## Reporting

Test execution reports will be generated by TestNG, usually in XML and basic HTML formats under the `target/surefire-reports` directory. For more advanced and detailed reporting, consider integrating a reporting framework like the [Allure Framework](https://allurereport.org/) by adding its dependencies to the `pom.xml` and configuring the TestNG listener.

## Resources

* **Appium Documentation:** [http://appium.io/docs/en/](http://appium.io/docs/en/)
* **Appium Java Client:** [https://github.com/appium/java-client](https://github.com/appium/java-client)
* **Maven:** [https://maven.apache.org/](https://maven.apache.org/)
* **TestNG:** [https://testng.org/doc/index.html](https://testng.org/doc/index.html)
* **Allure Framework (for advanced reporting):** [https://allurereport.org/](https://allurereport.org/)
