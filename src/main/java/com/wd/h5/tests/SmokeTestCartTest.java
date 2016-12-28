package com.wd.h5.tests;

import com.wd.h5.action.CommonLogin;
import com.wd.h5.page.GoodsPage;
import com.wd.h5.page.CartPage;
import com.wd.h5.page.LoginPage;
import com.wd.h5.page.ShopPage;
import com.wd.h5.page.ConfirmPurchasePage;
import com.wd.libarary.*;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangdi on 2016/10/26.
 */

@Listeners({TestNGListener.class})
public class SmokeTestCartTest extends UITest {
    //获取driver
    WebDriver driver = DriverFactory.getMobileForChromeDriver();
    private static String orderCerterUrl = "https://i.weidian.com/index.php";
    public String pageUrl = "http://weidian.com/?userid=3073080";

    @BeforeMethod(alwaysRun = true)
    public void init() {
        super.init(driver);
    }

     //**********************
    @Test(description = "未登录进入购物车页面", priority = 1)
    public void CartPageUnLogin() throws Exception {
        ShopPage shopPage = PageFactory.initElements(driver, ShopPage.class);
        driver.get(shopPage.getPageUrl());
        TimeUnit.SECONDS.sleep(2);
        shopPage.clickCartButton();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("还没有选购商品");
    }

    //************************
    @Test(description = "已登录进入购物车页面", priority = 8)
    public void CartPageLogin() throws Exception {
        ShopPage shopPage = PageFactory.initElements(driver, ShopPage.class);
        CommonLogin.setDriver(driver);
        driver.get(orderCerterUrl);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.switchToLogin();
        CommonLogin.login();
        driver.navigate ().to ( pageUrl );
        TimeUnit.SECONDS.sleep(5);
        shopPage.clickCartButton();
        TimeUnit.SECONDS.sleep(2);
    }

    //************************
    @Test(description = "从店铺页添加购物车－SKU", priority = 2)
    public void AddToCart () throws Exception {
        ShopPage shopPage = PageFactory.initElements(driver, ShopPage.class);
        driver.get(shopPage.getPageUrl());
        TimeUnit.SECONDS.sleep(2);
        List<WebElement> list = shopPage.getShopGoodsList();
        if(list == null || list.size() == 0){
            return ;
        }
        WebElement element = list.get(3);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
        TimeUnit.SECONDS.sleep(1);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 400)");
        //shopPage.clickAddToCart1();
        TimeUnit.SECONDS.sleep(3);
        element.click();
        TimeUnit.SECONDS.sleep(3);

