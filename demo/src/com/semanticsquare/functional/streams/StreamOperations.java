package com.semanticsquare.functional.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperations {

	static class Book implements Comparable {
		private long isbn;
		private String title;
		private double rating;
		private double price;
		private String source;

		public Book(long isbn, String title, double rating, double price, String source) {
			this.isbn = isbn;
			this.title = title;
			this.rating = rating;
			this.price = price;
			this.source = source;
		}

		public long getIsbn() {
			return isbn;
		}

		public String getTitle() {
			return title;
		}

		public double getRating() {
			return rating;
		}

		public double getPrice() {
			return price;
		}

		public String getSource() {
			return source;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (int) (isbn ^ (isbn >>> 32));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Book other = (Book) obj;
			if (isbn != other.isbn)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Book [isbn=" + isbn + ", title=" + title + ", rating=" + rating + ", price=" + price + ", source="
					+ source + "]";
		}

		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			return Long.valueOf(isbn).compareTo(((Book) o).getIsbn());
		}

	}

	private static void match(List<Book> books) {
		System.out.println("\nMatching ... ");
		boolean anyMatch = books.stream().anyMatch(d -> d.getRating() >= 4.8 && d.getPrice() <= 50);
		System.out.println(anyMatch);

		boolean allMacth = books.stream().allMatch(d -> d.getRating() >= 4.8);
		System.out.println(allMacth);

		boolean noneMatch = books.stream().noneMatch(d -> d.getRating() <= 2.0);
		System.out.println(noneMatch);

	}

	// Print at most 5 DISTINCT books with rating >= 4.5
	// DB world: select distinct (ISBN) from book where rating >= 4.5 limit 0, 5;
	private static void slice(List<Book> books) {
		Stream<Book> bookStream = books.stream().filter(d -> d.getRating() >= 4.5).distinct().limit(5);
		Stream<String> titleStream = bookStream.map(d -> d.getTitle());
		titleStream.forEach(System.out::println);
	}

	public static void main(String[] args) {

		List<Book> books = new ArrayList<>();

		books.addAll(DataExtractor.getFromAmazon("java"));
		books.addAll(DataExtractor.getFromBarnesAndNoble("java"));

		// intermediate operations (return stream objects)
		// slice(books);

		// terminal operations (return non-stream objects)
		// match(books); // matching stream elements to some criteria

		// All matching & finding operations + limit
		// are short-circuit operations (recall &&, ||)

		// find(books);
		/*reduce(books);
		reduceImperitively(books);
		ovrloadedReductions();
		mutableReduction();
		collectToCollections(books);*/
		collectTomap(books);
		//collectToCollection(books);
	}

	private static void collectToCollection(List<Book> books) {
		// TODO Auto-generated method stub
		System.out.println("collect to collection");

	}

	private static void collectTomap(List<Book> books) {
		// TODO Auto-generated method stub
		System.out.println("in collect to map");
		Map<Long, Book> map = books.stream()
				// .collect(Collectors.toMap(b->b.getIsbn(), b->b));
				.collect(Collectors.toMap(b -> b.getIsbn(), b -> b,
						(b1, b2) -> b1.getPrice() <= b2.getPrice() ? b1 : b2));

		for (Entry<Long, Book> entry : map.entrySet()) {
			System.out.println("isbn: " + entry.getKey() + "book" + entry.getValue());
		}
		System.out.println(map instanceof HashMap);

		Map<Long, Book> treemap = books.stream()
				// .collect(Collectors.toMap(b->b.getIsbn(), b->b));
				.collect(Collectors.toMap(Book::getIsbn, Function.identity(),
						(b1, b2) -> b1.getPrice() <= b2.getPrice() ? b1 : b2, () -> new TreeMap()));

		for (Entry<Long, Book> entry : treemap.entrySet()) {
			System.out.println("isbn: " + entry.getKey() + "book" + entry.getValue());
		}

		Map<Double, List<Book>> ratingsMap = treemap.values().stream()
				.collect(Collectors.toMap(Book::getRating, b -> Collections.singletonList(b), (l1, l2) -> {
					ArrayList<Book> l = new ArrayList<>(l1);
					l.addAll(l2);
					return l;
				}));
		for (Entry<Double, List<Book>> entry : ratingsMap.entrySet()) {
			System.out.println("rating "+ entry.getKey());
			for (Book b : entry.getValue()) {
				System.out.println(b);
			}
		}
	
		
		//more simplified here
		
		
		Map<Double, List<Book>> ratingsMap1 = treemap.values().stream()
				.collect(Collectors.groupingBy(Book::getRating));
		
		for (Entry<Double, List<Book>> entry : ratingsMap1.entrySet()) {
			System.out.println("rating "+ entry.getKey());
			for (Book b : entry.getValue()) {
				System.out.println(b);
			}
		}
		
		System.out.println("grouping y with values as set...");
		Map<Double, Set<Book>> ratingsMap2 = treemap.values().stream()
				.collect(Collectors.groupingBy(Book::getRating, TreeMap::new, Collectors.toSet()));
		for (Entry<Double, Set<Book>> entry : ratingsMap2.entrySet()) {
			System.out.println("\nRating: " + entry.getKey());
			for (Book b : entry.getValue()) {
				System.out.println(b);
			}
		}
		
		Map<Double, Long> ratingsCountMap = treemap.values().stream()
				.collect(Collectors.groupingBy(Book::getRating, Collectors.counting()));
		System.out.println("ratincs count map" + ratingsCountMap);
		System.out.println("counting" + treemap.values().stream().collect(Collectors.counting()));
		
		Map<Double, Double> ratingsavgPrice = treemap.values().stream()
				.collect(Collectors.groupingBy(Book::getRating, Collectors.averagingDouble(Book::getPrice)));
		System.out.println("average ratings" + ratingsavgPrice);
		
		Map<Double, Optional<Book>> ratingsMinPirceMap = treemap.values().stream()
				.collect(Collectors.groupingBy(Book::getRating, Collectors.minBy(Comparator.comparingDouble(Book::getPrice))));
		System.out.println("average min price ratings" + ratingsMinPirceMap);
		
		Map<Double, DoubleSummaryStatistics> sumarized = treemap.values().stream()
		.collect(Collectors.groupingBy(Book::getRating, Collectors.summarizingDouble((Book::getPrice))));
		System.out.println("summarixed" + sumarized);
		
		Map<Boolean, List<Book>> partitionalmap = treemap.values().stream()
				.collect(Collectors.partitioningBy(b->b.getRating() >= 14.5));
		System.out.println("partiton map" + partitionalmap);
		
		Map<Double, List<String>> ratingsTitleMap = treemap.values().stream()
				.collect(Collectors.groupingBy(Book::getRating, Collectors.mapping(Book::getTitle, Collectors.toList())));
		System.out.println("\nratingsTitleMap: " + ratingsTitleMap);
	}


	private static void collectToCollections(List<Book> books) {
		// TODO Auto-generated method stub
		System.out.println("in collecttot collection");
		List<Book> list1 = books.stream().filter(b -> b.getRating() >= 4.5).distinct().collect(Collectors.toList());

		System.out.println("list1.size: " + list1.size());

		Set<Book> set1 = books.stream().filter(b -> b.getRating() >= 4.5)
				// .distinct()
				.collect(Collectors.toSet());

		System.out.println("set1.size: " + set1.size());

		TreeSet<Book> set2 = books.stream().filter(b -> b.getRating() >= 4.5)
				.collect(Collectors.toCollection(() -> new TreeSet()));

		System.out.println("set2size: " + set2.size());

	}

	private static void mutableReduction() {
		// TODO Auto-generated method stub
		System.out.println("mutable red");
		String[] grades = { "A", "A", "B" };
		StringBuilder concat2 = Arrays.stream(grades).parallel().collect(StringBuilder::new, StringBuilder::append,
				StringBuilder::append);
		System.out.println(concat2);
	}

	private static void ovrloadedReductions() {
		// TODO Auto-generated method stub
		System.out.println("overloaded recutions");
		String[] grades = { "A", "B", "C", "D" };
		String concat1 = Arrays.stream(grades).reduce("", (s1, s2) -> s1 + s2);
		System.out.println("concat1 " + concat1);

		// reduce versions
		// if you check the parallel it will give a different result why???
		// because the recue method is doing a mutable reudction
		// the continaer concat2, will be mutated
		// it is not thread safe so you will have to check
		// combining container with itself at the end.
		StringBuilder concat2 = Arrays.stream(grades).parallel().reduce(new StringBuilder(), (sb, s) -> sb.append(s),
				(sb1, sb2) -> sb1.append(sb2));
		System.out.println("concat1 " + concat2);

		StringBuilder concat3 = Arrays.stream(grades).map(s -> new StringBuilder(s)).reduce(new StringBuilder(),
				(sb1, sb2) -> sb1.append(sb2));
		System.out.println("concat3" + concat3);
	}

	private static void reduceImperitively(List<Book> books) {
		// TODO Auto-generated method stub
		System.out.println("reduced imperatively ...");
		Book result = null;
		for (Book book : books) {
			if (result == null) {
				if (book.getRating() >= 4.5) {
					result = book;
				}
				continue;
			}
			if (book.getRating() >= 4.5 && result.getPrice() > book.getPrice()) {
				result = book;
			}
		}
		System.out.println("imperative +" + result);
	}

	private static void reduce(List<Book> books) {
		// TODO Auto-generated method stub
		System.out.println("reduce");
		books.stream().filter(b -> b.getRating() >= 4.5).reduce((b1, b2) -> b1.getPrice() <= b2.getPrice() ? b1 : b2)
				.ifPresent(b -> System.out.println("lowest priced book:" + b));
	}

	private static void find(List<Book> books) {
		System.out.println("inside find");
		/* Optional<Book> result = */books.stream().filter(d -> d.getRating() >= 4.8 && d.getPrice() <= 50).findAny()
				.orElseGet(StreamOperations::getDefault);
		/* ifPresent(StreamOperations::print);; */
		// optional container class, it might have the value present or not.
		// if using parallel stream you should use find any
		// find first will returnt the first
		// find any can be any possible;
		/*
		 * if (result.isPresent()) { System.out.println(result.get()); } else {
		 * System.out.println("not found"); }
		 */
		// books.stream().filter(d -> d.getRating() >= 4.8 && d.getPrice() <=
		// 50).findAny();

	}

	private static void print(Book b) {
		System.out.println(b);
	}

	private static Book getDefault() {
		System.out.println("default");
		return new Book(0, "", 4.0, 25.0, "Amazon");
	}

}