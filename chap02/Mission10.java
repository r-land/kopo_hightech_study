package chap02;

import java.util.Random;
import java.util.Scanner;

public class Mission10 {
//�������������� user 1,2,3 -���������� COM �� ����

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("���������� �����Դϴ�. ����(1), ����(2), ��(3) �߿� �Է��ϼ���");
		int user = scan.nextInt();
		System.out.println("user>>" + user);

		Random rand = new Random();
		int com = 1 + rand.nextInt(3);
		System.out.println("com>>" + com);
		/*
		 * int ���� = 1 ; int ���� = 2 ; int �� = 3;
		 */

		switch (user) {
		case 1:
			switch (com) {
			case 1:
				System.out.println("�����Դϴ�");
				break;
			case 2:
				System.out.println(" �����̤�");
				break;
			case 3:
				System.out.println(" �̰���ϴ�^^");
				break;
			}
			break;

		case 2:
			switch (com) {
			case 1:
				System.out.println("�̰���ϴ�^^");
				break;
			case 2:
				System.out.println(" �����Դϴ�");
				break;
			case 3:
				System.out.println(" �����ϴ� �Ф�");
				break;
			}
			break;

		case 3:
			switch (com) {
			case 1:
				System.out.println("�����ϴ٤Ф�");
				break;
			case 2:
				System.out.println("�̰���ϴ�^^");
				break;
			case 3:
				System.out.println(" �����Դϴ�");
				break;
			}
			break;
		default:
			System.out.println("�ٽ��ѹ���!");
		}
		scan.close();
	}
}

//1)Math.random() �޼ҵ� Ȱ���ؼ� ���� ����
//int com = (int)(1+Math.random(*3)); //1~3������ ����
//2)Random() Ŭ������ nextInt, nextDouble....
