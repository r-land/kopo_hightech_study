package chap03;

import java.util.Random;
import java.util.Scanner;

public class Mission_spacial {

	public static void main(String[] args) {
		String hightech[] = {"�迩��", "������", "���ؼ�", "���ʺ�", "�ڱԸ�", "�ڹα�",
		"�ڽ���", "���ֿ�", "������", "�ɼҿ�", "������", "������", "�̼���", "������",
		"������", "������", "����ȣ", "���º�", "������", "���Ƹ�", "������"};
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		System.out.print("������ ���ΰ��� ���� ? ������� �Է��ϼ���>> ");
		int pick = scan.nextInt();

		int picks[] = new int[pick];
		for (int i=0; i < picks.length; i++) {
			picks[i] = rand.nextInt(21);
			 for(int j =0; j<i; j++)
			
			 { 	 if(picks[i] == picks[j])  i--;  }				
		}
			for (int b=0; b <21; b++)
			{System.out.print(hightech[picks[b]]+" ");}
						scan.close();
	}

}
