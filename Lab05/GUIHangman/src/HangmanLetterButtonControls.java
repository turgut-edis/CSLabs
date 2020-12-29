import cs102.Hangman;

import java.awt.*;

/**
 * This class specifies the letter buttons according to the situation of the game
 * @author Turgut Alp Edis
 * date: 2/12/20
 */
public class HangmanLetterButtonControls extends LetterButtonControls implements IHangmanView {

    //Properties

    //Constructors

    /**
     * This constructor creates the letter buttons
     * @param letters the letters wanted to be used in the game
     */
    public HangmanLetterButtonControls(String letters) {
        super(letters);
    }

    /**
     * This constructor creates the letter buttons and setting their size so that all buttons have the size 50x50
     * @param letters the letters wanted to be used in the game
     * @param rows the row count
     * @param cols the column count
     */
    public HangmanLetterButtonControls(String letters, int rows, int cols) {
        super(letters, rows, cols);
        setPreferredSize( new Dimension( cols * 50, rows * 50 ) );
    }

    @Override
    public void updateView(Hangman hangmanModel) {

        //Initially, all buttons are enabled and after the end of the game, they are disabled
        setEnabledAll( true );
        if ( hangmanModel.isGameOver() )
        {
            super.setEnabledAll( false );
        }
        else
        {
            super.setDisabled( hangmanModel.getUsedLetters() );
        }
    }
}
