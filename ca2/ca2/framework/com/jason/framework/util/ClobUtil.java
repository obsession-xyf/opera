
package com.jason.framework.util;

import java.io.BufferedReader;
import java.sql.Clob;

public class ClobUtil {
	/**
	 * read colb object and return the content.
	 * 
	 * @param obj
	 * @return String
	 */
	public static String clobToString(Object obj) {
		Clob clob = (Clob) obj;
		try {
			if (clob == null || clob.getCharacterStream() == null)
				return null;
			BufferedReader read = new BufferedReader(clob.getCharacterStream());
			String temp;
			StringBuffer buf = new StringBuffer(1024);
			while ((temp = read.readLine()) != null) {
				buf.append(temp).append("\n");
			}
			return buf.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}