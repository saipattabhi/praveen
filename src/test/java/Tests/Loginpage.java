package Tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Data.ExcelDataConfig;
import PageObjects.AccountPage;
import PageObjects.LandingPage;
import PageObjects.LoginPage;
import resources.base;

public class Loginpage extends base {

	public WebDriver driver;
	Logger log;

	@Test(dataProvider = "getLoginData")
	public void login(String username, String password, String exceptedResult) throws IOException {
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		log.debug("my account dropdown has clicked");
		landingPage.loginOption().click();
		log.debug("login option has clicked");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailAdressField().sendKeys(username);
		loginPage.passwordField().sendKeys(password);
		loginPage.loginButton().click();
		log.debug("login button got clicked");
		AccountPage accountPage = new AccountPage(driver);
		String actualResult = null;
		try {
			if (accountPage.account().isDisplayed()) {
				actualResult = "Sucessfull";
				
			}

		} catch (Exception e) {
			actualResult = "failure";

		}
		Assert.assertEquals(actualResult, exceptedResult);

	}
	@BeforeMethod
	public void openAplication() throws IOException
	{
	    log = LogManager.getLogger(Loginpage.class.getName());
		driver = IntializeDriver();
		driver.get(prop.getProperty("url"));
		log.debug("The browser has got launched");
		
	}

	@AfterMethod
	public void closure() {
		driver.close();
		log.debug("The browser has got closed");
	}

	@DataProvider(name="getLoginData")
	public Object[][] passdata()
	
	{
		
		
		ExcelDataConfig config=new ExcelDataConfig("C:\\Users\\saipa\\eclipse-workspace\\LiveProject\\ExcelData\\remo.xlsx ");
		int rows = config.getRowCount(0);
		
		Object data[][]= new Object[rows][3];
		for(int i=0;i<rows;i++) {
		
			data[i][0]=config.getData(0, i, 0);
			data[i][1]=config.getData(0, i, 1);
			
		}
		
		return data;
		

		
		
		
	}
}
