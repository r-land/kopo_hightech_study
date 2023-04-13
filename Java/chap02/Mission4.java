package chap02;

import java.util.Scanner;

public class Mission4 {
//동전개수 문제
		public static void main(String[] args) {
	       Scanner sc = new Scanner(System.in);
        	        int[] arr = {10000, 5000, 1000, 500, 100};

	         System.out.print("총금액 입력 : ");
	        int price = sc.nextInt();

	         for(int i=0; i<arr.length; i++) {
	            if(price/arr[i] > 0) {
	                System.out.println(arr[i]+"원 : "+price/arr[i]+" 개 ");
	                price%=arr[i];

	    		sc.close();
	        	}
	        }
	
		}
}




	

	
	


