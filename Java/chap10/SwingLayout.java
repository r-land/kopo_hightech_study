package chap10;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class SwingLayout extends JFrame{
	
	JButton button1 = new JButton("버튼1");
	JButton button2 = new JButton("버튼2");
	JButton button3 = new JButton("버튼3");
	JButton button4 = new JButton("버튼4");
	JButton button5 = new JButton("버튼5");
	
	Panel panel1 = new Panel();
	Panel panel2 = new Panel();
	Panel panel3 = new Panel();

	public SwingLayout() {
		setTitle("스윙 레이아웃 연습하기");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container container = getContentPane();
		container.setBackground(Color.pink);
		
		// container에 panel을 부착시키기
		container.add(panel1);
		container.add(panel2);
		//flowLayout();
		//gridLayout();
		//borderLayout();
		cardLayout();
		
		setSize(300, 200);
		setVisible(true);
	}
	
	//FlowLayout설정하기
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
	//이벤트 핸들러도 달아보자!
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
		
		//이벤트 헨들러 달기 (이벤트종류 핸들러 다는 방법)
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
				JButton btn = (JButton)e.getSource(); //이벤트 소스
				if(btn.getText().equals("버튼1"))
					btn.setText("Action");
				else if (btn.getText().equals("Action"))
					btn.setText("버튼1");
			}
		});
		
		//button2 에 액션 > 내부 클래스로 작성하기
		button2.addMouseListener(new MyMouseAdapter());
		
		
		
	} 
	
	public static void main(String[] args) {
		SwingLayout layout = new SwingLayout();

	}
	
	//BUTTON2 마우스 누르면 좌표를 가져와서 버튼에 찍기
	//MouseAdapter 활용
	class MyMouseAdapter extends MouseAdapter{
		@Override
		public void mousePressed(MouseEvent e) {
			JButton btn = (JButton)e.getSource(); //이벤트소스
			int x = e.getX();
			int y = e.getY();
			if(btn.getText().equals("버튼2"))
				btn.setText("좌표 : " + x + "," +y);
			else
				btn.setText("버튼2");
		}
	}
	
	
	

	//MyActionListener 클래스 구현
//	class MyActionListener implements ActionListener{
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			JButton btn = (JButton)e.getSource(); //이벤트 소스
//			if(btn.getText().equals("버튼2"))
//				btn.setText("Push button");
//			else if (btn.getText().equals("Push button"))
//				btn.setText("버튼2");
//		}
//	}
}
