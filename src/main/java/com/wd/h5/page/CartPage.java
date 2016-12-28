package com.wd.h5.page;

import com.sun.tools.internal.xjc.reader.internalizer.LocatorTable;
import com.wd.libarary.BasePage;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import com.wd.libarary.Locator;
import com.wd.libarary.Locator.ByType;
import org.openqa.selenium.WebElement;

/**
 * Created by wangdi on 2016/10/26.
 */
public class CartPage extends BasePage {

    WebDriver driver;

    public String PageUrl = "https://weidian.com/cart/index.php?referrerURl=shopid_3073080";

    // ----------------------页面元素----------------------
    //购物车title
    Locator CartTitle = new Locator("#common_hd > h1", ByType.cssSelector);

    // 返回按钮
    Locator BackButton = new Locator("hd_back");

    // 删除按钮
    Locator DeleteButton = new Locator("hd_edit");

    // 商品全选按钮
    Locator SelectAll = new Locator("#cart_seller_list > div > div.cart_seller_title_wrapper > div > mark", ByType.cssSelector);

    // 购物车中商品列表
    Locator Cartlist = new Locator("#cart_seller_list > div > ul > li", ByType.cssSelector);

    // 购物车无商品文案
    Locator cartmpty = new Locator("cart_empty");

    // 单个商品获取商品名称
    Locator itemName = new Locator("a.cart_tle.over_hidden", ByType.cssSelector);

    // 获取商品列表
    Locator cartItemsList = new Locator("ul > li.cart_li.rel", ByType.cssSelector);
    // 购物车删除按钮
    Locator cartDeleteButton = new Locator("hd_edit");
    // 确定按钮
    Locator confirmButton = new Locator("_confirm_btnB");
    // 去结算
    Locator goBuyButton = new Locator("a.do_buy.btnok.right", ByType.cssSelector);





//    public WebDriver getDriver() {
//        return driver;
//    }

    public List<WebElement> getCartItemsList() {
        return getWebElements(cartItemsList);
    }

    // 点击去结算
    public void clickGoBuyButton() throws Exception {
        click(goBuyButton);
    }

    // 点击确定按钮
    public void clickConfirmButton() throws Exception {
        click(confirmButton);
    }

    // 点击删除按钮
    public void clickCartDeleteButton() throws Exception {
        click(cartDeleteButton);
    }

    // 获取单个商品名称
    public String getItemName() throws Exception {
        return getText(itemName);
    }

    // 获取购物车无商品文案
    public String getCartEmptyText() throws Exception {
        return getText(cartmpty);
    }

    public CartPage(WebDriver driver) throws Exception {
        super(driver);
//        driver.get("https://weidian.com/cart/index.php?referrerURl=shopid_3073080");
    }

    public boolean isCartPage() throws Exception {
        return isElementExist(CartTitle);
    }

    // 获取购物车title文案
    public String getCartTitleText() throws Exception {
        return getText(CartTitle);
    }

    // 获取购物车中商品列表
    public List<WebElement> getCartList() {
        return getWebElements(Cartlist);
    }

    // 获取购物车url
    public String getPageUrl() {
        return PageUrl;
    }

}
