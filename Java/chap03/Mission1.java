package chap03;

import java.util.Scanner;
//while 반복문
public class Mission1 {

	public static void main(String[] args) {
Scanner sc =new Scanner(System.in);

//  1. while 문 사용 
System.out.println("토익점수 >>");
int toeic = sc.nextInt();

while(true) {//무한반복
	if(toeic>700) break;
	System.out.println("공부를 하세요!");
	System.out.println("시험을 보세요!");
	System.out.println("토익점수 >>");
	toeic = sc.nextInt();
	}
System.out.println("토익 탈출!!");

sc.close();

	}

}
