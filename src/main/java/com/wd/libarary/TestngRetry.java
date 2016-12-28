package com.wd.libarary;

import java.io.IOException;
import java.util.Properties;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;
/**
 * testng失败后重试J
 * @author WD
 *
 */
public class TestngRetry implements IRetryAnalyzer{
	private int retryCount = 1;
	private static int maxRetryCount;
	private static Properties p = null;
	private static String config = System.getProperty("user.dir")
			+ "/classes/config.properties";
	static Log log = new Log(DriverFactory.class);


	static {
		try {
			p = ConfigUtils.getProperties(config);
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		if (p != null) {
			maxRetryCount = Integer.parseInt(p.getProperty("maxRetryCount"));
			
		}
		log.info("maxRunCount=" + (maxRetryCount));
	}

	@Override
	public boolean retry(ITestResult result) {
		if (retryCount <= maxRetryCount) {
			String message = "running retry for  '" + result.getName() + "' on class " + 
                                       this.getClass().getName() + " Retrying " + retryCount + " times";
			log.info(message);
			Reporter.setCurrentTestResult(result);
			Reporter.log("RunCount=" + (retryCount + 1));
			retryCount++;
			return true;
		}
		return false;
	}
}
