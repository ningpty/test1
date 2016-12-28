package com.wd.h5.page;

import com.wd.libarary.BasePage;
import com.wd.libarary.Locator;
import com.wd.libarary.Locator.ByType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.security.PublicKey;
import java.util.List;


/**
 * Created by ike on 16/8/1.
 * 店铺页面
 */
public class ShopPage extends BasePage {

    WebDriver driver;


    public String pageUrl = "http://weidian.com/?userid=3073080";

    // ----------------------页面元素----------------------
    // 收藏
    Locator favoriteButton = new Locator("li.store.for_gaq", ByType.cssSelector);
    // 联系卖家
    Locator imButton = new Locator("#footerBtn > ul > li.contact.for_gaq", 5, ByType.cssSelector);
    // 发现
    Locator findButton = new Locator("#footerBtn > ul > li.dynamic.for_gaq", ByType.cssSelector);
    // 分类
    Locator categoryButton = new Locator("#footerBtn > ul > li.classify.for_gaq", ByType.cssSelector);
    // 订单中心
    Locator orderCenterButton = new Locator("#common_hd > div", ByType.cssSelector);
    // 店铺动态
    Locator shopDynamicButton = new Locator("div.shop-dynamic", ByType.cssSelector);
    // 店铺icon
    Locator shopIconButton = new Locator("vshop_icon");
    // IM 聊天用户信息
    Locator imUserInfo = new Locator("div.user_info", ByType.cssSelector);
    // im 返回
    Locator hd_backButton = new Locator("a.hd_back", ByType.cssSelector);
    // 优惠劵
    Locator couponButton = new Locator("li.coupon", ByType.cssSelector);

    // 店铺名称
    Locator hd_name = new Locator("hd_name");
    // 获取店铺担保交易服务
    Locator danbao = new Locator("span.guarantee-icon.g_danbao", ByType.cssSelector);
    // 获取货到付款服务
    Locator huodaofukuan = new Locator("span.guarantee-icon.g_cashondelivery", ByType.cssSelector);
    // 店长实名认证
    Locator shimingrenzheng = new Locator("span.guarantee-icon.g_brand_realname", ByType.cssSelector);
    // 店铺公告
    Locator hd_note = new Locator("hd_note");
    // 装修购物车2 title
    Locator zx_title = new Locator("#tuijianItem > h3 > p", ByType.cssSelector);
    // 商品名称 --- 指定商品测试加入购物车2中的商品
    Locator good_name = new Locator("#tuijianItem > ul > li:nth-child(1) > a > p", ByType.cssSelector);
    // 商品图片url
    Locator good_img = new Locator("#tuijianItem > ul > li:nth-child(1) > a > div.img-wrapper > div > span > img", ByType.cssSelector);
    // 商品价格
    Locator good_price = new Locator("#tuijianItem > ul > li:nth-child(1) > a > div.i_pri_wrap > p", ByType.cssSelector);
    // 店长推荐
    // 热卖商品

    //    购物车
    Locator enterCartLocator = new Locator(".new_cart_btn for_gaq icon-cart", ByType.cssSelector);

    // 友情店铺
    Locator friendShop = new Locator("#frd_ul > li", ByType.cssSelector);
    // 商品分类列表
    Locator catelist = new Locator("#classListScrollWrapper > ul > li", ByType.cssSelector);
    // 分类输入框
    Locator cateinput = new Locator("input.search.block.wrap", ByType.cssSelector);
    // 搜索按钮
    Locator searchbtn = new Locator("#classifyPanel > div.wrap > div.search-wrap > span", ByType.cssSelector);
    // 分类商品列表
    Locator categoodslist = new Locator("li.i_li.left", ByType.cssSelector);
    // 购物车按钮
    Locator cartbutton = new Locator("a.new_cart_btn.for_gaq.icon-cart", ByType.cssSelector);
    // 加入购物车按钮1
    Locator addtocart1 = new Locator("#tuijianItem > ul > li:nth-child(1) > a > div.i_pri_wrap > div", ByType.cssSelector);
    // 选择sku1
    Locator getsku1 = new Locator("#sku_ul > li > a", ByType.cssSelector);
    // 确认按钮
    Locator getsubmitbutton = new Locator("control_bottom_submit");
    // 加入购物车按钮2
    Locator addtocart2 = new Locator("#tuijianItem > ul > li:nth-child(2) > a > div.i_pri_wrap > div", ByType.cssSelector);

    // -------------------发现-------------------
    // 发现header
    Locator find_header = new Locator("#diaryHeader > a", ByType.cssSelector);
    // 时尚靓点
    Locator shld = new Locator("#diaryHeader > a:nth-child(2) > span", ByType.cssSelector);
    // 吃货攻略
    Locator chgl = new Locator("#diaryHeader > a:nth-child(3) > span", ByType.cssSelector);
    // 列表内容
    Locator findlist = new Locator("#diaryList > a", ByType.cssSelector);

