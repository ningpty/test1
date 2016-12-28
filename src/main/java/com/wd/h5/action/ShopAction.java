package com.wd.h5.action;

import org.openqa.selenium.WebDriver;

/**
 * Created by ike on 16/8/2.
 */
public class ShopAction {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }


    public static void setDriver(WebDriver driver) {
        ShopAction.driver = driver;
    }


}
