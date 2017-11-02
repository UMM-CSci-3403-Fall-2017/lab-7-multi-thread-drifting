package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class myServerInputThread extends Thread{

	private Socket sock;
	
	public myServerInputThread(Socket s){
		this.sock = s;
	}
	
	
	public void run(){
		System.out.println("I'm running");
		try {
			InputStream inStream = sock.getInputStream();
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}
}
