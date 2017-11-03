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
		//Socket socket = null;
		OutputStream outStream = null;
		int b;
		int bcount = 0;
		
		try {
		//	socket = sock;
			outStream = sock.getOutputStream();
			while((b=System.in.read()) != -1){
				outStream.write(b);
				bcount++;
			}
			outStream.flush();
			sock.shutdownOutput();
//			System.out.println("It got here with socket output shutdown: " + socket.isOutputShutdown());
//			System.out.println("It got here with socket input shutdown: " + socket.isInputShutdown());
//			System.out.println("It got here with socket: " + socket.isClosed());
//			System.out.println("It sent this many: " + bcount);
		} catch (UnknownHostException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		}
		
	}

	
}
