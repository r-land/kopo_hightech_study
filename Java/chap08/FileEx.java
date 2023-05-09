package chap08;

import java.io.File;

public class FileEx {

	public static void main(String[] args) {
		File f = new File("C:\\javaex\\file.txt");
		System.out.println(f.getName());
		System.out.println(f.getParent());
		System.out.println(f.getPath());
		System.out.println("����ũ�� : " + f.length() + "byte");
		
		f = new File("C:\\javaex");
		if(f.isDirectory())
			System.out.println("���丮�� �½��ϴ�.");
		File[] subfiles = f.listFiles();
		for(File ff : subfiles)
			System.out.println(ff.getName());

	}

}
