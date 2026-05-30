# 📘 Omphe_CucumberFramework

A **Selenium + Cucumber + TestNG + Extent Reports** hybrid automation framework designed for scalable UI test automation using modern best practices.

---

# 🚀 Tech Stack

* Java 21
* Selenium WebDriver 4
* Cucumber 7 (BDD)
* TestNG
* Extent Reports
* WebDriverManager
* Maven

---

# 🏗️ Project Structure

```text
src
 ├── test
 │    ├── java
 │    │    ├── context
 │    │    ├── hooks
 │    │    ├── models
 │    │    ├── pages
 │    │    ├── reports
 │    │    ├── runners
 │    │    ├── stepdefinitions
 │    │    ├── testdata
 │    │    ├── utilities
 │
 │    ├── resources
 │         ├── features
 │         ├── testdata
 │         ├── extent.properties
```

---

# ⚙️ Features

* Page Object Model (POM)
* BDD using Cucumber
* Reusable BasePage methods
* Alert handling support
* Explicit wait utilities
* Context sharing between steps
* Data-driven testing support
* Extent Reports integration
* Screenshot capture on failure
* Clean and scalable architecture
* CI/CD ready framework

---

# 📊 Reporting

## ✔ Extent Report

Generate and view report:

```bash
mvn clean test
```

Report location:

```text
test-output/ExtentReport/ExtentReport.html
```

---

## ✔ Cucumber HTML Report

```text
target/cucumber-report.html
```

---

# ▶️ How to Run Tests

## Run all tests

```bash
mvn clean test
```

---

# 🧪 Example Feature

```gherkin
Feature: Group Management

  Scenario: Create group and validate in Sign-Up

    Given user logs in as admin
    When user navigates to admin panel
    And user creates a group
    And user logs out
    Then created group should be visible in sign up dropdown
```

---

# 🧠 Key Design Principles

* Separation of concerns
* Reusable components
* Maintainable structure
* Scalable framework architecture
* CI/CD compatible design
* Clean reporting integration

---

# 📂 Test Data

Test data is stored in:

```text
src/test/resources/testdata
```

Supports:

* JSON
* Excel
* Properties

---

# 📸 Screenshots

* Screenshots captured automatically on failures
* Integrated directly into Extent Reports

---

# 🚀 CI/CD (GitHub Actions)

The project supports GitHub Actions for:

* Build execution
* Automated test execution
* Extent Report generation
* Artifact uploads

---

# 👨‍💻 Author

Omphemetse L

---

# 📌 Future Enhancements

* Retry analyzer for flaky tests
* Parallel test execution
* Cross-browser testing support
---

# ⭐ Summary

This framework is designed to be:

* Clean
* Scalable
* Enterprise-ready
* Interview-ready
* Maintainable
* CI/CD compatible
