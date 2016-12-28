package com.wd.web.tests;
import com.wd.web.action.ViewHomePage;
import com.wd.web.action.CommodityManagementAction;
import com.wd.libarary.DriverFactory;
import com.wd.libarary.TestNGListener;
import com.wd.libarary.UITest;
import com.wd.web.page.CommodityManagementPage;

import java.sql.Date;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//spc-85
public class AddCommodityPicFrequencyLimitation extends UITest{
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
	 * 验证一分钟添加超过100个商品图片，系统会添加过于频繁 spc-85(Testlink需更新)
	 * @throws Exception
	 */
	@Test(groups = "addCommodityPicFrequencyLimitation")
	public void AddCommodityPicOverLimitation() throws Exception {
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.setDriver(getDriver());
		commodityManagementPage.clickCommodityManagementPageButton();
		commodityManagementPage.clickAddCommodityButton();

		for (int i= 0;i<12;i++){
			//System.out.println("begin!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+i);
			//commodityManagementPage = new CommodityManagementPage(getDriver());
			
			commodityManagementPage.addPicture();
			commodityManagementPage.addPicture();
			commodityManagementPage.addPicture();
			commodityManagementPage.addPicture();
			commodityManagementPage.addPicture();
			commodityManagementPage.addPicture();
			commodityManagementPage.addPicture();
			commodityManagementPage.addPicture();
			commodityManagementPage.addPicture();
			commodityManagementPage.addPicture();
//			commodityManagementPage.clickAddCommodityPictureButton();
//			UITest.sikuliClickPic("/Users/zhangyifan/weidian_web_test/imgs/clickthis.png");
//			UITest.sikuliClickPic("/Users/zhangyifan/weidian_web_test/imgs/pic.png");
//			UITest.sikuliClickPic("/Users/zhangyifan/weidian_web_test/imgs/open.png");
		
//			commodityManagementPage.clickCommodityManagementPageButton();
//			Assert.assertTrue(commodityManagementPage.isCommodity(), "add commodity failed");
		
			 //System.out.println("di"+i+ "ci");
		}
		commodityManagementPage.typeCommodityDescription("[请注意]这是一个测试商品");
		commodityManagementPage.typeCommoditPrice("100");
		commodityManagementPage.typeCommodityStock("99");
		commodityManagementPage.typeCommodityCode("88");
		commodityManagementPage.clickSubmitButton();
		Assert.assertEquals(commodityManagementPage.getMessageText(), "商品发布成功");
//		System.out.println("end!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+i);
		Thread.sleep(3000);
		
			
	}
	
	
	

}
