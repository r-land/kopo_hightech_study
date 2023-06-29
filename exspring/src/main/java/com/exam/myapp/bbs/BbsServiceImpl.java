package com.exam.myapp.bbs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//싱글톤(Singleton) 애플리케이션 전체에서 인스턴스를 1개만 생성하여 사용하는 객체
@Service
public class BbsServiceImpl implements BbsService{
	@Autowired
	private BbsrDao bbsDao;
	
	
	@Override
	public List<BbsVo> selectBbsList() {
		return bbsDao.selectBbsList();
	
	}

	@Override
	public int insertBbs(BbsVo vo) {
		return bbsDao.insertBbs(vo);
	}

	@Override
	public int deleteBbs(int memId) {
		return bbsDao.deleteBbs(memId);
	}

	@Override
	public BbsVo selectBbs(int memId) {
		return bbsDao.selectBbs(memId);
	}

	@Override
	public int updateBbs(BbsVo vo) {
		return bbsDao.updateBbs(vo);
	}


	}


