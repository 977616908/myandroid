package com.ifidc.traffic.util;

import java.text.DecimalFormat;

public class DateTypeUtil {
	public static String unitHandler(long count) {
		String value = null;
		long temp = count;
		float floatnum = count;
		if ((temp = temp / 1000) < 1) {
			value = count + "B";
		} else if ((floatnum = (float)temp / 1000) < 1) {
			value = temp + "KB";
		} else {
			DecimalFormat format = new DecimalFormat("0.#");
			value = format.format(floatnum) + "MB";
		}
		return value;
	}
}
