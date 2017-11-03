package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MyServerInputThread extends Thread{

	private ArrayList<Integer> result = new ArrayList<Integer>();
	private Socket sock;
	
	public MyServerInputThread(Socket s){
		this.sock = s;
	}
	
	
	public void run(){
		InputStream inStream = null;
		try {
			inStream = sock.getInputStream();
		} catch (IOException e) {
			System.out.println(e);
		}
		int b;
		try {
			while((b=inStream.read()) != -1){
				result.add(b);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}
	
	public ArrayList<Integer> getResult(){
		return result;
	}
	
}
