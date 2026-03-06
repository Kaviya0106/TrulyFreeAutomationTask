# TruelyFreeHome Automation Testing Project

## Project Overview

This project is an **Automation Testing Framework** developed to test the **Truely Free Home website** using **Selenium WebDriver with Java**.

The framework follows the *TestNG*, which helps to separate test logic from page elements. This improves code readability, reusability, and maintainability.

The automation suite validates different functionalities of the website such as navigation, user actions, and form interactions.

Main website used for automation testing:

👉 https://trulyfreehome.dev/

---

# Framework Used

This project is built using the following tools and technologies:

* Java – Programming language used for writing test scripts
* Selenium WebDriver – Used for browser automation
* TestNG – Test framework for executing test cases
* Maven – Build management and dependency management tool
* **ChromeDriver** – Used to run tests on Google Chrome browser

---

# Setup Instructions

Follow these steps to run the project on your system.

### 1 Install Java

Download and install **JDK 8 or higher**.

Verify installation:

```
java -version
```

---

### 2 Install Maven

Download Maven and verify installation.

```
mvn -version
```

---

### 3 Install IDE

Recommended IDE:

* Eclipse

Import the project as **Maven Project**.

---

### 4 Download ChromeDriver

Download ChromeDriver matching your Chrome version.

Place it in system path or configure in project.

---

### 5 Install Dependencies

Run the following command to download all required libraries:

```
mvn clean install
```

---

# How to Run the Project

### Method 1 – Using TestNG (Recommended)

1 Open the project in IDE
2 Navigate to the **testcases folder**
3 Right click the test file
4 Select **Run As → TestNG Test**

---

### Method 2 – Using Maven

Run the following command in project directory:

```
mvn test
```

---

# Folder Structure Explanation

Below is the structure of the automation framework.

```
src
 ├── main
 │   ├── java
 │   └── resources
 │
 └── test
     ├── java
     │   ├── base
     │   ├── locators
     │   ├── testscases
     │   └── utils
     │
     └── resources
```

### base

Contains **BaseClass** which handles:

* Browser setup
* Driver initialization
* Opening website
* Closing browser
* Screenshot capture on failure

---

### locators

Contains **Page Object Model locator classes**.

Example:

* Login page elements
* Buttons
* Input fields

All web elements are stored here using Selenium locators like:

```
By.id
By.xpath
By.name
```

---

### testscases

Contains all **TestNG test cases**.

Each test case verifies a functionality of the website.

Example:

* Verify homepage loads
* Verify user interactions
* Verify navigation

---

### utils

Contains **Reusable utility classes** such as:

* WaitUtil → Explicit waits
* ScreenshotUtil → Capture screenshot when test fails

---

### resources

Used for configuration files or test data.

---

### target

Generated automatically by **Maven build**.

Contains:

* Compiled files
* Test reports
* Generated sources

---

### test-output

Contains **TestNG execution reports**.

Includes:

* Test results
* Execution summary
* Screenshots for failed test cases

---

# Main Home Page of the Website

The automation testing is performed on the following website:

```
https://trulyfreehome.dev/
```

This is the **main homepage** used for validating UI elements and user interactions.

---

# Key Features of the Framework

* TestNG
* Screenshot capture for failed tests
* Reusable wait utilities
* Structured folder organization
* Maven dependency management
* TestNG reporting
