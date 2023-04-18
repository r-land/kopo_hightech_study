package chap05;


interface PhoneInterface{
	final int TIMEOUT = 10000;
	void sendCall();
	void receiveCall();
	default void printLogo( ) { System.out.println("**Phone**");
	//�����Ǹ� abstract�ϱ� default�� �ٿ�����
	}
}

public class SamsungPhone implements PhoneInterface {
//PhoneInterface�� ��� �߻�޼ҵ� ������!
	@Override
	public void sendCall() {
		System.out.println("�츮������");
		
	}

	@Override
	public void receiveCall() {
		System.out.println("��ȭ�Ծ��");
		
	}
	
	public static void main(String[] args) {
		SamsungPhone phone = new SamsungPhone();
		phone.sendCall();
		phone.receiveCall();
		phone.printLogo();
		System.out.println(phone.TIMEOUT);
	}

}


