package com.java.instructor.xslt.utils;

import org.joda.time.DateTime;

public class DateLib {

	// tibco Date functions.
	public static boolean after (DateTime d1, DateTime d2) {
		return d1.isAfter(d2);
	}
	
	public static boolean before (DateTime d1, DateTime d2) {
		return d1.isBefore(d2);
	}
	public static boolean equals (Object d1, Object d2) {
		return d1.equals(d2);
	}
	public static DateTime today () {
		return new DateTime();
	}

}
