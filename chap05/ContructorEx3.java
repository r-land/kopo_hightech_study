package chap05;

class A{
	public A() {System.out.println("생성자A"); }
	public A(int x) {System.out.println("매개변수생성자A"); }
}
class B extends A{
	public B() {
			super(100);
			System.out.println("생성자B"); }
	public B(int x) {System.out.println("매개변수생성자B"); }
}

public class ContructorEx3 {
public static void main(String[] args) {
B b = new B();
}
}
