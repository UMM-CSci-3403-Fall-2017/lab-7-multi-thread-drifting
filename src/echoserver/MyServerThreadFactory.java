package echoserver;

import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ThreadFactory;

public class MyServerThreadFactory implements ThreadFactory{
	private Socket sock;
	private int type = 0; //0 for output, 1 for input thread
	private ArrayList<Integer> input = new ArrayList<Integer>();
	public MyServerThreadFactory(Socket s, int type){
		this.sock = s;
		type = 1;
	}
	
	public MyServerThreadFactory(Socket s, int type, ArrayList<Integer> input){
		this.sock = s;
		type = 0;
		this.input = input;
	}
	
	@Override
	public Thread newThread(Runnable r){
		Thread t;
		if(type == 0) {
			t = new MyServerInputThread(sock);
		} else {
			t = new MyServerOutputThread(sock, input);
		}
		
		return t;
	}
}
