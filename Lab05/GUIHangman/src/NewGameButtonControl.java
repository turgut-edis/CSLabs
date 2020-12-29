import cs102.Hangman;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class creates a new game button for the gui of the game
 * @author Turgut Alp Edis
 * date: 2/12/20
 */
public class NewGameButtonControl extends JButton implements ActionListener, IHangmanView {

    //Properties
    Hangman hangman;

    //Constructors

    /**
     * This constructor creates new game button with given hangman game
     * @param hangman the hangman game to be controlled
     */
    public NewGameButtonControl( Hangman hangman){
        super("New Game");
        this.hangman = hangman;
        addActionListener( this );
        setEnabled( false );
    }

    //Methods
    @Override
    public void actionPerformed(ActionEvent e) {
        hangman.initNewGame();
        setEnabled( false );
    }

    @Override
    public void updateView(Hangman hangmanModel) {
        //If the game is over, the button set enabled
        if ( hangman.isGameOver())
        {
            setEnabled(true);
        }
    }
}
