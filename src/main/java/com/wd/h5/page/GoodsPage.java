package com.wd.h5.page;

import com.wd.libarary.BasePage;
import com.wd.libarary.Locator;
import com.wd.libarary.Locator.ByType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

/**
 * Created by ike on 16/8/1.
 * 商品页面
 */
public class GoodsPage extends BasePage {

    WebDriver driver;

    public String pageUrl = "https://weidian.com/item.html?itemID=65090056";
    public String pageUrl1 = "https://weidian.com/item.html?itemID=1046419044";

    // ----------------------页面元素----------------------
    // 返回按钮
    Locator hd_backButton = new Locator("hd_back");
    // 收藏
    Locator favoriteButton = new Locator("#control_btn_inner_left > div.store.for_gaq", ByType.cssSelector);
    // 客服
    Locator imButton = new Locator("#control_btn_inner_left > div.contact.for_gaq", ByType.cssSelector);
    // IM
    Locator iminput = new Locator("inputBar");
    // 发送
    Locator sendim = new Locator("span.send_btn", ByType.cssSelector);
    // 消息列表
    Locator messagelist = new Locator("div.txt_content_wrap", ByType.cssSelector);
    // 订单中心
    Locator orderCenterButton = new Locator("#common_hd > div", ByType.cssSelector);
    // 进店--底部导航
    Locator goShopButton = new Locator("goshop");
    // 商品分类
    Locator goodsategoryButton = new Locator("enter_shop_class");
    // 进入店铺
    Locator enterShopButton = new Locator("enter_shop");
    // 购物车
    Locator cartButton = new Locator("a.new_cart_btn.for_gaq", ByType.cssSelector);
    // 加入购物车
    Locator addCartButton = new Locator("add_cart");
    // 举报
    Locator love110 = new Locator("doReport1");
    // 认证
    Locator goodsAuth = new Locator("guarantee");
    // 优惠劵
    Locator couponButton = new Locator("li.coupon", ByType.cssSelector);
    // 我要提问
    Locator iWantToAskButton = new Locator("em.e1", ByType.cssSelector);
    // 立即购买
    Locator buy_now = new Locator("buy_now");

    // 商品名称
    Locator item_name = new Locator("item_name");
    // 商品价格
    Locator item_price = new Locator("item_price");
    // 商品销量
    Locator sold_number = new Locator("sold-number");
    // 商品收藏
    Locator collect_number = new Locator("collect-number");
    // 包邮
    Locator baoyou = new Locator("#free_delivery > span", ByType.cssSelector);
    // 店铺信息
    Locator shopName = new Locator("seller_name");
    // 商品分类列表
    Locator catelist = new Locator("#shop_classes_ul > li", ByType.cssSelector);
    // 分类列表商品
    Locator categoodslist = new Locator("#hot_ul > li", ByType.cssSelector);
    // 分类输入框
    Locator catesearch = new Locator("tb_search2");
    // 点击搜索按钮
    Locator search_button = new Locator("search_button");

    // 评价
    Locator comment = new Locator("comment");
    // 评价列表
    Locator commentlist = new Locator("#commentList > li", ByType.cssSelector);
    // 点击好评
    Locator goodcomment = new Locator("#item_show_wrap > ul > li:nth-child(2)", ByType.cssSelector);
    // 点击中评
    Locator middlecommnt = new Locator("#item_show_wrap > ul > li:nth-child(3)", ByType.cssSelector);
    // 点击差评
    Locator lowcomment = new Locator("#item_show_wrap > ul > li:nth-child(4)", ByType.cssSelector);
    // 点击更多评价
    Locator morecomment = new Locator("moreContent");
    // 评价列表页面title
    Locator commenttitle = new Locator("#common_hd > h1", ByType.cssSelector);

    // 问答
    Locator asktitle = new Locator("#askinfo > h2", ByType.cssSelector);
    // 问答列表
    Locator askinfos = new Locator("#askinfo > div.asklist > a", ByType.cssSelector);
    // 更多问答
    Locator moreask = new Locator("#askinfo > div.askBtn > span.span2", ByType.cssSelector);
    // 问题列表
    Locator askslist = new Locator("#askList > div > a", ByType.cssSelector);


    // 相关推荐商品列表
    Locator tuijian = new Locator("#hot_ul > li", ByType.cssSelector);
    // 相关推荐title
    Locator tjtitle = new Locator("#item_recommend > h3", ByType.cssSelector);

    // 确认按钮
    Locator getsubmitbutton = new Locator("control_bottom_submit");

    public WebDriver getDriver() {
        return driver;
    }

    public GoodsPage(WebDriver driver) throws Exception {
        super(driver);
//        driver.get("http://weidian.com/item.html?itemID=1763050342&p=0");
    }

    // 选择sku1
    Locator getsku1 = new Locator("#sku_ul > li > a", ByType.cssSelector);
    //商品页选择SKU
    public void selectSku1() throws Exception {
        click(getsku1);
    }
    // 点击加入购物车
    public void clickAddCartButton() throws Exception {
        click(addCartButton);
    }

