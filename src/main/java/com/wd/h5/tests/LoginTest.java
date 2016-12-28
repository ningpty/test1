package com.wd.h5.tests;


import com.wd.h5.action.ShopAction;
import com.wd.h5.page.LoginPage;
import com.wd.h5.page.ShopPage;
import com.wd.libarary.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.wd.h5.action.LoginAction;
import org.testng.annotations.Test;


@Listeners({TestNGListener.class})
public class LoginTest extends UITest {

    // 获取driver
    WebDriver driver = DriverFactory.getRemoteDriver(new RemoteBrowserBean("chrome"));// 远程driver
//	WebDriver driver = DriverFactory.getChromeDriver(); // 本地
//	WebDriver driver = DriverFactory.getMobileForChromeRemoteDriver();

    @BeforeMethod(alwaysRun = true)
//	@BeforeClass(alwaysRun = true)
    public void init() {
        super.init(driver);
        LoginAction.setDriver(driver);
//		ShopAction.setDriver(driver);
    }

    @Test(groups = {"LoginTest"}, description = "验证登录页面title/下一步文案")
    public void loginPageTelTextCheck() throws Exception {
        LoginAction.loginPageTelTextCheck();
        Reporter.log("验证登录页面title/下一步文案");
    }

    @Test(groups = {"LoginTest"}, description = "验证登录页面手机号码不足11位提示文案")
    public void loginPageTelCheck() throws Exception {
        LoginAction.loginPageTelCheck();
        Reporter.log("验证登录页面手机号码不足11位提示文案");
    }

    @Test(groups = {"LoginTest"}, description = "验证密码页面title/下一步文案")
    public void loginPagePWTextCheck() throws Exception {
        LoginAction.loginPagePWTextCheck();
        Reporter.log("验证密码页面title/下一步文案");
    }

    @Test(groups = {"LoginTest"}, description = "验证登陆更换手机号码-输入密码页面")
    public void loginPageChangeTelCheck01() throws Exception {
        LoginAction.loginPageChangeTelCheck01();
        Reporter.log("验证登陆更换手机号码-输入密码页面");
    }

//	@Test(groups = {"LoginTest"}, description = "验证登陆更换手机号码-填写验证码,设置密码页面")
//	public void loginPageChangeTelCheck02() throws Exception {
//		LoginAction.loginPageChangeTelCheck02();
//	}

    @Test(groups = {"LoginTest"}, description = "验证忘记密码按钮")
    public void loginPageForgetPasswordCheck() throws Exception {
        LoginAction.loginPageForgetPasswordCheck();
        Reporter.log("验证忘记密码按钮");
    }

    @Test(groups = {"LoginTest"}, description = "店铺页面收藏登陆")
    public void loginViaShopFavorite() throws Exception {
        LoginAction.loginViaShopFavorite();
        Reporter.log("店铺页面收藏登陆");
    }

    @Test(groups = {"LoginTest"}, description = "店铺页面Im登陆")
    public void loginViaShopIm() throws Exception {
        LoginAction.loginViaShopIm();
        Reporter.log("店铺页面Im登陆");
    }

    @Test(groups = {"LoginTest"}, description = "店铺页面优惠劵登陆")
    public void loginViaShopCoupon() throws Exception {
        LoginAction.loginViaShopCoupon();
        Reporter.log("店铺页面优惠劵登陆");
    }

    @Test(groups = {"LoginTest"}, description = "商品页面优惠劵登录")
    public void loginViaGoodsCoupon() throws Exception {
        LoginAction.loginViaGoodsCoupon();
        Reporter.log("商品页面优惠劵登录");
    }

    @Test(groups = {"LoginTest"}, description = "商品页面收藏登录")
    public void loginViaGoodsFavorite() throws Exception {
        LoginAction.loginViaGoodsFavorite();
        Reporter.log("商品页面收藏登录");
    }

    @Test(groups = {"LoginTest"}, description = "商品页面我要提问登录")
    public void loginViaAsk() throws Exception {
        LoginAction.loginViaAsk();
        Reporter.log("商品页面我要提问登录");
    }

    // -------------------------订单中心-------------------------------------

    @Test(groups = {"LoginTest"}, description = "订单中心登录")
    public void loginByUerName() throws Exception {
        LoginAction.viewloginPage();
        Reporter.log("订单中心登录");
    }

    @Test(groups = {"LoginTest"}, description = "订单中心--待付款登陆")
    public void loginViaOrderCenterWaitPay() throws Exception {
        LoginAction.loginViaOrderCenterWaitPay();
        Reporter.log("订单中心--待付款登陆");
    }

    @Test(groups = {"LoginTest"}, description = "订单中心--待发货订单")
    public void loginViaOrderCenterWaitSend() throws Exception {
        LoginAction.loginViaOrderCenterWaitSend();
        Reporter.log("订单中心--待发货订单");
    }

    @Test(groups = {"LoginTest"}, description = "订单中心--待收货订单")
    public void loginViaOrderCenterWaitConfirm() throws Exception {
        LoginAction.loginViaOrderCenterWaitConfirm();
        Reporter.log("订单中心--待收货订单");
    }

    @Test(groups = {"LoginTest"}, description = "订单中心--待评价订单")
    public void loginViaOrderCenterWaitRate() throws Exception {
        LoginAction.loginViaOrderCenterWaitRate();
        Reporter.log("订单中心--待评价订单");
    }

    @Test(groups = {"LoginTest"}, description = "订单中心--待退款订单")
    public void loginViaOrderCenterReturn() throws Exception {
        LoginAction.loginViaOrderCenterReturn();
        Reporter.log("订单中心--待退款订单");
    }

    @Test(groups = {"LoginTest"}, description = "订单中心--Im")
    public void loginViaOrderCenterIm() throws Exception {
        LoginAction.loginViaOrderCenterReturn();
        Reporter.log("订单中心--Im");
    }

    // -------------------------------确认下单页面登录-----------------------------------
    @Test(groups = {"LoginTest"}, description = "确认订单页--去购买登录")
    public void loginViaPurchaseSubmitOrder() throws Exception {
        LoginAction.loginViaPurchaseSubmitOrder();
        Reporter.log("确认订单页--去购买登录");
    }

    @Test(groups = {"LoginTest"}, description = "确认订单页--收货地址")
    public void loginViaPurchaseAddress() throws Exception {
        LoginAction.loginViaPurchaseAddress();
        Reporter.log("确认订单页--收货地址");
    }

    @Test(groups = {"LoginTest"}, description = "确认订单页--快速登录")
    public void loginViaPurchaseQuickLogin() throws Exception {
        LoginAction.loginViaPurchaseQuickLogin();
        Reporter.log("确认订单页--快速登录");
    }


    @AfterClass(alwaysRun = true)
    public void stop() {
        super.stop();
    }

}
