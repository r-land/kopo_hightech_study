package miniproject;

public abstract class Product {
	 String pname;
	 int price;
	
	public void printDefault() {
		System.out.println("��ǰ�� : "+ pname + ",");
		System.out.println("��ǰ���� : "+ price + ",");
		printExtra();
	}
	
	public abstract void printExtra();
	
	
}
