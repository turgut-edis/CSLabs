import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class creates a potluck game in the frame
 * @author Turgut Alp Edis
 * date: 22/11/2020
 */
public class PotLuck extends JFrame implements ActionListener
{
    //Properties
    //The number of rows and cols, attempts and indexes of bomb one two and prize
    int dimension, bombOne, bombTwo, prize, attempt;
    //Panels to store the components
    JPanel gamePanel, barPanel, contentPane;
    //The label that shows how many attempts, loses or wins the game
    JLabel bar;
    //The buttons for the game
    JButton bBombOne, bBombTwo, bPrize, bNormal;

    //Constructors

    /**
     * This constructor takes number of dimension and creates new potluck game
     * @param dimension the number of dimension
     */
    public PotLuck ( int dimension )
    {
        //To avoid the error when only one button is available, dimension is set 2 default.
        if ( dimension > 1 )
            this.dimension = dimension;
        else
            this.dimension = 2;
        setTitle("PotLuck Game");
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        //Creating the components and adding them to the frame
        createContentPane();
        createLabel();
        createPanel();
        createButtons();
        //Setting the size according to the components
        pack();
    }

    //Methods

    /**
     * This method creates content pane to store all components in the frame
     */
    private void createContentPane() {
        contentPane = new JPanel();
        contentPane.setBorder( new EmptyBorder( 15, 0, 15, 0 ) );
        contentPane.setLayout( new BorderLayout( 0, 15 ) );
        contentPane.setBackground( Color.BLUE );
        setContentPane( contentPane );
    }

    /**
     * This method creates location of prize and bombs randomly and inserts them into the buttons
     */
    private void createButtons() {
        attempt = 0;
        while (prize == bombOne ||  prize == bombTwo ||bombOne == bombTwo)
        {
            prize = (int) ( Math.random() * ( dimension * dimension ) );
            bombOne = (int) ( Math.random() * ( dimension * dimension ) );
            bombTwo = (int) ( Math.random() * ( dimension * dimension ) );
        }

        for ( int i = 0; i < dimension * dimension; i++ )
        {
            String name = "Pot " + (i + 1);
            if ( i == bombOne )
            {
                bBombOne = new JButton( name );
                bBombOne.addActionListener( this );
                gamePanel.add( bBombOne );
            }
            else if ( i == bombTwo )
            {
                bBombTwo = new JButton( name );
                bBombTwo.addActionListener( this );
                gamePanel.add( bBombTwo );
            }
            else if ( i == prize )
            {
                bPrize = new JButton( name );
                bPrize.addActionListener( this );
                gamePanel.add( bPrize );
            }
            else
            {
                bNormal = new JButton( name );
                bNormal.addActionListener( this );
                gamePanel.add( bNormal );
            }
        }
    }

    /**
     * This method creates label panel that shows the current attempt and win or lose situation
     */
    private void createLabel() {
        barPanel = new JPanel();
        barPanel.setLayout( new FlowLayout() );
        bar = new JLabel("YOU CLICKED " + attempt + " times\r\n");
        bar.setHorizontalAlignment(JLabel.CENTER);
        barPanel.setBackground( Color.GREEN );
        barPanel.add( bar );
        contentPane.add(barPanel, BorderLayout.NORTH);

    }

    /**
     * This method creates the panel where all buttons are fit into
     */
    private void createPanel() {
        gamePanel = new JPanel();
        gamePanel.setBorder( new EmptyBorder( dimension, dimension, dimension, dimension ) );
        gamePanel.setLayout( new GridLayout( dimension, dimension, dimension * 2, dimension * 2) );
        contentPane.add( gamePanel , BorderLayout.CENTER );
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if ( e.getSource() == bPrize )
        {
            bar.setText("The prize found in " + (attempt + 1) + " tries.");
            for (int i = 0; i < (dimension * dimension); i++) {
                if (gamePanel.getComponent(i) != bPrize) {
                    gamePanel.getComponent(i).setEnabled(false);
                }
            }
        }
        else if ( e.getSource() != bBombOne && e.getSource() != bBombTwo )
        {
            attempt++;
            ((JButton) e.getSource()).setEnabled( false );
            bar.setText( "You clicked " + ( attempt ) + " times");
        }
        else
        {
            bar.setText("Sorry! You are blown up at attempt " + (attempt + 1) + "!");
            for(int i = 0; i < (dimension*dimension); i++)
            {
                (gamePanel.getComponent(i)).setEnabled(false);
            }
        }
    }
}