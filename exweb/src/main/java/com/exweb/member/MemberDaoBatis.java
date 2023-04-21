package com.exweb.member;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//jdbc가 해줄수 있지만 각 서블릿 마다 중복되는것이 있어서
//memberdao 와 jdbc  두군데서 같이쓰는걸 인터페이스 만든다
public class MemberDaoBatis implements MemberDao {

	SqlSessionFactory sqlSessionFactory;
	//아래에 트라이문 안에서  sqlSessionFactory  분리하고 트라이 문 위로 보내기
	{		
		try {
			String resource = "batis/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			//설정파일의 내용대로 sqlsessionFactory(마이바티스본체)생성
			//ctrl +shift + o 임포트
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public List<MemberVo> selectMemberList() {
		List<MemberVo> list=null; 
//		new ArrayList<Membervo>(); 
		//리스트 선언 분리후 트라이 밖으로 꺼내고 초기값설정 null이나 new로
		try (SqlSession session = sqlSessionFactory.openSession()) {
			//실행할 sql문과 동일한 이름의 메서드를 사용하여 sql문 실행
			//select 결과가 1행인 경우 selectOne, 2행이상인 경우 slectList 메서드 사용
			//첫번쨰 인자로 실행할 sql문의 고유한 이름 전달
			//두번쨰 인자로 sql문 실행시 필요한 데이터를 담은 객체를 전달 //지금은 필요없으니 삭제 원래 ,101 이였음
			list = session.selectList("com.exweb.member.MemberDao.selectMemberList");
			}
		//마이바티스 사이트 SqlSessionFactory 에서 SqlSession 만들기 에서 복붙 임포트 하고  
	return list;
	}

	@Override
	public int insertMember(MemberVo vo) {
		// TODO Auto-generated method stub
		return 0; 	}

	@Override
	public int deleteMember(String memId) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	
}
