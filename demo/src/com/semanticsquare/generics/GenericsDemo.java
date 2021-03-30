package com.semanticsquare.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GenericsDemo <T extends ArrayList > {
	public static void main(String[] args) {
		
		Container<String> stringStore = new Store<>();
		stringStore.set("Java");
		System.out.println(stringStore.get());
		
		
		Container<Integer> integerStore = new Store<>();
		integerStore.set(1);
		System.out.println(integerStore.get());
		
		Container<List<Integer>> listStore = new Store<>();
		listStore.set(Arrays.asList(1,2,3));
		System.out.println(listStore.get());
		
		GenericsDemo<ArrayList> list1 = new GenericsDemo<>();
		
		//
		//rawTypeTest();
		List<String> strList1 = Arrays.asList("a","b","c");
		List<String> strList2 = Arrays.asList("b","c","d");
		getCommonElementsCount(strList1,strList2);

	}
	
	public static int getCommonElementsCount(List<String> list1, List<String> list2) {
		// TODO Auto-generated method stub
		int count = 0;
		for (Object element : list1) {
			if (list2.contains(element)) {
				count++;
			}
		}
		return count;
	}

	public static void rawTypeTest() {
		// TODO Auto-generated method stub
		System.out.println("raw type test");
		int ISBN = 1303030;
		List<Double> prices = new ArrayList<>();
		HalfIntegrator.getPrice(ISBN,prices);
		Double price = prices.get(0);
	}

	public void go(T list) {
		list.add(0, new Object());
	}
}

interface Container<T>{
	void set(T a);
	T get();
}

class HalfIntegrator {
	public static void getPrice(int ISBN, List<Double> prices) {
		prices.add((double) 45);
	}
}
class Store<T> implements Container<T>{
	private T a;
	public void set(T a) {
		this.a = a;
	}

	public T get() {
		return a;
	}
	
}