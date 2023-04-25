package chap07;

import java.util.ArrayList;

public class ClassMate {
	String class_name;
	static ArrayList<Student> al = new ArrayList<Student>();
	
	public static void main(String[] args) {
		Student s1 = new Student("이유진", 1);
		al.add(s1);
		s1 = new Student("조아름", 2);
		al.add(s1);
		System.out.println(al.get(1).getName());
	}
}



class Student{
	private String name;
	private int id;
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + "]";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Student(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
}



