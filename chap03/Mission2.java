package chap03;

import java.util.Random;
import java.util.Scanner;

public class Mission2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Random rand = new Random();
		int count = 0;
		final int try_number = 10; // ���
		boolean state = true; // ���°� �������� ���� ��������

		while (true) {
			count++;
			if (count > try_number) {
				state = false;
				break;
			}

			rand.setSeed(System.currentTimeMillis()); //���������˰��� ,��� �и�second ����
			System.out.println(System.currentTimeMillis());
			int com = 1 + rand.nextInt(3);

			System.out.println(" ����(1), ����(2), ��(3) >>");
			int user = scan.nextInt();

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
			else {
				System.out.println("���� ��!");
				break;
				// �̱�� Ż��
			}
		}
		System.out.println("===================================");
		if (state)
			System.out.println("�¸�!");
		else
			System.out.println("�õ� ȸ�� �ʰ�!");
		scan.close();
	}

}
