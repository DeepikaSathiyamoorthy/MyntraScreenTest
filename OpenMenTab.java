package com.vstl.Pagefactory;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.vstl.Generic.Pojo;

public class OpenMenTab {

	private Pojo objPojo;

	public OpenMenTab(Pojo pojo) {
		this.objPojo = pojo;
	}

	By loc_lnkMen = By.xpath("//a[@data-group='men' and @class='desktop-main']");
	By loc_lnkPhoneCases = By.xpath("//a[text()='Phone Cases']");
	By loc_txtMobilePhonesCases = By.xpath("//h1[text()='Mobile Phone Cases']");

	public void mouseHoverOnMENOptionFromTopMenuBar() {

		Assert.assertTrue(objPojo.getObjSeleniumWrapperFunctions().mouseHover(loc_lnkMen));
		Assert.assertTrue(objPojo.getObjSeleniumWrapperFunctions().clickEvent(loc_lnkPhoneCases));
	}
	
	public void verifyMobilePhonesCasesResultIsDisplayed() {
		Assert.assertTrue(objPojo.getObjSeleniumWrapperFunctions().getText(loc_txtMobilePhonesCases).equals("Mobile Phone Cases"));
	}

}
