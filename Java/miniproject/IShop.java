package miniproject;

public interface IShop {
	
//	setTitle : 쇼핑몰 제목 달기
//===========================================
	public abstract void setTitle(String title);
	
//	genUser : 사용자 정보 등록하기
//===========================================

	public abstract void genUser();
	
//	genProduct : 상품정보 등록하기
//===========================================
	public abstract void getProduct();
	
//	start : 쇼핑몰 전체기능을 위한 시나리오 넣기 
//===========================================
	public abstract void start();
}
