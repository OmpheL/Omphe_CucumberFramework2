package utilities;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import reports.ExtentManager;

public class ExtentReportManager {

    // Log simple step
    public static void step(String message) {

        ExtentManager.getTest()
                .log(Status.INFO, message);
    }

    // Attach text/log
    public static void attachText(String title,
                                  String content) {

        ExtentManager.getTest()
                .log(Status.INFO,
                        "<b>" + title + "</b><br>" + content);
    }

    // Attach screenshot using file path
    public static void attachScreenshot(String title,
                                        String screenshotPath) {

        try {

            ExtentManager.getTest()
                    .info(title,
                            MediaEntityBuilder
                                    .createScreenCaptureFromPath(screenshotPath)
                                    .build());

        } catch (Exception e) {

            ExtentManager.getTest()
                    .fail("Failed to attach screenshot: "
                            + e.getMessage());
        }
    }
}
