package com.wd.h5.action;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.wd.h5.page.LoginPage;
import com.wd.libarary.PageFactory;

public class CommonLogin {

	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	static LoginPage loginPage;

	public static void login(String phoneno, String password)
			throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.typePhoneNoInputBox(phoneno);
		loginPage.clickOnNextButton();
		loginPage.typePasswordInputBox(password);
		loginPage.clickOnLoginButton();
		loginPage.defaultToContent();
		Thread.sleep(2000);
	}

	public static void login() throws Exception {
		CommonLogin.login("13161790208", "123456");
	}
		
	public static void setDriver(WebDriver driver) {
		CommonLogin.driver = driver;
	}

}
