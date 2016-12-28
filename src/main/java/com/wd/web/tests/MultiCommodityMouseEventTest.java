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
//spc-94
public class MultiCommodityMouseEventTest extends UITest{
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
	 * 验证多级商品自定义型号的鼠标事件 spc-94  (Testlink需更新) 
	 * @throws Exception
	 */
	@Test(groups = "multiCommodityMouseEventTest")
	public void multiCommodityMouseEvent() throws Exception {
		Thread.sleep(2000);
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickAddCommodityButton();
		commodityManagementPage.clickAddMultiBtn();
		
		 commodityManagementPage.clickCustomCommodityModel();
		 commodityManagementPage.typeCustomCommodityModel("原产地");	
		 commodityManagementPage.clickCreateCustom();		
		Thread.sleep(3000);
		 commodityManagementPage.clickMultiYuanchandiBtn();	
		Thread.sleep(3000);
		 commodityManagementPage.clickMouseHoverDelBtn();	
		Thread.sleep(3000);
		 commodityManagementPage.clickMouseHoverDelConfirmBtn();			 
		Thread.sleep(3000);
	//	System.out.println(commodityManagementPage.getMessageText()+"111111111222222223333333333");		
   //		 commodityManagementPage.clickMultiConfirmBtn();
   //	Assert.assertNotSame(commodityManagementPage.getMessageText(),"原产地");

  //existYuanchandi
		
	}

	
	
}
