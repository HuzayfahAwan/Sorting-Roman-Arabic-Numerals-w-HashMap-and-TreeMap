/**
 *  this package must be imported to be able to use the GridLayout class
 */
import java.awt.*;
/**
 * this package must be imported to be able to extend the JFrame class to the RomanNumeralGUI class
 */
import javax.swing.*;
/**
 * this package must be imported to be able to use the JMenu class
 */
import javax.swing.*;

/**
 *  this class extends class JFrame and contains a constructor that gets information passed in to it, so the JFrame can be initialized
 * @author Huzayfah Hayyan Awan
 *
 */
public class RomanNumeralGUI extends JFrame {
    
    /**
     * this constructor is called when a new object is instantiated and using the arguments passed-in, initializes the Roman-Arabic Numerals Conversion GUI
     * @param title The title of the GUI
     * @param height The height of the GUI
     * @param width The width of the GUI
     * @param horizDistance The horizontal distance of where the GUI is set
     * @param vertDistance The vertical distance of where the GUI is set
     */
    public RomanNumeralGUI(String title, int height, int width, int horizDistance, int vertDistance) {
        
        setTitle(title);
        setSize(height, width);
        setLocation(horizDistance, vertDistance);
        setLayout(new GridLayout(1, 2));
        createMenu();
        setDefaultCloseOperation(RomanNumeralGUI.EXIT_ON_CLOSE);
        setVisible(true);
        
    } // constructor
    
    /**
     * creates the menu and all of its components and puts it inside of the GUI
     */
    private void createMenu() {
    	JMenuBar menuBar = new JMenuBar(); // creates the menu bar
    	JMenu fileMenu = new JMenu("File"); // creates one of the "bars" of the menu bar, which will be named "File"
    	JMenu convertMenu = new JMenu("Convert"); // creates one of the "bars of the menu bar, which will be named "Convert"
    	JMenuItem item; // stores a bar that can be accessed (as part of a drop-down menu) when the File bar is clicked on within the GUI
    	FileMenuHandler fmh = new FileMenuHandler(this); // passes in the GUI object that should correspond with the FileMenuHandler
    	ConvertMenuHandler cmh = new ConvertMenuHandler(this); // passes in the GUI object that should correspond with the FileMenuHandler
    	item = new JMenuItem("Open"); // creates one of the bars of the drop-down menu of "File" which will be named "Open"
    	item.addActionListener(fmh); // adds an action listener to the current MenuItem "Open" and its associated event-handler -> the FileMenuHandler object fmh, which corresponds with the GUI object
    	fileMenu.add(item); // adds the JMenuItem "Open" to the drop-down menu of "File"
    	fileMenu.addSeparator(); // adds a separator between the bars of the "File" drop-down menu
    	item = new JMenuItem("Quit"); // rewriting what is stored in the item variable; creates one of the bars of the drop-down menu of "File" which will be named "Quit"
    	item.addActionListener(fmh); // adds an action listener to the current MenuItem "Quit" and its associated event-handler -> the FileMenuHandler object fmh, which corresponds with the GUI object
    	fileMenu.add(item); // adds the JMenuItem "Quit" to the drop-down menu of "File"
    	menuBar.add(fileMenu); // adds the completed "File" bar (with all of its drop-down bars as well) to the menuBar of the GUI
    	item = new JMenuItem("Roman to Arabic");
    	item.addActionListener(cmh);
    	convertMenu.add(item);
    	menuBar.add(convertMenu);    	
    	setJMenuBar(menuBar); // puts the menuBar inside of the GUI
    }
    
} // class RomanNumeralGUI
