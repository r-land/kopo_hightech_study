package chap01;

public class Mission2 {

	public static int max(int x, int y) {
		if (x>y)
		return x;
		else
		return y;
}

	public static void main(String[] args) {
		int x = 10;
		int y = 20;
		System.out.println("더 큰 수는 : " + max(x,y));

	}

}
