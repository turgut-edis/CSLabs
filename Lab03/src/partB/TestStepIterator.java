package partB;

import java.util.Iterator;

/**
 * This class tests the IntBagStepIterator
 * @author Turgut Alp Edis
 * date: 2/11/20
 */
public class TestStepIterator
{
    public static void main( String[] args )
    {
        int step = 2;
        IntBag bag = new IntBag( step);
        for (int j = 1; j < 21; j++)
            bag.add(j);

        Iterator i;
        i = bag.iterator();
        while (i.hasNext())
        {
            System.out.println( i.next());
        }


    }
}