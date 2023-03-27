package chap02;

import java.util.Scanner;

public class Mission5 {

	public static void main(String[] args) {

		Scanner scan = new  Scanner(System.in);
		System.out.print("키 입력 >>");
	    int  height = scan.nextInt();
		System.out.print("나이 입력 >>");
	    int  age = scan.nextInt();
	    
	    if (height>=140 && age>=10)
	   System.out.println("타도 좋아요!");
	    else
	    System.out.println("타면 안되요!");
    
			scan.close();
	}


}
