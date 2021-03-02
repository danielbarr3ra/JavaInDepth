package com.semanticsquare.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionsDemo {
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("\nInside main ...");
		try {
		share();
		System.out.println("Afterinvoiknig share");
		} catch(FileNotFoundException e) {
			System.out.println("main filenoutfound exception");
		} finally {
			System.out.println("Inside mains finally");
		}
		System.out.println("\nEnd of main ...");
	}

	private static void share() throws FileNotFoundException {
		System.out.println("\nInside share ...");
		try {
			String response = HttpConnect.send(1, "Hello", "http://wwww.goodsnips.com");
			APIParser.parseSendResponseCode(response,"hello","http://wwww.goodnsips.com");
		} catch (FileNotFoundException e) {
			System.out.println("share: filenoutfoundexception");
			throw e;
		} catch (IOException e) {

			System.out.println("Connection to a different server...");
		} catch (APIFormatChangeException e){
			//e.printStackTrace();
			//System.out.println("e.toString: "+e);
			//System.out.println("e.getMess: "+ e.getMessage());
			e.getCause().printStackTrace();
			//System.out.println("e. getElementName " + e.getElementName());
		} finally {
			System.out.println("Inside share finally...");
		}
		System.out.println("\nEnd of share ...");
	}
}
