# 🧪 Opencart Automation Framework

This project automates test cases for the [OpenCart demo site](https://demo.opencart.com/) using **Selenium WebDriver**, **TestNG**, and **Java**, following the **Page Object Model (POM)** design pattern.

---

## 🔧 Tech Stack

| Tool / Library     | Purpose                      |
|--------------------|------------------------------|
| Java 24            | Programming Language         |
| Selenium WebDriver | UI Automation                |
| TestNG             | Test Execution Framework     |
| Maven              | Build & Dependency Management|
| Apache POI         | Excel-based Data-Driven Test |
| Log4j2             | Logging                      |
| Extent Reports     | Test Reporting               |
| Jenkins            | Continuous Integration       |

---

## 🧪 Test Cases Included
- TC001_AccountRegistrationTest
- TC002_LoginTest
- TC003_LoginDDT
- TC004_LogOutTest

## 📁 Folder Structure

<img width="375" height="414" alt="image" src="https://github.com/user-attachments/assets/a14e3c8f-0a0b-466c-a090-78d74607a77b" />

## ▶️ How to Run
You can run the automation tests using any of the following methods:

### 🟢 Option 1: Using Maven

mvn clean test
//Make sure you are in the project root where pom.xml is located.

### 🟢 Option 1: Using Jenkins 

Set up a Jenkins job with GitHub repo URL.

Add a Build Step to run:
mvn clean test
