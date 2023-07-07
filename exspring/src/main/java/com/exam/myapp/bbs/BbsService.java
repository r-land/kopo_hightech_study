package com.exam.myapp.bbs;

import java.io.File;
import java.util.List;

public interface BbsService {

	List<BbsVo> selectBbsList();

	int insertBbs(BbsVo vo);

	int deleteBbs(int memId);

	BbsVo selectBbs(int memId);
	
	int updateBbs(BbsVo vo);

	AttachVo selectAttach(int attNo);

	File getAttachFile(AttachVo vo);





}