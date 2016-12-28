package com.wd.libarary;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;

public class ChangeWindow {
	
	/**
	 * 通过窗口句柄切换窗口
	 * @param driver
	 * @throws Exception
	 */
	public static void switchToWindowUseHandle(WebDriver driver) throws Exception {
		String[] handles=new String[driver.getWindowHandles().size()];
		driver.getWindowHandles().toArray(handles);
		driver.switchTo().window(handles[1]);
	}
	
	public static void closeWindowBlack(WebDriver driver) throws Exception {
		String[] handles=new String[driver.getWindowHandles().size()];
		driver.getWindowHandles().toArray(handles);
		WebDriver window = driver.switchTo().window(handles[1]);
		window.close();//关闭新窗口
		driver.switchTo().window(handles[0]);
		}
	
	/**
	 * 通过窗口title来切换窗口
	 * @param driver
	 * @param windowTitle
	 * @return
	 */
	public static boolean switchToWindowUseTitle(WebDriver driver,String windowTitle){  
	    boolean flag = false;  
	    try {  
	        String currentHandle = driver.getWindowHandle();  
	        Set<String> handles = driver.getWindowHandles();  
	        for (String s : handles) {  
	            if (s.equals(currentHandle))  
	                continue;  
	            else {  
	                driver.switchTo().window(s);  
	                if (driver.getTitle().contains(windowTitle)) {  
	                    flag = true;  
	                    System.out.println("Switch to window: "  
	                            + windowTitle + " successfully!");  
	                    break;  
	                } else  
	                    continue;  
	            }  
	        }  
	    } catch (NoSuchWindowException e) {  
	        System.out.println("Window: " + windowTitle  
	                + " cound not found!");  
	        flag = false;  
	    }  
	    return flag;  
	} 
	
	
	
}
