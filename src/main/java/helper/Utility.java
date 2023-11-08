package helper;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import dataProvider.ConfigReader;

public class Utility {

	public static void selectValueFromDropDown(WebDriver driver, By locator, String value) {
		Select sel = new Select(Utility.waitForWebElement(driver, locator));

		sel.selectByVisibleText(value);

	}

	public static void selectValueFromList(WebDriver driver, By locator, String valueToSearch) {
		List<WebElement> allvalues = driver.findElements(locator);
		for (WebElement ele : allvalues) {
			String date = ele.getText();
			if (date.contains(valueToSearch)) {
				ele.click();
				System.out.println("LOG INFO : Clicked on " + valueToSearch);
				break;
			}
		}

	}

	public static void rightClick(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.contextClick(ele).perform();
	}

	public static void doubleClick(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.doubleClick(ele).perform();
	}

	
	public static String captureScreenshotAsByte(WebDriver driver) {

		TakesScreenshot ts = (TakesScreenshot) driver;

		String screenshotasBase64 = ts.getScreenshotAs(OutputType.BASE64);

		return screenshotasBase64;
	}

	public static String getCurrentDate() {
		SimpleDateFormat myformat = new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy");

		String newFormat = myformat.format(new Date());

		return newFormat;
	}

	public static void clickElement(WebDriver driver, WebElement ele) {
		try {
			ele.click();
		} catch (Exception e) {
			Reporter.log("LOG:INFO - WebElement Click Failed - Trying With Actions Class Click " + e.getMessage(),
					true);

			try {
				Actions act = new Actions(driver);
				act.click().perform();
			} catch (Exception e2) {
				Reporter.log("LOG:INFO - Actions Class Click Failed - Trying With JSExecutor Class " + e2.getMessage(),
						true);

				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguemnts[0].click()", ele);
			}
		}
	}

	public static void sleep(int timeInSeconds) {
		try {
			Thread.sleep(timeInSeconds * 1000);
		} catch (InterruptedException e) {

			Reporter.log("LOG:ERROR - Thread Interruped " + e.getMessage(), true);
		}
	}

	public static WebElement highLightWebElement(WebDriver driver, WebElement ele) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('style','background: yellow; border: solid 2px red')", ele);

		sleep(1);

		js.executeScript("arguments[0].setAttribute('style','border: solid 2px black')", ele);

		return ele;

	}

	public static void mouseHover(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	}

	public static void scrollTillElementPresent(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);

		act.scrollToElement(ele).perform();

	}

	public static void scrollTillElementPresent(WebDriver driver, By Locator) {
		Actions act = new Actions(driver);

		act.scrollToElement(driver.findElement(Locator)).perform();

	}

	public static WebElement waitForWebElement(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(locator));

		String highLightString = ConfigReader.getProperty("highLightElement");

		if (highLightString.equalsIgnoreCase("true")) {
			highLightWebElement(driver, ele);
		}

		return ele;
	}

	public static WebElement waitForWebElement(WebDriver driver, By locator, int timeInSec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSec));

		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(locator));

		String highLightString = ConfigReader.getProperty("highLightElement");

		if (highLightString.equalsIgnoreCase("true")) {
			highLightWebElement(driver, ele);
		}

		return ele;
	}

}
