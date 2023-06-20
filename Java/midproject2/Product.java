package midproject2;

//상품정보 테이블 데이터 표현을 위한 클래스
public class Product {
	
	// 컬럼정보에 따른 필드 선언
	private int pcode;
	private String pname;
	private int price;
	private String manufacture;
	
	// Getter/Setter 메서드
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	@Override
	public String toString() {
		return "Product [pcode=" + pcode + ", pname=" + pname + ", price=" + price + ", manufacture=" + manufacture
				+ "]";
	}
}