package chap02;

import java.util.Scanner;

public class Mission9 {
// swich문

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		 System.out.print("월(1~12) >>");
		 int month = scan.nextInt();
		 int days =0;  
		  //초기화시킨다 0값으로
		 // 변수인지 인식못할까봐 
		 switch (month) {
		case 2:
			days = 28;
			break;
		case 4:	case 6: case 9:	case 11:
			days = 30;
			break;
		default:
			days =31;
			break;
		}
System.out.println(month + "월은" + days +  "입니다.");
scan.close();
	}

}
