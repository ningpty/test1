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

//spc-102 spc-103 spc-106  spc-107  spc-108
public class MulSkuCommodityManagementTest extends UITest{
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
	 * 验证商品列表展示，正确展示所商品型号依次为“尺码”“颜色” spc-102
	 * @throws Exception
	 */
	@Test(groups = "mulSkuCommodityManagementTest")
	public void displayMulSkuCommodityManagement() throws Exception {
		Thread.sleep(3000);
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickAddCommodityButton();
		commodityManagementPage.addPicture();

		 commodityManagementPage.typeCommodityDescription("添加的商品描述测试");
		//添加第一个一级商品型号
		 commodityManagementPage.clickAddCommodityModel();		 
		 commodityManagementPage.addFirstModelPicture();
		 
		 commodityManagementPage.clickCommodityModelModel();
		 commodityManagementPage.typecommodityModelModel("原产地");
		 
		 commodityManagementPage.clickCommodityModelCode();
		 commodityManagementPage.typecommodityModelCode("测试商品型号的编码输入框111");
		 
		 commodityManagementPage.clickCommodityModelPrice();
		 commodityManagementPage.typecommodityModelPrice("111");
		 
		 commodityManagementPage.clickCommodityModelStock();
		 commodityManagementPage.typecommodityModelStock("111");	 
		 Thread.sleep(2000);
	
		 //添加第二个一级商品型号
         commodityManagementPage.clickAddCommodityModel();
		 commodityManagementPage.addSecondModelPicture();
		 
		 commodityManagementPage.clickCommodityModelModelSecond();
		 commodityManagementPage.typecommodityModelModelSecond("尺码");
		 
		 commodityManagementPage.clickCommodityModelCodeSecond();
		 commodityManagementPage.typecommodityModelCodeSecond("测试商品型号的编码输入框222");
		 
		 commodityManagementPage.clickCommodityModelPriceSecond();
		 commodityManagementPage.typecommodityModelPriceSecond("222");
		 
		 commodityManagementPage.clickCommodityModelStockSecond();
		 commodityManagementPage.typecommodityModelStockSecond("222");	 
		 Thread.sleep(2000);
		 
		//添加第三更一级商品型号 
         commodityManagementPage.clickAddCommodityModel();
		 commodityManagementPage.addThirdModelPicture();
		 
		 commodityManagementPage.clickCommodityModelModelThird();
		 commodityManagementPage.typecommodityModelModelThird("颜色");
		 
		 commodityManagementPage.clickCommodityModelCodeThird();
		 commodityManagementPage.typecommodityModelCodeThird("测试商品型号的编码输入框333");
		 
		 commodityManagementPage.clickCommodityModelPriceThird();
		 commodityManagementPage.typecommodityModelPriceThird("333");
		 
		 commodityManagementPage.clickCommodityModelStockThird();
		 commodityManagementPage.typecommodityModelStockThird("333");	 
		 Thread.sleep(2000);
		
		 //点击提交按钮
		 commodityManagementPage.clickSubmitButton();
		Assert.assertEquals(commodityManagementPage.getMessageText(), "商品发布成功");		
		 Thread.sleep(2000);
		//点击左侧商品管理
	    commodityManagementPage.clickCommodityManagementPageButton();
	    Thread.sleep(2000);
	    //点击“共3个型号，点击展开”
	    commodityManagementPage.clickExpandButton();
	    Thread.sleep(2000);   
	    
	    //验证商品管理页点击展开后是否为“原产地”“尺码”“颜色”
	    Assert.assertTrue(commodityManagementPage.isExpandYuanchandi(), "原产地");
	    Assert.assertTrue(commodityManagementPage.isExpandChima(), "尺码");
	    Assert.assertTrue(commodityManagementPage.isExpandYanse(), "颜色");
		
	}
	
	/**
	 * 验证添加商品自定义多级型号保存成功后，老入口消失 spc-103
	 * @throws Exception
	 */
	@Test(groups = "mulSkuCommodityManagementTest")
	public void disappearOfOldEntrance() throws Exception {
		Thread.sleep(2000);
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickAddCommodityButton();
		 Thread.sleep(6000);
		//验证“添加商品型号”按钮存在
		Assert.assertTrue(commodityManagementPage.isAddCommodityModel());
		//点击添加“多级型号按钮”
		commodityManagementPage.clickAddMultiBtn();
		//添加 “颜色” “尺寸” 的商品型号
	
			commodityManagementPage.clickMultiSizeBtn(); 
			Thread.sleep(1000);
			commodityManagementPage.clickMultiColorBtn(); 
			Thread.sleep(1000);
			commodityManagementPage.clickMultiConfirmBtn();		
			Thread.sleep(1000);

		Assert.assertTrue(commodityManagementPage.isUpdateMulBtn());
			
			 Thread.sleep(2000);	

	//	Assert.assertEquals(commodityManagementPage.getMessageText(), "商品发布成功");		
		

	    
	   

		
	}
	
