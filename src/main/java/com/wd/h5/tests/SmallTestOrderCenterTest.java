package com.wd.h5.tests;

import com.wd.h5.action.CommonLogin;
import com.wd.h5.page.OrderCenterPage;
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

/**
 * Created by ike on 16/10/30.
 */
@Listeners({TestNGListener.class})
public class SmallTestOrderCenterTest extends UITest {

    // 获取driver
    WebDriver driver = DriverFactory.getMobileForChromeRemoteDriver();

    @BeforeMethod(alwaysRun = true)
    public void init() {
        super.init(driver);
    }


    @Test(description = "订单中心--待付款", priority = 1)
    public void checkOrderWaitPay() throws Exception {
        OrderCenterPage orderCenterPage = PageFactory.initElements(driver, OrderCenterPage.class);
        driver.get(orderCenterPage.getPageUrl());
        orderCenterPage.clickLogin();
        CommonLogin.setDriver(driver);
        CommonLogin.login();
        String WaitPayReminder = orderCenterPage.getWaitPayReminder();
        Thread.sleep(3000);
        orderCenterPage.clickOrderWaitPay();
        Thread.sleep(3000);

        if (WaitPayReminder.equals("reminder")) {
            Assert.assertTrue(orderCenterPage.getWaitpayList().size() >= 1);
        } else {
            Assert.assertEquals(orderCenterPage.getnoordersstatus(), "没有相关订单");
        }
    }

    @Test(description = "订单中心--待发货", priority = 2)
    public void checkOrderWaitSend() throws Exception {
        OrderCenterPage orderCenterPage = PageFactory.initElements(driver, OrderCenterPage.class);
        checkPage(orderCenterPage);
        String reminder = orderCenterPage.getWaitSendReminder();
        orderCenterPage.clickOrderWaitSend();
        Thread.sleep(2000);

        if (reminder.equals("reminder")) {
            Assert.assertTrue(orderCenterPage.getWaitsendList().size() >= 1);
        } else {
            Assert.assertEquals(orderCenterPage.getWaitSendNoOrderText(), "没有相关订单");
        }

    }

    @Test(description = "订单中心--待收货", priority = 3)
    public void checkOrderWaitConfirm() throws Exception {
        OrderCenterPage orderCenterPage = PageFactory.initElements(driver, OrderCenterPage.class);
        checkPage(orderCenterPage);
        String reminder = orderCenterPage.getWaitConfirmReminder();
        orderCenterPage.clickOrderWaitConfirm();
        Thread.sleep(2000);

        if (reminder.equals("reminder")) {
            Assert.assertTrue(orderCenterPage.getWaitConfirmOrderList().size() >= 1);
        } else {
            Assert.assertEquals(orderCenterPage.getWaitConfirmNoOrderText(), "没有相关订单");
        }

    }

    @Test(description = "订单中心--待评价", priority = 4)
    public void checkOrderWaitRate() throws Exception {
        OrderCenterPage orderCenterPage = PageFactory.initElements(driver, OrderCenterPage.class);
        checkPage(orderCenterPage);
        String reminder = orderCenterPage.getWaitRateReminder();
        orderCenterPage.clickOrderWaitRate();
        Thread.sleep(2000);

        if (reminder.equals("reminder")) {
            Assert.assertTrue(orderCenterPage.getWaitRateOrderList().size() >= 1);
        } else {
            Assert.assertEquals(orderCenterPage.getWaitRateNoOrderText(), "没有相关订单");
        }

    }

    @Test(description = "订单中心--全部订单", priority = 5)
    public void checkAllOrders() throws Exception {
        OrderCenterPage orderCenterPage = PageFactory.initElements(driver, OrderCenterPage.class);
        checkPage(orderCenterPage);
//        String reminder = orderCenterPage.getWaitRateReminder();
        orderCenterPage.clickAllOrdersButton();
        Thread.sleep(2000);
        Assert.assertTrue(orderCenterPage.getAllOrdersList().size() >= 1);
    }


    public void checkPage(OrderCenterPage orderCenterPage) {

        if (!driver.getTitle().equals("微店订单中心")) {
            driver.get(orderCenterPage.getPageUrl());

        }

    }

    @AfterClass(alwaysRun = true)
    public void stop() {
        super.stop();
    }


}
