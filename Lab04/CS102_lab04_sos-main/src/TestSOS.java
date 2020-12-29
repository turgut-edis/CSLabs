import cs101.sosgame.SOS;

/**
 * This class test the sos game taken default from SOS.class
 * @author Turgut Alp Edis
 * date: 22/11/2020
 */
public class TestSOS {
    public static void main( String[] args )
    {
        int dim;
        SOS game;

        dim = 3;
        game = new SOS( dim );
        game.printBoard();
        game.play('s', 1, 1 );
        game.play('o', 1,2 );
        game.play('s', 1, 3 );
        game.printBoard();
        System.out.println("player 1 score: " + game.getPlayerScore1() );
        System.out.println("player 2 score: " + game.getPlayerScore2() );
    }
}
