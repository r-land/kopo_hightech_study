package miniproject_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import miniproject.Test;

public class ProductDAO {
	//0. JDBC Driver, URL, ID, PW 설정
	String jdbcdriver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3305/mydb";
	String id = "root";
	String pw = "1234";
	Product p; //상품정보를 위한 객체 
	ArrayList<Product> product_list = null;
	   
	Connection conn;    
	PreparedStatement pstmt;    
	ResultSet rs;
	String sql;
	
	//DB 연결 메서드
	public void connectDB() throws Exception {
		try {
			Class.forName(jdbcdriver);
			conn = DriverManager.getConnection(url, id, pw);
		}
		catch(Exception e) {e.printStackTrace();}
	}
	
	
	//DB 종료 메서드 
	public void closeDB() {
		try {
			pstmt.close();
			conn.close();
		}
		catch(Exception e) {e.printStackTrace();}
	}
	
	
	//전체 product 리스트로 구성된 arraylist를 리턴 (전체조회)
	public ArrayList<Product> getAll(){}
	
	//파라미터에서 pcode에 해당하는 상품을 리턴 (일부조회)
	public Product getProduct(int pcode) {
		
		//1. db연결
		connectDB();
		//2. pstmt에 sql 활용해서 executeUpdate 메소드 활용 insert
		sql = "select * form product where pcode = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pcode);
			pstmt.executeQuery();
			rs.next();
			
			//todo : cellphone 또는 smartTv로 분류해서 값을 넣어야함
			p = new SmartTV();
			p = new CellPhone();
			
			p.setPcode(rs.getInt("pcode"));
			p.setPname(rs.getString("pname"));
			p.setPrice(rs.getInt("price"));
			p.setMf(rs.getString("mf"));
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		finally {
		//3 db 종료
			closeDB();
		}
		return p;
	}
	
	
	//Product 객체 내용 DB 저장 (insert)
	public boolean newProduct(Product product) {
		//1. db연결
		connectDB();
		//2. pstmt에 sql 활용해서 executeUpdate 메소드 활용 insert
		sql = "insert into product(pname, price, mf) values(?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getPname());
			pstmt.setInt(2, product.getPrice());
			pstmt.setString(3, product.getMf());
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
		//3 db 종료
			closeDB();
		}
		return true;
	}
	
	//Product 객체 내용 중 pcode에 해당하는 객체를  DB 삭제 (delete) 
	public boolean delProduct(int pcode) throws Exception {
		
		//1. db연결
		connectDB();
		//2. pstmt에 sql 활용해서 executeUpdate 메소드 활용 insert
		sql = "delete from product where pcode = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pcode);
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
		//3 db 종료
			closeDB();
		}
		return true;
	}
	
	
	//Product 객체 내용 업데이트(update)
	public boolean updateProduct(Product product) {
		
		//1. db연결
		connectDB();
		//2. pstmt에 sql 활용해서 executeUpdate 메소드 활용 insert
		sql = "update product set pname=?, price=?, mf=? where pcode=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getPname());
			pstmt.setInt(2, product.getPrice());
			pstmt.setString(3, product.getMf());
			pstmt.setInt(4, product.getPcode());
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
		//3 db 종료
			closeDB();
		}
		return true;
	}
	
}
