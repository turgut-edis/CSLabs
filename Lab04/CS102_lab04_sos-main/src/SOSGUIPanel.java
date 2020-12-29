import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This class creates a panel for the game to play in
 * @author Turgut Alp Edis
 * date: 22/11/2020
 */
public class SOSGUIPanel extends JPanel {

    //Properties
    SOSCanvas canvas;
    String p1, p2;
    JRadioButton r1, r2;
    ButtonGroup group;
    JLabel l1, l2;
    JPanel panel1, panel2, panelB;
    MouseListener listener = new MouseGame();

    //Constructors

    /**
     * This constructor creates new GUI Panel for SOS Game
     * @param canvas the SOSCanvas to be wanted to play in
     * @param p1 name of player 1
     * @param p2 name of player 2
     */
    public SOSGUIPanel ( SOSCanvas canvas, String p1, String p2 )
    {
        this.canvas = canvas;
        this.p1 = p1;
        this.p2 = p2;
        canvas.addMouseListener( listener );
        createBottomPanel();
        createPanel();
    }

    //Methods

    /**
     * This method sets the main panel settings and adds the other panels
     */
    private void createPanel() {
        this.setLayout( new BoxLayout( this, BoxLayout.Y_AXIS ) );
        this.setPreferredSize( new Dimension( canvas.getCanvasSize(), canvas.getCanvasSize() + 100 ) );
        add( canvas );
        add( panelB );
    }

    /**
     * This method creates labels
     */
    private void createLabels() {
        l1 = new JLabel( p1 + " " + canvas.getGame().getPlayerScore1() );
        l2 = new JLabel( canvas.getGame().getPlayerScore2() + " " + p2 );
        l1.setFont( new Font( "TimeRoman", Font.PLAIN, 15 ) );
        l2.setFont( new Font( "TimeRoman", Font.PLAIN, 15 ) );
        l1.setForeground( Color.BLACK );
        l2.setForeground( Color.WHITE );
    }

    /**
     * This method creates radio buttons for letters s and o
     */
    private void createRadioButtons() {
        group = new ButtonGroup();
        r1 = new JRadioButton( "s" );
        r2 = new JRadioButton( "o" );
        r1.setFont( new Font( "TimeRoman", Font.PLAIN, 15 ) );
        r2.setFont( new Font( "TimeRoman", Font.PLAIN, 15 ) );
        group.add(r1);
        group.add(r2);
    }

    /**
     * This method creates two panel for labels and emerging them into one bottom panel
     */
    private void createBottomPanel() {
        panelB = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panelB.setLayout( new FlowLayout() );
        panelB.setBackground( Color.ORANGE );
        panel1.setBackground( Color.CYAN );
        panel2.setBackground( Color.RED );
        createLabels();
        createRadioButtons();
        panel1.add( l1 );
        panel1.add( r1 );
        panel2.add( r2 );
        panel2.add( l2 );
        panelB.add( panel1 );
        panelB.add( panel2 );
    }

    /**
     * This inner class implements MouseListener interface according to the need of the gui panel
     */
    class MouseGame implements MouseListener
    {

        @Override
        public void mouseClicked(MouseEvent e) {
            if( !canvas.getGame().isGameOver() )
            {
                //Since the coordinates of the mouse is opposite with the SOS game, the y and x coordinates are opposite
                int  y = e.getX()/( canvas.getCanvasSize() / canvas.getGame().getDimension());
                int x = e.getY()/( canvas.getCanvasSize() / canvas.getGame().getDimension());
                //Which radio button is selected, the letter will be played according to it
                if (r1.isSelected())
                {
                    canvas.getGame().play('s' , x+1 , y+1);
                }
                else if(r2.isSelected())
                {
                    canvas.getGame().play('o' , x+1 , y+1);
                }
                else {
                    System.out.println("Row: " + (x + 1) );
                    System.out.println("Col: " + (y + 1) );
                }
                canvas.repaint();
                //Who has the play turn, the name of him or her will be black and other will be white
                if ( canvas.getGame().getTurn() == 1 ) {
                    l1.setForeground( Color.BLACK );
                    l2.setForeground( Color.WHITE );
                }
                else
                {
                    l1.setForeground( Color.WHITE );
                    l2.setForeground( Color.BLACK );
                }
                l1.setText( p1 + " " + canvas.getGame().getPlayerScore1() );
                l2.setText( canvas.getGame().getPlayerScore2() + " " + p2 );
            }
            //When the game is over, the game over message will show according to who is the winner
            if( canvas.getGame().isGameOver() )
            {
                String message = "";
                if( canvas.getGame().getPlayerScore1() > canvas.getGame().getPlayerScore2() )
                    message = p1 + " is the winner!";
                else if( canvas.getGame().getPlayerScore1() < canvas.getGame().getPlayerScore2() )
                    message = p2 + " is the winner!";
                else
                    message = "It's a draw!";

                JOptionPane.showConfirmDialog(null, message, "GAME OVER", JOptionPane.DEFAULT_OPTION);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) { }

        @Override
        public void mouseReleased(MouseEvent e) { }

        @Override
        public void mouseEntered(MouseEvent e) { }

        @Override
        public void mouseExited(MouseEvent e) { }
    }
}
