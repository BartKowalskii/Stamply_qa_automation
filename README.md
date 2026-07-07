# Stamply Web Application UI Test Automation

![Java](https://img.shields.io/badge/Java-17-orange)
![Selenium](https://img.shields.io/badge/Selenium-4-green)
![JUnit 5](https://img.shields.io/badge/JUnit-5-red)
![Maven](https://img.shields.io/badge/Maven-Build-blue)
![POM](https://img.shields.io/badge/Architecture-Page%20Object%20Model-purple)

## Overview

This repository contains an automated UI testing project developed using **Java, Selenium WebDriver, JUnit 5, and Maven** for the **Stamply** web application.

The project is a portfolio automation project created while collaborating with an independent developer working on the Stamply application. The purpose of this project is to build a maintainable automated regression test suite that validates important user flows and helps ensure application quality during continuous development.

The automation framework follows the **Page Object Model (POM)** design pattern, separating test logic from page-specific implementation. This approach improves code readability, reduces duplication, and allows the framework to be extended as the application grows.

Application under test:

**Stamply:** https://stamply.app

## Features

* Implementation of the **Page Object Model (POM)** design pattern for clean and maintainable test architecture.
* Automated UI regression tests covering key application workflows.
* Creation of reusable page classes representing individual application views.
* Development of common automation actions shared across multiple tests.
* Usage of a dedicated base layer to handle common test setup and browser configuration.
* Organization of automated tests into separate classes based on tested functionality.
* Integration with Maven for dependency management and test execution.
* Usage of JUnit 5 annotations for organizing and running test scenarios.
* Version control using Git and GitHub.

## Framework Structure

The project is organized into separate layers:

```text
src
└── test
    └── java
        ├── base
        │   ├── BasePage
        │   ├── BaseTest
        │   └── reusable actions
        │
        ├── pages
        │   └── Page Object classes
        │
        └── tests
            └── Automated UI test scenarios
```

The framework layer contains reusable components responsible for common browser interactions, while Page Object classes contain application-specific elements and actions.

## Current Test Coverage

The project currently contains **28 automated UI tests** covering important application functionality, including:

* User login and authentication flows
* Navigation between application sections
* Verification of UI elements
* Form interactions
* Core business workflows
* Positive and negative test scenarios

The test suite is continuously expanded as new features are introduced into the application.

## My Contribution

I am responsible for the development and maintenance of the automation framework and automated test scenarios for the Stamply application.

My responsibilities include:

* Designing and implementing Selenium WebDriver tests.
* Creating Page Object classes for application pages.
* Developing reusable automation methods.
* Automating important end-to-end user flows.
* Improving test stability through proper element handling and synchronization.
* Maintaining the automation codebase using Git and GitHub.
* Supporting manual testing of newly introduced application features.
* Increasing regression test coverage as the application evolves.

## Technologies Used

* **Java** – Programming language used for writing automation code.
* **Selenium WebDriver** – Framework used for browser-based UI automation.
* **JUnit 5** – Testing framework used for organizing and executing automated tests.
* **Maven** – Dependency management and build automation tool.
* **Page Object Model (POM)** – Design pattern used for creating scalable automation architecture.
* **Git / GitHub** – Version control and source code management.
* **IntelliJ IDEA** – IDE used for development and debugging.

## Running the Tests

Clone the repository:

```bash
git clone <repository-url>
```

Navigate to the project folder:

```bash
cd Stamply_qa_automation
```

Run the automated test suite:

```bash
mvn test
```

## Project Status

🚧 **Work in Progress**

The project is actively maintained. Additional automated tests are continuously added as the Stamply application evolves and new functionality becomes available.

## Purpose of the Repository

This repository demonstrates practical experience with:

* UI test automation using Selenium WebDriver
* Designing maintainable automation frameworks
* Applying Page Object Model architecture
* Writing automated regression tests for a real web application
* Working with an evolving production-like environment

## Contact

GitHub:
https://github.com/BartKowalskii
