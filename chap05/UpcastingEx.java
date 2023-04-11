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
		Person p = new Student("이재문"); //upcasting
		System.out.println(p.name); 
	//	System.out.println(p.grade); //자식것은 못씀 
		
		Student s = new Student("홍길동");
		System.out.println(s.grade); //본인것은 씀. 
		
		//downcasting
		Student s1 = (Student)p;
		System.out.println(s1.name);
		s1.department = "하이테크";
		System.out.println(s1.department);
		
		if(p instanceof Person)System.out.println("Person");
		else				System.out.println("Person 아니야");
		
	}

}
