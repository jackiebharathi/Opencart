# 🧪 OpenCart Selenium Automation Framework

Automated test suite for the [OpenCart demo site](https://demo.opencart.com) built with Selenium WebDriver, TestNG, and Java. Follows the Page Object Model (POM) design pattern with data-driven testing, CI integration, and structured reporting.

## 🔧 Tech Stack

| Tool / Library | Purpose |
|----------------|---------|
| Java 24 | Programming Language |
| Selenium WebDriver | UI Automation |
| TestNG | Test Execution Framework |
| Maven | Build & Dependency Management |
| Apache POI | Excel-based Data-Driven Testing |
| Log4j2 | Logging |
| Extent Reports | Test Reporting |
| Jenkins | Continuous Integration |

## 🧪 Test Cases

| Test ID | Test Case |
|---------|-----------|
| TC001 | Account Registration |
| TC002 | Login (static) |
| TC003 | Login DDT (data-driven via Excel) |
| TC004 | Logout |

## 📁 Folder Structure

```
opencart-selenium/
├── src/
│   ├── main/java/
│   │   ├── pageObjects/       # POM classes for each page
│   │   └── utilities/         # Reusable helpers (Excel reader, logger, etc.)
│   └── test/java/
│       ├── testCases/         # TestNG test scripts
│       └── testData/          # Excel data files for DDT
├── reports/                   # Extent Reports output
├── logs/                      # Log4j2 log files
├── pom.xml                    # Maven config
└── testng.xml                 # TestNG suite config
```

## ▶️ How to Run

### Option 1: Maven
```bash
# Run from project root (where pom.xml lives)
mvn clean test
```

### Option 2: Jenkins
1. Create a new Jenkins Freestyle job
2. Set GitHub repo URL
3. Add build step: `mvn clean test`
4. Save and build

## 📊 Reports

Extent Reports are auto-generated after each run:
```
reports/ExtentReport.html
```

## 💡 Key Design Decisions

- **POM pattern** — each page is a separate class; tests never interact with locators directly
- **Data-driven login (TC003)** — reads credentials from Excel via Apache POI, no hardcoded test data
- **Log4j2** — structured logs for every test action, useful for debugging failures in CI
- **TestNG XML suite** — controls execution order and parallel run configuration
