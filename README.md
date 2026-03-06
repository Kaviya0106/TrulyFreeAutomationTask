# Selenium TestNG E2E Framework - TruelyFreeHome

## Tech Stack
- Java
- Selenium WebDriver
- TestNG
- WebDriverManager
- Maven

## Framework Design
- Pattern: Page Object Model (POM)
- Test base: `BaseTest` for setup/teardown
- Utilities: `WaitUtil` and `ScreenshotUtil`
- Reporting: TestNG HTML reports under `test-output/`
- Failure handling: Screenshot captured automatically on test failure

## Project Structure
```text
src/test/java
  base/
    BaseTest.java
  testscases/
    SignupPage.java
    HomePage.java
    BrandPage.java
    ProductListPage.java
    ProductDetailPage.java
    CartPage.java
    CheckoutPage.java
    PaymentPage.java
    OrdersPage.java
    E2EPurchaseFlowTest.java
  utils/
    ScreenshotUtil.java
    WaitUtil.java
src/test/resources/
  testng.xml
pom.xml
```

## Prerequisites
- Java 8+
- Maven 3.8+
- Google Chrome installed

## Setup
1. Clone/open project in VS Code.
2. Ensure internet access for Maven dependencies and WebDriverManager.
3. Update test data in `E2EPurchaseFlowTest` if needed.

## Execute Tests
```bash
mvn clean test
```

## Run Against Different URL
```bash
mvn clean test -Dbase.url=https://trulyfreehome.dev/
```

## Reports
- TestNG default report: `test-output/index.html`
- Failed test screenshots: `test-output/screenshots/`

## Notes
- Locators intentionally use XPath/ID/Name (no CSS selectors).
- Wait strategy is centralized in `WaitUtil` for reusable synchronization.
