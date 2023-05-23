package miniproject;

public class CellPhone extends Product {
	private String  carrier;
	
	public CellPhone(String pname, int price, String carrier) {
		super.pname= pname;
		super.price = price;
		this.carrier = carrier;
	}

	@Override
	public void printExtra() {
		System.out.println("Ελ½Ε»η : " + carrier);
	};
}
