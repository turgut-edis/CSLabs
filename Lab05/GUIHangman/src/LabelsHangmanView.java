import cs102.Hangman;
import javax.swing.*;
import java.awt.*;

/**
 * This class creates a label for some important info about the game
 * @author Turgut Alp Edis
 * date: 2/12/20
 */
public class LabelsHangmanView extends JPanel implements IHangmanView {

    //Properties
    JLabel knownSoFar, incorrectTries, usedWords, secretWord, isGameOver;
    Font labelFont = new Font( "Times New Roman" , Font.PLAIN , 20 );

    //Constructors

    /**
     * This constructor creates LabelsHangmanView panel and stores the labels in it
     */
    public LabelsHangmanView()
    {
        //Set the size of the panel
        setPreferredSize( new Dimension( 250,300 ) );

        setBackground( Color.green );

        //Initializing labels
        knownSoFar = new JLabel("");
        incorrectTries = new JLabel("");
        usedWords = new JLabel("");
        secretWord = new JLabel("");
        isGameOver = new JLabel("");

        //Setting fonts for each label
        knownSoFar.setFont( labelFont );
        incorrectTries.setFont( labelFont );
        usedWords.setFont( labelFont );
        secretWord.setFont( labelFont );
        isGameOver.setFont( labelFont );

        //Setting layout and adding the labels according to the layout
        setLayout( new GridLayout(5,1) );
        add( knownSoFar );
        add( incorrectTries );
        add( usedWords );
        add( isGameOver );
        add( secretWord );

    }

    //Methods

    @Override
    public void updateView( Hangman hangman )
    {
        //Setting the labels according to the properties of the game
        //and secretWord is setting in the end of the game
        knownSoFar.setText( hangman.getKnownSoFar() );
        incorrectTries.setText( "Tries: " + hangman.getNumOfIncorrectTries() );
        usedWords.setText( "Used letters: " + hangman.getUsedLetters() );
        isGameOver.setText(" Game Over: " + hangman.isGameOver() );
        secretWord.setText("");

        //if the game is over, the labels set according to win or lose of the game
        if ( hangman.isGameOver() )
        {
            //If the game is lost, the labels are set as below
            if ( hangman.hasLost() )
            {
                knownSoFar.setText( "Oops" );
                incorrectTries.setText( "You lost!" );
                usedWords.setText( "You used: " + hangman.getUsedLetters() );
                isGameOver.setText( "Game Over" );
                secretWord.setText("The word is : " + hangman.getKnownSoFar() );
            }
            //If the game is won, the labels are set as below
            else
            {
                knownSoFar.setText( "Congratulations. You won!!!" );
                incorrectTries.setText( "Just in " + hangman.getNumOfIncorrectTries() + " incorrect tries!!" );
                usedWords.setText( "You used: " + hangman.getUsedLetters() );
                isGameOver.setText( "Game Over" );
                secretWord.setText( "The word is : " + hangman.getKnownSoFar() );
            }
        }
    }

}
