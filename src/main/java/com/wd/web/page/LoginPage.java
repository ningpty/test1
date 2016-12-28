package com.wd.web.page;

import com.wd.libarary.BasePage;
import com.wd.libarary.Locator;
import com.wd.libarary.Locator.ByType;

import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage {

	WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public LoginPage(WebDriver driver) throws Exception {
		super(driver);
		driver.get("http://d.weidian.com");
	}

	Locator phoneInputBox = new Locator("phoneInputBox",35);
	Locator loginPasswordInputBox = new Locator("loginPasswordInputBox");
	Locator loginButton = new Locator("loginButton");
	Locator profile = new Locator("profile");
	Locator iframe = new Locator("loginIframe");
	Locator next = new Locator("nextButton");
	Locator clickToLoginRegisterButton=new Locator("clickToLoginRegisterButton");
	
	
	Locator phoneNo = new Locator("input[name='telephone']",ByType.cssSelector);
	Locator passwords = new Locator("input[name='password']",ByType.cssSelector);
	Locator loginBtn = new Locator("a[ng-click='submitUserInfo()']",ByType.cssSelector);

//	public void typePhoneNoInputBox(String phoneno) throws Exception {
////		open("http://i.weidian.com");
//		switchToLogin();
//		switchToIframe();
//		type(phoneInputBox, phoneno);
//	}

	
	//登录页输入手机号
	public void typePhoneNoInputBox(String phoneno) throws Exception {
		type(phoneNo,phoneno);
	}
	
	//登录页输入密码
	public void typePasswordInputBox(String password) throws Exception {
		type(passwords, password);
	}
	
	//点击进入微店按钮，即登录按钮
	public void clickLoginBtn() throws Exception {
		click(loginBtn);
	}
	
	
	
	
	
	
//	public void typePasswordInputBox(String password) throws Exception {
//		type(loginPasswordInputBox, password);
//	}

	public void clickOnLoginButton() throws Exception {
		click(loginButton);
	}

	public boolean isPrestentProfile() throws IOException {
		return isElementPresent(profile, 20);

	}

	public void waitForPageLoad() {
		super.getDriver().manage().timeouts()
				.pageLoadTimeout(30, TimeUnit.SECONDS);//pageLoadTimeout方法用来设置页面完全加载的超时时间，完全加载即页面全部渲染，异步同步脚本都执行完成。
	}

	public void switchToLogin() throws Exception
	{
		
		click(clickToLoginRegisterButton);
	}
	
	//选择登录页中的iframe
	public void switchToIframe() throws Exception {
		switchToIframe(iframe);
	}
	
	//选择完iframe后，需要返回到默认页
	public void defaultToContent() throws Exception {
		defaultContent();
	}
	
	//输入完手机号后点击的下一步按钮
	public void clickOnNextButton() throws Exception {
		click(next);
	}
	
}
