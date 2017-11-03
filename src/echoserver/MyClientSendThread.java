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
		int b;
		
		//get output stream
		//write to output
		try {
			OutputStream outStream = sock.getOutputStream();
			while((b=System.in.read()) != -1){
				outStream.write(b);
			}
			//flush remaining data
			outStream.flush();
			//let server know we are done sending data
			sock.shutdownOutput();
		} catch (UnknownHostException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		}
		
	}

	
}
