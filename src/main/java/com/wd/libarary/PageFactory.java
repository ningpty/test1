package com.wd.libarary;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;

/**
 * 
 * @author WD
 * 页面跳转，使用反射
 */
public class PageFactory {
	static Log log = new Log(PageFactory.class);
	//Class<?> 通配泛型，?可以代表任何类型
	public synchronized static Object getPage(Class<?> key, WebDriver d)
			throws ClassNotFoundException, NoSuchMethodException,
			SecurityException, IllegalArgumentException,
			InvocationTargetException {
		String pageClassName = key.getCanonicalName();//getCanonicalName返回的声明类似的形式
		log.info("page name is " + pageClassName);
		Class<?> clazz = Class.forName(pageClassName);
		Object obj = null;
		try {
			Constructor<?> constructor = clazz.getConstructor(WebDriver.class);//getConstructor,此方法返回指定的parameterTypes参数匹配的公共构造函数的构造函数对象.
			obj = constructor.newInstance(d);//先调用Class类的getConstructor()方法获得一个Constructor对象，它代表默认的构造方法，然后调用Constructor对象的newInstance()方法构造一个实例。

		} catch (InstantiationException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return obj;
	}

}
