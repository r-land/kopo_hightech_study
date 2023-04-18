package chap05;


class Point1 {
	private int x, y;
	public Point1(int x, int y) {this.x = x; this.y = y;}
	public int getX() {return x;}
	public int getY() {return y;}
	protected void move(int x, int y) {this.x = x; this.y = y;}
}
//Point 클래스 사전제공
//Point 클래스 상속 받은 ColorPoint 클래스  생성자와 메소드 작성
public class ColorPoint1 extends Point1{
	private String color;
	public ColorPoint1(int x, int y, String color) {
		super(x, y); //조상클래스 생성자 호출
		this.color = color; //멤버변수와 지역변수 이름같을때 구별
	}
	public void setXY(int x, int y) {move(x,y);}
	public void setColor(String color) {this.color = color;}
	public String toString() {
		return color + "색의 " + "(" + getX() + "," + getY() + ")의 점"; 
	}
    //실행결과도출 사전제공 생성자 메소드 유추
	public static void main(String[] args) {
		ColorPoint1 cp = new ColorPoint1(5, 5, "YELLOW");
		cp.setXY(10, 20);
		cp.setColor("RED");
		String str = cp.toString();
		System.out.println(str + "입니다.");
	}
}
