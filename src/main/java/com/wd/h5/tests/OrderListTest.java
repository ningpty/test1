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

import java.util.List;

import org.openqa.selenium.WebElement;
import com.wd.h5.page.ShopPage;
import org.openqa.selenium.By;

/**
 * Created by huangmeng on 16/10/27.
 */
@Listeners({TestNGListener.class})
public class OrderListTest extends UITest {

    // 获取driver
//    WebDriver driver = DriverFactory.getMobileForChromeRemoteDriver();
    WebDriver driver = DriverFactory.getChromeDriver();

    @BeforeMethod(alwaysRun = true)
    public void init() {
        super.init(driver);
    }
//------------------------------------------------待付款
    /**
     * 001验证待付款商品状态正确
     */
    @Test(description = "001验证待付款商品状态正确", priority = 1)
    public void NopayShopstatus() throws Exception {
        OrderCenterPage orderCenterPage = PageFactory.initElements(driver, OrderCenterPage.class);
        driver.get(orderCenterPage.getPageUrl());
        orderCenterPage.clickLogin();
        CommonLogin.setDriver(driver);
        CommonLogin.login();

        orderCenterPage.clickOrderWaitPay();
        Thread.sleep(3000);
        if (orderCenterPage.isNoOrderStatus()) {
            System.out.println("没有订单");
        } else {
            Assert.assertEquals(orderCenterPage.getwaitpaystatus(), "未付款");
            Thread.sleep(3000);
        }
    }

    /**
     * 002验证点击待付款商品店铺名称跳转正确
     */
    @Test(description = "002验证点击待付款商品店铺名称跳转正确", priority = 2)
    public void NopayShopjump() throws Exception {
        OrderCenterPage orderCenterPage = PageFactory.initElements(driver, OrderCenterPage.class);
        checkPage(orderCenterPage);
        orderCenterPage.clickOrderWaitPay();
        if (orderCenterPage.isNoOrderStatus()) {
            System.out.println("没有订单");
        } else {
            //获取待付款列表中的订单店铺名称
            List<WebElement> e = orderCenterPage.getWaitpayList();
            String s = e.get(0).findElement(By.cssSelector(".left.chevron-left")).getText();
            //点击待付款列表上店铺名称
            orderCenterPage.clickwaitordertitle();
            //判断点击的店铺是否与调转店铺名称一致
            ShopPage shopPage = PageFactory.initElements(driver, ShopPage.class);
            Assert.assertEquals(shopPage.getShopName(), s);

        }

    }

    /**
     * 003验证点击待付款商品点击跳转正确
     */
    @Test(description = "003验证点击待付款商品点击跳转正确", priority = 3)
    public void Nopaygoodsjump() throws Exception {
        OrderCenterPage orderCenterPage = PageFactory.initElements(driver, OrderCenterPage.class);
        checkPage(orderCenterPage);
        orderCenterPage.clickOrderWaitPay();
        if (orderCenterPage.isNoOrderStatus()) {
            System.out.println("没有订单");
        } else {
            //点击待付款商品
            orderCenterPage.clickwaitordergoods();

            Assert.assertEquals(orderCenterPage.getorderdetailname(), "订单详情");
        }

    }


    /**
     * 004验证待付款列表关闭按钮功能正确
     */
    @Test(description = "004验证待付款列表关闭按钮功能正确", priority = 4)
    public void Nopayclosebutton() throws Exception {
        OrderCenterPage orderCenterPage = PageFactory.initElements(driver, OrderCenterPage.class);
        checkPage(orderCenterPage);
        orderCenterPage.clickOrderWaitPay();
        if (orderCenterPage.isNoOrderStatus()) {
            System.out.println("没有订单");
        } else {
            //点击待付款页关闭按钮
            orderCenterPage.clickwaitorderclosebutton();
            Thread.sleep(2000);
            //点击待付款页关闭原因
            orderCenterPage.clickwaitorderclosereson();
            Thread.sleep(2000);
        }

    }

