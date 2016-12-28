package com.wd.h5.tests;

import com.wd.h5.action.CommonLogin;
import com.wd.h5.page.ConfirmPurchasePage;
import com.wd.libarary.DriverFactory;
import com.wd.libarary.TestNGListener;
import com.wd.libarary.UITest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.xml.dom.Tag;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by ike on 16/10/27.
 */
@Listeners({TestNGListener.class})
public class SmallTestCPTest extends UITest {


    // 获取driver
    WebDriver driver = DriverFactory.getMobileForChromeRemoteDriver();

    @BeforeMethod(alwaysRun = true)
    public void init() {
        super.init(driver);
    }

    @Test(description = "结算页面信息显示（未登录", priority = 1)
    public void checkConfirmPurchasePage() throws Exception {
        ConfirmPurchasePage confirmPurchasePage = PageFactory.initElements(driver, ConfirmPurchasePage.class);
        driver.get(confirmPurchasePage.getPageUrl());
        confirmPurchasePage.clickBuyNow();
        Thread.sleep(8000);
        Assert.assertEquals(confirmPurchasePage.getItemName(), "天青I 蔚蓝Ⅰ天青1 蔚蓝1 BS IND 25克/瓶");
        Assert.assertEquals(confirmPurchasePage.getItemPrice(), "¥0.01");
    }

    @Test(description = "结算页登陆购买商品--在线支付", priority = 2)
    public void checkOnlinePay() throws Exception {
        ConfirmPurchasePage confirmPurchasePage = PageFactory.initElements(driver, ConfirmPurchasePage.class);
        checkPage(confirmPurchasePage);
        confirmPurchasePage.clickQuickLogin();
        CommonLogin.setDriver(driver);
        CommonLogin.login();
        Thread.sleep(8000);
        confirmPurchasePage.clickSubmitOrderButton();
        Thread.sleep(6000);
//        Assert.assertEquals(confirmPurchasePage.getPayTitle(), "商品名称：天青I 蔚蓝Ⅰ天...");
        Assert.assertTrue(confirmPurchasePage.isDoPay());
    }

    @Test(description = "结算页登陆购买商品--货到付款", priority = 3)
    public void checkCOD() throws Exception {
        ConfirmPurchasePage confirmPurchasePage = PageFactory.initElements(driver, ConfirmPurchasePage.class);
        checkPage(confirmPurchasePage);
        checkLogin(confirmPurchasePage);
        confirmPurchasePage.clickPayCODButton();
        Thread.sleep(8000);
        confirmPurchasePage.clickSubmitOrderButton();
        Thread.sleep(5000);
        Assert.assertEquals(confirmPurchasePage.getCODOrderSuccessText(), "订单提交成功");
    }


    public void checkPage(ConfirmPurchasePage confirmPurchasePage) throws Exception {
        if (!confirmPurchasePage.isCPTitle()) {
            driver.get(confirmPurchasePage.getPageUrl());
            confirmPurchasePage.clickBuyNow();
            Thread.sleep(3000);
        }
    }

    public void checkLogin(ConfirmPurchasePage confirmPurchasePage) throws Exception {

        if (!confirmPurchasePage.getLoginStatusText().equals("退出登录")) {
            CommonLogin.setDriver(driver);
            CommonLogin.login();
            Thread.sleep(3000);
        }

    }


    @AfterClass(alwaysRun = true)
    public void stop() {
        super.stop();
    }


}
