package com.semanticsquare.concurrency;

public class ThreadPriorityDemo {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread());
		Thread t1 = new Thread(new EmailCampaing());
		Thread t2 = new Thread(new DataAggregator());
		
		t1.setName("emailCampaing");
		t2.setName("DataAgregator");
		
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		
		t1.start();
		t2.start();
		
		try {
			t2.join(1); //wait for one millisecond to thread to die, if not go back to main
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("inside main");
	}
}

class EmailCampaing implements Runnable{
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(Thread.currentThread().getName());
			if (i == 5) {
				Thread.currentThread().yield();
			}
		}
	}
}

class DataAggregator implements Runnable{
	public void run() {
		for (int i =1; i<10; i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}
}
