package utility;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends SwagLabElement implements ITestListener {
	
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Test is successful"+result.getName());
	}
	
	public void onTestFailure(ITestResult result)
	{
		try {
			Screenshot.takeScreenShot(driver, result.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("Test is Skip"+result.getName());
	}
	
	public void onTestStart(ITestResult result)
	{
		System.out.println("Test is Start"+result.getName());
	}

}
