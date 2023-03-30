package chap03;

import java.util.Random;
import java.util.Scanner;

public class Mission_spacial {

	public static void main(String[] args) {
		String hightech[] = {"김여원", "김정현", "김준성", "김초봄", "박규리", "박민규",
		"박슬기", "박주연", "박지원", "심소영", "오연경", "윤진수", "이성진", "이유진",
		"이태형", "전병남", "정성호", "정승복", "정웅기", "조아름", "최지현"};
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		System.out.print("오늘의 주인공은 누구 ? 몇명인지 입력하세요>> ");
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
