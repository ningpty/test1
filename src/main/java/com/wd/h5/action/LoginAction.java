package com.wd.h5.action;

import com.wd.h5.page.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Created by ike on 16/7/29.
 *
 * 有一个问题,还是每一条用例会打开url,会增加一些测试时间
 * 如果不设置,需要设置一个@before 或者每一个执行用例之前做一个检查. 貌似差不多.
 *
 *
 */
public class LoginAction {

    private static WebDriver driver;
    private static String shopUrl = "http://weidian.com/?userid=3073080";
    private static String goodsUrl = "http://weidian.com/item.html?itemID=65090056";
    private static String orderCerterUrl = "http://i.weidian.com/index.php";


    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        LoginAction.driver = driver;
    }


    // ----------------------------------登陆功能--------------------------------------

    // 验证登录页面title/下一步文案
    public static void loginPageTelTextCheck() throws Exception {
        driver.get(orderCerterUrl);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.switchToLogin();
        Thread.sleep(2000);
        loginPage.switchToIframe(); // 切换到iframe 已经取消
        Assert.assertEquals(loginPage.getLoginTitleText(), "输入手机号 登录/注册微店", "登录页面title不正确");
        Assert.assertEquals(loginPage.getTeleSubmitText(), "下一步", "登录下一步按钮不存在");
    }

    // 验证登录页面手机号码不足11位提示文案
    public static void loginPageTelCheck() throws Exception {
        driver.get(orderCerterUrl);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.switchToLogin();
        loginPage.typePhoneNoInputBox("111111111");
        Thread.sleep(1000);
        Assert.assertFalse(loginPage.isElementExist(), "手机号位数校验失败");
        loginPage.clickOnNextButton();
        // 由于无法获取弹出文案
        Assert.assertTrue(loginPage.isElementExist(), "手机号位数校验失败");
    }

    // 验证密码页面title/下一步文案
    public static void loginPagePWTextCheck() throws Exception {
        driver.get(orderCerterUrl);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.switchToLogin();
        Thread.sleep(2000);
        loginPage.typePhoneNoInputBox("13161133886");
        loginPage.clickOnNextButton();
        Thread.sleep(2000);
//        loginPage.switchToIframe();
        Assert.assertEquals(loginPage.getLoginShowTeleText(), "+86 13161133886", "登录手机号码不正确");
        Assert.assertEquals(loginPage.getRegiTitleText(), "号码已注册，请直接登录", "密码页面title不正确");
        Assert.assertEquals(loginPage.getLoginSubmitText(), "登录", "登录按钮不存在");
//        Assert.assertTrue(loginPage.isChangeTeleLink(), "更换手机号不存在");
//        Assert.assertTrue(loginPage.isForgetPasswordLink(), "忘记密码不存在");
    }

    // 验证登陆更换手机号码-输入密码页面
    public static void loginPageChangeTelCheck01() throws Exception {
        driver.get(orderCerterUrl);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.switchToLogin();
        loginPage.typePhoneNoInputBox("13161133886");
        Thread.sleep(1000);
        loginPage.clickOnNextButton();
        Assert.assertEquals(loginPage.getLoginShowTeleText(), "+86 13161133886", "登录手机号码不正确");
        loginPage.clickChangeTeleLink();
        Thread.sleep(2000);
        loginPage.typePhoneNoInputBox02("13161790208");
        loginPage.clickOnNextButton();
        Thread.sleep(3000);// 测试多次时,会出现获取验证码次数过多提示,增加时间来保证提示消失.
        Assert.assertEquals(loginPage.getLoginShowTeleText(), "+86 13161790208", "更换手机号码失败");
    }

    // 验证登陆更换手机号码-填写验证码,设置密码页面
