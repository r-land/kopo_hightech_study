package chap08;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;


public class Words {


	Vector<String> wordVector = new Vector<String>();
	
	public Words(String filename) {
		try {
			Scanner scan = new Scanner(new FileReader(filename));
			while(scan.hasNext()) {
				String words = scan.nextLine();
				wordVector.add(words);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
			System.exit(0); //프로그램 종료
		}
	}
	
	public void printVector() {
		for(String s : wordVector)
			System.out.println(s);
	}
	
	
	public String getRandomWord() {
		final int WORDMAX = wordVector.size();
		int randomIndex = (int)(Math.random() * WORDMAX);
		return wordVector.get(randomIndex);
	
	
	}
}