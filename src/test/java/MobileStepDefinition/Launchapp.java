package MobileStepDefinition;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Launchapp {
	
	AndroidDriver androiddriver;
	@When("user launches app")
	public void user_launches_app() throws Throwable {
		DesiredCapabilities capabilility = new DesiredCapabilities();

		capabilility.setCapability("deviceName", "OnePlus 11R");
		capabilility.setCapability("os", "Android");
		capabilility.setCapability("osVersion", "13");
		capabilility.setCapability("buildName", "Android");
		capabilility.setCapability("projectName", "Login page:learn-automation");
		capabilility.setCapability("app", "bs://b2f9b85590220d389bc07cb457103fe62d709e5a");

 		URL hubUrl=new URL("https://gireeshdm_wvmkOl:LbkDSsKbB4Ly2CxysBxb@hub-cloud.browserstack.com/wd/hub");
 		AndroidDriver androiddriver=new AndroidDriver(hubUrl, capabilility);
 		
		    
	}

	@Then("app should install in mobile and open main menu.")
	public void app_should_install_in_mobile_and_open_main_menu() {
	    
		androiddriver.findElement(AppiumBy.accessibilityId("open menu")).click();
		androiddriver.quit();
	}


}
