package Collections.List;

public class Commodity implements Comparable<Commodity> {
	private String name;
	private int price;
	private String country;

	public Commodity(String name, int price, String country) {
		this.name = name;
		this.price = price;
		this.country = country;
	}

	@Override
	public String toString() {
		return name + ";" + price + ";" + country;
	}

	@Override
	public int compareTo(Commodity other) {
		return this.name.compareTo(other.name);
	}

	public static Commodity fromString(String input) throws IllegalArgumentException {
		String[] parts = input.split("/");
		if (parts.length != 3) {
			throw new IllegalArgumentException("Неверный формат данных");
		}
		try {
			String name = parts[0].trim();
			int price = Integer.parseInt(parts[1].trim());
			String country = parts[2].trim();
			return new Commodity(name, price, country);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Цена должна быть числом");
		}
	}

	public String getCountry() {
		return country;
	}

	public int getPrice() {
		return price;
	}
}
