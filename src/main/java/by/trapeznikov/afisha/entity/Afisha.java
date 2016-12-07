package by.trapeznikov.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Afisha {
	
	private Set <Event> events;
	private final String city;
	
	
	public Afisha(String city) {
		this.events = new HashSet<Event>();
		this.city = city;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return "Afisha [events=" + events + "]";
	}
	
	public boolean addEvent(Event event){
		if (event != null){
		return events.add(event);
		}
		return false;
	}
	
	public Set<Event> viewEvents(){
		return events;
	}
	
	public Set<Event> viewEvents(Date date){
		
		Set <Event> events = new HashSet<Event>();
		
		for (Event element: this.events ) {
			if (date.equals(element.getDate())){
				events.add(element);
			}
		}
		return events;
	}
	
	public Set<Event> viewEvents(Date dateBegin, Date dateEnd){
		
		Set <Event> events = new HashSet<Event>();
		
		for (Event element: this.events ) {
			if ((element.getDate().after(dateBegin) == true) && (element.getDate().before(dateEnd) == true)) {
				events.add(element);
			}
		}
		return events;
	}
}
