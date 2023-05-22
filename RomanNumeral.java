/**
 * this package must be imported to access the regex class
 */
import java.util.regex.*;

/**
 * 
 * @author Huzayfah Hayyan Awan
 * this class holds a RomanNumeral object with two properties/attributes (one holds the Roman Numeral as a String; the other holds the Arabic Numeral as an int); this class contains the convertRomanNumToArabicInt method, which performs the numeral conversion
 */
public class RomanNumeral {
    
    /*
     * instance variable storing the Roman Numeral of the instantiated object
     */
    private String romanNumeral;
    /**
     * instance variable storing the Arabic Numeral of the instantiated object \
     */
    private int arabicNumeral;
    
    /**
     * This constructor initializes the instance variables romanNumeral and arabicNumeral 
     * 
     * @param rn The Roman Numeral being instantiated as an object
     */
    public RomanNumeral(String rn) {
        romanNumeral = rn;
        arabicNumeral = convertRomanNumToArabicInt(romanNumeral);
    } // constructor

    /**
     * Converts the Roman Numeral passed in to an Arabic Integer value
     *  
     * @param convertThis The Roman Numeral to be converted to an Arabic Numeral
     * @return conversionResult The Arabic Numeral (integer value) after the Roman Numeral conversion is complete
     */
    public static int convertRomanNumToArabicInt(String convertThis) {
      
    	  /* 
            the conversionResult variable holds the integer value being accumulated as each Roman Numeral in the String gets processed, and the 
            valueOfNumeralToRight variable tracks the value of the numeral to the right so the special case can be tested
	       */
	     int conversionResult = 0;
	     int valueOfNumeralToRight = 0;
	     /* 
	        looping through the Roman Numeral String provided from right-to-left because the special case needs to be considered when the character to the left 
	        has a smaller value than the character to its right
	      */
	     for (int i = (convertThis.length() - 1); i >= 0; i--) {
	         // testing for XLII
	    	 /*
	    	  * if the loop is on the last character (first iteration), then simply add the corresponding integer value of the Roman Numeral
	    	  * character to the conversionResult variable
	    	  */
	    	 if (i == (convertThis.length() - 1)) {
	    		 conversionResult += Project4.romanToArabicMap.get(convertThis.charAt(i));
	    		 /* 
	                 if it's not the last iteration of the Roman Numeral String being processed, then the matched integer value of the current Roman 
	                 Numeral letter is stored in this variable to be used for the next iteration's comparison of letters
                  */
	    		 if (i != 0) valueOfNumeralToRight = Project4.romanToArabicMap.get(convertThis.charAt(i));
	    	 } 
	    	 
	    	 /*
	    	  * if the loop is on a character that isn't the last character of the Roman Numeral and whose corresponding integer value is also
	    	  * less than the integer value of the Roman Numeral character on the right, then subtract the current Roman Numeral character's integer
	    	  * value from the conversionResult variable.
	    	  */
	    	 else if (Project4.romanToArabicMap.get(convertThis.charAt(i)) < valueOfNumeralToRight) {
	    		 conversionResult -= Project4.romanToArabicMap.get(convertThis.charAt(i));
	    		 /* 
	                 if it's not the last iteration of the Roman Numeral String being processed, then the matched integer value of the current Roman 
	                 Numeral letter is stored in this variable to be used for the next iteration's comparison of letters
	    		  */
	    		 if (i != 0) valueOfNumeralToRight = Project4.romanToArabicMap.get(convertThis.charAt(i));
	    	 }
	    	 
	    	 /*
	    	  * if the loop is on a character that isn't the last character of the Roman Numeral and whose corresponding integer value is also
	    	  * greater than or equal to the integer value of the Roman Numeral character on the right, then add the current Roman Numeral character's
	    	  * integer value to the conversionResult variable.
	    	  */
	    	 else if (Project4.romanToArabicMap.get(convertThis.charAt(i)) >= valueOfNumeralToRight) {
	    		 conversionResult += Project4.romanToArabicMap.get(convertThis.charAt(i));
	    		 /* 
	                 if it's not the last iteration of the Roman Numeral String being processed, then the matched integer value of the current Roman 
	                 Numeral letter is stored in this variable to be used for the next iteration's comparison of letters
	              */
	    		 if (i != 0) valueOfNumeralToRight = Project4.romanToArabicMap.get(convertThis.charAt(i));
	    	 }
	         
	     } // outer-loop
     
	     return conversionResult;
    	
    } // method convertRomanNumToArabicInt
    
