package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.base;


public class ThreeTest extends base {

	public WebDriver driver;
	@Test
	public void ThreeTest() throws Exception {
		System.out.println("inside three test");
		driver = IntializeDriver();
		driver.get("http://tutorialsninja.com/demo/");
		Thread.sleep(2000);
		driver.close();
		
		System.out.println("information is wealth");
	}

}
