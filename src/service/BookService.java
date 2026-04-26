package service;

import java.util.ArrayList;
import java.util.List;

import model.Book;

public class BookService {
	
	private List<Book> books = new ArrayList<>();

	public BookService(List<Book> books) {
		this.books = books;
	}
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public void removeBook(String isbn) {
		books.remove(findByIsbn(isbn));
	}

	public Book findByIsbn(String isbn) {
		for(Book book : books) {
			if(isbn.equals(book.getIsbn())) {
				return book;
			}
		}
		return null;
	}
	
	public Book findByTitle(String title) {
		for(Book book : books) {
			if(title.equals(book.getTitle())) {
				return book;
			}
		}
		return null;
	}
	
	public void listAllBooks() {
		for(Book book : books) {
			System.out.println(book.getTitle());;
		}
	}
	
}
