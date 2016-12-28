package com.wd.h5.page;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.wd.libarary.BasePage;
import com.wd.libarary.Locator;
import com.wd.libarary.Locator.ByType;
import org.openqa.selenium.WebElement;


public class OrderCenterPage extends BasePage {

    String pageUrl = "https://i.weidian.com/index.php";

    // 退出登录按钮
    Locator signOut = new Locator("signOut");
    // 查看全部订单
    Locator allOrdersButton = new Locator("span.view-all-orders", ByType.cssSelector);
    // 待付款订单
    Locator orderWaitPay = new Locator("orderWaitPay");
    // 待发货订单
    Locator orderWaitSend = new Locator("orderWaitSend");
    // 待收货订单
    Locator orderWaitConfirm = new Locator("orderWaitConfirm");
    // 待评价订单
    Locator orderWaitRate = new Locator("orderWaitRate");
    // 待退款订单
    Locator orderReturn = new Locator("orderReturn");
    // 收藏商品
    Locator favoriteGoods = new Locator("a.tlist1.iconfont.J-login", ByType.cssSelector);
    // 收藏店铺
    Locator favoriteShop = new Locator("a.tlist2.iconfont.J-login", ByType.cssSelector);
    // 发现好货
    Locator findGoods = new Locator("a.tlist3.iconfont.J-login", ByType.cssSelector);
    // 购物车
    Locator cart = new Locator("a.tlist4.iconfont.J-nologin", ByType.cssSelector);
    // 搜索
    Locator find = new Locator("a.tlist5.iconfont.J-nologin", ByType.cssSelector);
    // 优惠劵
    Locator coupon = new Locator("a.tlist6.iconfont.J-login", ByType.cssSelector);
    // 收货地址
    Locator deliveryAddress = new Locator("a.tlist7.iconfont.J-login", ByType.cssSelector);
    // 我的银行卡
    Locator bankCard = new Locator("a.tlist8.iconfont.J-login", ByType.cssSelector);
    // im
    Locator orderCenterIm = new Locator("a.iconfont.icon-chat.J-login", ByType.cssSelector);
    // login
    Locator login = new Locator("login");
    // 全部订单列表
    Locator allOrdersList = new Locator("#js_orderList > div:nth-child(1) > nav", ByType.cssSelector);
    // 待付款列表
    Locator waitpaygoodsList = new Locator("#js_orderList > div:nth-child(2) > nav", ByType.cssSelector);
    // 待发货列表
    Locator waitsendgoodsList = new Locator("#js_orderList > div:nth-child(3) > nav", ByType.cssSelector);
    // 待收货列表
    Locator waitConfirmOrderList = new Locator("#js_orderList > div:nth-child(4) > nav", ByType.cssSelector);
    // 待评价
    Locator waitRateOrderList = new Locator("#js_orderList > div:nth-child(5) > nav", ByType.cssSelector);
    // 待付款订单角标
    Locator waitPayReminder = new Locator("#orderWaitPay > span:nth-child(3)", ByType.cssSelector);
    // 待发货订单角标
    Locator waitSendReminder = new Locator("#orderWaitSend > span:nth-child(3)", ByType.cssSelector);
    // 待收货订单角标
    Locator waitConfirmReminder = new Locator("#orderWaitConfirm > span:nth-child(3)", ByType.cssSelector);
    // 待评价订单角标
    Locator waitRateReminder = new Locator("#orderWaitRate > span:nth-child(3)", ByType.cssSelector);
    // 待付款列表中"没有相关订单"状态
    Locator noorders = new Locator("#js_orderList > div:nth-child(2) > div > p", ByType.cssSelector);
    // 待发货列表中"没有相关订单"状态
    Locator waitSendNoOrder = new Locator("#js_orderList > div:nth-child(3) > div > p", ByType.cssSelector);
    // 待确认付款列表中"没有相关订单"状态
    Locator waitConfirmNoOrder = new Locator("#js_orderList > div:nth-child(4) > div > p", ByType.cssSelector);
    // 待确认列表中"没有相关订单"状态
    Locator waitRateNoOrder = new Locator("#js_orderList > div:nth-child(5) > div > p", ByType.cssSelector);



    //-------------------------------------订单列表页面相关元素
// 获取待付款列表中"未付款"状态
    Locator waitpay = new Locator("span.right.color-red", ByType.cssSelector);
    public String getwaitpaystatus() throws Exception {
        return getText(waitpay);
    }


    public String getnoordersstatus() throws Exception {
        return getText(noorders);
    }

    // 获取全部订单列表
    public List<WebElement> getAllOrdersList() {
        return getWebElements(allOrdersList);
    }

    // 获取待收货订单列表
    public List<WebElement> getWaitConfirmOrderList() {
        return getWebElements(waitConfirmOrderList);
    }

    // 获取待评价订单列表
    public List<WebElement> getWaitRateOrderList() {
        return getWebElements(waitRateOrderList);
    }

    // 获取待发货无订单文案
    public String getWaitSendNoOrderText() throws Exception {
        return getText(waitSendNoOrder);
    }

