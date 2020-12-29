public class TestSimpleLinkedList {

    public static void main( String[] args ){
        //Constants

        //Variables
        SimpleLinkedList list;
        String data;
        Node getted;

        //Program Code
        list = new SimpleLinkedList();
        data = "abcde";

        list.addToTail( data );
        System.out.println(list.toString());
        data = "new data";
        getted = list.get( "abcde" );
        list.addToTail( data );
        list.removeFromHead();
        System.out.println(list.toString());
        System.out.println(getted.getData());
        list.addToTail(" Turkey ");
        System.out.println(list.toString());

    }
}
