package miniproject_db;

public abstract class Product {
	 int pcode;
	 String pname;
	 int price;
	
	public int getPcode() {
		return pcode;
	}

	public void setPcode(int pcode) {
		this.pcode = pcode;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	

	public void printDefault() {
		System.out.println("��ǰ�ڵ� : "+ pcode + ",");
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
