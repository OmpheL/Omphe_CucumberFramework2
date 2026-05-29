
# 📘 Omphe_CucumberFramework

A **Selenium + Cucumber + TestNG + Allure** hybrid automation framework designed for UI testing with scalable architecture and reporting.

---

# 🚀 Tech Stack

* Java 21
* Selenium WebDriver 4
* Cucumber 7 (BDD)
* TestNG
* Allure Reports
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
 │    │    ├── runners
 │    │    ├── stepdefinitions
 │    │    ├── testdata
 │    │    ├── utilities
 │
 │    ├── resources
 │         ├── features
 │         ├── testdata
```

---

# ⚙️ Features

* Page Object Model (POM)
* BDD using Cucumber
* Reusable BasePage methods
* Alert handling support
* Wait utilities (explicit waits)
* Context sharing between steps
* Data-driven testing support
* Allure reporting integration
* Screenshot support in failures
* Parallel execution ready

---

# 📊 Reporting

## ✔ Allure Report

Generate and view report:

```bash
mvn clean test
mvn allure:serve
```

OR

```bash
allure serve target/allure-results
```

---

## ✔ Cucumber HTML Report

```text
target/cucumber-report.html
```

---

# ▶️ How to Run Tests

### Run all tests:

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

* Separation of concerns (Pages, Steps, Utilities)
* Reusable components
* Maintainable structure
* Scalable for CI/CD pipelines
* Thread-safe ready (for parallel execution)

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

# 📸 Screenshots & Videos

* Screenshots captured on failure
* Integrated with Allure reports

---

# 🚀 CI/CD (GitHub Actions)

The project supports GitHub Actions for:

* Build execution
* Test execution
* Allure report generation
* Artifact upload

---

# 👨‍💻 Author

Omphemetse L

---

# 📌 Future Enhancements

* Retry analyzer for flaky tests

---

# ⭐ Summary

This framework is designed to be:

* Clean
* Scalable
* Interview-ready
* CI/CD compatible
---