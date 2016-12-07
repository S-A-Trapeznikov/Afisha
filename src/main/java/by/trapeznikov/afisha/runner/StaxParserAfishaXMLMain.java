package by.trapeznikov.runner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.trapeznikov.dao.xml.AfishaXMLStaxParser;
import by.trapeznikov.entity.Event;
import by.trapeznikov.entity.Exhibition;
import by.trapeznikov.entity.Film;
import by.trapeznikov.entity.Genre;
import by.trapeznikov.entity.Opera;
import by.trapeznikov.entity.Singer;

public class StaxParserAfishaXMLMain {

	public static void main(String[] args) throws XMLStreamException, IOException, ParseException {

		
		InputStream input = new FileInputStream("files/Afisha2.xml");

		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
	
		
		for (Event element : AfishaXMLStaxParser.StaxParser(reader)) {
			System.out.println(element.toString());
		}
		input.close();
	}

	
}