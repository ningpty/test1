package com.wd.libarary;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

import com.wd.web.action.CommodityManagementAction;
import com.wd.web.action.ViewHomePage;
import com.wd.web.page.HomePage;

public class Before extends UITest{
	@BeforeSuite()
	public void beforeClass() throws Exception {
		WebDriver driver = DriverFactory.getChromeDriver();
		super.init(driver);
		HomePage homePage = new HomePage(driver);
		if(homePage.isElementExistCommodityManagement()){
			
		}else{
			ViewHomePage.setDriver(driver);
			ViewHomePage.viewHomePage();
			CommodityManagementAction.setDriver(driver);
		}
//		CommodityManagementAction.addCommodity("[请注意]这是一个测试商品","34.44","80","1111111");
//		Thread.sleep(1000);
//		CommodityManagementAction.addCommodity("[请注意]这是一个测试商品","55.65","90","2222222");
//		Thread.sleep(1000);
//		CommodityManagementAction.addCommodity("[请注意]这是一个测试商品","67.54","100","33333333");
//		Thread.sleep(1000);
//		CommodityManagementAction.addCommodity("[请注意]这是一个测试商品","78.44","130","33333333");
	}
}
