package chap07;




public class Student2{
	//field
	private String name;
	private double score;
	
	//������
	
	public Student2(String name, double score) {
		super();
		this.name = name;
		this.score = score;
	}
	//getters setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	
	//toString
	@Override
	public String toString() {
		return "Student2 [�̸� = " + name + ", ������� = " + score + "]";
	}
	
}
