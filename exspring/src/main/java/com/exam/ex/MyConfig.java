package com.exam.ex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  //스프링 설정파일 역할을 하는 클래스임을 표시  요즘은 xml 안쓰고 자바 쓰는데 이프로젝는 래거시 프로젝트니깐 xml 쓸거야
@ComponentScan(basePackages = "com.exam.ex") //vale = 가능 하나만있을떄는 생략도 가능
public class MyConfig {

	//@Bean //("ma") //이 메서드에서 반환하는 객체를 스프링에 등록 name=  value = 생략가능
	public MyApp ma() {  //이름을 생략하면 메서드명을 빈 이름으로 사용
		MyApp app = new MyApp();
		app.setMyService(this.msk());
		return app;
	}
	
	//@Bean //("msk") 
	public MyService msk() {
		return new MyServiceKo();
	}
	
//	@Bean //("mse") 
	public MyService mse() {
		return new MyServiceEn();
	}
	
}
