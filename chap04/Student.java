package chap04;

public class Student {
	String dept;
	int id;
	
	public static void main(String[] args) {
		Student student = new Student();
		student.dept = "����Ʈ����Ʈ�����а�";
		student.id = 2023000111;
		System.out.println(student.dept + " : " + student.id);
	}
}
