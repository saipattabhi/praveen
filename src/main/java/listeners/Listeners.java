package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utilities.ExtentReport;
import resources.base;

public class Listeners extends base implements ITestListener  {
	
	 public	 WebDriver driver = null;
	 
	 ExtentReports extentreport = ExtentReport.getExtentReport();
	 ExtentTest extentTest ;
	 ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();

	 
	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getName();
	 extentTest = extentreport.createTest(testName+"Execution started");
	 extentTestThread.set(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String testName = result.getName();
		
	//extentTest.log(Status.PASS,testName+"Test got passed");
	 extentTestThread.get().log(Status.PASS,testName+"Test got passed");
	
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
       
	  	String testName = result.getName();
	  	
	  //	extentTest.fail(result.getThrowable());
	  	
	  	extentTestThread.get().fail(result.getThrowable());
	
	  	try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		try {
	String screenshotFilePath = takeScreenshot(testName,driver);
	extentTestThread.get().addScreenCaptureFromPath(screenshotFilePath, testName);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extentreport.flush();
		
	}
	
	
	
	
	

}
