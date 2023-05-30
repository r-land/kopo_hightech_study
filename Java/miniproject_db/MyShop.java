package miniproject_db;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MyShop implements IShop{
	//쇼핑몰 프로그램을 위한 필드구성
	
	//등록 사용자 정보 배열
	User[] users = new User[2];
	//등록 상품 정보 배열
	Product[] products = new Product[4];
	//상품 정보를 추가할 수 있는 장바구니
	ArrayList<Product> cart = new ArrayList<>();
	
	Scanner scan = new Scanner(System.in);
	
	/*todo : 추가적으로 필요할 필드
	*====================================== */
	String title;		//쇼핑몰 이름
	int sel_user;		//선택된 사용자 인덱스
	int sum; 			//장바구니 가격 합계
	
	/* setTitle : 쇼핑몰의 제목 달기
	 *====================================== */
	@Override
	public void setTitle(String title) {this.title = title;}
	
	/* genUser : 사용자정보를 등록하기 (? 컬렉션 사용, db 사용도 생각해보기)
	 *====================================== */
	@Override
	public void genUser() {
		User user = new User("홍길동", PayType.CARD);
		users[0] =user;
		user = new User("엄남경", PayType.CASH);
		users[1] = user;
		
	}
	
	/* genProduct : 상품정보를 등록하기
	 *====================================== */
	@Override
	public void genProduct() {
		//cellphone 등록
		CellPhone cell = new CellPhone("갤럭시노트20", 1500000, "SKT");
		products[0] = cell;
		cell = new CellPhone("애플아이폰14", 1000000, "KT");
		products[1] = cell;
		//smartTv 등록
		SmartTV tv = new SmartTV("삼성3DSmartTV", 3000000, "4K");
		products[2] = tv;
		tv = new SmartTV("LG SmartTV", 2000000, "FullHD" );
		products[3] = tv;
		
	}
	
	/* start : 쇼핑몰의 전체기능을 위한 시나리오 넣기
	 *====================================== */
	@Override
	public void start() {
		System.out.println("=".repeat(30));
		System.out.println(title + ": 메인 화면 - 계정 선택 >>");
		System.out.println("=".repeat(30));
		//1. 사용자 정보 출력
		int index = 0;
		for(User u : users) {
			System.out.println("["+ index++ + "] ");
			System.out.println(u.toString());
		}
		System.out.println("[x] 종료 "); //system.exit(0) 호출 -프로그램 종료
		System.out.print("선택 : ");
		
		String select = scan.next(); //선택 : x 종료
		try {
			switch(select) {
			case "x" : 
			System.out.println("쇼핑몰 프로그램이 종료됩니다");
			System.exit(0); break; 	  //메인으로
			default : 
			//1. select 값을 int 형으로 바꾸고
			sel_user = Integer.parseInt(select);
			System.out.println(users[sel_user].getName() + " 님 즐거운 쇼핑^^");
			productList();
			}
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("계정을 다시 확인해주세요!");
			run();		
		}
		
	}
	
	/* productList : 상품정보 출력하기
	 *====================================== */
	public void productList() {
		System.out.println("=".repeat(30));
		System.out.println(title + ": 상품 목록 - 상품 선택 >>");
		System.out.println("=".repeat(30));
		
		int index = 0;
		for(Product p : products) {
			System.out.println("["+ index++ + "] ");
			p.printDefault();
		}
		System.out.println("[h] 메인화면 "); //start 메인화면 메소드
		System.out.println("[c] 체크아웃 "); //checkout 메소드
		System.out.println("선택 : ");

		String select = scan.next(); //선택 : h,c, 상품index
	try {	
		switch(select) {
		case "h" : start(); break; 	  //메인으로
		case "c" : checkOut(); break; //체크아웃으로
		default : 
			//1. select 값을 int 형으로 바꾸고
			//2. int로 바뀐 select 값의 인덱스에 대한 products정보를
			//3. cart에 add 시킨다.
			cart.add(products[Integer.parseInt(select)]);
			System.out.println("쇼핑 계속~");
			productList();}
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("상품번호를 다시 확인해주세요!");
			productList();
		}	
	}
	
	
	/* checkOut : 체크아웃 후 결제하기
	 *====================================== */
	public void checkOut() {
		System.out.println("=".repeat(30));
		System.out.println(title + ": 체크 아웃 하기 >>");
		System.out.println("=".repeat(30));
		
		int index = 0;
		for(Product p : cart) {
			System.out.println("["+ index++ + "] ");
			System.out.println(p.toString());
			System.out.println();
			sum += p.getPrice();
			
		}	
		
		// 결제방법 합계 출력
		System.out.println("=".repeat(30));
		System.out.println("사용자명 : " + users[sel_user].getName());
		System.out.println("결제방법 : " + users[sel_user].getPaytype());
		System.out.println("=".repeat(30));
		System.out.println("계산금액 : " + sum);
		System.out.println("[p] 이전, [q] 결제 완료;");
		System.out.print("선택 : ");

		// 선택
		String select = scan.next(); //선택 : p,q 
		switch(select) {
		case "p" : productList(); break; 	  //상품목록 화면 
		case "q" : 
			System.out.println("결제완료~ 감사합니다^^");
			System.exit(0);
			 break; //종료
		default : 
			checkOut();

		}
	}
	//프로그램 시나리오에 따라 초기화하고 시작한다.
	public void run() {
		setTitle("알네 쇼핑몰");
		genUser();
		genProduct();
		start();
	}
	
	public static void main(String args[]) {
		MyShop shop = new MyShop();
		shop.run();
				
	}

}