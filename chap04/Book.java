package chap04;

public class Book {
	
	//�������
	String title; 	
	String author; 	
	String name ="���Ƹ�";
	//�޼ҵ�
	//�����ڸ޼ҵ�
	Book(){
		System.out.println(name);
	} //�⺻������ Default
	Book(String title){
		this("", ""); //(�������߿��� �ĸ����� �ƹ����� ���� ��)
		this.title = title; //this�� �������,����Լ�����
		this.author = "���ڹ̻�";
			}
	Book(String title, String author){
		this.title =title;
		this.author = author;
	}
	//�Ϲݸ޼ҵ�
	void printBook() {
		System.out.println(this.title + " : " + this.author);
	}
	
	public static void main(String[] args) {
		Book book = new Book();
		Book littlePrince = new Book("�����", "�������丮");
		Book loveStory = new Book("������");
		littlePrince.printBook();
		loveStory.printBook();	
		book.title ="���̿���";
		System.out.println(book.title);

	}

}
