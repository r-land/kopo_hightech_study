package chap05;

abstract class Shape1 {
	abstract void draw();
	void paint() {System.out.println("페인트메소드 호출");}
	void print(){System.out.println("프린트메소드 호출");};
}

class RealShape extends Shape1{
	@Override
	void draw() {System.out.println("draw메소드 호출");}
	
	
}

	public abstract class Shape1_Abstract_Ex {
		public static void main(String args[]) {
		Shape1 sp =new RealShape();
		sp.paint();
		sp.draw();
		}
	}
