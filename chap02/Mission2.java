package chap02;

import java.util.Scanner;

public class Mission2 {

	public static void main(String[] args) {
	
		Scanner scan = new  Scanner(System.in);
		System.out.print("�Է��� ������ �����ּ��� >>");
		String msg = scan.next();
		System.out.println("mag =" +msg);
		
		
		System.out.print("�Է��� ������ �����ּ��� >>");
		int num = scan.nextInt();
		System.out.println("num =" +num);
	  
		scan.close();
	}

}
