package chap08;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileReaderEx1 {

/*	public static void main(String[] args) throws IOException  {
		FileReader fin = new FileReader("C:\\javaex\\ex.txt");
		int c;
		while((c=fin.read())!=-1) {
			System.out.print((char)c);
		}
		fin.close();
	}

}*/

//����ó��, �ѱ����ڵ�
public static void main(String[] args) throws IOException  {
	FileInputStream in;
	try{
		in= new FileInputStream("C:\\javaex\\ex.txt");
		InputStreamReader is = new InputStreamReader(in, "UTF-8");
		int c;
		while((c=is.read())!=-1) {
		System.out.print((char)c);
		}
		is.close();
	}
	catch(IOException e) {
		e.printStackTrace();
	}

  }

}