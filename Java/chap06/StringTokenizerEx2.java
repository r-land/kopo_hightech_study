package chap06;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringTokenizerEx2 {
	public static void main(String[] args) {
			
Scanner scan = new Scanner(System.in);
//1. StringTokenizer �̿��� ���α׷�	
//	while(true) {
//		System.out.println(">>");
//		String s = scan.nextLine();
//		if(s.equals("�׸�"))
//			break;
//		StringTokenizer st = new StringTokenizer(s, " ");
//		System.out.println("���� ������" +st.countTokens());
//	}
//System.out.println("����");		


//2.split �̿��� ���α׷�
	while(true) {
		System.out.println(">>");
		String s=scan.nextLine();
		if (s.equals("�׸�"))
			break;
		String arr[]=s.split(" ");
		System.out.println("���� ������ "+arr.length);
	}
		System.out.println("����");
	}
}
