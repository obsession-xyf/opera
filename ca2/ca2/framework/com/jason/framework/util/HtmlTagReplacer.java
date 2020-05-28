
package com.jason.framework.util;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlTagReplacer implements Serializable {

	private static final long serialVersionUID = 5155177467068480248L;

	private static Pattern WIDTH_PATTERN = Pattern.compile(
			"width=([\"|\']?)\\w+[%]?\\1", Pattern.CASE_INSENSITIVE);

	private static Pattern HEIGHT_PATTERN = Pattern.compile(
			"height=([\"|\']?)\\w+[%]?\\1", Pattern.CASE_INSENSITIVE);

	private static Pattern ID_PATTERN = Pattern.compile(
			"id=([\"|\']?).+?\\1\\s", Pattern.CASE_INSENSITIVE);

	private static Pattern CLASS_PATTERN = Pattern.compile(
			"class=([\"|\']?).+?\\1\\s", Pattern.CASE_INSENSITIVE);

	// private static Pattern STYLE_PATTERN =
	// Pattern.compile("style=([\"|\']?)(\\s*.+:\\s*.+?[;]?)+?\\s*\\1",Pattern.CASE_INSENSITIVE);

	private static Pattern ON_PATTERN = Pattern.compile(
			"on\\w+=([\"|\']?).+?\\1\\s", Pattern.CASE_INSENSITIVE);

	private static Pattern IMG_PATTERN = Pattern.compile("<img\\s.*[////]?>",
			Pattern.CASE_INSENSITIVE);

	private static Pattern READONLY_PATTERN = Pattern.compile("<input",
			Pattern.CASE_INSENSITIVE);

	private static Pattern DISABLED_PATTERN = Pattern.compile("<select",
			Pattern.CASE_INSENSITIVE);

	private static Pattern TEXTAREA_PATTERN = Pattern.compile("<textarea",
			Pattern.CASE_INSENSITIVE);

	private static Pattern BORDER_PATTERN = Pattern
			.compile("border=([\"|\']?).+?\\1\\s?");

	// private static Pattern COLS_PATTERN =
	// Pattern.compile("cols=([\"|\']?).+?\\1");

	public static String replace(String html_str) {

		Matcher m = IMG_PATTERN.matcher(html_str);

		html_str = m.replaceAll("");

		m = WIDTH_PATTERN.matcher(html_str);

		html_str = m.replaceAll("");

		m = HEIGHT_PATTERN.matcher(html_str);

		html_str = m.replaceAll("");

		m = ID_PATTERN.matcher(html_str);

		html_str = m.replaceAll("");

		m = CLASS_PATTERN.matcher(html_str);

		html_str = m.replaceAll("");

		// m = STYLE_PATTERN.matcher(html_str);
		//
		// html_str = m.replaceAll("");

		m = ON_PATTERN.matcher(html_str);

		html_str = m.replaceAll("");

		m = BORDER_PATTERN.matcher(html_str);

		html_str = m.replaceAll("");

		// m = COLS_PATTERN.matcher(html_str);
		//
		// html_str = m.replaceAll("cols=15");
		//
		m = READONLY_PATTERN.matcher(html_str);

		html_str = m.replaceAll("<input readonly='readonly'");

		m = DISABLED_PATTERN.matcher(html_str);

		html_str = m.replaceAll("<select disabled='disabled'");

		m = TEXTAREA_PATTERN.matcher(html_str);

		html_str = m.replaceAll("<textarea readonly='readonly'");

		return html_str;
	}
}
