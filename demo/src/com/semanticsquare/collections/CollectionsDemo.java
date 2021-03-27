package com.semanticsquare.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Raj");
		list.add("John");
		list.add("John");
		String[] array = {"Anita"};
		
		Collections.addAll(list, array);
		// list.addAll(Arrays.asList(array);
		
		System.out.println("list " + list);
		
		
		//sorting
		Collections.sort(list);
		System.out.println(list);
		
		//binary search
		System.out.println(Collections.binarySearch(list, "Anita"));
		
		Collection<String> unmodifieable = Collections.unmodifiableCollection(list);
		System.out.println("unmo" + unmodifieable);
		System.out.println("is anita there: " + unmodifieable.contains("Anita"));
		
		//add to list then use undomdifable
		list.add("JJ");
		System.out.println("is anita there: " + unmodifieable);
		
	}
}
