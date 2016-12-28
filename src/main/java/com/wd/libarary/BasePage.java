package com.wd.libarary;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;//用来做动作组合,最后使用 perform 方法执行
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class BasePage {

	protected WebDriver driver;
	// protected String[][] locatorMap;
	String path;
	protected Log log = new Log(this.getClass());

	//赋值driver，并且，读取对应文件的xml
	protected BasePage(WebDriver driver) throws Exception {
		this.driver = driver;
	}

	//给locator输入框赋值
	protected void type(Locator locator, String values) throws Exception {
		WebElement e = findElement(driver, locator);
		log.info("type value is:  " + values);
		e.sendKeys(values);
	}

	/**
	 * This Method is for set value use javascript
	 * 
     * @author WD
	 * @param locator
	 * @param values
	 * @throws Exception
	 */
	//使用js来赋值，用于不规则控件，selenium无法处理时，将value属性标签赋值
	protected void typeQuick(Locator locator, String values) throws Exception {
		WebElement e = findElement(driver, locator);
		log.info("type value is:  " + values);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value=\"" + values + "\"", e);

	}
	
	//获取控件属性值
	protected String getAttribute(Locator locator,String name) throws Exception {
		WebElement e = findElement(driver, locator);
		log.info("get text");
		return e.getAttribute(name);
	}
		

	/**
     * @author WD
	 * @param locator
	 * @param text
	 */
	//使用js来赋值，用在没有value属性标签时使用
	protected void setRichTextBox(Locator locator, String text) {
		WebElement e = findElement(driver, locator);
		log.info("type value is:  " + text);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].innerHTML = \"" + text + "\"", e);
	}

	/**
     * @author WD
	 * @param locator
	 * @param text
	 * @return
	 */
	//使用js来获取text内容
	protected String getRichTextBox(Locator locator, String text) {
		WebElement e = findElement(driver, locator);
		log.info("type value is:  " + text);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String result = (String) js.executeScript(
				"arguments[0].getInnerHTML()", e);
		return result;
	}

	
	//获取控件文本值
	protected String getText(Locator locator) throws Exception {
		WebElement e = findElement(driver, locator);
		log.info("get text");
		return e.getText();
	}

	/**
     * @author WD
	 * @param locator
	 */
	//使用js来进行滚动操作,true表示尽量将元素显式在视口中部（垂直方向）。
	protected void scrollToElement(Locator locator) {
		WebElement e = findElement(driver, locator);
		log.info("scroll view element");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// roll down and keep the element to the center of browser
		js.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", e);
	}
	
	//单击控件
	protected void click(Locator locator) throws Exception {
		WebElement e = findElement(driver, locator);
		log.info("click button");
		e.click();
	}
	
	//验证checkbox是否被选中
	protected boolean ischecked(Locator locator) throws Exception {
		WebElement e = findElement(driver, locator);
		return e.isSelected();
	}

	//通过下拉列表中的选项的value属性，如果报错，通过再通过下拉列表中选项的可见文本选。
	protected void select(Locator locator, String value) throws Exception {
		WebElement e = findElement(driver, locator);
		Select select = new Select(e);

		try {
			log.info("select by Value " + value);
			select.selectByValue(value);
		} catch (Exception notByValue) {
			log.info("select by VisibleText " + value);
			select.selectByVisibleText(value);
		}
	}

	//点击alert的确定
	protected void alertConfirm() throws Exception {
		Alert alert = driver.switchTo().alert();
		try {
			alert.accept();
		} catch (Exception notFindAlert) {
			throw notFindAlert;
		}
	}

	//点击alert的取消
	protected void alertDismiss() throws Exception {
		Alert alert = driver.switchTo().alert();
		try {
			alert.dismiss();
		} catch (Exception notFindAlert) {
			throw notFindAlert;
		}
	}
	
	//使用sikuli进行点击点击
	public static void sikuliClick(String path) throws Exception {
		Screen s = new Screen();
		Pattern pp=new Pattern(path);
		s.click(pp);
	}
	
	
	//获取alert文本信息
	protected String getAlertText() throws Exception {
		Alert alert = driver.switchTo().alert();
		try {
			return alert.getText();
		} catch (Exception notFindAlert) {
			throw notFindAlert;
		}
	}

	//点击并停留，即按下鼠标不放开的操作
	protected void clickAndHold(Locator locator) throws IOException {
		WebElement e = findElement(driver, locator);
		Actions actions = new Actions(driver);
		actions.clickAndHold(e).perform();
	}

	//获取driver
	public WebDriver getDriver() {
		return driver;
	}

	//给driver赋值
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	//获取对象元素
	public WebElement getElement(Locator locator) throws IOException {
		return getElement(this.getDriver(), locator);
	}
	
	//选择iframe
	public void switchToIframe(Locator locator) throws IOException {
		WebElement e = findElement(driver, locator);
		driver.switchTo().frame(e);
	}
	
	//离开iframe返回default content
	public void defaultContent() throws IOException {
		driver.switchTo().defaultContent();
	}

	// 返回WebElement元素集合,目前仅支持通过CSS,有需求在拓展
	public List<WebElement> getWebElements(Locator locator) {
		List<WebElement> webElements = driver.findElements(By.cssSelector(locator.getElement()));
		return webElements;
	}

	
	/**
	 * get by parameter
	 * 
     * @author WD
	 * @param driver
	 * @param locator
	 * @return
	 * @throws IOException
	 */
	//获取元素具体方法实现，分为不同方式获取，具体以什么方式获取，取决于xml配置文件中的元素定义字段type。
	public WebElement getElement(WebDriver driver, Locator locator)
			throws IOException {
		WebElement e;
		System.out.println("++++++++++++++++++++++++ "+locator.getBy());
		switch (locator.getBy()) {
		case xpath:
			log.debug("find element By xpath");
			e = driver.findElement(By.xpath(locator.getElement()));
//			System.out.println("^^^^^^^^^^^^^^^"+locator.getWaitSec());//获取xml中的等待时间
			break;
		case id:
			log.debug("find element By id");
			e = driver.findElement(By.id(locator.getElement()));
			break;
		case name:
			log.debug("find element By name");
			e = driver.findElement(By.name(locator.getElement()));
			break;
		case cssSelector:
			log.debug("find element By cssSelector");
			e = driver.findElement(By.cssSelector(locator.getElement()));
			break;
		case className:
			log.debug("find element By className");
			e = driver.findElement(By.className(locator.getElement()));
			break;
		case tagName:
			log.debug("find element By tagName");
			e = driver.findElement(By.tagName(locator.getElement()));
			break;
		case linkText:
			log.debug("find element By linkText");
			e = driver.findElement(By.linkText(locator.getElement()));
			break;
		case partialLinkText:
			log.debug("find element By partialLinkText");
			e = driver.findElement(By.partialLinkText(locator.getElement()));
			break;
		default:
			e = driver.findElement(By.id(locator.getElement()));
		}
		return e;
	}

	//判断元素是否可见，true：可见；false：不可见。
	public boolean isElementPresent(WebDriver driver, Locator myLocator, int timeOut) throws IOException {
		final Locator locator = myLocator;
		boolean isPresent = false;
		WebDriverWait wait = new WebDriverWait(driver, timeOut);//默认让webdriver等待
		isPresent = wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver d) {
				return findElement(d, locator);//直到找到元素
			}
		}).isDisplayed();
		return isPresent;
	}

	
	public boolean isElementExist(Locator myLocator) throws IOException {  
		final Locator locator = myLocator;
		try{  
			 getElement(driver, locator);//直到找到元素
	         return true;
	     }catch(org.openqa.selenium.NoSuchElementException ex){ 
	    	 return false;  
	     }  
	}  
	
	/**
	 * This Method for check isPresent Locator
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 * @throws IOException
	 */
	//判断元素是否可见，true：可见；false：不可见。
	public boolean isElementPresent(Locator locator, int timeOut)
			throws IOException {
		return isElementPresent(driver, locator, timeOut);
	}

	/**
	 * 
	 * @param driver
	 * @param locator
	 * @return
	 */
	//获取元素对象
	public WebElement findElement(WebDriver driver, final Locator locator) {
		System.out.println("=========================="+locator.getWaitSec());
		System.out.println("=========================="+locator.getElement());
		System.out.println("=========================="+locator.getBy());
		WebElement element = (new WebDriverWait(driver, locator.getWaitSec()))
				.until(new ExpectedCondition<WebElement>() {

					@Override
					public WebElement apply(WebDriver driver) {
						try {
							return getElement(driver, locator);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							log.error("can't find element "
									+ locator.getElement());
							return null;
						}

					}

				});
		return element;

	}
	
	//此方法为log记录用，通过访问url来获取服务器响应，用以记录log
	public int open(String URL)
	{
		if(URL==null ||URL.equals(""))
		{
			log.error("invlid URL");
			return -1;
		}
		int responseStatus = 200;
	    CloseableHttpClient httpclient = HttpClients.createDefault();  
	    try {  
	            // 创建httpget.    
	            HttpGet httpget = new HttpGet(URL);  
	            log.info("executing request " + httpget.getURI());  
	            // 执行get请求.    
	            CloseableHttpResponse response = httpclient.execute(httpget);  
	            try {  
	                // 获取响应实体    
	                HttpEntity entity = response.getEntity();  
	                log.info("--------------------------------------");  
	                // 打印响应状态    
	                log.info(response.getStatusLine().toString());  
	                if (entity != null) {  
	                    // 打印响应内容长度    
	                    log.info("Response content length: " + entity.getContentLength());  
	                    // 打印响应内容    
	                    log.info("Response content: " + EntityUtils.toString(entity));  
	                }  
	                log.info("------------------------------------");  
	            } finally {  
	                response.close();  
	            }  
	        } catch (ClientProtocolException e) {  
	            e.printStackTrace();  
	        } catch (ParseException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        } finally {  
	            try {  
	                httpclient.close();  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            }  
	        }  
	  	return responseStatus;
	}
	/**
	 * For DOM Event 
     * @author WD
	 * @param locator
	 * @param event
	 * please refer to: http://www.w3school.com.cn/jsref/dom_obj_event.asp
	 * 
	 */
	//var event;
	//if (document.createEvent){
	//	event = document.createEvent(\"HTMLEvents\");//createEvent() 方法创建新的 Event 对象。HTML事件
	//	event.initEvent(\""+event+"\", true, false);//初始化新事件对象的属性
	//	arguments[0].dispatchEvent(event);//给节点分派一个合成事件。
	//} else {
	//	arguments[0].fireEvent(\"on"+event+"\")//出发事件
	//}
	public void DOMEvent(Locator locator,String event)
	{
		JavascriptExecutor jse=((JavascriptExecutor)driver);
		String js="var event;if (document.createEvent){event = document.createEvent(\"HTMLEvents\");event.initEvent(\""+event+"\", true, false);arguments[0].dispatchEvent(event);} else {arguments[0].fireEvent(\"on"+event+"\")}";
		jse.executeScript(js, findElement(driver,locator)) ;
	}

}
