/**
 * 
 */
package com.wd.web.action;

import com.wd.web.page.HomePage;
import org.openqa.selenium.WebDriver;

/**
     * @author WD
 *
 */
public class ViewHomePage {

	private static WebDriver driver;
	private static HomePage homePage;

	public static WebDriver getDriver() {
		return driver;
	}

	public static HomePage viewHomePage() throws Exception {
		
		CommonLogin.setDriver(driver);
		homePage = CommonLogin.login();
		return homePage;
	}

	public static void setDriver(WebDriver driver) {
		ViewHomePage.driver = driver;
	}

}
