package chap02;

import java.util.Scanner;

public class Mission2 {

	public static void main(String[] args) {
	
		Scanner scan = new  Scanner(System.in);
		System.out.print("입력할 내용을 적어주세요 >>");
		String msg = scan.next();
		System.out.println("mag =" +msg);
		
		
		System.out.print("입력할 정수를 적어주세요 >>");
		int num = scan.nextInt();
		System.out.println("num =" +num);
	  
		scan.close();
	}

}
