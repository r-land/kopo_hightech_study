package chap05;

abstract class Shape1 {
	abstract void draw();
	void paint() {System.out.println("����Ʈ�޼ҵ� ȣ��");}
	void print(){System.out.println("����Ʈ�޼ҵ� ȣ��");};
}

class RealShape extends Shape1{
	@Override
	void draw() {System.out.println("draw�޼ҵ� ȣ��");}
	
	
}

	public abstract class Shape1_Abstract_Ex {
		public static void main(String args[]) {
		Shape1 sp =new RealShape();
		sp.paint();
		sp.draw();
		}
	}