    // 获取刚发送的消息
    public String getMessage() {
        List<WebElement> e = getMessagelist();
        return e.get(e.size() - 1).getText();
    }

    // 获取消息列表
    public List<WebElement> getMessagelist() {
        return getWebElements(messagelist);
    }

    // 发送im消息
    public void clickSendIm() throws Exception {
        click(sendim);
    }

    // 输入im内容
    public void typeImInput(String text) throws Exception {
        type(iminput, text);
    }

    // 获取推荐商品
    public List<WebElement> getTJList() throws Exception {
        scrollToElement(tjtitle);
        Thread.sleep(2000);
        return getWebElements(tuijian);
    }

    // 点击立即购买
    public void clickBuyNow() throws Exception {
        click(buy_now);
    }

    // 查看评论列表页面title
    public boolean isCommentList() throws IOException {
        return isElementExist(commenttitle);
    }

    // 问题列表
    public List<WebElement> getAskList() {
        return getWebElements(askslist);
    }

    // 问答列表
    public List<WebElement> getAskInfos() {
        return getWebElements(askinfos);
    }

    // 问答模块存在
    public boolean isAsktitle() throws IOException {
        scrollToElement(asktitle);
        return isElementExist(asktitle);
    }

    // 点击更多问答
    public void clickMoreAsk() throws Exception {
        scrollToElement(moreask);
        click(moreask);
    }

    // 获取好评列表
    public void clickGoodComment() throws Exception {
        click(goodcomment);
    }

    // 获取中评列表
    public void clickMiddleComment() throws Exception {
        click(middlecommnt);
    }

    // 获取差评列表
    public void clickLowComment() throws Exception {
        click(lowcomment);
    }

    // 获取全部评价列表
    public List<WebElement> getAllComment() {
        return getWebElements(commentlist);
    }

    // 点击更多评价
    public void clickMoreComment() throws Exception {
        scrollToElement(morecomment);
        click(morecomment);
    }
    // 评论
    public boolean isComment() throws IOException {
        scrollToElement(comment);
        return isElementExist(comment);
    }

    // 点击搜索按钮
    public void clickSearchButton() throws Exception {
        click(search_button);
    }

    // 输入搜索内容
    public void typeCateSearch(String cate) throws Exception {
        type(catesearch, cate);
    }

    // 获取商品列表
    public List<WebElement> getCateGoodsList() {
        return getWebElements(categoodslist);
    }

    // 获取分类列表
    public List<WebElement> getCatelist() {
        return getWebElements(catelist);
    }

    // 店铺信息
    public String getShopName() throws Exception {
        return getText(shopName);
    }

    // 包邮
    public String getBaoYou() throws Exception {
        scrollToElement(baoyou);
        return getText(baoyou);
    }

    // 商品收藏
    public String getCollectNumber() throws Exception {
        return getText(collect_number);
    }

    // 商品销量
    public String getSoldNumber() throws Exception {
        return getText(sold_number);
    }

    // 获取价格
    public String getItemPrice() throws Exception {
        return getText(item_price);
    }

    // 获取商品名称
    public String getItemName() throws Exception {
        return getText(item_name);
    }

    // 点击收藏
    public void clickFavoriteButton() throws Exception {
        click(favoriteButton);
    }

    // 点击客服
    public void clickImButton() throws Exception {
        click(imButton);
    }

    // 点击订单中心
    public void clickOrderCenterButton() throws Exception {
        click(orderCenterButton);
    }

    // 点击进店--底部导航
    public void clickGoShopButton() throws Exception {
        click(goShopButton);
    }

    // 点击商品分类
    public void clickGoodsategoryButton() throws Exception {
        scrollToElement(goodsategoryButton);
        click(goodsategoryButton);
    }

    // 点击进入店铺
    public void clickEnterShopButton() throws Exception {
        click(enterShopButton);
    }

    // 点击购物车按钮
    public void clickCartButton() throws Exception {
        click(cartButton);
    }

    // 点击举报
    public void clickLove110() throws Exception {
        click(love110);
    }

    // 点击商品认证
    public void clickGoodsAuth() throws Exception {
        click(goodsAuth);
    }

    // 点击优惠劵
    public void clickCouponButton() throws Exception {
        scrollToElement(couponButton);
        click(couponButton);
    }

    // 检查优惠劵
    public boolean isCoupon() throws IOException {
        scrollToElement(couponButton);
        return isElementExist(couponButton);
    }

    // 点击我要提问
    public void clickIWantToAskButton() throws Exception {
        scrollToElement(iWantToAskButton);
        click(iWantToAskButton);
    }

    // 点击返回按钮
    public void clickhd_backButton() throws Exception {
        click(hd_backButton);
    }


    public String getPageUrl() {
        return pageUrl;
    }

    public String getPageUrl1() {
        return pageUrl1;
    }

    // 点击确认按钮
    public void clickSubmitButton ( ) throws Exception {
        click(getsubmitbutton);
    }
}
