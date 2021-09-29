package com.techelevator.farm;

public abstract class FarmAnimal implements Singable {
	public static final String FARM_NAME = "Old MacDonald's Farm";
	//every class and instance can access this Farm Name, but it cannot be changed.
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
		if(asleep){
			return "zzZZZzzz";
		}
		return sound;
	}
	public boolean isAsleep(){
		return asleep;
	}
	public void setAsleep(boolean asleep){
		this.asleep = asleep;
	}

	public abstract void eat();
}