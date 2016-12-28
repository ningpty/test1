package com.wd.web.tests;


import com.wd.web.action.CommodityManagementAction;
import com.wd.libarary.DriverFactory;
import com.wd.libarary.TestNGListener;
import com.wd.libarary.UITest;
import com.wd.web.page.CommodityManagementPage;

import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ TestNGListener.class })
public class CommodityManagementAddTest extends UITest {
	
	/**
	 * 验证在添加商品时，没有上传商品图片，点击提交，系统应给出正确提示
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void addCommodityLackOfPictures() throws Exception {
		Thread.sleep(6000);
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickAddCommodityButton();
		commodityManagementPage.clickSubmitButton();
		Assert.assertEquals(commodityManagementPage.getMessageText(), "请至少上传一张商品图片");
	}
	
	/**
	 * 验证在添加商品时，没输入商品描述，点击提交，系统应给出正确提示
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void addCommodityLackOfCommodityDescription() throws Exception {
		Thread.sleep(6000);
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickAddCommodityButton();
		commodityManagementPage.addPicture();
		commodityManagementPage.clickSubmitButton();
		Assert.assertEquals(commodityManagementPage.getMessageText(), "请填写商品描述");
		
	}
	
	/**
	 * 验证在添加商品时，没输入商品价格，点击提交，系统应给出正确提示
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void addCommodityLackOfCommodityPrice() throws Exception {
		Thread.sleep(6000);
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickAddCommodityButton();
		commodityManagementPage.addPicture();
		commodityManagementPage.typeCommodityDescription("这是一个吃的东西");
		commodityManagementPage.clickSubmitButton();
		Thread.sleep(500);
		Assert.assertEquals(commodityManagementPage.getMessageText(), "请填写商品价钱");
		
	}
	
	/**
	 * 验证在添加商品时，没输入商品库存，点击提交，系统应给出正确提示
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void addCommodityLackOfCommodityStock() throws Exception {
		Thread.sleep(6000);
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickAddCommodityButton();
		commodityManagementPage.addPicture();
		commodityManagementPage.typeCommodityDescription("这是一个测试商品");
		commodityManagementPage.typeCommoditPrice("234.02");
		commodityManagementPage.clickSubmitButton();
		Thread.sleep(500);
		Assert.assertEquals(commodityManagementPage.getMessageText(), "请填写商品库存");
	}
	
	/**
	 * 验证在添加商品，是否可以添加成功
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void addCommodityTest() throws Exception {
		Thread.sleep(6000);
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickAddCommodityButton();
		commodityManagementPage.addPicture();
		CommodityManagementAction.addCommodity("[请注意]这是一个测试商品","100","999","1212112");
	}
	

}
