package com.techelevator.farm;

import java.math.BigDecimal;

public class Cow extends FarmAnimal {
				private String color;
	public Cow(String color) {
		super("Cow", "moo!", new BigDecimal("3000.00"));
		this.color = color;

	}
	public Cow() {
		//super("Cow", "moo!", new BigDecimal("3000.00"));
		this("white");
		//forwards to the first constructor...
	}

}