package Collections.Set;

import java.util.Objects;

public class Product implements Comparable<Product> {
	private String name;
	private int price;
	private String country;

	public Product(String name, int price, String country) {
		this.name = name;
		this.price = price;
		this.country = country;
	}

	public static Product fromString(String input) {
		String[] data = input.split("#");
		if (data.length != 3) {
			return null;
		}

		String name = data[0];
		String country = data[1];
		int price = Integer.parseInt(data[2]);

		return new Product(name, price, country);
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Product product)) return false;
		return price == product.price && Objects.equals(name, product.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, price);
	}

	@Override
	public int compareTo(Product o) {
		if (!name.equals(o.getName())) {
			return name.compareTo(o.getName());
		} else {
			if (price > o.getPrice()) return 1;
			if (price < o.getPrice()) return -1;
			return 0;
		}
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return name + ';' + price;
	}
}
