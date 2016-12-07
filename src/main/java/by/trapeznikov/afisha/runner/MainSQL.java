package by.trapeznikov.runner;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import by.trapeznikov.dao.xml.AfishaSQLexecute;
import by.trapeznikov.dao.xml.AfishaSQLset;
import by.trapeznikov.entity.Event;
import by.trapeznikov.entity.Exhibition;
import by.trapeznikov.entity.Film;
import by.trapeznikov.entity.Genre;
import by.trapeznikov.entity.Opera;
import by.trapeznikov.entity.Singer;


public class MainSQL {
	
	public static void main (String args[]){
		
		// загрузить драйвер
		// Connect to db
		// выполнить запрос
		// закрыть соедиение
		
		Connection con = null;
		
		try {
//			Class.forName("com.mysql.jdbc.Driver"); //object driver subd
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/afisha", "root", "12345");		
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from events");
			
			Film film = new Film(new Date(10), "17-00", "Minsk", new BigDecimal (10), "Way", Genre.HORROR, 10.0);
			
			Opera opera;
			Exhibition exhibition;
			Set<Event> events =new  HashSet<Event>();
									
			
			events = AfishaSQLexecute.parse(rs);
			
			for (Event element: events){
					System.out.println(element.toString());
			 }
			
			AfishaSQLset.insertFilm(con, film);
//			AfishaSQLset.deleteId(con,10);
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
	}

}
