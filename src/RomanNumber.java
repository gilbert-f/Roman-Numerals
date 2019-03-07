// Some useful libraries
import uwcse.graphics.*;
import uwcse.io.*;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 * CSC 142 - Homework<br>
 * A RomanNumber is the representation in decimal and Roman numerals of an
 * integer between 1 and 3000.<br>
 * The number is displayed in a graphics window.<br>
 * A RomanNumber can be incremented, decremented or changed via interactive
 * input.
 * 
 * Gilbert Febrianto
 */
public class RomanNumber {

	/** Maximum number that can be displayed */
	public static final int MAX_NUMBER = 3000;

	// instance fields
	private TextShape text; // The label to display the number (center it in the
							// window)

	private Font font; // Font used to display the number

	private GWindow window; // the window this RomanNumber belongs to

	private String sNumber; // The text to write in the TextShape (e.g. 18 =
							// XVIII)

	private int dNumber; // the number to display and x-coordinate of the text

	/**
	 * Creates the display of a number in Roman numerals in a given graphics
	 * window.<br>
	 * The number is given via interactive input by the user
	 * 
	 * @param window
	 *            the graphics window that displays the roman number.
	 */
	public RomanNumber(GWindow window) {
		// This RomanNumber is displayed in the GWindow window
		this.window = window;

		// Create the font for the TextShape
		font = new Font("Times New Roman",Font.BOLD, 50);
		// e.g. font = new Font("Courier",Font.BOLD,50);
		
		// Create the text for the roman numerals
		text = new TextShape("", 0, 0, Color.BLACK, font);
		window.add(text);

		// Ask for the number and display it
		// (to do so, you might want to call other methods in the class)
		inputNewNumber();
	}

	/**
	 * Changes this RomanNumber to the new value given interactively by the
	 * user.<br>
	 * If the value given by the user is invalid, display an error message and
	 * don't change the display.
	 */
	public void inputNewNumber() {
		// Asks the user for input
		Input inputInteger = new Input();
		// Initialize the value for dNumber
		dNumber = inputInteger.readIntDialog("Enter an integer from 1 to 3000");
		// Goes into the statement if the input number is more than 0 and less or equal to
		// 3000
		if (dNumber > 0 && dNumber <= MAX_NUMBER) {
			// calls the convertToString with dNumber as the parameter
			convertToString(dNumber);
		}
		// Goes into the statement when dNumber is else
		else {
			// Shows error warning
			JOptionPane.showMessageDialog(null, "Invalid Number", "Input Error",
					JOptionPane.WARNING_MESSAGE);
			// calls the inputNewNumber() method again
			inputNewNumber();
		}
	}

	/**
	 * Adds one to this RomanNumber (if < MAX_NUMBER).
	 */
	public void plusOne() {
		// Goes into the statement if the dNumber is less than 3000
		if (dNumber < MAX_NUMBER){
			// Increments the dNumber by one
			dNumber += 1;
			// Calls the convertToString with dNumber as the parameter
			convertToString(dNumber);
		}
	}

	/**
	 * Subtracts one from this RomanNumber (if > 1)
	 */
	public void minusOne() {
		// Goes into the statement if the input number is more than 1
		if (dNumber > 1){
			// Decrements the dNumber by one
			dNumber -= 1;
			// Calls convertToString with dNumber as the parameter
			convertToString(dNumber);
		}
	}
	
	// Private void method converToString to convert the integer input to string with dNumber
	// as the parameter
	private void convertToString(int dNumber){
		// Initialize the sNumber
		sNumber = dNumber + " = ";
		// Finds the value of thousands place of the integer 
		int nThousands = dNumber / 1000;
		// Converts the integer to roman by calling the convertToRoman method
		String sThousands = convertToRoman(nThousands, ' ', ' ', 'M');
		// Finds the value of hundreds place of the integer 
		int nHundreds = dNumber / 100 % 10;
		// Converts the integer to roman by calling the convertToRoman method
		String sHundreds = convertToRoman(nHundreds, 'M', 'D', 'C');
		// Finds the value of tens place of the integer 
		int nTens = dNumber / 10 % 10;
		// Converts the integer to roman by calling the convertToRoman method
		String sTens = convertToRoman(nTens, 'C', 'L', 'X');
		// Finds the value of ones place of the integer 
		int nOnes = dNumber % 10;
		// Converts the integer to roman by calling the convertToRoman method
		String sOnes = convertToRoman(nOnes, 'X', 'V', 'I');
		// Appends the sNumber by adding the strings of thousands , hundreds, tens, 
		// and ones places
		sNumber += sThousands + sHundreds + sTens + sOnes;
		// Finds the stringLength of to center the conversion
		double stringLength = (double) (sNumber.length() / 2.0 * 30);
		// Initializes the xCoordinate for the text
		int xCoordinate = (int) (350 - stringLength);
		// Sets the text to sNumber
		text.setText(sNumber);
		// Moves the coordinates of the text
		text.moveTo(xCoordinate, 50);
	}
	
	// Private convertToRoman method to find the roman numerals
	private String convertToRoman(int nPlace, char tens, char fives, 
			char ones){
		// Initializes the roman string
		String roman = "";
		// Switch statement with nPlace as the parameter
		switch(nPlace){
		// For each of the numbers adds the tens, fives, and ones
		case 1:
		roman += ones;
		break;
		case 2:
		roman += ones;
		roman += ones;
		break;
		case 3:
		roman += ones;
		roman += ones;
		roman += ones;
		break;
		case 4:
		roman += ones;
		roman += fives;
		break;
		case 5:
		roman += fives;
		break;
		case 6:
		roman += fives;
		roman += ones;
		break;
		case 7:
		roman += fives;
		roman += ones;
		roman += ones;
		break;
		case 8:
		roman += fives;
		roman += ones;
		roman += ones;
		roman += ones;
		break;
		case 9:
		roman += ones;
		roman += tens;
		break;
		case 10:
		roman += tens;
		break;
		default:
		break;
		}
		// Returns the roman string
		return roman ;
	}
}