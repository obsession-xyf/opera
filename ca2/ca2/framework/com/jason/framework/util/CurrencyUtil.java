
package com.jason.framework.util;

import java.text.DecimalFormat;
import java.text.ParseException;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class CurrencyUtil implements Converter {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	private DecimalFormat formatter = new DecimalFormat("###,###.00");

	public void setDecimalFormatter(DecimalFormat df) {
		this.formatter = df;
	}

	/**
	 * Convert a String to a Double and a Double to a String
	 * 
	 * @param type
	 *            the class type to output
	 * @param value
	 *            the object to convert
	 * @return object the converted object (Double or String)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public final Object convert(final Class type, final Object value) {
		// for a null value, return null
		if (value == null) {
			return null;
		} else {
			if (value instanceof String) {
				if (logger.isDebugEnabled()) {
					logger.debug("value (" + value + ") instance of String");
				}

				try {
					if (StringUtils.isBlank(String.valueOf(value))) {
						return null;
					}

					if (logger.isDebugEnabled()) {
						logger.debug("converting '" + value + "' to a decimal");
					}

					// formatter.setDecimalSeparatorAlwaysShown(true);
					Number num = formatter.parse(String.valueOf(value));

					return num.doubleValue();
				} catch (ParseException pe) {
					pe.printStackTrace();
				}
			} else if (value instanceof Double) {
				if (logger.isDebugEnabled()) {
					logger.debug("value (" + value + ") instance of Double");
					logger.debug("returning double: " + formatter.format(value));
				}

				return formatter.format(value);
			}
		}

		throw new ConversionException("Could not convert " + value + " to "
				+ type.getName() + "!");
	}
}
