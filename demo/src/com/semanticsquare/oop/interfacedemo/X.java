package com.semanticsquare.oop.interfacedemo;
//author xyz

public class X extends AbstractA implements A, B, C, Cloneable{
	public void foo() {
		System.out.println("X: foo");
		System.out.println("VAL: " + B.VAL );
	}
	public void fooBar() {
		System.out.println("FooBar: fooBar");
	}
	public C clone() {
		try {
			return (C)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void injertianceTest() {
		go();
	}
//	public void go() {
//		C.super.go(); //cannot access grandparetns etc default methods
//		//you also need to specify the interface name (c) same with
//		//default method.
//	}
}
