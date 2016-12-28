package com.wd.web.tests;
import com.wd.web.action.ViewHomePage;
import com.wd.web.action.CommodityManagementAction;
import com.wd.libarary.DriverFactory;
import com.wd.libarary.Locator;
import com.wd.libarary.TestNGListener;
import com.wd.libarary.UITest;
import com.wd.libarary.Locator.ByType;
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


//spc-99
public class BatchSetOfAddCommutityTest extends UITest{
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
	 * 添加商品自定义商品型号批量设置 spc-99
	 * @throws Exception
	 */
	@Test(groups = "batchSetOfAddCommutityTest")
	public void batchSetOfAddCommutity() throws Exception {
		Thread.sleep(2000);
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickAddCommodityButton();
		commodityManagementPage.addPicture();
		 commodityManagementPage.typeCommodityDescription("测试商品批量设置");
		commodityManagementPage.clickAddMultiBtn();
		//添加 “颜色” “尺寸” 的商品型号
	
			commodityManagementPage.clickMultiSizeBtn(); 
			Thread.sleep(1000);
			commodityManagementPage.clickMultiColorBtn(); 
			Thread.sleep(1000);
			commodityManagementPage.clickMultiConfirmBtn();		
			Thread.sleep(1000);

			//循环新建2个商品型号1的属性
			for(int i=1; i<3;i++){
			 commodityManagementPage.typeCreatePro1Custom("属性"+i);	
			 commodityManagementPage.clickCreatePro1Custom();	
			 Thread.sleep(2000);}	
			//循环新建2个商品型号2的属性
			for(int i=1; i<3;i++){
			 commodityManagementPage.typeCreatePro2Custom("属性"+i);	
			 commodityManagementPage.clickCreatePro2Custom();	
			 Thread.sleep(2000);}
			//依次勾选型号1的两个属性
			commodityManagementPage.clickfirstPro1();	
			commodityManagementPage.clickfirstPro2();	

		//依次勾选型号2的两个属性
			commodityManagementPage.clicksecondPro1();	
			commodityManagementPage.clicksecondPro2();	
			
		//依次输入批量价格，批量库存
			commodityManagementPage.typeBatchPrice("100");	
			Thread.sleep(3000);
		//随便点击下其他地方，比如“其他信息”
			commodityManagementPage.clickQitaxinxi();
			Thread.sleep(2000);
			commodityManagementPage.typeBatchStock("200");	
			Thread.sleep(3000);
		//随便点击下其他地方，比如“其他信息”
			commodityManagementPage.clickQitaxinxi();
			Thread.sleep(2000);
		//验证价格、库存列分别为100，200
		 Assert.assertEquals(commodityManagementPage.getpriceSku1Text(), "100");
		 Assert.assertEquals(commodityManagementPage.getpriceSku2Text(), "100");
		 Assert.assertEquals(commodityManagementPage.getpriceSku3Text(), "100");
		 Assert.assertEquals(commodityManagementPage.getpriceSku4Text(), "100");
		 
		 Assert.assertEquals(commodityManagementPage.getstockSku1Text(), "200");
		 Assert.assertEquals(commodityManagementPage.getstockSku2Text(), "200");
		 Assert.assertEquals(commodityManagementPage.getstockSku3Text(), "200");
		 Assert.assertEquals(commodityManagementPage.getstockSku4Text(), "200");
			
		//修改某一行“价格”	
		 commodityManagementPage.typePriceSku1("111");	
			Thread.sleep(3000);
		//随便点击下其他地方，比如“其他信息”
			commodityManagementPage.clickQitaxinxi();
			Thread.sleep(2000);
		//修改某一行“库存”	
			commodityManagementPage.typeStockSku1("222");	
			Thread.sleep(3000);
		//随便点击下其他地方，比如“其他信息”
			commodityManagementPage.clickQitaxinxi();
			Thread.sleep(2000);
				
			Assert.assertEquals(commodityManagementPage.getpriceSkuText(), "");
			System.out.print("!!!!!!!!!"+commodityManagementPage.getpriceSkuText()+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			 Thread.sleep(2000);	
			 Assert.assertEquals(commodityManagementPage.getpriceSkuText(), "");
			System.out.print(commodityManagementPage.getpriceSkuText()+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");			
			 Thread.sleep(2000);	

	//	Assert.assertEquals(commodityManagementPage.getMessageText(), "商品发布成功");		
		

	    
		
		
	    
	
		
	}
	
	
	
	
	
	

}
