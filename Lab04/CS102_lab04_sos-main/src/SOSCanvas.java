import javax.imageio.ImageIO;
import javax.swing.*;
import cs101.sosgame.SOS;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * This class creates a board for sos game
 * @author Turgut Alp Edis
 * date: 22/11/2020
 */
public class SOSCanvas extends JPanel {

    //Properties
    SOS sosGame;
    int row, col, size, x, y, start, canvas;
    char letter;
    Image img;

    //Constructors

    /**
     * This constructor creates new canvas object with given SOS game object
     * @param sosGame the SOS game
     */
    public SOSCanvas( SOS sosGame ) throws IOException {
        this.sosGame = sosGame;
        row = sosGame.getDimension();
        col = sosGame.getDimension();
        start = 5; //Start location of the canvas
        canvas = (row * 160) + 2 * start;
        size = ( canvas - ( 2 * start ) ) / row;
        img = ImageIO.read(new File("/Users/TurgutAlp/Pictures/background.jpg"));
        setBackground( Color.BLACK );
        setPreferredSize( new Dimension( canvas, canvas ) );
    }

    //Methods

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent( g );
        //The font, color and background image will be set
        g.setFont( new Font( "TimeRoman", Font.PLAIN, 25 ) );
        g.drawImage( img, size, size, null);
        g.setColor( Color.WHITE );
        //First the rows and the cols will be drawn
        for ( int i = 0; i < row + 1; i++ )
            g.drawLine( start, (start + i * size), canvas - start, (start + i * size) );
        for ( int i = 0; i < col + 1; i++ )
            g.drawLine( (start + i * size), start , (start + i * size), canvas- start );
        //Then, the cell contents will be placed according to the current game
        for ( int i = 0; i < row; i++ )
        {
            for ( int j = 0; j < col; j++ )
            {
                letter = sosGame.getCellContents( i, j );
                x = start + size/2 + j * size;
                y = start + size/2 + i * size;
                if ( letter != 's' && letter != 'o' ) {
                    g.drawString("", x, y);
                }
                else {
                    g.drawString("" + letter, x, y);
                }
            }
        }
    }

    /**
     * This method returns SOS game
     * @return a sos game
     */
    public SOS getGame()
    {
        return sosGame;
    }

    /**
     * This method returns canvas size
     * @return a size of the canvas
     */
    public int getCanvasSize()
    {
        return canvas;
    }

}
