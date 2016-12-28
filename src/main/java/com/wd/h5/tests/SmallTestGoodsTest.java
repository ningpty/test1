package com.wd.h5.tests;

import com.wd.h5.action.CommonLogin;
import com.wd.h5.page.ConfirmPurchasePage;
import com.wd.h5.page.GoodsPage;
import com.wd.h5.page.OrderCenterPage;
import com.wd.h5.page.ShopPage;
import com.wd.libarary.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by ike on 16/10/13.
 */
@Listeners({TestNGListener.class})
public class SmallTestGoodsTest extends UITest {

    // 获取driver
    WebDriver driver = DriverFactory.getMobileForChromeRemoteDriver();

    @BeforeMethod(alwaysRun = true)
    public void init() {
        super.init(driver);
    }

    @Test(description = "查看商品信息")
    public void checkGoodsInfo() throws Exception {
        GoodsPage goodsPage = PageFactory.initElements(driver, GoodsPage.class);
        driver.get(goodsPage.getPageUrl());
        // 商品销量
        int soldNumber = Integer.parseInt(goodsPage.getSoldNumber());
        Assert.assertTrue(soldNumber > 1000);
        // 商品名称
        Assert.assertEquals("天青I 蔚蓝Ⅰ天青1 蔚蓝1 BS IND 25克/瓶", goodsPage.getItemName());
        // 商品价格
        Assert.assertEquals("¥0.10", goodsPage.getItemPrice());
        // 商品收藏
        int collect_number = Integer.parseInt(goodsPage.getCollectNumber());
        Assert.assertTrue(collect_number > 0);
    }

    @Test(description = "查看商品优惠信息")
    public void checkGoodsDiscount() throws Exception {
        GoodsPage goodsPage = PageFactory.initElements(driver, GoodsPage.class);
        driver.get(goodsPage.getPageUrl());
        Thread.sleep(2000);
        Assert.assertEquals("包邮", goodsPage.getBaoYou());
        Assert.assertTrue(goodsPage.isCoupon());
    }

    @Test(description = "商品分类列表")
    public void checkShopCateList() throws Exception {
        GoodsPage goodsPage = PageFactory.initElements(driver, GoodsPage.class);
        driver.get(goodsPage.getPageUrl());
        Thread.sleep(2000);
        goodsPage.clickGoodsategoryButton();
        Thread.sleep(3000);
        List<WebElement> e = goodsPage.getCatelist();
        // 店铺分类数
        Assert.assertEquals(e.size(), 30);
        // 分类名称选择
        String s = e.get(0).findElement(By.cssSelector("a")).getText();
        Assert.assertEquals(s, "44");
    }

    @Test(description = "商品分类商品")
    public void checkShopCateGood() throws Exception {
        GoodsPage goodsPage = PageFactory.initElements(driver, GoodsPage.class);
        driver.get(goodsPage.getPageUrl());
        goodsPage.clickGoodsategoryButton();
        Thread.sleep(5000);
        goodsPage.typeCateSearch("化学");
        Thread.sleep(2000);
        goodsPage.clickSearchButton();
        Thread.sleep(3000);
        List<WebElement> e = goodsPage.getCateGoodsList();
        // 分类搜索商品默认展示10条
        Assert.assertEquals(e.size(), 10);
        // 第一个商品名称,价格和url
        Assert.assertEquals(e.get(0).findElement(By.cssSelector("p.i_txt ")).getText(), "8-羟基喹啉 8-氢氧化喹啉，8-羟基氮萘 化学试剂 AR 500克/瓶");
        // 价格
        Assert.assertEquals(e.get(0).findElement(By.cssSelector("span.i_pri ")).getText(), "¥350.00");
        // 图片url
        String img = "https://si.geilicdn.com/vshop903042-1409304634-143770.jpg?w=400&h=400&cp=1";
        Assert.assertEquals(e.get(0).findElement(By.cssSelector("img")).getAttribute("data-src"), img);
    }

    @Test(description = "查看商品评价模块存在")
    public void checkComment() throws IOException {
        GoodsPage goodsPage = PageFactory.initElements(driver, GoodsPage.class);
        driver.get(goodsPage.getPageUrl());
        Assert.assertTrue(goodsPage.isComment());
    }

    @Test(description = "获取全部评价--已存在评价")
    public void checkAllComment() throws Exception {
        GoodsPage goodsPage = PageFactory.initElements(driver, GoodsPage.class);
        driver.get(goodsPage.getPageUrl());
        goodsPage.clickMoreComment();
        Thread.sleep(2000);
        List<WebElement> e = goodsPage.getAllComment();
        // 店铺存在评价
        Assert.assertTrue(e.size() >= 1);
    }

