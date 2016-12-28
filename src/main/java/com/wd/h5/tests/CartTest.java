package com.wd.h5.tests;


import com.wd.h5.page.CartPage;
import com.wd.h5.page.ConfirmPurchasePage;
import com.wd.h5.page.GoodsPage;
import com.wd.h5.page.ShopPage;
import com.wd.libarary.DriverFactory;
import com.wd.libarary.TestNGListener;
import com.wd.libarary.UITest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by ike on 16/10/30.
 */
@Listeners({TestNGListener.class})
public class CartTest extends UITest {

    // 获取driver
    WebDriver driver = DriverFactory.getMobileForChromeRemoteDriver();

    @BeforeMethod(alwaysRun = true)
    public void init() {
        super.init(driver);
    }

    @Test(description = "检查购物页面展示正常--未登录", priority = 1)
    public void checkCartPage() throws Exception {
        CartPage cartPage = PageFactory.initElements(driver, CartPage.class);
        driver.get(cartPage.getPageUrl());
        Assert.assertEquals(cartPage.getCartTitleText(), "购物车");
        Assert.assertEquals(cartPage.getCartEmptyText(), "还没有选购商品");
    }

    @Test(description = "店铺页添加商品到购物车", priority = 2)
    public void checkShopAddItemToCart() throws Exception {
        ShopPage shopPage = PageFactory.initElements(driver, ShopPage.class);
        driver.get(shopPage.getPageUrl());
        Thread.sleep(1000);
        shopPage.clickAddToCart1();
        // 购物车动画加提示时间太长
        Thread.sleep(5000);
        shopPage.clickCartButton();
        CartPage cartPage = PageFactory.initElements(driver, CartPage.class);
        Thread.sleep(1000);
        Assert.assertEquals(cartPage.getItemName(), "樱桃家独家特制* 法兰绒睡衣四件套 清新珊瑚绒家居服wd-194986");
    }

    @Test(description = "商品页添加商品到购物车", priority = 4)
    public void checkGoodsAddItemToCart() throws Exception {
        GoodsPage goodsPage = PageFactory.initElements(driver, GoodsPage.class);
        driver.get(goodsPage.getPageUrl());
        goodsPage.clickAddCartButton();
        Thread.sleep(5000);
        goodsPage.clickCartButton();
        Thread.sleep(2000);
        CartPage cartPage = PageFactory.initElements(driver, CartPage.class);
        List<WebElement> e = cartPage.getCartItemsList();
        String itemName = e.get(0).findElement(By.cssSelector("a.cart_tle.over_hidden")).getText();
        Assert.assertEquals(itemName, "包邮 天青I 蔚蓝Ⅰ天青1 蔚蓝1 BS IND 25克/瓶");

//        System.out.println(cartPage.getCartItemsList().size());
    }

    @Test(description = "购物车删除商品", priority = 3)
    public void checkCartDeleteItem() throws Exception {
        CartPage cartPage = PageFactory.initElements(driver, CartPage.class);
        checkPage(cartPage);
        cartPage.clickCartDeleteButton();
        Thread.sleep(1000);
        cartPage.clickConfirmButton();
        Assert.assertEquals(cartPage.getCartEmptyText(), "还没有选购商品");
    }

    @Test(description = "购物车结算商品", priority = 5)
    public void checkCartGoBuy() throws Exception {
        CartPage cartPage = PageFactory.initElements(driver, CartPage.class);
        checkPage(cartPage);
        cartPage.clickGoBuyButton();
        Thread.sleep(3000);
        ConfirmPurchasePage cp = PageFactory.initElements(driver, ConfirmPurchasePage.class);
        Assert.assertTrue(cp.isCPTitle());
    }


    public void checkPage(CartPage cartPage) throws Exception {
        if (!cartPage.isCartPage()) {
            GoodsPage goodsPage = PageFactory.initElements(driver, GoodsPage.class);
            driver.get(goodsPage.getPageUrl());
            goodsPage.clickAddCartButton();
            Thread.sleep(5000);
            goodsPage.clickCartButton();
            Thread.sleep(2000);
        }


    }


    @AfterClass(alwaysRun = true)
    public void stop() {
        super.stop();
    }


}
