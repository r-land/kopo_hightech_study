package midproject;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AppMain extends JFrame implements ActionListener {
	// 화면 구성을 위한 패널
	JPanel p1 = new JPanel(); // 텍스트 라벨 패널
	JPanel p2 = new JPanel(); // 입력 양식 패널
	JPanel p3 = new JPanel(); // 데이터 출력 패널 (버튼)

	// 텍스트 라벨부
	JLabel msg1 = new JLabel();

	// 입력양식에 사용된 텍스트 필드
	JTextField t1 = new JTextField(20); // 상품명
	JTextField t2 = new JTextField(20); // 단가
	JTextField t3 = new JTextField(20); // 제조사

	
	  //관리코드 선택을 위한 콤보박스 
	JComboBox cb = new JComboBox();
	 

	// 데이터 출력 텍스트영역
	JTextArea area = new JTextArea(10, 40);

	// 메뉴버튼
	JButton b1 = new JButton("등록");
	JButton b2 = new JButton("조회");
	JButton b3 = new JButton("삭제");

	// 사이드 라벨
	JLabel la1 = new JLabel("관리번호");
	JLabel la2 = new JLabel("상품명");
	JLabel la3 = new JLabel("단가");
	JLabel la4 = new JLabel("제조사");

	// editmode 설정(false : 등록 /조회/ 삭제 안되게 _
	boolean editmode;
	String msg = "## 메시지: ";

	// ProductDAO을 위한 객체 설정
	ProductDAO dao = new ProductDAO();
	Product product;

	// 전체 상품목록 출력을 위한 ArrayList 생성
	ArrayList<Product> datas = new ArrayList<Product>();

	// refreshData : 초기화면을 제공하는 기능
	public void refreshData() {
		// 기존의 내용을 모두 지우고 초기화
		clearField();
		// textarea 초기화
		area.setText("");

		// editmode (true)정보 수정 삭제 전체목록 조회가 가능한 상태
		// editmode (false)정보 수정 삭제 전체목록 조회가 안되는 상태
		editmode = false;

		// textfield 내용 찍는 기능 구현
		datas = dao.getAll();
		area.append("관리번호\t상품명\t\t단가\t제조사\n");

		// 콤보박스 items 넣어주는 것
		cb.setModel(new DefaultComboBoxModel(dao.getItems()));
		
		if (datas != null) {
			// ArrayList 의 전체 데이터를 형식에 맞춰 출력
			for (Product p : datas) {
				StringBuffer sb = new StringBuffer();
				sb.append(p.getPcode() + "\t");
				sb.append(p.getPname() + "\t\t");
				sb.append(p.getPrice() + "\t");
				sb.append(p.getManufacture() + "\n");
				area.append(sb.toString());
			}
		} else {
			area.append("등록된 상품이 없습니다. !!\n상품을 등록해 주세요 !!");
		}
	}

	// actionPerformed 오버라이딩
	// 이벤트 발생 처리 메서드
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		// 등록기능
		if (obj == b1) {
			product = new Product();
			product.setPname(t1.getText()); // 상품명
			product.setPrice(Integer.parseInt(t2.getText())); // 단가
			product.setManufacture(t3.getText()); // 제조사

			// 수정인 경우
			if (editmode == true) {
				product.setPcode(Integer.parseInt((String) cb.getSelectedItem()));
				if (dao.updateProduct(product)) {
					msg1.setText(msg + "상품을 수정했습니다!!");
					clearField();
					editmode = false; // 수정 불가 모드로 변경
				} else
					msg1.setText(msg + "상품 수정이 실패 했습니다.!!");
			}
			// 등록인 경우
			else {
				if (dao.newProduct(product)) {
					msg1.setText(msg + "상품을 등록했습니다.!!");
				} else
					msg1.setText(msg + "상품 등록이 실패 했습니다.!!");
			}
			// 화면 데이터 갱신
			refreshData();

		}

		// 조회기능
		if (obj == b2) {
			String s = (String) cb.getSelectedItem();
			if (!s.equals("전체")) {
				product = dao.getProduct(Integer.parseInt(s));
				if (product != null) {
					msg1.setText(msg + "상품정보를 가져왔습니다.!!");
					t1.setText(product.getPname());
					t2.setText(String.valueOf(product.getPrice()));
					t3.setText(product.getManufacture());
					// cb.setSelectedIndex(anIndex);
					editmode = true;
				} else {
					msg1.setText(msg + "상품이 검색되지 않았습니다.!!");
				}
			} else {
				// 화면 데이터 갱신
				refreshData();
			}
		}

		// 삭제기능
		if (obj == b3) {
			String s = (String) cb.getSelectedItem();
			if (s.equals("전체")) {
				msg1.setText(msg + "전체 삭제는 되지 않습니다.!!");
			} else {
				if (dao.delProduct(Integer.parseInt(s))) {
					msg1.setText(msg + "상품이 삭제되었습니다.!!");
				} else {
					msg1.setText(msg + "상품이 삭제되지 않았습니다.!!");
				}
			}
			// 화면 데이터 갱신
			refreshData();
		}

	}

	public void startUI() {
		setTitle("프로그램이 시작되었습니다.");

		// 레이아웃 배
		p1.setLayout(new GridLayout(4, 1, 20, 2));
		p2.setLayout(new GridLayout(4, 1, 20, 2));

		// 스크롤기능 들어가도록 area 조정
		JScrollPane scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		// refreshData 메소드 호출 (화면갱신)
		refreshData();

		// 등록(b1) 조회(b2) 삭제(b3) 이벤트 리스너 추가
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		p1.add(la1);
		p1.add(la2);
		p1.add(la3);
		p1.add(la4);

		p2.add(cb);
		p2.add(t1);
		p2.add(t2);
		p2.add(t3);

		p3.add(b1);
		p3.add(b2);
		p3.add(b3);

		add(msg1, BorderLayout.PAGE_START);
		add(p1, BorderLayout.LINE_START);
		add(p2, BorderLayout.CENTER);
		add(scroll, BorderLayout.LINE_END);
		add(p3, BorderLayout.PAGE_END);

		setSize(700, 300);
//		setResizable(false);
		setVisible(true);
	}

	public AppMain() {
		super("Product Manager Application V1.0");
		msg1.setText("프로그램이 시작되었습니다.");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void clearField() {
		t1.setText("");
		t2.setText("");
		t3.setText("");
	}

	public static void main(String[] args) {
		AppMain app = new AppMain();
		app.startUI();
	}

}
