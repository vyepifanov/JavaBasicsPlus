package Streams;

import java.util.ArrayList;

public class Reader {
	private String name;
	private ArrayList<Book> books;

	public Reader(String name, ArrayList<Book> books) {
		this.name = name;
		this.books = books;
	}

	public void addBook(Book book) {
		this.books.add(book);
	}

	public ArrayList<Book> getBooks() {
		return books;
	}
}
