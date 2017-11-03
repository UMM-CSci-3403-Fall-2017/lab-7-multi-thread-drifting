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
		int bcounter = 0;
		try {
			InputStream inStream = sock.getInputStream();
			OutputStream outStream = sock.getOutputStream();
			
			while((b=inStream.read()) != -1){
				outStream.write(b);
				bcounter++;
				System.out.write(b);
//				if(sock.isOutputShutdown()) System.out.println("Socket output is shutdown");
//				if(sock.isInputShutdown()) System.out.println("Socket input is shutdown");
			}

			System.out.println("it sent this many: " + bcounter);
			System.out.println("it got here");
			outStream.flush();
			System.out.println("then it got here");
			sock.close();

		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
}
