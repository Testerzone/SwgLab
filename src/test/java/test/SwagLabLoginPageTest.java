package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;

import pojo.SwagBrowser;
import pom.SwagLabLoginPage;
import utility.ExtentReport;
import utility.Parametrization;
@Listeners(utility.Listeners.class)

public class SwagLabLoginPageTest {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	
	@BeforeTest
	public void createReport()
	{
		report=ExtentReport.getReport();
	}
	
	@BeforeMethod
	public void Browser()
	{
		driver=SwagBrowser.OpenBrowser();
	}
	@Test
	public void validateSwagLabLogin() throws EncryptedDocumentException, IOException
	{
		test=report.createTest("validateSwagLoginPage");
		SwagLabLoginPage swagLoginPage=new SwagLabLoginPage(driver);
		
		swagLoginPage.enterUserName(Parametrization.getExcelData("Swag", 0, 1));
		swagLoginPage.enterPassword(Parametrization.getExcelData("Swag", 1, 1));
		swagLoginPage.clickOnLogin();
		String expectedUrl="https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
		
	}
	
	@AfterMethod
	public void captureResult(ITestResult result)
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, result.getName());
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, result.getName());
		}
		else {
			test.log(Status.SKIP, result.getName());
		}
	}
	@AfterTest
	public void flushResult()
	{
		report.flush();
	}
}
