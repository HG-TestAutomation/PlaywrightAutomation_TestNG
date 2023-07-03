package com.qa.ecommerce.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
	
	   private Page page;
	     
	    private final Locator USERNAME_EDITBOX;
	    private final Locator PASSWORD_EDITBOX;
	    private final Locator LOGIN_BTN;
	    private final Locator FORGOT_PW_LINK;
	    private final Locator GREETING_TITLE;
	    

	    public LoginPage(Page page) {
	        this.page = page;
	        this.USERNAME_EDITBOX = page.getByLabel("Username or email address *");
	        this.PASSWORD_EDITBOX = page.locator("#password");
	        this.LOGIN_BTN = page.locator("//button[normalize-space()='Log in']");
	        this.FORGOT_PW_LINK = page.locator("//a[normalize-space()='Lost your password?']");
	        this.GREETING_TITLE = page.locator("//body/div[@id='wpadminbar']/div[@id='wp-toolbar']/ul[@id='wp-admin-bar-top-secondary']/li[@id='wp-admin-bar-my-account']/a[1]");
	        
	         
	    }
	    
	    public String getLoginPageTitle() {
	    	return page.title();
	    }
	    
	    public boolean doesForgotPwdExist() {
	    	return FORGOT_PW_LINK.isVisible();
	    }
	    
	    public boolean doLogin(String appUsername, String appPassword) {
	    	System.out.println("App credentials: "+ appUsername + ":" + appPassword);
	    	USERNAME_EDITBOX.fill(appUsername);
	    	PASSWORD_EDITBOX.fill(appPassword);
	    	LOGIN_BTN.click();
	    	if(GREETING_TITLE.isVisible()) {
	    		System.out.println("user logged in successfully");
	    		return true;
	    	}
	    	return false;
	    }

}
