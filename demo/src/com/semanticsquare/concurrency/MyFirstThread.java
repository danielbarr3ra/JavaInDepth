package com.semanticsquare.concurrency;

import java.util.concurrent.TimeUnit;

public class MyFirstThread {
	
	public static void main(String[] args) {
		//two different actvities represented by different classes
		// the second approach both task and thread have been tightly coupled.
		Task task = new Task();
		Thread thread = new Thread(task);
		thread.start();
		
		try {
			Thread.sleep(3000); //current thread sleep for 3 seconds.
			
			TimeUnit.SECONDS.sleep(3);
			
			thread.interrupt();
			//web crawlers use it
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Inside main");
		
	}
}

class Task implements Runnable{

	@Override
	public void run() {
		System.out.println("Inside run...");
		try {
			Thread.sleep(3000); //current thread sleep for 3 seconds.
			
			TimeUnit.SECONDS.sleep(9);
			//web crawlers use it
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
			//e.printStackTrace();
		}
		go();
	}

	private void go() {
		System.out.println("Inside go..");
		more();
	}
	
	private void more() {
		System.out.println("Inside more..");
	}
	
	
}
