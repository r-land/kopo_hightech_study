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
	//driver, dburl, id, pw ����
	String jdbcdriver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3305/mydb";
	String id = "root";
	String pw = "1234";
	
	//conn, pstmt, rs , sql
	Connection conn;    
	PreparedStatement pstmt;    
	ResultSet rs;
	String sql;
	
	// ArrayList ��ǰ������ ��� ����
	ArrayList<Product> datas = null;
	Vector<String> items = null;
	
	//connectDB : DB ����
	public void connectDB() {
		try {
			Class.forName(jdbcdriver);
			conn = DriverManager.getConnection(url, id, pw);
		}
		catch(Exception e) {e.printStackTrace();}
	}
	
	//closeDB : DB ����
	public void closeDB() {
		try {
		pstmt.close();
		conn.close();
	}
	catch(Exception e) {e.printStackTrace();}
}
	
	// newProduct : ��ǰ ��� ���
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
	
	// delProduct : ��ǰ ���� ��� 
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

	//updateProduct : ��ǰ ���� ������Ʈ ��� 
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
	
	
	//getItems : pcode ����Ʈ�� ��ȸ�ϴ� ��� 
	public Vector<String> getItems(){
		return items;
	}
	
	// getAll ��ü ������ ��ȸ�ϴ� ��� 
	public ArrayList<Product> getAll(){
		connectDB();
		sql = "select * from product";
	     
		//��ü �˻� �����͸� �����ϱ� ���� ArrayList
		ArrayList<Product> datas = new ArrayList<Product>();
		
		// �����ڵ� �޺��ڽ� �����͸� ���� ���� �ʱ�ȭ
		items = new Vector<String>();
		items.add("��ü");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
			Product product = new Product();
			product.setPcode(rs.getInt("pcode"));
			product.setPname(rs.getString("pname"));
			product.setPrice(rs.getInt("pcode"));
			product.setManufacture(rs.getString("manufacture"));
			datas.add(product);					//��ü��ǰ���
			items.add(String.valueOf(rs.getInt("pcode")));     //todo for GUI �޺��ڽ��� ���
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
		
	
	
	//getProduct : ��ǰ�ڵ�� ��ǰ ������ ��ȸ�ϴ� ���
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