    @Test(description = "评价列表好评")
    public void checkGoodComment() throws Exception {
        GoodsPage goodsPage = PageFactory.initElements(driver, GoodsPage.class);
        // 检查是不是评论列表页面
        CheckPage(goodsPage, "评论");
        goodsPage.clickGoodComment();
        Thread.sleep(2000);
        List<WebElement> e = goodsPage.getAllComment();
        // 店铺存在评价
        Assert.assertTrue(e.size() >= 1);

    }

    @Test(description = "评价列表中评")
    public void checkMiddleComment() throws Exception {

        GoodsPage goodsPage = PageFactory.initElements(driver, GoodsPage.class);
        // 检查是不是评论列表页面
        CheckPage(goodsPage, "评论");
        goodsPage.clickMiddleComment();
        Thread.sleep(2000);
        List<WebElement> e = goodsPage.getAllComment();
        // 店铺存在评价
        Assert.assertTrue(e.size() >= 1);

    }

    @Test(description = "评价列表差评")
    public void checkLowComment() throws Exception {
        GoodsPage goodsPage = PageFactory.initElements(driver, GoodsPage.class);
        // 检查是不是评论列表页面
        CheckPage(goodsPage, "评论");
        goodsPage.clickLowComment();
        Thread.sleep(2000);
        List<WebElement> e = goodsPage.getAllComment();
        Assert.assertEquals(e.get(0).getText(), "暂无评论");
    }

    @Test(description = "检查问答模块显示")
    public void checkAsk() throws IOException {
        GoodsPage goodsPage = PageFactory.initElements(driver, GoodsPage.class);
        driver.get(goodsPage.pageUrl);
        Assert.assertTrue(goodsPage.isAsktitle());
    }

    @Test(description = "检查问答问题列表")
    public void checkMoreAsk() throws Exception {
        GoodsPage goodsPage = PageFactory.initElements(driver, GoodsPage.class);
        driver.get(goodsPage.pageUrl);
        goodsPage.clickMoreAsk();
        Thread.sleep(2000);
        List<WebElement> e = goodsPage.getAskList();
        Assert.assertTrue(e.size() >= 1);
    }

    @Test(description = "检查商品页面立即购买")
    public void checkBuyNow() throws Exception {
        GoodsPage goodsPage = PageFactory.initElements(driver, GoodsPage.class);
        driver.get(goodsPage.pageUrl);
        goodsPage.clickBuyNow();
        Thread.sleep(3000);
        ConfirmPurchasePage cp = PageFactory.initElements(driver, ConfirmPurchasePage.class);
        Assert.assertTrue(cp.isCPTitle());
    }

    @Test(description = "检查商品相关推荐")
    public void checkTJList() throws Exception {
        GoodsPage goodsPage = PageFactory.initElements(driver, GoodsPage.class);
        driver.get(goodsPage.pageUrl);
        Thread.sleep(3000);
        List<WebElement> e = goodsPage.getTJList();
        System.out.println(e.size());
        Assert.assertTrue(e.size() >= 1);
    }

    @Test(description = "客服")
    public void checkShopIm() throws Exception {
        CommonLogin.setDriver(driver);
        GoodsPage goodsPage = PageFactory.initElements(driver, GoodsPage.class);
        driver.get(goodsPage.getPageUrl());
        goodsPage.clickImButton();
        Thread.sleep(2000);
        CommonLogin.login();
        goodsPage.typeImInput("测试im");
        Thread.sleep(2000);
        goodsPage.clickSendIm();
        Thread.sleep(3000);
        Assert.assertEquals(goodsPage.getMessage(), "测试im");
        driver.get("https://i.weidian.com/index.php");
//        goodsPage.clickOrderCenterButton();
        OrderCenterPage orderCenterPage = PageFactory.initElements(driver, OrderCenterPage.class);
        orderCenterPage.clickSignOutButton();
    }


    public void CheckPage(GoodsPage goodsPage, String page) throws Exception {

        switch (page) {
            case "评论":
                if (!goodsPage.isCommentList()) {
                    driver.get(goodsPage.pageUrl);
                    goodsPage.clickMoreComment();
                }
                break;
            case "问答":
                driver.get(goodsPage.pageUrl);
                goodsPage.clickMoreAsk();
                break;
            default:
                break;
        }


    }


    @AfterClass(alwaysRun = true)
    public void stop() {
        super.stop();
    }


}
