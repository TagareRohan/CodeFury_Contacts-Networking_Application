package com.training.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.training.models.Admin;


public class AdminParser {

	public List<Admin> adminDetails() throws ParserConfigurationException, SAXException, IOException
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    Document document = builder.parse(new File("Admins.xml"));
	    List<Admin> adminList = new ArrayList<>();
	    NodeList nodeList= document.getDocumentElement().getChildNodes();
	    for (int i = 0; i < nodeList.getLength(); i++) {
	         Node node = nodeList.item(i);

	         if (node.getNodeType() == Node.ELEMENT_NODE) {
	             Element elem = (Element) node;

	              // Get the value of the id attribute.
	              String id = elem.getAttribute("id");
	              Integer adminId=Integer.parseInt(id);
	              
	              // Get the value of all sub-elements.
	              String fullName = elem.getElementsByTagName("adminFullName")
	            		  .item(0).getChildNodes().item(0).getNodeValue();
	              
	              String email = elem.getElementsByTagName("adminEmail")
	                      .item(0).getChildNodes().item(0).getNodeValue();
	              
	              String phoneNumber = elem.getElementsByTagName("adminPhoneNumber")
	                      .item(0).getChildNodes().item(0).getNodeValue();
	              Long adminPhoneNumber=Long.parseLong(phoneNumber);
	                      
	              String userName = elem.getElementsByTagName("adminUserName")
	                                  .item(0).getChildNodes().item(0).getNodeValue();
	              
	              String password = elem.getElementsByTagName("adminPassword")
	                      .item(0).getChildNodes().item(0).getNodeValue();
	              
	              adminList.add(new Admin(adminId, fullName,email, adminPhoneNumber,userName, password));
	         }
	    }
	    
	    return adminList;
	  }
	
}
