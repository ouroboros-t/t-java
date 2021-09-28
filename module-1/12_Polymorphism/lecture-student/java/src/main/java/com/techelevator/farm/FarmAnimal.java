package com.techelevator.farm;


import java.math.BigDecimal;

public class FarmAnimal implements Singable, Sellable {
	//now all subclasses of FarmAnimal implement both Singable AND Sellable..
	private String name;
	private String sound;
	private BigDecimal price;

	public FarmAnimal(String name, String sound, String price) {
		//why do I pass through
		this.name = name;
		this.sound = sound;
		this.price = new BigDecimal(price);
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public String getSound() {
		return sound;
	}
	@Override
	public String getIndefiniteArticleForSound(){
		return "a";
	}

@Override
	public BigDecimal getPrice(){
		return price;
	}

}