package com.wd.web.page;

import com.wd.libarary.BasePage;
import com.wd.libarary.Locator;
import com.wd.libarary.Locator.ByType;

import org.openqa.selenium.WebDriver;

import java.io.IOException;


public class HomePage extends BasePage {
	Locator signOut = new Locator("a.quit",ByType.cssSelector);//实例化元素时，声明等待时间为多少秒，即等待多少秒。
	//页面左侧商品管理按钮
	Locator commodityManagement = new Locator("a[data-for-gaq='商品管理']",5,ByType.cssSelector);
	
	public HomePage(WebDriver driver) throws Exception {
		super(driver);
	}

	//判断退出按钮是否存在
	public boolean isElementExistSignOut() throws IOException {
		return isElementExist(signOut);
	}
	
	//判断商品管理按钮是否存在
	public boolean isElementExistCommodityManagement() throws IOException {
		return isElementExist(commodityManagement);
	}
	
	//单击商品管理按钮
	public void clickCommodityManagementPageButton() throws Exception {
		click(commodityManagement);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
