package chap02;

import java.util.Scanner;

public class Mission9 {
// swich��

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		 System.out.print("��(1~12) >>");
		 int month = scan.nextInt();
		 int days =0;  
		  //�ʱ�ȭ��Ų�� 0������
		 // �������� �νĸ��ұ�� 
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
System.out.println(month + "����" + days +  "�Դϴ�.");
scan.close();
	}

}
