package chap06;

import java.io.InputStreamReader;
import java.util.Scanner;

public class AlphabetHistogram {
    int histData[] = new int[26]; //각 알파벳 갯수를 카운트하는 정수형 배열
    
    AlphabetHistogram() {
    	for(int i=0; i<histData.length; i++) histData[i]=0;
    }
    //동작을 해주는 메소드 : readString -> checkAlphabet -> drawHistogram 조립
    void run() {
    	checkAlphabet(readString());
    	drawHistogram();
    }

	//readString 통해 가지고 온// 텍스트를 알파벳 별로(배열형태) 카운팅하는 메소드
	void checkAlphabet(String msg) {
		msg =msg.toUpperCase();
	 //대문자 바꾸면 문자열로 바뀜
		int index;
		for(int i=0; i<msg.length(); i++) {
		char c = msg.charAt(i);
		if(c>='A' && c<='Z') {
			index = c -'A'; // 문자끼리 뺄수없어 아스키코드로 바뀜 65-65 =0
			histData[index]++;
		}	
	}
}
	//히스토그램을 그리는 메소드 

	void drawHistogram() {
		for(int i=0;i<histData.length;i++) {
			System.out.print((char)(65+i)+":");
			for(int j=0;j<histData[i];j++) {
				System.out.print("-");
			}
			System.out.println();
		}
	}
	
		
	
	//텍스트를 입력받아 하나의 StringBuffer로 붙이고,String으로 변경하여 리턴하는 메소드
		String readString() {
			StringBuffer sb = new StringBuffer();
			Scanner scan = new Scanner(System.in);
			while(true) {
				String line = scan.nextLine();
				if(line.length()==1&&line.charAt(0)==';')
						break;
				sb.append(line);
			}
			scan.close();
			return sb.toString();		
			
			
	}
		public static void main(String[] args) {
			System.out.println("텍스트를 입력하시오");
			AlphabetHistogram al = new AlphabetHistogram();
			al.run();
}
}