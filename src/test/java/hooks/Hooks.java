package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import reports.ExtentManager;
import utilities.ConfigReader;
import utilities.DriverFactory;
import utilities.ExtentReportManager;
import utilities.ScreenshotUtil;

public class Hooks {

    ConfigReader configReader = new ConfigReader();

    @Before
    public void setup(Scenario scenario) {

        // Create Extent Test
        ExtentManager.createTest(
                scenario.getName());

        ExtentReportManager.step(
                "Starting Scenario: " + scenario.getName());

        // Initialize Browser
        DriverFactory.initializeDriver();

        ExtentReportManager.step(
                "Browser launched successfully");

        // Open Application
        DriverFactory.getDriver().get(
                configReader.getProperty("baseUrl"));

        ExtentReportManager.step(
                "Navigated to URL: "
                        + configReader.getProperty("baseUrl"));
    }

    @After
    public void tearDown(Scenario scenario) {

        String testName =
                scenario.getName().replace(" ", "_");

        // Scenario Status
        if (scenario.isFailed()) {

            ExtentReportManager.step(
                    "Scenario Failed: " + scenario.getName());

            // Capture Screenshot
            String screenshotPath =
                    ScreenshotUtil.captureScreenshot(testName);

            // Attach Screenshot to Extent Report
            ExtentReportManager.attachScreenshot(
                    "Failure Screenshot",
                    screenshotPath);

        } else {

            ExtentReportManager.step(
                    "Scenario Passed: " + scenario.getName());
        }

        // Close Browser
        DriverFactory.quitDriver();

        ExtentReportManager.step(
                "Browser closed successfully");

        // Flush Report
        ExtentManager.flushReport();
    }
}
