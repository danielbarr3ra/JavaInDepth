package com.semanticsquare.collections;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueDemo {
	private static void dequeTest() {
		System.out.println("Inside dequeTest ...");
		Deque<String> deque = new ArrayDeque<>();
		deque.add("walden");
		deque.add("harry Potter");
		deque.add("head first Java");
		System.out.println("\n Printing queue....");
		System.out.println(deque.remove()); //removefirst first corresponds to head
		System.out.println(deque.remove());
		System.out.println(deque.remove());
		
		//Stack =LIFO
		deque.push("walden");
		deque.push("harry Potter");
		deque.push("head first java");
		System.out.println(deque.pop());
		System.out.println(deque.pop());
		System.out.println(deque.pop());
		
	}
	
	public static void main(String[] args) {
		dequeTest();
	}
}
