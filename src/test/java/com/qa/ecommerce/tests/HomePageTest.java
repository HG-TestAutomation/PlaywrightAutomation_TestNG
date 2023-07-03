package com.qa.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.ecommerce.base.BaseTest;
import com.qa.ecommerce.constants.AppConstants;

public class HomePageTest extends BaseTest{

	@Test
	public void homePageTitleTest() {
		String actualTitle = homePage.getHomePageTitle();
		Assert.assertEquals(actualTitle, AppConstants.HOME_PAGE_TITLE);
	}

	@Test
	public void homePageUrlTest() {
		String actualUrl = homePage.getHomePageUrl();
		Assert.assertEquals(actualUrl, prop.getProperty("url"));
	}
	
	@DataProvider
	public Object [][] getProductData() {
		return new Object[][] {
			{"beanie"},
			{"logo"},
			{"shirt"}
		};
	}

	@Test(dataProvider = "getProductData")
	public void searchTest(String productName) {
		String actualSearchHeader = homePage.doSearch(productName);
		Assert.assertEquals(actualSearchHeader, "Search results: “"+productName+"”");
	}

	
}
