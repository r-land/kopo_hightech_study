package chap08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class WordSearchEx {
	
	Words word;
	Scanner scan;
	
	private Vector<String> wordVector = new Vector<String>();

	private boolean readFile() { // words.txt ���� �б�
		try {
			Scanner fScanner = new Scanner(new FileInputStream("c:\\javaex\\words.txt"));
			while(fScanner.hasNext()) 
				wordVector.add(fScanner.nextLine()); // �� ���ο� �ϳ��� �ܾ�
			fScanner.close();
		}catch(FileNotFoundException e) { 
			System.out.println("������Ʈ ���� ���� words.txt ������ �����ϴ�");
			return false;
		} 
		System.out.println("������Ʈ ���� ���� words.txt ������ �о����ϴ�...");
		return true;
	}
	private void processQuery() { // �ܾ� �˻�
		Scanner scanner = new Scanner(System.in);
		while(true) {
			boolean found = false;
			System.out.print("�ܾ�>>");
			String searchWord = scanner.nextLine(); // �˻��� �ܾ� �Է�
			if(searchWord.equals("�׸�")) { 
				break; // �˻� ����
			}
			
			// ���Ϳ��� �˻�
			for(int i=0; i<wordVector.size(); i++) {
				String word = wordVector.get(i); // ���� ���� ���ڿ�
				if(word.length() < searchWord.length()) // ������ ���ڿ��� �˻� ���ڿ����� ª�� ��� 
					continue;
				
				// ���͹��ڿ��� �պκ��� �˻� ���ڿ� ũ�⸸ŭ �߶󳻱�
				String frontPart = word.substring(0, searchWord.length());
				
				if(searchWord.equals(frontPart)) { // �˻� ���ڿ��� �߶� �� �κ� ��
					System.out.println(word); // ���Ϳ��� �߰��� �ܾ� ���
					found = true;
				}
			}
			if(!found) // �� �ܾ �߰߸��� ����
				System.out.println("�߰��� �� ����");
		}
		scanner.close();

	}
	
	public void run() {
		System.out.println("�ܾ�ã����ӽ����մϴ�~");
		//������ word �����ڿ� �־� vector�� ��ȯ

		boolean res = readFile(); // res�� false�̸�  �ܾ� ���� �б� ����
		if(res == true)
			processQuery();
		System.out.println("�����մϴ�...");
	}
	
	public static void main(String[] args) {
		WordSearchEx ws = new WordSearchEx();
		ws.run();
	}
}