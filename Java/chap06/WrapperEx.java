package chap06;

public class WrapperEx {

	public static void main(String[] args) {
//		Integer i =new Interger(10); //�ڽ�
		Integer i = 10; //����ڽ�
		Integer i1 = new Integer("10");
		
		System.out.println(i);
		System.out.println(i1);
		
		char c1 = '4';
		char c2 = '4';
		if(Character.isDigit(c1)) System.out.println("c1�� ����");
		if(Character.isAlphabetic(c2)) System.out.println("c2�� ���ĺ�");
		
		
		
		
	}
}
