package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.base;


public class TwoTest extends base {

	public WebDriver driver;
	@Test
public void TwoTest() throws IOException, Exception {
		
		System.out.println("inside two test");
		
	driver=	IntializeDriver();
	
	driver.get("http://tutorialsninja.com/demo/");
	Thread.sleep(2000);
	driver.close();
	
	System.out.println("pratice make man perfect");

	}
	
	@AfterMethod
public void closeBrowser()
{
	driver.close();
}
	
	
}
