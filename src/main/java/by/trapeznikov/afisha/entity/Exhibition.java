package by.trapeznikov.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Exhibition extends Event {
	
	private String author;
	private String theme;
	
	public Exhibition() {
		
	}
	
	public Exhibition(Date date, String time, String place, BigDecimal price, String title, String author, String theme) {
		super(date,time,place,price,title);
		this.author = author;
		this.theme = theme;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Exhibition [author=" + author + ", theme=" + theme + ", Date=" + getDate() + ", Time="
				+ getTime() + ", Place=" + getPlace() + ", Price=" + getPrice() + ", Title=" + getTitle()
				+ "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((theme == null) ? 0 : theme.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exhibition other = (Exhibition) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (theme == null) {
			if (other.theme != null)
				return false;
		} else if (!theme.equals(other.theme))
			return false;
		return true;
	}
	
	public String getTheme() {
		return theme;
	}
	
	public void setTheme(String theme) {
		this.theme = theme;
	}
	
}
