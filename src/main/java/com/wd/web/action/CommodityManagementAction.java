package com.wd.web.action;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.wd.libarary.PageFactory;
//import org.openqa.selenium.support.PageFactory;

import com.wd.web.page.CommodityManagementPage;
import com.wd.libarary.ChangeWindow;

public class CommodityManagementAction {
	private static WebDriver driver;
	
	
	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		CommodityManagementAction.driver = driver;
	}
	
	static CommodityManagementPage commodityManagementPage;
	
	
	/**
	 * 进入商品管理页面
	 * @return 
	 * @throws Exception
	 */
	public static CommodityManagementPage intoCommodityManagementPage() throws Exception {
		commodityManagementPage = new CommodityManagementPage(getDriver());
		commodityManagementPage.clickCommodityManagementPageButton();
		Assert.assertTrue(commodityManagementPage.isCommodityManagement(), "into CommodityManagementPage failed");
		return (CommodityManagementPage) PageFactory.getPage(CommodityManagementPage.class, getDriver());
	}
	
	/**
	 * 添加商品
	 * @return 
	 * @throws Exception
	 */
	public static CommodityManagementPage addCommodity(String description,String price,String stock,String code) throws Exception {
		commodityManagementPage = new CommodityManagementPage(getDriver());
		commodityManagementPage.clickCommodityManagementPageButton();
		commodityManagementPage.clickAddCommodityButton();
		commodityManagementPage.addPicture();
		commodityManagementPage.typeCommodityDescription(description);
		commodityManagementPage.typeCommoditPrice(price);
		commodityManagementPage.typeCommodityStock(stock);
		commodityManagementPage.typeCommodityCode(code);
		commodityManagementPage.clickShopownerRecommend();
		commodityManagementPage.clickFreeDelivery();
		commodityManagementPage.clickRemoteFreeDelivery();
		commodityManagementPage.clickIsCustoms();
		commodityManagementPage.clickAreaLimit();
		commodityManagementPage.clickFirstTemplate();
		commodityManagementPage.clickSubmitButton();
		Assert.assertEquals(commodityManagementPage.getMessageText(), "商品发布成功");
		Thread.sleep(6000);
		commodityManagementPage.clickCommodityManagementPageButton();
		Assert.assertTrue(commodityManagementPage.isCommodity(), "add commodity failed");
		return (CommodityManagementPage) PageFactory.getPage(CommodityManagementPage.class, getDriver());
	}
	
	/**
	 * 添加商品
	 * @return 
	 * @throws Exception
	 */
	public static CommodityManagementPage addSKUCommodity(String description,String price,String stock) throws Exception {
		commodityManagementPage = new CommodityManagementPage(getDriver());
		commodityManagementPage.clickCommodityManagementPageButton();
		commodityManagementPage.clickAddCommodityButton();
		commodityManagementPage.addPicture();
		commodityManagementPage.typeCommodityDescription(description);
		commodityManagementPage.clickAddMultiBtn();
		commodityManagementPage.clickMultiColorBtn();
		commodityManagementPage.clickMultiSizeBtn();
		commodityManagementPage.clickMultiConfirmBtn();
		commodityManagementPage.clickblueBtn();
		commodityManagementPage.clickyellowBtn();
		commodityManagementPage.clickSBtn();
		commodityManagementPage.clickXLBtn();
		commodityManagementPage.typeBatchPrice(price);
		commodityManagementPage.typeBatchStock(stock);
		commodityManagementPage.clickShopownerRecommend();
		commodityManagementPage.clickFreeDelivery();
		commodityManagementPage.clickRemoteFreeDelivery();
		commodityManagementPage.clickIsCustoms();
		commodityManagementPage.clickAreaLimit();
		commodityManagementPage.clickFirstTemplate();
		commodityManagementPage.clickSubmitButton();
		Assert.assertEquals(commodityManagementPage.getMessageText(), "商品发布成功");
		Thread.sleep(6000);
		commodityManagementPage.clickCommodityManagementPageButton();
		Thread.sleep(3000);
		Assert.assertTrue(commodityManagementPage.isCommodity(), "add commodity failed");
		return (CommodityManagementPage) PageFactory.getPage(CommodityManagementPage.class, getDriver());
	}
	
	/**
	 * 使用title切换窗口
	 * @return
	 * @throws Exception
	 */
	public static CommodityManagementPage switchToWindowUseTitle(String title) throws Exception {
//		ChangeWindow.switchWindow(getDriver());
		ChangeWindow.switchToWindowUseTitle(getDriver(),title);
		return (CommodityManagementPage) PageFactory.getPage(CommodityManagementPage.class, getDriver());
	}
	
	/**
	 * 使用窗口句柄切换窗口
	 * @return
	 * @throws Exception
	 */
	public static CommodityManagementPage switchToWindowUseHandle() throws Exception {
		ChangeWindow.switchToWindowUseHandle(getDriver());
		return (CommodityManagementPage) PageFactory.getPage(CommodityManagementPage.class, getDriver());
	}
	
	/**
	 * 关闭窗口页面
	 * @return
	 * @throws Exception
	 */
	public static CommodityManagementPage closeWindowBlack() throws Exception {
		ChangeWindow.closeWindowBlack(getDriver());
		return (CommodityManagementPage) PageFactory.getPage(CommodityManagementPage.class, getDriver());
	}

	
}
