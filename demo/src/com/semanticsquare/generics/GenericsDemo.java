package com.semanticsquare.generics;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class GenericsDemo<T> {

	<E extends T> GenericsDemo(E object) {

	}

	public static void main(String[] args) {

		Container<String> stringStore = new Store<>();
		stringStore.set("Java");
		System.out.println(stringStore.get());

		Container<Integer> integerStore = new Store<>();
		integerStore.set(1);
		System.out.println(integerStore.get());

		Container<List<Integer>> listStore = new Store<>();
		listStore.set(Arrays.asList(1, 2, 3));
		System.out.println(listStore.get());

		rawTypeTest();
		List<String> strList1 = Arrays.asList("a", "b", "c");
		List<String> strList2 = Arrays.asList("b", "c", "d");
		getCommonElementsCount(strList1, strList2);
		getCommonElementsCount(strList1, strList2);
		Container<?> someStore = stringStore;
		Object object = someStore.get();
		List<Integer> intList1 = Arrays.asList(1, 2);
		List<Integer> intList2 = Arrays.asList(3, 4);
		invalidAggregate(intList1, intList2, new ArrayList());
		go(new ArrayList<Number>());
		go(new Integer[1]);

		genericMethodDemo();
		//GenericsDemo.invarianceWorkAround(new ArrayList<String>());
		//GenericsDemo.invarianceWorkAround(new ArrayList<Number>());
		List<Integer> intList3 = new ArrayList<>();
		//GenericsDemo.invarianceWorkAround(intList3, 23);
		Integer data = intList3.get(0);

		boundedWildcards();
	}

	static void boundedWildcards() {
		System.out.println("inside bounded wildcard");
		List<Integer> intList = Arrays.asList(11, 21, 31);
		display(intList);
		List<Double> doubleLlist = Arrays.asList(11.5, 21.5, 31.5);
		display(doubleLlist);

		List<Number> numList = new ArrayList<>();
		aggregateWithConsumer(intList, doubleLlist, numList);
		System.out.println("num list" + numList);

		Collections.addAll(new ArrayList<Object>(), 1, 2);
		Collections.copy(numList, doubleLlist);
		System.out.println("numList after copy" + numList);
		System.out.println("collecitons dispaly + " + Collections.disjoint(intList, doubleLlist));

		GenericsDemo.replaceAll(numList, 11.5, 44);
		System.out.println("numlist: " + numList);
	}

	static <T> boolean replaceAll(List<T> list, T oldval, T newval) { //overrading the the class level typer parameter
		// TODO Auto-generated method stub
		for (int i = 0; i < list.size(); i++) {
			if (oldval.equals(list.get(i)))
				list.set(i, newval);
		}
		return true;
	}

	public static <E> void aggregateWithConsumer(List<? extends E> l1, List<? extends E> l2, List<? super E> l3) {
		// TODO Auto-generated method stub
		l3.addAll(l1);
		l3.addAll(l2);
	}

	static void display(List<? extends Number> list) {
		// producer of dtat
		for (Number element : list) {
			System.out.println("disply: " + element);
		}
		// list.add(22);
	}
	// or this generic method
	/*
	 * static <T extends Number> void display(List<T> list) { for (Number element:
	 * list) { System.out.println("diplaying " + element); } }
	 */

	static <T extends Number> void invarianceWorkAround(List<T> list, T element) {
		// T element = (T) new Double(23.3);
		list.add(element);
	}

	static void genericMethodDemo() {
		System.out.println("indiseGenericMethod Name");
		TyperArgeInference(22.0);
		TyperArgeInference("Java");
		Double doubleVal = TyperArgInference1(22.0);
		System.out.println(doubleVal);
		Integer[] na = new Integer[100];
		Collection<Number> cs = new ArrayList<>();
		arrayToCollection(na, cs);
		String strVal = typeArgInferenceFromTargetType1();
		// Integer strVal = typeArgInterfaceFromTargetType1();
		GenericsDemo.targetTypeInvoker1(typeArgInferenceFromTargetType2());
		GenericsDemo.targetTypeInvoker1(new ArrayList<>());
		GenericsDemo.targetTypeInvoker2(typeArgInferenceFromTargetType2());
		List<String> strList = GenericsDemo.targetTypeInvoker2(typeArgInferenceFromTargetType2());
		GenericsDemo.targetTypeInvoker2(new ArrayList<>());
		List<String> strList2 = GenericsDemo.targetTypeInvoker2(new ArrayList<>());

		// inferring super type
		Serializable obj = typeArgInference3("s", new ArrayList<>());

		AbstractCollection c = typeArgInference4(new ArrayList(), new HashSet());
		GenericsDemo.<String>uselessGenerciMethod();

		new GenericsDemo<Number>(12.0);
		new GenericsDemo<>(12.0);
		new <Double>GenericsDemo<Number>(12.0); // double for the constructor
		// new <Double>GenericsDemo<>(12.0);// hmmmm
		GenericsDemo<Number> gd = new GenericsDemo<>(12.0);

		List<Integer> intList1 = Arrays.asList(1, 2);
		List<Integer> intList2 = Arrays.asList(3, 5);
		List<Integer> intList3 = new ArrayList<>();
		aggregate(intList1, intList2, intList3);
		System.out.println(intList3);
	}

	public static <E> void aggregate(List<E> list1, List<E> list2, List<E> list3) {
		// TODO Auto-generated method stub
		list3.addAll(list1);
		list3.addAll(list2);
	}

	static <T> void uselessGenerciMethod() {
		T t = (T) new Integer(2);
		System.out.println("typeWitness: " + t.getClass().getName());

	}

	static <T> T typeArgInference3(T object1, T object2) {
		System.out.println("most specifig type arg: " + object1.getClass().getName() + object2.getClass().getName());
		return object1;
	}

	static <T> T typeArgInference4(T object1, T object2) {
		// TODO Auto-generated method stub
		System.out.println("most specific" + object2.getClass().getName());
		return object1;
	}

	static <T> List<T> targetTypeInvoker2(List<T> list) {
		// TODO Auto-generated method stub
		return list;

	}

	static void targetTypeInvoker1(List<String> list) {
		// TODO Auto-generated method stub
		for (String s : list) {
			System.out.println("element: " + s);
		}
	}

	static <T> void arrayToCollection(T[] na, Collection<T> cs) {
		for (T o : na) {
			cs.add(o);
		}
	}

	private static <T> T TyperArgInference1(T object) {
		System.out.println("Type argument" + object.getClass().getName());
		return object;
	}

	private static <T> void TyperArgeInference(T object) {
		System.out.println("Type argument" + object.getClass().getName());
	}

	private static <T> T typeArgInferenceFromTargetType1() {
		return (T) "abc";
	}

	private static <T> List<T> typeArgInferenceFromTargetType2() {
		List<String> list = new ArrayList<>();
		list.add("abc");
		return (List<T>) list;
	}

	static void go(Number[] list) {
		list[0] = 24.4;
	}

	private static void invalidAggregate(List<?> intList1, List<?> intList2, List<?> list3) {
		// TODO Auto-generated method stub
		// l3.addAll(l1);
		// l3.addAll(l2);
	}

	static void go(List<Number> list) {

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

	public static int getCommonElementsCountWithWildcard(List<?> list1, List<?> list2) {
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
		HalfIntegrator.getPrice(ISBN, prices);
		Double price = prices.get(0);
	}

	// public void go(T list) {
	// list.add(0, new Object());
	// }
}

interface Container<T> {
	void set(T a);

	T get();
}

class HalfIntegrator {
	public static void getPrice(int ISBN, List<Double> prices) {
		prices.add((double) 45);
	}
}

class Store<T> implements Container<T> {
	private T a;

	public void set(T a) {
		this.a = a;
	}

	public T get() {
		return a;
	}

}