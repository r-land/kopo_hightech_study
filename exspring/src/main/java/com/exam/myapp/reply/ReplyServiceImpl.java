package com.exam.myapp.reply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Autowired
	private ReplyDao repDao;
	
	@Override
	public int insertReply(ReplyVo vo) {
		
		return repDao.insertReply(vo);
	}

	@Override
	public List<ReplyVo> selectReplyList(int repBbsNo) {
		return repDao.selectReplyList(repBbsNo);
	}



}


