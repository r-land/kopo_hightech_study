package chap08;

import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class FileReaderEx {

/*	public static void main(String[] args) throws IOException  {
		FileReader fin = new FileReader("C:\\javaex\\ex.txt");
		int c;
		while((c=fin.read())!=-1) {
			System.out.print((char)c);
		}
		fin.close();
	}

}*/


public static void main(String[] args) throws IOException  {
	FileReader fin;
	try{
		fin= new FileReader("C:\\javaex\\ex.txt");
		int c;
		while((c=fin.read())!=-1) {
		System.out.print((char)c);
		}
		fin.close();
	}
	catch(IOException e) {
		e.printStackTrace();
	}

  }

}