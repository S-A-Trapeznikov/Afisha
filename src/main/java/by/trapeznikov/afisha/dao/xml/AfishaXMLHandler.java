package by.trapeznikov.dao.xml;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.trapeznikov.entity.Event;
import by.trapeznikov.entity.Exhibition;
import by.trapeznikov.entity.Film;
import by.trapeznikov.entity.Genre;
import by.trapeznikov.entity.Opera;
import by.trapeznikov.entity.Singer;

public class AfishaXMLHandler extends DefaultHandler {

	private String value;
	private Set<Event> events = new HashSet<Event>();
	private Event someEvent = null;
	
	private Film film = new Film();
	private Opera opera = new Opera();
	private Exhibition exhibition = new Exhibition();

	public Set<Event> getEvents() {
		return events;
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("end document");

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		value = "";
		
//		if (qName.equals("events") && qName != null) {
			switch (qName) {

			case "film":
				events.add(film);
				break;

			case "opera":
				events.add(opera);
				break;

			case "exhibition":
				events.add(exhibition);
				break;

			}
		}



	@Override
	public void startDocument() throws SAXException {
		System.out.println("Start Document");
		
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		value = qName;
				
//		if (qName.equals("events") && qName != null) {
//
//			String type = attributes.getValue(0);

			if (qName != null) {
				switch (qName) {

				case "film":
					someEvent = film;
					break;
				case "opera":
					someEvent = opera;
					break;
				case "exhibition":
					someEvent = exhibition;
					break;
				}
			}
		}
	

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		String s = new String(ch, start, length);

		switch (value) {

			case "title":
				someEvent.setTitle(s);
				break;
			case "date":
				SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				try {
					Date date = df.parse(s);
					someEvent.setDate(date);

				} catch (ParseException e) {

				}

			case "time":
				someEvent.setTime(s);
				break;
			case "price":
				BigDecimal price = new BigDecimal(s);
				someEvent.setPrice(price);
				break;
			case "place":
				someEvent.setPlace(s);
				break;
			case "genre":
				film.setGenre(Genre.getGenre(s));
				break;
			case "rating":
				double rating = Double.parseDouble(s);
				film.setRating(rating);
				break;
			case "singer":
				opera.setSinger(new Singer(s));
				break;
			case "author":
				exhibition.setAuthor(s);
				break;

			case "theme":
				exhibition.setTheme(s);

				break;
			}
		
		}

	}

