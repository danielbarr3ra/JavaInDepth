import java.util.Arrays;

public class SentimentAnalyzer {
    // Tip: labeled continue can be used when iterating featureSet + convert review to lower-case
	public static int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords, String[] negOpinionWords) {
    int[] featureOpinions = new int[featureSet.length]; // output
    String reviewLowerCase = review.toLowerCase();
    //loop thoruhg each opinion
    for(int feature = 0; feature < featureSet.length; feature ++ ){
      //feature is the index of which feature we are iterating over
      for (String alternateForm : featureSet[feature]) {
        
        int result = getOpinionOnFeature(reviewLowerCase, alternateForm, posOpinionWords, negOpinionWords);
        featureOpinions[feature] = result; 

        if (result == 1 || result == -1){
          break;
        }
      }
    }	
 
		return featureOpinions;
	}

	// First invoke checkForWasPhrasePattern and 
	// if it cannot find an opinion only then invoke checkForOpinionFirstPattern
	private static int getOpinionOnFeature(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
    int resultWasPattern = checkForWasPhrasePattern(review, feature, posOpinionWords, negOpinionWords);
    if (resultWasPattern == 0) {
      return checkForOpinionFirstPattern(review, feature, posOpinionWords, negOpinionWords);
    } else {
      return resultWasPattern;
    }
	}	

	// Tip: Look at String API doc. Methods like indexOf, length, substring(beginIndex), startsWith can come into play
	// Return 1 if positive opinion found, -1 for negative opinion, 0 for no opinion
	// You can first look for positive opinion. If not found, only then you can look for negative opinion
	private static int checkForWasPhrasePattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
		int opinion = 0;
    String pattern = (feature + " was").intern();

    String[] sentences = review.split("\\.");
    for (String sentence : sentences) {
    // feature <first space> was <second space> opinion <third space>
    //extracting string to get
      int locationFeature = sentence.indexOf(feature);
      
      if(locationFeature != -1){ //word is found
        int firstSpace = sentence.indexOf(" ", locationFeature);
        //this checks if the sentence ends 
        int secondSpace = sentence.indexOf(" ", firstSpace+1);
        if (secondSpace == -1 || secondSpace<locationFeature ){
          secondSpace = sentence.length();
        }
        
        int thirdSpace = sentence.indexOf(" ", secondSpace+1);
        if (thirdSpace == -1 || thirdSpace<locationFeature ){
          thirdSpace = sentence.length();
        }
        
        
        //check if the pattern matches
        String featureWas = sentence.substring(locationFeature, secondSpace).intern();
        //System.out.println(featureWas == pattern);
        //System.out.println(feature);
        if(featureWas == pattern){

          String opinionWord = sentence.substring(secondSpace+1,thirdSpace).trim().intern();
          
          if ( checkIfWordIsInSet(opinionWord, posOpinionWords)){
            opinion = 1;
          } else if (checkIfWordIsInSet(opinionWord, negOpinionWords)){
            opinion = -1;
          } 
          return opinion;
        }
      }
    
    }
    return opinion;
	}
	
	// You can first look for positive opinion. If not found, only then you can look for negative opinion
	private static int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
		// Extract sentences as feature might appear multiple times. 
		// split() takes a regular expression and "." is a special character 
		// for regular expression. So, escape it to make it work!!
		String[] sentences = review.split("\\.");
		int opinion = 0;
    
    for (String sentence : sentences) {
      int locationFeature = sentence.indexOf(feature);
      
      if ( locationFeature!= -1) { //feature found in sentence
        //< first space > opinion <locationfeature>  //here is the issue
        int firstSpace = sentence.lastIndexOf(" ", locationFeature-2);
        String opinionWord = sentence.substring(firstSpace+1, locationFeature-1);
        
      
        if (checkIfWordIsInSet(opinionWord, posOpinionWords)){
          opinion = 1;
        } else if (checkIfWordIsInSet(opinionWord, negOpinionWords)){
          opinion = -1;
        } 
        return opinion;
        }
    }
		return opinion;
  }

  private static boolean checkIfWordIsInSet(String key, String[] set){
    for(String word: set) {
      if( key == word || key.indexOf(word) != -1){ //should not use == for strings, use .equals instead
        return true;
      }
    }
    return false;
  }

	public static void main(String[] args) {
		//String review = "I chose two items form the new menu, the srhimp scampi and the shrimp and chicken carbonara, both with my favourite soup and some warm breadsticks. the soup was amazing, as always.";
		
		String review = "Not only was their food delicious, but I must say that the stars are more for the excellent service!";
		
		String[][] featureSet = { 
      { "ambiance", "ambience", "atmosphere", "decor" },
      { "dessert", "ice cream", "desert" }, 
      { "food" }, 
      { "soup" },
      { "service", "management", "waiter", "waitress", "bartender", "staff", "server" } };
    String[] posOpinionWords = { "good", "fantastic", "friendly", "great", "excellent", "amazing", "awesome", "delicious" };
    String[] negOpinionWords = { "slow", "bad", "horrible", "awful", "unprofessional", "poor" };
    
		int[] featureOpinions = detectProsAndCons(review, featureSet, posOpinionWords, negOpinionWords);
    System.out.println("Opinions on Features: " + Arrays.toString(featureOpinions)); 
	}
}