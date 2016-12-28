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
//spc-87  spc-95
public class AddMultilevelCommodityModelDefaultTest extends UITest{
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
	 * 验证添加多级商品型号的初始默认状态及返回值 spc-87 后续包含spc-95 (Testlink需更新)
	 * @throws Exception
	 */
	@Test(groups = "addMultilevelCommodityModelDefaultTest")
	public void addMultilevelCommodityModelDefault() throws Exception {
		Thread.sleep(2000);
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickAddCommodityButton();
		commodityManagementPage.clickAddMultiBtn();
		Assert.assertTrue(commodityManagementPage.isColorBtn());
		Assert.assertTrue(commodityManagementPage.isSizeBtn());
		Thread.sleep(6000);
		commodityManagementPage.clickMultiCancelBtn();
		Assert.assertTrue(commodityManagementPage.isCommodityInfo());
		
		
	}
	
	/**
	 * 验证添加多个多级商品型号的乱序选择顺序 spc-95 (Testlink需更新)
	 * @throws Exception
	 */
	@Test(groups = "addMultilevelCommodityModelDefaultTest")
	public void sequenDisplayMultilevelCommodityModel() throws Exception {
		Thread.sleep(2000);
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickAddCommodityButton();
		commodityManagementPage.clickAddMultiBtn();		 
		if(!commodityManagementPage.isYuanchandi())
	{	
		//添加多级商品型号“原产地”
		 commodityManagementPage.clickCustomCommodityModel();
		 commodityManagementPage.typeCustomCommodityModel("原产地");	
		 commodityManagementPage.clickCreateCustom();		
							 }
		commodityManagementPage.clickMultiYuanchandiBtn();	
		Thread.sleep(1000);
		commodityManagementPage.clickMultiSizeBtn(); 
		Thread.sleep(1000);
		commodityManagementPage.clickMultiColorBtn(); 
		Thread.sleep(1000);
		commodityManagementPage.clickMultiConfirmBtn();		
		Thread.sleep(1000);
		
		//验证从上到下的顺序
//		System.out.print(commodityManagementPage.getFirstBtn()+"11111111111111111");
		Assert.assertEquals(commodityManagementPage.getFirstBtn(), "原产地：");
		Assert.assertEquals(commodityManagementPage.getSecondBtn(), "尺寸：");
		Assert.assertEquals(commodityManagementPage.getThirdBtn(), "颜色：");
		Thread.sleep(1000);

		
		
	}
	
	/**
	 * 验证添加多个多级商品型号的顺序勾选顺序 spc-95 (Testlink需更新)
	 * @throws Exception
	 */
	@Test(groups = "addMultilevelCommodityModelDefaultTest")
	public void otherSequenDisplayMultilevelCommodityModel() throws Exception {
		Thread.sleep(2000);
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickAddCommodityButton();
		commodityManagementPage.clickAddMultiBtn();
		if(!commodityManagementPage.isYuanchandi())
	{	
		//添加多级商品型号“原产地”
		commodityManagementPage.clickCustomCommodityModel();
		commodityManagementPage.typeCustomCommodityModel("原产地");	
		commodityManagementPage.clickCreateCustom();		
								 }
		Thread.sleep(1000);
		commodityManagementPage.clickMultiSizeBtn(); 
		Thread.sleep(1000);
		commodityManagementPage.clickMultiColorBtn(); 
		Thread.sleep(1000);
		commodityManagementPage.clickMultiYuanchandiBtn();	
		Thread.sleep(1000);
		commodityManagementPage.clickMultiConfirmBtn();		
		Thread.sleep(1000);
		
		//验证从上到下的顺序
//		System.out.print(commodityManagementPage.getFirstBtn()+"11111111111111111");
		Assert.assertEquals(commodityManagementPage.getFirstBtn(), "尺寸：");
		Assert.assertEquals(commodityManagementPage.getSecondBtn(), "颜色：");
		Assert.assertEquals(commodityManagementPage.getThirdBtn(), "原产地：");

//		Assert.assertTrue(commodityManagementPage.getFirstBtn());
		Thread.sleep(1000);
		//commodityManagementPage.clickMultiCancelBtn();
		//Assert.assertTrue(commodityManagementPage.isFirstBtn());
		
		
	}
	
	
	

}
