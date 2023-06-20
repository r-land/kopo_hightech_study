package midproject;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AppMain extends JFrame implements ActionListener {
	// ȭ�� ������ ���� �г�
	JPanel p1 = new JPanel(); // �ؽ�Ʈ �� �г�
	JPanel p2 = new JPanel(); // �Է� ��� �г�
	JPanel p3 = new JPanel(); // ������ ��� �г� (��ư)

	// �ؽ�Ʈ �󺧺�
	JLabel msg1 = new JLabel();

	// �Է¾�Ŀ� ���� �ؽ�Ʈ �ʵ�
	JTextField t1 = new JTextField(20); // ��ǰ��
	JTextField t2 = new JTextField(20); // �ܰ�
	JTextField t3 = new JTextField(20); // ������

	
	  //�����ڵ� ������ ���� �޺��ڽ� 
	JComboBox cb = new JComboBox();
	 

	// ������ ��� �ؽ�Ʈ����
	JTextArea area = new JTextArea(10, 40);

	// �޴���ư
	JButton b1 = new JButton("���");
	JButton b2 = new JButton("��ȸ");
	JButton b3 = new JButton("����");

	// ���̵� ��
	JLabel la1 = new JLabel("������ȣ");
	JLabel la2 = new JLabel("��ǰ��");
	JLabel la3 = new JLabel("�ܰ�");
	JLabel la4 = new JLabel("������");

	// editmode ����(false : ��� /��ȸ/ ���� �ȵǰ� _
	boolean editmode;
	String msg = "## �޽���: ";

	// ProductDAO�� ���� ��ü ����
	ProductDAO dao = new ProductDAO();
	Product product;

	// ��ü ��ǰ��� ����� ���� ArrayList ����
	ArrayList<Product> datas = new ArrayList<Product>();

	// refreshData : �ʱ�ȭ���� �����ϴ� ���
	public void refreshData() {
		// ������ ������ ��� ����� �ʱ�ȭ
		clearField();
		// textarea �ʱ�ȭ
		area.setText("");

		// editmode (true)���� ���� ���� ��ü��� ��ȸ�� ������ ����
		// editmode (false)���� ���� ���� ��ü��� ��ȸ�� �ȵǴ� ����
		editmode = false;

		// textfield ���� ��� ��� ����
		datas = dao.getAll();
		area.append("������ȣ\t��ǰ��\t\t�ܰ�\t������\n");

		// �޺��ڽ� items �־��ִ� ��
		cb.setModel(new DefaultComboBoxModel(dao.getItems()));
		
		if (datas != null) {
			// ArrayList �� ��ü �����͸� ���Ŀ� ���� ���
			for (Product p : datas) {
				StringBuffer sb = new StringBuffer();
				sb.append(p.getPcode() + "\t");
				sb.append(p.getPname() + "\t\t");
				sb.append(p.getPrice() + "\t");
				sb.append(p.getManufacture() + "\n");
				area.append(sb.toString());
			}
		} else {
			area.append("��ϵ� ��ǰ�� �����ϴ�. !!\n��ǰ�� ����� �ּ��� !!");
		}
	}

	// actionPerformed �������̵�
	// �̺�Ʈ �߻� ó�� �޼���
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		// ��ϱ��
		if (obj == b1) {
			product = new Product();
			product.setPname(t1.getText()); // ��ǰ��
			product.setPrice(Integer.parseInt(t2.getText())); // �ܰ�
			product.setManufacture(t3.getText()); // ������

			// ������ ���
			if (editmode == true) {
				product.setPcode(Integer.parseInt((String) cb.getSelectedItem()));
				if (dao.updateProduct(product)) {
					msg1.setText(msg + "��ǰ�� �����߽��ϴ�!!");
					clearField();
					editmode = false; // ���� �Ұ� ���� ����
				} else
					msg1.setText(msg + "��ǰ ������ ���� �߽��ϴ�.!!");
			}
			// ����� ���
			else {
				if (dao.newProduct(product)) {
					msg1.setText(msg + "��ǰ�� ����߽��ϴ�.!!");
				} else
					msg1.setText(msg + "��ǰ ����� ���� �߽��ϴ�.!!");
			}
			// ȭ�� ������ ����
			refreshData();

		}

		// ��ȸ���
		if (obj == b2) {
			String s = (String) cb.getSelectedItem();
			if (!s.equals("��ü")) {
				product = dao.getProduct(Integer.parseInt(s));
				if (product != null) {
					msg1.setText(msg + "��ǰ������ �����Խ��ϴ�.!!");
					t1.setText(product.getPname());
					t2.setText(String.valueOf(product.getPrice()));
					t3.setText(product.getManufacture());
					// cb.setSelectedIndex(anIndex);
					editmode = true;
				} else {
					msg1.setText(msg + "��ǰ�� �˻����� �ʾҽ��ϴ�.!!");
				}
			} else {
				// ȭ�� ������ ����
				refreshData();
			}
		}

		// �������
		if (obj == b3) {
			String s = (String) cb.getSelectedItem();
			if (s.equals("��ü")) {
				msg1.setText(msg + "��ü ������ ���� �ʽ��ϴ�.!!");
			} else {
				if (dao.delProduct(Integer.parseInt(s))) {
					msg1.setText(msg + "��ǰ�� �����Ǿ����ϴ�.!!");
				} else {
					msg1.setText(msg + "��ǰ�� �������� �ʾҽ��ϴ�.!!");
				}
			}
			// ȭ�� ������ ����
			refreshData();
		}

	}

	public void startUI() {
		setTitle("���α׷��� ���۵Ǿ����ϴ�.");

		// ���̾ƿ� ��
		p1.setLayout(new GridLayout(4, 1, 20, 2));
		p2.setLayout(new GridLayout(4, 1, 20, 2));

		// ��ũ�ѱ�� ������ area ����
		JScrollPane scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		// refreshData �޼ҵ� ȣ�� (ȭ�鰻��)
		refreshData();

		// ���(b1) ��ȸ(b2) ����(b3) �̺�Ʈ ������ �߰�
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
		msg1.setText("���α׷��� ���۵Ǿ����ϴ�.");
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
