/**
 * This class starts with word search program that gives user to find any word in the text from the website without HTML codes
 * @author Turgut Alp Edis
 * date : 20/10/2020
 */
public class WordSearch extends HTMLFilteredReader
{
    //Properties
    String url;

    //Constructor
    /**
     * This constructor creates wordsearch object with given url
     * @param url the url of the webpage
     */
    public WordSearch( String url )
    {
        super(url);
        this.url = url;
    }

    //Methods
    /**
     * It is finding the word and displaying how many times the word occured.
     * @param word the word to be found in the text.
     */
    public void searchWord( String word )
    {
        String page = super.getPageContents();
        if( !page.contains(word) )
            System.out.println("Sorry " + word + " is not found here.");
        else
        {
            System.out.println("The word " + word + " is founded at " + page.indexOf(word) + ".");
        }
    }
}