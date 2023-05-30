package miniproject_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

public class DBConnect {
	//0. JDBC Driver, URL, ID, PW 설정
	static String jdbcdriver = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3305/mydb";
	static String id = "root";
	static String pw = "1234";
    static Vector<Test> vtest = null;
	

	
	public static void main(String args[]) throws SQLException, ClassNotFoundException{

		Test t= null;
		vtest = new Vector<Test>();
		
//		//미션1. 입력받은 값을 이름(name)과 이메일(mail)로 분류하여 값을 나눠주세요.
//		Scanner scan = new Scanner(System.in);
//		System.out.print("이름,이메일(콤마로 구분)>>");
//		String[] line = scan.nextLine().split(",");
//		String name = line[0].trim();
//		String mail = line[1].trim();
//		t.setUname(name);
//		t.setEmail(mail);
		
		//0. SQL 문 정의 
//		String sql = "insert into test values(?,?)";	
		String sql = "select * from test"; //테이블조회
		//0.DB 연결에 필요한 객체 선언 
		Connection con = null;
		PreparedStatement pstmt = null;
		
		//1. JDBC 드라이버 로드
		Class.forName(jdbcdriver);	//ClassNotFoundException
		//2. Connection 연결
		con = DriverManager.getConnection(url, id, pw);
		pstmt = con.prepareStatement(sql);		
//		pstmt.setString(1, t.getUname());
//		pstmt.setString(2, t.getEmail());
	    //4. SQL 전송 : executeQuery(조회)-ResultSet, executeUpdate(삽입, 삭제, 수정)-int
//		if(pstmt.executeUpdate()==0)
//			System.out.println("SQL이 수행되지 않았습니다.");		
	    //5. ResultSet으로 Transaction 처리
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			t = new Test();
			t.setUname(rs.getString("uname"));
			t.setEmail(rs.getString("email"));
			vtest.add(t);
			
		}
		
		//6. Vector 내용 출력
		for(Test tt : vtest) {
			System.out.println(tt.getUname() + ", " + tt.getEmail());
		}
		
		
		
		pstmt.close();
		con.close();
		}
	}