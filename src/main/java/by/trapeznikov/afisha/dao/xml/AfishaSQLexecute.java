package by.trapeznikov.dao.xml;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import by.trapeznikov.entity.Event;
import by.trapeznikov.entity.Exhibition;
import by.trapeznikov.entity.Film;
import by.trapeznikov.entity.Genre;
import by.trapeznikov.entity.Opera;
import by.trapeznikov.entity.Singer;

public class AfishaSQLexecute {

	public static Set<Event> parse(ResultSet rs) throws SQLException{
		
		Set<Event> events =new  HashSet<Event>();
		
		Film film;
		Opera opera;
		Exhibition exhibition;
								
		while (rs.next()){
			String type = rs.getString("type");
			switch (type){
			case "film": film = new Film();
						 film.setTitle(rs.getString("title"));
						 film.setDate(rs.getDate("date"));
						 film.setTime(rs.getString("time"));
						 film.setPrice(rs.getBigDecimal("price"));
						 film.setPlace(rs.getString("place"));
						 film.setGenre(Genre.getGenre(rs.getString("genre")));
						 film.setRating(rs.getDouble("rating"));
						 events.add(film);
						 
						 break;
			case "opera": opera = new Opera();
						  opera.setTitle(rs.getString("title"));
						  opera.setDate(rs.getDate("date"));
						  opera.setTime(rs.getString("time"));
						  opera.setPrice(rs.getBigDecimal("price"));
						  opera.setPlace(rs.getString("place"));
						  opera.setSinger(new Singer(rs.getString("singer")));
						  events.add(opera);
						  
						  break;
			case "exhibition": exhibition = new Exhibition();
			 	 	 	 	   exhibition.setTitle(rs.getString("title"));
			 	 	 	 	   exhibition.setDate(rs.getDate("date"));
			 	 	 	 	   exhibition.setTime(rs.getString("time"));
			 	 	 	 	   exhibition.setPrice(rs.getBigDecimal("price"));
			 	 	 	 	   exhibition.setPlace(rs.getString("place"));
			 	 	 	 	   exhibition.setAuthor(rs.getString("author"));
			 	 	 	 	   exhibition.setTheme(rs.getString("theme"));
			 	 	 	 	   events.add(exhibition);
			 	 	 	 	
							   break;
			}
			
		}
				
		return events;
	}
			
}