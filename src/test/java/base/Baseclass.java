package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.ScreenshotUtil;
import utils.WaitUtil;

// BaseClass is used to initialize the browser and common setup required for all test cases
public class Baseclass {

	// WebDriver instance used to control the browser
	public WebDriver driver;

	// Custom WaitUtil class used to handle explicit waits in the project
	public WaitUtil waitUtil;

	// setUp() method will run before every test case execution
	// It is responsible for launching the browser and opening the application URL
	@BeforeMethod(alwaysRun = true)
	public void setUp() {

		// ChromeOptions is used to customize browser settings
		ChromeOptions options = new ChromeOptions();

		// This line disables browser notifications during automation execution
		options.addArguments("--disable-notifications");

		// Launch Chrome browser with the given options
		driver = new ChromeDriver(options);

		// Maximize the browser window
		driver.manage().window().maximize();

		// Apply implicit wait to wait for elements to load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Initialize custom WaitUtil class for handling explicit waits
		waitUtil = new WaitUtil(driver, 20);

		// Open the application under test
		driver.get("https://trulyfreehome.dev/");

		// Set maximum time for page to load completely
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));

	}

	// tearDown() method runs after every test case execution
	// It helps to capture screenshot when test fails and close the browser
	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) {

		// Capture the screenshot when TestCase fails
		if (driver != null && !result.isSuccess()) {
			String screenshotPath = ScreenshotUtil.capture(driver, result.getName());
			Reporter.log("Captured failure screenshot: " + screenshotPath, true);
		}

		// Close the browser after test execution
		if (driver != null) {
			driver.quit();
			Reporter.log("Closed browser session", true);
		}
	}
}