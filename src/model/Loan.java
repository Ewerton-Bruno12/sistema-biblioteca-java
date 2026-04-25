package model;

import java.time.LocalDateTime;

public class Loan {
	
	private Book book;
	private User user;
	private LocalDateTime startDate;
	private LocalDateTime returnDate;
	private boolean isReturned;
	
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
	
	

}
