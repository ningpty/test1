package com.wd.libarary;

import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;


public class Test {

	/**
     * @author WD
	 * @throws IOException
	 */
	public static void writeXMLDocument() throws IOException {
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(new FileWriter("output.xml"), format);
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("map");
		root.addComment("locator of page map info");
		Element page = root.addElement("page").addAttribute("pageName",
				"com.wd.libarary.page.HomePage");
		page.addComment("Locator lists");
		page.addElement("locator").addAttribute("type", "ByName")
				.addAttribute("timeOut", "3")
				.addAttribute("value", "\\\\div[@name]").addText("loginButton");
		page.addElement("locator").addAttribute("type", "ById")
				.addAttribute("timeOut", "3")
				.addAttribute("value", "\\\\div[@id]").addText("InputButton");
		writer.write(document);
		writer.close();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		writeXMLDocument();
	}
	
	
}

