public class QueueTest {

    public static void main(String[] args){
        //Constants

        //Variables
        String data;
        SimpleQueue queue;
        SimpleStackWithQueue stack;

        //Program Code
        queue = new SimpleQueue();
        stack = new SimpleStackWithQueue();
        data = "Hello";

        queue.enqueue( data );
        data = "World";
        queue.enqueue( data );
        System.out.println(queue.toString()); //Hello \n World
        data = queue.dequeue();
        System.out.println(data);
        System.out.println(queue.toString());

        stack.push( data );
        data = "abcdef";
        stack.push( data );
        System.out.println( stack.toString() );
        data = stack.pop();
        System.out.println( data );
        System.out.println( stack.toString() );
        stack.push( "Turkey" );
        System.out.println("***********************");
        System.out.println( stack.toString() );


    }
}
