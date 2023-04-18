package chap05;


class Point4 {
	private int x, y;
	
	public Point4() {this.x = 0; this.y = 0;}
	public Point4(int x, int y) {this.x = x; this.y = y;}
	public int getX() {return x;}
	public int getY() {return y;}
	protected void move(int x, int y) {this.x = x; this.y = y;}
}
//Point Ŭ���� ��������
//Point Ŭ���� ��� ���� PositivePoint Ŭ����  �����ڿ� �޼ҵ� �ۼ�
public class PositivePoint extends Point4{
	public PositivePoint(int x, int y) {
		super(x, y);
		if(x < 0 || y < 0) move(0, 0);
	}
    // �ϳ��� �����̸� Ʈ��
	
	public PositivePoint() {
	}
	@Override
	protected void move(int x, int y) {
		if(x >= 0 && y >= 0) super.move(x, y);
	}
	//�Ѵ� ����̸� Ʈ��
	public String toString() {
		return "(" + getX() + "," + getY() + ")�� ��"; 
	}
	public static void main(String[] args) {
		PositivePoint p = new PositivePoint();
		p.move(10, 10);
		System.out.println(p.toString() + "�Դϴ�.");
		
		p.move(-5, 5); //��ü p�� ���� �������� �̵����� ����
		System.out.println(p.toString() + "�Դϴ�.");
		
		PositivePoint p2 = new PositivePoint(-10, -10);
		System.out.println(p2.toString() + "�Դϴ�.");
	}
}