        //sku
        Locator skuDialog = new Locator("control_wrap", Locator.ByType.id);
        if(shopPage.isElementExist(skuDialog)){
//            TimeUnit.SECONDS.sleep(2);
//            shopPage.clickAddToCart1();
            shopPage.selectSku1();
            shopPage.clickSubmitButton();
            TimeUnit.SECONDS.sleep(7);


        }else {
            Thread.sleep(1000);
        }
        //check商品是否添加成功
        shopPage.clickCartButton();
        TimeUnit.SECONDS.sleep(4);
        CartPage cartPage = PageFactory.initElements(driver, CartPage.class);
        List<WebElement> e = cartPage.getCartList();
        TimeUnit.SECONDS.sleep(4);
        Assert.assertEquals(e.size(), 1);
        TimeUnit.SECONDS.sleep(2);
        cartPage.clickCartDeleteButton();
        TimeUnit.SECONDS.sleep(4);
        cartPage.clickConfirmButton();
        Assert.assertEquals(cartPage.getCartEmptyText(), "还没有选购商品");
        TimeUnit.SECONDS.sleep(4);

    }

    //************************
    @Test(description = "店铺页添加到购物车－无SKU", priority = 3)
    public void AddSkuToCart() throws Exception{
        ShopPage shopPage = PageFactory.initElements(driver, ShopPage.class);
        driver.get(shopPage.getPageUrl());
        TimeUnit.SECONDS.sleep(4);
        List<WebElement> list = shopPage.getShopGoodsList();
        if(list == null || list.size() == 0){
            return ;
        }
        System.out.print(list);
        WebElement element = list.get(0);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
        TimeUnit.SECONDS.sleep(1);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 300)");
        //shopPage.clickAddToCart1();
        TimeUnit.SECONDS.sleep(2);
        element.click();
        TimeUnit.SECONDS.sleep(5);

        //check商品是否添加成功
        shopPage.clickCartButton();
        TimeUnit.SECONDS.sleep(4);
        CartPage cartPage = PageFactory.initElements(driver, CartPage.class);
        List<WebElement> e = cartPage.getCartList();
        TimeUnit.SECONDS.sleep(4);
        Assert.assertEquals(e.size(), 1);
        TimeUnit.SECONDS.sleep(4);
        cartPage.clickCartDeleteButton();
        TimeUnit.SECONDS.sleep(4);
        cartPage.clickConfirmButton();
        Assert.assertEquals(cartPage.getCartEmptyText(), "还没有选购商品");
        TimeUnit.SECONDS.sleep(4);
    }

    //************************
    @Test(description = "商品页点击加入购物车-无SKU", priority = 4)
    public void AddToCartFromGoodsPage() throws Exception {
        GoodsPage goodsPage = PageFactory.initElements(driver, GoodsPage.class);
        driver.get(goodsPage.getPageUrl());
        TimeUnit.SECONDS.sleep(2);
        goodsPage.clickAddCartButton();
        TimeUnit.SECONDS.sleep(5);

        //check商品是否添加成功
        goodsPage.clickCartButton();
        CartPage cartPage = PageFactory.initElements(driver, CartPage.class);
        List<WebElement> e = cartPage.getCartList();
        TimeUnit.SECONDS.sleep(2);
        Assert.assertEquals(e.size(), 1);
        TimeUnit.SECONDS.sleep(2);
        cartPage.clickCartDeleteButton();
        TimeUnit.SECONDS.sleep(2);
        cartPage.clickConfirmButton();
        Assert.assertEquals(cartPage.getCartEmptyText(), "还没有选购商品");
        TimeUnit.SECONDS.sleep(4);

    }


    //*************************
    @Test(description = "商品页点击加入购物车-SKU", priority = 5)
    public void AddSkuToCartFromGoodsPage() throws Exception {
        GoodsPage goodsPage = PageFactory.initElements(driver, GoodsPage.class);
        driver.get(goodsPage.getPageUrl1());
        goodsPage.clickAddCartButton();
        TimeUnit.SECONDS.sleep(2);
        goodsPage.selectSku1();
        TimeUnit.SECONDS.sleep(1);
        goodsPage.clickSubmitButton();
        TimeUnit.SECONDS.sleep(5);

      //check
        goodsPage.clickCartButton();
        CartPage cartPage = PageFactory.initElements(driver, CartPage.class);
        List<WebElement> e = cartPage.getCartList();
        TimeUnit.SECONDS.sleep(2);
        Assert.assertEquals(e.size(), 2);
        TimeUnit.SECONDS.sleep(2);
        cartPage.clickCartDeleteButton();
        TimeUnit.SECONDS.sleep(2);
        cartPage.clickConfirmButton();
        Assert.assertEquals(cartPage.getCartEmptyText(), "还没有选购商品");
        TimeUnit.SECONDS.sleep(2);

    }


    @Test(description = "购物车页面删除商品", priority = 6)
    public void DeleteItemFromCart() throws Exception {
        ShopPage shopPage = PageFactory.initElements(driver, ShopPage.class);
        driver.get(shopPage.getPageUrl());
        // 未完待续
        //添加商品到购物车
        shopPage.clickAddToCart1();
        Thread.sleep(5000);
        shopPage.clickAddToCart2();
        Thread.sleep(5000);
        //点击购物车按钮
        shopPage.clickCartButton();
        CartPage cartPage = PageFactory.initElements(driver, CartPage.class);
        Assert.assertEquals(cartPage.getCartTitleText(), "购物车");
        System.out.println("进入购物车页面");
        List<WebElement> e = cartPage.getCartList();
        Assert.assertEquals(e.size(), 1);
        cartPage.clickCartDeleteButton();
        Thread.sleep(1000);
        cartPage.clickConfirmButton();
        Thread.sleep(2000);
    }

    @Test(description = "购物车页面点击去结算", priority = 7)
    public void ClickToBuy() throws Exception {
        ShopPage shopPage = PageFactory.initElements(driver, ShopPage.class);
        driver.get(shopPage.getPageUrl());
        // 未完待续
        //添加商品到购物车
        shopPage.clickAddToCart1();
        Thread.sleep(5000);
        shopPage.clickCartButton();
        CartPage cartPage = PageFactory.initElements(driver, CartPage.class);
        Assert.assertEquals(cartPage.getCartTitleText(), "购物车");
        System.out.println("进入购物车页面");
        List<WebElement> e = cartPage.getCartList();
        Assert.assertEquals(e.size(), 1);
        cartPage.clickGoBuyButton();
        Thread.sleep(3000);
        ConfirmPurchasePage cpPage = PageFactory.initElements(driver, ConfirmPurchasePage.class);
        if (cpPage.isCPTitle()) {
            System.out.println("成功进入确认购买页");
        } else {
            System.out.println("进入确认购买页失败");
        }
//        Assert

    }

    @AfterClass(alwaysRun = true)
    public void stop() {
        super.stop();
    }
}
