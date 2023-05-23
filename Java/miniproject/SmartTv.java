package miniproject;

public class SmartTv extends Product {
	private String  resolution;
	
	public SmartTv(String pname, int price, String resolution) {
		super.pname= pname;
		super.price = price;
		this.resolution = resolution;
	}

	@Override
	public void printExtra() {
		System.out.println("ÇØ»óµµ : " + resolution);
	};
}
