package com.techelevator.farm;

import javax.swing.plaf.synth.SynthMenuBarUI;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OldMacdonald {
	public static void main(String[] args) {

		Singable[] farmAnimals = new Singable[] { new Cow(), new Chicken(), new Pig(), new Tractor() };
		//because FarmAnimal is-a Singable, all FarmAnimal subclasses are also Singable

		for (Singable animal : farmAnimals) {
			//iterating through the interface now that we have an array of Singable interface
			String name = animal.getName();
			String sound = animal.getSound();
			String indefiniteArticle = animal.getIndefiniteArticleForSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With " + indefiniteArticle+ " " + sound + " " + sound + " here");
			System.out.println("And "+ indefiniteArticle+ " " + sound + " " + sound + " there");
			System.out.println("Here "+ indefiniteArticle + " " + sound + " there " +indefiniteArticle+ " " + sound
					+ " everywhere "+ indefiniteArticle+ " " + sound + " " + sound);
			System.out.println();
		}

		List<Sellable> items = new ArrayList<Sellable>();
		//can now add which items
		items.add(new Egg());
		items.add(new Cow());
		items.add(new Chicken());
		items.add(new Pig());
		items.add(new Tractor("6500"));

		BigDecimal total = BigDecimal.ZERO;
		for(Sellable item : items) {
			//we only have access to both Object methods and the only method we put in Sellable interface
			total = total.add(item.getPrice());
			System.out.println("$"+ item.getPrice());
		}
		System.out.println("Total: $" + total);

	}
}