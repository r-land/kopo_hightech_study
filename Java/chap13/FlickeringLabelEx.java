package chap13;

import java.awt.*;
import javax.swing.*;

class FlickeringLabel extends JLabel implements Runnable {
	private long delay;  // 배경색이 바뀌는 지연 시간. 밀리초 단위
	
	public FlickeringLabel(String text, long delay) {
		super(text);
		this.delay = delay;
		setOpaque(true);
		
		Thread t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		int n=0; //상태초기값
		while(true) { //무한루프
			if(n==0) 		setBackground(Color.orange);
			else if(n==1)   setBackground(Color.PINK);
			if(n==0) 		n = 1;
			else if(n==1) 	n = 0;
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
public class FlickeringLabelEx extends JFrame {
	public FlickeringLabelEx() {
		setTitle("깜박거리는 예제");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		//label - 3가지 구성 
		FlickeringLabel label1 = new FlickeringLabel("0.5초깜빡", 500);
		label1.setFont(new Font("굴림", Font.ITALIC, 30));
		JLabel label2 = new JLabel("안깜빡");
		label2.setFont(new Font("굴림", Font.ITALIC, 30));
		FlickeringLabel label3 = new FlickeringLabel("0.3초깜빡", 300);
		label3.setFont(new Font("굴림", Font.ITALIC, 30));
		
		//label을 컨테이너에 부착
		c.add(label1);c.add(label2);c.add(label3);
		
		setSize(500,150);
		setVisible(true);
	}

	public static void main(String[] args) {	
		FlickeringLabelEx ex = new FlickeringLabelEx();
	}
}