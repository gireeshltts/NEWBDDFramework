package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.Utility;



public class CoursePage
{

	WebDriver driver;
	
	
	public CoursePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By addCourse =By.xpath("//button[normalize-space()='Add New Course']");
	By file= By.xpath("//input[@id='thumbnail']");
	By courseName=By.xpath("//input[@id='name']");
	By courseDescription=By.xpath("(//textarea[@id='description'])[1]");
	By instructor=By.xpath("//input[@id='instructorNameId']");
	By price=By.xpath("//input[@id='instructorNameId']");
	By startDate=By.xpath("//input[@name='startDate']");
	By endDate =By.xpath("//input[@name='endDate']");
	By selectCategory=By.xpath("//div[normalize-space()='Select Category']");
	//button[normalize-space()='Selenium']
	
	By save=By.xpath("//button[normalize-space()='Save']");
	
	By numCourses=By.xpath("//table//tbody//tr/td[1]");
	
	
	public void courseAdd(String fileName,String cName,String cDescription,String instructorName,String priceValue,String starDateValue,String endDateValue,String categoryName)
	{
		Utility.waitForWebElement(driver, addCourse).click();
		Utility.waitForWebElement(driver, file).sendKeys(fileName);
		Utility.waitForWebElement(driver, courseName).sendKeys(cName);
		Utility.waitForWebElement(driver, courseDescription).sendKeys(cDescription);
		Utility.waitForWebElement(driver, instructor).sendKeys(instructorName);
		Utility.waitForWebElement(driver, price).sendKeys(priceValue);
		
		Utility.waitForWebElement(driver, By.xpath("//input[@name='startDate']")).click();
		Utility.waitForWebElement(driver, By.xpath("//button[@aria-label='Next Month']")).click();
		//Utility.waitForWebElement(driver, By.xpath("//div[contains(@class,'"+starDateValue"+')]")).click();
		

		
		
		//span[@class='react-datepicker__navigation-icon react-datepicker__navigation-icon--next']
	//	Utility.selectValueFromList(driver, startDate,starDateValue );
		//Utility.selectValueFromList(driver, startDate,starDateValue );
		//WebElement startDateElement=Utility.waitForWebElement(driver, startDate);
		//startDateElement.clear();
		//startDateElement.sendKeys(starDateValue);
		WebElement endDatElement=Utility.waitForWebElement(driver, endDate);
		endDatElement.clear();
		endDatElement.sendKeys(endDateValue);
		
		//Utility.waitForWebElement(driver, endDate).sendKeys(endDateValue);
		Utility.waitForWebElement(driver, selectCategory).click();
		Utility.waitForWebElement(driver,By.xpath("//button[normalize-space()='"+categoryName+"']")).click();
		Utility.waitForWebElement(driver, save).click();
		
		
		
	}
	
	
	
}
