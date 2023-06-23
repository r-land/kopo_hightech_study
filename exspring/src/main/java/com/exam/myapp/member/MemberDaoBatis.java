package com.exam.myapp.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//jdbc가 해줄수 있지만 각 서블릿 마다 중복되는것이 있어서
//memberdao 와 jdbc  두군데서 같이쓰는걸 인터페이스 만든다
//@Repository
public class MemberDaoBatis implements MemberDao {
 /* @Autowired private SqlSessionFactory sqlSessionFactory; */
	@Autowired
	private SqlSession session;
	@Override
	public List<MemberVo> selectMemberList() {
		return session.selectList("com.exam.myapp.member.MemberDao.selectMemberList");
	}

	@Override
	public int insertMember(MemberVo vo) {
		return session.insert("com.exam.myapp.member.MemberDao.insertMember", vo);
	}
	

	@Override
	public int deleteMember(String memId) {
		return session.delete("com.exam.myapp.member.MemberDao.deleteMember", memId);
	}

	@Override
	public MemberVo selectMember(String memId) {
		return session.selectOne("com.exam.myapp.member.MemberDao.selectMember",memId);
	
	}

	@Override
	public int updateMember(MemberVo vo) {
		return session.update("com.exam.myapp.member.MemberDao.updateMember", vo);
	}

	@Override
	public MemberVo selectLogin(MemberVo mvo) {
		return session.selectOne("com.exam.myapp.member.MemberDao.selectLogin",mvo);
	}	
}
