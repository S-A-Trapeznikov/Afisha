package by.trapeznikov.runner;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import by.trapeznikov.entity.Event;
import by.trapeznikov.entity.Exhibition;
import by.trapeznikov.entity.Film;
import by.trapeznikov.entity.Genre;
import by.trapeznikov.entity.Opera;
import by.trapeznikov.entity.Singer;


public class DOMParserAfishaXMLMain {
	
	private final static Logger Log = LogManager.getLogger();
		
public static void main(String [] args) throws ParseException{
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		
		Document document;
		Element afishaRoot;
		NodeList eventsNode;
		
		try {
			builder = factory.newDocumentBuilder();
			document = builder.parse(new InputSource("files/Afisha2.xml"));
			
			afishaRoot = document.getDocumentElement();// root element
								
			String att = afishaRoot.getAttribute("city");
			System.out.println(att);
			
			eventsNode = afishaRoot.getElementsByTagName("events"); //get concrete event tag as Element from events
			
			for(int i =0; i<eventsNode.getLength(); i++) {
				
				Element events = (Element) eventsNode.item(i);
				
				NodeList allEvents = events.getChildNodes(); // get all event tags
				
				for(int j =0; j<allEvents.getLength(); j++) {
					Node eventNode = allEvents.item(j);
					
					Element eventElement;
					
					if (eventNode.getNodeType() == 1) {
						eventElement = (Element) eventNode;
						Event eventEntity = buildEvent(eventElement, eventNode.getNodeName());
								System.out.println(eventEntity);
								
				
				}
				}
			}
		
			
		}catch (SAXException | IOException | ParserConfigurationException e){
			Log.error("Some error happens");
		}

			
		}

private static Event buildEvent(Element element, String nodeName) throws ParseException {
	Event event = null;
	System.out.println("nodeName: " + nodeName);
	
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	switch (nodeName) {
	case "film" :
		Film film = new Film();
		film.setTitle(getSingleElementContent(element, "title"));
		film.setPlace(getSingleElementContent(element, "place"));
		film.setPrice(new BigDecimal(getSingleElementContent(element, "price")));
		film.setDate(df.parse(getSingleElementContent(element, "date")));
		film.setTime(getSingleElementContent(element, "time"));
		film.setGenre(Genre.getGenre(getSingleElementContent(element, "genre")));
		film.setRating(Double.parseDouble(getSingleElementContent(element, "rating")));
		event = film;
		break;
	case "opera" :
		Opera opera= new Opera();
		opera.setTitle(getSingleElementContent(element, "title"));
		opera.setPlace(getSingleElementContent(element, "place"));
		opera.setPrice(new BigDecimal(getSingleElementContent(element, "price")));
		opera.setDate(df.parse(getSingleElementContent(element, "date")));
		opera.setTime(getSingleElementContent(element, "time"));
		opera.setSinger(new Singer(getSingleElementContent(element, "singer")));
		event = opera;
		break;
	case "exhibition" :
		Exhibition exhibition = new Exhibition();
		exhibition.setTitle(getSingleElementContent(element, "title"));
		exhibition.setPlace(getSingleElementContent(element, "place"));
		exhibition.setPrice(new BigDecimal(getSingleElementContent(element, "price")));
		exhibition.setDate(df.parse(getSingleElementContent(element, "date")));
		exhibition.setTime(getSingleElementContent(element, "time"));
		exhibition.setAuthor(getSingleElementContent(element, "author"));
		exhibition.setTheme(getSingleElementContent(element, "theme"));
		event = exhibition;
		break;
	}
	return event;
}


private static String getSingleElementContent(Element element, String tagName) {
	
	NodeList list = element.getElementsByTagName(tagName);
	Element el = (Element) list.item(0);
	String content = el.getTextContent().trim();
	return content;
	
}

}