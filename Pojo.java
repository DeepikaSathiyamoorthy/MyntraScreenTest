package com.vstl.Generic;

import org.openqa.selenium.WebDriver;

public class Pojo {

	private WebDriver driver;
	private String strBaseURL;
	private int intImplicitWait = 0;
	private Utilities objUtilities;

	public Utilities getObjUtilities() {
		return objUtilities;
	}

	public SeleniumWrapperFunctions getObjSeleniumWrapperFunctions() {
		return objSeleniumWrapperFunctions;
	}

	public void setObjUtilities(Utilities objUtilities) {
		this.objUtilities = objUtilities;
	}

	public void setObjSeleniumWrapperFunctions(SeleniumWrapperFunctions objSeleniumWrapperFunctions) {
		this.objSeleniumWrapperFunctions = objSeleniumWrapperFunctions;
	}

	private SeleniumWrapperFunctions objSeleniumWrapperFunctions;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public String getStrBaseURL() {
		return strBaseURL;
	}

	public void setStrBaseURL(String strBaseURL) {
		this.strBaseURL = strBaseURL;
	}

	public int getIntImplicitWait() {
		return intImplicitWait;
	}

	public void setIntImplicitWait(int intImplicitWait) {
		this.intImplicitWait = intImplicitWait;
	}

}
