import java.util.Scanner;

/**
 * This class lists all binary numbers according to the input from the user but no 1s is consecutive
 * @author Turgut Alp Edis
 * date: 8/12/20
 */
public class NonOnesRecursive {

    public static void main( String[] args ){
        Scanner scanner = new Scanner( System.in );

        //CONSTANTS

        //Variables
        int input;
        String wrong;

        //Program Code
        //Program repeats itself until the negative number is entered
        do {
            input = 0;
            System.out.print("Please enter the binary step number: ");
            //Checking the input is valid or not
            if ( scanner.hasNextInt() ) {
                input = scanner.nextInt();
                listBinary( input );
            } else {
                System.out.println("Please enter valid input");
                wrong = scanner.nextLine();
            }
        } while ( input < 0 );


    }

    /**
     * This method lists binary numbers in the given step number
     * @param input the step number of the binary
     */
    private static void listBinary(int input) {
        //Base case, if input is below or equal to zero, return zero as binary
        if ( input <= 0 )
        {
            System.out.println("0");
        }
        //Main Case: if step number is bigger than zero, created the char array and fill it with recursive method.
        else {
            char[] binNums = new char[input];
            binNums[0] = '0';
            strBin( input, binNums, 1);
            binNums[0] = '1';
            strBin( input, binNums, 1);
        }
    }

    /**
     * This method creates a binary number, stores in given array one by one and prints it with given step number and index number
     * @param input the given step number
     * @param binNums the given char array which creates a number
     * @param i the index number that indicates which index of array is created
     */
    private static void strBin(int input, char[] binNums, int i) {
        //Base Case: if the index is equal to the step number, then print the array
        if ( i == input )
        {
            for ( int j = 0; j < i; j++ )
            {
                //When the last digit is entered, the new line is created
                if ( j == i - 1 )
                    System.out.print(binNums[j] + "\n");
                else
                    System.out.print(binNums[j]);
            }
        }
        //Main Case: according to the last index is 1 or 0, the next number is put and going to next index recursively
        else if ( binNums[ i - 1 ] == '1' )
        {
            //Since consecutive ones is forbidden, the next is 0 and the recursive call occurs
            binNums[i] = '0';
            strBin( input, binNums, i + 1 );
        }
        else if ( binNums[ i - 1 ] == '0' )
        {
            //Since 0 has no rules, the two possibilities are put and the recursive call occurs
            binNums[i] = '0';
            strBin( input, binNums, i + 1 );
            binNums[i] = '1';
            strBin( input, binNums, i + 1 );
        }
    }
}
