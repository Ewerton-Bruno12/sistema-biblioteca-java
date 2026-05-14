package main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnection;
import model.Book;
import model.Loan;
import model.User;
import service.BookService;
import service.LoanService;

public class Main {
	
	public static void main(String[] args) throws InterruptedException, SQLException {
		
		DatabaseConnection database = new DatabaseConnection();
		database.getConnection();
		
		List<Book> books = new ArrayList<>();
		List<Loan> loans = new ArrayList<>();
		List<User> users = new ArrayList<>();
		
		BookService bookService = new BookService(books);
		LoanService loanService = new LoanService(users, loans);
		Menu menu = new Menu(bookService, loanService);
		
		menu.showMenu();
		
	}

}
