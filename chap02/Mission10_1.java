package chap02;

import java.util.Random;
import java.util.Scanner;

public class Mission10_1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("���������� �����Դϴ�. ����(1), ����(2), ��(3) �߿� �Է��ϼ���");
		int user = scan.nextInt();
		
		Random rand = new Random();
		int com = 1 + rand.nextInt(3);
		
		if (user == 1)
			System.out.println("���� : ����");
		else if (user == 2)
			System.out.println("���� :����");
		else
			System.out.println("���� :��");

		if (com == 1)
			System.out.println("��ǻ�� : ����");
		else if (com == 2)
			System.out.println("��ǻ�� :����");
		else
			System.out.println("��ǻ��:��");

		int result = user - com;
		if (result == 0)
			System.out.println("���º�!");
		else if (result == -1 || result == 2)
			System.out.println("��ǻ�ͽ�!");
		else
			System.out.println("���� ��!");
scan.close();
	}
 
}
