package chap08;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterEx {

	public static void main(String[] args) {

		FileWriter fout = null;
		Scanner scan = new Scanner(System.in);
		try {
			fout = new FileWriter("C:\\javaex\\test.txt");
			while(true) {
				String line = scan.nextLine();
				if(line.length()==0) break;
				fout.write(line, 0, line.length());
				fout.write("\r\n", 0, 2);
			}
			fout.close();
		}
		catch(IOException e) {
			System.out.println("파일 입출력 오류");
		}
		
		scan.close();
	}

}
