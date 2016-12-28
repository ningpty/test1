/**
 * 
 */
package com.wd.libarary;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;



/**
     * @author WD
 *
 */
public class UITest {
	static WebDriver driver;
	Log log = new Log(this.getClass());

	public static WebDriver getDriver() {
		return driver;
	}
	
	/**
	 * init test case
	 * 
	 * @param driver
	 */
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void init(WebDriver driver) {
		log.info("Start WebDriver");
		setDriver(driver);
	}

	/**
	 * stop webdriver
	 * 
	 *
	 */
	public void stop() {
		log.info("Stop WebDriver");
		driver.quit();

	}

	/**
     * @author WD
	 */
	public void takeScreenShot() {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		String dateStr = sf.format(date);
		String path = "/logs/screenshot/" + this.getClass().getSimpleName() + "_" + dateStr + ".png";
		takeScreenShot((TakesScreenshot) this.getDriver(), path);
	}

	/**
     * @author WD
	 * @param drivername
	 * @param path
	 */
	public void takeScreenShot(TakesScreenshot drivername, String path) {
		// this method will take screen shot ,require two parameters ,one is
		// driver name, another is file name
		String currentPath = System.getProperty("user.dir"); // get current work
		log.info(currentPath);
		File scrFile = drivername.getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy
		try {
			log.info("save snapshot path is:" + currentPath + path);
			FileUtils.copyFile(scrFile, new File(currentPath +  path));
		} catch (Exception e) {
			log.error("Can't save screenshot");
			e.printStackTrace();
		} finally {
			log.info("screen shot finished");
		}
	}

	/**
	 * 新增一个截图,目的是新报告中增加图片展示
	 */
	public void takeScreenShot(String imgName) {
		String path = "/logs/imgs/" + imgName + ".png";
		takeScreenShot((TakesScreenshot) this.getDriver(), path);
	}
	
	public static void sikuliClickPic(String picture) throws InterruptedException, FindFailed {
		Thread.sleep(2000);
		Screen screen = new Screen();
		Thread.sleep(2000);
	    Pattern pic=new Pattern(picture);
	    Thread.sleep(2000);
	    screen.click(pic);
	    Thread.sleep(2000);
	}


	
	
	
	
	
}
