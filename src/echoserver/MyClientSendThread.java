package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class MyClientSendThread extends Thread{

	private Socket sock;
	
	public MyClientSendThread(Socket sock){
		this.sock = sock;
	}
	
	
	public void run(){
		Socket socket = null;
		OutputStream outStream = null;
		int b;
		
		try {
			socket = sock;
			outStream = socket.getOutputStream();
			while((b=System.in.read()) != -1){
				outStream.write(b);
			}
			outStream.flush();
			socket.shutdownOutput();
//			System.out.println("This happened: " + socket.isOutputShutdown());
		} catch (UnknownHostException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}

	
}
