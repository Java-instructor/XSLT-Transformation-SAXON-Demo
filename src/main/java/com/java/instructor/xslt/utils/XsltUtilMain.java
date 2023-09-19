package com.java.instructor.xslt.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.StringReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.io.FileUtils;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class XsltUtilMain {

	public static void main2(String[] args) {
		
		String activityName= "hello asdfsf & adaf";
		activityName=activityName.replaceAll("[^a-zA-Z0-9]","_");
		System.out.println(activityName);
		// TODO Auto-generated method stub
		try {
			String xslt=FileUtils.readFileToString(new File(new File("").getAbsolutePath()+"/src/main/resources/jhttpcrowler/utils/xml/a.xsl"));
			
			Set<String> namespacesInXpath=collectNamespacesInXpath(xslt);
 		
 			System.out.println("namespacesInXpath::"+namespacesInXpath);
 			for(String namespace: namespacesInXpath) {
				xslt=xslt.replaceAll(namespace+":", "");
			}
			Set<String> namespaces=	collectNamespaces(xslt);
			System.out.println("namespaces::"+namespaces);
			for(String namespace: namespaces) {
				xslt=xslt.replaceAll(namespace+":", "");
			}
			System.out.println(xslt);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String arg[]) {
		try {
			testXsltFromInputStream();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getCurrentDirectory() {
		String filePath = new File("").getAbsolutePath();
		int lastIndex = filePath.lastIndexOf(java.io.File.separator);
		String projectFolderPath = "";
		if (lastIndex > 0) {
			projectFolderPath = filePath.substring(0, lastIndex);
		}
		return projectFolderPath;
	}   

	 public static Document convertStringToDocument(String xmlStr) {
	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
	      //  DocumentBuilderFactory xerces = XMLFactory.getDocumentBuilderFactory(DocumentBuilderType.XERCES);    
	        DocumentBuilder builder;  
	        try  
	        {  
	            builder = factory.newDocumentBuilder();  
	            Document doc = builder.parse( new InputSource( new StringReader( xmlStr ) ) ); 
	            return doc;
	        } catch (Exception e) { 
	        	System.err.println(xmlStr);
	        
	        } 
	        return null;
	    }
    
    public static void testXsltFromInputStream() throws Exception {
        InputStream xml = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("xslt.xml");
        InputStream xsl = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("xslt.xsl");
        StreamSource xmlSourcce = new StreamSource(xml);
		StreamSource xsltSourcce = new StreamSource(xsl);

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        Map<String,Object> param=new HashMap<String, Object>();
       
        param.put("_test", convertStringToDocument("<a><b>bcontent</b><c>cContent</c><d>dContent</d></a>"));
        param.put("_test2", convertStringToDocument("<root>testing2</root>"));

        System.out.println(param);
        String result= XsltUtil.transformXMLString(xmlSourcce,xsltSourcce,param);
       // XsltUtil.transform(xml, xsl, os);
        //String result = new String(os.toByteArray());
        System.out.println("result::"+result);
           }

    
	public static Set<String> collectNamespaces(String str) {
		Set<String> namespaces = new HashSet<>();
		Stack<Integer> dels = new Stack<Integer>();
		for (int i = 0; i < str.length(); i++) {

			if (str.charAt(i) == '<') {
				dels.add(i);
			}

			else if (str.charAt(i) == ':' && !dels.isEmpty()) {
				int pos = dels.peek();
				dels.pop();
				int len = i - 1 - pos;
				String ans = str.substring(pos + 1, pos + 1 + len);
				if (!ans.startsWith("/") && !ans.equalsIgnoreCase("xsl")) {
					namespaces.add(ans);
				}
			}
		}
		return namespaces;
	}
	
	public static Set<String> collectNamespacesInXpath(String str) {
		Set<String> namespaces = new HashSet<>();
		Stack<Integer> dels = new Stack<Integer>();
		for (int i = 0; i < str.length(); i++) {

			if (str.charAt(i) == '/') {
				dels.add(i);
			}

			else if (str.charAt(i) == ':' && !dels.isEmpty()) {
				int pos = dels.peek();
				dels.pop();
				int len = i - 1 - pos;
				String ans = str.substring(pos + 1, pos + 1 + len);
				if (!ans.startsWith("/") && !ans.contains("xsl")) {
					namespaces.add(ans);
				}
			}
		}
		return namespaces;
	}
}
