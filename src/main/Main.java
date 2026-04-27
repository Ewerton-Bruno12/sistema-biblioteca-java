package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Book;
import model.Loan;
import model.User;
import service.BookService;
import service.LoanService;

public class Main {
	
	public static void main(String[] args) {
		
		List<Book> books = new ArrayList<>();
		List<Loan> loans = new ArrayList<>();
		List<User> users = new ArrayList<>();
		
		BookService bookService = new BookService(books);
		LoanService loanService = new LoanService(users, loans);
		
		bookService.addBook(new Book("Clean Code", "Robert C. Martin", "978-0132350884"));
		bookService.addBook(new Book("The Pragmatic Programmer", "David Thomas", "978-0135957059"));
		bookService.addBook(new Book("Effective Java", "Joshua Bloch", "978-0134685991"));
		bookService.addBook(new Book("Design Patterns", "Gang of Four", "978-0201633610"));
		
		loanService.addUser(new User(1, "Ewerton Bruno", "ewerton@email.com"));
		loanService.addUser(new User(2, "Gabriel Felipe", "gabriel@email.com"));
		loanService.addUser(new User(3, "Pedro Ferreira", "pedro@email.com"));
		
		System.out.println("LIST OF ALL BOOKS:");
		bookService.listAllBooks();
		
		System.out.println("\nFIND BY ISBN:");
		System.out.println(bookService.findByIsbn("978-0132350884"));
		
		System.out.println("\nLIST OF ALL USERS");
		loanService.listAllUsers();
		
		loanService.addLoan(new Loan(1, bookService.findByIsbn("978-0135957059"), loanService.findUser(1), LocalDate.of(2026, 4, 26)));
		System.out.println("\nLIST OF ALL LOANS:");
		loanService.listAllLoans();
		
		loanService.returnBook(1);
		
		loanService.listAllLoans();
		
	}

}
