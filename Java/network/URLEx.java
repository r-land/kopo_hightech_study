package network;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class URLEx {

	public static void main(String[] args) throws Exception{
		URL url = new URL("http://www.google.com");
		System.out.println(url.getProtocol());
		System.out.println(">> HTML 시작하기");
		
		
		InputStream is = url.openStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String msg;
		while((msg = br.readLine())!=null) {
			System.out.println(msg);
		}
		br.close();
		is.close();
	}

}
