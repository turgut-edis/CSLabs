/**
 * This class implements a simple linked list with using node
 * @author Turgut Alp Edis
 * date: 23/12/2020
 */
public class SimpleLinkedList {

    //Properties
    private Node head;

    //Constructors

    /**
     * This constructor creates a new simple linked list object with null head
     */
    public SimpleLinkedList() {
        head = null;
    }

    //Methods

    /**
     * This method adds the data to the tail of the list
     * @param data the data
     */
    public void addToTail( String data ) {
        Node tail = new Node( data );
        Node temp = head;
        if ( temp == null )
            head = tail;
        else {
            while (temp.next != null)
                temp = temp.getNext();
            temp.setNext( tail );
        }
    }

    /**
     * This method removes the data which is at the head of the list
     * @return the removed data
     */
    public String removeFromHead(){
        Node temp = head;
        if ( isEmpty() )
            return "";
        else
            head = head.getNext();
        return temp.getData();
    }

    /**
     * This method checks the situation of the list
     * @return true if it is empty, false otherwise.
     */
    public boolean isEmpty(){
        return head == null;
    }

    /**
     * This method gets the node of the wanted data
     * @param data the wanted data
     * @return the node which has wanted data
     */
    public Node get( String data ){
        Node temp = head;
        while ( temp != null )
        {
            if ( temp.getData().equals(data) )
                return temp;
            temp = temp.getNext();
        }
        return null;
    }

    @Override
    public String toString(){
        String str = "";
        Node index = head;
        while ( index != null){
            str = str + index.getData() + "\n";
            index = index.getNext();
        }
        return str;
    }
}
