package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class MyClientRecieveThread extends Thread{

	private Socket sock;
	
	public MyClientRecieveThread(Socket sock){
		this.sock = sock;
	}
	
	
	public void run(){
		int b;
		
		//new socket
		//open input stream
		//write input stream to System.out
		try {
			Socket socket = sock;
			InputStream inStream = inStream = socket.getInputStream();
			while((b=inStream.read()) != -1){
				System.out.write(b);
			}
			//flush any remaining data
			System.out.flush();
			System.out.println("it got here with OutputShutdown: " + socket.isOutputShutdown());
			if(socket.isOutputShutdown()){
				socket.close();
				System.out.println("This happened: " + socket.isClosed());
			}
			System.out.println("then it got here");

		} catch (UnknownHostException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}
	
}
