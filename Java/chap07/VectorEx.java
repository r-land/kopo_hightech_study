package chap07;

import java.util.Vector;

public class VectorEx {
	
	public void printVector(Vector<Integer> v) {
		for(Integer i : v) System.out.println(i);
	}

	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer>(20);
		//capacity기본값 10
		VectorEx ex = new VectorEx();
		v.add(5); //int형의 데이터가 Integer로 자동박싱되면서 들어감
		v.add(4);
		v.add(-1);
		v.add(6);
		
		v.add(2,7); //2번 인덱스에 7값 끼워넣기
		
		System.out.println("벡터 객체의 요소 갯수 : " +v.size());
		System.out.println("벡터 현재 용량 : " +v.capacity());

//		for(int i=0; i<v.size(); i++)
//			System.out.println("요소 : "+ v.get(i));
//		
//		for(Integer i : v) System.out.println(i);
		for(Integer i : v) System.out.printf("%d ,", i);
		
		ex.printVector(v);
		int sum = 0;
		for(Integer i : v) sum += i;
		System.out.println("sum : " +sum);
	}
}
