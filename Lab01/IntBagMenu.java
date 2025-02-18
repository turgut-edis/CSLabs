import java.util.Scanner;
/**
 * This program executes the menu that user can create intbag and modified it
 * 
 * @author Turgut Alp Edis
 * 6/10/2020
 */
public class IntBagMenu
{
   public static void main( String[] args )
   {
      //Constants
      
      //Variables
      IntBag intBag;
      Scanner scan;
      //value and index are used in all functions
      /**
       * option is used in select option 
       * number is used in reading values
       * value is used in add value and remove all
       * index is used in add value, remove value and remove all
       */
      int option, number, value, index;
      //The string wrong keeps the wrong entries
      String wrong;
      //This condition, allows the user to avoid any error due to the not created intbag.
      boolean created; 
      
      //Program Code
      scan = new Scanner(System.in);
      option = 0;
      intBag = new IntBag();
      created = false; //Since the intbag is not created yet.
      do
      {
         System.out.println("Please select an option: ");
         System.out.println("1 - Create a new empty collection(any previous values are lost!)");
         System.out.println("2 - Read a set of positive values into the collection (use zero to indicate all the values have been entered.)");
         System.out.println("3 - Print the collection of values.");
         System.out.println("4 - Add a value to the collection of values at a specified location");
         System.out.println("5 - Remove the value at a specified location from the collection of values");
         System.out.println("6 - Remove all instances of a value within the collection* (see note below).");
         System.out.println("7 - Quit the program.");
         if( scan.hasNextInt() )
         {
            option = scan.nextInt();
            if( option == 1 )
            {
               intBag = new IntBag();
               created = true;
               System.out.println("Bag is created successfully!");
            }
            if( option == 2 && created )
            {
               System.out.println("Please enter list of values (0 to stop):");
               if(scan.hasNextInt())
               {
                  number = scan.nextInt();
                  while( number > 0 )
                  {
                     if( scan.hasNextInt() )
                     {
                        intBag.add(number);
                        number = scan.nextInt();
                     }
                     else
                     {
                        System.out.println("Please enter valid input");
                        wrong = scan.next();
                     }
                  }
                  System.out.println("The current list of array:");
                  System.out.println(intBag.toString());
               }
               else
               {
                  System.out.println("Please enter valid input");
                  wrong = scan.next();
               }
               
            }
            if( option ==3 && created )
            {
               System.out.println("The current list of array:");
               System.out.println(intBag.toString());
            }
            if( option == 4 && created )
            {
               System.out.println("Please enter the value: ");
               if( scan.hasNextInt() )
               {
                  value = scan.nextInt();
                  System.out.println("Please enter the index: ");
                  if( scan.hasNextInt() )
                  {
                     index = scan.nextInt();
                     intBag.add( value , index );
                     System.out.println("The current list of array:");
                     System.out.println(intBag.toString());
                  }
                  else
                  {
                     System.out.println("Please enter valid input");
                     wrong = scan.next();
                  }
               }
               else
               {
                  System.out.println("Please enter valid input");
                  wrong = scan.next();
               }
            }
            if( option == 5 )
            {
               System.out.println("Please enter the index to remove: ");
               if( scan.hasNextInt() )
               {
                  index = scan.nextInt();
                  intBag.remove( index );
                  System.out.println("The current list of array:");
                  System.out.println(intBag.toString());
               }
               else
               {
                  System.out.println("Please enter valid input");
                  wrong = scan.next();
               }
            }
            if( option == 6 )
            {
               System.out.println("Please enter the number to remove: ");
               if( scan.hasNextInt() )
               {
                  value = scan.nextInt();
                  intBag.removeAll(value);
                  System.out.println("The value " + value + " is successfully removed from array.");
                  System.out.println("The current list of numbers:");
                  System.out.println(intBag.toString());
               }
               else
               {
                  System.out.println("Please enter valid input");
                  wrong = scan.next();
               }
            }
         }
         else
         {
            System.out.println("Please enter valid number!!");
            wrong = scan.next();
         }
         
      }while( option != 7);
   }
}