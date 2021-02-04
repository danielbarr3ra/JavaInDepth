package com.semanticsquare.oop.interfacedemo;
//client inc
public class TestClient {
	public static int getVal() {
		return 42;
	}
	
	public static void main(String[] args) {
		A a = new X();
		a.foo();
		a.bar();
		/*
		C c = new X();
		C clone = ((X)c).clone();
		
		if (clone != c) {
			System.out.println("Clone created");
		}*/
		C c = new X();
		C.staticMethod();
		((X)c).injertianceTest();
	}
}
