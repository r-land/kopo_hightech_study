package com.exam.myapp.bbs;

import org.apache.ibatis.annotations.Mapper;

//Daobatis 클래스 대신 @Mapper를 붙여서 바티스 스캔기능으로 '인터페이스'의 구현체를 자동 생성 
@Mapper
public interface AttachDao {

	/* List<BbsVo> selectBbsList(); */

		int insertAttach(AttachVo vo);

		AttachVo selectAttach(int attNo);

	/*
	 * int deleteBbs(int memId);
	 * 
	 * BbsVo selectBbs(int memId);
	 * 
	 * int updateBbs(BbsVo vo);
	 */

}