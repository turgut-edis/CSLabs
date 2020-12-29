/**
 * This class implements a node class which stores a data
 * @author Turgut Alp Edis
 * date: 19/12/2020
 */
public class Node {

    //Properties
    String data;
    Node next;

    //Constructors

    /**
     * This constructor creates a new node with data and next node
     * @param data the data
     * @param next the next node
     */
    public Node( String data, Node next ){
        this.data = data;
        this.next = next;
    }

    /**
     * This constructor creates a new node with just data
     * @param data the data
     */
    public Node( String data ){
        this.data = data;
        this.next = null;
    }

    //Methods

    /**
     * Getter for data
     * @return the data
     */
    public String getData(){
        return data;
    }

    /**
     * Getter for the next node
     * @return the next node
     */
    public Node getNext(){
        return next;
    }

    /**
     * Setter for the next node
     * @param next the new next node
     */
    public void setNext( Node next ) { this.next = next; }

    /**
     * Setter for the data
     * @param data the new data
     */
    public void setData( String data ) { this.data = data; }
}
