/*******************************************************************************
 *    系统 ： 恩普勒斯框架
 *    版权 ：(C) Copyright NPLUS 2013-2014 All Rights Reserved.
 * *****************************************************************************
 *    注意： 本内容仅限于恩普勒斯内部使用，禁止转发
 ******************************************************************************/

package com.jason.framework.util.valuelist;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Vector;


public class ValueList {

	String name;
	List<DisplayValue> valueList = new Vector<DisplayValue>();
	Map<String, DisplayValue> valueMap = new Hashtable<String, DisplayValue>();

	/**
	 */
	public String getName() {
		return name;
	}

	/**
	 */
	public void setName(String name) {
		this.name = name;
	}

	public List<DisplayValue> getList() {
		return valueList;
	}

	public void addValue(DisplayValue value) {
		valueList.add(value);
		valueMap.put(value.getKey(), value);
	}

	public DisplayValue getDisplayValue(String key) {
		return valueMap.get(key);
	}

	public String getValueKey(String key) {
		DisplayValue displayValue = valueMap.get(key);
		if (displayValue != null)
			return displayValue.getValueKey();
		else
			return null;
	}

	public String getValueText(String key) {
		DisplayValue displayValue = valueMap.get(key);
		if (displayValue != null)
			return displayValue.getValueText();
		else
			return null;
	}

}
