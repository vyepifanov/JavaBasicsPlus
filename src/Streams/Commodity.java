package Streams;

import java.util.Objects;

public class Commodity implements Comparable<Commodity> {
	private String title;
	private int price;

	public Commodity(String title, int price) {
		this.title = title;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return title + ';' + price;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Commodity commodity)) return false;
		return price == commodity.price && Objects.equals(title, commodity.title);
	}

	@Override
	public int hashCode() {
		return Objects.hash(title, price);
	}

	@Override
	public int compareTo(Commodity o) {
		return title.compareTo(o.getTitle());
	}
}
