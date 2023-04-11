package chap05;


class Point{
	private int x, y;
	
	public void set(int x, int y) {this.x = x;	this.y = y;	}
	public void showPoint() {System.out.println("("+x+","+y+")");}
}

//point ���
class ColorPoint extends Point{
	private String color;
	public void setColor(String color){
		this.color = color;
	}
	void showColorPoint() {
		System.out.print(this.color);
		super.showPoint(); //super �����ϸ� �θ� �⺻������ ȣ�� �ϹǷ� 
	}
}

public class ColorPointEx {
	public static void main(String[] args) {
		Point p = new Point();
		p.set(1,2);
		p.showPoint();
		
		ColorPoint cp = new ColorPoint();
		cp.set(3, 4);
		cp.setColor("red");
		cp.showColorPoint();
	}
	
}