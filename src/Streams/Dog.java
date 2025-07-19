package Streams;

import java.util.Optional;

public class Dog {
	private String name;
	private String breed;
	private Collar collar;

	public Dog(String name, String breed) {
		this.name = name;
		this.breed = breed;
	}

	public Dog(String name, String breed, Collar collar) {
		this.name = name;
		this.breed = breed;
		this.collar = collar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public Collar getCollar() {
		return collar;
	}

	public void setCollar(Collar collar) {
		this.collar = collar;
	}

	@Override
	public String toString() {
		return name + ';' + breed + (collar != null ? ";" + collar : "");
	}
}
