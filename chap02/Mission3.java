package chap02;

import java.util.Scanner;

public class Mission3 {

	public static void main(String[] args) {

		Scanner scan = new  Scanner(System.in);
		System.out.print("��ȭ �Է�(���� ��) >>");
	    int  won = scan.nextInt();
	 		System.out.println( won + "���� $" +(double) won/1100  +"�Դϴ�");


		System.out.print("2�ڸ� �� ���� �Է�(10~99) >>");
	    int num = scan.nextInt();
//int num10 = num/10;
//int num1 = num%10;
//	    String msg = (num10 == num1) ?  "yes! 10�� �ڸ���  1�� �ڸ��� �����ϴ�."
//	    	: "no! 10�� �ڸ���  1�� �ڸ��� �ٸ��ϴ�.";
/* ���ǹ����� 1 (����) ? ��: ����; */	    
	    
	  
	    		String msg;
	    		if (num/10 == num%10)
	    			msg =  "yes! 10�� �ڸ���  1�� �ڸ��� �����ϴ�." ;
	     else  msg = "no! 10�� �ڸ���  1�� �ڸ��� �ٸ��ϴ�.";
	    		System.out.println(msg);

	    		/*���ǹ����� 2 if(����) {�����๮}; else {�������๮}; */
  	 	    		
	    		
		
		scan.close();

      
	}

}
