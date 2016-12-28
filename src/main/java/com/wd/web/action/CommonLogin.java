package com.wd.web.action;

import com.wd.web.page.HomePage;
import com.wd.web.page.LoginPage;
import com.wd.libarary.PageFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CommonLogin {

	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	static LoginPage loginPage;
	static HomePage homePage;

	public static HomePage login(String phoneno, String password)
			throws Exception {
		loginPage = new LoginPage(getDriver());
		homePage = new HomePage(getDriver());
		
		loginPage.waitForPageLoad();
		loginPage.typePhoneNoInputBox(phoneno);
		loginPage.typePasswordInputBox(password);
		loginPage.clickLoginBtn();
		Thread.sleep(3000);
		Assert.assertTrue(homePage.isElementExistSignOut(), "login failed");
		return (HomePage) PageFactory.getPage(HomePage.class, getDriver());
	}

	public static HomePage login() throws Exception {
		return CommonLogin.login("12344734232", "123456");
	}
		
	public static void setDriver(WebDriver driver) {
		CommonLogin.driver = driver;
	}

}
