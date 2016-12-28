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
//spc-96  spc-97 spc-98
public class PropertyOfCommodityModelTest extends UITest{
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
	 * 添加多级商品型号的下级属性然后鼠标点击删除 spc-97  本组包含spc-96 spc-98 (Testlink需更新)
	 * @throws Exception
	 */
	@Test(groups = "propertyOfCommodityModelTest")
	public void delPropertyOfCommodityModel() throws Exception {
		Thread.sleep(2000);
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickAddCommodityButton();
		commodityManagementPage.clickAddMultiBtn();
//		System.out.print(commodityManagementPage.isYuanchandi()+"11111111111");
		if(!commodityManagementPage.isYuanchandi()){	
	 //  Assert.assertTrue(commodityManagementPage.isYuanchandi());		
		//添加多级商品型号“原产地”
	//	 commodityManagementPage.clickCustomCommodityModel();
			
	//	System.out.print(commodityManagementPage.isYuanchandi()+"2222222222222");
		 commodityManagementPage.typeCustomCommodityModel("原产地");	
		 commodityManagementPage.clickCreateCustom();		
		 }
		
		
		 commodityManagementPage.clickMultiYuanchandiBtn();	
		Thread.sleep(1000);
		commodityManagementPage.clickMultiConfirmBtn();		
		Thread.sleep(3000);
		if(!commodityManagementPage.isZhongguo()){
		
		//为商品型号“原产地”添加属性：中国
		 commodityManagementPage.clickProCustomCommodityModel();
		Thread.sleep(1000);
		 commodityManagementPage.typeCreateProCustom("中国一二三四五六七八九十一二三四五六七八");
		Thread.sleep(2000);
		 commodityManagementPage.clickCreateProCustom();	
		Thread.sleep(1000);
		}
		//鼠标事件删除该属性
		 commodityManagementPage.clickZhongguoPro();	
		Thread.sleep(1000);
		 commodityManagementPage.clickPromouseHoverDel();	
		Thread.sleep(2000);
		 commodityManagementPage.clickMouseHoverDelConfirmBtn();			 
		Thread.sleep(2000);
		
	
	}
	
	/**
	 * 添加多级商品型号的下级属性 spc-96 本组包含spc-97 98 (Testlink需更新)
	 * @throws Exception
	 */
	@Test(groups = "propertyOfCommodityModelTest")
	public void addPropertyOfCommodityModel() throws Exception {
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
		//勾选多级商品型号“原产地”	
		 commodityManagementPage.clickMultiYuanchandiBtn();	
		Thread.sleep(1000);
		commodityManagementPage.clickMultiConfirmBtn();		
		Thread.sleep(3000);
		
		
		//为商品型号“原产地”添加多个属性：中国一二三四五六七八，美国，法国
		if(!commodityManagementPage.isZhongguo())
	{
		commodityManagementPage.clickProCustomCommodityModel();
		Thread.sleep(1000);
		 commodityManagementPage.typeCreateProCustom("中国一二三四五六七八九十一二三四五六七八");
		Thread.sleep(2000);
		 commodityManagementPage.clickCreateProCustom();	
		Thread.sleep(1000);}
			
		if(!commodityManagementPage.isMeiguo())
			{
		 commodityManagementPage.clickProCustomCommodityModel();
		Thread.sleep(1000);
		 commodityManagementPage.typeCreateProCustom("美国");	
		Thread.sleep(2000);
		 commodityManagementPage.clickCreateProCustom();	
		Thread.sleep(1000);
			}
		
		if(!commodityManagementPage.isFaguo())
			{
		 commodityManagementPage.clickProCustomCommodityModel();
		Thread.sleep(1000);
		 commodityManagementPage.typeCreateProCustom("法国");
		Thread.sleep(2000);
		 commodityManagementPage.clickCreateProCustom();	
		Thread.sleep(1000);}
		//验证从左到右的顺序
	    //System.out.print(commodityManagementPage.getFirstBtn()+"11111111111111111");
		Assert.assertTrue(commodityManagementPage.isFaguo(), "法国");
		Thread.sleep(1000);
		Assert.assertTrue(commodityManagementPage.isMeiguo(), "美国");
		Thread.sleep(1000);
		Assert.assertTrue(commodityManagementPage.isZhongguo(), "中国一二三四五六七八九十一二三四五六七八");
		Thread.sleep(1000);


		//	Assert.assertEquals(commodityManagementPage.getSecondPro(), "美国");
			//Assert.assertEquals(commodityManagementPage.getThirdPro(), "中国");
			Thread.sleep(1000);
		}
			
	/**
	 * 验证添加多级商品属性的字数限制 spc-98 本组包含spc-96 97 (Testlink需更新)
	 * @throws Exception
	 */
	@Test(groups = "propertyOfCommodityModelTest")
	public void verifyPropertyLimitOfCommodityModel() throws Exception {
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
		//勾选多级商品型号“原产地”	
		 commodityManagementPage.clickMultiYuanchandiBtn();	
		Thread.sleep(1000);
		commodityManagementPage.clickMultiConfirmBtn();		
		Thread.sleep(3000);
		
		
		//为商品型号“原产地”添加字数超过限制的属性
	
		commodityManagementPage.clickProCustomCommodityModel();
		Thread.sleep(1000);
		 commodityManagementPage.typeCreateProCustom("中国一二三四五六七八九十一二三四五六七八九十");
		Thread.sleep(2000);
		 commodityManagementPage.clickCreateProCustom();	
		Thread.sleep(1000);
		Assert.assertTrue(commodityManagementPage.isZhongguo(), "中国一二三四五六七八九十一二三四五六七八");
		}
	
	
	
	
	}


