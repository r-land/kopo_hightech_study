package chap03;

public class Mission12 {

	public static void main(String[] args) {
 
//로또 번호 생성기 배열
 int lotto_num[] = new int [7];
 String names[] = {"엄", "정", "이"};
 

 for(int i=0; i<7; i++) {
	 lotto_num[i] = 1+(int)(Math.random()*45);
//배열값 입력
 for(int j =0; j<i; j++)
	  if(lotto_num[i] == lotto_num[j]) i--;}
//중복값 제거 
 

	System.out.println("배열값 : " + lotto_num.length);
	
for(int i =0;i<lotto_num.length; i++)
System.out.print(lotto_num[i] +" "); 
System.out.println();
 //배열값출력
 
 for(int i=0; i<7; i++)
 System.out.printf("%5d", lotto_num[i]);	
 System.out.println();
 //배열값 출력
 
 for(int num : lotto_num)
 System.out.printf("%3d", num);
//foreach문을 이용한 값출력
 
 System.out.println();
 
 for(String name :names)
	 System.out.print(name + " ");

	}
	}

//1.배열 이해
//2.배열초기화
//3.배열입력
//4.배열출력
//5.for- each 활용
