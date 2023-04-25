package chap06;

import java.io.InputStreamReader;
import java.util.Scanner;

public class AlphabetHistogram {
    int histData[] = new int[26]; //�� ���ĺ� ������ ī��Ʈ�ϴ� ������ �迭
    
    AlphabetHistogram() {
    	for(int i=0; i<histData.length; i++) histData[i]=0;
    }
    //������ ���ִ� �޼ҵ� : readString -> checkAlphabet -> drawHistogram ����
    void run() {
    	checkAlphabet(readString());
    	drawHistogram();
    }

	//readString ���� ������ ��// �ؽ�Ʈ�� ���ĺ� ����(�迭����) ī�����ϴ� �޼ҵ�
	void checkAlphabet(String msg) {
		msg =msg.toUpperCase();
	 //�빮�� �ٲٸ� ���ڿ��� �ٲ�
		int index;
		for(int i=0; i<msg.length(); i++) {
		char c = msg.charAt(i);
		if(c>='A' && c<='Z') {
			index = c -'A'; // ���ڳ��� �������� �ƽ�Ű�ڵ�� �ٲ� 65-65 =0
			histData[index]++;
		}	
	}
}
	//������׷��� �׸��� �޼ҵ� 

	void drawHistogram() {
		for(int i=0;i<histData.length;i++) {
			System.out.print((char)(65+i)+":");
			for(int j=0;j<histData[i];j++) {
				System.out.print("-");
			}
			System.out.println();
		}
	}
	
		
	
	//�ؽ�Ʈ�� �Է¹޾� �ϳ��� StringBuffer�� ���̰�,String���� �����Ͽ� �����ϴ� �޼ҵ�
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
			System.out.println("�ؽ�Ʈ�� �Է��Ͻÿ�");
			AlphabetHistogram al = new AlphabetHistogram();
			al.run();
}
}