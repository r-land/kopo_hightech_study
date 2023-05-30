package miniproject_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

public class DBConnect {
	//0. JDBC Driver, URL, ID, PW ����
	static String jdbcdriver = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3305/mydb";
	static String id = "root";
	static String pw = "1234";
    static Vector<Test> vtest = null;
	

	
	public static void main(String args[]) throws SQLException, ClassNotFoundException{

		Test t= null;
		vtest = new Vector<Test>();
		
//		//�̼�1. �Է¹��� ���� �̸�(name)�� �̸���(mail)�� �з��Ͽ� ���� �����ּ���.
//		Scanner scan = new Scanner(System.in);
//		System.out.print("�̸�,�̸���(�޸��� ����)>>");
//		String[] line = scan.nextLine().split(",");
//		String name = line[0].trim();
//		String mail = line[1].trim();
//		t.setUname(name);
//		t.setEmail(mail);
		
		//0. SQL �� ���� 
//		String sql = "insert into test values(?,?)";	
		String sql = "select * from test"; //���̺���ȸ
		//0.DB ���ῡ �ʿ��� ��ü ���� 
		Connection con = null;
		PreparedStatement pstmt = null;
		
		//1. JDBC ����̹� �ε�
		Class.forName(jdbcdriver);	//ClassNotFoundException
		//2. Connection ����
		con = DriverManager.getConnection(url, id, pw);
		pstmt = con.prepareStatement(sql);		
//		pstmt.setString(1, t.getUname());
//		pstmt.setString(2, t.getEmail());
	    //4. SQL ���� : executeQuery(��ȸ)-ResultSet, executeUpdate(����, ����, ����)-int
//		if(pstmt.executeUpdate()==0)
//			System.out.println("SQL�� ������� �ʾҽ��ϴ�.");		
	    //5. ResultSet���� Transaction ó��
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			t = new Test();
			t.setUname(rs.getString("uname"));
			t.setEmail(rs.getString("email"));
			vtest.add(t);
			
		}
		
		//6. Vector ���� ���
		for(Test tt : vtest) {
			System.out.println(tt.getUname() + ", " + tt.getEmail());
		}
		
		
		
		pstmt.close();
		con.close();
		}
	}