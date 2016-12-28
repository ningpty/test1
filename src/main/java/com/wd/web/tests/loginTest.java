package com.wd.web.tests;


import com.wd.web.action.ViewHomePage;
import com.wd.libarary.TestNGListener;
import com.wd.libarary.UITest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ TestNGListener.class })
public class loginTest extends UITest {

//	WebDriver driver = DriverFactory.getChromeDriver();
//	WebDriver driver = DriverFactory.getFirefoxDriver();
	WebDriver driver = new FirefoxDriver();

//	WebDriver driver = DriverFactory.getRemoteDriver(new RemoteBrowserBean("chrome"));

	@BeforeMethod(alwaysRun = true)
	public void init() {
		super.init(driver);
		ViewHomePage.setDriver(driver);
	}
	
//	@Parameters({"userName","passWord"})
//	@Test(groups = "loginTest")
//	public void loginByUerName(String userName,String passWord) throws Exception {
//		System.out.println("userName is "+userName+"; passWord is "+passWord);
//		ViewHomePage.viewHomePage();
//	}
	
	@Test(groups = "loginTest")
	public void loginByUerName() throws Exception {
		ViewHomePage.viewHomePage();
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void stop() {
//		super.stop();
	}

}
