package com.wd.web.page;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import com.wd.libarary.BasePage;
import com.wd.libarary.Locator;
import com.wd.libarary.Locator.ByType;

public class CommodityManagementPage extends BasePage {
	
	public CommodityManagementPage(WebDriver driver) throws Exception {
		super(driver);
	}
	
	

	//页面左侧商品管理按钮
	Locator commodityManagement = new Locator("a[data-for-gaq='商品管理']",ByType.cssSelector);
	//添加商品按钮
	Locator addCommodity = new Locator("a[data-for-gaq='商品管理-添加商品']",ByType.cssSelector);
	//商品图片按钮
	Locator addcommodityPicture = new Locator("input[name='imgs[]']",ByType.cssSelector);
	//提交按钮
	Locator submit = new Locator("submit_i_do_item");
	//点击提交按钮后的弹出消息
	Locator messageText = new Locator("_alert_content");
	//商品描述输入框
	Locator commodityDescription = new Locator("i_des");
	//商品价格输入框
	Locator commodityPrice = new Locator("i_no_sku_price");
	//商品数量输入框
	Locator commodityStock = new Locator("i_no_sku_stock");
	//商品编码输入框
	Locator commodityCode = new Locator("coding_val");
	//店长推荐选择框
	Locator shopownerRecommend = new Locator("isTopItem");
	//包邮选择框
	Locator freeDelivery = new Locator("freeDelivery");
	//偏远地区不包邮选择框
	Locator remoteFreeDelivery = new Locator("remoteFreeDelivery");
	//是否清关选择框
	Locator isCustoms = new Locator("isCustoms");
	//特定区域配送选择框
	Locator areaLimit = new Locator("areaLimit");
	//可配送区域按钮
	Locator areaLimitBtn = new Locator("no-areaLimit-btn",ByType.className);
	//选择支持配送地区--北京
	Locator bj = new Locator("div[data-address-id='1001']",ByType.cssSelector);
	//城市的全选按钮
	Locator selectAll = new Locator("div.select-flag:first-child",ByType.cssSelector);
	//可配送区域设置--确定按钮
	Locator determine = new Locator("div.btn.confirm",ByType.cssSelector);
	//可配送区域设置--模板名称
	Locator templateName = new Locator("input[placeholder=请输入模版名称]",ByType.cssSelector);
	//可配送区域设置--新建可配送区域模板
	Locator newTemplate = new Locator("div[data-for-gaq=新建可配送区域模板]",ByType.cssSelector);
	//选择第一个测试模板
	Locator firstTemplate = new Locator("div.list div:nth-child(1) div:nth-child(1) input",ByType.cssSelector);
	//第一个商品的删除按钮
	Locator deleteBtn = new Locator("div[ng-show='ctrl.items.length'] div:nth-child(2) div:nth-child(1) div:nth-child(8) a:nth-child(3)",ByType.cssSelector);
	//点击删除按钮后弹出的确认提示框中的确认按钮
	Locator okBtn = new Locator("button[ng-click='ok()']",ByType.cssSelector);
	//点击删除按钮后弹出的确认提示框中的取消按钮
	Locator cancelBtn = new Locator("button[ng-click='cancel()']",ByType.cssSelector);
	//商品列表中是否有商品
	Locator commodity = new Locator("div.cpc-item-main-con",ByType.cssSelector);
	//页面右上角搜索商品的放大镜按钮
	Locator searchBtn = new Locator("img[src='https://s.geilicdn.com/CPC/item/manage/images/search.png']",ByType.cssSelector);
	//页面右上角搜索输入框
	Locator searchInput = new Locator("input[placeholder='商品名称']",ByType.cssSelector);
	//页面上筛选行全部按钮
	Locator allBtn = new Locator("a[data-for-gaq='商品管理-全部']",ByType.cssSelector);
	//页面上筛选行出售中按钮
	Locator onSaleBtn = new Locator("a[data-for-gaq='商品管理-出售中']",ByType.cssSelector);
	//页面上筛选行已售完按钮
	Locator soldOutBtn = new Locator("a[data-for-gaq='商品管理-已卖完']",ByType.cssSelector);
	//页面上筛选行已下架按钮
	Locator offShelvesBtn = new Locator("a[data-for-gaq='商品管理-已下架']",ByType.cssSelector);
	//页面上筛选行上架时间按钮
	Locator onShelvesTimeBtn = new Locator("a[data-for-gaq='商品管理-上架时间']",ByType.cssSelector);
	//页面上筛选行库存按钮
	Locator stocksBtn = new Locator("a[data-for-gaq='商品管理-库存']",ByType.cssSelector);
	//页面上筛选行销量按钮
	Locator salesVolumeBtn = new Locator("a[data-for-gaq='商品管理-销量']",ByType.cssSelector);
	//商品列表页中的全选按钮
	Locator allSelectBtn = new Locator("cpc-items-select-all");
	//商品列表页批量分类按钮
	Locator batchClass = new Locator("a[data-for-gaq='商品管理-批量分类']",ByType.cssSelector);
	//商品列表页批量下架按钮
	Locator	batchOffShelves = new Locator("a[data-for-gaq='商品管理-批量下架']",ByType.cssSelector);
	//商品列表页批量删除按钮
	Locator	batchDelete = new Locator("a[data-for-gaq='商品管理-批量删除']",ByType.cssSelector);
	//商品后面的编辑按钮
	Locator editBtn = new Locator("div.cpc-item-cell.cpc-item-opt.ng-scope a:first-child",ByType.cssSelector);
	//商品后面的下架按钮
	Locator offItemBtn = new Locator("div.cpc-item-cell.cpc-item-opt.ng-scope a:nth-child(2)",ByType.cssSelector);
	//商品后面的删除按钮
	Locator deleteItemBtn = new Locator("div.cpc-item-cell.cpc-item-opt.ng-scope a:last-child",ByType.cssSelector);
	//批量导出按钮
	Locator exportCommodity = new Locator("a[data-for-gaq='商品管理-批量导出商品']",ByType.cssSelector);
	//第一个商品的更新时间
	Locator updateTime = new Locator("span[ng-bind='item.add_time']",ByType.cssSelector);
	//点击商品后面的下架按钮，弹出的提示框文本提示元素
	Locator offItemAlert = new Locator("div.modal-body.ng-scope",ByType.cssSelector);
	//商品列表前的选择框
	Locator itemCheckBox = new Locator("div.cpc-item-main-con div input",ByType.cssSelector);
	//已售完页中，没有商品时的文字提示
	Locator noItemMsg = new Locator("div.tip-text",ByType.cssSelector);
	// 商品列表页批量上架按钮
	Locator batchShelves = new Locator("a[data-for-gaq='商品管理-批量上架']",ByType.cssSelector);
	//添加商品型号按钮
	Locator addCommodityModel = new Locator("add_sku");
	// 搜索页中的没有搜索出内容的提示
	Locator listempty = new Locator("list_empty");
	//添加一级商品型号的型号输入框第一个
	Locator commodityModelModel = new Locator("#sku_ul li:nth-child(2) div.sku_item_a input.sku_item_a_input",ByType.cssSelector);
	//添加一级商品型号的编码输入框第一个
	Locator commodityModelCode = new Locator("#sku_ul li:nth-child(2) div:nth-child(2) input.sku_item_m_input",ByType.cssSelector);
	//添加一级商品型号的价格输入框第一个
	Locator commodityModelPrice = new Locator("#sku_ul li:nth-child(2) div:nth-child(3) input.sku_item_b_input",ByType.cssSelector);
	//添加一级商品型号的库存输入框第一个
	Locator commodityModelStock = new Locator("#sku_ul li:nth-child(2) div.sku_item_c input.sku_item_c_input",ByType.cssSelector);
	//商品型号中的添加图片按钮第一个
	Locator addcommodityModelPictureFirst = new Locator("#sku_ul li:nth-child(2) div.sku_img_editor div.sku_img_upload_area input[name='sku_img_upload']",ByType.cssSelector);
	// 左上角微店logo
	Locator logo = new Locator("img[src='https://d.weidian.com/images/index/logo.png']",ByType.cssSelector);
	// 点击批量分类弹出框中的第一个分类
	Locator classification = new Locator("div.cate-select-cates a",ByType.cssSelector);
	//添加一级商品型号的型号输入框第二个
	Locator commodityModelModelSecond = new Locator("#sku_ul li:nth-child(3) div.sku_item_a input.sku_item_a_input",ByType.cssSelector);
	//添加一级商品型号的编码输入框第二个
	Locator commodityModelCodeSecond = new Locator("#sku_ul li:nth-child(3) div:nth-child(2) input.sku_item_m_input",ByType.cssSelector);
	//添加一级商品型号的价格输入框第二个
	Locator commodityModelPriceSecond = new Locator("#sku_ul li:nth-child(3) div:nth-child(3) input.sku_item_b_input",ByType.cssSelector);
	//添加一级商品型号的库存输入框第二个
	Locator commodityModelStockSecond = new Locator("#sku_ul li:nth-child(3) div.sku_item_c input.sku_item_c_input",ByType.cssSelector);
	//商品型号中的添加图片按钮第二个
	Locator addcommodityModelPictureSecond = new Locator("#sku_ul li:nth-child(3) div.sku_img_editor div.sku_img_upload_area input[name='sku_img_upload']",ByType.cssSelector);
	//第一个商品的销量字段
	Locator Salesvolume = new Locator("span[ng-bind='item.sold']",ByType.cssSelector);
	// 批量分类弹出框的确定按钮
	Locator sureBtn = new Locator("button.btn.btn-primary", ByType.cssSelector);
	// 商品列表页批量改价按钮
	Locator batchChangeprice = new Locator("a[data-for-gaq='商品管理-批量改价']",ByType.cssSelector);
	//添加一级商品型号的型号输入框第三个
	Locator commodityModelModelThird = new Locator("#sku_ul li:nth-child(4) div.sku_item_a input.sku_item_a_input",ByType.cssSelector);
	//添加一级商品型号的编码输入框第三个
	Locator commodityModelCodeThird = new Locator("#sku_ul li:nth-child(4) div:nth-child(2) input.sku_item_m_input",ByType.cssSelector);
	//添加一级商品型号的价格输入框第三个
	Locator commodityModelPriceThird = new Locator("#sku_ul li:nth-child(4) div:nth-child(3) input.sku_item_b_input",ByType.cssSelector);
	//添加一级商品型号的库存输入框第三个
	Locator commodityModelStockThird = new Locator("#sku_ul li:nth-child(4) div.sku_item_c input.sku_item_c_input",ByType.cssSelector);
	//商品型号中的添加图片按钮第三个
	Locator addcommodityModelPictureThird = new Locator("#sku_ul li:nth-child(4) div.sku_img_editor div.sku_img_upload_area input[name='sku_img_upload']",ByType.cssSelector);	
	// 批量改价界面中的直接输入价格输入框
	Locator PriceBtn = new Locator("input[ng-change='ctrl.changePrice_1()']",ByType.cssSelector);
	// 多sku颜色，蓝色
	Locator blueBtn = new Locator("p[data-title='蓝色']", ByType.cssSelector);
	// 多sku颜色，黄色
	Locator yellowBtn = new Locator("p[data-title='黄色']", ByType.cssSelector);
	// 多sku型号，S
	Locator SBtn = new Locator("p[data-title='S']", ByType.cssSelector);
	// 多sku型号，XL
	Locator XLBtn = new Locator("p[data-title='XL']", ByType.cssSelector);
	//添加多级型号按钮
	Locator multiCommodityModel = new Locator("add_multi_sku");
	//添加多级商品页面的（未勾选）颜色按钮
	Locator multiColorBtn = new Locator("p[data-title='颜色']",ByType.cssSelector);
	//添加多级商品页面的（未勾选）尺寸按钮
	Locator multiSizeBtn = new Locator("p[data-title='尺寸']",ByType.cssSelector);
	//多级商品型号页的取消按钮
	Locator multiCancelBtn = new Locator("div.footer-btn.cancle",ByType.cssSelector);
	//商品信息页面标题
	Locator commodityInfo = new Locator("#i_do_wrap > h3:nth-child(1)",ByType.cssSelector);
	//自定义型号文本框
	Locator customCommodityModel= new Locator("sku_add_model");	
	//自定义型号的新建按钮
	Locator createCustom = new Locator("sku_add_model_btn");
	//多级商品型号页的确定按钮
	Locator multiConfirmBtn = new Locator("div.footer-btn.confirm",ByType.cssSelector);
	//多级商品页面自定义的原产地按钮
	Locator multiYuanchandiBtn = new Locator("p[data-title='原产地']",ByType.cssSelector);
	//多级商品页面自定义的图形按钮
	Locator multiTuxingBtn = new Locator("p[data-title='图形']",ByType.cssSelector);
	//多级商品页面自定义的材质按钮
	Locator multiCaizhiBtn = new Locator("p[data-title='材质']",ByType.cssSelector);	
	//多级商品页面自定义的气味按钮
	Locator multiQiweiBtn = new Locator("p[data-title='气味']",ByType.cssSelector);	
	//多级商品页面自定义的小XX按钮
	Locator mouseHoverDelBtn = new Locator("p[data-title='原产地'] i.sku_del",ByType.cssSelector);
	//多级SKU属性的第一层的第一个小XX按钮
	Locator mouseHoverDelFirstBtn = new Locator("#item_sku_pro div:nth-child(1) div.item_sku_atr p:nth-child(1) i.sku_del",ByType.cssSelector);
	//属性页面的第一个自定义属性删除按钮
	Locator promouseHoverDel = new Locator("p[data-title='中国一二三四五六七八九十一二三四五六七八'] i.sku_del",ByType.cssSelector);
	//鼠标事件后的删除弹框确定按钮
	Locator mouseHoverDelConfirmBtn = new Locator("_confirm_btnB");
	//自定义中国、美国、法国属性
	Locator zhongguoPro = new Locator("p[data-value='中国一二三四五六七八九十一二三四五六七八']",ByType.cssSelector);
	Locator meiguoPro = new Locator("p[data-title='美国']",ByType.cssSelector);
	Locator faguoPro = new Locator("p[data-title='法国']",ByType.cssSelector);
	Locator yingguoPro = new Locator("p[data-title='英国']",ByType.cssSelector);
	Locator deguoPro = new Locator("p[data-title='德国']",ByType.cssSelector);
	Locator ribenPro = new Locator("p[data-title='日本']",ByType.cssSelector);
	
