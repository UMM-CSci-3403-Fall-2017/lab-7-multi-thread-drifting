package echoserver;

import java.util.concurrent.ThreadFactory;

public class MyServerOutputThreadFactory implements ThreadFactory{
	private String name;
	private int counter = 0;
	public void CustomThreadFactory(String name){
		this.name = name;
	}
	@Override
	public Thread newThread(Runnable r){
		MyServerOutputThread t = new MyServerOutputThread(null, null);
		counter++;
		return t;
	}
}
