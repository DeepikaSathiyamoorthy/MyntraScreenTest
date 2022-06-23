package com.vstl.Generic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumWrapperFunctions {

	private Pojo objPojo;

	public SeleniumWrapperFunctions(Pojo pojo) {
		this.objPojo = pojo;
	}

	// TextBox
	public boolean setText(By locator, String inputValue) {
		try {
			objPojo.getDriver().findElement(locator).sendKeys(inputValue);
			return true;
		} catch (Exception exception) {
			System.out.println("Error Occured TextBox is : " + exception.getMessage());
			exception.printStackTrace();
			return false;
		}

	}

	// DropDown
	public boolean selectDropDown(By locator, String selectValue) {
		try {
			Select selectDropDown = new Select(objPojo.getDriver().findElement(locator));
			selectDropDown.selectByVisibleText(selectValue);
			return true;
		} catch (Exception exception) {
			System.out.println("Error Occured in DropDown is : " + exception.getMessage());
			exception.printStackTrace();
			return false;
		}
	}

	// CheckBox / Link /Button /Radio

	public boolean clickEvent(By locator) {
		try {
			objPojo.getDriver().findElement(locator).click();
			return true;
		} catch (Exception exception) {
			System.out.println("Error Occured in checkBox/Link/Button/Radio is : " + exception.getMessage());
			exception.printStackTrace();
			return false;
		}
	}

	// Mouse Hover

	public boolean mouseHover(By locator) {

		try {
			WebElement objWebElement = objPojo.getDriver().findElement(locator);
			Actions objActions = new Actions(objPojo.getDriver());
			objActions.moveToElement(objWebElement).perform();
			return true;
		} catch (Exception exception) {
			System.out.println("Error Occured in checkBox/Link/Button/Radio is : " + exception.getMessage());
			exception.printStackTrace();
			return false;
		}
	}
	
	// Get Text
	
	public String getText(By locator) {

		try {
			String getText = objPojo.getDriver().findElement(locator).getText().trim();
			return getText;
		} catch (Exception exception) {
			System.out.println("Error Occured in getText is : " + exception.getMessage());
			exception.printStackTrace();
			return null;
		}

	}

	//Verify locator is Displayed

	public boolean isDisplayed(By locator) {
		try {
			objPojo.getDriver().findElement(locator).isDisplayed();
			return true;
		} catch (Exception exception) {
			System.out.println("Error Occured in checkBox/Link/Button/Radio is Displayed method : " + exception.getMessage());
			exception.printStackTrace();
			return false;
		}
	}
}
