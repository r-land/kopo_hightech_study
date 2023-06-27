 package chap13;

public class TicketSystem extends Thread{
	int total;
	SellManager sm;
	
	@Override
	public void run() {
		String currentName = Thread.currentThread().getName();
		System.out.println(currentName+ "- ����");
		for(int i=0; i<3; i++) {
			System.out.println(currentName+ "- �Ǹ�" + sm.sell());
		}
		System.out.println(currentName+ "- ����");
	}
	//������
	public TicketSystem() {
		total = 100;
		sm = new SellManager();
	}
	public static void main(String[] args) {
		System.out.println("#######Ƽ�� ���� �ý��� #######");
		TicketSystem app = new TicketSystem();
		for(int i = 0; i<10; i++) {
			Thread t = new Thread(app);
			t.start();
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("main �޼ҵ� ���� !!");
	}
	//���� Ŭ���� �ۼ�
	class SellManager{
		
		//Ƽ���� ��ü ������ �����ϴ� �޼ҵ�
		int sell() {
			total--;
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return total;
		}
	}
}
