import cs102.IHangmanSetup;

/**
 * This class implements the IHangmanSetup to create new words as the theme of countries
 * @author Turgut Alp Edis
 * date: 2/12/20
 */
public class CountryGameSetup implements IHangmanSetup {

    //The word list
    private static String[] words = { "Afghanistan", "Andorra", "Argentina",
            "Bahrain", "Belarus", "Cuba", "Croatia", "Denmark", "United States",
            "Egypt", "Turkey", "England", " Singapore" };

    @Override
    public int getMaxAllowedIncorrectTries() {
        return 6;
    }

    @Override
    public char getBlankChar() {
        return '*';
    }

    @Override
    public String getCharsToPreserve() {
        return " ";
    }

    @Override
    public String getAllLetters() {
        return "abcdefghijklmnopqrstuvwxyz";
    }

    @Override
    public String chooseSecretWord() {
        int random = (int) (Math.random() * words.length );
        return words[ random ];
    }
}
