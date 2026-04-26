package model;

import java.time.LocalDateTime;

public class Loan {
	
	private Book book;
	private User user;
	private LocalDateTime startDate;
	private LocalDateTime returnDate;
	private boolean isReturned;
	
	public Loan(Book book, User user, LocalDateTime startDate) {
		this.book = book;
		this.user = user;
		this.startDate = startDate;
	}

	public Book getBook() {
		return book;
	}
	
	public User getUser() {
		return user;
	}
	
	public LocalDateTime getStartDate() {
		return startDate;
	}
	
	public LocalDateTime getReturnDate() {
		return returnDate;
	}
	
	public boolean isReturned() {
		return isReturned;
	}

	public void setReturned(boolean isReturned) {
		this.isReturned = isReturned;
	}
	
}
