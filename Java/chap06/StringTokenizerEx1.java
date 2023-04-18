package chap06;

import java.util.StringTokenizer;

public class StringTokenizerEx1 {

	public static void main(String[] args) {
		String data = "ȫ�浿,��,65,170/�����,��,57,164/���屺,��,80,190/����,��,77,667/ȫ�̿�,��,64,165";
		StringTokenizer st = new StringTokenizer(data, "/");
		int sum = 0;
		int count =0;
		
				
		while(st.hasMoreTokens()) {
			StringTokenizer st1 = new StringTokenizer(st.nextToken(), ",");
			while(st1.hasMoreTokens()) {
				if(st1.nextToken().equals("��"))
				{
					count++;
					sum+=Integer.parseInt(st1.nextToken());
				}
				
			}
			
			}
		System.out.println("���ڵ��� ��� ü�� :" + ((double)sum/count));
		}

	}
