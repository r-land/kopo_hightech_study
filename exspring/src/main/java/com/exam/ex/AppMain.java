package com.exam.ex;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {
	
	public static void main(String[] args) {
		//MyApp, MyServiceKo 를 사용하여,
		//콘솔에 "안녕"이 출력되도록 구현 
		
//		MyApp app = new MyApp();
//		MyServiceKo msk = new MyServiceKo();
//		app.setMyService(msk);
		
//		MyServiceEn mse = new MyServiceEn();
//		app.setMyService(mse);
		
		//스프링 == (IoC/DI 기능을 가진) 객체컨테이너 == BeanFactory == ApplicationContext
		//클래스패스 상의 XML 파일로부터 "설정"을 읽어서, 스프링객체컨테이너 생성 스프링 역할은 자바파일 컴파일 필요 없이 설정만 수정하면 됨 제어권 스프링  제어의 역전ioc 객체가 의존하는 외부의 다른 객체를 결정 의존성 주입 Di
		//라이브러리는 내가 주도권 필요한걸 가져다씀 프레임워크는 주된 흐름이 프로그램 내가 필요할걸 집어넣음 
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("/com/exam/ex/context.xml");
		
		
		//java 클래스로부터 설정을 읽어서, 스프링 객체 컨테이너 생성
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);
		
		//스프링에 "ma"라는 이름으로 등록되어 있는 객체 가져오기
		MyApp app = (MyApp) ctx.getBean("ma");
		
		app.say();
		
	}
}
