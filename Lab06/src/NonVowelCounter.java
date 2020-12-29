import java.util.Scanner;

/**
 * This class counts the non vowel letters in a sentence with recursion
 * @author Turgut Alp Edis
 * date: 6/12/20
 */
public class NonVowelCounter {

    public static void main( String[] args ){
        Scanner scan = new Scanner( System.in );

        //Constants

        //Variables
        String line;

        //Program Code
        System.out.println("Please type the sentence that the non vowels is counted: ");
        line = scan.nextLine();
        System.out.println( "The non vowel count in string is " + nonVowelCntr(line) );
    }

    /**
     * This method counts the non vowels with recursive way
     * @param line the input string
     * @return the count of non vowel letters in the input
     */
    private static int nonVowelCntr(String line) {
        //Firstly, all letters is lowered
        line = line.toLowerCase();
        //The base case if the length is 1 and is not vowel, then return 1.
        if ( line.length() == 1 && !isVowel(line.charAt(0)))
            return 1;
        //Main case: if the last char is non vowel, then return recursive + 1, else return just recursive
        else
        {
            if ( !isVowel( line.charAt( line.length() - 1) ) )
                return nonVowelCntr( line.substring(0,line.length() - 1)) + 1;
            else
                return nonVowelCntr( line.substring(0,line.length() - 1));
        }
    }

    /**
     * This method checks the char is vowel or not
     * @param ch the input character
     * @return true if it is vowel, false if it is non-vowel
     */
    private static boolean isVowel(char ch) {
        //Check if it is letter or not
        if ( Character.isLetter(ch) )
            return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
        else return true;
    }
}
