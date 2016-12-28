package com.wd.web.tests;


import com.wd.web.action.CommodityManagementAction;
import com.wd.libarary.TestNGListener;
import com.wd.libarary.UITest;
import com.wd.web.page.CommodityManagementPage;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ TestNGListener.class })
public class SmokingTestCommodityManagement extends UITest {
	
	/**
	 * 添加商品功能正常
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void addCommodityTest() throws Exception {
		Thread.sleep(2000);
		CommodityManagementAction.addCommodity("[请注意]这是一个测试商品","78.44","130","33333333");
	}
	
	/**
	 * 添加SKU商品功能正常
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void addSKUCommodityTest() throws Exception {
		Thread.sleep(2000);
		CommodityManagementAction.addSKUCommodity("[请注意]这是一个测试商品","78.44","130");
	}
	
	/**
	 * 商品管理页全部按钮商品展现正常
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void allBtnshow() throws Exception {
	    CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
	    commodityManagementPage.clickAllBtn();
	    Assert.assertTrue(commodityManagementPage.isEditBtn());
	}
	
	/**
	 * 批量改价功能正常
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void batchChangepriceTest() throws Exception {
		Thread.sleep(2000);
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickItemCheckBox();
		commodityManagementPage.clickbatchChangepriceBtn();
		commodityManagementPage.typePriceBtn("22.00");
		commodityManagementPage.clicksureBtn();
		Thread.sleep(500);
		Assert.assertEquals(commodityManagementPage.getOffItemAlert(), "批量改价成功");
	}
	
	/**
	 * 批量分类功能正常
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void batchClassTest() throws Exception {
		Thread.sleep(2000);
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		Thread.sleep(1000);
		if(!commodityManagementPage.ischecked()){
			commodityManagementPage.clickItemCheckBox();
		}
		commodityManagementPage.clickbatchClassBtn();
		Thread.sleep(1000);
		commodityManagementPage.clickClassification();
		commodityManagementPage.clicksureBtn();
		Thread.sleep(500);
		Assert.assertEquals(commodityManagementPage.getOffItemAlert(), "分类成功");
	}
	
	/**
	 * 批量删除功能正常
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void batchDeleteTest() throws Exception {
		Thread.sleep(2000);
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickOnSaleBtn();
		Thread.sleep(1000);
		if(!commodityManagementPage.ischecked()){
			if(!commodityManagementPage.getSalesvolume().equals("0")){
				commodityManagementPage.clickSalesVolumeBtn();
				Thread.sleep(600);
				commodityManagementPage.clickItemCheckBox();
			}else{
				commodityManagementPage.clickItemCheckBox();
			}
		}else{
			if(!commodityManagementPage.getSalesvolume().equals("0")){
				commodityManagementPage.clickItemCheckBox();
				Thread.sleep(600);
				commodityManagementPage.clickSalesVolumeBtn();
				Thread.sleep(600);
				commodityManagementPage.clickItemCheckBox();
			}else{
			}
		}
		commodityManagementPage.clickbatchDelete();
		commodityManagementPage.clickOkBtn();
		Thread.sleep(500);
		Assert.assertEquals(commodityManagementPage.getOffItemAlert(), "删除成功");
	}
	
	/**
	 * 批量下架功能正常
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void batchOffTheShelfTest() throws Exception {
		Thread.sleep(2000);
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickOnSaleBtn();
		Thread.sleep(1000);
		if(!commodityManagementPage.ischecked()){
			commodityManagementPage.clickItemCheckBox();
		}
		commodityManagementPage.clickBatchOffShelves();
		Thread.sleep(1000);
		commodityManagementPage.clickOkBtn();
		Assert.assertEquals(commodityManagementPage.getOffItemAlert(), "下架成功");
	}
	
	/**
	 * 批量上架功能正常
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void batchshelvesTest() throws Exception {
		Thread.sleep(2000);
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickOffShelvesBtn();
		Thread.sleep(1000);
		if(!commodityManagementPage.ischecked()){
			commodityManagementPage.clickItemCheckBox();
		}
		commodityManagementPage.clickbatchShelvesBtn();
		Thread.sleep(1000);
		commodityManagementPage.clickOkBtn();
		Thread.sleep(500);
		Assert.assertEquals(commodityManagementPage.getOffItemAlert(), "上架成功");
	}
	
	/**
	 * 点击编辑按钮，弹出进入编辑商品页
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void clickEditBtnTest() throws Exception {
		Thread.sleep(2000);
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		Thread.sleep(1000);
		commodityManagementPage.clickEditBtn();
		Thread.sleep(1000);
		CommodityManagementAction.switchToWindowUseHandle();
		commodityManagementPage.typeCommodityDescription("3456675454");
		commodityManagementPage.clickSubmitButton();
		Thread.sleep(1000);
		Assert.assertEquals(commodityManagementPage.getMessageText(),"商品更新成功");
		CommodityManagementAction.closeWindowBlack();
	}
	
	/**
	 * 上架时间按钮功能正常
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void clickOnShelvesTimeBtnTest() throws Exception {
		Thread.sleep(2000);
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickAllBtn();
		Thread.sleep(1000);
		commodityManagementPage.clickStocksBtn();
		Thread.sleep(500);
		commodityManagementPage.clickStocksBtn();
		Thread.sleep(1000);
		String startUT = commodityManagementPage.getUpdateTime();
		commodityManagementPage.clickOnShelvesTimeBtn();
		Thread.sleep(1000);
		String endUT = commodityManagementPage.getUpdateTime();
		System.out.println("start1= "+startUT);
		System.out.println("end1= "+endUT);
		Assert.assertNotEquals(startUT, endUT);
	}
	
	/**
	 * 销量按钮功能正常
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void clickSalesVolumeBtnTest() throws Exception {
		Thread.sleep(2000);
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		Thread.sleep(1000);
		commodityManagementPage.clickAllBtn();
		Thread.sleep(1000);
		commodityManagementPage.clickSalesVolumeBtn();
		Thread.sleep(1000);
		String startUT = commodityManagementPage.getUpdateTime();
		commodityManagementPage.clickSalesVolumeBtn();
		Thread.sleep(1000);
		String endUT = commodityManagementPage.getUpdateTime();
		System.out.println("start2= "+startUT);
		System.out.println("end2= "+endUT);
		Assert.assertNotEquals(startUT, endUT);
	}
	
	/**
	 * 库存按钮功能正常
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void clickStocksBtnTest() throws Exception {
		Thread.sleep(2000);
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickAllBtn();
		Thread.sleep(1000);
		commodityManagementPage.clickStocksBtn();
		Thread.sleep(1000);
		String startUT = commodityManagementPage.getUpdateTime();
		commodityManagementPage.clickStocksBtn();
		Thread.sleep(1000);
		String endUT = commodityManagementPage.getUpdateTime();
		commodityManagementPage.clickSalesVolumeBtn();
		System.out.println("start2= "+startUT);
		System.out.println("end2= "+endUT);
		Assert.assertNotEquals(startUT, endUT);
	}
	
	/**
	 * 点击删除按钮，弹出删除商品的确认弹框，点击确定按钮后，商品被成功删除
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void deleteItemIsOkTest() throws Exception {
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickAllBtn();
		Thread.sleep(1000);
		if(commodityManagementPage.getSalesvolume().equals("0")){
			String startUT = commodityManagementPage.getUpdateTime();
			commodityManagementPage.clickDeleteItemBtn();
			commodityManagementPage.clickOkBtn();
			Thread.sleep(2000);
			String endUT = commodityManagementPage.getUpdateTime();
			Assert.assertNotEquals(startUT, endUT);
		}else{
			commodityManagementPage.clickSalesVolumeBtn();
			Thread.sleep(1000);
			String startUT = commodityManagementPage.getUpdateTime();
			commodityManagementPage.clickDeleteItemBtn();
			commodityManagementPage.clickOkBtn();
			Thread.sleep(2000);
			String endUT = commodityManagementPage.getUpdateTime();
			Assert.assertNotEquals(startUT, endUT);
		}
	}
	
	/**
	 * 点击下架按钮，弹出下架商品的确认弹框，点击确定按钮后，商品被成功下架
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void offShelvesIsOkTest() throws Exception {
		Thread.sleep(1000);
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickOnSaleBtn();
		String startUT = commodityManagementPage.getUpdateTime();
		Thread.sleep(1000);
		commodityManagementPage.clickOffItemBtn();
		commodityManagementPage.clickOkBtn();
		Thread.sleep(2000);
		String endUT = commodityManagementPage.getUpdateTime();
		Assert.assertNotEquals(startUT, endUT);
	}
	
	/**
	 * 商品管理页已下架按钮商品展现正常
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void offShelvesshow() throws Exception {
	    CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
	    commodityManagementPage.clickOffShelvesBtn();
	    Assert.assertTrue(commodityManagementPage.isEditBtn());
	}
	
	/**
	 * 商品管理页出售中按钮商品展现正常
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void saleshow() throws Exception {
	    CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
	    commodityManagementPage.clickOnSaleBtn();
	    Assert.assertTrue(commodityManagementPage.isEditBtn());
	}
	
	/**
	 * 当搜索内容不存在时，不能搜索出内容
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void searchisnull() throws Exception {
	    CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
	    commodityManagementPage.typeSearchInput("123");
	    commodityManagementPage.clicksearchBtn();
	    Assert.assertTrue(commodityManagementPage.islistempty());
	    commodityManagementPage.clickLogo();
	    commodityManagementPage.clickCommodityManagementPageButton();
	}
	
	/**
	 * 当搜索内容存在时，可以正确搜索出内容
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void searchisok() throws Exception {
	    CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
	    commodityManagementPage.typeSearchInput("测试");
	    commodityManagementPage.clicksearchBtn();
	    Assert.assertFalse(commodityManagementPage.islistempty());
	    commodityManagementPage.clickLogo();
	    commodityManagementPage.clickCommodityManagementPageButton();
	}
	
	/**
	 * 商品管理页已售完按钮商品展现正常
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void soldOutshow() throws Exception {
	    CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
	    commodityManagementPage.clickSoldOutBtn();
	    Thread.sleep(500);
	    Assert.assertTrue(commodityManagementPage.isEditBtn());
	}
}