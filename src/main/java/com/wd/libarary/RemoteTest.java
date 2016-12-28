package com.wd.libarary;

import java.net.MalformedURLException;   
import java.net.URL;   
    

import org.openqa.selenium.WebDriver;   
import org.openqa.selenium.remote.DesiredCapabilities;   
import org.openqa.selenium.remote.RemoteWebDriver;   
    
public class RemoteTest {
    
    /**  
     * @throws MalformedURLException  
     */  
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities test = DesiredCapabilities.chrome();
        WebDriver dr = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),test);
        dr.get("http://www.baidu.com");
        try {
			Thread.sleep(10000);
			System.out.println("In The End");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }   
} 