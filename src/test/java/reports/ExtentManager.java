package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static ExtentReports getInstance() {

        if (extent == null) {

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(
                            "test-output/ExtentReport/ExtentReport.html");

            sparkReporter.config().setReportName("Automation Test Report");
            sparkReporter.config().setDocumentTitle("Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            extent.setSystemInfo("Framework", "Selenium Cucumber TestNG");
            extent.setSystemInfo("Tester", "Omphe");
            extent.setSystemInfo("Environment", "QA");
        }

        return extent;
    }

    public static void createTest(String testName) {

        ExtentTest extentTest =
                getInstance().createTest(testName);

        test.set(extentTest);
    }

    public static ExtentTest getTest() {

        return test.get();
    }

    public static void flushReport() {

        if (extent != null) {

            extent.flush();
        }
    }
}
