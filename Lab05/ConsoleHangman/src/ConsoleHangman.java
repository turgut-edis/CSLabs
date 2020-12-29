import java.util.Scanner;

/**
 * ConsoleHangman
 *
 * @author Turgut Alp Edis
 * @version 1.01 2020/12/1
 */

public class ConsoleHangman
{
    public static void main( String[] args)
	{
    	Scanner scan = new Scanner( System.in);

    	System.out.println( "Start of ConsoleHangman\n");

		// VARIABLES
		HangmanModel model;
		ConsoleHangmanView view, view1;
		char letter;

		// PROGRAM CODE
		model = new HangmanModel( new CountryGameSetup() );
		view = new ConsoleHangmanView();
		view1 = new ConsoleHangmanView();

		model.addView( view );
		model.addView( view1 );
		view.updateView( model );
		view1.updateView( model );

		// ToDo - allow user to repeatedly enter a letter and tryThis letter
		//		  then show game status, until gameover. Finally report win/lose.


		do {
			System.out.println("Please enter a char");
			letter = scan.next().charAt(0);
			model.tryThis( letter );
			view.updateView( model );
			view1.updateView( model );
		} while ( !model.isGameOver() );

		if ( model.hasLost() )
			System.out.println( "You lost ");
		else
			System.out.println("You win");

		System.out.println( "\nEnd of ConsoleHangman\n" );
	}

} // end of class ConsoleHangman
