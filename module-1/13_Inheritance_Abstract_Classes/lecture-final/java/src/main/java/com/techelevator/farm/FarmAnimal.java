package com.techelevator.farm;

public abstract class FarmAnimal implements Singable {

	// final means the value can't be changed
	public static final String FARM_NAME = "Old MacDonald's Farm";

	private String name;
	private String sound;
	private boolean asleep;

	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
		this.asleep = false;
	}

	public String getName( ) {
		return name;
	}

	final public String getSound( ) {
		if (asleep) {
			return "Zzzzzz...";
		}
		return sound;
	}
	public boolean isAsleep() {
		return asleep;
	}
	protected void setAsleep(boolean asleep) {
		this.asleep = asleep;
	}

	public abstract void eat();

	@Override
	public String toString() {
		return name + " " + sound;
	}
}