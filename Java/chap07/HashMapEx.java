package chap07;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapEx {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		HashMap<String, String> dic = new HashMap<String, String>();
		
		dic.put("apple", "사과");
		dic.put("banana", "바나나");
		dic.put("grape", "포도");
		dic.put("peach", "복숭아");
		dic.put("orange", "오렌지");
		dic.put("melon", "멜론");
		
		
		while(true) {
		System.out.println("찾고싶은 단어 : ");
		String key = scan.next();
		if(key.equals("exit")) {
			System.out.println("종료합니다");
			break;
		}
		System.out.println(dic.get(key));
		}
	}

}
