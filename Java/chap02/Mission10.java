package chap02;

import java.util.Random;
import java.util.Scanner;

public class Mission10 {
//가위바위보게임 user 1,2,3 -가위바위보 COM 은 랜덤

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("가위바위보 게임입니다. 가위(1), 바위(2), 보(3) 중에 입력하세요");
		int user = scan.nextInt();
		System.out.println("user>>" + user);

		Random rand = new Random();
		int com = 1 + rand.nextInt(3);
		System.out.println("com>>" + com);
		/*
		 * int 가위 = 1 ; int 바위 = 2 ; int 보 = 3;
		 */

		switch (user) {
		case 1:
			switch (com) {
			case 1:
				System.out.println("동승입니다");
				break;
			case 2:
				System.out.println(" 졌어요ㅜㅜ");
				break;
			case 3:
				System.out.println(" 이겼습니다^^");
				break;
			}
			break;

		case 2:
			switch (com) {
			case 1:
				System.out.println("이겼습니다^^");
				break;
			case 2:
				System.out.println(" 동승입니다");
				break;
			case 3:
				System.out.println(" 졌습니다 ㅠㅠ");
				break;
			}
			break;

		case 3:
			switch (com) {
			case 1:
				System.out.println("졌습니다ㅠㅠ");
				break;
			case 2:
				System.out.println("이겼습니다^^");
				break;
			case 3:
				System.out.println(" 동승입니다");
				break;
			}
			break;
		default:
			System.out.println("다시한번더!");
		}
		scan.close();
	}
}

//1)Math.random() 메소드 활용해서 난수 생성
//int com = (int)(1+Math.random(*3)); //1~3사이의 난수
//2)Random() 클래스의 nextInt, nextDouble....
