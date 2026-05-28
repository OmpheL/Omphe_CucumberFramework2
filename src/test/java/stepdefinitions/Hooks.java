package stepdefinitions;

import utilities.ConfigReader;
import utilities.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setup() {

        DriverFactory.initializeDriver();

        DriverFactory.getDriver().get(
                ConfigReader.getProperty("baseUrl")
        );
    }

    @After
    public void tearDown() {

        DriverFactory.quitDriver();
    }
}