package chap03;

public class Mission15 {

public static void main(String[] args) {
//	try { System.out.println(3/0);
//}
//	catch(ArithmeticException e) {
//		e.printStackTrace();
//		System.out.println("0���� ������ ����!");

String[] stringNumber = {"23", "12", "3.141592", "998"};

int i =0;
try {for(i=0; i<stringNumber.length;i++) {
	int j=Integer.parseInt(stringNumber[i]);
	System.out.println("���ڷ� ��ȯ�� ����"+j);
}
		}
catch(NumberFormatException e) {
	System.out.println(stringNumber[i]+"�� ������ ��ȯ�Ҽ� �����ϴ�.");
}
	}
	
}
