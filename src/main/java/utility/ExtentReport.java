package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	public static ExtentReports getReport()
	{
		ExtentSparkReporter sparkReporter= new ExtentSparkReporter("ExtentReports.html");
		ExtentReports extent=new ExtentReports();
		
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Reported_By", "Amit");
		extent.setSystemInfo("Test_Type", "Functional Testing");
		extent.setSystemInfo("Reported_To", "Subodh Sir");
		return extent;
	}

}
