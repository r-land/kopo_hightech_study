package chap03;

public class Mission4 {

	public static void main(String[] args) {
		/*
		 * 1. while 문 활용 : 1~10 까지 수를 합산하여 결과값(sum)을 출력하시오. 누적합 프로그램
		 * 
		 *  int num = 1; 
		 *  int sum = 0; //누적합(초기화는 항상 0)
		 *  while(num<=10) { sum += num; num++; }
		 * System.out.println("sum = " + sum);
		 */

/*		// 2. Do-while
		int num = 1;
		int sum = 0; // 누적합(초기화는 항상 0)
		do {
			sum += num;
			num++;
		} while (num <= 10);
		System.out.println("sum = " + sum);*/

		/*
		 * 3.for문 활용 횟수 정해진 경우
		 * 
		 *  int sum = 0; 
		 *  for(int num=1; num<=10; num++) 
		 *  sum+= num;
		 * System.out.println("sum = " + sum);
		 */
		
		//4.1~100수 중에  13 배수만  합
		int sum = 0;
		 for(int num=1; num<=100; num++)
			 		if(num%3==0) sum+=num;
		 System.out.println("sum = " + sum);
		 
		 //5. 1~100수 중에서 13 배수 전까지만  합
		  for(int num=1; num<=100; num++) { 
			 if(num%13==0) break ; 
				 sum +=num;}
		 System.out.println("sum = " + sum);
		 
		 //6.1~100수 중에서 13배수 제외하고 합
		 for(int num=1; num<=100; num++) {
			 if(num%13==0) continue;
			 		sum+=num; }
		 System.out.println("sum = " + sum);
 }
	}