	//自定义多SKU属性型号测试i 1到4
	Locator testPro4 = new Locator("#layer_sku_self p:nth-child(1) span.sku_attr_val",ByType.cssSelector);
	Locator testPro3 = new Locator("#layer_sku_self p:nth-child(2) span.sku_attr_val",ByType.cssSelector);
	Locator testPro2 = new Locator("#layer_sku_self p:nth-child(3) span.sku_attr_val",ByType.cssSelector);
	Locator testPro1 = new Locator("#layer_sku_self p:nth-child(4) span.sku_attr_val",ByType.cssSelector);
	
	//验证从上至下第一个按钮
	Locator firstBtn = new Locator("#item_sku_pro div:nth-child(1) p.item_sku_model_name",ByType.cssSelector);
	//验证从上至下第二个按钮
	Locator secondBtn = new Locator("#item_sku_pro div:nth-child(2) p.item_sku_model_name",ByType.cssSelector);
	//验证从上至下第三个按钮
	Locator thirdBtn = new Locator("#item_sku_pro div:nth-child(3) p.item_sku_model_name",ByType.cssSelector);
		
	//验证从左至右第一个按钮
	Locator firstPro = new Locator("#item_sku_pro div:nth-child(1) div.item_sku_atr p:nth-child(1) span.sku_attr_val",ByType.cssSelector);
	//验证从左至右第二个按钮
	Locator secondPro = new Locator("#item_sku_pro div:nth-child(1) div.item_sku_atr p:nth-child(2) span.sku_attr_val",ByType.cssSelector);
	//验证从上至下第三个按钮	
	Locator thirdPro = new Locator("#item_sku_pro div:nth-child(1) div.item_sku_atr p:nth-child(3) span.sku_attr_val",ByType.cssSelector);
			
