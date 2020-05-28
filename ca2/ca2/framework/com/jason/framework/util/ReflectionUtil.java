
package com.jason.framework.util;

import java.lang.reflect.*;

import org.apache.commons.lang.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ReflectionUtil {
	private ReflectionUtil() {
	}

	private static Logger logger = LoggerFactory
			.getLogger(ReflectionUtil.class);

	/**
	 * 通过反射,获得定义Class时声明的父类的范型参数的类型. 如public BookManager extends
	 * GenricManager<Book>
	 * 
	 * @param clazz
	 *            The class to introspect
	 * @return the first generic declaration, or <code>Object.class</code> if
	 *         cannot be determined
	 */

	@SuppressWarnings("rawtypes")
	public static Class getSuperClassGenricType(Class clazz) {
		return getSuperClassGenricType(clazz, 0);
	}

	/**
	 * 通过反射,获得定义Class时声明的父类的范型参数的类型. 如public BookManager extends
	 * GenricManager<Book>
	 * 
	 * @param clazz
	 *            clazz The class to introspect
	 * @param index
	 *            the Index of the generic ddeclaration,start from 0.
	 * @return the index generic declaration, or <code>Object.class</code> if
	 *         cannot be determined
	 */
	@SuppressWarnings("rawtypes")
	public static Class getSuperClassGenricType(Class clazz, int index) {

		Type genType = clazz.getGenericSuperclass();

		if (!(genType instanceof ParameterizedType)) {
			logger.warn(clazz.getSimpleName()
					+ "'s superclass not ParameterizedType");
			return Object.class;
		}

		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

		if (index >= params.length || index < 0) {
			logger.warn("Index: " + index + ", Size of "
					+ clazz.getSimpleName() + "'s Parameterized Type: "
					+ params.length);
			return Object.class;
		}
		if (!(params[index] instanceof Class)) {
			logger.warn(clazz.getSimpleName()
					+ " not set the actual class on superclass generic parameter");
			return Object.class;
		}
		return (Class) params[index];
	}

	public static void setFieldValue(Object target, String fname,
			Class<?> ftype, Object fvalue) {
		if (target == null
				|| StringUtils.isBlank(fname)
				|| (fvalue != null && !ftype
						.isAssignableFrom(fvalue.getClass()))) {
			return;
		}
		Class<?> clazz = target.getClass();
		try {
			Method method = clazz.getDeclaredMethod(
					"set" + Character.toUpperCase(fname.charAt(0))
							+ fname.substring(1), ftype);
			if (!Modifier.isPublic(method.getModifiers())) {
				method.setAccessible(true);
			}
			method.invoke(target, fvalue);
		} catch (Exception me) {
			if (logger.isDebugEnabled()) {
				logger.debug(me.getMessage());
			}
			try {
				Field field = clazz.getDeclaredField(fname);
				if (!Modifier.isPublic(field.getModifiers())) {
					field.setAccessible(true);
				}
				field.set(target, fvalue);
			} catch (Exception fe) {
				if (logger.isDebugEnabled()) {
					logger.debug(me.getMessage());
				}
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public static Object getFieldValue(Object target, String fieldName) {
		try {
			Field field = null;
			Class clazz = target.getClass();
			try {
				field = clazz.getField(fieldName);
			} catch (Exception e) {
				field = clazz.getDeclaredField(fieldName);
				field.setAccessible(true);
			}
			return field.get(target);
		} catch (Exception e) {
			return null;
		}
	}
}
