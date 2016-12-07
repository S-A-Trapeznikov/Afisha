package by.trapeznikov.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Film extends Event { 
	
	private Genre genre;
	private Double rating;
		
	public Film() {
		
	}
	
		
	public Film(Date date, String time, String place, BigDecimal price, String title, Genre genre, double rating) {
		super(date,time,place,price,title);
		this.genre = genre;
		this.rating = rating;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (genre != other.genre)
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		return true;
	}


	public Genre getGenre() {
		return genre;
	}


	public void setGenre(Genre genre) {
		this.genre = genre;
	}


	public Double getRating() {
		return rating;
	}


	public void setRating(Double rating) {
		this.rating = rating;
	}


	@Override
	public String toString() {
		return "Film [genre=" + genre + ", rating=" + rating + ", Date=" + getDate() + ", Time=" + getTime()
				+ ", Place=" + getPlace() + ", Price=" + getPrice() + ", Title=" + getTitle() + "]";
	}

	
	



	
	
	
}