	//当有一个商品型号的自定义属性文本框
	Locator proCustomCommodityModel= new Locator("div.sku_line.sku_add.sku_attr_add_area input[placeholder='输入型号属性']",ByType.cssSelector);	
	//当有一个商品型号的自定义属性的新建按钮
	Locator createProCustom = new Locator("a.sku_add_btn.sku_add_attr_btn",ByType.cssSelector);
	//当有多个多级型号的自定义属性文本框
	Locator protest1CustomCommodityModel = new Locator("#item_sku_pro div:nth-child(1) div.item_sku_atr div.sku_line.sku_add.sku_attr_add_area input.sku_add_input.sku_add_attr_input",ByType.cssSelector);
	Locator protest2CustomCommodityModel = new Locator("#item_sku_pro div:nth-child(2) div.item_sku_atr div.sku_line.sku_add.sku_attr_add_area input.sku_add_input.sku_add_attr_input",ByType.cssSelector);
	Locator protest3CustomCommodityModel = new Locator("#item_sku_pro div:nth-child(3) div.item_sku_atr div.sku_line.sku_add.sku_attr_add_area input.sku_add_input.sku_add_attr_input",ByType.cssSelector);
	Locator protest4CustomCommodityModel = new Locator("#item_sku_pro div:nth-child(4) div.item_sku_atr div.sku_line.sku_add.sku_attr_add_area input.sku_add_input.sku_add_attr_input",ByType.cssSelector);
	//当有多个商品型号的自定义属性的新建按钮
	Locator createPro1Custom = new Locator("#item_sku_pro div:nth-child(1) div.item_sku_atr div.sku_line.sku_add.sku_attr_add_area a.sku_add_btn.sku_add_attr_btn",ByType.cssSelector);
	Locator createPro2Custom = new Locator("#item_sku_pro div:nth-child(2) div.item_sku_atr div.sku_line.sku_add.sku_attr_add_area a.sku_add_btn.sku_add_attr_btn",ByType.cssSelector);
	Locator createPro3Custom = new Locator("#item_sku_pro div:nth-child(3) div.item_sku_atr div.sku_line.sku_add.sku_attr_add_area a.sku_add_btn.sku_add_attr_btn",ByType.cssSelector);
	Locator createPro4Custom = new Locator("#item_sku_pro div:nth-child(4) div.item_sku_atr div.sku_line.sku_add.sku_attr_add_area a.sku_add_btn.sku_add_attr_btn",ByType.cssSelector);
	//型号1的五个属性
	Locator firstPro1 = new Locator("#item_sku_pro div:nth-child(1) div.item_sku_atr p:nth-child(1) span.sku_attr_val",ByType.cssSelector);
	Locator firstPro2 = new Locator("#item_sku_pro div:nth-child(1) div.item_sku_atr p:nth-child(2) span.sku_attr_val",ByType.cssSelector);
	Locator firstPro3 = new Locator("#item_sku_pro div:nth-child(1) div.item_sku_atr p:nth-child(3) span.sku_attr_val",ByType.cssSelector);
	Locator firstPro4 = new Locator("#item_sku_pro div:nth-child(1) div.item_sku_atr p:nth-child(4) span.sku_attr_val",ByType.cssSelector);
	Locator firstPro5 = new Locator("#item_sku_pro div:nth-child(1) div.item_sku_atr p:nth-child(5) span.sku_attr_val",ByType.cssSelector);
	//型号2的五个属性
	Locator secondPro1 = new Locator("#item_sku_pro div:nth-child(2) div.item_sku_atr p:nth-child(1) span.sku_attr_val",ByType.cssSelector);
	Locator secondPro2 = new Locator("#item_sku_pro div:nth-child(2) div.item_sku_atr p:nth-child(2) span.sku_attr_val",ByType.cssSelector);
	Locator secondPro3 = new Locator("#item_sku_pro div:nth-child(2) div.item_sku_atr p:nth-child(3) span.sku_attr_val",ByType.cssSelector);
	Locator secondPro4 = new Locator("#item_sku_pro div:nth-child(2) div.item_sku_atr p:nth-child(4) span.sku_attr_val",ByType.cssSelector);
	Locator secondPro5 = new Locator("#item_sku_pro div:nth-child(2) div.item_sku_atr p:nth-child(5) span.sku_attr_val",ByType.cssSelector);
	//型号3的五个属性
	Locator thirdPro1 = new Locator("#item_sku_pro div:nth-child(3) div.item_sku_atr p:nth-child(1) span.sku_attr_val",ByType.cssSelector);
	Locator thirdPro2 = new Locator("#item_sku_pro div:nth-child(3) div.item_sku_atr p:nth-child(2) span.sku_attr_val",ByType.cssSelector);
	Locator thirdPro3 = new Locator("#item_sku_pro div:nth-child(3) div.item_sku_atr p:nth-child(3) span.sku_attr_val",ByType.cssSelector);
	Locator thirdPro4 = new Locator("#item_sku_pro div:nth-child(3) div.item_sku_atr p:nth-child(4) span.sku_attr_val",ByType.cssSelector);
	Locator thirdPro5 = new Locator("#item_sku_pro div:nth-child(3) div.item_sku_atr p:nth-child(5) span.sku_attr_val",ByType.cssSelector);
	//型号4的五个属性
	Locator fourthPro1 = new Locator("#item_sku_pro div:nth-child(4) div.item_sku_atr p:nth-child(1) span.sku_attr_val",ByType.cssSelector);
	Locator fourthPro2 = new Locator("#item_sku_pro div:nth-child(4) div.item_sku_atr p:nth-child(2) span.sku_attr_val",ByType.cssSelector);
	Locator fourthPro3 = new Locator("#item_sku_pro div:nth-child(4) div.item_sku_atr p:nth-child(3) span.sku_attr_val",ByType.cssSelector);
	Locator fourthPro4 = new Locator("#item_sku_pro div:nth-child(4) div.item_sku_atr p:nth-child(4) span.sku_attr_val",ByType.cssSelector);
	Locator fourthPro5 = new Locator("#item_sku_pro div:nth-child(4) div.item_sku_atr p:nth-child(5) span.sku_attr_val",ByType.cssSelector);
	//多SKU属性从上至下的价格，库存，商品编码
	Locator priceSku1 = new Locator("#item_sku_list ul.sku_list_box.sku_list_len2 li:nth-child(2) p.sku_list_width_price input.sku_list_price",ByType.cssSelector);
	Locator priceSku2 = new Locator("#item_sku_list ul.sku_list_box.sku_list_len2 li:nth-child(3) p.sku_list_width_price input.sku_list_price",ByType.cssSelector);
	Locator priceSku3 = new Locator("#item_sku_list ul.sku_list_box.sku_list_len2 li:nth-child(4) p.sku_list_width_price input.sku_list_price",ByType.cssSelector);
	Locator priceSku4 = new Locator("#item_sku_list ul.sku_list_box.sku_list_len2 li:nth-child(5) p.sku_list_width_price input.sku_list_price",ByType.cssSelector);
	
