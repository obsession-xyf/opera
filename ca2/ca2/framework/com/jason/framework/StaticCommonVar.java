package com.jason.framework;

import com.jason.framework.util.valuelist.annotation.ValueListContainer;

@ValueListContainer()
public class StaticCommonVar {
	
	/** 系统管理者变量 */
	public final static String SESSION_ADMIN = "SESSION_ADMIN";
	
	/** 微信页面授权openid info*/
	public final static String SESSION_ACCOUNT = "SESSION_ACCOUNT";
	
	/** 微信页面授权openid base*/
	public final static String SESSION_OPENID = "SESSION_OPENID";

}
