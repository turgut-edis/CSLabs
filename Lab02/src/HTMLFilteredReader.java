/**
 * This class implements a html filtered reader class that will allow user to read text without any html codes.
 * @author Turgut Alp Edis
 * date : 12/10/2020
 */
public class HTMLFilteredReader extends MySimpleURLReader
{
    //Properties
    String url;
    
    //Constructors
    /**
     * This constructor creates HTMLFilteredReader object with given url
     * @param url of the webpage
     */
    public HTMLFilteredReader(String url) {
        super(url);
        this.url = url;
    }
    
    //Methods
    /**
     * It is reading the webpage without any filter
     * @return the content of the webpage with all html codes
     */
    public String getUnfilteredPageContents()
    {
        return super.getPageContents();
    }
    
    /**
     * It is reading webpage and it filters all html codes and special signs
     * @return the filtered content of the webpage
     */
    public String getPageContents()
    {
        String fullPage = getUnfilteredPageContents();
        boolean isHTML = false; // Shows the current character is part of HTML
        boolean isJs = false;
        String filteredPage = ""; // First HTML codes filtered
        String jsFiltered = ""; //Page after js codes are deleted
        String fullfilteredPage = ""; //&quot; filtered that means all page is String

        //
        for( int i = 0; i < fullPage.length(); i++ )
        {
            if( fullPage.indexOf("<script") == i )
                isJs = true;
            else if( fullPage.indexOf("</script>") + 8 == i )
                isJs = false;
            else if( !isJs )
                jsFiltered = jsFiltered + fullPage.charAt(i);
        }
        //Filtering all html codes
        //Also, when the body ends, the content also ends. Then after the body is not taken into consideration.
        for( int i = 0; i < jsFiltered.length() - 1; i++ )
        {
            if( jsFiltered.charAt(i) == '<' )
                isHTML = true;
            else if( jsFiltered.charAt(i) == '>' )
                isHTML = false;
            else if( !isHTML && jsFiltered.indexOf("body", i) >= 0 )
                filteredPage = filteredPage + jsFiltered.charAt(i);
        }

        //Then filtering & and ; symbols since they are not in html codes
        for( int j = 0; j < filteredPage.length() - 1; j ++)
        {
            if( filteredPage.charAt(j) == '&' )
                isHTML = true;
            else if( filteredPage.charAt(j) == ';' )
                isHTML = false;
            else if( !isHTML )
                fullfilteredPage = fullfilteredPage + filteredPage.charAt(j);
        }
        return fullfilteredPage;
    }
}