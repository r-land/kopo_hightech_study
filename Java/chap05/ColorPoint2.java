package chap05;


class Point2 {
	private int x, y;
	public Point2() {this.x = 0; this.y = 0;}	//기본 생성자 추가
	public Point2(int x, int y) {this.x = x; this.y = y;}
	public int getX() {return x;}
	public int getY() {return y;}
	protected void move(int x, int y) {this.x = x; this.y = y;}
}
//Point 클래스 사전제공
//Point 클래스 상속 받은 ColorPoint 클래스  생성자와 메소드 작성
public class ColorPoint2 extends Point2{
	private String color;
	
	public ColorPoint2() {	//기본 생성자 추가
		this.color = "Black";
	}
	public ColorPoint2(int x, int y) {
		super(x, y);
	}
	public void setXY(int x, int y) {move(x,y);}
	public void setColor(String color) {this.color = color;}
	public String toString() {
		return color + "색의 " + "(" + getX() + "," + getY() + ")의 점"; 
	}
     //main 클래스 실행결과도출 사전제공 생성자 메소드 유추
	public static void main(String[] args) {
		ColorPoint2 zeroPoint = new ColorPoint2(); //(0,0) 위치 black 색점
		System.out.println(zeroPoint.toString() + "입니다.");
		
		ColorPoint2 cp = new ColorPoint2(10, 10); //(10,10) 위치 black 색점
		cp.setXY(5, 5);
		cp.setColor("RED");
		System.out.println(cp.toString() + "입니다.");
	}
}