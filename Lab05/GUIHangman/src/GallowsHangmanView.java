import cs102.Hangman;

import javax.swing.*;
import java.awt.*;

/**
 * This class draws a gallows hangman view of the hangman game
 * @author Turgut Alp Edis
 * date: 2/12/20
 */
public class GallowsHangmanView extends JPanel implements IHangmanView {

    //Properties

    HangmanModel hmModel;
    JLabel winLost, secretWord;
    JPanel labels;

    //Set font for the labels in the panel
    Font labelFont = new Font( "Times New Roman" , 8 , 20 );

    //Constructors

    /**
     * This constructor creates a new GallowsHangmanView object with an instance of HangmanModel
     * and sets the properties of this panel
     * @param hmModel the HangmanModel object
     */
    public GallowsHangmanView( HangmanModel hmModel )
    {
        this.hmModel = hmModel;
        setBackground(Color.blue);
        setLayout( new BorderLayout() );
        setPreferredSize( new Dimension( 500, 300 ) );
        createLabels();
    }

    //Methods

    /**
     * This method creates labels for showing win lose situation and secretword
     * at the end of the game
     */
    public void createLabels()
    {
        //Constructing label panel holding labels
        labels = new JPanel();
        //Setting it
        labels.setLayout( new BorderLayout() );
        labels.setBackground(Color.blue);
        labels.setPreferredSize( new Dimension(50,60) );

        //Creating labels
        winLost = new JLabel( "", JLabel.CENTER );
        secretWord = new JLabel( "", JLabel.CENTER );

        //Setting labels
        winLost.setFont( labelFont );
        secretWord.setFont( labelFont );
        winLost.setForeground(Color.white);
        secretWord.setForeground(Color.white);

        //Adding labels to label panel and then it is added to hangman panel
        labels.add( winLost, BorderLayout.NORTH );
        labels.add( secretWord, BorderLayout.CENTER );
        add(labels , BorderLayout.SOUTH);
    }

    @Override
    public void paintComponent( Graphics g )
    {
        super.paintComponent(g);
//      this.g = g;
        //Setting drawing color and creating the gallows
        g.setColor(Color.red);
        g.fillRect( 20, 320, 120, 10 );
        g.fillRect( 20, 20, 10, 300 );
        g.fillRect( 20, 20, 200, 10 );
        g.fillRect( 220, 20, 10, 30 );

        //For first incorrect try, the head of the hangman is created
        if ( hmModel.getNumOfIncorrectTries() >= 1 )
        {
            g.drawOval( 195, 50, 60, 60 );
        }

        //For second incorrect try, the body of the hangman is created
        if ( hmModel.getNumOfIncorrectTries() >= 2 )
        {
            g.drawLine( 225, 110, 225, 210 );
        }

        //For third incorrect try, the left leg is created
        if ( hmModel.getNumOfIncorrectTries() >= 3 )
        {
            g.drawLine( 225, 210, 245, 300 );
        }

        //For forth incorrect try, the right leg is created
        if ( hmModel.getNumOfIncorrectTries() >= 4 )
        {
            g.drawLine( 225, 210, 205, 300 );
        }

        //For fifth incorrect try, the left arm is created
        if ( hmModel.getNumOfIncorrectTries() >= 5 )
        {
            g.drawLine( 225, 140, 255, 190 );
        }

        //For sixth incorrect try, the right arm is created and hangman is completed
        //and game is lost
        if ( hmModel.getNumOfIncorrectTries() >= 6 )
        {
            g.drawLine( 225, 140, 195, 190 );
        }
    }

    @Override
    public void updateView( Hangman hm )
    {
        //Update the view of hangman with calling repaint method
        repaint();
        //The labels are set to show win lose and the secret word
        winLost.setText( "" );
        secretWord.setText( "" );
        if( hm.isGameOver() )
        {
            if( hm.hasLost() )
            {
                winLost.setText( "You lost!" );
                secretWord.setText( "The word is " + hm.getKnownSoFar() );
            }
            else
            {
                winLost.setText( "You win!" );
                secretWord.setText( "The word is " + hm.getKnownSoFar() );
            }
        }
    }

}
