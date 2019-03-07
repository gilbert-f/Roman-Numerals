// Some useful libraries
import uwcse.graphics.*;
import java.awt.Color; // avoid writing java.awt.* since the package has a
// class called Rectangle, which is a name also used
// in uwcse.graphics
import java.awt.Font;

/**
 * CSC 142 - Homework<br>
 * A RomanNumberDisplay has a window that can display a RomanNumber.<br>
 * Buttons allow the user to enter a new number to display, or to add 1 to or
 * subtract 1 from the current number.<br>
 * 
 * Gilbert Febrianto
 */

public class RomanNumberDisplay extends GWindowEventAdapter {
	// By extending GWindowEventAdapter, a RomanNumberDisplay can
	// respond to mouse clicks on a graphics window.

	// Instance fields
	// Graphics window
	private GWindow window;

	// The RomanNumber being displayed
	private RomanNumber rNumber;

	// Add here other instance fields as needed
	private Rectangle plusOneButton, minusOneButton, newNumberButton;

	/**
	 * Create the display
	 */
	public RomanNumberDisplay() {
		// Create the window (change the size if you wish)
		window = new GWindow("Numbers in roman numerals", 700, 200);
		window.setExitOnClose();
		// This RomanNumberDisplay handles the mouse clicks
		window.addEventHandler(this);

		// Buttons...
		// If you find yourself writing lots of line of code in the constructor,
		// move the code into a private method that you call from here.
		draw();

		// Add the RomanNumber rNumber...
		rNumber = new RomanNumber(window);
	}

	/**
	 * A mouse button has been pressed on the window.<br>
	 * Detects the location of the click and take proper action (do nothing or
	 * increment or decrement the number, or input and display a new number).
	 * 
	 * @param e
	 *            the GWindowEvent triggered by the mouse click
	 */
	public void mousePressed(GWindowEvent e) {
		// Locate the click
		int x = e.getX();
		int y = e.getY();

		// Click on the left button?
		if (x >= 100 && x <= 200 && y >= 150 && y <= 175) {
			rNumber.plusOne();
		}
		// (if the left button is "plus one", tell rNumber
		// to increment itself by one: rNumber.addOne();)
		// etc...
		else if (x >= 300 && x <= 400 && y >= 150 && y <= 175) {
			rNumber.minusOne();
		}
		
		else if (x >= 500 && x <= 600 && y >= 150 && y <= 175) {
			rNumber.inputNewNumber();	
		}
		// If you need to update the display, use the method doRepaint() as in
		window.doRepaint();
	}

	/**
	 * Starts the application
	 */
	public static void main(String[] args) {
		// Calls the RomanNumberDisplay
		new RomanNumberDisplay();
	}

	// Add your private methods here
	private void draw() {
		// Creates the buttons and texts for each buttons
		plusOneButton = new Rectangle(100, 150, 100, 25, Color.RED, true);
		TextShape plusOneText = new TextShape("Plus One", 118, 155, Color.WHITE,
				new Font("Times New Romans", Font.BOLD, 14));
		minusOneButton = new Rectangle(300, 150, 100, 25, Color.GREEN, true);
		TextShape minusOneText = new TextShape("Minus One", 310, 155, Color.WHITE,
				new Font("Times New Romans", Font.BOLD, 14));
		newNumberButton = new Rectangle(500, 150, 100, 25, Color.MAGENTA, true);
		TextShape newNumberText = new TextShape("New Number", 503, 155, Color.WHITE,
				new Font("Times New Romans", Font.BOLD, 14));
		
		// Adds the buttons and texts for each buttons
		window.add(plusOneButton);
		window.add(plusOneText);
		window.add(minusOneButton);
		window.add(minusOneText);
		window.add(newNumberButton);
		window.add(newNumberText);
	}
}