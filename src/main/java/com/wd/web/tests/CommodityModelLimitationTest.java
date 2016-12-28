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

//spc-100
public class CommodityModelLimitationTest extends UITest{
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
	 * 验证添加一层商品自定义商品型号最大型号上限，可以超过500 spc-100
	 * @throws Exception
	 */
//	@Test(groups = "commodityModelLimitationTest")
//	public void CommodityModelLimitation() throws Exception {
//		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
//		commodityManagementPage.setDriver(getDriver());
//		commodityManagementPage.clickCommodityManagementPageButton();
//		commodityManagementPage.clickAddCommodityButton();
//		commodityManagementPage.addPicture();
//		commodityManagementPage.typeCommodityDescription("添加的商品描述测试");			
//
//		
//		for (int i= 0;i<502;i++){
//			commodityManagementPage.clickAddCommodityModel();
//			System.out.println("begin!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+i);
//		}
//		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//		commodityManagementPage.clickAddCommodityModel();
//		Thread.sleep(2000);
	//	Assert.assertEquals(commodityManagementPage.getMessageText(), "最多支持添加500个商品型号");
		
//	}
	
	/**
	 * 验证添加多SKU商品自定义商品型号最大型号上限，不可以超过500 spc-100
	 * @throws Exception
	 */
	@Test(groups = "commodityModelLimitationTest")
	public void multSkuProMaxLimitation() throws Exception {
		Thread.sleep(2000);
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickAddCommodityButton();
		commodityManagementPage.addPicture();
		 commodityManagementPage.typeCommodityDescription("商品帽子");
		commodityManagementPage.clickAddMultiBtn();
		
		
			//循环新建4个商品型号规格
			for(int i=1; i<5;i++){
			 commodityManagementPage.clickCustomCommodityModel();
			 commodityManagementPage.typeCustomCommodityModel("多级型号测试"+i);	
			 commodityManagementPage.clickCreateCustom();	
			 Thread.sleep(2000);}
			//勾选4个属性
			  commodityManagementPage.clicktestPro4();
			  Thread.sleep(1000);
			  commodityManagementPage.clicktestPro3();
			  Thread.sleep(1000);
			  commodityManagementPage.clicktestPro2();
			  Thread.sleep(1000);
			  commodityManagementPage.clicktestPro1();  
			  Thread.sleep(1000);	
			//点击多级型号页面确定按钮
			  commodityManagementPage.clickMultiConfirmBtn();
			  
			//循环新建5个商品型号1的属性
				for(int i=1; i<6;i++){
				 commodityManagementPage.typeCreatePro1Custom("属性"+i);	
				 commodityManagementPage.clickCreatePro1Custom();	
				 Thread.sleep(2000);}				  
			//循环新建5个商品型号2的属性
				for(int i=1; i<6;i++){
				 commodityManagementPage.typeCreatePro2Custom("属性"+i);	
				 commodityManagementPage.clickCreatePro2Custom();	
				 Thread.sleep(2000);}			  
			//循环新建5个商品型号3的属性
				for(int i=1; i<6;i++){
				 commodityManagementPage.typeCreatePro3Custom("属性"+i);	
				 commodityManagementPage.clickCreatePro3Custom();	
				 Thread.sleep(2000);}				  
			//循环新建5个商品型号4的属性
				for(int i=1; i<6;i++){
				commodityManagementPage.typeCreatePro4Custom("属性"+i);	
				commodityManagementPage.clickCreatePro4Custom();	
				 Thread.sleep(2000);}
				
					
			//依次勾选型号1的五个属性
				commodityManagementPage.clickfirstPro1();	
				commodityManagementPage.clickfirstPro2();	
				commodityManagementPage.clickfirstPro3();	
				commodityManagementPage.clickfirstPro4();	
				commodityManagementPage.clickfirstPro5();	
			//依次勾选型号2的五个属性
				commodityManagementPage.clicksecondPro1();	
				commodityManagementPage.clicksecondPro2();	
				commodityManagementPage.clicksecondPro3();	
				commodityManagementPage.clicksecondPro4();	
				commodityManagementPage.clicksecondPro5();	
			//依次勾选型号3的五个属性
				commodityManagementPage.clickthirdPro1();	
				commodityManagementPage.clickthirdPro2();	
				commodityManagementPage.clickthirdPro3();
				commodityManagementPage.clickthirdPro4();
				commodityManagementPage.clickthirdPro5();
			//依次勾选型号4的五个属性
				commodityManagementPage.clickfourthPro1();	
				commodityManagementPage.clickfourthPro2();	
				commodityManagementPage.clickfourthPro3();	
				commodityManagementPage.clickfourthPro4();	
				commodityManagementPage.clickfourthPro5();	

				
		// Thread.sleep(2000);					
		Assert.assertEquals(commodityManagementPage.getMessageText(), "SKU总数量不能超过500个");		
		// Thread.sleep(2000);
		

	    
	    //验证商品管理页点击展开后是否为“原产地”“尺码”“颜色”
//	    Assert.assertTrue(commodityManagementPage.isExpandYuanchandi(), "原产地");
//	    Assert.assertTrue(commodityManagementPage.isExpandChima(), "尺码");
//	    Assert.assertTrue(commodityManagementPage.isExpandYanse(), "颜色");
//	    for(int i=2;i<6;i++){
//	    	Locator firstPro1 = new Locator(getPriceStockCode(String.valueOf(i),"pice"),ByType.cssSelector);
//	    	String aa = getText(firstPro1);
//	    	Assert.assertEquals(aa, 1);
//	    }
		
	}
	
	
	
}
