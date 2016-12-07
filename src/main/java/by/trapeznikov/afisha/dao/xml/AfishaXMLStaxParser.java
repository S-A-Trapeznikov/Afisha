package by.trapeznikov.dao.xml;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.trapeznikov.entity.Event;
import by.trapeznikov.entity.Exhibition;
import by.trapeznikov.entity.Film;
import by.trapeznikov.entity.Genre;
import by.trapeznikov.entity.Opera;
import by.trapeznikov.entity.Singer;

public class AfishaXMLStaxParser {
	
	public static Set<Event> StaxParser(XMLStreamReader reader) throws XMLStreamException, ParseException {
		Film film = null;
		Opera opera = null;
		Exhibition exhibition = null;
		Set<Event> events = new HashSet<Event>();
		String element = null;
		String s = "";
		Event event=null;

		while (reader.hasNext()) {

			int type = reader.next();

			switch (type) {

			case (XMLStreamConstants.START_ELEMENT):

				element = reader.getLocalName();
				
			switch (element) {

				case "film":
					film = new Film();
					event = film;
					break;
				case "opera":
					opera = new Opera();
					event = opera;
					break;
				case "exhibition":
					exhibition = new Exhibition();
					event = exhibition;
					break;
				}
				break;

			case (XMLStreamConstants.CHARACTERS):

				s = reader.getText().trim();
				if (s != "") {
					switch (element) {

					case "title":
						event.setTitle(s);
						break;
					case "date":
						SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
						event.setDate(df.parse(s));
						break;
					case "time":
						event.setTime(s);
						break;
					case "price":
						event.setPrice(new BigDecimal(s));
						break;
					case "place":
						event.setPlace(s);
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
				break;

			case (XMLStreamConstants.END_ELEMENT):

				String end_element = reader.getLocalName();
				element = "";
			
				switch (end_element) {

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
				break;

			}
		}

		return events;

	}

}
