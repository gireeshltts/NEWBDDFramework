package hooks;

import org.openqa.selenium.WebDriver;

import dataProvider.ConfigReader;
import factory.BrowserFactory;
import helper.Utility;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook {
	
	WebDriver driver;
	
	@Before
	public void startBrowser()
	{
		BrowserFactory.startBrowser(ConfigReader.getProperty("browser"), ConfigReader.getProperty("appURL"));
	}
	
	@After
	public void closeBrowser()
	{
		driver.quit();
	}

	@AfterStep
	public void tearDown(Scenario scenario)
	{
		String name= scenario.getName();
		
		if(scenario.isFailed())
		{
			scenario.attach(Utility.captureScreenshotAsByte(driver), "image/png", name); ;
		}
		
	}
}
