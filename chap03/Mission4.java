package chap03;

public class Mission4 {

	public static void main(String[] args) {
		/*
		 * 1. while �� Ȱ�� : 1~10 ���� ���� �ջ��Ͽ� �����(sum)�� ����Ͻÿ�. ������ ���α׷�
		 * 
		 *  int num = 1; 
		 *  int sum = 0; //������(�ʱ�ȭ�� �׻� 0)
		 *  while(num<=10) { sum += num; num++; }
		 * System.out.println("sum = " + sum);
		 */

/*		// 2. Do-while
		int num = 1;
		int sum = 0; // ������(�ʱ�ȭ�� �׻� 0)
		do {
			sum += num;
			num++;
		} while (num <= 10);
		System.out.println("sum = " + sum);*/

		/*
		 * 3.for�� Ȱ�� Ƚ�� ������ ���
		 * 
		 *  int sum = 0; 
		 *  for(int num=1; num<=10; num++) 
		 *  sum+= num;
		 * System.out.println("sum = " + sum);
		 */
		
		//4.1~100�� �߿�  13 �����  ��
		int sum = 0;
		 for(int num=1; num<=100; num++)
			 		if(num%3==0) sum+=num;
		 System.out.println("sum = " + sum);
		 
		 //5. 1~100�� �߿��� 13 ��� ��������  ��
		  for(int num=1; num<=100; num++) { 
			 if(num%13==0) break ; 
				 sum +=num;}
		 System.out.println("sum = " + sum);
		 
		 //6.1~100�� �߿��� 13��� �����ϰ� ��
		 for(int num=1; num<=100; num++) {
			 if(num%13==0) continue;
			 		sum+=num; }
		 System.out.println("sum = " + sum);
 }
	}


