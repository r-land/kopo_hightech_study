package chap02;

import java.util.Scanner;

public class Mission4 {
//�������� ����
		public static void main(String[] args) {
	       Scanner sc = new Scanner(System.in);
        	        int[] arr = {10000, 5000, 1000, 500, 100};

	         System.out.print("�ѱݾ� �Է� : ");
	        int price = sc.nextInt();

	         for(int i=0; i<arr.length; i++) {
	            if(price/arr[i] > 0) {
	                System.out.println(arr[i]+"�� : "+price/arr[i]+" �� ");
	                price%=arr[i];

	    		sc.close();
	        	}
	        }
	
		}
}




	

	
	