	Locator stockSku1 = new Locator("#item_sku_list ul.sku_list_box.sku_list_len2 li:nth-child(2) p.sku_list_width_stock input.sku_list_stock",ByType.cssSelector);
	Locator stockSku2 = new Locator("#item_sku_list ul.sku_list_box.sku_list_len2 li:nth-child(3) p.sku_list_width_stock input.sku_list_stock",ByType.cssSelector);
	Locator stockSku3 = new Locator("#item_sku_list ul.sku_list_box.sku_list_len2 li:nth-child(4) p.sku_list_width_stock input.sku_list_stock",ByType.cssSelector);
	Locator stockSku4 = new Locator("#item_sku_list ul.sku_list_box.sku_list_len2 li:nth-child(5) p.sku_list_width_stock input.sku_list_stock",ByType.cssSelector);

	Locator codeSku1 = new Locator("#item_sku_list ul.sku_list_box.sku_list_len2 li:nth-child(2) p.sku_list_width_code input.sku_list_code",ByType.cssSelector);
	Locator codeSku2 = new Locator("#item_sku_list ul.sku_list_box.sku_list_len2 li:nth-child(3) p.sku_list_width_code input.sku_list_code",ByType.cssSelector);
	Locator codeSku3 = new Locator("#item_sku_list ul.sku_list_box.sku_list_len2 li:nth-child(4) p.sku_list_width_code input.sku_list_code",ByType.cssSelector);
	Locator codeSku4 = new Locator("#item_sku_list ul.sku_list_box.sku_list_len2 li:nth-child(5) p.sku_list_width_code input.sku_list_code",ByType.cssSelector);
	//点击展开按钮
	Locator expandButton = new Locator("#wrap div.ng-scope div.cpc-items.ng-scope div.cpc-item-list div:nth-child(2) div:nth-child(2) a.sku-show-toggle.btn.ng-scope span[ng-show='!item.showAllSku']",ByType.cssSelector);
	//点击展开后是否显示原产地，尺码，颜色
	Locator yuanchandi = new Locator("#wrap div.ng-scope div.cpc-items.ng-scope div.cpc-item-list div:nth-child(2) div:nth-child(2) div.cpc-item-sku-con.ng-scope div:nth-child(1) div:nth-child(1) span.ng-binding",ByType.cssSelector);
	Locator chima = new Locator("#wrap div.ng-scope div.cpc-items.ng-scope div.cpc-item-list div:nth-child(2) div:nth-child(2) div.cpc-item-sku-con.ng-scope div:nth-child(2) div:nth-child(1) span.ng-binding ",ByType.cssSelector);
	Locator yanse = new Locator("#wrap div.ng-scope div.cpc-items.ng-scope div.cpc-item-list div:nth-child(2) div:nth-child(2) div.cpc-item-sku-con.ng-scope div:nth-child(3) div:nth-child(1) span.ng-binding ",ByType.cssSelector);
	Locator sumstock = new Locator("#wrap div.ng-scope div.cpc-items.ng-scope div.cpc-item-list div:nth-child(2) div:nth-child(2) div.cpc-item-main-con div:nth-child(5) span.ng-binding",ByType.cssSelector);
	Locator stock1 = new Locator("#wrap div.ng-scope div.ng-scope div.cpc-item-list div:nth-child(2) div:nth-child(2) div.cpc-item-sku-con.ng-scope div:nth-child(1) div:nth-child(4) span.ng-binding",ByType.cssSelector);
	Locator stock2 = new Locator("#wrap div.ng-scope div.ng-scope div.cpc-item-list div:nth-child(2) div:nth-child(2) div.cpc-item-sku-con.ng-scope div:nth-child(2) div:nth-child(4) span.ng-binding",ByType.cssSelector);
	Locator stock3 = new Locator("#wrap div.ng-scope div.ng-scope div.cpc-item-list div:nth-child(2) div:nth-child(2) div.cpc-item-sku-con.ng-scope div:nth-child(3) div:nth-child(4) span.ng-binding",ByType.cssSelector);
	Locator stock4 = new Locator("#wrap div.ng-scope div.ng-scope div.cpc-item-list div:nth-child(2) div:nth-child(2) div.cpc-item-sku-con.ng-scope div:nth-child(4) div:nth-child(4) span.ng-binding",ByType.cssSelector);
	
	Locator sumSale = new Locator("#wrap div.ng-scope div.cpc-items.ng-scope div.cpc-item-list div:nth-child(2) div:nth-child(2) div.cpc-item-main-con div:nth-child(4) span.ng-binding",ByType.cssSelector);	
	Locator sale1 = new Locator("#wrap div.ng-scope div.cpc-items.ng-scope div.cpc-item-list div:nth-child(2) div:nth-child(2) div.cpc-item-sku-con.ng-scope div:nth-child(1) div:nth-child(3) span.ng-binding",ByType.cssSelector);
	Locator sale2 = new Locator("#wrap div.ng-scope div.cpc-items.ng-scope div.cpc-item-list div:nth-child(2) div:nth-child(2) div.cpc-item-sku-con.ng-scope div:nth-child(2) div:nth-child(3) span.ng-binding",ByType.cssSelector);
	Locator sale3 = new Locator("#wrap div.ng-scope div.cpc-items.ng-scope div.cpc-item-list div:nth-child(2) div:nth-child(2) div.cpc-item-sku-con.ng-scope div:nth-child(3) div:nth-child(3) span.ng-binding",ByType.cssSelector);
	Locator sale4 = new Locator("#wrap div.ng-scope div.cpc-items.ng-scope div.cpc-item-list div:nth-child(2) div:nth-child(2) div.cpc-item-sku-con.ng-scope div:nth-child(4) div:nth-child(3) span.ng-binding",ByType.cssSelector);
	//“修改多级型号”按钮
	Locator updateMulBtn = new Locator("add_multi_sku");
	//批量设置输入价格
	Locator batchPrice = new Locator("#item_sku_list ul.sku_list_box.sku_list_len2 li:nth-child(6) p.sku_list_mod_price input.sku_list_multi_price",ByType.cssSelector);
	//批量设置输入库存
	Locator batchStock = new Locator("#item_sku_list ul.sku_list_box.sku_list_len2 li:nth-child(6) p.sku_list_mod_stock input.sku_list_multi_stock",ByType.cssSelector);
	//“其他信息”
	Locator qitaxinxi = new Locator("#i_do_wrap h3.mt40",ByType.cssSelector);
	//	Locator firstPro1 = new Locator(getPriceStockCode("2","pice"),ByType.cssSelector);
//	Locator firstPro2 = new Locator(getPriceStockCode("2","stock"),ByType.cssSelector);
	//点击左上角微店标志
	Locator test = new Locator("div.header-b-l",ByType.cssSelector);
	
	
	public void clickTest() throws Exception {
		click(test);
	}
	
