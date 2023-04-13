package chap02;

import java.util.Random;
import java.util.Scanner;

public class Mission10_1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("가위바위보 게임입니다. 가위(1), 바위(2), 보(3) 중에 입력하세요");
		int user = scan.nextInt();
		
		Random rand = new Random();
		int com = 1 + rand.nextInt(3);
		
		if (user == 1)
			System.out.println("유저 : 가위");
		else if (user == 2)
			System.out.println("유저 :바위");
		else
			System.out.println("유저 :보");

		if (com == 1)
			System.out.println("컴퓨터 : 가위");
		else if (com == 2)
			System.out.println("컴퓨터 :바위");
		else
			System.out.println("컴퓨터:보");

		int result = user - com;
		if (result == 0)
			System.out.println("무승부!");
		else if (result == -1 || result == 2)
			System.out.println("컴퓨터승!");
		else
			System.out.println("유저 승!");
scan.close();
	}
 
}
