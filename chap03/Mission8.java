package chap03;

import java.util.Scanner;

public class Mission8 {

	public static void main(String[] args) {

      // �Է¼��� ��ձ��ϱ�
		int count =0;
		int sum =0 ;// �Է°��� ���� 
		double avg = 0.0; //���
		
		Scanner sc = new Scanner(System.in);
		System.out.println("���ڵ��Է��ϼ��� �������� -1>");
		int num = sc.nextInt();
		
		while(num !=-1) {
		sum += num;
		count ++; 
		num = sc.nextInt();
		}
		
		if(count>0)
		{System.out.println("���� ���� :" + count);		
		avg =(double)sum/count;
		System.out.println("�Էµ� ������ �����" + avg +"�Դϴ�");
		}
		else System.out.println();
		sc.close();
	}}

