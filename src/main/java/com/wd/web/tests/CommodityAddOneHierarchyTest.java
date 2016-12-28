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

//spc-86
public class CommodityAddOneHierarchyTest extends UITest{
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
	 * 验证在添加商品型号时，输入不完整的商品型号，点击提交，系统应给出正确提示 spc-86 (Testlink需更新)
	 * @throws Exception
	 */
	@Test(groups = "commodityAddOneHierarchyTest")
	public void addOneHierarchyCommodityModeLackOfOne() throws Exception {
		Thread.sleep(6000);
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickAddCommodityButton();
		commodityManagementPage.addPicture();
		commodityManagementPage.typeCommodityDescription("添加的商品描述测试");		
		commodityManagementPage.clickAddCommodityModel();
		 
		 commodityManagementPage.addFirstModelPicture();			 
		 commodityManagementPage.clickCommodityModelModel();
		 commodityManagementPage.typecommodityModelModel("111");
		 
//		 commodityManagementPage.clickCommodityModelCode();
//		 commodityManagementPage.typecommodityModelCode("测试商品型号的编码输入框");
//		 
//		 commodityManagementPage.clickCommodityModelPrice();
//		 commodityManagementPage.typecommodityModelPrice("wrong_price");
//		 
//	     commodityManagementPage.clickCommodityModelStock();
//  	 commodityManagementPage.typecommodityModelStock("333");
		 
		commodityManagementPage.clickSubmitButton();
		Assert.assertEquals(commodityManagementPage.getMessageText(), "请完整填写第1个型号");
		
		
	}
	
	
	/**
	 * 验证在添加商品型号时，输入商品型号中的价格格式不符合，点击提交，系统应给出正确提示
	 * @throws Exception
	 */
	@Test(groups = "commodityAddOneHierarchyTest")
	public void addOneHierarchyCommodityModeLackOfModel() throws Exception {
		Thread.sleep(3000);
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickAddCommodityButton();
		commodityManagementPage.addPicture();


		 commodityManagementPage.typeCommodityDescription("添加的商品描述测试");		
		 commodityManagementPage.clickAddCommodityModel();
		 commodityManagementPage.addFirstModelPicture();

			 
		 commodityManagementPage.clickCommodityModelModel();
		 commodityManagementPage.typecommodityModelModel("111");
		 
		 commodityManagementPage.clickCommodityModelCode();
		 commodityManagementPage.typecommodityModelCode("测试商品型号的编码输入框111");
		 
		 commodityManagementPage.clickCommodityModelPrice();
		 commodityManagementPage.typecommodityModelPrice("wrong_price111");
		 
		 commodityManagementPage.clickCommodityModelStock();
		 commodityManagementPage.typecommodityModelStock("111");
		 
		 		 		 
		commodityManagementPage.clickSubmitButton();
		Assert.assertEquals(commodityManagementPage.getMessageText(), "型号1 的价格不是数字");
		
		
	}
	
	
	/**
	 * 验证在添加商品型号时，输入完整商品型号，再添加商品并输入完整型号，点击提交，系统应给出“商品发布成功”
	 * @throws Exception
	 */
	@Test(groups = "commodityAddOneHierarchyTest")
	public void addOneHierarchyCompleteCommodityMode() throws Exception {
		Thread.sleep(3000);
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickAddCommodityButton();
		commodityManagementPage.addPicture();

		 commodityManagementPage.typeCommodityDescription("添加的商品描述测试");
		
		 commodityManagementPage.clickAddCommodityModel();		 
		 commodityManagementPage.addFirstModelPicture();
		 
		 commodityManagementPage.clickCommodityModelModel();
		 commodityManagementPage.typecommodityModelModel("111");
		 
		 commodityManagementPage.clickCommodityModelCode();
		 commodityManagementPage.typecommodityModelCode("测试商品型号的编码输入框111");
		 
		 commodityManagementPage.clickCommodityModelPrice();
		 commodityManagementPage.typecommodityModelPrice("111");
		 
		 commodityManagementPage.clickCommodityModelStock();
		 commodityManagementPage.typecommodityModelStock("111");	 
		 Thread.sleep(2000);
		 
         commodityManagementPage.clickAddCommodityModel();
		 commodityManagementPage.addSecondModelPicture();
		 
		 commodityManagementPage.clickCommodityModelModelSecond();
		 commodityManagementPage.typecommodityModelModelSecond("222");
		 
		 commodityManagementPage.clickCommodityModelCodeSecond();
		 commodityManagementPage.typecommodityModelCodeSecond("测试商品型号的编码输入框222");
		 
		 commodityManagementPage.clickCommodityModelPriceSecond();
		 commodityManagementPage.typecommodityModelPriceSecond("222");
		 
		 commodityManagementPage.clickCommodityModelStockSecond();
		 commodityManagementPage.typecommodityModelStockSecond("222");	 
		 Thread.sleep(2000);
		 
		commodityManagementPage.clickSubmitButton();
		Assert.assertEquals(commodityManagementPage.getMessageText(), "商品发布成功");
		
		
	}
	
	/**
	 * 验证在添加商品型号时，没输入任何商品型号，点击提交，系统应给出正确提示
	 * @throws Exception
	 */
	@Test(groups = "commodityAddOneHierarchyTest")
	public void addOneHierarchyCommodityModeLackOfAll() throws Exception {
		Thread.sleep(3000);
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickAddCommodityButton();
	//	commodityManagementPage.clickAddCommodityPictureButton();
		commodityManagementPage.addPicture();

		commodityManagementPage.typeCommodityDescription("添加的商品描述测试");
		commodityManagementPage.clickAddCommodityModel();
		 
		 
		commodityManagementPage.clickSubmitButton();
		Assert.assertEquals(commodityManagementPage.getMessageText(), "型号都空着呢呀");
			
	}

	

	
}
