package com.semanticsquare.nestedclasses;

import java.io.Serializable;
import java.util.Comparator;

public class Bookmark {
	private long id;
	private String title;
	private double rating;
	
	public static final Comparator<Bookmark> RATING_COMPARATOR =  new RatingComparator();
	
	private static class RatingComparator implements Comparator<Bookmark>, Serializable{

		public int compare(Bookmark o1, Bookmark o2) {
			return o1.getRating() < o2.getRating() ? 1 : -1;
		}
  
		
	}
	

	public static class ComparatorList{
		public static class RatingComparator implements Comparator<Bookmark>, Serializable{

			public int compare(Bookmark o1, Bookmark o2) {
				return o1.getRating() < o2.getRating() ? 1 : -1;
			}

			
		}

		public static class StringComparator implements Comparator<Bookmark>, Serializable{

			public int compare(Bookmark o1, Bookmark o2) {
				return o1.getTitle().length() < o2.getTitle().length() ? 1 : -1;
			}

			
		}

	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
}
