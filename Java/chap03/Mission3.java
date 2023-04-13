package chap03;

import java.util.Random;
import java.util.Scanner;

public class Mission3 {
//up-down 게임
//	사용자 : 1~99 입력  컴퓨터 :1~99 생성
//사용자 컴퓨터 값을 맞추면 게임 성공 
//사용자 > 컴퓨터 down 시켜
//사용자<컴퓨터 up 시켜
//trial = 7회
// 성공 : 이겼다
// 실패시 시도횟수 출력 !! 실패했다 !!

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		
		//1. 컴퓨터 값 생성
		rand.setSeed(System.currentTimeMillis()); //난수생성알고리즘 ,계수 밀리second 단위
		System.out.println(System.currentTimeMillis());
		int com = 1 + rand.nextInt(99);
		
     //4. 게임세팅 양념 
		final int try_number = 7; // 최대시도횟수, 상수 초기화 아니면 변경불가
		int count = 0; //시도횟수를 위한 카운트
		boolean state = true; // 상태가 성공임을 가정 상태점검
			
		//3. 반복한다(try_number 횟수까지, 성공할때까지)
		while (true) {
			//5. 실패 탈출조건
			count++;
			if (count > try_number) {
				state = false;
				break; 			}
		
						//2. 게임을 한다
						System.out.println(" 1~99 입력 >>");
						int user = scan.nextInt(); //1~99
			
						if (user >com)
							System.out.println("다운!");
						else if (user <com)
							System.out.println("업!");
						else 	{System.out.println("성공!");
                                    break;} //5.성공시 탈출조건
			}
		//6.게임종료
		System.out.println("===================================");
		if (state) 			System.out.println("승리!");
		else 			System.out.println("시도횟수" + (count-1) + "번 실패!");
		scan.close();
	}
}