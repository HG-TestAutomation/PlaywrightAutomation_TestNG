package com.qa.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.ecommerce.base.BaseTest;
import com.qa.ecommerce.constants.AppConstants;

public class LoginPageTest extends BaseTest{
	
	@Test(priority =1)
	public void loginPageNavigationTest() {
		loginPage = homePage.clickMyAccountLink();
		String actualLoginPageTitle = loginPage.getLoginPageTitle();
		System.out.println("page actual title: " + actualLoginPageTitle);
		Assert.assertEquals(actualLoginPageTitle, AppConstants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority =2)
	public void forgotPwdLinkExistTest() {
		loginPage = homePage.clickMyAccountLink();
		Assert.assertTrue(loginPage.doesForgotPwdExist());	
	}
	@Test(priority =3)
	public void appLoginTest() {
		Assert.assertTrue(loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim()));
		
	}

}
