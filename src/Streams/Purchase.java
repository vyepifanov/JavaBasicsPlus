package Streams;

import java.util.HashMap;
import java.util.Set;

public class Purchase {
	private String card;
	private HashMap<Commodity, Double> items;

	public Purchase(String card) {
		this.card = card;
		this.items = new HashMap<>();
	}

	public void addItem(Commodity item, Double number) {
		items.put(item, number);
	}

	public String getCard() {
		return card;
	}

	public Set<Commodity> getItems() {
		return items.keySet();
	}
}
