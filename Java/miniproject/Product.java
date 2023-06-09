package miniproject;

public abstract class Product {
	 String pname;
	 int price;
	
	public void printDefault() {
		System.out.println("��ǰ�� : "+ pname + ",");
		System.out.println("��ǰ���� : "+ price + ",");
		printExtra();
	}
	
	@Override
	public String toString() {
		return pname + "(" +  price + ")";
	}
		
	public int getPrice() {
		return price;
	}

	public abstract void printExtra();
	
	
}