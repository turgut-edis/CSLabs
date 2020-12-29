import cs102.Hangman;

/**
 * This class implements the IHangmanView into the console looking
 * @author Turgut Alp Edis
 * date: 1/12/20
 */
public class ConsoleHangmanView implements IHangmanView
{

    @Override
    public void updateView(Hangman hangmanModel) {
        //Show important info of the game for the user
        System.out.println("KnownSoFar      = " + hangmanModel.getKnownSoFar() );
        System.out.println("AllLetters      = " + hangmanModel.getAllLetters() );
        System.out.println("UsedLetters     = " + hangmanModel.getUsedLetters() );
        System.out.println("IncorrectTries  = " + hangmanModel.getNumOfIncorrectTries() );
        System.out.println("MaxAllowedTries = " + hangmanModel.getMaxAllowedIncorrectTries() );
        System.out.println("HasLost         = " + hangmanModel.hasLost() );
        System.out.println("GameOver        = " + hangmanModel.isGameOver() );
        System.out.println();
    }
}
