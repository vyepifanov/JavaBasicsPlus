package Streams;

public class Collar {
	private String color;
	private int size;

	public Collar(String color, int size) {
		this.color = color;
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public int getSize() {
		return size;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return color + ';' + size;
	}
}
