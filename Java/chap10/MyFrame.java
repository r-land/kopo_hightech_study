package chap10;

import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame{
	
	public MyFrame() {
		setTitle("300X300 ���� ������ �����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//����Ʈ ���� ������ ���� �ͼ� ����
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.PINK);
		//��ư �߰� (��� ��ȸ ���� ��ư �߰�)
		JButton button1 = new JButton("���");
		JButton button2 = new JButton("��ȸ");
		JButton button3 = new JButton("����");
		
		contentPane.setLayout(new FlowLayout());
		contentPane.add(button1);
		contentPane.add(button2);
		contentPane.add(button3);
				
		setSize(300, 300);
		setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
	
		
	}

}

