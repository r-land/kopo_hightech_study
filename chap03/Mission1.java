package chap03;

import java.util.Scanner;
//while �ݺ���
public class Mission1 {

	public static void main(String[] args) {
Scanner sc =new Scanner(System.in);

//  1. while �� ��� 
System.out.println("�������� >>");
int toeic = sc.nextInt();

while(true) {//���ѹݺ�
	if(toeic>700) break;
	System.out.println("���θ� �ϼ���!");
	System.out.println("������ ������!");
	System.out.println("�������� >>");
	toeic = sc.nextInt();
	}
System.out.println("���� Ż��!!");

sc.close();

	}

}
