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

//spc-88   spc-93
public class AddMaxLimiCommodityModelTest extends UITest{
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
	 * 验证勾选多个多级商品型号上限（前提添加原产地、气味、材质、图形、颜色等商品型号）spc-88 spc-93 (Testlink需更新)
	 * @throws Exception
	 */
	@Test(groups = "addCustomCommodityModelTest")
	public void AddCustomCommodityModel() throws Exception {
		Thread.sleep(2000);
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickAddCommodityButton();
		commodityManagementPage.clickAddMultiBtn();
		//新建型号原产地
		if(!commodityManagementPage.isYuanchandi())
{	
		//添加多级商品型号“原产地”
		commodityManagementPage.clickCustomCommodityModel();
		commodityManagementPage.typeCustomCommodityModel("原产地");	
		commodityManagementPage.clickCreateCustom();		
				 }

		 
		//新建型号图形
		 commodityManagementPage.clickCustomCommodityModel();
		 commodityManagementPage.typeCustomCommodityModel("图形");	
		 commodityManagementPage.clickCreateCustom();	
		 Thread.sleep(2000);
		//新建型号材质
		 commodityManagementPage.clickCustomCommodityModel();
		 commodityManagementPage.typeCustomCommodityModel("材质");	
		 commodityManagementPage.clickCreateCustom();	
		 Thread.sleep(2000);
		 
		//新建型号气味
		 commodityManagementPage.clickCustomCommodityModel();
		 commodityManagementPage.typeCustomCommodityModel("气味");	
		 commodityManagementPage.clickCreateCustom();	
		 Thread.sleep(2000);

		 
		 //勾选几个自定义型号及原有型号
		  commodityManagementPage.clickMultiYuanchandiBtn();
		  Thread.sleep(1000);
		  commodityManagementPage.clickTuxingBtn();
		  Thread.sleep(1000);
		  commodityManagementPage.clickCaizhiBtn();
		  Thread.sleep(1000);
		  commodityManagementPage.clickMultiQiweiBtn();  
		  Thread.sleep(1000);
		  commodityManagementPage.clickMultiColorBtn();  		  
	      Thread.sleep(1000);
	      Assert.assertEquals(commodityManagementPage.getMessageText(), "商品型号不能超过4个");
	      Thread.sleep(2000);
		 commodityManagementPage.clickMultiCancelBtn();
//		 Assert.assertTrue(commodityManagementPage.isCommodityInfo());
		
		
	}
	
	
	/**
	 * 验证添加多个商品规格上限（添加超过20个）spc-93 (Testlink需更新)
	 * @throws Exception
	 */
	@Test(groups = "addCustomCommodityModelTest")
	public void AddMaxLimCustomCommodityModel() throws Exception {
		Thread.sleep(1000);
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickAddCommodityButton();
		commodityManagementPage.clickAddMultiBtn();
		//循环新建21个商品型号规格
		for(int i=1; i<20;i++){
		 commodityManagementPage.clickCustomCommodityModel();
		 commodityManagementPage.typeCustomCommodityModel("多级型号测试"+i);	
		 commodityManagementPage.clickCreateCustom();	

		 Thread.sleep(2000);
		 
		}
	
	}
	
	
}
