package com.vstl.Generic;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest extends Pojo {

	private WebDriver driver;
	private String strURL;
	private Utilities objUtilities;
	private SeleniumWrapperFunctions objSeleniumWrapperFunctions;

	// Application Invoke
	public void invokeApplication() {

		System.setProperty("webdriver.chromedriver",
				System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		strURL = "https://www.myntra.com/";
		this.setStrBaseURL(strURL);
		driver.get(this.getStrBaseURL());
		this.setDriver(driver);
		objUtilities = new Utilities();
		this.setObjUtilities(objUtilities);
		objSeleniumWrapperFunctions = new SeleniumWrapperFunctions(this);
		this.setObjSeleniumWrapperFunctions(objSeleniumWrapperFunctions);
		driver.manage().window().maximize();

	}

	// Thread.sleep
	public boolean waitFor(int timeUnitSeconds) {
		try {
			Thread.sleep(TimeUnit.MILLISECONDS.convert(timeUnitSeconds, TimeUnit.SECONDS));
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	// Set Implicit Wait
	public void setImplicitWait(int intImpliciWait) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(intImpliciWait));
	}

	// Close Current Window
	public void closeCurrentWindow() {

		driver.close();

	}

	// Close all windows

	public void tearDown() {

		driver.quit();
	}

	// Get the Driver
	public WebDriver getDriver() {
		return driver;
	}

	// Set the Driver
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	// Back to previous Page
	public void goBackToPreviousPage() {
		driver.navigate().back();
	}

	// Verify HomePage Title
	public void verifyPageHomeTitle(String getTitleToVerify) {

		String verifyTitle = driver.getTitle();
		if (verifyTitle.equalsIgnoreCase(getTitleToVerify))
			System.out.println("Title is Match");
		else
			System.out.println("Title not Matches");
		System.out.println("Title is " + verifyTitle);

	}

	// Verify Current Page Title
	public void verifyCurrentPageTitle(String windowTitle) {

		String parentWindow = driver.getWindowHandle();
		Set<String> objSet = driver.getWindowHandles();
		Iterator<String> iteration = objSet.iterator();

		while (iteration.hasNext()) {
			String child_window = iteration.next();

			if (!parentWindow.equals(child_window)) {
				driver.switchTo().window(child_window);
				String strgetTitle = driver.switchTo().window(child_window).getTitle();
				if (strgetTitle.equalsIgnoreCase(windowTitle))
					System.out.println("Title is Match");
				else
					System.out.println("Title not Matches");
				System.out.println("Title is " + strgetTitle);
			}

		}
		driver.close();
		driver.switchTo().window(parentWindow);
	}

	// Switch to Parent Window
	public void switchToParentWindow() {
		Set<String> allWindows = driver.getWindowHandles();
		for (String parentWindow : allWindows) {
			driver.switchTo().window(parentWindow);
			break;
		}
	}

}
