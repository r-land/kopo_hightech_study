package chap03;

import java.util.Scanner;

public class Mission6 {
//3,6,9 ���Ӹ����
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1~99������ ������ �Է�>>");
		int i= sc.nextInt();
		//�Է°� 
		int crap = 0;
		if(i/10==3 || i/10==6 || i/10==9) //���� �ڸ� 369
			crap++;
		if(i%10==3 || i%10==3 || i%10==9) //�����ڸ� 369
			crap++;
	    //�ڼ��� 
		if(crap == 0) 
			System.out.println(i);
		else {System.out.print("�ڼ�");
					if(crap == 1)  System.out.println("¦");
					else System.out.println("¦¦");	}
		//369���α׷� ���
			sc.close();
	}

}
