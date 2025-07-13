package Func;

public class Purchase {
	private String name;
	private int price;
	private int amount;

	public Purchase() {
	}

	public Purchase(String name, int price, int amount) {
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getAmount() {
		return amount;
	}

	public int getCost() {
		return price * amount;
	}

	@Override
	public String toString() {
		return name + ';' + price + ';' + amount + ";" + getCost();
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
