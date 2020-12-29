/**
 * This class shows first 40 fibonacci numbers
 * 
 * @author Turgut Alp Edis
 * 6/10/2020
 */
public class FibonacciNums
{
   public static void main(String[] args)
   {
      //Constants
      final int LIMIT = 40;
      
      //Variables
      IntBag fibonacci;
      int nextNum;
      
      //Program Code
      
      fibonacci = new IntBag();
      fibonacci.add(0);
      fibonacci.add(1);
      
      for(int i = 2; i < LIMIT; i++)
      {
         nextNum = fibonacci.getIndex( i - 1 ) + fibonacci.getIndex( i - 2 );
         fibonacci.add(nextNum);
      }
      
      System.out.println(fibonacci.toString());
   }
}