//    public static void loginPageChangeTelCheck02() throws Exception {
//        driver.get(orderCerterUrl);
//        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
//        loginPage.switchToLogin();
//        loginPage.typePhoneNoInputBox("13161133886");
//        Thread.sleep(1000);
//        loginPage.clickOnNextButton();
//        loginPage.clickForgetPasswordLink();
//        Thread.sleep(2000);
//        loginPage.clickChangeTeleLink();
//        loginPage.typePhoneNoInputBox02("13161790208");
//        loginPage.clickOnNextButton();
//        Assert.assertEquals(loginPage.getLoginShowTeleText(), "+86 13161790208", "更换手机号码失败");
//    }

    // 验证忘记密码按钮    如果有多次忘记密码 >5次 case 可能会failed
    public static void loginPageForgetPasswordCheck() throws Exception {
        driver.get(orderCerterUrl);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.switchToLogin();
        loginPage.typePhoneNoInputBox("13161790208");
        Thread.sleep(1000);
        loginPage.clickOnNextButton();
        loginPage.clickForgetPasswordLink();
        Thread.sleep(2000);
        Assert.assertEquals(loginPage.getNoRegiTitleText(), "填写验证码，并设置密码", "忘记密码页面跳转失败");
    }

    // ----------------------------------店铺页面登陆----------------------------------------

    // 店铺页面收藏登录
    public static void loginViaShopFavorite() throws Exception {
        CommonLogin.setDriver(driver);
        driver.get(shopUrl);
        ShopPage shopPage = PageFactory.initElements(driver, ShopPage.class);
        shopPage.clickFavoriteButton();
        CommonLogin.login();
        shopPage.clickOrderCenterButton();
        OrderCenterPage orderCenterPage = PageFactory.initElements(driver, OrderCenterPage.class);
        Assert.assertEquals(orderCenterPage.getSignOutText(), "退出登录", "登陆失败");
        orderCenterPage.clickSignOutButton();
    }

    // 店铺页面im登录
    public static void loginViaShopIm() throws Exception {
        driver.get(shopUrl);
        CommonLogin.setDriver(driver);
        ShopPage shopPage = PageFactory.initElements(driver, ShopPage.class);
        Thread.sleep(1000);
        shopPage.clickImButton();
        CommonLogin.login();
        Thread.sleep(2000);
        Assert.assertTrue(shopPage.userInfoIsExist(), "登录失败");
        shopPage.clickhd_backButton();
        shopPage.clickhd_backButton();
        shopPage.clickOrderCenterButton();
        OrderCenterPage orderCenterPage = PageFactory.initElements(driver, OrderCenterPage.class);
        Assert.assertEquals(orderCenterPage.getSignOutText(), "退出登录", "登陆失败");
        orderCenterPage.clickSignOutButton();
    }

    // 店铺页面优惠劵登录
    public static void loginViaShopCoupon() throws Exception {
        CommonLogin.setDriver(driver);
        driver.get(shopUrl);
        ShopPage shopPage = PageFactory.initElements(driver, ShopPage.class);
        shopPage.clickCouponButton();
        CommonLogin.login();
        shopPage.clickOrderCenterButton();
        OrderCenterPage orderCenterPage = PageFactory.initElements(driver, OrderCenterPage.class);
        Assert.assertEquals(orderCenterPage.getSignOutText(), "退出登录", "登陆失败");
        orderCenterPage.clickSignOutButton();
    }

    // --------------------------------------商品页面登陆-------------------------------------

    // 商品页面优惠劵登录
    public static void loginViaGoodsCoupon() throws Exception {
        CommonLogin.setDriver(driver);
        driver.get(goodsUrl);
        GoodsPage goodsPage = PageFactory.initElements(driver, GoodsPage.class);
        goodsPage.clickCouponButton();
        CommonLogin.login();
        goodsPage.clickOrderCenterButton();
        OrderCenterPage orderCenterPage = PageFactory.initElements(driver, OrderCenterPage.class);
        Assert.assertEquals(orderCenterPage.getSignOutText(), "退出登录", "登陆失败");
        orderCenterPage.clickSignOutButton();
    }

    // 商品页面收藏登录
    public static void loginViaGoodsFavorite() throws Exception {
        driver.get(goodsUrl);
        CommonLogin.setDriver(driver);
        GoodsPage goodsPage = PageFactory.initElements(driver, GoodsPage.class);
        goodsPage.clickFavoriteButton();
        CommonLogin.login();
        goodsPage.clickOrderCenterButton();
        OrderCenterPage orderCenterPage = PageFactory.initElements(driver, OrderCenterPage.class);
        Assert.assertEquals(orderCenterPage.getSignOutText(), "退出登录", "登陆失败");
        orderCenterPage.clickSignOutButton();
    }

    // 商品页面我要提问登录
    public static void loginViaAsk() throws Exception {
        CommonLogin.setDriver(driver);
        driver.get(goodsUrl);
        GoodsPage goodsPage = PageFactory.initElements(driver, GoodsPage.class);
        goodsPage.clickIWantToAskButton();
        CommonLogin.login();
        goodsPage.clickhd_backButton();
        goodsPage.clickhd_backButton();
        Thread.sleep(2000);
        goodsPage.clickOrderCenterButton();
        OrderCenterPage orderCenterPage = PageFactory.initElements(driver, OrderCenterPage.class);
        Assert.assertEquals(orderCenterPage.getSignOutText(), "退出登录", "登陆失败");
        orderCenterPage.clickSignOutButton();
    }

    // -----------------------------------订单中心登陆--------------------------------------

    // 订单中心登录
    public static void viewloginPage() throws Exception {
        CommonLogin.setDriver(driver);
        driver.get(orderCerterUrl);
        OrderCenterPage orderCenterPage = PageFactory.initElements(driver, OrderCenterPage.class);
        orderCenterPage.clickLogin();
        CommonLogin.login();
        Thread.sleep(2000);
        Assert.assertEquals(orderCenterPage.getSignOutText(), "退出登录", "登陆失败");
        orderCenterPage.clickSignOutButton();
    }

    // 订单中心--待付款登陆
    public static void loginViaOrderCenterWaitPay() throws Exception {
        CommonLogin.setDriver(driver);
        driver.get(orderCerterUrl);
        OrderCenterPage orderCenterPage = PageFactory.initElements(driver, OrderCenterPage.class);
        orderCenterPage.clickOrderWaitPay();
        CommonLogin.login();
        Thread.sleep(2000);
        Assert.assertEquals(orderCenterPage.getSignOutText(), "退出登录", "登陆失败");
        orderCenterPage.clickSignOutButton();
    }

    // 订单中心--待发货订单
    public static void loginViaOrderCenterWaitSend() throws Exception {
        CommonLogin.setDriver(driver);
        driver.get(orderCerterUrl);
        OrderCenterPage orderCenterPage = PageFactory.initElements(driver, OrderCenterPage.class);
        orderCenterPage.clickOrderWaitSend();
        CommonLogin.login();
        Thread.sleep(2000);
        Assert.assertEquals(orderCenterPage.getSignOutText(), "退出登录", "登陆失败");
        orderCenterPage.clickSignOutButton();
    }

    // 订单中心--待收货订单
    public static void loginViaOrderCenterWaitConfirm() throws Exception {
        CommonLogin.setDriver(driver);
        driver.get(orderCerterUrl);
        OrderCenterPage orderCenterPage = PageFactory.initElements(driver, OrderCenterPage.class);
        orderCenterPage.clickOrderWaitConfirm();
        CommonLogin.login();
        Thread.sleep(2000);
//        Assert.assertTrue(orderCenterPage.isPrestentProfile(), "login failed");
        Assert.assertEquals(orderCenterPage.getSignOutText(), "退出登录", "登陆失败");
        orderCenterPage.clickSignOutButton();
    }

    // 订单中心--待评价订单
    public static void loginViaOrderCenterWaitRate() throws Exception {
        CommonLogin.setDriver(driver);
        driver.get(orderCerterUrl);
        OrderCenterPage orderCenterPage = PageFactory.initElements(driver, OrderCenterPage.class);
        orderCenterPage.clickOrderWaitRate();
        CommonLogin.login();
        Thread.sleep(2000);
        Assert.assertEquals(orderCenterPage.getSignOutText(), "退出登录", "登陆失败");
        orderCenterPage.clickSignOutButton();
    }

    // 订单中心--待退款订单
    public static void loginViaOrderCenterReturn() throws Exception {
        CommonLogin.setDriver(driver);
        driver.get(orderCerterUrl);
        OrderCenterPage orderCenterPage = PageFactory.initElements(driver, OrderCenterPage.class);
        orderCenterPage.clickOrderReturn();
        CommonLogin.login();
        Thread.sleep(2000);
        Assert.assertEquals(orderCenterPage.getSignOutText(), "退出登录", "登陆失败");
        orderCenterPage.clickSignOutButton();
    }

    // 订单中心--Im
    public static void loginViaOrderCenterIm() throws Exception {
        CommonLogin.setDriver(driver);
        driver.get(orderCerterUrl);
        OrderCenterPage orderCenterPage = PageFactory.initElements(driver, OrderCenterPage.class);
        orderCenterPage.clickOrderCenterIm();
        CommonLogin.login();
        Thread.sleep(2000);
        Assert.assertEquals(orderCenterPage.getSignOutText(), "退出登录", "登陆失败");
        orderCenterPage.clickSignOutButton();
    }
    // -----------------------------确认购买----------------------------------

    // 确认订单页--去购买登录
    public static void loginViaPurchaseSubmitOrder() throws Exception {
        CommonLogin.setDriver(driver);
        driver.get(goodsUrl);
        ConfirmPurchasePage confirmPurchasePage = PageFactory.initElements(driver, ConfirmPurchasePage.class);
        confirmPurchasePage.clickBuyNow();
        Thread.sleep(3000);
        confirmPurchasePage.clickSubmitOrderButton();
        CommonLogin.login();
        Thread.sleep(3000);
        Assert.assertEquals(confirmPurchasePage.getSignOutText(), "退出登录", "登录失败");
        confirmPurchasePage.clickQuickLogin();
    }

    // 确认订单页--收货地址
    public static void loginViaPurchaseAddress() throws Exception {
        CommonLogin.setDriver(driver);
        driver.get(goodsUrl);
        ConfirmPurchasePage confirmPurchasePage = PageFactory.initElements(driver, ConfirmPurchasePage.class);
        confirmPurchasePage.clickBuyNow();
        Thread.sleep(3000);
        confirmPurchasePage.clickNoneAddressButton();
        CommonLogin.login();
        Thread.sleep(3000);
        Assert.assertEquals(confirmPurchasePage.getSignOutText(), "退出登录", "登录失败");
        confirmPurchasePage.clickQuickLogin();
    }

    // 确认订单页--快速登录
    public static void loginViaPurchaseQuickLogin() throws Exception {

        CommonLogin.setDriver(driver);
        driver.get(goodsUrl);
        ConfirmPurchasePage confirmPurchasePage = PageFactory.initElements(driver, ConfirmPurchasePage.class);
        confirmPurchasePage.clickBuyNow();
        Thread.sleep(3000);
        confirmPurchasePage.clickQuickLogin();
        CommonLogin.login();
        Thread.sleep(3000);
        Assert.assertEquals(confirmPurchasePage.getSignOutText(), "退出登录", "登录失败");
        confirmPurchasePage.clickQuickLogin();
    }
}
