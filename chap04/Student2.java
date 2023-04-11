package chap04;

public class Student2 {
    //�Ӽ�(�ʵ�)
	private String name;
	private int age;
	private int id;
    
    //���� (�޼ҵ�)
    //������ �޼ҵ� -�ʱ�ȭ���� �Ӽ����� Ŭ������� �������ְ� �ȸ��� �⺻����
    //source >generate using fields���������
    
    public Student2(){}    
    public Student2(String name, int age, int id) {
		this.name = name;
		this.age = age;
		this.id = id;
	}

	//�Ϲ� �޼ҵ� -�����������
    //������ : �����ε�(overloading) �����̸����� �Ķ���͸� �޸��ؼ� ����
    void study() {System.out.println("��������~");}
    void study(String test) {System.out.println(test+"���θ� �մϴ�.");}
    void eat() {System.out.println("���~");}
    void eat(String meat) {System.out.println(meat + "��⸦ �Խ��ϴ�.");}
    void sleep() {System.out.println("����~");}
    boolean test(String test, int score) {
    	System.out.println(test + "������ �ñ���!");
    	if(score >= 60) return true;
    	else 			return false;
    }
    
    //getters & setters (������ ������ ) 
    //source > generate getters setters ���������
    //������ �ܺ����� ���°Ŵϱ�(�ڹ�ĸ��ȭ) �Ӽ��� private �پ��ִ°� ����
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}


    //main �޼ҵ�
    public static void main(String[] args) {
    	Student2 student = new Student2(); //��ü�� �����ϰ� new ����Ȯ��
		student.study();
		if(student.test("����ó��������", 80))
			System.out.println("�հ��ϼ̽��ϴ�^^");
		else 
			System.out.println("���հ��ϼ̽��ϴ٤̤�");
    }
}