    // 获取待确认无订单文案
    public String getWaitConfirmNoOrderText() throws Exception {
        return getText(waitConfirmNoOrder);
    }

    // 获取待发货无订单文案
    public String getWaitRateNoOrderText() throws Exception {
        return getText(waitRateNoOrder);
    }

    // 获取待评价订单角标熟悉
    public String getWaitRateReminder() throws Exception {
        return getAttribute(waitRateReminder, "class");
    }

    // 获取待确认订单角标熟悉
    public String getWaitConfirmReminder() throws Exception {
        return getAttribute(waitConfirmReminder, "class");
    }

    // 获取待发货订单角标熟悉
    public String getWaitSendReminder() throws Exception {
        return getAttribute(waitSendReminder, "class");
    }

    // 获取待付款订单角标熟悉
    public String getWaitPayReminder() throws Exception {
        return getAttribute(waitPayReminder, "class");
    }

    // 判断无订单提示文案是否存在
    public boolean isNoOrderStatus() throws Exception {
        return isElementExist(noorders);
    }

    //获取待付款列表订单上店铺名称
    Locator ordershopname = new Locator("a.left.chevron-left", ByType.cssSelector);
    public String getordertitle() throws Exception{
        return getText(ordershopname);
    }
    //点击待付款列表店铺名称
    public void clickwaitordertitle() throws Exception{
        click(ordershopname);
    }

    //获取待付款列表订单上商品名称
    Locator waitordergoodname = new Locator("span.p-name.color-dark", ByType.cssSelector);
    public String getordergoodsname() throws Exception{
        return getText(waitordergoodname);
    }

    //点击待付款订单商品名称
    public void clickwaitordergoods() throws Exception{
        click(waitordergoodname);
    }

    //获取待订单详情名称
    Locator orderdetails = new Locator("#common_hd > h1", ByType.cssSelector);
    public String getorderdetailname() throws Exception{
        return getText(orderdetails);

    }

    //获取关闭按钮
    Locator waitorderclosebutton = new Locator("span.btn.btncancel.btncloseOrder", ByType.cssSelector);
    public String getwaitorderclosebutton() throws Exception{
        return getText(waitorderclosebutton);
    }

    //点击关闭按钮
    public void clickwaitorderclosebutton() throws Exception{
        click(waitorderclosebutton);
    }

    //获取关闭原因
    Locator waitorderclosereson = new Locator("#closeOrderFloat > div > ul > li:nth-child(1)", ByType.cssSelector);
    public String getwaitorderclosereson() throws Exception{
        return getText(waitorderclosereson);
    }

    //点击关闭原因
    public void clickwaitorderclosereson() throws Exception{
        click(waitorderclosereson);
    }

    //获取待付款角标数量
    Locator WaitPaySum = new Locator("#orderWaitPay > span.reminder", ByType.cssSelector);
    public String getWaitPaySum() throws Exception{
        return getText(WaitPaySum);
    }

    //获取待付款列表元素
    public List<WebElement> getWaitpayList() {
        return getWebElements(waitpaygoodsList);
    }

    //获取待付款列表元素
    public List<WebElement> getWaitsendList() {
        return getWebElements(waitsendgoodsList);
    }

    //---------------------------------------待评价列表
    // 获取待付款列表中"待评价"状态
    Locator waitevaluate = new Locator("span.right.color-red", ByType.cssSelector);
    public String getwaitevaluate() throws Exception {
        return getText(waitevaluate);
    }

    //获取待评价列表元素
    public List<WebElement> getWaitevaluateList() {
        return getWebElements(waitRateOrderList);
    }

    //获取待评价角标数量
    Locator WaitevaluateSum = new Locator("#orderWaitRate > span.reminder", ByType.cssSelector);
    public String getWaitevaluateSum() throws Exception{
        return getText(WaitevaluateSum);
    }


    //获取待评价列表订单上店铺名称
    Locator evaluateshopname = new Locator("a.left.chevron-left", ByType.cssSelector);
    public String getevaluateshopname() throws Exception{
        return getText(evaluateshopname);
    }
    //点击待评价列表店铺名称
    public void clickevaluateshopname() throws Exception{
        click(evaluateshopname);
    }

    //获取待评价列表订单上商品名称
    Locator evaluateordergoods = new Locator("span.p-name.color-dark", ByType.cssSelector);
    public String getevaluateordergoods() throws Exception{
        return getText(evaluateordergoods);
    }

    //点击待评价订单商品名称
    public void clickevaluateordergoods() throws Exception{
        click(evaluateordergoods);
    }

    //-----------------------------待发货列表
    // 获取待发货列表中"待发货"状态
    Locator waitsends = new Locator("span.right.color-red", ByType.cssSelector);
    public String getwaitsendsstatus() throws Exception {
        return getText(waitsends);
    }

    //获取待发货列表元素
    public List<WebElement> getWaitsendsList() {
        return getWebElements(waitsendgoodsList);
    }

    //获取待发货角标数量
    Locator WaitsendSum = new Locator("#orderWaitConfirm > span.reminder", ByType.cssSelector);
    public String getWaitsendSum() throws Exception{
        return getText(WaitsendSum);
    }

