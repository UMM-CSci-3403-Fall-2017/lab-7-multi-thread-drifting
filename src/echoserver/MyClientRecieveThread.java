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
			InputStream inStream = sock.getInputStream();
			while((b=inStream.read()) != -1){
				System.out.write(b);
			}
			//flush any remaining data
			System.out.flush();
			sock.close();

		} catch (UnknownHostException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		}
		
	}
	
}
