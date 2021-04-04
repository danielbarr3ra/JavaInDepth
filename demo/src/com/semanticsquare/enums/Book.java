package com.semanticsquare.enums;

public class Book {
	public enum BookGenre {
		BIOGRAPHY (12){
			public boolean isKidFriendly(int age) {
				return age >= minAgeToRead;
			}
		}, HORROR (13){
			public boolean isKidFriendly(int age) {
				return false;
			}
		};

		private BookGenre(int minAgeToRead) {
			this.minAgeToRead = minAgeToRead;
		}

		protected int minAgeToRead;

		public int getMinAgeToRead() {
			return minAgeToRead;
		}
		public abstract boolean isKidFriendly(int age);
		/*
		public boolean isKidFriendly(int age) {
			switch (this) {
			case BIOGRAPHY : return age >= minAgeToRead;
			case HORROR : return false;
			}
			return false;
		}
		*/

	}

	public static void main(String[] args) {
		for (BookGenre bookGenre : BookGenre.values()) {
			System.out.println("\nName" + bookGenre);
			System.out.println("name()" + bookGenre.name());
			System.out.println("Ordinal" + bookGenre.ordinal());
			System.out.println("getdeclaringclass()" + bookGenre.getDeclaringClass());
			System.out.println("comapreTo" + bookGenre.compareTo(BookGenre.HORROR));
			System.out.println("equals" + bookGenre.equals(BookGenre.HORROR));
			System.out.println("min age to read" + bookGenre.getMinAgeToRead());
			System.out.println("is kid firendly" + bookGenre.isKidFriendly(25));
		}

	}

}