	public void shuaxin() throws Exception {
		click(test);
	}
	
	
//根据child位置和class的属性，返回多级型号中，价格、库存、商品编码的元素定位
//	public String getPriceStockCode(String no,String sb) {
//		String locator = "#item_sku_list > ul > li:nth-child("+no+") > p.sku_list_width_"+sb+" > input";
//		return locator;
//	}
	//商品管理页的第一个商品的“编辑”按钮
		Locator editOfCommodityManagementFirstBtn = new Locator("#wrap div.ng-scope div.cpc-items.ng-scope div.cpc-item-list div:nth-child(2) div:nth-child(2) div.cpc-item-main-con div.cpc-item-cell.cpc-item-opt.ng-scope a:nth-child(1)",ByType.cssSelector);
	//点击多SKU第一个属性
		Locator firstSkuProBtn = new Locator("#item_sku_pro div:nth-child(1) div.item_sku_atr p:nth-child(1) span.sku_attr_val",ByType.cssSelector);
		//选择商品型号的“X”按钮
		Locator closeMulBtn = new Locator("#sku_layer div.area-footer div.footer-btn-area div.footer-btn.cancle",ByType.cssSelector);
//		Locator closeMulBtn = new Locator("div.footer-btn.cancle");
		
		//验证删除历史原产地后它的属性还存在在商品管理页面上
		Locator historyPro1 = new Locator("#wrap div.ng-scope div.cpc-items.ng-scope div.cpc-item-list div:nth-child(2) div:nth-child(2) div.cpc-item-sku-con.ng-scope div:nth-child(1) div:nth-child(1) span.ng-binding",ByType.cssSelector);
		//商品型号选择框
		Locator mulText = new Locator("#sku_layer div.area-content",ByType.cssSelector);
		
	
	
	// 点击左上角logo按钮
	public void clickLogo() throws Exception {
		click(logo);
	}
	
	// 点击批量分类弹出界面中的确定按钮
	public void clicksureBtn() throws Exception {
		click(sureBtn);
	}
	
	//获取第一个商品的销量字段值
	public String getSalesvolume() throws Exception {
		return getText(Salesvolume);
	}
	
	// 点击多sku蓝色按钮
	public void clickblueBtn() throws Exception {
		click(blueBtn);
	}
	
	// 多级sku中点击型号S按钮
	public void clickSBtn() throws Exception {
		click(SBtn);
	}
	
	// 多级sku中点击型号XL按钮
	public void clickXLBtn() throws Exception {
		click(XLBtn);
	}
	
	// 点击多sku蓝色按钮
	public void clickyellowBtn() throws Exception {
		click(yellowBtn);
	}
		
	//点击筛选栏中的全部按钮
	public void clickAllBtn() throws Exception {
		click(allBtn);
	}
	
	// 向商品搜索输入框输入内容
	public void typeSearchInput(String sb) throws Exception {
		type(searchInput, sb);
	}
	
	// 填写价格到批量改价界面中的直接填写价格输入框
	public void typePriceBtn(String sb) throws Exception {
		type(PriceBtn, sb);
	}
		
	// 点击批量分类弹出框的第一个分类
	public void clickClassification() throws Exception {
		click(classification);
	}
	
	// 点击批量分类按钮
	public void clickbatchClassBtn() throws Exception {
		click(batchClass);
	}
	
	// 判断搜索页提示信息是否存在
	public boolean islistempty() throws IOException {
		return isElementExist(listempty);
	}
	
	// 点击搜索按钮
	public void clicksearchBtn() throws Exception {
		click(searchBtn);
	}
		
	//点击出售中按钮
	public void clickOnSaleBtn() throws Exception {
		click(onSaleBtn);
	}
	
	// 点击批量改价按钮
	public void clickbatchChangepriceBtn() throws Exception {
		click(batchChangeprice);
	}
	
	//添加商品的商品照片
	public void addPicture() throws Exception {
		type(addcommodityPicture,System.getProperty("user.dir")+"/imgs/pic.png");
	}

	
	//获取已售完页中的文字信息
	public String getnoItemMsg() throws Exception {
		return getText(noItemMsg);
	}
	
	//验证单选框是否被选中
	public boolean ischecked() throws Exception {
		return ischecked(itemCheckBox);
	}
	
	//点击弹出框的取消按钮
	public void clickCancelBtn() throws Exception {
		click(cancelBtn);
	}
	
	// 点击批量上架按钮
	public void clickbatchShelvesBtn() throws Exception {
		click(batchShelves);
	}
		
	//点击批量删除按钮
	public void clickbatchDelete() throws Exception {
		click(batchDelete);
	}
	
	//点击批量下架按钮
	public void clickBatchOffShelves() throws Exception {
		click(batchOffShelves);
	}
	
	//点击第一个商品前的单选框
	public void clickItemCheckBox() throws Exception {
		click(itemCheckBox);
	}
	
	//判断提交按钮是否存在
	public boolean isSubmit() throws Exception {
		return isElementExist(submit);
	}
	
	//点击商品后面的编辑按钮
	public void clickEditBtn() throws Exception {
		click(editBtn);
	}
	
	//点击商品后面的删除按钮
	public void clickDeleteItemBtn() throws Exception {
		click(deleteItemBtn);
	}
	
	//获取点击商品后面下架按钮，弹出提示框文本内容
	public String getOffItemAlert() throws Exception {
		return getText(offItemAlert);
	}
	
	//点击商品后面的下架按钮
	public void clickOffItemBtn() throws Exception {
		click(offItemBtn);
	}
	
	//点击商品后面的下架或删除按钮后，弹出的确认框中的确认按钮
	public void clickOkBtn() throws Exception {
		click(okBtn);
	}
	
	//点击已售完按钮
	public void clickSoldOutBtn() throws Exception {
		click(soldOutBtn);
	}
	
	//点击已下架按钮
	public void clickOffShelvesBtn() throws Exception {
		click(offShelvesBtn);
	}
	
	//点击销量按钮
	public void clickSalesVolumeBtn() throws Exception {
		click(salesVolumeBtn);
	}
	
	//获取第一个商品更新时间内容
	public String getUpdateTime() throws Exception {
		return getText(updateTime);
	}
	
	//点击库存按钮
	public void clickStocksBtn() throws Exception {
		click(stocksBtn);
	}
		
	//点击上架时间按钮
	public void clickOnShelvesTimeBtn() throws Exception {
		click(onShelvesTimeBtn);
	}
	
	//判断添加商品按钮是否存在，用以确认是否进入商品管理页
	public boolean isCommodityManagement() throws Exception {
		return isElementExist(addCommodity);
	}
	
	//点击左侧商品管理按钮，进入商品管理页
	public void clickCommodityManagementPageButton() throws Exception {
		click(commodityManagement);
	}
	
	
	//点击添加商品按钮
	public void clickAddCommodityButton() throws Exception {
		click(addCommodity);
	}
	//点击添加商品图片按钮
	public void clickAddCommodityPictureButton() throws Exception {
		click(addcommodityPicture);
	}
	
	//点击提交按钮
	public void clickSubmitButton() throws Exception {
		click(submit);
	}
	
	//获取弹出提示内容
	public String getMessageText() throws Exception {
		return getText(messageText);
	}

	
	//点击商品描述输入框
	public void clickCommodityDescription() throws Exception {
		click(commodityDescription);
	}
	
	//向商品描述输入框输入描述内容
	public void typeCommodityDescription(String description) throws Exception {
		type(commodityDescription,description);
	}
	
