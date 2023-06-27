package kr.ac.kopo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookService {
	
	private Connection conn;

	private PreparedStatement query(String query)throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "madang", "madang");	
		return conn.prepareStatement(query);
	}

	public ArrayList<Book> list() {
		ArrayList<Book> list = new ArrayList<Book>();
		try {
			PreparedStatement stmt  = query("SELECT * FROM book");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Book item = new Book();
				
				item.setBookid(rs.getInt(1));
				item.setBookname(rs.getString(2));
				item.setPublisher(rs.getString(3));
				item.setPrice(rs.getInt(4));
				
				list.add(item);
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;
	}

	public Book item(String bookid) {
		  Book item = new Book();
		    try {
				PreparedStatement stmt = query("SELECT * FROM book WHERE bookid=?");
				stmt.setString(1, bookid);
				ResultSet rs = stmt.executeQuery();
				
				if(rs.next()) {
				
				item.setBookid(rs.getInt(1));
				item.setBookname(rs.getString(2));
				item.setPublisher(rs.getString(3));
				item.setPrice(rs.getInt(4));
				}
				
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		    return item;
	}

	public int delete(String bookid) {
		int result =0;
		try {
			PreparedStatement stmt = query("DELETE FROM book WHERE bookid=?");
			stmt.setString(1, bookid);
			result = stmt.executeUpdate();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return result;
	}

	public int add(String bookid, String bookname, String publisher, String price) {
		int result =0;
		try {
			PreparedStatement stmt = query("INSERT INTO book VALUES (?, ?, ?, ?)");
			stmt.setString(1, bookid);
			stmt.setString(2, bookname);
			stmt.setString(3, publisher);
			stmt.setString(4, price);
			
			result = stmt.executeUpdate();
			
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return result;
	}

	public int update(String bookid, String bookname, String publisher, String price) {
		int result = 0;
		try {
			PreparedStatement stmt = query("UPDATE book SET bookname =?, publisher=?, price=? WHERE bookid =?");
			
			stmt.setString(4, bookid);
			stmt.setString(1, bookname);
			stmt.setString(2, publisher);
			stmt.setString(3, price);
			
			result = stmt.executeUpdate();
			
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return result;
	}

}
