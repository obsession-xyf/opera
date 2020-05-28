
package com.jason.framework.util;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class XmlUtil {
	public static Map<String, Object> xmlToMap(String xmlStr) throws JDOMException, IOException {
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(new StringReader(xmlStr));
		
		// 调用递归函数，得到所有最底层元素的名称和值，加入map中
		return convertObject(doc.getRootElement());
	}
	
	/**
	 * 解析一级String类型
	 * @param xmlStr
	 * @return
	 * @throws JDOMException
	 * @throws IOException
	 */
	public static Map<String, String> xmlToMapString(String xmlStr) throws JDOMException, IOException {
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(new StringReader(xmlStr));
		
		// 调用递归函数，得到所有最底层元素的名称和值，加入map中
		return convertToString(doc.getRootElement());
	}
	
	/**
	 * 通过根接点解析子接点
	 * @param e 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> convertObject(Element e) {
		Map<String, Object> map = new HashMap<String, Object>();
		String lastname = e.getName();
		
//		map.put("root.name", lastname);
		if(e.getChildren().size()>0) {
			for(Object o:e.getChildren()) {
				Element child = (Element) o;
				String name = lastname + "." + child.getName();
				Boolean isRows = false;
				
				if (child.getAttributes().size() > 0) {
					for(Object o1:child.getAttributes()) {
						Attribute attribute = (Attribute) o1;
						String attrname = attribute.getName();
						String attrvalue = child.getAttributeValue(attrname);
						map.put(name + ":" + attrname, attrvalue);
						
						if(attrname.equalsIgnoreCase("listnode") && attrvalue.equalsIgnoreCase("true")) {
							isRows = true;
						}
					}
				}
				
				if(isRows) {
					//解析列表接点
					map.put(name, convertList(child.getChildren()));
				} else {
					if(child.getChildren().size()==0) {
						map.put(name, child.getText());
					} else if(child.getChildren().size() > 0) {
						//解析子接点
						map.put(name, convertObject(child));
					}
				}
			}
		} else {
			map.put(lastname, e.getText());
		}
		
		return map;
	}
	
	/**
	 * 通过列表接点找出所有字接点
	 * @param listChildren 列表接点集合
	 * @return 返回解释后的接点集合
	 */
	public static List<Map<String, Object>> convertList(List<Object> listChildren) {
		List<Map<String, Object>> listMap = new ArrayList<Map<String,Object>>();
		
		for(Object o: listChildren) {
			Element child = (Element) o;
			//解析子接点
			listMap.add(convertObject(child));
		}
		
		return listMap;
	}
	
	
	/**
	 * 通过根接点解析子接点String类型
	 * @param e 
	 * @return
	 */
	public static Map<String, String> convertToString(Element e) {
		Map<String, String> map = new HashMap<String, String>();
		String lastname = e.getName();
		
		if(e.getChildren().size()>0) {
			for(Object o:e.getChildren()) {
				Element child = (Element) o;
				String name = lastname + "." + child.getName();
				
				if (child.getAttributes().size() > 0) {
					for(Object o1:child.getAttributes()) {
						Attribute attribute = (Attribute) o1;
						String attrname = attribute.getName();
						String attrvalue = child.getAttributeValue(attrname);
						map.put(name + ":" + attrname, attrvalue);
					}
				}
				
				if(child.getChildren().size()==0) {
					map.put(name, child.getText());
				} else if(child.getChildren().size() > 0) {
					//解析子接点
					convertToString(child);
				}
			}
		} else {
			map.put(lastname, e.getText());
		}
		
		return map;
	}
}
