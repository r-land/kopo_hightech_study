package chap07;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapEx {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		HashMap<String, String> dic = new HashMap<String, String>();
		
		dic.put("apple", "���");
		dic.put("banana", "�ٳ���");
		dic.put("grape", "����");
		dic.put("peach", "������");
		dic.put("orange", "������");
		dic.put("melon", "���");
		
		
		while(true) {
		System.out.println("ã����� �ܾ� : ");
		String key = scan.next();
		if(key.equals("exit")) {
			System.out.println("�����մϴ�");
			break;
		}
		System.out.println(dic.get(key));
		}
	}

}
