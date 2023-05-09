package chap08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BufferedReaderEx {

	public static void main(String[] args) throws IOException {
		File f = new File("C:\\\\javaex\\\\phone.txt");
		
		InputStreamReader is = new InputStreamReader(new FileInputStream(f), "UTF-8");
		
		BufferedReader reader = new BufferedReader(is);
		String line;
		StringTokenizer st;
		HashMap<String, String> map = new HashMap<String, String>();
	
		
		while(!(line = reader.readLine()).equals("q")) {
			map = new HashMap<String, String>();
			st = new StringTokenizer(line, " ");
			while(st.hasMoreTokens()) {
				map.put(st.nextToken(), st.nextToken());
			}
	
	
		}
		
		}
		
		
		
	}
	


