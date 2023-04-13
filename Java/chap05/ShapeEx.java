package chap05;
class Shape {
	void draw() {System.out.println("Shape");}
}
class Line extends Shape {
	@Override
	void draw() {System.out.println("Line");}
}
class Rect extends Shape {
	@Override
	void draw() {System.out.println("Rect");}
}
class Circle extends Shape {
	@Override
	void draw() {System.out.println("Circle");}
}


//오버라이딩 (동적바인딩) 자식 먼저 실행된다

public class ShapeEx {
	public static void main(String[] args) {
		Circle c = new Circle();
		c.draw();
		Shape shape = new Line(); //업캐스팅
		shape.draw(); //오버라이딩 되서 Shape 아닌 Line 실행
	}
}
