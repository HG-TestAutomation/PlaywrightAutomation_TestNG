package com.qa.ecommerce.base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.qa.ecommerce.factory.PlaywrightFactory;
import com.qa.ecommerce.pages.HomePage;
import com.qa.ecommerce.pages.LoginPage;

public class BaseTest {

	PlaywrightFactory pf;
	Page page;
	protected Properties prop;
	
	protected HomePage homePage;
	protected LoginPage loginPage;
	
	@BeforeTest
	public void setup() {
		pf = new PlaywrightFactory();
		prop = pf.init_prop();
		page = pf.initBrowser(prop);
		homePage = new HomePage(page);
		
	}
	
	@AfterTest
	public void tearDown() {
		page.context().close();
	}
	
}
