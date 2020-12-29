import java.awt.*;
import cs102.*;

/**
 * GUIHangman - GUI based MVC test for cs102 Hangman & IHangmanSetup
 * Improved version of guiHangman
 * @author Turgut
 * @version 1.01 2020/12/2
 */

public class GUIHangman
{
	public GUIHangman()
	{
    	System.out.println( "Start of GUIHangman\n");
		//Creating components of the game
		HangmanModel		hangman;
		IHangmanSetup		basicSetup;
		ConsoleHangmanView	consoleView;
		TextFieldControlPanel fieldControlPanel;
		NewGameButtonControl newGameButton;
		LabelsHangmanView labelView;
		GallowsHangmanView gHangman;
		HangmanLetterButtonControls letterButtons;

		basicSetup = new CountryGameSetup();
		hangman = new HangmanModel( basicSetup );
		fieldControlPanel = new TextFieldControlPanel( hangman );
		newGameButton = new NewGameButtonControl( hangman );
		labelView = new LabelsHangmanView();
		gHangman = new GallowsHangmanView( hangman );
		letterButtons = new HangmanLetterButtonControls( hangman.getAllLetters(), 13, 2 );
		letterButtons.addActionListener( new HangmanLetterButtonsController( hangman ) );

		//Adding the components as a view and to the frame
		consoleView = new ConsoleHangmanView();
		hangman.addView( newGameButton );
		hangman.addView( consoleView );
		hangman.addView( labelView );
		hangman.addView( letterButtons );
		hangman.addView( gHangman );

		new SimpleJFrame( "GUIHangman", 	// title
							gHangman,			// center
							fieldControlPanel, newGameButton,		// north, south
							letterButtons, labelView );	// east, west

		// this is an infinite loop reading from the console... not clever!
		ConsoleControl.controlFor( hangman);
	}

	public static void main( String[] args)
	{
		new GUIHangman();

//		// This is the approved way to initialise GUIs
//		// but won't work with the ConsoleControl as is!
//		// --------------------------------------------
//		SwingUtilities.invokeLater(
//			new Runnable() {
//			    public void run() {
//	        		new GUIHangman();
//	        		new GUIHangman();
//	    		}
//			});
	}

} // end of class GUIHangman
