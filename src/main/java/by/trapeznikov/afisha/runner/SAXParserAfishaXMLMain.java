package by.trapeznikov.runner;

import java.io.IOException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.trapeznikov.dao.xml.AfishaXMLHandler;
import by.trapeznikov.entity.Event;

public class SAXParserAfishaXMLMain {
	
	public static void main(String [] args) throws SAXException, IOException{
		
		XMLReader reader;
		
		reader = XMLReaderFactory.createXMLReader();
		
		InputSource source = new InputSource("files/Afisha2.xml");
		
		AfishaXMLHandler handler = new AfishaXMLHandler();
		
		reader.setContentHandler(handler);
		
		reader.parse(source);
		
		for (Event element: handler.getEvents()){
		System.out.println(element.toString());}
		
		
		
		
	}

}