	//点击商品价格输入框
	public void clickCommoditPrice() throws Exception {
		click(commodityPrice);
	}
	
	//向商品价格输入框输入数据
	public void typeCommoditPrice(String price) throws Exception {
		type(commodityPrice,price);
	}
	
	//点击商品库存输入框
	public void clickCommodityStock() throws Exception {
		click(commodityStock);
	}
	
	//向商品库存输入框输入数据
	public void typeCommodityStock(String stock) throws Exception {
		type(commodityStock,stock);
	}
	
	//向商品编码输入框输入数据
	public void typeCommodityCode(String code) throws Exception {
		type(commodityCode,code);
	}
	
	//点击店长推荐选择框
	public void clickShopownerRecommend() throws Exception {
		click(shopownerRecommend);
	}
	
	//点击包邮选择框
	public void clickFreeDelivery() throws Exception {
		click(freeDelivery);
	}
	
	//点击偏远地区不包邮选择框
	public void clickRemoteFreeDelivery() throws Exception {
		click(remoteFreeDelivery);
	}
	
	//点击是否清关选择框
	public void clickIsCustoms() throws Exception {
		click(isCustoms);
	}
	
	//点击可配送区域设置选择框
	public void clickAreaLimit() throws Exception {
		click(areaLimit);
	}
	
	//点击第一个模板选择框
	public void clickFirstTemplate() throws Exception {
		click(firstTemplate);
	}
	
	//判断商品元素是否存在
	public boolean isCommodity() throws Exception {
		return isElementExist(commodity);
	}
	
	//判断搜索按钮是否存在
	public boolean isSearchBtn() throws Exception {
		return isElementExist(searchBtn);
	}
	
	//判断搜索输入框是否存在
	public boolean isSearchInput() throws Exception {
		return isElementExist(searchInput);
	}
	
	//判断添加商品按钮是否存在
	public boolean isAddCommodity() throws Exception {
		return isElementExist(addCommodity);
	}
	
	//判断筛选列表中全部按钮是否存在
	public boolean isAllBtn() throws Exception {
		return isElementExist(allBtn);
	}
		
	//判断筛选列表中出售中按钮是否存在
	public boolean isOnSaleBtn() throws Exception {
		return isElementExist(onSaleBtn);
	}
		
	//判断筛选列表中已售完按钮是否存在
	public boolean isSoldOutBtn() throws Exception {
		return isElementExist(soldOutBtn);
	}
		
	//判断筛选列表中已下架按钮是否存在
	public boolean isOffShelvesBtn() throws Exception {
		return isElementExist(offShelvesBtn);
	}
	//判断排序列表中上架时间是否存在
	public boolean isOnShelvesTimeBtn() throws Exception {
		return isElementExist(onShelvesTimeBtn);
	}
	//判断排序列表中库存是否存在
	public boolean isStocksBtn() throws Exception {
		return isElementExist(stocksBtn);
	}
	//判断排序列表中销量是否存在
	public boolean isSalesVolumeBtn() throws Exception {
		return isElementExist(salesVolumeBtn);
	}
	//判断全选是否存在
	public boolean isAllSelectBtn() throws Exception {
		return isElementExist(allSelectBtn);
	}
	//判断批量分类是否存在
	public boolean isBatchClass() throws Exception {
		return isElementExist(batchClass);
	}
	//判断批量下架是否存在
	public boolean isBatchOffShelves() throws Exception {
		return isElementExist(batchOffShelves);
	}
	//判断批量删除是否存在
	public boolean isBatchDelete() throws Exception {
		return isElementExist(batchDelete);
	}
	//判断商品后面的编辑按钮是否存在
	public boolean isEditBtn() throws Exception {
		return isElementExist(editBtn);
	}
	//判断商品后面的下架按钮是否存在
	public boolean isOffItemBtn() throws Exception {
		return isElementExist(offItemBtn);
	}
	//判断商品后面的删除按钮是否存在
	public boolean isDeleteItemBtn() throws Exception {
		return isElementExist(deleteItemBtn);
	}
	//判断批量导出商品按钮是否存在
	public boolean isExportCommodity() throws Exception {
		return isElementExist(exportCommodity);
	}
	//判断修改多级型号按钮是否存在
	public boolean isUpdateMulBtn() throws Exception {
		return isElementExist(updateMulBtn);
	}
	
	
	
	
	//点击添加商品型号按钮
		public void clickAddCommodityModel() throws Exception {
			click(addCommodityModel);
		}
		public boolean isAddCommodityModel() throws Exception {
			return isElementExist(addCommodityModel);
		}
		//判断添加商品型号按钮是否存在
		
		//点击添加商品型号的型号输入框第一个
		public void clickCommodityModelModel() throws Exception {
				click(commodityModelModel);
			}		
		//向添加商品型号的型号输入框输入型号第一个
		public void typecommodityModelModel(String model) throws Exception {
				type(commodityModelModel,model);
			}
		
		
		//点击添加商品型号的编码输入框第一个
		public void clickCommodityModelCode() throws Exception {
				click(commodityModelCode);
				}				
		//向添加商品型号的型号输入框输入编码第一个
		public void typecommodityModelCode(String code) throws Exception {
				type(commodityModelCode,code);
				}		
	
		
		//点击添加商品型号的价格输入框第一个
		public void clickCommodityModelPrice() throws Exception {
				click(commodityModelPrice);
				}			
		//向添加商品型号的型号输入框输入价格第一个
		public void typecommodityModelPrice(String price) throws Exception {
				type(commodityModelPrice,price);
				}
		
		
		//点击添加商品型号的库存输入框第一个
		public void clickCommodityModelStock() throws Exception {
				click(commodityModelStock);
					}					
		//向添加商品型号的型号输入框输入库存第一个 
		public void typecommodityModelStock(String stock) throws Exception {
				type(commodityModelStock,stock);
					}
					
////////////////////////////////////////////////////////////////////////////////////////////////
		//点击添加商品型号的型号输入框第二个
		public void clickCommodityModelModelSecond() throws Exception {
				click(commodityModelModelSecond);
			}		
		//向添加商品型号的型号输入框输入型号第二个
		public void typecommodityModelModelSecond(String model) throws Exception {
				type(commodityModelModelSecond,model);
			}
		
		
		//点击添加商品型号的编码输入框第二个
		public void clickCommodityModelCodeSecond() throws Exception {
				click(commodityModelCodeSecond);
				}				
		//向添加商品型号的型号输入框输入编码第二个
		public void typecommodityModelCodeSecond(String code) throws Exception {
				type(commodityModelCodeSecond,code);
				}		
	
		
		//点击添加商品型号的价格输入框第二个
		public void clickCommodityModelPriceSecond() throws Exception {
				click(commodityModelPriceSecond);
				}			
		//向添加商品型号的型号输入框输入价格第二个
		public void typecommodityModelPriceSecond(String price) throws Exception {
				type(commodityModelPriceSecond,price);
				}
		
		
		//点击添加商品型号的库存输入框第二个
		public void clickCommodityModelStockSecond() throws Exception {
				click(commodityModelStockSecond);
					}					
		//向添加商品型号的型号输入框输入库存第二个 
		public void typecommodityModelStockSecond(String stock) throws Exception {
				type(commodityModelStockSecond,stock);
					}

		
////////////////////////////////////////////////////////////////////////////////////////////////
//点击添加商品型号的型号输入框第三个
		public void clickCommodityModelModelThird() throws Exception {
			click(commodityModelModelThird);
}		
//向添加商品型号的型号输入框输入型号第三个
		public void typecommodityModelModelThird(String model) throws Exception {
			type(commodityModelModelThird,model);
}


//点击添加商品型号的编码输入框第三个
		public void clickCommodityModelCodeThird() throws Exception {
			click(commodityModelCodeThird);
}				
//向添加商品型号的型号输入框输入编码第三个
		public void typecommodityModelCodeThird(String code) throws Exception {
			type(commodityModelCodeThird,code);
}		


//点击添加商品型号的价格输入框第三个
		public void clickCommodityModelPriceThird() throws Exception {
			click(commodityModelPriceThird);
}			
//向添加商品型号的型号输入框输入价格第三个
		public void typecommodityModelPriceThird(String price) throws Exception {
			type(commodityModelPriceThird,price);
}


//点击添加商品型号的库存输入框第三个
		public void clickCommodityModelStockThird() throws Exception {
			click(commodityModelStockThird);
}					
//向添加商品型号的型号输入框输入库存第三个 
		public void typecommodityModelStockThird(String stock) throws Exception {
			type(commodityModelStockThird,stock);
}
		
		
		
		
		
		

		
		
		
	
		
		
