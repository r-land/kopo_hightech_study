package com.exam.myapp.bbs;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

//싱글톤(Singleton) 애플리케이션 전체에서 인스턴스를 1개만 생성하여 사용하는 객체
@Service
@Transactional //이 객체의 모든 메서드들을 각각 하나의 트랜젝션으로 정의  
public class BbsServiceImpl implements BbsService{
	@Autowired
	private BbsDao bbsDao;
	@Autowired
	private AttachDao attachDao;
	
	
	private String uploadPath = "C:/Temp/upload"; //게시판 첨부파일 저장 위치
	
	public BbsServiceImpl() {
	new File(uploadPath).mkdirs(); //uploadPath 디렉토리가 없으면 생성
	}

	@Override
	public List<BbsVo> selectBbsList() {
		return bbsDao.selectBbsList();
	
	}

	
//	@Transactional //이 메서드를 하나의 트랜젝션으로 정의  
	@Override
	public int insertBbs(BbsVo vo) {
		int num = bbsDao.insertBbs(vo);
		
		
		 for (MultipartFile f : vo.getBbsFile()) {
			 if(f.getSize()<=0) continue; //파일크기가 0인 경우, 저장하지 않음
			 
			 System.out.println("파일명:" + f.getOriginalFilename());
			 System.out.println("파일크기:" + f.getSize());
			 
			 
			 String fname = UUID.randomUUID().toString();  //중복될 확률이 극도로 낮은 랜덤 문자열 생성
			 File saveFile = new File(uploadPath, fname);
			
			 
				 try {
					f.transferTo(saveFile); //파일f의 내용을 saveFile에 복사(저장)
				 
					AttachVo attVo = new AttachVo();
					
					attVo.setAttBbsNo(vo.getBbsNo()); //첨부파일이 속한 게시글번호
					attVo.setAttOrgName(f.getOriginalFilename()); //첨부파일 원래 이름 
					attVo.setAttNewName(fname); //첨부파일저장이름
					
					attachDao.insertAttach(attVo);
					
				} catch (IllegalStateException | IOException e) {
				//	e.printStackTrace();
					throw new RuntimeException(e); //첨부파일 저장 중 오류 발생시 트랜잭션이 롤백되도록 
				} 
			 
		}
		 
		
		return num;
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

	@Override
	public AttachVo selectAttach(int attNo) {
		return attachDao.selectAttach(attNo);
	}

	@Override
	public File getAttachFile(AttachVo vo) {
		return new File(uploadPath, vo.getAttNewName());
	}


	}


