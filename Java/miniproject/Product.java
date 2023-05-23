package miniproject;

public abstract class Product {
	 String pname;
	 int price;
	
	public void printDefault() {
		System.out.println("상품명 : "+ pname + ",");
		System.out.println("상품가격 : "+ price + ",");
		printExtra();
	}
	
	public abstract void printExtra();
	
	
}
