package chap08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
 
public class p0810 {
 
	public static void main(String[] args) {
		File f=null;
		HashMap<String,String> phone;
		Scanner sc;
		try {
			phone=new HashMap<String,String>();
			f=new File("c:\\javaex\\phone.txt");
			InputStreamReader is = new InputStreamReader(new FileInputStream(f), "UTF-8");
			
			BufferedReader reader = new BufferedReader(is);
	
			sc=new Scanner(reader);
			int i = 0;
			while(sc.hasNext()) {
				i++;
				String n=sc.next();
				String t=sc.next();
				phone.put(n,t);
				System.out.println("이름 : "+n+" 전화번호 : "+phone.get(n));
			}
			System.out.println("총 "+phone.size()+"개의 정보를 읽었습니다.");
			sc.close();
			sc=new Scanner(System.in);
			String temp="";
			while(true) {
				System.out.print("이름>>");
				temp=sc.next();
				System.out.println(temp);
				if(temp.equals("그만")) {
					break;
				}
				String tel=phone.get(temp);
				if(tel==null) {
					System.out.println("찾는 이름이 없습니다.");
				}
				else {
					System.out.println(tel);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
 
}