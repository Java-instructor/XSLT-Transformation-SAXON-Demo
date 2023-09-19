package com.java.instructor.xslt.utils;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class LibUtil{
	
	
	// Tibco String function
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
	
	public static String[] tokenize_allow_empty(String str, String delimiter) {
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


	
	public static String substring_after_last(String str,  String separator) {
		return StringUtils.substringAfterLast(str, separator);
	}
	public static String substring_before_last(String str,  String separator) {
		return StringUtils.substringBeforeLast(str, separator);
	}
	
	
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
	public static long timestamp() {
		return new Date().getTime();
	}

	public static String get_timezone_from_dateTime(String date) {
		 if (date.length() != 5) {
	            return null;
	        }

	        TimeZone tz = null;

	        Integer offsetHours = Integer.parseInt(date.substring(0, 3));
	        Integer offsetMinutes = Integer.parseInt(date.substring(3));

	        String[] ids = TimeZone.getAvailableIDs();

	        for (int i = 0; i < ids.length; i++) {
	            tz = TimeZone.getTimeZone(ids[i]);

	            long hours = TimeUnit.MILLISECONDS.toHours(tz.getRawOffset());
	            long minutes = Math.abs(TimeUnit.MILLISECONDS.toMinutes(tz.getRawOffset()) % 60);

	            if (hours != offsetHours || minutes != offsetMinutes) {
	                tz = null;
	            } else {
	                break;
	            }
	        }
	        return tz.getID();
	}
	
	
	public static String format_dateTime(String format, long dateLong ) {
	
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		String date = simpleDateFormat.format(new Date(dateLong));	
		return date.toString();
	}
	public static String render_xml(String str){
		  Document doc = convertStringToDocument(str);	        
	        String renderedXML = convertDocumentToString(doc);
	        
	        return renderedXML;
	}

	
	public static String string_round_fraction(String value, int fractions) {		
		    double scale = Math.pow(10, fractions);
		    Float result= (float) (Math.round(Double.parseDouble(value) * scale) / scale);
		    return result.toString();
		}

	


	private static String convertDocumentToString(Document doc) {
		TransformerFactory tf = TransformerFactory.newInstance();
		StringWriter writer = new StringWriter();
		try {
			Transformer transformer = tf.newTransformer();
			// transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			transformer.transform(new DOMSource(doc), new StreamResult(writer));
			String output = writer.getBuffer().toString();
			return output;
		} catch (TransformerException e) {
			e.printStackTrace();
		}

		return null;
	}

	private static Document convertStringToDocument(String xmlStr) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new InputSource(new StringReader(xmlStr)));
			return doc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
	
	/*public static void main(String[] args) {
	       // final String xmlStr = "<Emp id=\"1\"><name>Pankaj</name><age>25</age><role>Developer</role><gen>Male</gen></Emp>";
	       // System.out.println(render_xml(xmlStr));
	        
	     //  System.out.println(pad ("sasi", 7, "0"));
	       
	       String startDate = "2016-04-21T00:00:00+0530";
	       if(startDate.contains("+")) {
	    	   startDate = startDate.substring(startDate.length() - 5);
	       }
	       System.out.println(get_timezone_from_dateTime(startDate) );

	    }*/

