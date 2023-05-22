/**
 * this package must be imported to access the ActionListener interface
 */
import java.awt.event.*;
/**
 * this package must be imported to access the File class -> chooser.getSelectedFile() returns a File, which gets sent into the readSource method, so this is necessary
 */
import java.io.File;

/**
 * this package must be imported to access the JFileChooser class to allow users to choose a file from their system/computer
 */
import javax.swing.JFileChooser;

/**
 * 
 * @author Huzayfah Hayyan Awan
 * this class handles the events of the items from the drop-down menu of "File" being clicked within the GUI
 * implement ActionListener, which is an interface containing the actionPerfomed method heading (in this class actionPerfomed method is provided and defined, so something could happen when a menuItem within the GUI being handled is clicked
 */
public class FileMenuHandler implements ActionListener {
	
	/**
	 * keeps track of how many times "Open" was clicked to display new content to the GUI (if value is more than 1, then wipe out the GUI's contents first before appending new contents to the GUI text areas)
	 */
	public static int howManyTimesClicked = 0;
	
	/**
	 * this instance variable of the FileMenuHandler class stores the current GUI object that the FileMenuHandler should be associated with
	 */
	public RomanNumeralGUI JFrameBeingDealtWith;
	/**
	 * This constructor sets the instance variable JFrameBeingDealtWith to the current GUI object that the FileMenuHandler is dealing with or handling
	 * @param jf The GUI object that the FileMenuHandler object should correspond to
	 */
	public FileMenuHandler(RomanNumeralGUI jf) {
		JFrameBeingDealtWith = jf;
	} // constructor
	
	/**
	 * @param event The event that has just occurred within the GUI (example: a click)
	 */
	public void actionPerformed(ActionEvent event) {
	
		String menuItemName; // stores the name of the menuItem clicked within the GUI
		menuItemName = event.getActionCommand(); // Returns the command String associated with the event that has just occurred, in this project, the event would be a click within the GUI
		if (menuItemName.equals("Open")) {
			howManyTimesClicked++;
			if (howManyTimesClicked > 1) {
				/*
				 resetting the text areas of each column of the GUI
				 */
				Project4.romanNumeralsColumn.setText("");
				Project4.sortedArabicNumeralsColumn.setText("");
				Project4.sortedRomanToArabicMap.clear();
			}
			openFile(); // if the command String above equals "Open", the openFile() method from the main class Project3 is called
		}
		else if (menuItemName.equals("Quit")) System.exit(0);
	
	} // method actionPerformed
	
	/**
     * allows the user to choose a file from their system/computer and then passes the selected file into the readSource() method as a File object
     */
    private void openFile() {
    	
    	int status;
    	JFileChooser chooser = new JFileChooser(); // creating a JFileChooser object allows the user to choose a file from their system/computer
    	status = chooser.showOpenDialog(null); // shows dialog on-screen telling the user to choose a file from their system/computer
    	readSource(chooser.getSelectedFile()); // returns the selected file of the user from their system/computer as a File object, which then gets passed in to the readSource method
    
    } // method openFile
    
    /**
     * gets the name and absolute path of the user-selected file and instantiates a TextFileInput object for the chosen file so its contents can be read later on
     * @param chosenFile The file selected by the user from the system/computer
     */
    private void readSource(File chosenFile) {
    	
    	String chosenFileName = chosenFile.getAbsolutePath(); // gets the name of the user-selected file and its absolute path and stores the name of the text file as a String
    	/**
    	 * instantiates a TextFileInput object and passes in the text file name, so the file's content can be read-in later
    	 */
    	TextFileInput fileName = new TextFileInput(chosenFileName);
    	Project4.readNumeralsFromFileAndPlaceIntoTreeMap(fileName);
    	
    } // method readSource
	
} // class FileMenuHandler
