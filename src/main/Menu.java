package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.Book;
import model.Loan;
import model.User;
import service.BookService;
import service.LoanService;

public class Menu {
	
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private BookService bookService;
	private LoanService loanService;
	private int loanId = 0;
	private Scanner sc = new Scanner(System.in);
	
	public Menu(BookService bookService, LoanService loanService) {
		this.bookService = bookService;
		this.loanService = loanService;
	}
	
	
	public void showMenu() throws InterruptedException {
		int choice;
		do {
			System.out.println("=== LIBRARY ===");
			System.out.println("1 - List all books");
			System.out.println("2 - Search book by ISBN");
			System.out.println("3 - Add book");
			System.out.println("4 - Remove book");
			System.out.println("5 - Make loan");
			System.out.println("6 - Return book");
			System.out.println("7 - List all loans");
			System.out.println("8 - List all users");
			System.out.println("0 - Exit");
			System.out.print("Enter your option: ");
			choice = sc.nextInt();
			sc.nextLine();
			
			switch (choice) {
			case 1:
				System.out.println("LIST OF ALL BOOKS:");
				bookService.listAllBooks();
				break;
			case 2:
				System.out.print("Enter ISBN: ");
				String isbn = sc.next();
				System.out.println(bookService.findByIsbn(isbn));
				break;
			case 3:
				System.out.print("Enter book title: ");
				String title = sc.nextLine();
				System.out.print("Enter book author: ");
				String author = sc.nextLine();
				System.out.print("Enter book ISBN: ");
				String addIsbn = sc.next();
				bookService.addBook(new Book(title, author, addIsbn));
				break;
			case 4:
				System.out.print("Enter book ISBN to remove: ");
				String removeBook = sc.next();
				bookService.removeBook(removeBook);
				break;
			case 5:
				System.out.print("Enter book title: ");
				String loanTitle = sc.nextLine();
				System.out.print("Enter book author: ");
				String loanAuthor = sc.nextLine();
				System.out.print("Enter book ISBN: ");
				String loanIsbn = sc.next();
				
				System.out.print("Enter your ID: ");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter your name: ");
				String name = sc.nextLine();
				System.out.print("Enter your email: ");
				String email = sc.next();
				
				System.out.print("Enter loan start date (dd/MM/yyyy): ");
				String date = sc.next();
				LocalDate startDate = LocalDate.parse(date, fmt);
				loanService.addLoan(new Loan(loanId, 
						new Book(loanTitle, loanAuthor, loanIsbn), 
						new User(id, name, email), startDate));
				loanId++;
				break;
			case 6:
				System.out.print("Enter loan ID: ");
				int idReturnBook = sc.nextInt();
				loanService.returnBook(idReturnBook);
				break;
			case 7:
				System.out.println("LIST OF ALL LOANS:");
				loanService.listAllLoans();
				break;
			case 8:
				System.out.println("LIST OF ALL USERS:");
				loanService.listAllUsers();
				break;
			case 0:
				System.out.println("EXITING...");
				break;	
			default:
				System.out.println("\nENTER A VALID OPTION.");
				Thread.sleep(2000);
				break;
			}
			
			if (choice != 0) {
			    System.out.println("\nPress Enter to continue...");
			    sc.nextLine();
			}
		} while(choice != 0);
	}

}
