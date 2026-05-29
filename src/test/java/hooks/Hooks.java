package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import utilities.ConfigReader;
import utilities.DriverFactory;
import utilities.ScreenshotUtil;
import utilities.AllureManager;

public class Hooks {

    ConfigReader configReader = new ConfigReader();


    @Before
    public void setup(Scenario scenario) {

        String testName =
                scenario.getName().replace(" ", "_");

        AllureManager.step("Starting scenario: " + scenario.getName());

        DriverFactory.initializeDriver();

        DriverFactory.getDriver().get(
                configReader.getProperty("baseUrl")
        );

    }

    @After
    public void tearDown(Scenario scenario) {

        String testName =
                scenario.getName().replace(" ", "_");


        if (scenario.isFailed()) {

            AllureManager.step("Scenario Failed: " + scenario.getName());

            ScreenshotUtil.captureScreenshot(testName);

            AllureManager.step("Screenshot captured for failure");
        }


        DriverFactory.quitDriver();

        AllureManager.step("Browser closed for scenario");
    }
}