package com.semanticsquare.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapDemo {
	private static void hashMapDemo() {
		System.out.println("Inside hasmapdDemo");
		Map<String, Integer> map1 = new HashMap<>();
		map1.put("John", 25);
		map1.put("Raj", 29);
		map1.put("Anita", null);
		System.out.println(map1);
		map1.put("Anita", 23);
		System.out.println(map1);
		System.out.println("conatins John?"+ map1.containsKey("John"));
		System.out.println(" John age?"+ map1.get("John"));
		
		System.out.println("iterate using key set");
		Set<String> names = map1.keySet();
		for (String name : names) {
			System.out.println("name: "+ name + "ages " + map1.get(name));
		}
		System.out.println("iterate using entry set");
		Set<Map.Entry<String, Integer>> mappings = map1.entrySet();
		for (Map.Entry<String, Integer> mapping : mappings) {
			System.out.println("name: "+ mapping.getKey() + "ages " + mapping.getValue());
			
		}
		
		names.remove("Anita");
		System.out.println(map1);

		Map<String, Map<String, Object>> userProfile = new HashMap<>();
		Map<String, Object> profile = new HashMap<>();
		profile.put("age", 25);
		profile.put("dept", "CS");
		profile.put("city", "New York");
		userProfile.put("John", profile);
		profile = new HashMap<>();
		profile.put("age", 29);
		profile.put("dept", "CS");
		profile.put("city", "New York");
		userProfile.put("Raj", profile);
		
		System.out.println("User profile: "+ userProfile);
		Map<String, Object> profile1 = userProfile.get("John");
		int age = (Integer) profile1.get("age");
		System.out.println(age);
		
		
	}
	
	public static void imutableKeysDemo() {
		System.out.println("Inside iumatlekeydeom");
		List<Integer> list = new ArrayList<>();
		list.add(1);
		
		Map<List<Integer>, Integer> map = new HashMap<>();
		map.put(list, 1);
		list.add(2);
		System.out.println(map.get(list));
		
	}
	
	private static void lruCacheTest() {
		System.out.println("inside lru cahce test");
		Map<String,String> lruCache = new LRUCache<>(16,0.75f, true);
		lruCache.put("a", "A");
		lruCache.put("b", "B");
		lruCache.put("c", "C");
		System.out.println(lruCache);
		lruCache.get("a");
		lruCache.get("a");
		lruCache.get("a");
		System.out.println(lruCache);
		lruCache.get("b");
		System.out.println(lruCache);
		
		lruCache.put("d", "D");
		System.out.println(lruCache);
		lruCache.put("e", "E");
		System.out.println(lruCache);
		
		
	}
	private static void treeMapDemo() {
		System.out.println("\n\nInside treeMapDemo ...");
		TreeMap<String, Integer> map1 = new TreeMap<>();
		map1.put("John", 25);
		map1.put("Raj", 29);
		map1.put("Anita", 23);
		
		System.out.println(map1);	
		
		System.out.println("Iterating using entrySet ...");
		Set<Map.Entry<String, Integer>> mappings = map1.entrySet();
		for (Map.Entry<String, Integer> mapping : mappings) {
			System.out.println("Name: " + mapping.getKey() + ", Age: " + mapping.getValue());
			if (mapping.getKey().equals("John"))
				mapping.setValue(26);	
		}
		System.out.println(map1);
		//map1.floorEntry("Raj").setValue(22);
	}


	public static void main(String[] args) {
		//hashMapDemo();
		//imutableKeysDemo();
		//lruCacheTest();
		treeMapDemo();
	}
}

class LRUCache<K,V> extends LinkedHashMap<K,V> {
	//private static final long serialVersionUID = 6464155743798737431L;
	private static final int MAX_ENTRIES = 3;
	  
	public LRUCache(int initialCapacity,
	             float loadFactor,
	             boolean accessOrder) {
		 super(initialCapacity, loadFactor, accessOrder);
	}
	  
	// Invoked by put and putAll after inserting a new entry into the map
	public boolean removeEldestEntry(Map.Entry eldest) {
	     return size() > MAX_ENTRIES;
		 // return false; // same as normal linked hash map
	}		  
}