    /**
     * 005验证点击待付款商品数量与角标一致
     */
    @Test(description = "005验证点击待付款商品数量与角标一致", priority = 5)
    public void Nopaygoodsum() throws Exception {
        OrderCenterPage orderCenterPage = PageFactory.initElements(driver, OrderCenterPage.class);
        checkPage(orderCenterPage);
        //获取待付款角标数量
        String WaitPaysum = orderCenterPage.getWaitPaySum();

        orderCenterPage.clickOrderWaitPay();
        if (orderCenterPage.isNoOrderStatus()) {
            System.out.println("没有订单");
        } else {
            int i = Integer.parseInt(WaitPaysum);
            Assert.assertEquals(orderCenterPage.getWaitpayList().size(), i);
        }
    }


//------------------------------------------------待评价
    /**
     * 007验证待评价商品状态正确
     */
    @Test(description = "007验证待评价商品状态正确", priority = 7)
    public void WaitEvaluatestatus() throws Exception {
        OrderCenterPage orderCenterPage = PageFactory.initElements(driver, OrderCenterPage.class);
        checkPage(orderCenterPage);
        //点击待评价列表
        orderCenterPage.clickOrderWaitRate();
        Thread.sleep(3000);
        if (orderCenterPage.isNoOrderStatus()) {
            System.out.println("没有订单");
        } else {
            Assert.assertEquals(orderCenterPage.getwaitpaystatus(), "待评价");
        }
    }

    /**
     * 008验证点击待评价商品店铺名称跳转正确
     */
    @Test(description = "008验证点击待评价商品店铺名称跳转正确", priority = 8)
    public void waitevaluateShopjump() throws Exception {
        OrderCenterPage orderCenterPage = PageFactory.initElements(driver, OrderCenterPage.class);
        checkPage(orderCenterPage);
        //点击待评价列表
        orderCenterPage.clickOrderWaitRate();
        Thread.sleep(3000);
        if (orderCenterPage.isNoOrderStatus()) {
            System.out.println("没有订单");
        } else {
            //获取待评价列表中的订单店铺名称
            List<WebElement> e = orderCenterPage.getWaitevaluateList();
            String s = e.get(0).findElement(By.cssSelector(".left.chevron-left")).getText();
            //点击待评价列表上店铺名称
            orderCenterPage.clickevaluateshopname();
            //判断点击的店铺是否与调转店铺名称一致
            ShopPage shopPage = PageFactory.initElements(driver, ShopPage.class);
            Assert.assertEquals(shopPage.getShopName(), s);

        }

    }

    /**
     * 009验证点击待评价商品点击跳转是正确的
     */
    @Test(description = "009验证点击待评价商品点击跳转是正确的", priority = 9)
    public void waitevaluategoodsjump() throws Exception {
        OrderCenterPage orderCenterPage = PageFactory.initElements(driver, OrderCenterPage.class);
        checkPage(orderCenterPage);
        orderCenterPage.clickOrderWaitRate();
        if (orderCenterPage.isNoOrderStatus()) {
            System.out.println("没有订单");
        } else {
            //点击待评价商品
            orderCenterPage.clickevaluateordergoods();
            Thread.sleep(2000);
            Assert.assertEquals(orderCenterPage.getorderdetailname(), "订单详情");
        }
    }

    /**
     * 010验证点击待评价商品数量与角标一致
     */
    @Test(description = "010验证点击待评价商品数量与角标一致", priority = 10)
    public void waitevaluategoodsum() throws Exception {
        OrderCenterPage orderCenterPage = PageFactory.initElements(driver, OrderCenterPage.class);
        checkPage(orderCenterPage);
        //获取待付款角标数量
        String Waitevaluatesum = orderCenterPage.getWaitevaluateSum();

        orderCenterPage.clickOrderWaitRate();
        if (orderCenterPage.isNoOrderStatus()) {
            System.out.println("没有订单");
        } else {
            int i = Integer.parseInt(Waitevaluatesum);
            Assert.assertEquals(orderCenterPage.getWaitevaluateList().size(), i);
        }
    }

    //------------------------------------------------待发货
    /**
     * 013验证待发货商品状态正确
     */
    @Test(description = "013验证待发货商品状态正确", priority = 13)
    public void WaitsendShopstatus() throws Exception {
        OrderCenterPage orderCenterPage = PageFactory.initElements(driver, OrderCenterPage.class);
        checkPage(orderCenterPage);
        orderCenterPage.clickOrderWaitSend();
        Thread.sleep(3000);
        if (orderCenterPage.isNoOrderStatus()) {
            System.out.println("没有订单");
        } else {
            Assert.assertEquals(orderCenterPage.getwaitsendsstatus(), "待发货");
            Thread.sleep(3000);
        }
    }
    /**
     * 014验证点击待发货商品店铺名称跳转正确
     */
    @Test(description = "014验证点击待发货商品店铺名称跳转正确", priority = 14)
    public void WaitsendShopjump() throws Exception {
        OrderCenterPage orderCenterPage = PageFactory.initElements(driver, OrderCenterPage.class);
        checkPage(orderCenterPage);
        orderCenterPage.clickOrderWaitSend();
        if (orderCenterPage.isNoOrderStatus()) {
            System.out.println("没有订单");
        } else {
            //获取待发货列表中的订单店铺名称
            List<WebElement> e = orderCenterPage.getWaitsendsList();
            String s = e.get(0).findElement(By.cssSelector(".left.chevron-left")).getText();
            //点击待发货列表上店铺名称
            orderCenterPage.clickwaitsendshopname();
            //判断点击的店铺是否与调转店铺名称一致
            ShopPage shopPage = PageFactory.initElements(driver, ShopPage.class);
            Assert.assertEquals(shopPage.getShopName(), s);

        }
    }

