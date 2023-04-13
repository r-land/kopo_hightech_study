package chap03;

public class Mission15 {

public static void main(String[] args) {
//	try { System.out.println(3/0);
//}
//	catch(ArithmeticException e) {
//		e.printStackTrace();
//		System.out.println("0으로 나눌수 없음!");

String[] stringNumber = {"23", "12", "3.141592", "998"};

int i =0;
try {for(i=0; i<stringNumber.length;i++) {
	int j=Integer.parseInt(stringNumber[i]);
	System.out.println("숫자로 변환된 값은"+j);
}
		}
catch(NumberFormatException e) {
	System.out.println(stringNumber[i]+"는 정수로 변환할수 없습니다.");
}
	}
	
}