    // IM
    Locator iminput = new Locator("inputBar");
    // 发送
    Locator sendim = new Locator("span.send_btn", ByType.cssSelector);
    // 消息列表
    Locator messagelist = new Locator("div.txt_content_wrap", ByType.cssSelector);
    // 消息


    //商品列表页
    Locator shopGoodsList = new Locator("li.list-item.single-column > a[href='https://weidian.com/i/1046419956']",ByType.cssSelector);

    public WebDriver getDriver() {
        return driver;
    }

    public ShopPage(WebDriver driver) throws Exception {
        super(driver);
//        driver.get("http://weidian.com/?userid=3073080");
    }

    // 点击购物车按钮
    public void clickCartButton() throws Exception {
        click(cartbutton);
    }
    //点击加入购物车按钮1
    public void clickAddToCart1() throws Exception {
        scrollToElement(addtocart1);
        click(addtocart1);
    }

    // 选择sku1
    public void selectSku1() throws Exception {
        click(getsku1);
    }

    // 点击确认按钮
    public void clickSubmitButton ( ) throws Exception {
        click(getsubmitbutton);
    }

    //点击加入购物车按钮2
    public void clickAddToCart2() throws Exception {
        scrollToElement(addtocart2);
        click(addtocart2);
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

    // 获取每日推荐列表
    public List<WebElement> getFindlist() {
        return getWebElements(findlist);
    }

    // 点击吃货攻略
    public void clickchgl() throws Exception {
        click(chgl);
    }

    // 点击时尚靓点
    public void clickshld() throws Exception {
//        List<WebElement> e = getFindHeader();
//        e.get(1).findElement(By.cssSelector("a.diary-nav.for_gaq ")).click();
        click(shld);

    }

    // 获取发现tab列表
    public List<WebElement> getFindHeader() {
        return getWebElements(find_header);
    }

    // 获取商品列表
    public List<WebElement> getCateGoodsList() {
        return getWebElements(categoodslist);
    }

    // 点击搜索
    public void clickSearchBtn() throws Exception {
        click(searchbtn);
    }

    // 输入分类输入
    public void typeCateInput(String cate) throws Exception {
        type(cateinput, cate);
    }

    // 获取分类列表
    public List<WebElement> getCatelist() {
        return getWebElements(catelist);
    }

    // 获取友情店铺列表
    public List<WebElement> getFriendShop() {
        return getWebElements(friendShop);
    }

    // 获取商品名称---指定商品测试加入购物车2中的商品
    public String getGoodImg() throws Exception {
        scrollToElement(good_img);
        // 存在懒加载  所以直接使用懒加载的图片url
        return getAttribute(good_img, "data-src");
    }

    // 获取商品名称---指定商品测试加入购物车2中的商品
    public String getGoodNameText() throws Exception {
        scrollToElement(good_name);
        return getText(good_name);
    }

    // 获取店铺公告
    public String getShopNoteText() throws Exception {
        return getText(hd_note);
    }

    // 获取店长实名认证
    public String getShiMingRenZhengText() throws Exception {
        return getText(shimingrenzheng);
    }

    // 获取货到付款文案
    public String getHuoDaoFuKuanText() throws Exception {
        return getText(huodaofukuan);
    }

    // 获取担保交易文案
    public String getDanBaoText() throws Exception {
        return getText(danbao);
    }

    // 获取店铺名称
    public String getShopName() throws Exception {
        return getText(hd_name);
    }

    // 获取店铺url
    public String getPageUrl() {
        return pageUrl;
    }

    public void clickFavoriteButton() throws Exception {
        click(favoriteButton);
    }

    public void clickImButton() throws Exception {
        click(imButton);
    }

    public void clickFindButton() throws Exception {
        click(findButton);
    }

    public void clickCategoryButton() throws Exception {
        click(categoryButton);
    }

    public void clickOrderCenterButton() throws Exception {
        click(orderCenterButton);
    }

    public void clickShopDynamic() throws Exception {
        click(shopDynamicButton);
    }

    public void clickShopIconButton() throws Exception {
        click(shopIconButton);
    }

    public void clickhd_backButton() throws Exception {
        click(hd_backButton);
    }

    public void clickCouponButton() throws Exception {
        click(couponButton);
    }

    // 判断登陆之后im中元素存在
    public boolean userInfoIsExist() throws Exception {
        return isElementExist(imUserInfo);

    }

    Locator goodsLocator = new Locator("div.i_cart.abs.addCart",ByType.cssSelector);

    /**
     * 获取店铺商品列表信息
     * @return
     * @throws Exception
     */
    public List<WebElement>  getShopGoodsList() throws  Exception {

        //click(shopGoodsList);
        return getWebElements(goodsLocator);

    }

}
