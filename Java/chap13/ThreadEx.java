package chap13;

public class ThreadEx extends Thread{

		@Override
		public void run() {
			System.out.println("RUN���� ����� ���!");
		}
		public static void main(String[] args) {
			ThreadEx ex = new ThreadEx();
			ex.start();
			System.out.println("main���� ����� ���!");
		}
}
