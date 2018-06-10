/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.nure.gavr.util;

import java.text.SimpleDateFormat;
import java.util.Date;

;

/**
 *
 * @author legionteam
 */
public class StringUtils {

	public final static SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy-MM-dd");

	public static Date parseDate(String dataString) {

		Date date = null;
		try {
			date = sdf.parse(dataString);
		} catch (Exception e) {/* pass exeption */

		}

		return date;
	}

	public static Double parseDouble(String dataString) {

		Double value = null;
		try {
			value = Double.parseDouble(dataString);
		} catch (Exception e) {/* pass exeption */

		}
		return value;
	}

	public static String formatDate(Date date) {

		String string = null;
		try {
			string = sdf.format(date);
		} catch (Exception e) {/* pass exeption */

		}

		return string;
	}

	public static boolean hasText(String text) {
		return text != null && text.trim().length() > 0;
	}

}
