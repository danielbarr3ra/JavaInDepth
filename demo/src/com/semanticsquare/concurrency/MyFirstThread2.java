package com.semanticsquare.concurrency;

public class MyFirstThread2 extends Thread {
	//class defined within thread itself
	public void run() {
		//overrides thread method run
		System.out.println("Inside run...");
		go();
	}

	private void go() {
		System.out.println("Inside go..");
		more();
	}
	
	private void more() {
		System.out.println("Inside more..");
	}
	
	public static void main (String[] args) {
		Thread thread = new MyFirstThread2();
		thread.start();
		System.out.println("Inside main");
	}
}
