package chap03;

import java.util.Random;
import java.util.Scanner;

public class Mission3 {
//up-down ����
//	����� : 1~99 �Է�  ��ǻ�� :1~99 ����
//����� ��ǻ�� ���� ���߸� ���� ���� 
//����� > ��ǻ�� down ����
//�����<��ǻ�� up ����
//trial = 7ȸ
// ���� : �̰��
// ���н� �õ�Ƚ�� ��� !! �����ߴ� !!

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		
		//1. ��ǻ�� �� ����
		rand.setSeed(System.currentTimeMillis()); //���������˰��� ,��� �и�second ����
		System.out.println(System.currentTimeMillis());
		int com = 1 + rand.nextInt(99);
		
     //4. ���Ӽ��� ��� 
		final int try_number = 7; // �ִ�õ�Ƚ��, ��� �ʱ�ȭ �ƴϸ� ����Ұ�
		int count = 0; //�õ�Ƚ���� ���� ī��Ʈ
		boolean state = true; // ���°� �������� ���� ��������
			
		//3. �ݺ��Ѵ�(try_number Ƚ������, �����Ҷ�����)
		while (true) {
			//5. ���� Ż������
			count++;
			if (count > try_number) {
				state = false;
				break; 			}
		
						//2. ������ �Ѵ�
						System.out.println(" 1~99 �Է� >>");
						int user = scan.nextInt(); //1~99
			
						if (user >com)
							System.out.println("�ٿ�!");
						else if (user <com)
							System.out.println("��!");
						else 	{System.out.println("����!");
                                    break;} //5.������ Ż������
			}
		//6.��������
		System.out.println("===================================");
		if (state) 			System.out.println("�¸�!");
		else 			System.out.println("�õ�Ƚ��" + (count-1) + "�� ����!");
		scan.close();
	}
}