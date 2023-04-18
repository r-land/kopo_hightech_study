package chap05;


interface PhoneInterface{
	final int TIMEOUT = 10000;
	void sendCall();
	void receiveCall();
	default void printLogo( ) { System.out.println("**Phone**");
	//생략되면 abstract니깐 default를 붙여야함
	}
}

public class SamsungPhone implements PhoneInterface {
//PhoneInterface의 모든 추상메소드 구현해!
	@Override
	public void sendCall() {
		System.out.println("띠리리리링");
		
	}

	@Override
	public void receiveCall() {
		System.out.println("전화왔어요");
		
	}
	
	public static void main(String[] args) {
		SamsungPhone phone = new SamsungPhone();
		phone.sendCall();
		phone.receiveCall();
		phone.printLogo();
		System.out.println(phone.TIMEOUT);
	}

}


