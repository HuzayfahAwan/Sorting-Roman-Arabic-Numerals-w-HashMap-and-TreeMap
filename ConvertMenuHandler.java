/**
 * this package must be imported to access the ActionListener interface
 */
import java.awt.event.*;

/**
 * this package must be imported to access the JOptionPane class
 */
import javax.swing.*;

/**
 * 
 * @author Huzayfah Hayyan Awan
 * this class handles all events when "File" from the GUI menu bar is clicked on by the user
 * implement ActionListener, which is an interface containing the actionPerfomed method heading (in this class actionPerfomed method is provided and defined, so something could happen when a menuItem within the GUI being handled is clicked
 */
public class ConvertMenuHandler implements ActionListener {
	
	private String userInput = ""; // stores the user's inputted Roman Numeral from the JOptionPane
	
	/**
	 * this instance variable of the FileMenuHandler class stores the current GUI object that the FileMenuHandler should be associated with
	 */
	public RomanNumeralGUI JFrameBeingDealtWith;
	/**
	 * This constructor sets the instance variable JFrameBeingDealtWith to the current GUI object that the FileMenuHandler is dealing with or handling
	 * @param jf The GUI object that the FileMenuHandler object should correspond to
	 */
	public ConvertMenuHandler(RomanNumeralGUI jf) {
		JFrameBeingDealtWith = jf;
	} // constructor
	
	/**
	 * @param event The event that has just occurred within the GUI (example: a click)
	 */
	public void actionPerformed(ActionEvent event) {
		
		while (userInput != "STOP") {
			try {
				userInput = JOptionPane.showInputDialog(null, "Enter a Roman Numeral and I will give its corresponding Arabic Numeral (enter \"stop\" to end): ").toUpperCase();
				if (userInput.equals("STOP")) System.exit(0);
				else if (!RomanNumeral.checkRomanNumeral(userInput)) throw new IllegalRomanNumeralException("Bad Input for Roman Numeral!");
				JOptionPane.showMessageDialog(null, "The Arabic Numeral Counterpart of the Roman Numeral " + userInput + " is: " + RomanNumeral.convertRomanNumToArabicInt(userInput));
			}
			catch (IllegalRomanNumeralException e) {
				JOptionPane.showMessageDialog(null, "Invalid Roman Numeral! Please try again.");
				System.out.println(userInput);
			}
		}
		
		
	} // actionPerformed
	
} // class ConvertMenuHandler