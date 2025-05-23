# Automated Tests for QA Code Challenge (Appium - Android)

This repository contains automated test suites for the QA Code Challenge Android application, developed by Filipe Preto Alves, using Appium with Java and the Page Object Model (POM) pattern. The project now includes programmatic management of the Appium Server.

## Table of Contents

- [Introduction](#introduction)
- [Project Structure](#project-structure)
- [Setup](#setup)
- [Test Organization](#test-organization)
- [Authentication (Android)](#authentication-android)
- [Running Tests](#running-tests)
- [Appium Server Management](#appium-server-management)
- [Appium Configuration (Capabilities)](#appium-configuration-capabilities)
- [Reporting](#reporting)
- [Resources](#resources)
- [Troubleshooting](#troubleshooting)
- [License](#license)

## Introduction

This repository provides automated tests for the Android application QA Code Challenge. The goal is to ensure the application's stability and reliability by automating key functionalities using Appium for mobile automation. The project now incorporates the automatic starting and stopping of the Appium Server using the `io.appium.java-client` library.

## Project Structure

```

qacodechallengeHostelWorld/
├── .idea/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── Android/
│   │           ├── Android_BaseTest.java        # Base class for Android tests (Appium Server management, setup, teardown)
│   │           ├── Android_Environment.java     # Environment-related configurations (now receives Appium Server URL)
│   │           ├── Android_Locators.java        # Centralized locators for Android elements
│   │           └── Android_TestUtilities.java   # Utility functions for Android tests
│   │       └── Strings/
│   ├── resources/
│   │   └── log4j2.xml                          # Logging configuration
├── test/
│   └── Android/
│       ├── AccountCreation/                  # Test cases for account creation functionality
│       │   ├── accountcreationfieldsblank/
│       │   └── accountcreationhappypath/
│       └── LoginScreen/                       # Test cases for the login screen
│           └── loginscreenhappypath/
├── TestSuites/
│   └── AndroidTests_FullRegression.xml      # TestNG suite for full regression testing
├── target/
├── pom.xml                                  # Maven project configuration
└── README.md                                # This file
```


**Explanation of Key Directories:**

* `src/main/java/Android/`: Contains core classes for the Android test project, including the base test class with Appium Server management, environment configurations, locators, and utility functions.
* `src/main/java/Strings/`: Likely contains string resources used within the application or tests.
* `src/resources/`: Holds configuration files, such as the Log4j2 configuration for logging.
* `src/test/Android/AccountCreation/`: Contains test cases specifically for the account creation functionality, organized into subdirectories.
* `src/test/Android/LoginScreen/`: Contains test cases related to the login screen functionality, organized into subdirectories.
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
* **Node.js and npm (or yarn):** Required for the Appium Server (verify with `node -v` and `npm -v` or `yarn --version`). Ensure Node.js is in your system's PATH.
* **Appium Server:** While the server is managed programmatically, ensure Appium is installed (`npm install -g appium` or `yarn global add appium`).
* **Android Emulator/Simulator or Real Device:** Configured for testing.

### Installation

1.  **Clone the Repository:**
    ```bash
    git clone [github.com/filipepalves/qacodechallengeHostelWorld/](https://github.com/filipepalves/qacodechallengeHostelWorld/)
    cd qacodechallengeHostelWorld
    ```

2.  **Verify Dependencies:**
    Maven will automatically manage the dependencies defined in the `pom.xml` file during the build process.

3.  **Configure Test Environment:**
    * Ensure Node.js is installed and in your system's PATH.
    * Set up an Android emulator/simulator or connect a real Android device.
    * The Appium Server is now managed programmatically within `Android_BaseTest.java`. The server starts before the test suite and stops after.
    * The desired capabilities for Appium are configured in `Android_Environment.java`, which now receives the Appium Server URL. This includes details like `platformName`, `deviceName`, `appPackage`, `appActivity`.

## Test Organization

Test cases are located under the `src/test/Android/` directory, organized into subdirectories like `AccountCreation` and `LoginScreen`, indicating the specific functionalities being tested. TestNG annotations within the Java files define the individual test methods. Test suites for running groups of tests are defined in the `TestSuites/` directory.

## Authentication (Android)

Authentication testing for the Android application likely involves interacting with the user interface elements on the login screens. Test cases within the `LoginScreen` directory (and potentially other relevant directories) will automate the process of entering credentials and verifying successful or unsuccessful login attempts. Strategies to avoid repeated logins might be implemented in the `Android_BaseTest.java` or through specific test flow designs.

## Running Tests

You can execute the tests using Maven and TestNG:

1.  **Run all tests defined in the `pom.xml`:**
    ```bash
    mvn test
    ```
2.  **Run a specific test suite (e.g., the full regression suite):**
    ```bash
    mvn -Dsurefire.suiteXmlFiles=src/test/TestSuites/AndroidTests_FullRegression.xml test
    ```
3.  **Run a specific test class:**
    ```bash
    mvn -Dtest=scr/test/Android/LoginScreen/loginscreenhappypath test
    ```
## Appium Server Management

The Appium Server should be opened manually before running tests. Using command appium in the terminal.

## Appium Configuration (Capabilities)

The configuration for Appium, defining how it interacts with your Android device or emulator, is set up in the `Android_Environment.java` file. This involves defining Desired Capabilities such as `platformName`, `deviceName`, `appPackage`, `appActivity`. These capabilities tell Appium which device/application to automate.

Refer to the [official Appium documentation](http://appium.io/docs/en/caps/) for a comprehensive list of available capabilities.

## Reporting

Test execution reports will be generated by TestNG under the `target/surefire-reports` directory.

## Resources

* **Appium Documentation:** [http://appium.io/docs/en/](http://appium.io/docs/en/)
* **Appium Java Client:** [https://github.com/appium/java-client](https://github.com/appium/java-client)
* **Maven:** [https://maven.apache.org/](https://maven.apache.org/)
* **TestNG:** [https://testng.org/doc/index.html](https://testng.org/doc/index.html)
* **Allure Framework (for advanced reporting):** [https://allurereport.org/](https://allurereport.org/)

## Troubleshooting

* **`NodeJS is either not installed or its executable not present in PATH`:** Ensure Node.js is installed and accessible in your system's PATH. Restart your IDE after installation or PATH updates. You can verify the path using `which node` in the terminal.
* **Appium Server Connection Issues:** Verify that the Appium Server is starting correctly by checking the console output.
* **Emulator/Device Not Found:** Ensure your emulator/simulator is running or your real device is properly connected and recognized by ADB (`adb devices`). Verify the `deviceName` capability in your Appium configuration matches the name listed by ADB.
* **Application Not Installed or Package/Activity Issues:** Double-check the `appPackage` and `appActivity` capabilities in your Appium configuration to ensure they are correct for the application you are testing. If you are not using `noReset=true`, the application will be reinstalled for each session.