	/**
	 * 验证多SKU商品总库存等于所有商品库存之和 spc-106
	 * @throws Exception
	 */
	@Test(groups = "mulSkuCommodityManagementTest")
	public void stockOfMulSkuCommodityManagement() throws Exception {
		Thread.sleep(2000);
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickAddCommodityButton();
		commodityManagementPage.addPicture();
		 commodityManagementPage.typeCommodityDescription("商品帽子");
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
		    Thread.sleep(2000);
	//	Assert.assertEquals(commodityManagementPage.getMessageText(), "商品发布成功");		
		
		//点击左侧商品管理
	    commodityManagementPage.clickCommodityManagementPageButton();
	    //点击“共4个型号，点击展开”
	    commodityManagementPage.clickExpandButton();

	    int sumstock=Integer.parseInt(commodityManagementPage.getsumStockText());
	    int stock1=Integer.parseInt(commodityManagementPage.getStock1Text());
	    int stock2=Integer.parseInt(commodityManagementPage.getStock2Text());
	    int stock3=Integer.parseInt(commodityManagementPage.getStock3Text());
	    int stock4=Integer.parseInt(commodityManagementPage.getStock4Text());
	    Assert.assertEquals(sumstock, stock1+stock2+stock3+stock4);
	    
	   

		
	}
	
	
	
	/**
	 * 验证多SKU商品总销量大于等于所有商品销量之和 spc-107
	 * @throws Exception
	 */
	@Test(groups = "mulSkuCommodityManagementTest")
	public void saleOfMulSkuCommodityManagement() throws Exception {
		Thread.sleep(2000);
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickAddCommodityButton();
		commodityManagementPage.addPicture();
		 commodityManagementPage.typeCommodityDescription("商品帽子");
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
		    Thread.sleep(2000);

		
		//点击左侧商品管理
	    commodityManagementPage.clickCommodityManagementPageButton();
	    
	    //点击“共4个型号，点击展开”
	    commodityManagementPage.clickExpandButton();

	    
	    int sumsale=Integer.parseInt(commodityManagementPage.getsumSaleText());
	    int sale1=Integer.parseInt(commodityManagementPage.getSale1Text());
	    int sale2=Integer.parseInt(commodityManagementPage.getSale2Text());
	    int sale3=Integer.parseInt(commodityManagementPage.getSale3Text());
	    int sale4=Integer.parseInt(commodityManagementPage.getSale4Text());
		Assert.assertTrue(commodityManagementPage.isBigger(sumsale,sale1+sale2+sale3+sale4));

	//    System.out.print( stock1+stock2+stock3+stock4+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");getsumSaleText
	    
//点击“共2个型号，点击展开”
 // commodityManagementPage.clickExpandButton();
//   Thread.sleep(2000);       
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
	
	/**
	 * 验证多SKU商品列表删除型号后销量展示   spc-108
	 * @throws Exception
	 */
	@Test(groups = "mulSkuCommodityManagementTest")
	public void stockAfterDeleOfMulSkuCommodityManagement() throws Exception {
		Thread.sleep(2000);
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickAddCommodityButton();
		commodityManagementPage.addPicture();
		 commodityManagementPage.typeCommodityDescription("商品帽子");
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
		    Thread.sleep(2000);
	//	Assert.assertEquals(commodityManagementPage.getMessageText(), "商品发布成功");		
		
		//点击左侧商品管理
	    commodityManagementPage.clickCommodityManagementPageButton();
	    //点击“共4个型号，点击展开”
	    commodityManagementPage.clickExpandButton();
	    //将销量字符串转为整型
	    int sumstock=Integer.parseInt(commodityManagementPage.getsumStockText());
	    int stock1=Integer.parseInt(commodityManagementPage.getStock1Text());
	    int stock2=Integer.parseInt(commodityManagementPage.getStock2Text());
	    int stock3=Integer.parseInt(commodityManagementPage.getStock3Text());
	    int stock4=Integer.parseInt(commodityManagementPage.getStock4Text());
	    Assert.assertEquals(sumstock, stock1+stock2+stock3+stock4);
	    //点击编辑商品按钮
		commodityManagementPage.clickEditOfCommodityManagementFirstBtn();	
	    Thread.sleep(3000);
	    //切换窗口，因为点击编辑按钮后会跳出新窗口
	    CommodityManagementAction.switchToWindowUseHandle();
		
	    // 点击多SKU属性的第一个属性按钮
		commodityManagementPage.clickFirstSkuProBtn();	
	    Thread.sleep(2000);
	    //点击多SKU属性的第一个属性删除小XX 
		commodityManagementPage.clickMouseHoverDelFirstBtn();	
		//Thread.sleep(2000);
		 commodityManagementPage.clickMouseHoverDelConfirmBtn();			 
		Thread.sleep(3000);
		//点击提交按钮
		 commodityManagementPage.clickSubmitButton();
		 Thread.sleep(2000);
		//关闭当前页面，返回原来页面
		 CommodityManagementAction.closeWindowBlack();
		//点击左侧商品管理
		 commodityManagementPage.clickCommodityManagementPageButton();
		 int sumstockAfter=Integer.parseInt(commodityManagementPage.getsumStockText());
		 Assert.assertEquals(sumstock, sumstockAfter);
	}
	
	
	
	
}
