package chap06;

import java.util.StringTokenizer;

public class StringTokenizerEx1 {

	public static void main(String[] args) {
		String data = "홍길동,남,65,170/김새영,여,57,164/이장군,남,80,190/김명수,남,77,667/홍미용,여,64,165";
		StringTokenizer st = new StringTokenizer(data, "/");
		int sum = 0;
		int count =0;
		
				
		while(st.hasMoreTokens()) {
			StringTokenizer st1 = new StringTokenizer(st.nextToken(), ",");
			while(st1.hasMoreTokens()) {
				if(st1.nextToken().equals("남"))
				{
					count++;
					sum+=Integer.parseInt(st1.nextToken());
				}
				
			}
			
			}
		System.out.println("남자들의 평균 체중 :" + ((double)sum/count));
		}

	}
