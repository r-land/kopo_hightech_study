package com.exam.myapp.bbs;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

//Daobatis 클래스 대신 @Mapper를 붙여서 바티스 스캔기능으로 '인터페이스'의 구현체를 자동 생성 
@Mapper
public interface BbsDao {

	List<BbsVo> selectBbsList(SearchInfo info);

	int insertBbs(BbsVo vo);

	int deleteBbs(int memId);

	BbsVo selectBbs(int memId);
	
	int updateBbs(BbsVo vo);

	int selectBbsCount(SearchInfo info);


}