package com.wd.h5.page;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.wd.libarary.BasePage;
import com.wd.libarary.Locator;
import com.wd.libarary.Locator.ByType;

/**
 * 登陆页面
 */
public class LoginPage extends BasePage {

	WebDriver driver;

	// 手机号码输入框
	Locator phoneInputBox = new Locator("login_tele_input");
	// 密码输入框
	Locator loginPasswordInputBox = new Locator("login_isRegi_input");
	// 登陆按钮
	Locator loginButton = new Locator("login_isRegi_submit");
	// iframe
	Locator iframe = new Locator("login_iframe_wrapper");
	// 下一步
	Locator next = new Locator("login_tele_submit");
	// 登陆/注册按钮
	Locator clickToLoginRegisterButton = new Locator("login");
	// 退出登陆
	Locator signOut = new Locator("signOut");//实例化元素时，声明等待时间为多少秒，即等待多少秒。
	// 获取login页面title文案
	Locator loginTitle = new Locator("#login_tele_wrapper > h3", ByType.cssSelector);
	// 获取注册title文案
	Locator regiTitle = new Locator("#login_isRegi_wrapper > h3", ByType.cssSelector);
	// 获取手机号码
	Locator loginShowTele = new Locator("login_isRegi_show_tele");
	// 更换手机号码
	Locator changeTeleLink = new Locator("a.login_change_tele_link", ByType.cssSelector);
	// 忘记密码
	Locator forgetPasswordLink = new Locator("a.login_forget_pwd_link", ByType.cssSelector);
	// 注册验证码和密码填写页面
	Locator noRegiTitle = new Locator("#login_noRegi_wrapper > h3", ByType.cssSelector);
	// Alert提示
	Locator alert_Content = new Locator("_alert_content");

	// 方法目前应该并没有什么用
	public WebDriver getDriver() {
		return driver;
	}

	public LoginPage(WebDriver driver) throws Exception {
		super(driver);
//		driver.get("http://i.weidian.com");
	}

	public void typePhoneNoInputBox(String phoneno) throws Exception {
//		open("http://i.weidian.com");
//		switchToLogin(); // 个人中心点击登录
		switchToIframe();
		type(phoneInputBox, phoneno);
	}

	// 已经在登录的iframe中之后 不需要再次
	public void typePhoneNoInputBox02(String phoneno) throws Exception {
		type(phoneInputBox, phoneno);
	}

	// 输入密码
	public void typePasswordInputBox(String password) throws Exception {
		type(loginPasswordInputBox, password);
	}

	//点击登陆按钮
	public void clickOnLoginButton() throws Exception {
		click(loginButton);
	}

	// 等页面加载
	public void waitForPageLoad() {
		super.getDriver().manage().timeouts()
				.pageLoadTimeout(30, TimeUnit.SECONDS);//pageLoadTimeout方法用来设置页面完全加载的超时时间，完全加载即页面全部渲染，异步同步脚本都执行完成。
	}

	// 获取提示文案
	public String getAlertContent() throws Exception {
		return getText(alert_Content);
	}

	//
	public boolean isElementExist() throws Exception {
		return isElementExist(alert_Content);
//		return getAlertText();
	}

	// 点击更换手机号
	public void clickChangeTeleLink() throws Exception {
		click(changeTeleLink);
	}

	// 点击忘记密码
	public void clickForgetPasswordLink() throws Exception {
		click(forgetPasswordLink);
	}

	// 更换手机号是否存在
	public boolean isChangeTeleLink() throws IOException {
		return isElementPresent(changeTeleLink, 5);
	}

	// 忘记密码是否存在
	public boolean isForgetPasswordLink() throws IOException {
		return isElementPresent(forgetPasswordLink, 5);
	}

	// 获取登录页面title文案
	public String getLoginTitleText() throws Exception {
		return getText(loginTitle);
	}

	// 获取登录页面title文案
	public String getRegiTitleText() throws Exception {
		return getText(regiTitle);
	}

	// 获取登录页面title文案
	public String getNoRegiTitleText() throws Exception {
		return getText(noRegiTitle);
	}

	// 获取登录下一步文案
	public String getTeleSubmitText() throws Exception {
		return getText(next);
	}

	// 获取登录按钮文案
	public String getLoginSubmitText() throws Exception {
		return getText(loginButton);
	}

	public String getLoginShowTeleText() throws Exception {
		return getText(loginShowTele);
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

	public boolean isPrestentProfile() throws IOException {
		return isElementPresent(signOut, 10);
	}

	public void clickSignOut() throws Exception {
		click(signOut);
	}
}
