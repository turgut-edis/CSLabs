package partB;

import java.util.Iterator;

/**
 * This class test iterators
 */
public class TestIterators
{
    public static void main( String[] args)
    {
        IntBag bag = new IntBag();
        bag.add(4);
        bag.add(3);
        bag.add(2);
        Iterator i, j;
        i = bag.iterator();
        while ( i.hasNext() )
        {
            System.out.println( i.next() );
            j = bag.iterator();
            while ( j.hasNext() )
            {
                System.out.println( "--" + j.next() );
            }
        }
    }
}