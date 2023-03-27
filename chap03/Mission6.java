package chap03;

import java.util.Scanner;

public class Mission6 {
//3,6,9 게임만들기
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1~99사이의 정수를 입력>>");
		int i= sc.nextInt();
		//입력값 
		int crap = 0;
		if(i/10==3 || i/10==6 || i/10==9) //십의 자리 369
			crap++;
		if(i%10==3 || i%10==3 || i%10==9) //일의자리 369
			crap++;
	    //박수값 
		if(crap == 0) 
			System.out.println(i);
		else {System.out.print("박수");
					if(crap == 1)  System.out.println("짝");
					else System.out.println("짝짝");	}
		//369프로그램 출력
			sc.close();
	}

}
