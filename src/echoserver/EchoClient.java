package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class EchoClient {
	public static final int PORT_NUMBER = 6013;

	public static void main(String[] args) throws IOException {
		EchoClient client = new EchoClient();
		client.start();
	}

	private void start() throws IOException {
		Socket socket = new Socket("localhost", PORT_NUMBER);
		
		Thread send = new MyClientSendThread(socket);
		Thread receive = new MyClientRecieveThread(socket);
//		ExecutorService service = Executors.newFixedThreadPool(2);
		send.start();
		receive.start();
	}
	
//	private void start() throws IOException {
//		Socket socket = new Socket("localhost", PORT_NUMBER);
//		InputStream socketInputStream = socket.getInputStream();
//		OutputStream socketOutputStream = socket.getOutputStream();
//		int readByte;
//		while ((readByte = System.in.read()) != -1) {
//			socketOutputStream.write(readByte);
//			int socketByte = socketInputStream.read();
//			System.out.write(socketByte);
//		}
//		System.out.flush();
//	}
}