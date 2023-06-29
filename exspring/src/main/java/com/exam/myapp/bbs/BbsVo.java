package com.exam.myapp.bbs;

import java.util.Date;

//value object 객체 안 속성이 모두 동일하면 두 객체가 동일하다 말할 수 있다 . 
//디비 테이블 레코드 한 행 정보 담을 수 있는 클래스 
//이 클래스는 회원정보 한명의 정보를 모두 담고싶어서 만들었음
//자바 캡슐화 접근제어자 프라이빗 붙여서 직접 접근 막기
public class BbsVo {
	private int bbsNo;
	private String bbsTitle;
	private String bbsContent;
	private String bbsWriter;
	private Date bbsRegDate;
	private int bbsCount;
	
	
	public int getBbsNo() {
		return bbsNo;
	}
	public void setBbsNo(int bbsNo) {
		this.bbsNo = bbsNo;
	}
	public String getBbsTitle() {
		return bbsTitle;
	}
	public void setBbsTitle(String bbsTitle) {
		this.bbsTitle = bbsTitle;
	}
	public String getBbsContent() {
		return bbsContent;
	}
	public void setBbsContent(String bbsContent) {
		this.bbsContent = bbsContent;
	}
	public String getBbsWriter() {
		return bbsWriter;
	}
	public void setBbsWriter(String bbsWriter) {
		this.bbsWriter = bbsWriter;
	}
	public Date getBbsRegDate() {
		return bbsRegDate;
	}
	public void setBbsRegDate(Date bbsRegDate) {
		this.bbsRegDate = bbsRegDate;
	}
	public int getBbsCount() {
		return bbsCount;
	}
	public void setBbsCount(int bbsCount) {
		this.bbsCount = bbsCount;
	}
	
}
