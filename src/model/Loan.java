package model;

import java.time.LocalDate;

public class Loan {
	
	private int id;
	private Book book;
	private User user;
	private LocalDate startDate;
	private LocalDate returnDate;
	private boolean isReturned;
	
	public Loan(int id, Book book, User user, LocalDate startDate) {
		this.id = id;
		this.book = book;
		this.user = user;
		this.startDate = startDate;
	}
	
	public int getId() {
		return id;
	}

	public Book getBook() {
		return book;
	}
	
	public User getUser() {
		return user;
	}
	
	public LocalDate getStartDate() {
		return startDate;
	}
	
	public LocalDate getReturnDate() {
		return returnDate;
	}
	
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public boolean isReturned() {
		return isReturned;
	}

	public void setReturned(boolean isReturned) {
		this.isReturned = isReturned;
	}

	@Override
	public String toString() {
		return "Loan: id=" + id 
				+ "\n" + book 
				+ "\nuser: " + user.getName() 
				+ "\nstartDate: " + startDate 
				+ "\nreturnDate: " + returnDate 
				+ "\nisReturned: " + isReturned + "\n";
	}
	
}
