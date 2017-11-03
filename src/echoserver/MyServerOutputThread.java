package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MyServerOutputThread extends Thread{
	
	private ArrayList<Integer> input = new ArrayList<Integer>();
	private Socket socket = null;
	
	public MyServerOutputThread(Socket socket, ArrayList<Integer> input){
		this.socket = socket;
		this.input = input;
	}
	
	public void run(){
			OutputStream outputStream = null;
			try {
				outputStream = socket.getOutputStream();
			} catch (IOException e) {
				System.out.println(e);
			}
			int counter = 0;
			while (counter < input.size()) {
				try {
					outputStream.write(input.get(counter));
				} catch (IOException e) {
					System.out.println(e);
				}
			}
			try {
				outputStream.flush();
			} catch (IOException e) {
				System.out.println(e);
			}
	}
}
