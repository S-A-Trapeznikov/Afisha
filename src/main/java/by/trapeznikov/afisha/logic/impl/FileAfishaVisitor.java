package by.trapeznikov.logic.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Set;

import by.trapeznikov.entity.Afisha;
import by.trapeznikov.entity.Event;
import by.trapeznikov.entity.Exhibition;
import by.trapeznikov.entity.Film;
import by.trapeznikov.entity.Genre;
import by.trapeznikov.entity.Opera;
import by.trapeznikov.entity.Singer;
import by.trapeznikov.logic.AfishaVisitor;

public class FileAfishaVisitor implements AfishaVisitor {

	@Override
	public void loadAfisha(Afisha afisha) {
		String fileName = "Result.txt";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write(afisha.toString());
			fw.close();
		} catch (IOException e) {

		}
	}

	public void loadAfisha(Set<Event> events) {
		String fileName = "Result1.txt";
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write(events.toString());
			fw.close();
		} catch (IOException e) {

		}
	}

	public void readAfisha(Afisha afisha) throws ParseException {
		ResourceBundle bundle = ResourceBundle.getBundle("config");
		String fileName = bundle.getString("path");
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String t;
				while ((t= br.readLine()) != null) {
					
				 String[] s = t.split(" ");
							
				switch (s[0]) {
				// Film(Date date, String time, String place, BigDecimal price,
				// String title, Genre genre, double rating)
				case "Film":
					SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
					Date dateFilm = df.parse(s[1]);
					BigDecimal priceFilm = new BigDecimal(s[4]);
					double ratingFilm = Double.parseDouble(s[7]);

					afisha.addEvent(new Film(dateFilm, s[2], s[3], priceFilm, s[5], Genre.getGenre(s[6]), ratingFilm));
					break;
				// Opera(Date date, String time, String place, BigDecimal price,
				// String title, Singer singer)
				case "Opera":
					SimpleDateFormat df1 = new SimpleDateFormat("dd.MM.yyyy");
					Date dateOpera = df1.parse(s[1]);
					BigDecimal priceOpera = new BigDecimal(s[4]);

					afisha.addEvent(new Opera(dateOpera, s[2], s[3], priceOpera, s[5], new Singer(s[6])));
					break;
				// Exhibition(Date date, String time, String place, BigDecimal
				// price, String title, String author, String theme)
				case "Exhibition":
					SimpleDateFormat df2 = new SimpleDateFormat("dd.MM.yyyy");
					Date dateExhibition = df2.parse(s[1]);
					BigDecimal priceExhibition = new BigDecimal(s[4]);

				 afisha.addEvent(new Exhibition(dateExhibition, s[2], s[3], priceExhibition, s[5], s[6], s[7]));

					break;
				}
								
			}
			fr.close();
			br.close();
		} catch (FileNotFoundException e) {

		} catch (IOException e) {
		}

	}

}
