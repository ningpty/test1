package com.wd.web.tests;



import com.wd.web.action.CommodityManagementAction;
import com.wd.libarary.TestNGListener;
import com.wd.libarary.UITest;
import com.wd.libarary.StringTools;
import com.wd.web.page.CommodityManagementPage;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ TestNGListener.class })
public class CommodityManagementFunctionButtonTest extends UITest {
	
	
	/**
	 * 点击批量删除按钮，弹出删除商品的确认弹框，点击确定按钮后，商品被成功删除
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void batchDeleteIsOkTest() throws Exception {
		CommodityManagementAction.addCommodity("[请注意]这是一个测试商品","78.44","130","33333333");
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickOnSaleBtn();
		Thread.sleep(1000);
		commodityManagementPage.clickItemCheckBox();
		String startUT = commodityManagementPage.getUpdateTime();
		commodityManagementPage.clickbatchDelete();
		commodityManagementPage.clickOkBtn();
		Thread.sleep(2000);
		String endUT = commodityManagementPage.getUpdateTime();
		Assert.assertNotEquals(startUT, endUT);
	}
	
	/**
	 * 点击批量下架按钮，弹出下架商品的确认弹框，点击确定按钮后，商品被成功下架
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void batchOffShelvesIsOkTest() throws Exception {
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		Thread.sleep(2000);
		String startUT = commodityManagementPage.getUpdateTime();
		commodityManagementPage.clickItemCheckBox();
		Thread.sleep(1000);
		commodityManagementPage.clickBatchOffShelves();
		Thread.sleep(1000);
		commodityManagementPage.clickOkBtn();
		Thread.sleep(2000);
		String endUT = commodityManagementPage.getUpdateTime();
		Assert.assertNotEquals(startUT, endUT);
	}

	/**
	 * 选择商品后，点击批量删除按钮，弹出删除商品的确认弹框
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void clickBatchDeleteBtnAlertTest() throws Exception {
		Thread.sleep(2000);
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickItemCheckBox();
		commodityManagementPage.clickbatchDelete();
		Thread.sleep(1000);
		String sb = commodityManagementPage.getOffItemAlert();//待判断的字符串
		sb = StringTools.replaceBlank(sb);
		String reg=".*批量删除后不能恢复.*";
		commodityManagementPage.clickCancelBtn();
		Assert.assertTrue(sb.matches(reg));
	}
	
	/**
	 * 选择商品后，点击批量下架按钮，系统弹出提示框
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void clickBatchOffShelvesAlertTest() throws Exception {
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		if(!commodityManagementPage.ischecked()){
			commodityManagementPage.clickItemCheckBox();
		}
		commodityManagementPage.clickBatchOffShelves();
		Thread.sleep(500);
		String sb = commodityManagementPage.getOffItemAlert();//待判断的字符串
		sb = StringTools.replaceBlank(sb);
		String reg=".*确认下架.*";  //判断字符串中是否含有:确认下架
		commodityManagementPage.clickCancelBtn();
		Assert.assertTrue(sb.matches(reg));
	}
	
	/**
	 * 点击删除按钮，弹出删除商品的确认弹框
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void clickDeleteItemBtnAlertTest() throws Exception {
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickOnSaleBtn();
		commodityManagementPage.clickDeleteItemBtn();
		Thread.sleep(500);
		String sb = commodityManagementPage.getOffItemAlert();//待判断的字符串
		sb = StringTools.replaceBlank(sb);
		String reg=".*删除此商品.*";
		commodityManagementPage.clickCancelBtn();
		Assert.assertTrue(sb.matches(reg));
	}
	
	/**
	 * 点击编辑按钮，弹出进入编辑商品页
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void clickEditBtnTest() throws Exception {
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickEditBtn();
		CommodityManagementAction.switchToWindowUseHandle();
		Assert.assertTrue(commodityManagementPage.isSubmit());
		CommodityManagementAction.closeWindowBlack();
	}
	
	/**
	 * 点击下架按钮，弹出下架商品的确认弹框
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void clickOffShelvesAlertTest() throws Exception {
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickOnSaleBtn();
		commodityManagementPage.clickOffItemBtn();
		Thread.sleep(500);
		String sb = commodityManagementPage.getOffItemAlert();//待判断的字符串
		sb = StringTools.replaceBlank(sb);
		String reg=".*确认下架.*";  //判断字符串中是否含有:确认下架
		commodityManagementPage.clickCancelBtn();
		Assert.assertTrue(sb.matches(reg));
	}
	
	/**
	 * 已下架功能正常
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void clickOffShelvesBtnTest() throws Exception {
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickAllBtn();
		Thread.sleep(1000);
		commodityManagementPage.clickOnSaleBtn();
		Thread.sleep(1000);
		String startUT = commodityManagementPage.getUpdateTime();
		commodityManagementPage.clickOffShelvesBtn();
		Thread.sleep(1000);
		String endUT = commodityManagementPage.getUpdateTime();
		Assert.assertNotEquals(startUT, endUT);
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
	 * 库存按钮功能正常
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void clickSalesVolumeBtnTest() throws Exception {
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
		System.out.println("start2= "+startUT);
		System.out.println("end2= "+endUT);
		Assert.assertNotEquals(startUT, endUT);
	}
	
	/**
	 * 已售完功能正常
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void clickSoldOutBtnTest() throws Exception {
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickSoldOutBtn();
		Thread.sleep(500);
	    Assert.assertTrue(commodityManagementPage.isEditBtn());
	}
	
	/**
	 * 库存按钮功能正常
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void clickStocksBtnTest() throws Exception {
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		commodityManagementPage.clickAllBtn();
		Thread.sleep(1000);
		commodityManagementPage.clickStocksBtn();
		Thread.sleep(500);
		String startUT = commodityManagementPage.getUpdateTime();
		commodityManagementPage.clickStocksBtn();
		Thread.sleep(500);
		String endUT = commodityManagementPage.getUpdateTime();
		commodityManagementPage.clickSalesVolumeBtn();
		Thread.sleep(1000);
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


}
