package miniproject_db;

public class CellPhone extends Product {
	private String  mf;
	
	public CellPhone(String pname, int price, String mf) {
		super.pname= pname;
		super.price = price;
		this.mf = mf;
	}

	public String getMf() {
		return mf;
	}

	public void setMf(String mf) {
		this.mf = mf;
	}

	@Override
	public void printExtra() {
		System.out.println("Ελ½Ε»η : " + mf);
	};
}
