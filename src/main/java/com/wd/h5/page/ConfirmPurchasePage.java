package com.wd.h5.page;

import com.wd.libarary.BasePage;
import com.wd.libarary.Locator;
import org.openqa.selenium.WebDriver;
import com.wd.libarary.Locator.ByType;
import sun.misc.*;

import java.io.IOException;
import java.io.PushbackInputStream;

/**
 * Created by ike on 16/8/26.
 * 确认购买页面
 */
public class ConfirmPurchasePage extends BasePage {

    WebDriver driver;

    String pageUrl = "https://weidian.com/item.html?itemID=65090056";

    // 提交订单
    Locator submitOrderButton = new Locator("submit_order");
    // 确认购买title
    Locator cptitle = new Locator("#common_hd > h1", ByType.cssSelector);
    // 请填写收货地址
    Locator noneAddressButton = new Locator("none_address");
    // 快速登录
    Locator quickLogin = new Locator("hd_edit");
    // 立即购买
    Locator buyNow = new Locator("buy_now");
    // 支付宝
    Locator alipay = new Locator("ALIPAY");
    // 立即支付
    Locator doPay = new Locator("doPay");
    // 支付宝登录
    Locator alipayLogin = new Locator("支付宝账户登录", ByType.linkText);
    // 支付宝用户名 logon_id
    Locator logon_id = new Locator("logon_id");
    // 支付宝密码
    Locator pwd_unencrypt = new Locator("pwd_unencrypt");
    // 支付吧下一步
    Locator nextStep = new Locator("#cashier > div.am-section > div > button", ByType.cssSelector);
    // 确认付款
    Locator confirmCashier = new Locator("#cashierPreConfirm > div.am-section > button", ByType.cssSelector);
    // 订单价格
    Locator orderPrice = new Locator("last_money_show");
    // 商品名称
    Locator itemName = new Locator("#i_ul > li > h2", ByType.cssSelector);
    // 收银台文案
    Locator payTitle = new Locator("itemTitle", ByType.cssSelector);
    // 货到付款
    Locator payCODButton = new Locator("p_id_COD");
    // 货到付款订单成功
    Locator codOrderSuccess = new Locator("#paySuccess > h1 > span:nth-child(2)", ByType.cssSelector);

    // 我知道了
    Locator _confirm_btnB = new Locator("_confirm_btnB");
    // 获取订单号
    Locator orderID = new Locator("#orderID > span.default", ByType.cssSelector);
    // 支付宝支付完成
    Locator finish = new Locator("body > header > a", ByType.cssSelector);


    // 货到付款订单成功文案
    public String getCODOrderSuccessText() throws Exception {
        return getText(codOrderSuccess);
    }

    // 点击货到付款
    public void clickPayCODButton() throws Exception {
        click(payCODButton);
    }

    // 获取登录文案
    public String getLoginStatusText() throws Exception {
        return getText(quickLogin);
    }

    // 获取收银台文案
    public String getPayTitle() throws Exception {
        return getText(payTitle);
    }

    // 获取商品名称
    public String getItemName() throws Exception {
        return getText(itemName);
    }

    // 获取订单价格
    public String getItemPrice() throws Exception {
        return getText(orderPrice);
    }

    // 确认购买title存在
    public boolean isCPTitle() throws IOException {
        return isElementExist(cptitle);
    }

    // 获取退出登录文案
    public String getSignOutText() throws Exception {
        return getText(quickLogin);
    }

    public void clickFinish() throws Exception {
        click(finish);
    }

    // 获取订单号
    public String getOrderID() throws Exception {
        return getText(orderID);
    }

    // 点击我知道了
    public void click_confirm_btnB() throws Exception {
        click(_confirm_btnB);
    }

    // 点击确认付款
    public void clickConfirmCashier() throws Exception {
        click(confirmCashier);
    }

    // 点击下一步
    public void clickNextStep() throws Exception {
        click(nextStep);
    }

    public void typepwd_unencrypt() throws Exception {
        type(pwd_unencrypt, getBase("OTAwODIx"));
    }

    public void typelogon_id() throws Exception {
        type(logon_id, getBase("MTAwNTM4MTM1NEBxcS5jb20="));
    }

    // 点击立即支付
    public void clickAlipayLogin() throws Exception {
        click(alipayLogin);
    }

    // 获取立即支付
    public boolean isDoPay() throws IOException {
        return isElementExist(doPay);
    }

    // 点击立即支付
    public void clickDoPay() throws Exception {
        click(doPay);
    }

    // 点击支付宝
    public void clickAlipay() throws Exception {
        click(alipay);
    }

    // 点击立即购买
    public void clickBuyNow() throws Exception {
        click(buyNow);
    }

    // 点击去付款
    public void clickSubmitOrderButton() throws Exception {
        click(submitOrderButton);
    }

    // 点击请填写收货地址
    public void clickNoneAddressButton() throws Exception {
        click(noneAddressButton);
    }

    // 点击快速登录
    public void clickQuickLogin() throws Exception {
        click(quickLogin);
    }

    public ConfirmPurchasePage(WebDriver driver) throws Exception {
        super(driver);
    }

    // 请勿解密
    public String getBase(String s) {

        byte[] b = null;
        java.lang.String result = null;
        if (s != null) {
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                b = decoder.decodeBuffer(s);
                result = new java.lang.String(b, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;

    }

    public String getPageUrl() {
        return pageUrl;
    }
    @Override
    public WebDriver getDriver() {
        return driver;
    }

    @Override
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
