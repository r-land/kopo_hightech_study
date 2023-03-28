package chap03;

import java.util.Scanner;

public class Mission9 {

	public static void main(String[] args) {

      // 입력수로 평균구하기
		int count =0;
		int sum =0 ;// 입력갯수 총합 
		double avg = 0.0; //평균
		
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자들입력하세요 마지막은 -1>");
		
	 int num;
		//do -while 문 
	 do{num = sc.nextInt();
		sum += num;
		count ++; 
		}
		while(num !=-1);
	 count = count -1;
		if(count>0)
		{System.out.println("정수 갯수 :" + count);		
		avg =(double)sum/count;
		System.out.printf("입력된 값들의 평균은 %.2f", avg );
		}
		else System.out.println();
		sc.close();
	}}

