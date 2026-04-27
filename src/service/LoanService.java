package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Loan;
import model.User;

public class LoanService {

	private List<User> users = new ArrayList<>();
	private List<Loan> loans = new ArrayList<>();

	public LoanService(List<User> users, List<Loan> loans) {
		this.users = users;
		this.loans = loans;
	}

	public void addUser(User user) {
		users.add(user);
	}

	public void removeUser(int id) {
		users.remove(findUser(id));
	}

	public User findUser(int id) {
		for (User user : users) {
			if (id == user.getId()) {
				return user;
			}
		}
		return null;
	}

	public void listAllUsers() {
		for (User user : users) {
			System.out.println(user.getName());
		}
	}

	public void addLoan(Loan loan) {
		loans.add(loan);
	}

	public void returnBook(int id) {
		for (Loan loan : loans) {
			if (id == loan.getId()) {
				loan.setReturned(true);
				loan.setReturnDate(LocalDate.now());
			}
		}
	}

	public void listAllLoans() {
		for (Loan loan : loans) {
			System.out.println(loan);
		}
	}

}
