package com.semanticsquare.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class HttpConnect {
	/**
	 * 
	 * @param destination
	 * @param data
	 * @param partner
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws IllegalArgumentException generatd if destination <0 || destination >1
	 */

	public static String send(int destination, String data, String partner) throws FileNotFoundException, IOException {
		System.out.println("\nInside send ...");
		String response = "success";
		if (destination < 0 || destination > 1) {
			throw new IllegalArgumentException();
		}
		
		if (destination == 0 ) {
			throw new FileNotFoundException();
		} else if (destination == 1) {
			//throw new IOException();
			response = "<result><code>success</code></result>";
		}
		System.out.println("\nEnd of send ...");
		return response;
	}

}
