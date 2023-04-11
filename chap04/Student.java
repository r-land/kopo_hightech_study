package chap04;

class Student {
	String dept;
	int id;
	
	public static void main(String[] args) {
		Student student = new Student();
		student.dept = "스마트소프트웨어학과";
		student.id = 2023000111;
		System.out.println(student.dept + " : " + student.id);
	}
}