    //获取待发货列表订单上店铺名称
    Locator waitsendshopname = new Locator("a.left.chevron-left", ByType.cssSelector);
    public String getwaitsendshopname() throws Exception{
        return getText(waitsendshopname);
    }
    //点击待发货列表店铺名称
    public void clickwaitsendshopname() throws Exception{
        click(waitsendshopname);
    }

    //获取待发货列表订单上商品名称的
    Locator waitsendordergoods = new Locator("span.p-name.color-dark", ByType.cssSelector);
    public String getwaitsendordergoods() throws Exception{
        return getText(waitsendordergoods);
    }

    //点击待发货订单商品名称
    public void clickwaitsendordergoods() throws Exception{
        click(waitsendordergoods);
    }

    //-----------------------------待收货列表
    // 获取待发货列表中"待收货"状态
    Locator waitreceived = new Locator("span.right.color-red", ByType.cssSelector);
    public String getwaitreceivedstatus() throws Exception {
        return getText(waitreceived);
    }

    //获取待发货列表元素
    public List<WebElement> getWaitreceivedList() {
        return getWebElements(waitConfirmOrderList);
    }

    //获取待发货角标数量
    Locator WaitreceivedSum = new Locator("#orderWaitConfirm > span.reminder", ByType.cssSelector);
    public String getWaitreceivedSum() throws Exception{
        return getText(WaitreceivedSum);
    }

    //获取待发货列表订单上店铺名称
    Locator waitreceivedhopname = new Locator("a.left.chevron-left", ByType.cssSelector);
    public String getwaitreceivedhopname() throws Exception{
        return getText(waitreceivedhopname);
    }
    //点击待发货列表店铺名称
    public void clickwaitreceivedshopname() throws Exception{
        click(waitreceivedhopname);
    }

    //获取待发货列表订单上商品名称
    Locator waitreceivedgoods = new Locator("span.p-name.color-dark", ByType.cssSelector);
    public String getwaitreceivedgoods() throws Exception{
        return getText(waitreceivedgoods);
    }

    //点击待发货订单商品名称
    public void clickwaitreceivedgoods() throws Exception{
        click(waitreceivedgoods);
    }



    //----------------------------------------------------------地址页面的相关元素获取
// 删除地址按钮
    Locator delectAddressButton = new Locator("a.delect.js_delect",ByType.cssSelector);

    // 删除按钮确认框:取消/确认
    Locator AddressCancelButton = new Locator("_confirm_btnA");
    Locator AddressConfirmButton = new Locator("_confirm_btnB");


    public OrderCenterPage(WebDriver driver) throws Exception {
        super(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    // 登录
    public void clickLogin() throws Exception {
        click(login);
    }

    // 回去退出登陆
    public String getSignOutText() throws Exception {
        return getText(signOut);
    }

    // 点击Im
    public void clickOrderCenterIm() throws Exception {
        click(orderCenterIm);
    }

    // 点击我的银行卡
    public void clickBankCard() throws Exception {
        click(bankCard);
    }

    // 点击收货地址
    public void clickDeliveryAddress() throws Exception {
        click(deliveryAddress);
    }

    // 点击优惠劵
    public void clickCoupon() throws Exception {
        click(coupon);
    }

    // 点击搜索
    public void clickFind() throws Exception {
        click(find);
    }

    // 点击购物车
    public void clickCart() throws Exception {
        click(cart);
    }

    // 点击发现好货
    public void clickFindGoods() throws Exception {
        click(findGoods);
    }

    // 点击收藏店铺
    public void clickFavoriteShop() throws Exception {
        click(favoriteShop);
    }

    // 点击收藏商品
    public void clickFavoriteGoods() throws Exception {
        click(favoriteGoods);
    }

    // 点击退款订单
    public void clickOrderReturn() throws Exception {
        click(orderReturn);
    }

    // 点击待评价订单
    public void clickOrderWaitRate() throws Exception {
        click(orderWaitRate);
    }

    // 点击待收货订单
    public void clickOrderWaitConfirm() throws Exception {
        click(orderWaitConfirm);
    }

    // 点击待发货订单
    public void clickOrderWaitSend() throws Exception {
        click(orderWaitSend);
    }

    // 点击待付款订单
    public void clickOrderWaitPay() throws Exception {
        click(orderWaitPay);
    }

    // 判断登陆,退出按钮存在
    public boolean isPrestentProfile() throws IOException {
        return isElementPresent(signOut, 10);

    }

    // 点击退出登录按钮
    public void clickSignOutButton() throws Exception {
        click(signOut);
    }

    //单击查看全部订单按钮
    public void clickAllOrdersButton() throws Exception {
        click(allOrdersButton);
    }

    public String getPageUrl() {
        return pageUrl;
    }
    //删除地址按钮
    public void clickdelectAddressButton() throws Exception{
        click(delectAddressButton);
    }
    //是否删除该收获地址:取消
    public void clickAddressCancelButton() throws Exception{
        click(AddressCancelButton);
    }
    //是否删除该收货地址:确认
    public void clickAddressConfirmButton() throws Exception{
        click(AddressConfirmButton);
    }

}
