package network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public void main(String args[]) throws Exception {
		ServerSocket server = new ServerSocket(5000);
		Socket s = server.accept();
		System.out.println("���� ���� ============");
		while(true) {
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			System.out.println("Ŭ���̾�Ʈ ���� ============");
			System.out.println(br.readLine());
			br.close();
		}
	
	}


}
