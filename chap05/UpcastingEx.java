package chap05;
class Person {
	String name;
	String id;
	
	public Person(String name) {this.name = name;}
}
class Student extends Person{
	String grade;
	String department;
	
	public Student(String name) {super(name);}
}

public class UpcastingEx {

	public static void main(String[] args) {
		Person p = new Student("���繮"); //upcasting
		System.out.println(p.name); 
	//	System.out.println(p.grade); //�ڽİ��� ���� 
		
		Student s = new Student("ȫ�浿");
		System.out.println(s.grade); //���ΰ��� ��. 
		
		//downcasting
		Student s1 = (Student)p;
		System.out.println(s1.name);
		s1.department = "������ũ";
		System.out.println(s1.department);
		
		if(p instanceof Person)System.out.println("Person");
		else				System.out.println("Person �ƴϾ�");
		
	}

}
