package chap03;

import java.util.Scanner;

public class Mission9 {

	public static void main(String[] args) {

      // �Է¼��� ��ձ��ϱ�
		int count =0;
		int sum =0 ;// �Է°��� ���� 
		double avg = 0.0; //���
		
		Scanner sc = new Scanner(System.in);
		System.out.println("���ڵ��Է��ϼ��� �������� -1>");
		
	 int num;
		//do -while �� 
	 do{num = sc.nextInt();
		sum += num;
		count ++; 
		}
		while(num !=-1);
	 count = count -1;
		if(count>0)
		{System.out.println("���� ���� :" + count);		
		avg =(double)sum/count;
		System.out.printf("�Էµ� ������ ����� %.2f", avg );
		}
		else System.out.println();
		sc.close();
	}}

