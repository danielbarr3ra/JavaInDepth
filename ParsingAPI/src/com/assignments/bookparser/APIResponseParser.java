package com.assignments.bookparser;
public class APIResponseParser {
    
     /**
	 * Parses the input text and returns a Book instance containing
	 * the parsed data. 
	 * @param response text to be parsed
	 * @return Book instance containing parsed data
	 */
     public static Book parse(String response) {
        Book book = new Book();
		String endRule = "<";
		
		String startRule = "<title>";		
		String title = parse(response, startRule, endRule); 
	    book.setTitle(title);
		
	    startRule = "<name>";		
		String author = parse(response, startRule, endRule); 
	    book.setAuthor(author);
	    
	    startRule = "<original_publication_year type=\"integer\">"; //change to int
	    String pubYearString = parse(response, startRule, endRule);
	    int pubYear = Integer.parseInt(pubYearString);
	    book.setPublicationYear(pubYear);
	    
	    startRule = "<average_rating>"; //change to double
	    String averageRatingString = parse(response,startRule,endRule);
	    double averageRating = Double.parseDouble(averageRatingString);
	    book.setAverageRating(averageRating);
	    
	    startRule = "<ratings_count type=\"integer\">"; //strip from commas
	    String ratingCountString = parse(response,startRule,endRule);
	    int ratingCount = Integer.parseInt(ratingCountString.replace(",",""));
	    book.setRatingsCount(ratingCount);
	    
	    startRule = "<image_url>";
	    String imageUrl = parse(response,startRule,endRule);
	    book.setImageUrl(imageUrl);
	    
		return book;
     }
     
     private static String parse(String response, String startRule, String endRule) {
		// TODO Auto-generated method stub 
    	int start = response.indexOf(startRule);
 		int end = response.indexOf(endRule, start+startRule.length());
 		String result = response.substring(start+startRule.length(), end);
		return result;
	}

	// write overloaded parse method with the 3 parameters response, startRule, endRule
     
     
     public static void main(String[] args) {
		/*String response = "<work>" + 
	                            "<id type=\"integer\">2361393</id>" +
	                            "<books_count type=\"integer\">813</books_count>" +
	                            "<ratings_count type=\"integer\">1,16,315</ratings_count>" + 
	                            "<text_reviews_count type=\"integer\">3439</text_reviews_count>" +
	                            "<original_publication_year type=\"integer\">1854</original_publication_year>" +
								"<original_publication_month type=\"integer\" nil=\"true\"/>" +
								"<original_publication_day type=\"integer\" nil=\"true\"/>" +
								"<average_rating>3.79</average_rating>" +
								"<best_book type=\"Book\">" +
									"<id type=\"integer\">16902</id>" +
									"<title>Walden</title>" + 
									"<author>" +
										"<id type=\"integer\">10264</id>" + 
										"<name>Henry David Thoreau</name>" + 
									"</author>" +
									"<image_url>" + 
										"http://images.gr-assets.com/books/1465675526m/16902.jpg" +
									"</image_url>" +
									"<small_image_url>" + 
										"http://images.gr-assets.com/books/1465675526s/16902.jpg" +
									"</small_image_url>" +
								"</best_book>" +
							"</work>";
		*/
		
//		Book aBook = parse(response);
//		System.out.println(aBook.getTitle());
//		System.out.println(aBook.getAuthor());
//		System.out.println(aBook.getPublicationYear());
//		System.out.println(aBook.getAverageRating());
//		System.out.println(aBook.getRatingsCount());
//		System.out.println(aBook.getImageUrl());
	}
}