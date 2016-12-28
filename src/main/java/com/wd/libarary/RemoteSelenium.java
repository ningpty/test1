package com.wd.libarary;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteSelenium extends Thread {
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities capability = DesiredCapabilities.firefox();
		WebDriver driver = new RemoteWebDriver(new URL(
				"http://localhost:4444/wd/hub"), capability);
		capability.setBrowserName("firefox");
//		capability.setVersion("3.6");
		driver.get("http://www.baidu.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}

	// public static void main(String[] args) {
	// // 同时启动1000个线程，去进行i++计算，看看实际结果
	// for (int i = 0; i < 3; i++) {
	// new Thread(new Runnable() {
	// @Override
	// public void run() {
	// DesiredCapabilities capability = DesiredCapabilities
	// .firefox();
	// capability.setBrowserName("firefox");
	// // capability.setCapability("VISTA","windows 7");
	// // capability.setVersion("47.0.1");
	// WebDriver driver;
	// try {
	// driver = new RemoteWebDriver(new URL(
	// "http://localhost:4444/wd/hub"), capability);
	// driver.get("http://www.baidu.com");
	// driver.manage().window().maximize();
	// driver.manage().timeouts()
	// .pageLoadTimeout(60, TimeUnit.SECONDS);
	// try {
	// Thread.sleep(20000);
	// } catch (InterruptedException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// driver.quit();
	// } catch (MalformedURLException e1) {
	// // TODO Auto-generated catch block
	// e1.printStackTrace();
	// }
	//
	// }
	// }).start();
	// }
	// }

}