# Stamply Web Application UI Test Automation

![Java](https://img.shields.io/badge/Java-17-orange)
![Selenium](https://img.shields.io/badge/Selenium-4-green)
![JUnit5](https://img.shields.io/badge/JUnit-5-red)
![Maven](https://img.shields.io/badge/Maven-Build-blue)
![POM](https://img.shields.io/badge/Architecture-POM-purple)
![Status](https://img.shields.io/badge/Status-Active-success)

## Overview

This repository contains an automated UI testing project developed using **Java, Selenium WebDriver, JUnit 5, and Maven** for the **Stamply** web application.

This project was developed as part of a collaboration with an independent developer working on the Stamply web application. It serves both as a production-like automation project and as a demonstration of my QA automation skills. The purpose of this project is to build a maintainable automated regression test suite that validates important user flows and helps ensure application quality during continuous development.

The automation framework follows the **Page Object Model (POM)** design pattern, separating test logic from page-specific implementation. This approach improves code readability, reduces duplication, and allows the framework to be extended as the application grows.

## Application Under Test

**Stamply**  
https://stamply.app

## Project Highlights

- ✔ 28 automated UI tests
- ✔ Java + Selenium WebDriver
- ✔ Page Object Model architecture
- ✔ Production-like web application
- ✔ Active collaboration with application developer

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

✔ 28 automated UI tests

Coverage includes:

- Login & authentication
- Navigation
- UI validation
- Form interactions
- Core business workflows
- Positive & negative scenarios

The test suite is continuously expanded as new features are introduced into the application.

## Planned Improvements

- Cross-browser execution
- GitHub Actions CI
- Test reporting with Allure
- Parallel execution
- Data-driven testing

  
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

| Technology | Purpose |
|------------|---------|
| Java | Programming language |
| Selenium WebDriver | UI automation |
| JUnit 5 | Test execution |
| Maven | Build & dependency management |
| Git | Version control |
| IntelliJ IDEA | Development environment |

## Running the Tests

Clone the repository:

```bash
git clone https://github.com/BartKowalskii/Stamply_qa_automation.git
```

Navigate to the project folder:

```bash
cd Stamply_qa_automation
```

Before running the tests, configure the following environment variables:

STAMPLY_EMAIL=your_test_email
STAMPLY_PASSWORD=your_test_password

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
