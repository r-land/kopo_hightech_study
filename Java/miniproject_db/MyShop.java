package miniproject_db;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MyShop implements IShop{
	//���θ� ���α׷��� ���� �ʵ屸��
	
	//��� ����� ���� �迭
	User[] users = new User[2];
	//��� ��ǰ ���� �迭
	Product[] products = new Product[4];
	//��ǰ ������ �߰��� �� �ִ� ��ٱ���
	ArrayList<Product> cart = new ArrayList<>();
	
	Scanner scan = new Scanner(System.in);
	
	/*todo : �߰������� �ʿ��� �ʵ�
	*====================================== */
	String title;		//���θ� �̸�
	int sel_user;		//���õ� ����� �ε���
	int sum; 			//��ٱ��� ���� �հ�
	
	/* setTitle : ���θ��� ���� �ޱ�
	 *====================================== */
	@Override
	public void setTitle(String title) {this.title = title;}
	
	/* genUser : ����������� ����ϱ� (? �÷��� ���, db ��뵵 �����غ���)
	 *====================================== */
	@Override
	public void genUser() {
		User user = new User("ȫ�浿", PayType.CARD);
		users[0] =user;
		user = new User("������", PayType.CASH);
		users[1] = user;
		
	}
	
	/* genProduct : ��ǰ������ ����ϱ�
	 *====================================== */
	@Override
	public void genProduct() {
		//cellphone ���
		CellPhone cell = new CellPhone("�����ó�Ʈ20", 1500000, "SKT");
		products[0] = cell;
		cell = new CellPhone("���þ�����14", 1000000, "KT");
		products[1] = cell;
		//smartTv ���
		SmartTV tv = new SmartTV("�Ｚ3DSmartTV", 3000000, "4K");
		products[2] = tv;
		tv = new SmartTV("LG SmartTV", 2000000, "FullHD" );
		products[3] = tv;
		
	}
	
	/* start : ���θ��� ��ü����� ���� �ó����� �ֱ�
	 *====================================== */
	@Override
	public void start() {
		System.out.println("=".repeat(30));
		System.out.println(title + ": ���� ȭ�� - ���� ���� >>");
		System.out.println("=".repeat(30));
		//1. ����� ���� ���
		int index = 0;
		for(User u : users) {
			System.out.println("["+ index++ + "] ");
			System.out.println(u.toString());
		}
		System.out.println("[x] ���� "); //system.exit(0) ȣ�� -���α׷� ����
		System.out.print("���� : ");
		
		String select = scan.next(); //���� : x ����
		try {
			switch(select) {
			case "x" : 
			System.out.println("���θ� ���α׷��� ����˴ϴ�");
			System.exit(0); break; 	  //��������
			default : 
			//1. select ���� int ������ �ٲٰ�
			sel_user = Integer.parseInt(select);
			System.out.println(users[sel_user].getName() + " �� ��ſ� ����^^");
			productList();
			}
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("������ �ٽ� Ȯ�����ּ���!");
			run();		
		}
		
	}
	
	/* productList : ��ǰ���� ����ϱ�
	 *====================================== */
	public void productList() {
		System.out.println("=".repeat(30));
		System.out.println(title + ": ��ǰ ��� - ��ǰ ���� >>");
		System.out.println("=".repeat(30));
		
		int index = 0;
		for(Product p : products) {
			System.out.println("["+ index++ + "] ");
			p.printDefault();
		}
		System.out.println("[h] ����ȭ�� "); //start ����ȭ�� �޼ҵ�
		System.out.println("[c] üũ�ƿ� "); //checkout �޼ҵ�
		System.out.println("���� : ");

		String select = scan.next(); //���� : h,c, ��ǰindex
	try {	
		switch(select) {
		case "h" : start(); break; 	  //��������
		case "c" : checkOut(); break; //üũ�ƿ�����
		default : 
			//1. select ���� int ������ �ٲٰ�
			//2. int�� �ٲ� select ���� �ε����� ���� products������
			//3. cart�� add ��Ų��.
			cart.add(products[Integer.parseInt(select)]);
			System.out.println("���� ���~");
			productList();}
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("��ǰ��ȣ�� �ٽ� Ȯ�����ּ���!");
			productList();
		}	
	}
	
	
	/* checkOut : üũ�ƿ� �� �����ϱ�
	 *====================================== */
	public void checkOut() {
		System.out.println("=".repeat(30));
		System.out.println(title + ": üũ �ƿ� �ϱ� >>");
		System.out.println("=".repeat(30));
		
		int index = 0;
		for(Product p : cart) {
			System.out.println("["+ index++ + "] ");
			System.out.println(p.toString());
			System.out.println();
			sum += p.getPrice();
			
		}	
		
		// ������� �հ� ���
		System.out.println("=".repeat(30));
		System.out.println("����ڸ� : " + users[sel_user].getName());
		System.out.println("������� : " + users[sel_user].getPaytype());
		System.out.println("=".repeat(30));
		System.out.println("���ݾ� : " + sum);
		System.out.println("[p] ����, [q] ���� �Ϸ�;");
		System.out.print("���� : ");

		// ����
		String select = scan.next(); //���� : p,q 
		switch(select) {
		case "p" : productList(); break; 	  //��ǰ��� ȭ�� 
		case "q" : 
			System.out.println("�����Ϸ�~ �����մϴ�^^");
			System.exit(0);
			 break; //����
		default : 
			checkOut();

		}
	}
	//���α׷� �ó������� ���� �ʱ�ȭ�ϰ� �����Ѵ�.
	public void run() {
		setTitle("�˳� ���θ�");
		genUser();
		genProduct();
		start();
	}
	
	public static void main(String args[]) {
		MyShop shop = new MyShop();
		shop.run();
				
	}

}