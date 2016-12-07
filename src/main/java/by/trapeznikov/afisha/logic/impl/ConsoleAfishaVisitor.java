package by.trapeznikov.logic.impl;

import by.trapeznikov.entity.Afisha;
import by.trapeznikov.entity.Event;
import by.trapeznikov.logic.AfishaVisitor;

public class ConsoleAfishaVisitor implements AfishaVisitor {

	@Override
	public void  loadAfisha(Afisha afisha) {
		for(Event event : afisha.viewEvents()) {
			System.out.println(event);
		}
		
	}

}
