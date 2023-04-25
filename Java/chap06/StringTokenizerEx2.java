package chap06;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringTokenizerEx2 {
	public static void main(String[] args) {
			
Scanner scan = new Scanner(System.in);
//1. StringTokenizer 이용한 프로그램	
//	while(true) {
//		System.out.println(">>");
//		String s = scan.nextLine();
//		if(s.equals("그만"))
//			break;
//		StringTokenizer st = new StringTokenizer(s, " ");
//		System.out.println("어절 개수는" +st.countTokens());
//	}
//System.out.println("종료");		


//2.split 이용한 프로그램
	while(true) {
		System.out.println(">>");
		String s=scan.nextLine();
		if (s.equals("그만"))
			break;
		String arr[]=s.split(" ");
		System.out.println("어절 개수는 "+arr.length);
	}
		System.out.println("종료");
	}
}
