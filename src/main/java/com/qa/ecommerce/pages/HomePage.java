package com.qa.ecommerce.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage {

	private Page page;

	// 1. String Locators - OR
	private final Locator NO_BUTTON;
	private final Locator USERNAME_LINK;
	private final Locator SEARCHBOX;
	private final Locator SEARCH_HEADER;
	private final Locator MY_ACCOUNT_TAB;

	// 2. page contructor
	public HomePage(Page page) {
		this.page = page;
		this.NO_BUTTON = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("No"));
		this.USERNAME_LINK = page.getByText("Gabriel Mendez");
		this.SEARCHBOX = page.getByRole(AriaRole.SEARCHBOX, new Page.GetByRoleOptions().setName("Search for:"));
		this.SEARCH_HEADER = page.locator("//*[@class='woocommerce-products-header__title page-title']");
		this.MY_ACCOUNT_TAB = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("My account")).first();

	}
	// 3. page actions/methods

	public void clickNoBtn() {
		NO_BUTTON.click();
	}

	public void clickUsernameLink() {
		USERNAME_LINK.click();
	}

	public LoginPage clickMyAccountLink() {

		MY_ACCOUNT_TAB.click();
		return new LoginPage(page);

	}

	public String getHomePageTitle() {
		String title = page.title();
		System.out.println("page title is: " + title);
		return title;
	}

	public String getHomePageUrl() {
		String url = page.url();
		System.out.println("page url is: " + url);
		return url;

	}

	public String doSearch(String productName) {
		SEARCHBOX.fill(productName);
		SEARCHBOX.press("Enter");
		String header = SEARCH_HEADER.textContent();
		System.out.println("search header: " + header);
		return header;

	}

}
