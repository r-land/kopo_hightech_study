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
		System.out.println("상품코드 : "+ pcode + ",");
		System.out.println("상품명 : "+ pname + ",");
		System.out.println("상품가격 : "+ price + ",");
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
