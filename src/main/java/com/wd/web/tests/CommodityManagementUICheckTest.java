package com.wd.web.tests;


import com.wd.web.action.CommodityManagementAction;
import com.wd.libarary.TestNGListener;
import com.wd.libarary.UITest;
import com.wd.web.page.CommodityManagementPage;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ TestNGListener.class })
public class CommodityManagementUICheckTest extends UITest {

	
	/**
	 * 判断搜索按钮是否存在
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void isSearchBtnCheck() throws Exception {
		CommodityManagementAction.addCommodity("[请注意]这是一个测试商品","100","999","1212112");
	    CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		Assert.assertTrue(commodityManagementPage.isSearchBtn(), "商品管理页-搜索按钮不存在");
		
	}
	
	/**
	 * 判断搜索输入框是否存在
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void isSearchInputCheck() throws Exception {
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		Assert.assertTrue(commodityManagementPage.isSearchInput(), "商品管理页-搜索输入框不存在");
	}
	
	/**
	 * 判断添加商品按钮是否存在
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void isAddCommodityCheck() throws Exception {
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		Assert.assertTrue(commodityManagementPage.isAddCommodity(), "商品管理页-添加商品按钮不存在");
	}
	
	/**
	 * 判断筛选列表中全部按钮是否存在
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void isAllBtnCheck() throws Exception {
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		Assert.assertTrue(commodityManagementPage.isAllBtn(), "商品管理页-全选按钮不存在");
	}
	
	/**
	 * 判断筛选列表中出售中按钮是否存在
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void isOnSaleBtnCheck() throws Exception {
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		Assert.assertTrue(commodityManagementPage.isOnSaleBtn(), "商品管理页-出售中按钮不存在");
	}
	
	/**
	 * 判断筛选列表中已售完按钮是否存在
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void isSoldOutBtnCheck() throws Exception {
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		Assert.assertTrue(commodityManagementPage.isSoldOutBtn(), "商品管理页-已售完按钮不存在");
	}
	
	/**
	 * 判断筛选列表中已下架按钮是否存在
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void isOffShelvesBtnCheck() throws Exception {
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		Assert.assertTrue(commodityManagementPage.isOffShelvesBtn(), "商品管理页-已下架按钮不存在");
	}
	
	/**
	 * 判断排序列表中上架时间是否存在
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void isOnShelvesTimeBtnCheck() throws Exception {
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		Assert.assertTrue(commodityManagementPage.isOnShelvesTimeBtn(), "商品管理页-上架时间不存在");
	}
	
	/**
	 * 判断排序列表中库存是否存在
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void isStocksBtnCheck() throws Exception {
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		Assert.assertTrue(commodityManagementPage.isStocksBtn(), "商品管理页-库存按钮不存在");
	}
	
	/**
	 * 判断排序列表中销量是否存在
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void isSalesVolumeBtnCheck() throws Exception {
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		Assert.assertTrue(commodityManagementPage.isSalesVolumeBtn(), "商品管理页-销量按钮不存在");
	}
	
	/**
	 * 判断全选是否存在
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void isAllSelectBtnCheck() throws Exception {
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		Assert.assertTrue(commodityManagementPage.isAllSelectBtn(), "商品管理页-全选按钮不存在");
	}
	
	/**
	 * 判断批量分类是否存在
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void isBatchClassCheck() throws Exception {
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		Assert.assertTrue(commodityManagementPage.isBatchClass(), "商品管理页-批量分类不存在");
	}
	
	/**
	 * 判断批量下架是否存在
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void isBatchOffShelvesCheck() throws Exception {
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		Assert.assertTrue(commodityManagementPage.isBatchOffShelves(), "商品管理页-批量下架不存在");
	}
	
	/**
	 * 判断批量删除是否存在
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void isBatchDeleteCheck() throws Exception {
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		Assert.assertTrue(commodityManagementPage.isBatchDelete(), "商品管理页-批量删除不存在");
	}
	
	/**
	 * 判断商品后面的编辑按钮是否存在
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void isEditBtnCheck() throws Exception {
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		Assert.assertTrue(commodityManagementPage.isEditBtn(), "商品管理页-商品后的编辑按钮不存在");
	}
	
	/**
	 * 判断商品后面的下架按钮是否存在
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void isOffItemBtnCheck() throws Exception {
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		Assert.assertTrue(commodityManagementPage.isOffItemBtn(), "商品管理页-商品后的下架按钮不存在");
	}
	
	/**
	 * 判断商品后面的删除按钮是否存在
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void isDeleteItemBtn() throws Exception {
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		Assert.assertTrue(commodityManagementPage.isDeleteItemBtn(), "商品管理页-商品后的删除按钮不存在");
	}
	
	/**
	 * 判断批量导出商品按钮是否存在
	 * @throws Exception
	 */
	@Test(groups = "commodityManagementAddTest")
	public void isExportCommodityCheck() throws Exception {
		CommodityManagementPage commodityManagementPage = CommodityManagementAction.intoCommodityManagementPage();
		Assert.assertTrue(commodityManagementPage.isExportCommodity(), "商品管理页-批量导出商品按钮不存在");
	}
	

}
