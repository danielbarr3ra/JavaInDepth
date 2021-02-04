package com.semanticsquare.oop.interfacedemo;

public interface A {
	int VAL = 5;
	void foo();
	void bar();
	default void go() {
		System.out.println("A: go");
	}
}