    /**
     * Compares two RomanNumeral objects to see if they are equal in value, or if one is either less than or greater than the other
     * 
     * @param other The RomanNumeral object getting passed in as an argument for comparison
     * @return 0 if the objects are equal, -1 if the object the method is being applied to is less than the object getting passed in as an argument, and 1 if the object the method is being applied to is less than the object getting passed in as an argument
     */
    public int compareTo(RomanNumeral other) {
        if (this.arabicNumeral == other.arabicNumeral) return 0;
        else if (this.arabicNumeral < other.arabicNumeral) return -1;
        else if (this.arabicNumeral > other.arabicNumeral) return 1;
        return 0;
    } // method compareTo
    
    /**
     * Compares two objects to see if they are equal in value or not 
     * 
     * @param other The object getting passed in as an argument for an equality check
     * @return true if the objects are equal, or false if the objects are not equal
     */
    public boolean equals(Object other) {
        if (other != null && this.getClass().equals(other.getClass()) && this.romanNumeral.equals(((RomanNumeral) other).romanNumeral)) return true;
        return false;
    } // method equals
 
    /**
     * Returns the String representation of the Roman Numeral attribute of the object and the Arabic Numeral attribute of the object
     * 
     * @return The String representation of the object
     */
    public String toString() {
        return "Roman Numeral: " + romanNumeral + "\nArabic Numeral: " + String.valueOf(arabicNumeral);
    } // method toString()
    
    /**
     * Retrieves the Arabic Numeral of the object
     * 
     * @return The Arabic Numeral of the object
     */
    public int getArabicNumeral() {
        return arabicNumeral;
    } // method getArabicNumeral
    
    /**
     * Retrieves the Roman Numeral of the object
     * 
     * @return The Roman Numeral of the object
     */
    public String getRomanNumeral() {
        return romanNumeral;
    } // method getRomanNumeral
    
    /**
     * Replaces the previous String value of romanNumeral with a new valid Roman Numeral String 
     * 
     * @param rn The Roman Numeral replacing the previous String value of the object
     */
    public void setRomanNumeral(String rn) {
    	
        if (!checkRomanNumeral(rn)) throw new IllegalRomanNumeralException("Bad input for Roman Numeral.");
        else romanNumeral = rn;
        
    } // method setRomanNumeral
    
    /**
     * Checks the validity of the Roman Numeral String passed in and throws an exception and prints to the console the invalid Roman Numeral if not valid; otherwise, Roman to Arabic conversion proceeds
     * @param rn The Roman Numeral getting passed in as a string to check for validity
     * @return True or False depending on if the Roman Numeral regex pattern matches the passed-in Roman Numeral String
     */
    public static boolean checkRomanNumeral(String rn) {
    	
    	Pattern p; // stores the compiled version of the regex into an internal format, so the JVM can use it efficiently to match the regex
    	Matcher m; // stores the answer of whether or not the String passed in matches the regex stored in p
    	
    	int rnLength = rn.length();
    	// the pattern is to match the String rn with any character that is either M, D, C, L, X, V, or I exactly the length of String rn times from beginning to end (so each character of rn must match what's in the brackets to be considered a valid Roman Numeral)
    	String romanNumeral_Pattern = "^[MDCLXVI]{" + String.valueOf(rnLength) + "}$"; // regular expression that will be checked against the String passed in for Roman Numeral validity
    	
    	p = Pattern.compile(romanNumeral_Pattern); // compiling the regex so the JVM can check for matching between the String rn and the regex efficiently
    	
    	m = p.matcher(rn); // matches the given regex pattern against the passed-in String rn
    	
    	return m.matches(); // returns either true or false depending on whether or not the String matches the rules of the regex (rules of Roman Numeral validity)
    	
    } // method checkRomanNumeral
    
} // class RomanNumeral
