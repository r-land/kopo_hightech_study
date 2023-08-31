package com.exam.myapp.member;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

//2.0부터 사용가능
//@NotEmpty , @NotBlank,
//@positivem, positiveorzero
//@negative, negativeorzero
//@email
//@future, futureorpresent
//@past, pastorpresent



//value object 객체 안 속성이 모두 동일하면 두 객체가 동일하다 말할 수 있다 . 
//디비 테이블 레코드 한 행 정보 담을 수 있는 클래스 
//이 클래스는 회원정보 한명의 정보를 모두 담고싶어서 만들었음
//자바 캡슐화 접근제어자 프라이빗 붙여서 직접 접근 막기
public class MemberVo {
	@NotNull @Size(min = 3,max = 50) @Email
	private String memId; //mem_id 컬럼명이랑 다른 문제 자바는 기본이 나파표기법 별명으로 처리 as 띄어쓰기 있으면
	@NotNull @Size(min = 4,max = 50, message = "비밀번호는 영문+숫자")
	private String memPass;
	@NotNull @Size(min = 1,max = 50)
	private String memName;
	@Digits(integer = 10, fraction = 0)
	private int memPoint;
	
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPass() {
		return memPass;
	}
	public void setMemPass(String memPass) {
		this.memPass = memPass;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public int getMemPoint() {
		return memPoint;
	}
	public void setMemPoint(int memPoint) {
		this.memPoint = memPoint;
	}
	
	//프라이빗이라서 다른데서 읽고 쓰라고 get set 

}
