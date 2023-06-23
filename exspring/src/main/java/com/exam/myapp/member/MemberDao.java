package com.exam.myapp.member;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

//Daobatis 클래스 대신 @Mapper를 붙여서 바티스 스캔기능으로 '인터페이스'의 구현체를 자동 생성 
@Mapper
public interface MemberDao {

	List<MemberVo> selectMemberList();

	int insertMember(MemberVo vo);

	int deleteMember(String memId);

	MemberVo selectMember(String memId);
	
	int updateMember(MemberVo vo);

	MemberVo selectLogin(MemberVo vo);
}