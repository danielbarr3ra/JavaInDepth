package com.semanticsquare.nestedclasses;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

import com.semanticsquare.collections.Book;

interface CacheIterator{
	boolean hasNext();
	Bookmark next();
}

class FooBar {
	
	protected int y = 0;
	
	FooBar(int x){
		y = x;
	}
	
}

public class Cache {
	private Bookmark[] items;
	private int next = 0;
	public Cache(int size) {
		items = new Bookmark[size];
		
	}
	
	public void add(Bookmark item) {
		if (next < items.length)
			items[next++] = item;
	}
	
	private class MyCacheIterator implements CacheIterator{
		private int i = 0;
		public boolean hasNext() {
			return i < items.length;
		}
		public Bookmark next() {
			return items[i++];
		}
		/*
		public void go() {
			System.out.println("hello");
		}
		*/
	}
	
	public CacheIterator iterator() {
		return new MyCacheIterator();
	}
	/*public void go() {
		System.out.println("hello");
		MyCacheIterator sub = new MyCacheIterator();
		sub.go();
	}
	*/
	
	public static void main(String[] args) {
		Cache recommendedItems = new Cache(5);
		Bookmark item1 = new Bookmark();
		item1.setId(2000);
		item1.setTitle("Use Final Liberally");
		item1.setRating(1);
		
		Bookmark item2 = new Bookmark();
		item2.setId(2001);
		item2.setTitle("HOw do I import a pre exisitng jova proj..");
		item2.setRating(2);
		
		Bookmark item3 = new Bookmark();
		item3.setId(2002);
		item3.setTitle("Somwthing esle");
		item3.setRating(3);
		
		Bookmark item4= new Bookmark();
		item4.setId(2003);
		item4.setTitle(" again some esle");
		item4.setRating(4);
		
		Bookmark item5 = new Bookmark();
		item5.setId(2004);
		item5.setTitle("Helllo");
		item5.setRating(5);
		
		recommendedItems.add(item1);
		recommendedItems.add(item2);
		recommendedItems.add(item3);
		recommendedItems.add(item4);
		recommendedItems.add(item5);
		
		
		Arrays.sort(recommendedItems.items, Bookmark.RATING_COMPARATOR);
		CacheIterator iterator = recommendedItems.iterator();
		System.out.println("SORTED by rating");
		Arrays.sort(recommendedItems.items, Bookmark.RATING_COMPARATOR);
		while(iterator.hasNext()) {
			System.out.println(iterator.next().getTitle());
		}
		
		System.out.println("SORTED by titel");
		Arrays.sort(recommendedItems.items, new Bookmark.ComparatorList.StringComparator());
		iterator = recommendedItems.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next().getTitle());
		}
		
		new FooBar(5) {
			void go() {
				System.out.println("prinigt y in fooabr go" + y);
			}
		}.go();
		
	}
	
	
}
