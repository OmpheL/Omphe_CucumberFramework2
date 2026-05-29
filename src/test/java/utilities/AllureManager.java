package utilities;

import io.qameta.allure.Allure;

public class AllureManager {

    // Add a simple step
    public static void step(String message) {

        Allure.step(message);
    }

    // Attach text content
    public static void attachText(String name,
                                  String content) {

        Allure.addAttachment(
                name,
                content);
    }

    // Attach screenshot (if you pass byte array)
    public static void attachScreenshot(String name,
                                        byte[] screenshot) {

        Allure.addAttachment(
                name,
                "image/png",
                new String(screenshot));
    }
}