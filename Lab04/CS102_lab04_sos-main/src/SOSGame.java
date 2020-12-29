import cs101.sosgame.SOS;
import javax.swing.*;
import java.io.IOException;

/**
 * This class creates frame to play SOS game
 * @author Turgut Alp Edis
 * date:23/11/2020
 */
public class SOSGame {

    public static void main( String[] args ) throws IOException
    {
        SOS game;
        SOSCanvas canvas;
        SOSGUIPanel panel;
        JFrame frame;
        String p1, p2, dim;
        int d;

        dim = JOptionPane.showInputDialog("Please enter the dimension of the game: ");
        p1 = JOptionPane.showInputDialog("Please enter player 1: ");
        p2 = JOptionPane.showInputDialog("Please enter player 2: ");
        d = Integer.parseInt( dim );

        game = new SOS( d );
        canvas = new SOSCanvas( game );
        panel = new SOSGUIPanel( canvas, p1, p2 );
        frame = new JFrame();
        frame.setTitle("SOS Game");
        frame.getContentPane().add( panel );
        frame.pack();
        frame.setResizable( false );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setVisible( true );
    }
}
