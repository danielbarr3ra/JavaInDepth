package com.semanticsquare.jvm;

public class Hello {
	int i = 3;

	public static void main(String[] args) {
		Object hello = new Hello();
		hello.toString();
	}

	public String toString() {
		System.out.println("Hello");
		return "hello";
	}
}
