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
//spc-103


public class HistoryDataAfterDelTest extends UITest{
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
	 * 添加商品自定义商品型号删除后历史数据  spc-101 (Testlink需更新)
	 * @throws Exception
	 */
	@Test(groups = "historyDataAfterDelTest")
	public void historyDataAfterDel() throws Exception {
		Thread.sleep(2000);
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
	
		//添加商品A
		commodityManagementPage.clickAddCommodityButton();
		commodityManagementPage.addPicture();
		
		 commodityManagementPage.typeCommodityDescription("商品A");
		commodityManagementPage.clickAddMultiBtn();
		if(!commodityManagementPage.isYuanchandi()){	
			
		 commodityManagementPage.typeCustomCommodityModel("原产地");	
		 commodityManagementPage.clickCreateCustom();		
		 }
		//勾选多级商品型号“原产地”，“颜色”
		commodityManagementPage.clickMultiColorBtn(); 
		Thread.sleep(1000);

		 commodityManagementPage.clickMultiYuanchandiBtn();	
		 Thread.sleep(1000);
		 commodityManagementPage.clickMultiConfirmBtn();		
		 Thread.sleep(3000);
		
		//为商品型号“原产地”添加多个属性：中国一二三四五六七八，美国，法国
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
		//从上至下依次填写价格，库存，商品编码
			commodityManagementPage.typePriceSku1("111");
			commodityManagementPage.typePriceSku2("222");	
			commodityManagementPage.typePriceSku3("333");
			commodityManagementPage.typePriceSku4("444");
			
			commodityManagementPage.typeStockSku1("11");
			commodityManagementPage.typeStockSku2("22");
			commodityManagementPage.typeStockSku3("33");
			commodityManagementPage.typeStockSku4("44");
			
			commodityManagementPage.typeCodeSku1("code1");
			commodityManagementPage.typeCodeSku2("code2");
			commodityManagementPage.typeCodeSku3("code3");	
			commodityManagementPage.typeCodeSku4("code4");	
			
			 Thread.sleep(2000);	
		 //点击提交按钮
		 commodityManagementPage.clickSubmitButton();
		    Thread.sleep(6000);
		
		  //添加商品B
		    CommodityManagementAction.intoCommodityManagementPage();
			commodityManagementPage.clickAddCommodityButton();
			commodityManagementPage.addPicture();
			
			commodityManagementPage.typeCommodityDescription("商品B");
			commodityManagementPage.clickAddMultiBtn();
			if(!commodityManagementPage.isYuanchandi()){	
				
			 commodityManagementPage.typeCustomCommodityModel("原产地");	
			 commodityManagementPage.clickCreateCustom();		
			 }
			//勾选多级商品型号“原产地”，“颜色”
			commodityManagementPage.clickMultiColorBtn(); 
			Thread.sleep(1000);

			 commodityManagementPage.clickMultiYuanchandiBtn();	
			 Thread.sleep(1000);
			 commodityManagementPage.clickMultiConfirmBtn();		
			 Thread.sleep(3000);
			
			//为商品型号“原产地”添加多个属性：中国一二三四五六七八，美国，法国
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
			//从上至下依次填写价格，库存，商品编码
				commodityManagementPage.typePriceSku1("111");
				commodityManagementPage.typePriceSku2("222");	
				commodityManagementPage.typePriceSku3("333");
				commodityManagementPage.typePriceSku4("444");
				
				commodityManagementPage.typeStockSku1("11");
				commodityManagementPage.typeStockSku2("22");
				commodityManagementPage.typeStockSku3("33");
				commodityManagementPage.typeStockSku4("44");
				
				commodityManagementPage.typeCodeSku1("code1");
				commodityManagementPage.typeCodeSku2("code2");
				commodityManagementPage.typeCodeSku3("code3");	
				commodityManagementPage.typeCodeSku4("code4");	
				
				 Thread.sleep(2000);	
			 //点击提交按钮
			 commodityManagementPage.clickSubmitButton();
			    Thread.sleep(4000);
		
			    //添加商品C
			    CommodityManagementAction.intoCommodityManagementPage();
				commodityManagementPage.clickAddCommodityButton();
				commodityManagementPage.addPicture();
				
				commodityManagementPage.typeCommodityDescription("商品C");
				commodityManagementPage.clickAddMultiBtn();	
				Thread.sleep(2000);	
				 commodityManagementPage.clickMultiYuanchandiBtn();	
				Thread.sleep(3000);
				commodityManagementPage.clickMouseHoverDelBtn();	
				Thread.sleep(3000);
				commodityManagementPage.clickMouseHoverDelConfirmBtn();			 
				Thread.sleep(3000);
				//勾选多级商品型号“原产地”，“颜色”
				commodityManagementPage.clickMultiColorBtn(); 
				//点击多选择商品型号的“确定”按钮
//				commodityManagementPage.clickMultiConfirmBtn();	
				commodityManagementPage.clickCloseMulBtn();				
				//进入商品管理页面
			    CommodityManagementAction.intoCommodityManagementPage();
			    //验证之前的商品中仍存在已删除的“原产地”属性
			    Assert.assertTrue(commodityManagementPage.existhistoryPro1());
			    
			    //添加商品D，验证备选型号中无“原产地”
			    CommodityManagementAction.intoCommodityManagementPage();
				commodityManagementPage.clickAddCommodityButton();
				commodityManagementPage.addPicture();
				
				commodityManagementPage.typeCommodityDescription("商品D");
				commodityManagementPage.clickAddMultiBtn();	
			//	Assert.assertEquals(commodityManagementPage.getMessageText(), "请完整填写第1个型号");
			    Thread.sleep(6000);
				Assert.assertNotEquals(commodityManagementPage.getMulText(), "原产地");
			    

	
	}
	
	
	
	
	
	
	
	

}
