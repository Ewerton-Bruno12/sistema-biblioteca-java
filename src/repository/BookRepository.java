package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Book;

public class BookRepository {
	
	Connection connection;

	public BookRepository(Connection connection) {
		this.connection = connection;
	}
	
	public List<Book> findAll() throws SQLException {
	    List<Book> books = new ArrayList<>();
	    String sql = "SELECT * FROM books";
	    PreparedStatement stmt = connection.prepareStatement(sql);
	    ResultSet rs = stmt.executeQuery();
	    while (rs.next()) {
	        Book book = new Book(
	            rs.getString("title"),
	            rs.getString("author"),
	            rs.getString("isbn")
	        );
	        books.add(book);
	    }
	    return books;
	}
}
