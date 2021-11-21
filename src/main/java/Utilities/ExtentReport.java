package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

 static	  ExtentReports extentReports;
	public static   ExtentReports getExtentReport()
	{
		 
	String reporterpath = System.getProperty("user.dir")+"//reports//extentreport.html";
		
		ExtentSparkReporter reporter=new ExtentSparkReporter(reporterpath);
		
		reporter.config().setReportName("Tutorial ninja test automation results");
		reporter.config().setDocumentTitle("TestResults");
		
		
		 extentReports=new ExtentReports();
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("operatingsystem","windows10");
		 extentReports.setSystemInfo("Tested by", "Sai pattabhi");
		 return extentReports;
	}
	
	
}
