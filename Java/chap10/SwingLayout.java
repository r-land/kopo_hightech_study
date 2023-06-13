package chap10;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class SwingLayout extends JFrame{
	
	JButton button1 = new JButton("��ư1");
	JButton button2 = new JButton("��ư2");
	JButton button3 = new JButton("��ư3");
	JButton button4 = new JButton("��ư4");
	JButton button5 = new JButton("��ư5");
	
	Panel panel1 = new Panel();
	Panel panel2 = new Panel();
	Panel panel3 = new Panel();

	public SwingLayout() {
		setTitle("���� ���̾ƿ� �����ϱ�");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container container = getContentPane();
		container.setBackground(Color.pink);
		
		// container�� panel�� ������Ű��
		container.add(panel1);
		container.add(panel2);
		//flowLayout();
		//gridLayout();
		//borderLayout();
		cardLayout();
		
		setSize(300, 200);
		setVisible(true);
	}
	
	//FlowLayout�����ϱ�
	public void flowLayout() {
		panel1.setLayout(new FlowLayout());
		panel1.add(button1);
		panel1.add(button2);
		panel1.add(button3);
		panel1.add(button4);
		panel1.add(button5);
	}
	public void gridLayout() {
		panel1.setLayout(new GridLayout(2, 2));
		panel1.add(button1);
		panel1.add(button2);
		panel1.add(button3);
		panel1.add(button4);
		panel1.add(button5);
	}
	public void borderLayout() {
		panel1.setLayout(new BorderLayout());
		panel1.add(button1, BorderLayout.NORTH);
		panel1.add(button2, BorderLayout.WEST);
		panel1.add(button3, BorderLayout.CENTER);
		panel1.add(button4, BorderLayout.EAST);
		panel1.add(button5, BorderLayout.SOUTH);
	}	
	//�̺�Ʈ �ڵ鷯�� �޾ƺ���!
	public void cardLayout() {
		final CardLayout card = new CardLayout();
		setLayout(card);
		panel1.add(button1);
		panel1.add(button2);
		panel1.add(button3);
		panel2.add(button4);
		panel3.add(button5);
		
		add("panel1", panel1);
		add("panel2", panel2);
		add("panel3", panel3);
		
		//�̺�Ʈ ��鷯 �ޱ� (�̺�Ʈ���� �ڵ鷯 �ٴ� ���)
		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(getContentPane());
			}
		});
		
		button4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(getContentPane());
			}
		});
		
		button5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(getContentPane(), "panel1");
			}
		});
		
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton)e.getSource(); //�̺�Ʈ �ҽ�
				if(btn.getText().equals("��ư1"))
					btn.setText("Action");
				else if (btn.getText().equals("Action"))
					btn.setText("��ư1");
			}
		});
		
		//button2 �� �׼� > ���� Ŭ������ �ۼ��ϱ�
		button2.addMouseListener(new MyMouseAdapter());
		
		
		
	} 
	
	public static void main(String[] args) {
		SwingLayout layout = new SwingLayout();

	}
	
	//BUTTON2 ���콺 ������ ��ǥ�� �����ͼ� ��ư�� ���
	//MouseAdapter Ȱ��
	class MyMouseAdapter extends MouseAdapter{
		@Override
		public void mousePressed(MouseEvent e) {
			JButton btn = (JButton)e.getSource(); //�̺�Ʈ�ҽ�
			int x = e.getX();
			int y = e.getY();
			if(btn.getText().equals("��ư2"))
				btn.setText("��ǥ : " + x + "," +y);
			else
				btn.setText("��ư2");
		}
	}
	
	
	

	//MyActionListener Ŭ���� ����
//	class MyActionListener implements ActionListener{
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			JButton btn = (JButton)e.getSource(); //�̺�Ʈ �ҽ�
//			if(btn.getText().equals("��ư2"))
//				btn.setText("Push button");
//			else if (btn.getText().equals("Push button"))
//				btn.setText("��ư2");
//		}
//	}
}
