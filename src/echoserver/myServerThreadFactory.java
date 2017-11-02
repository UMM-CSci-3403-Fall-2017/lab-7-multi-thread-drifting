package echoserver;

import java.net.Socket;
import java.util.concurrent.ThreadFactory;

public class myServerThreadFactory implements ThreadFactory{
	private Socket sock;
	public myServerThreadFactory(Socket s){
		this.sock = s;
	}
	
	@Override
	public Thread newThread(Runnable r){
		myServerInputThread t = new myServerInputThread(sock);
		return t;
	}
}
