package chap04;

public class Circle {
    /*필드(멤버변수) : 속성==========================================*/
	public int radius; // 멤버변수
	public String name; //멤버변수
	public static final double PI = 3.14; //멤버변수, 상수
	public static String Circle_name = "원형"; //클래스변수 static을 붙여주자 소환가능
	
	/*메소드 (멤버함수 static x) : 행위========================================*/
	//생성자 메소드 값을초기화시키는 역할
	public Circle(){}            //Default 생성자
	public Circle(String name, int radius) { //오버로딩
		this.name = name;
		this.radius = radius;
	}
	//일반 메소드
	double getArea(){return PI * radius * radius;}
	static double getArea(double radius){return PI * radius * radius;}
	
	//main 메소드
	public static void main(String args[]) {
////	Circle c = new Circle();
//		Circle c1 = new Circle("원1",3);
//		System.out.printf("%.2f",c1.getArea());
		
		Circle pizza = new Circle("피자", 10);
		Circle donut = new Circle("도넛", 2);
		System.out.println(Circle.Circle_name);
		System.out.println("피자의 크기는 " + pizza.getArea());
		System.out.println("도넛의 크기는 " + donut.getArea());
		System.out.println(Circle.getArea(3.0));
		
	}
}