    /**
     * 015验证点击待发货商品点击跳转正确
     */
    @Test(description = "015验证点击待发货商品点击跳转正确", priority = 15)
    public void  Waitsendgoodsjump() throws Exception {
        OrderCenterPage orderCenterPage = PageFactory.initElements(driver, OrderCenterPage.class);
        checkPage(orderCenterPage);
        orderCenterPage.clickOrderWaitSend();
        if (orderCenterPage.isNoOrderStatus()) {
            System.out.println("没有订单");
        } else {
            //点击待发货商品
            orderCenterPage.clickwaitsendordergoods();

            Assert.assertEquals(orderCenterPage.getorderdetailname(), "订单详情");
        }

    }

    /**
     * 016验证点击待发货商品数量与角标一致
     */
    @Test(description = "016验证点击待发货商品数量与角标一致", priority = 16)
    public void Waitsendgoodsum() throws Exception {
        OrderCenterPage orderCenterPage = PageFactory.initElements(driver, OrderCenterPage.class);
        checkPage(orderCenterPage);
        //获取待发货角标数量
        String Waitsendsum = orderCenterPage.getWaitsendSum();

        orderCenterPage.clickOrderWaitSend();
        if (orderCenterPage.isNoOrderStatus()) {
            System.out.println("没有订单");
        } else {
            int i = Integer.parseInt(Waitsendsum);
            Assert.assertEquals(orderCenterPage.getWaitevaluateList().size(), i);
        }
    }


//------------------------------------------------待收货
    /**
     * 020验证待收货商品状态正确(获取的状态要修改)
     */
    @Test(description = "020验证待收货商品状态正确", priority = 20)
    public void WaitReceivedShopstatus() throws Exception {
        OrderCenterPage orderCenterPage = PageFactory.initElements(driver, OrderCenterPage.class);
        checkPage(orderCenterPage);
        orderCenterPage.clickOrderWaitConfirm();
        Thread.sleep(3000);
        if (orderCenterPage.isNoOrderStatus()) {
            System.out.println("没有订单");
        } else {
            Assert.assertEquals(orderCenterPage.getwaitreceivedstatus(), "待收货");
            Thread.sleep(3000);
        }
    }
    /**
     * 021验证点击待收货商品店铺名称跳转正确
     */
    @Test(description = "021验证点击待收货商品店铺名称跳转正确", priority = 21)
    public void WaitReceivedShopjump() throws Exception {
        OrderCenterPage orderCenterPage = PageFactory.initElements(driver, OrderCenterPage.class);
        checkPage(orderCenterPage);
        orderCenterPage.clickOrderWaitConfirm();
        if (orderCenterPage.isNoOrderStatus()) {
            System.out.println("没有订单");
        } else {
            //获取待发货列表中的订单店铺名称
            List<WebElement> e = orderCenterPage.getWaitreceivedList();
            String s = e.get(0).findElement(By.cssSelector(".left.chevron-left")).getText();
            //点击待发货列表上店铺名称
            orderCenterPage.clickwaitreceivedshopname();
            //判断点击的店铺是否与调转店铺名称一致
            ShopPage shopPage = PageFactory.initElements(driver, ShopPage.class);
            Assert.assertEquals(shopPage.getShopName(), s);

        }
    }

    /**
     * 022验证点击待收货商品点击跳转正确的
     */
    @Test(description = "022验证点击待收货商品点击跳转正确", priority = 22)
    public void  WaitReceivedgoodsjump() throws Exception {
        OrderCenterPage orderCenterPage = PageFactory.initElements(driver, OrderCenterPage.class);
        checkPage(orderCenterPage);
        orderCenterPage.clickOrderWaitConfirm();
        if (orderCenterPage.isNoOrderStatus()) {
            System.out.println("没有订单");
        } else {
            //点击待发货商品
            orderCenterPage.clickwaitreceivedgoods();

            Assert.assertEquals(orderCenterPage.getorderdetailname(), "订单详情");
        }

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
