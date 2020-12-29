package partB;

import java.util.Iterator;

/**
 * This class extends iterator to new method which is nextInt()
 */
public interface IntIterator extends Iterator
{
    /**
     * This method provides next integer
     * @return int number
     */
    public int nextInt();
}