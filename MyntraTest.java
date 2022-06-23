package com.vstl.Scripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vstl.Generic.BaseTest;
import com.vstl.Pagefactory.OpenMenTab;
import com.vstl.Pagefactory.ProductSelectionFromResult;

public class MyntraTest extends BaseTest {

	private OpenMenTab objOpenMenTab;
	private ProductSelectionFromResult objProductSelectionFromResult;

	public void initializeWebPages() {

		objOpenMenTab = new OpenMenTab(this);
		objProductSelectionFromResult = new ProductSelectionFromResult(this);
	}

	@BeforeClass (groups = "smoke")
	public void initializeWebEnvironment() {

		this.initializeWebPages();
		this.invokeApplication();
	}

	@AfterClass (groups = "smoke")
	public void tearDownEnvironments() {
		this.tearDown();
	}

	@Test(priority = 1, groups = "smoke")
	public void TCID_001_verifyPhoneCasesIsClickedfromMenCategory() {

		objOpenMenTab.mouseHoverOnMENOptionFromTopMenuBar();
		System.out.println("MouseHovered on MEN option from Top Men in HomePage");
		objOpenMenTab.verifyMobilePhonesCasesResultIsDisplayed();
		System.out.println("Phone cases Results are displayed");
		System.out.println("TestCase 01 is Executed");
	}

	@Test(priority = 2, groups = "smoke")
	public void TCID_002_selectProductfromResult_3rdRow_3rdPlace() {

		objProductSelectionFromResult.select_3rdRow_3rd_ProductFromResult();
		this.waitFor(15);
		objProductSelectionFromResult.verifyPriceIsDisplayed();
		System.out.println("TestCase 02 is Executed");
	}

	@Test(priority = 4, groups = "smoke")
	public void TCID_003_verifyAddToBagButtonIsDisplayedInSelectedProduct() {
		objProductSelectionFromResult.verifyAddBagButtonIsDisplayed();
		System.out.println("TestCase 03 is Executed");
	}

	@Test(priority = 3)
	public void TCID_004_verifyPriceIsNotLessThanRs10() {
		objProductSelectionFromResult.verifyPriceIsNotLessThanRs10();
	}
}
