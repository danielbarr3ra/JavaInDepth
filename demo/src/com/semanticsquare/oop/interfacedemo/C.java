package com.semanticsquare.oop.interfacedemo;
//aouthro abc
public interface C extends A {
	void fooBar();
	default void go() {
		System.out.println("default method go in c");
		staticMethod();
	};
	static void staticMethod() {
		System.out.println("static method in C");
	}
}
