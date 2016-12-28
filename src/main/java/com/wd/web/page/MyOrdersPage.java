package com.wd.web.page;

import com.wd.libarary.BasePage;
import com.wd.libarary.Locator;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class MyOrdersPage extends BasePage{
	

	Locator orderCenter = new Locator("orderCenter",10);
	
	public MyOrdersPage(WebDriver driver) throws Exception {
		super(driver);
	}
	
	public boolean isPrestentProfile() throws IOException {
		System.out.println("++++++++++++++++++"+orderCenter.getElement());
		return isElementPresent(orderCenter,10);

	}
	
	
	
	
	

}
