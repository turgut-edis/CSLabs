import java.util.Scanner;

/**
 * This class displays the potluck game after the user gives the dimension of the game
 * @author Turgut Alp Edis
 * date: 21/11/2020
 */
public class PotLuckGame
{
    public static void main( String[] args )
    {
        Scanner scan = new Scanner( System.in );
        //Constants

        //Variables
        int dim;
        PotLuck game;

        //Program Code
        System.out.println("Please enter the dimension of the game: ");
        if (scan.hasNextInt())
        {
            dim = scan.nextInt();
            game = new PotLuck( dim );
            game.setVisible( true );
        }

    }
}