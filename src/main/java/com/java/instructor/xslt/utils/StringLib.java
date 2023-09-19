package com.java.instructor.xslt.utils;

import java.io.UnsupportedEncodingException;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;

public class StringLib {

	public static Object append(Object stringBuffer, String stringToAppend) {
		return ((StringBuffer) stringBuffer).append(stringToAppend);
	}

	public static void clearBuffer(Object stringBuffer) {
		stringBuffer = new StringBuffer();
	}

	public static int compareTo(String s1, String s2) {
		return s1.compareTo(s2);
	}

	public static int compareToIgnoreCase(String s1, String s2) {
		return s1.compareToIgnoreCase(s2);
	}

	public static String concat(String s1, String s2) {
		return s1.concat(s2);
	}

	public static boolean contains(String s1, String s2) {
		return s1.contains(s2);
	}

	public static String convertBufferToString(Object stringBuffer) {
		return ((StringBuffer) stringBuffer).toString();
	}

	public static String convertByteArrayToString(byte[] bytesObject, String encoding) {
		try {
			return new String(bytesObject, encoding);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static boolean endsWith(String s1, String s2) {
		return s1.endsWith(s2);
	}

	public static boolean equals(String s1, String s2) {
		return s1.equals(s2);
	}

	public static String format(String message, Object... arguments) {
		return message.format(message, arguments);
	}

	public static Object getBytes(String s1, String charsetName) {
		try {
			return s1.getBytes(charsetName);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int hashCode(String s1) {
		return s1.hashCode();
	}

	public static int indexOfString(String s1, int fromIndex, String s2) {
		return s1.indexOf(s2, fromIndex);
	}

	public static int lastIndexOfString(String s1, int fromIndex, String s2) {
		return s1.lastIndexOf(s2, fromIndex);
	}

	public static String left(String s1, int length) {
		return s1.substring(length);
	}

	public static int length(String s1) {
		return s1.length();
	}

	public static boolean matches(String s1, String regex) {
		return s1.matches(regex);
	}

	public  static String pad(String str, int length, String padCharacter) {
		return StringUtils.rightPad(str, length, padCharacter);
	}

	public static String padFront(String str, int length, String padCharacter) {
		return StringUtils.leftPad(str, length, padCharacter);
	}

	public static boolean regionMatches(boolean ignoreCase, String s1, int offset1, String s2, int offset2,
			int length) {
		return s1.regionMatches(ignoreCase, offset1, s2, offset2, length);
	}

	public static String replaceAll(String s1, String regex, String replacement) {
		return s1.replaceAll(regex, replacement);
	}

	public static String replaceFirst(String s1, String regex, String replacement) {
		return s1.replaceFirst(regex, replacement);
	}

	public static String right(String s1, int length) {
		return StringUtils.right(s1, length);
	}

	public static String[] split(String str, String regex) {
		return StringUtils.split(str, regex);
	}

	public static String[] split2(String str, String regex, int limit) {
		return StringUtils.splitPreserveAllTokens(str, regex, limit);
	}

	public static boolean startsWith(String s1, String prefix) {
		return StringUtils.startsWith(s1, prefix);
	}

	public static String substring(String s1, int beginIndex, int endIndex) {
		return StringUtils.substring(s1, beginIndex, endIndex);
	}

	public static String substringAfter(String s1, String s2) {
		return StringUtils.substringAfter(s1, s2);
	}

	public static String substringBefore(String s1, String s2) {
		return StringUtils.substringBefore(s1, s2);
	}

	public static String toLowerCase(String s1) {
		return StringUtils.lowerCase(s1);
	}

	public static String toUpperCase(String s1) {
		return StringUtils.upperCase(s1);
	}

	public static String[] tokenize(String str, String delimiter) {
		return StringUtils.splitPreserveAllTokens(str, delimiter);
	}

	public static String trim(String str) {
		return StringUtils.trim(str);
	}

	public static String valueOfBoolean(boolean b) {
		return BooleanUtils.toStringTrueFalse(b);
	}

	public static String valueOfDouble(double d) {
		return Double.toString(d);
	}

	public static String valueOfInt(int i) {
		return Integer.toString(i);
	}

	public static String valueOfLong(long l) {
		return Long.toString(l);
	}

}
