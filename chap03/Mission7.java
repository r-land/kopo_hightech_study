package chap03;

public class Mission7 {

	public static void main(String[] args) {
        //달력만들기 
		int cal ;
		int count =0;
		for (cal=1; cal<=31 ; cal++){
			count++;
			System.out.printf("%5d", cal);
			if (count%7==0)  System.out.println(); 
		}	
	}
}
