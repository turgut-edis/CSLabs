package partB;

import java.util.Iterator;

/*
 * This class implements a IntBag object that stores non-negative numbers
 * 
 * @author Turgut Alp Edis
 * 6/10/2020
 */
public class IntBag
{
   //Properties
   private int[] bag;
   int step;

   //Constructors
   public IntBag()
   {
      bag = new int[4];
      bag[0] = -1;
      step = 1;
   }

   /**
    * This constructor creates normal intBag object but this time it has a step number.
    * @param step the step number
    */
   public IntBag( int step )
   {
      bag = new int[4];
      bag[0] = -1;
      this.step = step;
   }
   
   //Methods
   
   /**
    * This method adds specified value to the end of the array
    * @param value the specified value
    */
   public void add( int value )
   {
      int numCount = size();
      if( numCount >= bag.length - 1 && value >= 0 )
      {
         int[] temp = new int[ bag.length + bag.length ];
         for ( int i = 0; i < bag.length; i++ )
            temp[i] = bag[i];
         bag = temp;
         bag[numCount] = value;
         bag[numCount + 1] = -1;
         
      }
      else if( value >= 0 )
      {
         bag[numCount] = value;
         bag[numCount + 1] = -1;
      }
   }
   
   /**
    * This method adds a value to specific index that is within the bounds.
    * @param value the given value by the user
    * @param i the index number that the number is wanted to be added
    */
   public void add( int value, int i )
   {
      if( value >= 0 )
      {
         if( i <= size() )
         {
            if( size() < bag.length )
            {
               //Creating space for given value
               for( int j = size() - 1; j >= i; j-- )
               {
                  bag[j + 1] = bag[j];
               }
               bag[i] = value;
            }
            else
            {
               int[] temp = new int[ bag.length + bag.length ];
               for ( int k = 0; k < bag.length; k++ )
                  temp[k] = bag[k];
               bag = temp;
               for( int k = i; k < size() - 1; k++ )
               {
                  bag[k + 1] = bag[k];
               }
               bag[i] = value;
            }
         }
         else
         {
            System.out.println("Out of bounds");
         }
      }
   }
   
   /**
    * This method removes a value at specified index and replace it with last element
    * @param i the specified index
    */
   public void remove( int i )
   {
      bag[i] = bag[size() - 1];
      bag[size() - 1] = -1;
   }
   
   /**
    * This method finds out whether given value is in the array or not
    * @param value the given value
    * @return true if array contains, false otherwise.
    */
   public boolean isFound( int value )
   {
      for( int i = 0; i < size(); i++ )
      {
         if(bag[i] == value)
            return true;
      }
      return false;
   }
   
   @Override
   public String toString()
   {
      String s = "";
      boolean isSentinel = false;
      for( int i = 0; i < bag.length && !isSentinel; i++ )
      {
         if( bag[i] != -1 )
            s = s + bag[i] + " , ";
         else
         {
            s = s + "-1";
            isSentinel = true;
         }
      }
      return s;
   }
   
   /**
    * This method returns the size of the array
    * @return the size of the array
    */
   public int size()
   {
      int numbers = 0;
      boolean isSentinel = false;
      for( int i = 0; i < bag.length && !isSentinel; i++ )
      {
         if( bag[i] != -1 )
            numbers++;
         else
            isSentinel = true;
      }
      return numbers;
   }
   
   /**
    * This method finds the value at specific index
    * @param i the index of the number to be found
    * @return the number at that index
    */
   public int getIndex( int i )
   {
      if( i < size() )
         return bag[i];
      else
         return -1;
   }
   
   /**
     * This method removes the specific number in the array
     * If the number do not exists, the error message will be given.
     * @param number the number wanted to be deleted.
     */
   public void removeAll( int number )
   {
      if( isFound( number ) )
      {
         while( isFound(number) )
         {
            for( int t = 0; t < size(); t++ )
            {
               if(bag[t] == number)
               {
                  for( int u = t; u < size() - 1; u++ )
                     bag[u] = bag[u+1];
                  bag[size() - 1] = -1;
               }  
            }
         }
         
      }
      else
      {
         System.out.println("The number " + number + " does not exist.");
      }
   }

   /**
    * This method creates new iterator object that can iterates through the elements of intBag
    * @return the iterator object
    */
   public Iterator iterator()
   {
      return new IntBagStepIterator( step, this );
   }

}

/**
 * This inner class implements iterator and gives override methods for intBag class
 * @author Turgut Alp Edis
 * date : 4/11/20
 */
class IntBagIterator implements IntIterator
{
   //Properties
   IntBag aBag;
   int index;

   //Constructors

   /**
    * This constructor creates new intBagIterator object with given bag.
    * @param aBag the intBag object
    */
   public IntBagIterator( IntBag aBag )
   {
      this.aBag = aBag;
      index = 0;
   }

   //Methods
   @Override
   public boolean hasNext() {
      return index < aBag.size();
   }

   @Override
   public Integer next() {
      if ( hasNext() )
      {
         return nextInt();
      }
      else {
         return null;
      }
   }

   @Override
   public int nextInt() {
      index++;
      return aBag.getIndex( index - 1);
   }
}

/**
 * This inner class has extended from intBagIterator and it is iterates objects with given step numbers
 * @author Turgut Alp Edis
 * date: 4/11/20
 */
class IntBagStepIterator extends IntBagIterator {

   //Properties
   private int step;
   private IntBag aBag;
   private int index;

   //Constructors

   /**
    * This constructor creates new intBagStepIterator object with given step number and intBag object
    * @param step step number indicates that how many steps will iterated through
    * @param aBag the intBag object
    */
   public IntBagStepIterator(int step, IntBag aBag) {
      super(aBag);
      this.step = step;
      this.aBag = aBag;
      index = 0;
   }
   //Methods
   @Override
   public boolean hasNext(){
      return index < aBag.size();
   }

   @Override
   public Integer next()
   {
      if (hasNext())
      {
         index += step;
         return aBag.getIndex( index - step);
      }
      else
         return null;
   }
}