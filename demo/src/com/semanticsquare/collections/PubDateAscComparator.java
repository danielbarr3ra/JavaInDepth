package com.semanticsquare.collections;

import java.util.Comparator;

public class PubDateAscComparator implements Comparator {

	public int compare (Object o1, Object o2) {
		// TODO Auto-generated method stub
		int o1_year = ((Book)o1).getYear();
		int o2_year = ((Book)o2).getYear();
		if (o1_year == o2_year) {
			return ((Book)o1).compareTo((Book)o2);
		} else {
			return (o1_year>o2_year)?1:-1;
		}
	}
}