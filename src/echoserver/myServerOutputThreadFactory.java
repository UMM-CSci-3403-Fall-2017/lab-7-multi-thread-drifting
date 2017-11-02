package echoserver;

import java.util.concurrent.ThreadFactory;

public class myServerOutputThreadFactory implements ThreadFactory{
	private String name;
	private int counter = 0;
	public void CustomThreadFactory(String name){
		this.name = name;
	}
	@Override
	public Thread newThread(Runnable r){
		myServerOutputThread t = new myServerOutputThread();
		counter++;
		return t;
	}
}
