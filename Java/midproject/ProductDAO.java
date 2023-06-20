package midproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import midproject.Product;

public class ProductDAO {
	//driver, dburl, id, pw 정의
	String jdbcdriver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3305/mydb";
	String id = "root";
	String pw = "1234";
	
	//conn, pstmt, rs , sql
	Connection conn;    
	PreparedStatement pstmt;    
	ResultSet rs;
	String sql;
	
	// ArrayList 상품정보를 모두 넣음
	ArrayList<Product> datas = null;
	Vector<String> items = null;
	
	//connectDB : DB 연결
	public void connectDB() {
		try {
			Class.forName(jdbcdriver);
			conn = DriverManager.getConnection(url, id, pw);
		}
		catch(Exception e) {e.printStackTrace();}
	}
	
	//closeDB : DB 종료
	public void closeDB() {
		try {
		pstmt.close();
		conn.close();
	}
	catch(Exception e) {e.printStackTrace();}
}
	
	// newProduct : 상품 등록 기능
	public boolean newProduct(Product product) {
		connectDB();
		sql = "insert into product (pname,price,manufacture) values (?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getPname());
			pstmt.setInt(2, product.getPrice());
			pstmt.setString(3, product.getManufacture());
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
			}
		finally {
			closeDB();
		}
		return true;
	}
	
	// delProduct : 상품 삭제 기능 
	public boolean delProduct(int pcode) {
		connectDB();
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
			closeDB();
		}
		return true;
	}

	//updateProduct : 상품 정보 업데이트 기능 
	public boolean updateProduct(Product product) {
		
		connectDB();
		sql = "update product set pname=?, price=?, manufacture=? where pcode=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getPname());
			pstmt.setInt(2, product.getPrice());
			pstmt.setString(3, product.getManufacture());
			pstmt.setInt(4, product.getPcode());
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
			}
		finally {
			closeDB();
		}
		return true;
	}
	
	
	//getItems : pcode 리스트를 조회하는 기능 
	public Vector<String> getItems(){
		return items;
	}
	
	// getAll 전체 정보를 조회하는 기능 
	public ArrayList<Product> getAll(){
		connectDB();
		sql = "select * from product";
	     
		//전체 검색 데이터를 전달하기 위한 ArrayList
		ArrayList<Product> datas = new ArrayList<Product>();
		
		// 관리코드 콤보박스 데이터를 위한 벡터 초기화
		items = new Vector<String>();
		items.add("전체");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
			Product product = new Product();
			product.setPcode(rs.getInt("pcode"));
			product.setPname(rs.getString("pname"));
			product.setPrice(rs.getInt("pcode"));
			product.setManufacture(rs.getString("manufacture"));
			datas.add(product);					//전체상품목록
			items.add(String.valueOf(rs.getInt("pcode")));     //todo for GUI 콤보박스내 목록
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
			}
		finally {
			closeDB();
		}
		return datas;
	}
		
	
	
	//getProduct : 상품코드로 상품 정보를 조회하는 기능
	public Product getProduct(int pcode) {
		connectDB();
		Product product = null;
		sql = "select * from product where pcode = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pcode);
			rs = pstmt.executeQuery();
			rs.next();
			product = new Product();
			product.setPcode(rs.getInt("pcode"));
			product.setPname(rs.getString("pname"));
			product.setPrice(rs.getInt("pcode"));
			product.setManufacture(rs.getString("manufacture"));
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
			}
		finally {
			closeDB();
		}
		return product;	
	}
	
}



