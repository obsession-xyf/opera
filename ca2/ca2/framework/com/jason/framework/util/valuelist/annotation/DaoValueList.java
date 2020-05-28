/*******************************************************************************
 *    系统 ： 恩普勒斯框架
 *    版权 ：(C) Copyright NPLUS 2013-2014 All Rights Reserved.
 * *****************************************************************************
 *    注意： 本内容仅限于恩普勒斯内部使用，禁止转发
 ******************************************************************************/

package com.jason.framework.util.valuelist.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface DaoValueList {
	String name();

	String dao();

	String method();

	String key();

	String value();
}
