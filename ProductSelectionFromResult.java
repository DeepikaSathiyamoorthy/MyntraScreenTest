package com.vstl.Pagefactory;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.vstl.Generic.Pojo;

public class ProductSelectionFromResult {

	private Pojo objPojo;

	public ProductSelectionFromResult(Pojo pojo) {

		this.objPojo = pojo;
	}

	By loc_lnkProduct = By.xpath("//div[@id='mountRoot']//ul/li[@class='product-base'][11]");
	By loc_txtPrice = By.xpath("//div[@id='mountRoot']//strong[contains(text(),'Rs.')]");
	By loc_btnAddBag = By.xpath("//div[contains(@class,'add-to-bag')]");

	public void select_3rdRow_3rd_ProductFromResult() {

		String parentTab = objPojo.getDriver().getWindowHandle();
		objPojo.getObjSeleniumWrapperFunctions().clickEvent(loc_lnkProduct);
		ArrayList<String> newTab = new ArrayList<String>(objPojo.getDriver().getWindowHandles());
		newTab.remove(parentTab);
		objPojo.getDriver().switchTo().window(newTab.get(0));
		System.out.println("Product is selected from the Result ");
	}

	public void verifyPriceIsDisplayed() {
		String strPrice = objPojo.getObjSeleniumWrapperFunctions().getText(loc_txtPrice);
		Assert.assertTrue(objPojo.getObjSeleniumWrapperFunctions().getText(loc_txtPrice).contains("Rs."));
		System.out.println("Price of the Product is " + strPrice);
	}

	public void verifyAddBagButtonIsDisplayed() {
		Assert.assertTrue(objPojo.getObjSeleniumWrapperFunctions().isDisplayed(loc_btnAddBag));
		System.out.println("Add to Bag Button is displayed");
	}

	public void verifyPriceIsNotLessThanRs10() {

		String strPrice = objPojo.getObjSeleniumWrapperFunctions().getText(loc_txtPrice);
		String strNonStringValue = strPrice.replaceAll("Rs. ", "");

		int intPrice = Integer.parseInt(strNonStringValue);
		if (intPrice >= 10)
			System.out.println("Price of the Selected Product is " + intPrice + " which is not less than Rs.10/- ");
		else
			System.out.println("Price of the Product is " + intPrice + " which is Less Than Rs.10/-");
	}

}
