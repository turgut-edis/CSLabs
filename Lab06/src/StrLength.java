import java.util.Scanner;

/**
 * This class measures the length of the string typed by the user
 * @author Turgut Alp Edis
 * date: 6/12/20
 */
public class StrLength {

    public static void main( String[] args ){
        Scanner scan = new Scanner( System.in );

        //Constants

        //Variables
        String line;

        //Program Code
        System.out.println("Please type the string to be counted: ");
        line = scan.nextLine();
        System.out.println( "The count in string is " + strCounter(line) );

    }

    /**
     * This method counts the length of the string with recursive way.
     * @param line the input string
     * @return the length of the parameter line
     */
    private static int strCounter(String line) {
        //If the string is empty, return zero (base case)
        if ( line.equals("") )
            return 0;
        else
            //Else return recursive method + 1 (main case)
            return strCounter( line.substring(1) ) + 1;
    }
}
