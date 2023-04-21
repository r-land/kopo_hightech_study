package com.exweb.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//data access object 여기서 자바 객체 받아서 디비테이블 행으로 넣어주는 상호교환 작업해줌 
//이렇게 해놓으면 여기서 디비관련 문제 수정만 해주면 다 바뀜
public class MemberDaoJdbc implements MemberDao {
//클래스명 변경은 alt +shift +R 사용하는거 다 바뀜
	//memlist서블릿에서 디비 관련된 필드선언 변수랑 메소드 가져왔음 add 서블릿에도 적용됨
	String url = "jdbc:oracle:thin:@localhost:1521:xe";  // DB 서버 주소
	String user = "web";  // DB 접속 아이디
	String password = "web01"; //db 접속 비밀번호
	
	@Override
	public List<MemberVo> selectMemberList() {
		//한번 읽을때 멤버객체 여러개 저장하고싶어서 만드는 배열메소드 트라이문 밖에서 만들어야됨 
		List<MemberVo> list = new ArrayList<MemberVo>();
		
		String sql ="SELECT mem_id, mem_pass, mem_name, mem_point FROM member" ; 
		//jdbc sql은 ;세미콜론 없고 뒤에 공백 하나씩  +변수+로 하면 해킹 위험 
		
		
		try(//지정한 데이터베이스 접속하라는 명령문
				Connection conn = DriverManager.getConnection(url, user, password); 
				//해당 연결을 통해 실행할 sql문을 담은 명령문 객체 생성
				PreparedStatement pstmt = conn.prepareStatement(sql);	
				ResultSet rs = pstmt.executeQuery(); 
				)//try(괄호)안은 try-catch블럭 실행 완료후 conn, pstmt 자동으로 종료 close()메서드 실행 이전에는 finally 에 if !=null 구문까지 했어야함
			{	
			//sql문 실행  selet문 실행은 executeQuery()메서드 사용
			//반환값은 조회결과  레코드(row) 수
			
			//처음 resultset 객체는 첫 레코드(row) 이전을 가르키고 있음
			// .next() 메서드를 실행하면 다음 레코드를 가리키게 된다.
			//.next() 다음 레코드가 있으면 true를 반환하고 없으면 false를 반환한다.
			
			while (rs.next()) {
				MemberVo vo = new MemberVo(); //한번 돌때마다 네개 변수 담긴 vo 클래스 한세트 생성 회원 한명
				//컬럼값의 데이터타입에 따라 get타입("컬럼명") 메소드를 사용하여 컬람값 읽기
				vo.setMemId(rs.getString("mem_id"));//현재 가리키는 레코드(row)의 mem-id 컬럼값 읽기
				vo.setMemPass(rs.getString("mem_pass"));//현재 가리키는 레코드(row)의 mem-pass 컬럼값 읽기
				vo.setMemName(rs.getString("mem_name"));//현재 가리키는 레코드(row)의 mem-naem 컬럼값 읽기
				vo.setMemPoint(rs.getInt("mem_point"));//현재 가리키는 레코드(row)의 mem-point 컬럼값 읽기
				list.add(vo); //배열로 한바퀴돌때마다 회원수만큼 입력된다 
				
				// 이데이터를 한세트로 만들어서 저장하는 디비만들기 데이터 타입 다 다르기 때문에 클래스로 만들기 
				//클래스는 존재하지 않은 타입을 클래스로 만들거나 현실의 것을 코드화 하는것
			}
		
			} catch (SQLException e) {
			e.printStackTrace();
		}
		//프로그램이 완벽해도 db server 이상하면 접속 안될수도 있어서 오류 뜨지만 예외처리 해주면됨 
		return list;
	}
		
	
	@Override
	public int insertMember(MemberVo vo) {
		String sql = "insert into member (mem_id, mem_pass, mem_name, mem_point) " + "values (?, ?, ?, ? )";
		// jdbc sql은 세미콜론 없고 뒤에 공백 하나씩 +변수+로 하면 해킹 위험
		// 이방법으로도 insert 가능
		int n = 0;
		try (// 지정한 데이터베이스 접속하라는 명령문
				Connection conn = DriverManager.getConnection(url, user, password);
				// 해당 연결을 통해 실행할 sql문을 담은 명령문 객체 생성
				PreparedStatement pstmt = conn.prepareStatement(sql);)// try(괄호)안은 try-catch블럭 실행 완료후 conn, pstmt 자동으로
																		// 종료 close()메서드 실행 이전에는 finally 에 if !=null
																		// 구문까지 했어야함
		{
			// pstmt 명령문 객체에 담겨 있는 sql문의 ?에 값 채워넣기
			// 채워넣는 값의 타입에 따라서 set타입명() 메서드 사용
			pstmt.setString(1, vo.getMemId()); // 1번쨰 ?에 memId 값 넣기
			pstmt.setString(2, vo.getMemPass()); // 2번째 ?에 mempass 값 넣기
			pstmt.setString(3, vo.getMemName()); // 3번째 ?에 memname 값 넣기
			pstmt.setInt(4, vo.getMemPoint()); // 4번째 ?에 mempoint 값 넣기

			// sql문 실행 insert, update,delete문 실행은 executeUpdate()메서드 사용

			n = pstmt.executeUpdate(); // 반환값은 sql문 실행으로 영향받은 레코드(row) 수

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return n;
	}
	
	@Override
	public int deleteMember(String memId) {
		String sql ="delete from member where mem_id = ?";
			
		//jdbc sql은 세미콜론 없고 뒤에 공백 하나씩  +변수+로 하면 해킹 위험 
		//이방법으로도 insert 가능 
		int n=0;
		try(//지정한 데이터베이스 접속하라는 명령문
				Connection conn = DriverManager.getConnection(url, user, password); 
				//해당 연결을 통해 실행할 sql문을 담은 명령문 객체 생성
				PreparedStatement pstmt = conn.prepareStatement(sql);		
				)//try(괄호)안은 try-catch블럭 실행 완료후 conn, pstmt 자동으로 종료 close()메서드 실행 이전에는 finally 에 if !=null 구문까지 했어야함
			{
			//pstmt 명령문 객체에 담겨 있는 sql문의 ?에 값 채워넣기 
			//채워넣는 값의 타입에 따라서 set타입명() 메서드 사용
			pstmt.setString(1, memId); //1번쨰 ?에 memId 값 넣기

			//sql문 실행  insert, update,delete문 실행은 executeUpdate()메서드 사용
			
			n = pstmt.executeUpdate(); //반환값은 sql문 실행으로 영향받은 레코드(row) 수
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//프로그램이 완벽해도 db server 이상하면 접속 안될수도 있어서 오류 뜨지만 예외처리 해주면됨 
		return n;
	}
	
	
}
