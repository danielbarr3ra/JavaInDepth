package com.semanticsquare.concurrency;

public class RaceCondition {
	public static void main(String[] args) {
		BankAccount task = new BankAccount();
		task.setBalance(100);
		
		Thread john = new Thread(task);
		Thread anita = new Thread(task);
		
		john.setName("John");
		anita.setName("anita");
		
		john.start();
		anita.start();
	} 

}

class BankAccount implements Runnable{
	private int balance;
	
	public void setBalance(int newBalance) {
		balance = newBalance;
	}
	
	public synchronized void makeWithdrawal(int amount) {
		if (balance >= amount) {
			System.out.println(Thread.currentThread().getName() + " is about to widhtraw ...");
			balance -= amount;
			System.out.println(Thread.currentThread().getName() + " has withdranw " + amount);
		} else {
			System.out.println("Sorry, not enough balance for " + Thread.currentThread().getName());
		}
	}
	
	public void run() {
		makeWithdrawal(75);
		if (balance < 0)
			System.out.println("money overdrawn!!!");
	}
}