package com.exam.ex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



//이 클래스의 객체를 생성하여 "ma"라는 이름으로 스프링에 등록
@Component("ma")
public class MyApp {
	//@Autowired, @Inject/(타입으로 먼저찾고 이름으로 찾기), @Resource(이름으로 먼저찾고 타입맞는거 찾기) : 스프링에 등록된 객체를 이 변수(속성)에 주입(저장) > @Qualifier ("별명") @Named("이름")
	@Autowired
	private MyService myService;
	
	public void say() {
		System.out.println(myService.getMessage());
	}

	public MyService getMyService() {
		return myService;
	}

	public void setMyService(MyService myService) {
		this.myService = myService;
	}
	
	
	
}
