package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportUtility {
	//static ExtentReports extent;
	public static ExtentReports createExtentReports()
	{
		String path =System.getProperty("user.dir")+"\\extent-reports\\extent-report.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);//result will store in extent-report.html
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");

		ExtentReports extent =new ExtentReports();//create ExtentReports and attach reporter
		extent.attachReporter(reporter);

		return extent;
	}
}