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
		//get input and output streams
		//write from input to output
		try {
			InputStream inStream = sock.getInputStream();
			OutputStream outStream = sock.getOutputStream();
			
			while((b=inStream.read()) != -1){
				outStream.write(b);
				System.out.write(b);
			}

			//flush remaining data
			outStream.flush();
			//close socket
			sock.close();

		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
}
