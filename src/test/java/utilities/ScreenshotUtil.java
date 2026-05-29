package utilities;

import org.openqa.selenium.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {

    public static void captureScreenshot(String name) {

        try {

            WebDriver driver =
                    DriverFactory.getDriver();

            File src =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.FILE);

            String timestamp =
                    new SimpleDateFormat(
                            "yyyyMMdd_HHmmss")
                            .format(new Date());

            File dest =
                    new File("screenshots/"
                            + name + "_" + timestamp + ".png");

            FileUtils.copyFile(src, dest);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}