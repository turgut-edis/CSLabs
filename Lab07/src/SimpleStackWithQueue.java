/**
 * This class implements a new simple stack with using twu queues
 * @author Turgut Alp Edis
 * date: 24/12/2020
 */
public class SimpleStackWithQueue
{
    //Properties
    SimpleQueue q1, q2;


    //Constructors

    /**
     * This constructor creates a new simple stack with starting both queues.
     */
    public SimpleStackWithQueue(){
        q1 = new SimpleQueue();
        q2 = new SimpleQueue();
    }


    //Methods

    /**
     * This method pushes the data
     * @param data the pushed data
     */
    public void push(String data){
        q2.enqueue( data );
        while ( !q1.isEmpty() )
            q2.enqueue( q1.dequeue() );
        SimpleQueue tmp = q2;
        q2 = q1;
        q1 = tmp;
    }

    /**
     * This method pops the data from first queue
     * @return the poped data
     */
    public String pop(){
        return q1.dequeue();
    }

    @Override
    public String toString(){
        return q1.list.toString();
    }

}
