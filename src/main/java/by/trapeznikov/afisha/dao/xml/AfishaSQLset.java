package by.trapeznikov.dao.xml;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.trapeznikov.entity.Event;
import by.trapeznikov.entity.Exhibition;
import by.trapeznikov.entity.Film;
import by.trapeznikov.entity.Genre;
import by.trapeznikov.entity.Opera;

public class AfishaSQLset {
	
	private final static String SQL_INSERT_FILM = "INSERT INTO events (id, type, title, date, place, time, price, genre,rating) VALUES(?,?,?,?,?,?,?,?,?)";
	private final static String SQL_INSERT_OPERA = "INSERT INTO events (id, type, title, date, place, time, price, singer) VALUES(?,?,?,?,?,?,?,?)";
	private final static String SQL_INSERT_EXHIBITION = "INSERT INTO events (id, type, title, date, place, time, price, author, theme) VALUES(?,?,?,?,?,?,?,?,?)";
	private final static String SQL_DELETE_WHERE_ID = "DELETE FROM events WHERE id= ?";
	
	public static void insertFilm(Connection con, Film event) throws SQLException{
		
		PreparedStatement ps = con.prepareStatement(SQL_INSERT_FILM);
//		ps.setString(1,"events");
		ps.setInt(1, 10);
		ps.setString(2,"film");
		ps.setString(3, event.getTitle());
		ps.setDate(4,new Date(2));
//		ps.setDate(4,event.getDate());
		ps.setString(5, event.getPlace());
		ps.setString(6, event.getTime());
		ps.setBigDecimal(7, event.getPrice());
		ps.setString(8, Genre.getGenreString(event.getGenre()));
		ps.setDouble(9, event.getRating());
		ps.executeUpdate();
	}
	
	public static void insertOpera(Connection con, Opera event) throws SQLException{
		
		PreparedStatement ps = con.prepareStatement(SQL_INSERT_OPERA);
		ps.setInt(1, 10);
		ps.setString(2,"opera");
		ps.setString(3, event.getTitle());
		ps.setDate(4,new Date(2));
//		ps.setDate(4,event.getDate());
		ps.setString(5, event.getPlace());
		ps.setString(6, event.getTime());
		ps.setBigDecimal(7, event.getPrice());
		ps.setString(8,event.getSinger().toString());
		ps.executeUpdate();
				
	}
	public static void insertExhibition(Connection con, Exhibition event) throws SQLException{
	
		PreparedStatement ps = con.prepareStatement(SQL_INSERT_EXHIBITION);
		ps.setInt(1, 10);
		ps.setString(2,"exhibition");
		ps.setString(3, event.getTitle());
		ps.setDate(4,new Date(2));
//		ps.setDate(4,event.getDate());
		ps.setString(5, event.getPlace());
		ps.setString(6, event.getTime());
		ps.setBigDecimal(7, event.getPrice());
		ps.setString(8, event.getAuthor());
		ps.setString(9, event.getTheme());
		ps.executeUpdate();
	
	}
	public static void deleteId(Connection con, int id) throws SQLException{
		
		PreparedStatement ps = con.prepareStatement(SQL_DELETE_WHERE_ID);
		ps.setInt(1, id);
		ps.executeUpdate();
		
		
	
	}
	

}
