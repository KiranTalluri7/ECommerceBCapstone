
package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extent;
    private static ExtentSparkReporter spark;
    private static ExtentTest test;

    public static ExtentReports getExtentReports() {
        if (extent == null) {
            extent = new ExtentReports();
            spark = new ExtentSparkReporter("extent-reports/ExtentReport.html");
            extent.attachReporter(spark);
        }
        return extent;
    }

    public static ExtentTest createTest(String testName) {
        test = getExtentReports().createTest(testName);
        return test;
    }

    public static void flushReports() {
        if (extent != null) {
            extent.flush();
        }
    }
}
