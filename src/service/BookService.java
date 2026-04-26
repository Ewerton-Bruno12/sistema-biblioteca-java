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
	
	public void removeBook(Book book) {
		books.remove(book);
	}

	public String findByIsbn(String isbn) {
		for(Book book : books) {
			if(isbn.equals(book.getIsbn())) {
				return book.getTitle();
			}
		}
		return "Livro não encontrado.";
	}
	
	public String findByTitle(String title) {
		for(Book book : books) {
			if(title.equals(book.getTitle())) {
				return book.getTitle();
			}
		}
		return "Livro não encontrado.";
	}
	
	public String listAllBooks() {
		for(Book book : books) {
			return book.getTitle();
		}
	}
	
}
