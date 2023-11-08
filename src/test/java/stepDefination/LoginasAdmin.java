package stepDefination;

import org.openqa.selenium.By;
import org.testng.Assert;

import factory.BrowserFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginasAdmin {

LoginPage login;
	
@Given("User is able to load the application")
public void user_is_able_to_load_the_application() {
	
	login= new LoginPage(BrowserFactory.getDriver());
    
}
@When("user has entered user name as {string} and password as {string} and click on submit button")
public void user_has_entered_user_name_as_and_password_as_and_click_on_submit_button(String username, String password) {
	
	login.loginToApplication(username, password);
    
}

@Then("User should be able gto login")
public void user_should_be_able_gto_login() {
   
	Assert.assertTrue(BrowserFactory.getDriver().findElement(By.xpath("//span[normalize-space()='Manage')]")).isDisplayed());
}}
