package chap08;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;


//hangmangame class 
//=================================================
public class HangManGameEx {
//1.�ܾ �������� ���
//2.����2���� ����� ��� : 2���� ���ڸ� ����� �ش� ���ڴ� _ǥ�÷� �ٲ�
//3.���ڸ� �ϳ��� �����ش�. ���乮�ڿ� ��ġ�ϴ��� �´ٰ� ���ְ� _��� �ش� ���ڷ� ��ü�ϴ� ���
//4. 2������ ���� �� �ֵ��� �ϴ� ���
//5. ���� ������ ���� �� �ִ� ���
	
	String randomWord; //���Ӽ����ܾ�
	StringBuffer hidenLetters; //������� �����ܾ�
	final int BlankMax = 2; //����� ���� ����
	int failCount; //Ʋ��Ƚ��
	

	Scanner scanner = new Scanner(System.in);
	
	void run() {
		System.out.println("��ǰ��ӽ����մϴ�~");
		//������ word �����ڿ� �־� vector�� ��ȯ
		Words word = new Words("c:\\javaex\\words.txt");
		//������ �����մϴ�
		while(true) {
			randomWord = word.getRandomWord(); //������ �ܾ ���Ϳ� �����´�.
			System.out.println(randomWord);
			
			if(randomWord == null) break; //���������� ����
			
			hideLetters(); //���� 2���� ���ܼ� hiddenWord�� �����
			System.out.println(hidenLetters);
			go(); //������ �����մϴ�. �õ�Ƚ�� ������ ���ڸ� �ϼ���Ų��
			System.out.println("������ �� �Ͻǰſ��� ?(y/n)");
			if(scanner.next().equals("n")) break;
		}
	}
	//�������� �ܾ 2�� ���� ���� �ܾ� hidenletters�� �����
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
	//���� �����ϴ� �޼ҵ�
	private void go() {
		failCount=0; //�ʱ�ȭ ����
		char key;
		do {
			if(failCount ==5) {
				System.out.println("5�� ���� �Ͽ����ϴ�.");
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


//// Word class (������ , ����1�� �����ϴ� �޼ҵ�)
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
//			System.out.println("������ ã�� �� �����ϴ�.");
//			System.exit(0); //���α׷� ����
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