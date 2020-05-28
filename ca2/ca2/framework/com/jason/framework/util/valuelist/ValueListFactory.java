/*******************************************************************************
 *    系统 ： 恩普勒斯框架
 *    版权 ：(C) Copyright NPLUS 2013-2014 All Rights Reserved.
 * *****************************************************************************
 *    注意： 本内容仅限于恩普勒斯内部使用，禁止转发
 ******************************************************************************/

package com.jason.framework.util.valuelist;

import java.lang.reflect.Field;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;

import com.jason.framework.*;
import com.jason.framework.util.valuelist.annotation.DefaultValue;
import com.jason.framework.util.valuelist.annotation.ValueListContainer;
import com.jason.framework.util.valuelist.annotation.ValueName;

public class ValueListFactory implements MessageSourceAware {
	String constantsHolder;
	String[] constantsHolders;
	static Map<String, ValueList> container = new Hashtable<String, ValueList>();
	MessageSource messageSource;

	/**
	 * @param messageSource
	 */
	@Override
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
		for (Iterator<String> i = container.keySet().iterator(); i.hasNext();) {
			String key = i.next();
			ValueList valueList = container.get(key);
			List<DisplayValue> list = valueList.getList();
			for (int l = 0; l < list.size(); l++) {
				DisplayValue pair = list.get(l);
				pair.setMessageSource(messageSource);
			}
		}
	}

	/**
	 */
	public String getConstantsHolder() {
		return constantsHolder;
	}

	/**
	 * @param constantsHolder
	 */
	public void setConstantsHolder(String constantsHolder) {
		this.constantsHolder = constantsHolder;
		try {
			Class<?> holder = Class.forName(constantsHolder);
			loadConstants(holder);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setConstantsHolders(String[] constantsHolders) {
		try {
			for (String constant : constantsHolders) {
				setConstantsHolder(constant);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void loadConstants(Class<?> holder)
			throws IllegalArgumentException, IllegalAccessException {
		if (holder.isAnnotationPresent(ValueListContainer.class)) {
			Field[] fields = holder.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				ValueName names = fields[i].getAnnotation(ValueName.class);
				if (names == null)
					continue;
				String defaultValue = "";
				if (fields[i].getAnnotation(DefaultValue.class) != null)
					defaultValue = fields[i].getAnnotation(DefaultValue.class)
							.value();
				String[] valueNameList = names.value().split(",");
				for (int a = 0; a < valueNameList.length; a++) {
					String name = valueNameList[a];
					ValueList valueList = container.get(name);
					if (valueList == null) {
						valueList = new ValueList();
						valueList.setName(name);
						container.put(name, valueList);
					}
					String key = fields[i].get(null).toString();
					String value_key = fields[i].getName();
					DisplayValue value = new DisplayValue();
					value.setKey(key);
					value.setValueKey(value_key);
					value.setDefaultValue(defaultValue);
					value.setMessageSource(messageSource);
					valueList.addValue(value);
				}
			}
		}
		if (holder.getSuperclass() != null) {
			loadConstants(holder.getSuperclass());
		}
	}

	public static ValueList getValueList(String name) {
		ValueList list = container.get(name);
		if (list == null) {
			list = new ValueList();
			list.setName(name);
		}
		return list;
	}

	public static String getValueText(String name, String key) {
		ValueList list = container.get(name);
		if (list == null) {
			list = new ValueList();
			list.setName(name);
		}
		return list.getValueText(key);
	}

	public static String getValueKey(String name, String key) {
		ValueList list = container.get(name);
		if (list == null) {
			list = new ValueList();
			list.setName(name);
		}
		return list.getValueKey(key);
	}

	public static void main(String[] args) {
		try {
			ValueListFactory vlf = new ValueListFactory();
			vlf.loadConstants(StaticCommonVar.class);
			for (Iterator<String> i = container.keySet().iterator(); i
					.hasNext();) {
				String key = i.next();
				ValueList value = container.get(key);
				System.out.println(key + ":" + value);

				List<DisplayValue> dv = value.getList();
				for (int dvi = 0; dvi < dv.size(); dvi++) {
					DisplayValue d = dv.get(dvi);
					System.out
							.println(d.getValueKey() + ":" + d.getValueText());
				}
				System.out.println("=========================");
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @return the container
	 */
	public static Map<String, ValueList> getContainer() {
		return container;
	}

	/**
	 * @param container
	 *            the container to set
	 */
	public static void setContainer(Map<String, ValueList> container) {
		ValueListFactory.container = container;
	}

	/**
	 * @return the constantsHolders
	 */
	public String[] getConstantsHolders() {
		return constantsHolders;
	}

	/**
	 * @return the messageSource
	 */
	public MessageSource getMessageSource() {
		return messageSource;
	}
}
