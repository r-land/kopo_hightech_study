package chap02;

import java.util.Scanner;

public class Mission6 {

	public static void main(String[] args) {

		Scanner scan = new  Scanner(System.in);
		System.out.print("성적 입력 >>");
	    int  score = scan.nextInt();
	   char grade ;
	    
	    if (score>=90)  grade = 'A';
	    else		if (score>=80)  grade = 'B';
	    else		if (score>=70)  grade = 'C';
	    else		if (score>=60)  grade = 'D';
	    else		  grade = 'F';
	 
	        
	    System.out.println("성적은" + grade + "입니다.");
	   
	    
			scan.close();
	}


}
