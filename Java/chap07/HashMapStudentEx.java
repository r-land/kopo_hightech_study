package chap07;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapStudentEx {

	public static void main(String[] args) {
		HashMap<String, Student3> map = new HashMap<>();
		
		map.put("황기태", new Student3(1,"010-111-1111"));
		map.put("이재문", new Student3(2,"010-222-2222"));
		map.put("김남윤", new Student3(3,"010-333-3333"));
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.print("검색할 이름?");
			String name = scan.nextLine();
			if(name.equals("exit")) break;
			System.out.println(map.get(name));
			
		}
	}

}
