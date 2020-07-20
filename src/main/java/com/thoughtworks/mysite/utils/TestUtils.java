package com.thoughtworks.mysite.utils;

import java.io.InputStream;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TestUtils {
	
	public static final long  wait =10;
	
	
	public HashMap<String,String> parseStringXML(InputStream file) throws Exception{
		
		HashMap<String,String> stringMap = new HashMap<String,String>();
		//Get Document Builder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		DocumentBuilder builder =factory.newDocumentBuilder();
		//Build Document
		Document document = builder.parse(file);
		//Normalise the XMl structures;
		document.getDocumentElement().normalize();
		// root node
		Element root = document.getDocumentElement();
		//Get All Elements
		NodeList nodeList = document.getElementsByTagName("string");		
		
		for (int temp =0;temp<nodeList.getLength();temp++) {
			
			Node node = nodeList.item(temp);
			if (node.getNodeType()==Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				//store each element key value in map
				stringMap.put(eElement.getAttribute("name"), eElement.getTextContent());
			}
			}
		return stringMap;
		}
	}
