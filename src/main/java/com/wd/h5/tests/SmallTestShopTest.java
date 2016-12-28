package com.wd.h5.tests;

import com.wd.h5.action.CommonLogin;
import com.wd.h5.page.LoginPage;
import com.wd.h5.page.OrderCenterPage;
import com.wd.h5.page.ShopPage;
import com.wd.libarary.DriverFactory;
import com.wd.libarary.Locator;
import com.wd.libarary.TestNGListener;
import com.wd.libarary.UITest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.util.List;

/**
 * Created by ike on 16/10/10.
 */
@Listeners({TestNGListener.class})
public class SmallTestShopTest extends UITest {

    // 获取driver
    WebDriver driver = DriverFactory.getMobileForChromeRemoteDriver();

    @BeforeMethod(alwaysRun = true)
    public void init() {
        super.init(driver);
    }

    @Test(description = "店铺页查看店铺信息展示")
    public void checkShopInfo() throws Exception {
        ShopPage shopPage = PageFactory.initElements(driver, ShopPage.class);
        driver.get(shopPage.getPageUrl());
        Thread.sleep(1000);
        // 检查店铺名称
        Assert.assertEquals(shopPage.getShopName(), "艾克的店");
        // 检查店铺公告
        Assert.assertTrue(shopPage.getShopNoteText().contains("店铺装修"));
        // 未完待续
    }

    @Test(description = "检查店铺优惠展示")
    public void checkShopSales() {

    }

    @Test(description = "检查友情店铺")
    public void checkFriendShop() {
        ShopPage shopPage = PageFactory.initElements(driver, ShopPage.class);
        driver.get(shopPage.getPageUrl());
        List<WebElement> e = shopPage.getFriendShop();
        // 检查是否是2个友情店铺
        Assert.assertEquals(e.size(), 2);
        String fsurl = "";
        // 第一个友情店铺名称和url
        Assert.assertEquals(e.get(0).getText(), "smile");
        fsurl = e.get(0).findElement(By.cssSelector("a.frd_a.rel")).getAttribute("href");
        Assert.assertEquals(fsurl, "https://weidian.com/?userid=168280768&frid=3073080");
        // 第二个友情店铺名称和url
        fsurl = e.get(1).findElement(By.cssSelector("a.frd_a.rel")).getAttribute("href");
        Assert.assertEquals(fsurl, "https://weidian.com/?userid=902601999&frid=3073080");
        Assert.assertEquals(e.get(1).getText(), "测试微中心");

    }

    @Test(description = "店铺分类列表")
    public void checkShopCateList() throws Exception {
        ShopPage shopPage = PageFactory.initElements(driver, ShopPage.class);
        driver.get(shopPage.getPageUrl());
        shopPage.clickCategoryButton();
        Thread.sleep(5000);
        List<WebElement> e = shopPage.getCatelist();
        // 店铺分类数
        Assert.assertEquals(e.size(), 30);
        // 分类名称选择
        String s = e.get(0).findElement(By.cssSelector("span")).getText();
        Assert.assertEquals(s, "44");
    }

    @Test(description = "店铺分类商品")
    public void checkShopCateGood() throws Exception {
        ShopPage shopPage = PageFactory.initElements(driver, ShopPage.class);
        driver.get(shopPage.getPageUrl());
        shopPage.clickCategoryButton();
        Thread.sleep(5000);
        shopPage.typeCateInput("化学");
        Thread.sleep(2000);
        shopPage.clickSearchBtn();
        Thread.sleep(3000);
        List<WebElement> e = shopPage.getCateGoodsList();
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

    @Test(description = "发现--每日推荐")
    public void checkFindmrtj() throws Exception {
        ShopPage shopPage = PageFactory.initElements(driver, ShopPage.class);
        driver.get(shopPage.getPageUrl());
        shopPage.clickFindButton();
        Thread.sleep(3000);
        List<WebElement> e = shopPage.getFindlist();
        // 判断商品列表数大于0
        Assert.assertTrue(0 < e.size());
    }

    @Test(description = "发现--时尚靓点")
    public void checkFindshld() throws Exception {
        ShopPage shopPage = PageFactory.initElements(driver, ShopPage.class);
        driver.get(shopPage.getPageUrl());
        shopPage.clickFindButton();
        Thread.sleep(3000);
        shopPage.clickshld();
        Thread.sleep(3000);
        List<WebElement> e = shopPage.getFindlist();
        // 判断商品列表数大于0
        Assert.assertTrue(0 < e.size());
    }

    @Test(description = "发现--吃货攻略")
    public void checkFindchgl() throws Exception {
        ShopPage shopPage = PageFactory.initElements(driver, ShopPage.class);
        driver.get(shopPage.getPageUrl());
        shopPage.clickFindButton();
        Thread.sleep(3000);
        shopPage.clickchgl();
        Thread.sleep(3000);
        List<WebElement> e = shopPage.getFindlist();
        // 判断商品列表数大于0
        Assert.assertTrue(0 < e.size());
    }

    @Test(description = "联系卖家")
    public void checkShopIm() throws Exception {
        CommonLogin.setDriver(driver);
        ShopPage shopPage = PageFactory.initElements(driver, ShopPage.class);
        driver.get(shopPage.getPageUrl());
        shopPage.clickImButton();
        Thread.sleep(2000);
        CommonLogin.login();
        shopPage.typeImInput("测试im");
        Thread.sleep(2000);
        shopPage.clickSendIm();
        Thread.sleep(3000);
        Assert.assertEquals(shopPage.getMessage(), "测试im");
        driver.get("https://i.weidian.com/index.php");
//        shopPage.clickOrderCenterButton();
        OrderCenterPage orderCenterPage = PageFactory.initElements(driver, OrderCenterPage.class);
        orderCenterPage.clickSignOutButton();
    }


    @AfterClass(alwaysRun = true)
    public void stop() {
        super.stop();
    }


}