		//点击添加多级型号按钮
		public void clickAddMultiBtn() throws Exception {
			click(multiCommodityModel);
		}
	
		//判断颜色按钮是否存在
		public boolean isColorBtn() throws Exception {
			return isElementExist(multiColorBtn);
		}
		//判断原产地是否存在
		public boolean isYuanchandi() throws Exception {
			return isElementExist(multiYuanchandiBtn);
		}
		//判断材质是否存在
		public boolean isCaizhi() throws Exception {
			return isElementExist(multiCaizhiBtn);
		}
	
		//判断中国是否存在
		public boolean isZhongguo() throws Exception {
			return isElementExist(zhongguoPro);
		}
		//判断美国是否存在
		public boolean isMeiguo() throws Exception {
			return isElementExist(meiguoPro);
		}
		//判断法国是否存在
		public boolean isFaguo() throws Exception {
			return isElementExist(faguoPro);
		}
		
		//判断尺寸按钮是否存在
		public boolean isSizeBtn() throws Exception {
			return isElementExist(multiSizeBtn);
		}
	
	  //点击多级商品型号页的取消按钮
		public void clickMultiCancelBtn() throws Exception {
			click(multiCancelBtn);
		}
	//判断是否回到商品信息页面
		public boolean isCommodityInfo() throws Exception {
			return isElementExist(commodityInfo);
		}
		

	//选中输入自定义型号文本框
		public void clickCustomCommodityModel() throws Exception {
			click(customCommodityModel);
				}		
	//输入自定义型号名称
		public void typeCustomCommodityModel(String cus_model) throws Exception {
			type(customCommodityModel,cus_model);
				}
   //点击自定义型号的新建按钮
		public void clickCreateCustom() throws Exception {
			click(createCustom);
				}
   //选中输入自定义属性文本框
		public void clickProCustomCommodityModel() throws Exception {
			click(proCustomCommodityModel);
		}
   //输入自定义型属性
		public void typeCreateProCustom(String pro_cus_model) throws Exception {
			type(proCustomCommodityModel,pro_cus_model);
				}		
	//点击自定义属性的新建按钮
		public void clickCreateProCustom() throws Exception {
			click(createProCustom);
						}
	//有多个属性文本框时  输入属性框1	2 3 4
		public void typeCreatePro1Custom(String pro_cus_model) throws Exception {
			type(protest1CustomCommodityModel,pro_cus_model);}
		public void typeCreatePro2Custom(String pro_cus_model) throws Exception {
			type(protest2CustomCommodityModel,pro_cus_model);}
		public void typeCreatePro3Custom(String pro_cus_model) throws Exception {
			type(protest3CustomCommodityModel,pro_cus_model);}
		public void typeCreatePro4Custom(String pro_cus_model) throws Exception {
			type(protest4CustomCommodityModel,pro_cus_model);}
	//有多个属性时，点击自定义属性的新建按钮1 2 3 4
		public void clickCreatePro1Custom() throws Exception {
			click(createPro1Custom);}
		public void clickCreatePro2Custom() throws Exception {
			click(createPro2Custom);}
		public void clickCreatePro3Custom() throws Exception {
			click(createPro3Custom);}
		public void clickCreatePro4Custom() throws Exception {
			click(createPro4Custom);}
		
   //点击勾选自定义的“原产地”型号
		public void clickMultiYuanchandiBtn() throws Exception {
			click(multiYuanchandiBtn);
		}
	 //点击勾选自定义的“中国”“美国”“法国”属性
		public void clickZhongguoPro() throws Exception {
			click(zhongguoPro);
		}
		public void clickMeiguoPro() throws Exception {
			click(meiguoPro);
		}
		public void clickFaguoPro() throws Exception {
			click(faguoPro);
		}
	//点击勾选“多级型号测试i”
		public void clicktestPro4() throws Exception {
			click(testPro4);
		}
		public void clicktestPro3() throws Exception {
			click(testPro3);
		}
		public void clicktestPro2() throws Exception {
			click(testPro2);
		}
		public void clicktestPro1() throws Exception {
			click(testPro1);
		}

	//点击勾选型号1的属性
		public void clickfirstPro1() throws Exception {
			click(firstPro1);
			}
		public void clickfirstPro2() throws Exception {
			click(firstPro2);
			}
		public void clickfirstPro3() throws Exception {
			click(firstPro3);
			}
		public void clickfirstPro4() throws Exception {
			click(firstPro4);
			}
		public void clickfirstPro5() throws Exception {
			click(firstPro5);
			}

	//点击勾选型号2的属性
		public void clicksecondPro1() throws Exception {
			click(secondPro1);
			}
		public void clicksecondPro2() throws Exception {
			click(secondPro2);
			}
		public void clicksecondPro3() throws Exception {
			click(secondPro3);
			}
		public void clicksecondPro4() throws Exception {
			click(secondPro4);
			}
		public void clicksecondPro5() throws Exception {
			click(secondPro5);
			}
	//点击勾选型号3的属性
		public void clickthirdPro1() throws Exception {
			click(thirdPro1);
			}
		public void clickthirdPro2() throws Exception {
			click(thirdPro2);
			}
		public void clickthirdPro3() throws Exception {
			click(thirdPro3);
			}
		public void clickthirdPro4() throws Exception {
			click(thirdPro4);
			}
		public void clickthirdPro5() throws Exception {
			click(thirdPro5);
			}
	//点击勾选型号4的属性
		public void clickfourthPro1() throws Exception {
			click(fourthPro1);
			}
		public void clickfourthPro2() throws Exception {
			click(fourthPro2);
			}
		public void clickfourthPro3() throws Exception {
			click(fourthPro3);
			}
		public void clickfourthPro4() throws Exception {
			click(fourthPro4);
			}
		public void clickfourthPro5() throws Exception {
			click(fourthPro5);
			}
			
			
	//点击勾选自定义的“图形”型号
		public void clickTuxingBtn() throws Exception {
			click(multiTuxingBtn);
				}
  //点击勾选自定义的“材质”型号
		public void clickCaizhiBtn() throws Exception {
			click(multiCaizhiBtn);
				}
  //点击勾选自定义的“气味”型号
		public void clickMultiQiweiBtn() throws Exception {
			click(multiQiweiBtn);
						}
  //点击勾选“颜色”型号
		public void clickMultiColorBtn() throws Exception {
			click(multiColorBtn);
								}
 //点击勾选“尺寸”型号
		public void clickMultiSizeBtn() throws Exception {
			click(multiSizeBtn);
										}
		
