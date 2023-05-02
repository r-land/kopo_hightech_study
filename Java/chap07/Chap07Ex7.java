package chap07;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Chap07Ex7 {

	public static void main(String[] args) {
		HashMap<String, Double> h = new HashMap<String, Double>();
		Scanner scan = new Scanner(System.in);
		StringTokenizer st;

		
		System.out.println("미래 장학금 관리 시스템입니다.");
		for(int i=0; i<5; i++) {
			System.out.println("이름과 학점 >>");
			st = new StringTokenizer(scan.nextLine(), " ");
			while(st.hasMoreTokens()) {
				String key = st.nextToken().trim();
				double value = Double.parseDouble(st.nextToken().trim());
				h.put(key,value);
			}
				
	}

		
		System.out.println("저장된 요소의 개수 : " + h.size());
		for(String ss : h.keySet())
			System.out.println(h.get(ss));
		System.out.println("-".repeat(30));
		
		System.out.println("장학생 선발 학점 기준 입력 >> ");
		Double cutline = scan.nextDouble();
		for(String sss : h.keySet())
			if(h.get(sss)>=cutline) System.out.println(sss); 
		
		
		System.out.println("장학생 선발 학점 기준 입력 >> ");
		Double cut_line = scan.nextDouble();
		Set<String> set = h.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String name = it.next();
			Double score = h.get(name);
			if(score >=cut_line) System.out.println(name);
		}
		
		Collection<Double> c = h.values();
		Iterator<Double> itt = c.iterator();
		while(it.hasNext())
			System.out.println(itt.next());
		//values값으로 iterator 사용할때 형식
		}
}

