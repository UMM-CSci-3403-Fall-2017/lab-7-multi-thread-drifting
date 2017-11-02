package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class myServerOutputThread extends Thread{
	public void run(ServerSocket serverSocket, InputStream inputStream) throws IOException{
		System.out.println("I'm running");
		
		while (true) {
			Socket socket = serverSocket.accept();
			OutputStream outputStream = socket.getOutputStream();
			int b;
			while ((b = inputStream.read()) != -1) {
				outputStream.write(b);
			}
		}
	}
}
