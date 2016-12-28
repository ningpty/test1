package com.wd.web.tests;

import com.wd.web.action.ViewHomePage;
import com.wd.web.action.CommodityManagementAction;
import com.wd.libarary.DriverFactory;
import com.wd.libarary.PageFactory;
import com.wd.libarary.TestNGListener;
import com.wd.libarary.UITest;
import com.wd.web.page.CommodityManagementPage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ TestNGListener.class })
//spc-84
public class AddCommodityFrequencyLimitation extends UITest{
	WebDriver driver = DriverFactory.getChromeDriver();
//	WebDriver driver = DriverFactory.getRemoteDriver(new RemoteBrowserBean("chrome"));
	
	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		super.init(driver);
		ViewHomePage.setDriver(driver);
		CommodityManagementAction.setDriver(driver);
		ViewHomePage.viewHomePage();
	}
	
	
	@BeforeMethod(alwaysRun = true)
	public void init() {
		//每个测试方法之前执行一次
	}
	
	

	/**
	 * 验证一分钟添加5个商品，超过则显示添加过于频繁 spc-84
	 * @throws Exception
	 */
	@Test(groups = "addCommodityFrequencyLimitation")
	public void AddCommodityOverLimitation() throws Exception {
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.setDriver(getDriver());
		commodityManagementPage.clickCommodityManagementPageButton();
		commodityManagementPage.clickAddCommodityButton();
		for (int i= 0;i<5;i++){
	//		System.out.println("begin!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+i);
			//commodityManagementPage = new CommodityManagementPage(getDriver());
			
			commodityManagementPage.addPicture();
			commodityManagementPage.typeCommodityDescription("[请注意]这是一个测试商品");
			commodityManagementPage.typeCommoditPrice("100");
			commodityManagementPage.typeCommodityStock("99");
			commodityManagementPage.typeCommodityCode("88");
			commodityManagementPage.clickSubmitButton();
			Assert.assertEquals(commodityManagementPage.getMessageText(), "商品发布成功");
//			System.out.println("end!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+i);
			Thread.sleep(3000);
//			commodityManagementPage.clickCommodityManagementPageButton();
//			Assert.assertTrue(commodityManagementPage.isCommodity(), "add commodity failed");
		
			 //System.out.println("di"+i+ "ci");
		}
		commodityManagementPage.addPicture();
		commodityManagementPage.typeCommodityDescription("[请注意]这是一个测试商品");
		commodityManagementPage.typeCommoditPrice("100");
		commodityManagementPage.typeCommodityStock("99");
		commodityManagementPage.typeCommodityCode("88");
		commodityManagementPage.clickSubmitButton();
		Assert.assertEquals(commodityManagementPage.getMessageText(), "你添加商品次数太频繁啦,请稍后重试");
		Thread.sleep(2000);	
	}
	
	
	
}
