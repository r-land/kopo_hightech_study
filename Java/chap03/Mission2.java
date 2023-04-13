package chap03;

import java.util.Random;
import java.util.Scanner;

public class Mission2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Random rand = new Random();
		int count = 0;
		final int try_number = 10; // 상수
		boolean state = true; // 상태가 성공임을 가정 상태정검

		while (true) {
			count++;
			if (count > try_number) {
				state = false;
				break;
			}

			rand.setSeed(System.currentTimeMillis()); //난수생성알고리즘 ,계수 밀리second 단위
			System.out.println(System.currentTimeMillis());
			int com = 1 + rand.nextInt(3);

			System.out.println(" 가위(1), 바위(2), 보(3) >>");
			int user = scan.nextInt();

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
			else {
				System.out.println("유저 승!");
				break;
				// 이기면 탈출
			}
		}
		System.out.println("===================================");
		if (state)
			System.out.println("승리!");
		else
			System.out.println("시도 회수 초과!");
		scan.close();
	}

}