  //点击多级商品型号页的确定按钮
		public void clickMultiConfirmBtn() throws Exception {
			click(multiConfirmBtn);
			}

  //点击多级商品型号的鼠标事件小XX
		public void clickMouseHoverDelBtn() throws Exception {
			click(mouseHoverDelBtn);
			}
//点击属性的鼠标事件小XX
		public void clickPromouseHoverDel() throws Exception {
			click(promouseHoverDel);
			}
//点击多SKU第一个属性小XX
		public void clickMouseHoverDelFirstBtn() throws Exception {
			click(mouseHoverDelFirstBtn);
			}
 //点击鼠标事件后的删除弹框确定按钮
		public void clickMouseHoverDelConfirmBtn() throws Exception {
			click(mouseHoverDelConfirmBtn);
			}

 //判断当前页面是否存在“原产地”按钮
		public boolean existYuanchandi() throws Exception {
			return isElementExist(multiYuanchandiBtn);
		}
		
 //判断从上到下第一个按钮
		public String getFirstBtn() throws Exception {
			return getText(firstBtn);	
		}

 //判断从上到下第二个按钮
		public String getSecondBtn() throws Exception {
			return getText(secondBtn);	
		}	
 //判断从上到下第三个按钮
		public String getThirdBtn() throws Exception {
			return getText(thirdBtn);	
		}	
		
//判断从左到右第一个按钮
		public String getFirstPro() throws Exception {
			return getText(firstPro);	
		}

 //判断从左到右第二个按钮
		public String getSecondPro() throws Exception {
			return getText(secondPro);	
		}	
 //判断从左到右第三个按钮
		public String getThirdPro() throws Exception {
			return getText(thirdPro);	
		}	
		
//添加第一个商品型号图片
		public void addFirstModelPicture() throws Exception {
			type(addcommodityModelPictureFirst,System.getProperty("user.dir")+"/imgs/pic.png");
		}

//添加第二个商品型号图片
		public void addSecondModelPicture() throws Exception {
			type(addcommodityModelPictureSecond,System.getProperty("user.dir")+"/imgs/pic.png");
				}
//添加第三个商品型号图片
		public void addThirdModelPicture() throws Exception {
			type(addcommodityModelPictureThird,System.getProperty("user.dir")+"/imgs/pic.png");
						}
		
//点击第一个展开按钮
		public void clickExpandButton() throws Exception {
			click(expandButton);
		}	
		
//验证点击展开后“原产地”，“尺码”，“颜色”是否存在
		public boolean isExpandYuanchandi() throws Exception {
			return isElementExist(yuanchandi);
		}
		public boolean isExpandChima() throws Exception {
			return isElementExist(chima);
		}
		public boolean isExpandYanse() throws Exception {
			return isElementExist(yanse);
		}
		
//		public void typePriceSku11(String price) throws Exception {
//			type(priceSku1,price);
//		}
//		public void typePriceSku22(String price) throws Exception {
//			type(priceSku2,price);
//		}
//		public void typePriceSku33(String price) throws Exception {
//			type(priceSku3,price);
//		}
		//向多SKU属性输入框输入价格，库存，编码
		public void typePriceSku1(String price) throws Exception {
			type(priceSku1,price);
		}
		public void typePriceSku2(String price) throws Exception {
			type(priceSku2,price);
		}
		public void typePriceSku3(String price) throws Exception {
			type(priceSku3,price);
		}
		public void typePriceSku4(String price) throws Exception {
			type(priceSku4,price);
		}
		public void typeStockSku1(String stock) throws Exception {
			type(stockSku1,stock);
		}
		public void typeStockSku2(String stock) throws Exception {
			type(stockSku2,stock);
		}
		public void typeStockSku3(String stock) throws Exception {
			type(stockSku3,stock);
		}
		public void typeStockSku4(String stock) throws Exception {
			type(stockSku4,stock);
		}
		public void typeCodeSku1(String code) throws Exception {
			type(codeSku1,code);
		}
		public void typeCodeSku2(String code) throws Exception {
			type(codeSku2,code);
		}
		public void typeCodeSku3(String code) throws Exception {
			type(codeSku3,code);
		}
		public void typeCodeSku4(String code) throws Exception {
			type(codeSku4,code);
		}
		//库存总和
		public boolean isSumStock() throws Exception {
			return isElementExist(sumstock);
		}	
		//获取库存、销量中的文本
		public String getsumStockText() throws Exception {
			return getText(sumstock);
		}
		public String getStock1Text() throws Exception {
			return getText(stock1);
		}
		public String getStock2Text() throws Exception {
			return getText(stock2);
		}
		public String getStock3Text() throws Exception {
			return getText(stock3);
		}
		public String getStock4Text() throws Exception {
			return getText(stock4);
		}
		public String getsumSaleText() throws Exception {
			return getText(sumSale);
		}
		public String getSale1Text() throws Exception {
			return getText(sale1);
		}
		public String getSale2Text() throws Exception {
			return getText(sale2);
		}
		public String getSale3Text() throws Exception {
			return getText(sale3);
		}
		public String getSale4Text() throws Exception {
			return getText(sale4);
		}
		
		//获取批量设置中的价格，库存
		public String getpriceSkuText() throws Exception {
			return getText(batchPrice);
		}
		public String getstockSkuText() throws Exception {
			return getText(batchStock);
		}
		public String getpriceSku1Text() throws Exception {
			return getAttribute(priceSku1,"value");
		}
		public String getpriceSku2Text() throws Exception {
			return getAttribute(priceSku2,"value");
		}
		public String getpriceSku3Text() throws Exception {
			return getAttribute(priceSku3,"value");
		}
		public String getpriceSku4Text() throws Exception {
			return getAttribute(priceSku4,"value");
		}
		
		public String getstockSku1Text() throws Exception {
			return getAttribute(stockSku1,"value");
		}
		public String getstockSku2Text() throws Exception {
			return getAttribute(stockSku2,"value");
		}
		public String getstockSku3Text() throws Exception {
			return getAttribute(stockSku3,"value");
		}
		public String getstockSku4Text() throws Exception {
			return getAttribute(stockSku4,"value");
		}
		
		public boolean isBigger(int a, int b) {
			// TODO Auto-generated method stub
			if(a>=b){
		         return true;
		     }	 
			return false;
		} 
		//点击商品管理页第一个商品的“编辑”按钮
			public void clickEditOfCommodityManagementFirstBtn() throws Exception {
				click(editOfCommodityManagementFirstBtn);
					}
		//点击多SKU第一个属性
			public void clickFirstSkuProBtn() throws Exception {
				click(firstSkuProBtn);
					}
		//点击多选择商品型号的“X”按钮
			public void clickCloseMulBtn() throws Exception {
				click(closeMulBtn);
					}	
		//验证删除历史原产地后它的属性还存在在商品管理页面上 			
			public boolean existhistoryPro1() throws Exception {
				return isElementExist(historyPro1);
			}
			
			//获取商品型号选择框
			public String getMulText() throws Exception {
				return getText(mulText);
			}
			//批量设置输入价格
			public void typeBatchPrice(String batch_price) throws Exception {
				type(batchPrice,batch_price);}	
			
			//批量设置输入库存
			public void typeBatchStock(String batch_stock) throws Exception {
				type(batchStock,batch_stock);}	
			//点击“其他信息”
			public void clickQitaxinxi() throws Exception {
				click(qitaxinxi);
				}
				}
	
