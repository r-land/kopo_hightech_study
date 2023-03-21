package chap02;

import java.util.Scanner;

public class Mission3 {

	public static void main(String[] args) {

		Scanner scan = new  Scanner(System.in);
		System.out.print("원화 입력(단위 원) >>");
	    int  won = scan.nextInt();
	 		System.out.println( won + "원은 $" +(double) won/1100  +"입니다");


		System.out.print("2자리 수 정수 입력(10~99) >>");
	    int num = scan.nextInt();
//int num10 = num/10;
//int num1 = num%10;
//	    String msg = (num10 == num1) ?  "yes! 10의 자리와  1의 자리가 같습니다."
//	    	: "no! 10의 자리와  1의 자리가 다릅니다.";
/* 조건문형식 1 (조건) ? 참: 거짓; */	    
	    
	  
	    		String msg;
	    		if (num/10 == num%10)
	    			msg =  "yes! 10의 자리와  1의 자리가 같습니다." ;
	     else  msg = "no! 10의 자리와  1의 자리가 다릅니다.";
	    		System.out.println(msg);

	    		/*조건문형식 2 if(조건) {참실행문}; else {거짓실행문}; */
  	 	    		
	    		
		
		scan.close();

      
	}

}
