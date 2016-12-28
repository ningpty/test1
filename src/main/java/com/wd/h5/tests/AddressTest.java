package com.wd.h5.tests;



import com.sun.org.glassfish.gmbal.Description;
import com.sun.tools.internal.xjc.Driver;
import com.wd.h5.action.CommonLogin;
import com.wd.h5.action.LoginAction;
import com.wd.h5.page.LoginPage;
import com.wd.h5.page.OrderCenterPage;
import com.wd.h5.page.ShopPage;
import com.wd.libarary.DriverFactory;
import com.wd.libarary.UITest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.SystemClock;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by yuhao on 16/10/28.
 */
public class AddressTest extends UITest {
    //获取driver
    WebDriver driver = DriverFactory.getChromeDriver();
    private static String orderCenterurl = "http://i.weidian.com/index.php";
    @BeforeMethod(alwaysRun = true)
    public void init() {
        super.init(driver);
    }

    /**
     * 001验证地址的删除功能
     */
    @Test(groups = "AddressTest")
    public void AddressDelect() throws Exception {
        CommonLogin.setDriver(driver);
        driver.get(orderCenterurl);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.switchToLogin();
        CommonLogin.login();
        OrderCenterPage orderCenterPage = PageFactory.initElements(driver,OrderCenterPage.class);
        Thread.sleep(2000);
        orderCenterPage.clickDeliveryAddress();
        orderCenterPage.clickdelectAddressButton();
        Thread.sleep(2000);
        orderCenterPage.clickAddressCancelButton();
        Thread.sleep(2000);
        orderCenterPage.clickdelectAddressButton();
        Thread.sleep(2000);
        orderCenterPage.clickAddressConfirmButton();
        Thread.sleep(2000);



    }
}
