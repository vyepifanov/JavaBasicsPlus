package Streams;

public class Book {
	private int number;
	private String author;
	private String title;

	public Book(int number, String author, String title) {
		this.number = number;
		this.author = author;
		this.title = title;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return Integer.toString(number) + '#' + author + '#' + title;
	}
}
