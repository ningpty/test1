package com.wd.web.tests;
import com.wd.web.action.ViewHomePage;
import com.wd.web.action.CommodityManagementAction;
import com.wd.libarary.DriverFactory;
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
//spc-89  spc-91
public class AddCustomCommodityModelTest extends UITest{
WebDriver driver = DriverFactory.getChromeDriver();
	
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
	 * 添加多级商品自定义型号 spc-89 (Testlink需更新) （此页面包含spc-91验证自定义型号重复性）
	 * @throws Exception
	 */
	@Test(groups = "addCustomCommodityModelTest")
	public void AddCustomCommodityModel() throws Exception {
		Thread.sleep(2000);
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickAddCommodityButton();
		commodityManagementPage.clickAddMultiBtn();
		
		 commodityManagementPage.clickCustomCommodityModel();
		 commodityManagementPage.typeCustomCommodityModel("原产地");	
		 commodityManagementPage.clickCreateCustom();		
		 commodityManagementPage.clickMultiYuanchandiBtn();	
		Thread.sleep(3000);
		 commodityManagementPage.clickMultiConfirmBtn();
		Assert.assertTrue(commodityManagementPage.isCommodityInfo());


	}

	
	/**
	 * 验证自定义型号重复性 spc-91 (Testlink需更新) 
	 * @throws Exception
	 */	
	@Test(groups = "addCustomCommodityModelTest")
	public void RepeatedCustomCommodityModel() throws Exception {
		Thread.sleep(2000);
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickAddCommodityButton();
		commodityManagementPage.clickAddMultiBtn();
		
		commodityManagementPage.clickCustomCommodityModel();
		commodityManagementPage.typeCustomCommodityModel("原产地");	
		commodityManagementPage.clickCreateCustom();	
		Thread.sleep(2000);
		commodityManagementPage.typeCustomCommodityModel("原产地");	
		Thread.sleep(2000);
		commodityManagementPage.clickCreateCustom();
		Thread.sleep(1000);
		Assert.assertEquals(commodityManagementPage.getMessageText(), "型号重复");
		
		
	}
	
	

}
