package chap04;

public class Circle {
    /*�ʵ�(�������) : �Ӽ�==========================================*/
	public int radius; // �������
	public String name; //�������
	public static final double PI = 3.14; //�������, ���
	public static String Circle_name = "����"; //Ŭ�������� static�� �ٿ����� ��ȯ����
	
	/*�޼ҵ� (����Լ� static x) : ����========================================*/
	//������ �޼ҵ� �����ʱ�ȭ��Ű�� ����
	public Circle(){}            //Default ������
	public Circle(String name, int radius) { //�����ε�
		this.name = name;
		this.radius = radius;
	}
	//�Ϲ� �޼ҵ�
	double getArea(){return PI * radius * radius;}
	static double getArea(double radius){return PI * radius * radius;}
	
	//main �޼ҵ�
	public static void main(String args[]) {
////	Circle c = new Circle();
//		Circle c1 = new Circle("��1",3);
//		System.out.printf("%.2f",c1.getArea());
		
		Circle pizza = new Circle("����", 10);
		Circle donut = new Circle("����", 2);
		System.out.println(Circle.Circle_name);
		System.out.println("������ ũ��� " + pizza.getArea());
		System.out.println("������ ũ��� " + donut.getArea());
		System.out.println(Circle.getArea(3.0));
		
	}
}
