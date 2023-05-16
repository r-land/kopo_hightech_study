package chap08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BufferedReaderEx {

	public static void main(String[] args) throws IOException {
		File f = new File("C:\\\\javaex\\\\phone.txt");
		
		InputStreamReader is = new InputStreamReader(new FileInputStream(f), "UTF-8");
		
		BufferedReader reader = new BufferedReader(is);
		String line;
		StringTokenizer st;
		HashMap<String, String> map = new HashMap<String, String>();
	
		
		while(!(line = reader.readLine()).equals("q")) {
			map = new HashMap<String, String>();
			st = new StringTokenizer(line, " ");
			while(st.hasMoreTokens()) {
				map.put(st.nextToken(), st.nextToken());
			}
	
	
		}
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("이름>>");
			String name = scan.next();
			if(name.equals("exit")) break;
			System.out.println("전화번호 :" +map.get(name));
		}
		System.out.println("전화번호 검색을 종료합니다...");
		reader.close();
		scan.close();
		}
		
		
		
	}
	


