/**
* Project #4 stores Roman Numerals and their corresponding Arabic values in a Hashmap and performs conversions between the two types. Also, a TreeMap is used to sort the Arabic values. Finally, Roman Numerals and their corresponding Arabic values are displayed in a GUI.
* Lab Section: CSCI 212 11A
* @author  Huzayfah Hayyan Awan
* @version 1.0
* @since   2023-05-05
*/

/**
 * must be imported to access the Container class
 */
import java.awt.Container;
/**
 * must be imported to access the Container class
 */
import java.awt.TextArea;
import java.io.File;
/**
 * must be imported to access the Container class
 */
import java.util.*;

/**
 * must be imported to access the JFileChooser class
 */
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * 
 * @author Huzayfah Hayyan Awan
 * MAKE THE GUI WINDOW BIGGER AFTER OPENING A FILE TO SEE THE CHANGES! This class is where the main program is located
 *
 */

public class Project4 {
    
    /**
     * creates a GUI object using the RomanNumeralGUI class which extends the JFrame class
     */
    private static RomanNumeralGUI numeralsRomanArabicGUI;
    /**
     * creates a GUI container to store the Roman and Arabic Numerals inside
     */
    private static Container numeralsContentPane;
    /**
     * a text area to hold all of the Roman Numerals from the file that is opened within the GUI
     */
    public static TextArea romanNumeralsColumn;
    /**
     * a text area to hold all of the Arabic Numerals from the file that is opened within the GUI in a sorted format
     */
    public static TextArea sortedArabicNumeralsColumn;
    
    /**
     * creates a StringTokenizer object to tokenize each read-in line from the file into tokens (sub-strings)
     */
    private static StringTokenizer tokenizedLineOfNumerals;
    /**
     * this String holds the current token inside of the tokenizedLineOfNumerals
     */
    private static String currentToken;
    
    /** 
     * holds the String of Roman Numerals read-in from the file
     */
    private static String lineOfRomanNumerals;
    
    /**
     * this RomanNumeral object holds the Roman Numeral just read-in from the text file opened within the GUI and has String and int attributes which represent the Roman Numeral as a roman numeral using letters and an arabic numeral using numbers
     */
    private static RomanNumeral romanNumeral;
    
    /**
     * the HashMap stores each Roman Numeral letter and its corresponding Arabic value to perform conversions on
     */
    public static HashMap<Character, Integer> romanToArabicMap;
    /**
     * the TreeMap stores RomanNumeral objects and compares the Arabic values of each RomanNumeral object to sort the Arabic values from least to greatest
     */
    public static TreeMap<RomanNumeral, Integer> sortedRomanToArabicMap;

    /**
     * Calls the methods to initialize the GUI and TextFile variables, read numerals from the file and place them into lists, and print the contents of those lists
     * 
     * @param args The command-line arguments passed in are stored in this array
     */
    public static void main(String[] args) {
        
        initializeGUIandMaps();
       
    } // main
    
    /**
     * Instantiates a new UnSortedRomanNumeralList object and new SortedRomanNumeralList object (which both extend class RomanNumeralList), 
     * and initializes the GUI's title, size, content-pane, and sets the grid layout to one row and three columns
     */
    private static void initializeGUIandMaps() {
        
        numeralsRomanArabicGUI = new RomanNumeralGUI("Sorted vs. Unsorted Roman-Arabic Numerals", 400, 200, 100, 100);
        numeralsContentPane = numeralsRomanArabicGUI.getContentPane();
        romanNumeralsColumn = new TextArea();
        sortedArabicNumeralsColumn = new TextArea();
        romanToArabicMap = new HashMap<Character, Integer>();
        sortedRomanToArabicMap = new TreeMap<RomanNumeral, Integer>(new RomanNumeralComparator());
        romanToArabicMap.put('I', 1);
    	romanToArabicMap.put('V', 5);
    	romanToArabicMap.put('X', 10);    	
    	romanToArabicMap.put('L', 50);  
    	romanToArabicMap.put('C', 100);  
    	romanToArabicMap.put('D', 500);  
    	romanToArabicMap.put('M', 1000);
    	numeralsContentPane.add(romanNumeralsColumn);
    	numeralsContentPane.add(sortedArabicNumeralsColumn);
        
    } // method initializeGUIandFile

    /**
     * Reads each line of Roman Numerals from the input file, tokenizes them into tokens (sub-strings) separated by commas, appends each token (Roman Numeral)
     * of the current tokenized line of Roman Numerals into the Roman Numerals column of the GUI, and places each token (Roman Numeral) of the current tokenized
     * line of Roman Numerals into the unSortedArabicNumerals and sortedArabicNumerals Linked Lists
     */
    public static void readNumeralsFromFileAndPlaceIntoTreeMap(TextFileInput numeralsFile) {
        
        lineOfRomanNumerals = numeralsFile.readLine(); // read-in the first line from the file of Roman numerals
        /* 
           tokenizes the read-in line of Roman Numerals separated by commas from the file into tokens, or sub-strings, if the read-in line is not equal to null
         */
        if (lineOfRomanNumerals != null) tokenizedLineOfNumerals = new StringTokenizer(lineOfRomanNumerals, ",");
        /*
           tells the user that there are no numerals to display if the first line of the file is null
         */
        else numeralsRomanArabicGUI.setTitle("Empty File - No Numerals to Display!");
        
        while (lineOfRomanNumerals != null) { // loops until there are no more Roman numerals to read-in from the file
            try {
	            currentToken = tokenizedLineOfNumerals.nextToken(); // stores the current token (Roman Numeral) of the read-in line in the currentToken variable
	            if (!RomanNumeral.checkRomanNumeral(currentToken.toUpperCase())) throw new IllegalRomanNumeralException("Bad Roman Numeral in the current line read-in from the text file!");
	             // appends the first token in the read-in line to the Roman Numerals Column in the GUI
	            romanNumeral = new RomanNumeral(currentToken); // instantiates a RomanNumeral object passing in the current token (Roman Numeral) of the read-in line
	            sortedRomanToArabicMap.put(romanNumeral, romanNumeral.getArabicNumeral());	            
            }
            catch (IllegalRomanNumeralException e) {
            	JOptionPane.showMessageDialog(null, "Invalid Roman Numeral! I will skip the invalid Roman Numeral in the current line of the file and print it to the console instead.");
				System.out.println(currentToken);
            }
            finally {
            	if (tokenizedLineOfNumerals.hasMoreTokens()) continue; // if the tokenized line read-in from the file has more tokens to display, then the while-loop continues and waits until there are no more tokens left before reading the next line of the file
	            else {
	                lineOfRomanNumerals = numeralsFile.readLine(); // read-in the next line of Roman numerals from the file
	                if (lineOfRomanNumerals != null) tokenizedLineOfNumerals = new StringTokenizer(lineOfRomanNumerals, ",");
	            }
            }
        } // while-loop
        appendSortedArabicValuesFromTreeMapToGUI();
        
    } // method readandDisplayNumeralsFromFileToGUI
    
    /**
     * this method appends the sorted Arabic values from the TreeMap to the sorted Arabic Numeral column of the GUI
     */
    public static void appendSortedArabicValuesFromTreeMapToGUI() {
    	Iterator itr = sortedRomanToArabicMap.entrySet().iterator();
    	Map.Entry<RomanNumeral, Integer> me;
    	while (itr.hasNext()) {
    		me = (Map.Entry)itr.next();
    		romanNumeralsColumn.append(me.getKey() + "\n");
    		sortedArabicNumeralsColumn.append(me.getValue() + "\n");
    	}
    }
    
} // class Project4
