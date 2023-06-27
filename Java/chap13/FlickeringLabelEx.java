package chap13;

import java.awt.*;
import javax.swing.*;

class FlickeringLabel extends JLabel implements Runnable {
	private long delay;  // ������ �ٲ�� ���� �ð�. �и��� ����
	
	public FlickeringLabel(String text, long delay) {
		super(text);
		this.delay = delay;
		setOpaque(true);
		
		Thread t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		int n=0; //�����ʱⰪ
		while(true) { //���ѷ���
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
		setTitle("���ڰŸ��� ����");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		//label - 3���� ���� 
		FlickeringLabel label1 = new FlickeringLabel("0.5�ʱ���", 500);
		label1.setFont(new Font("����", Font.ITALIC, 30));
		JLabel label2 = new JLabel("�ȱ���");
		label2.setFont(new Font("����", Font.ITALIC, 30));
		FlickeringLabel label3 = new FlickeringLabel("0.3�ʱ���", 300);
		label3.setFont(new Font("����", Font.ITALIC, 30));
		
		//label�� �����̳ʿ� ����
		c.add(label1);c.add(label2);c.add(label3);
		
		setSize(500,150);
		setVisible(true);
	}

	public static void main(String[] args) {	
		FlickeringLabelEx ex = new FlickeringLabelEx();
	}
}