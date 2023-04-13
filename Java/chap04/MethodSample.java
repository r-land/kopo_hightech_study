package chap04;

public class MethodSample {

	//메소드 오버로딩
	int getSum(int x, int y){return x+y;}
	int getSum(int x, int y, int z){return x+y+z;}
//	double getSum(int x, int y){return (double)(x+y);} 
//이경우 int 인지 double 인지 모르니깐 double을 맞추던가 갯수를 다르게
	double getSum(double x,double y) {return (double)(x+y);}

	
	public static void main(String[] args) {
		MethodSample sample = new MethodSample();
		System.out.println(sample.getSum(1, 2));
		System.out.println(sample.getSum(1, 2, 3));
		System.out.println(sample.getSum(2.0, 3.0));
		//static 없어서 객체명 sample찍기
	}

}
