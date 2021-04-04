package com.semanticsquare.nestedclasses;

import java.io.StringWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class DataTrarnslator {
	public static  String getBookAsXml(int id, String title, double rating, int fblikes, int tweetCount) {
		class Book {
			private int id;
			private String title;
			private double rating;
			private int fblikes;
			private int tweetCount;
			
			public Book(int id, String title, double rating, int fblikes, int tweetCount) {
				this.id = id;
				this.title = title;
				this.rating = rating;
				this.fblikes = fblikes;
				this.tweetCount = tweetCount;
				
			}
		}
		
		Book book = new Book(id,title,rating,fblikes,tweetCount);
		XStream xstream = new XStream(new StaxDriver());
		xstream.alias("book", Book.class);
		StringWriter writer = new StringWriter();
		xstream.marshal(book, new PrettyPrintWriter(writer));
		
		return writer.toString();
	}
	
	public static void main(String[] args ) {
		System.out.println(DataTrarnslator.getBookAsXml(1, "hello world", 2.2, 3, 5));
	}
}
