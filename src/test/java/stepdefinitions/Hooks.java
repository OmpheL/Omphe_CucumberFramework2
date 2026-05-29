package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import utilities.ConfigReader;
import utilities.DriverFactory;
import utilities.ScreenshotUtil;
import utilities.VideoRecorderUtil;
import utilities.AllureManager;

public class Hooks {

    ConfigReader configReader = new ConfigReader();

    // =========================
    // BEFORE SCENARIO
    // =========================
    @Before
    public void setup(Scenario scenario) {

        String testName =
                scenario.getName().replace(" ", "_");

        AllureManager.step("Starting scenario: " + scenario.getName());

        DriverFactory.initializeDriver();

        DriverFactory.getDriver().get(
                configReader.getProperty("baseUrl")
        );

        VideoRecorderUtil.startRecording(testName);
    }

    // =========================
    // AFTER SCENARIO
    // =========================
    @After
    public void tearDown(Scenario scenario) {

        String testName =
                scenario.getName().replace(" ", "_");

        // =========================
        // IF FAILED
        // =========================
        if (scenario.isFailed()) {

            AllureManager.step("Scenario Failed: " + scenario.getName());

            ScreenshotUtil.captureScreenshot(testName);

            AllureManager.step("Screenshot captured for failure");
        }

        // =========================
        // STOP VIDEO
        // =========================
        VideoRecorderUtil.stopRecording();

        // =========================
        // CLOSE DRIVER
        // =========================
        DriverFactory.quitDriver();

        AllureManager.step("Browser closed for scenario");
    }
}