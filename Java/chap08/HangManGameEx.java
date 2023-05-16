package chap08;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;


//hangmangame class 
//=================================================
public class HangManGameEx {
//1.단어를 가져오는 기능
//2.글자2개를 숨기는 기능 : 2개의 글자를 숨기고 해당 글자는 _표시로 바꿈
//3.글자를 하나씩 맞춰준다. 숨긴문자와 일치하는지 맞다고 해주고 _대신 해당 문자로 교체하는 기능
//4. 2개까지 맞출 수 있도록 하는 기능
//5. 직접 게임을 해줄 수 있는 기능
	
	String randomWord; //게임선정단어
	StringBuffer hidenLetters; //숨긴글자 가진단어
	final int BlankMax = 2; //숨기는 글자 개수
	int failCount; //틀린횟수
	

	Scanner scanner = new Scanner(System.in);
	
	void run() {
		System.out.println("행맨게임시작합니다~");
		//파일을 word 생성자에 넣어 vector로 변환
		Words word = new Words("c:\\javaex\\words.txt");
		//게임을 시작합니다
		while(true) {
			randomWord = word.getRandomWord(); //랜덤한 단어를 벡터에 꺼내온다.
			System.out.println(randomWord);
			
			if(randomWord == null) break; //문제있으면 종료
			
			hideLetters(); //글자 2개를 숨겨서 hiddenWord를 만든다
			System.out.println(hidenLetters);
			go(); //게임을 진행합니다. 시도횟수 내에서 글자를 완성시킨다
			System.out.println("게임을 더 하실거예요 ?(y/n)");
			if(scanner.next().equals("n")) break;
		}
	}
	//랜덤선정 단어에 2개 글자 숨긴 단어 hidenletters를 만든다
 private void hideLetters() {
	 hidenLetters = new StringBuffer(randomWord);
	 Random r = new Random();
	 
	 for(int k=0; k<BlankMax; k++) {
		 int index =r.nextInt(randomWord.length());
		 char c = randomWord.charAt(index);
		 for(int i = 0; i <randomWord.length(); i++) {
			 if(hidenLetters.charAt(i) == c)
				 hidenLetters.setCharAt(i,'_');	
	 }
	 }
	 
	 
 }
	//실제 게임하는 메소드
	private void go() {
		failCount=0; //초기화 시켜
		char key;
		do {
			if(failCount ==5) {
				System.out.println("5번 실패 하였습니다.");
				break;
			}
			System.out.println(hidenLetters);
			System.out.print(">>");
			String text = scanner.next();
			key = text.charAt(0);
		} while(!complete(key));
		System.out.println(randomWord);
	}
	
	private boolean complete(char key) {
		boolean hit = false;
		for(int i = 0; i<randomWord.length(); i++) {
			if(hidenLetters.charAt(i)=='_' && randomWord.charAt(i)==key) {
				hidenLetters.setCharAt(i, key);
				hit = true;
				break;
//			if(randomWord.equals(hidenLetters)) {hit=true; break;}
			}
//			return hit;
		}
		if(!hit)
			failCount++;
		for(int i =0; i < randomWord.length(); i++) {
			if(hidenLetters.charAt(i)=='_')
				return false;
		}
		return true;
	}
	
	
	
	
	
	public static void main(String[] args) {
		HangManGameEx game = new HangManGameEx();
		game.run();
	}

}


//// Word class (생성자 , 글자1개 추출하는 메소드)
////=================================================
//
//class Words{
//	Vector<String> wordVector = new Vector<String>();
//	
//	public Words(String filename) {
//		try {
//			Scanner scan = new Scanner(new FileReader(filename));
//			while(scan.hasNext()) {
//				String words = scan.nextLine();
//				wordVector.add(words);
//			}
//		} catch (FileNotFoundException e) {
//			System.out.println("파일을 찾을 수 없습니다.");
//			System.exit(0); //프로그램 종료
//		}
//	}
//	
//	public String getRandomWord() {
//		final int WORDMAX = wordVector.size();
//		int randomIndex = (int)(Math.random() * WORDMAX);
//		return wordVector.get(randomIndex);
//	
//	
//	}
//}