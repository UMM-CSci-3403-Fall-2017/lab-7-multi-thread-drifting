package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MyServerThread extends Thread{

	private Socket sock;
	
	public MyServerThread(Socket s){
		this.sock = s;
	}
	
	
	public void run(){
		int b;
		try {
			InputStream inStream = sock.getInputStream();
			OutputStream outStream = sock.getOutputStream();
			
			while((b=inStream.read()) != -1){
				outStream.write(b);
			}

			outStream.flush();

		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
}
