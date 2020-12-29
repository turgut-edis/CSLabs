/**
 * This class implements a simplequeue object with using simple linked list
 * @author Turgut Alp Edis
 * date: 23/12/2020
 */
public class SimpleQueue {

    //Properties
    SimpleLinkedList list;

    //Constructors

    /**
     * This constructor creates a new simple queue object with creating new list
     */
    public SimpleQueue(){
        list = new SimpleLinkedList();
    }

    //Methods

    /**
     * This method queues the data to the list
     * @param data the data
     */
    public void enqueue( String data ){
        list.addToTail( data );
    }

    /**
     * This method dequeues the fisrt data from the list
     * @return the dequeued data
     */
    public String dequeue(){
        return list.removeFromHead();
    }

    /**
     * This method checks the queue
     * @return true if it is empty, false otherwise.
     */
    public boolean isEmpty(){
        return list.isEmpty();
    }

    @Override
    public String toString(){
        return list.toString();
    }


}
