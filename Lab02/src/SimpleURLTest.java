import cs1.SimpleURLReader;
/**
 * This class is testing the simple url reader file given from default
 * @author Turgut Alp Edis
 * date : 19/10/2020
 */
public class SimpleURLTest
{
    public static void main( String[] args )
    {
        //Constants
        final String SIMPURL = "http://www.cs.bilkent.edu.tr/~ozturk/cs102/housman.txt";
        
        //Variables
        int lineCnt;
        String pageCont;
        SimpleURLReader page;
        
        //Program Code
        page = new SimpleURLReader( SIMPURL );
        lineCnt = page.getLineCount();
        pageCont = page.getPageContents();
        System.out.println("The page content of " + SIMPURL);
        System.out.println(pageCont);
        System.out.println("The line count : " + lineCnt);
    }
}