package miniproject;

public class SmartTV extends Product {
	private String  resolution;
	
	public SmartTV(String pname, int price, String resolution) {
		super.pname= pname;
		super.price = price;
		this.resolution = resolution;
	}

	@Override
	public void printExtra() {
		System.out.println("�ػ� : " + resolution);
	};
}
