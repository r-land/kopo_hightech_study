package chap05;


class Point4 {
	private int x, y;
	
	public Point4() {this.x = 0; this.y = 0;}
	public Point4(int x, int y) {this.x = x; this.y = y;}
	public int getX() {return x;}
	public int getY() {return y;}
	protected void move(int x, int y) {this.x = x; this.y = y;}
}
//Point 클래스 사전제공
//Point 클래스 상속 받은 PositivePoint 클래스  생성자와 메소드 작성
public class PositivePoint extends Point4{
	public PositivePoint(int x, int y) {
		super(x, y);
		if(x < 0 || y < 0) move(0, 0);
	}
    // 하나라도 음수이면 트루
	
	public PositivePoint() {
	}
	@Override
	protected void move(int x, int y) {
		if(x >= 0 && y >= 0) super.move(x, y);
	}
	//둘다 양수이면 트루
	public String toString() {
		return "(" + getX() + "," + getY() + ")의 점"; 
	}
	public static void main(String[] args) {
		PositivePoint p = new PositivePoint();
		p.move(10, 10);
		System.out.println(p.toString() + "입니다.");
		
		p.move(-5, 5); //객체 p는 음수 공간으로 이동되지 않음
		System.out.println(p.toString() + "입니다.");
		
		PositivePoint p2 = new PositivePoint(-10, -10);
		System.out.println(p2.toString() + "입니다.");
	}
}