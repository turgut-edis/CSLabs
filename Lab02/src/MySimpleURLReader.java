import cs1.SimpleURLReader;
/**
 * This class creating my simple url reader extends from simple url reader.
 * @author Turgut Alp Edis
 * date : 19/10/2020
 */
public class MySimpleURLReader extends SimpleURLReader
{
    //Properties
    String url;
    String name;
    
    //Constructor
    /**
     * This constructor creates my simple url reader with given url parameter.
     * @param url the url site which is read by the program
     */
    public MySimpleURLReader( String url )
    {
        super(url);
        this.url = url;
    }

    //Methods
    /**
     * This method returns the url of the site
     * @return the url of the site
     */
    public String getUrl()
    {
        return url;
    }

    /**
     * This method gets name of the webpage
     * @return the name of the site
     */
    public String getName()
    {
        name = "";
        for (int i = getUrl().length() - 1; i >= 0; i--)
            if (getUrl().charAt(i) == '/')
            {
                name = getUrl().substring(i);
                return name;
            }
        return name;
    }
    
    /**
     * This method gives the number of css files in the html code.
     * @return the number of css files
     */
    public int getNumberOfCSSLinks()
    {
        String page = super.getPageContents();
        String cssLink = "";
        int next = 0;
        int start = 0;
        int end = 0;
        int cssCount = 0;
        while( start >= 0 )
        {
            start = page.indexOf( "link" , next);
            end = page.indexOf(">", start);
            cssLink = page.substring( start, end );
            if (cssLink.contains("css"))
                cssCount++;
            next = start + 4;
            start = page.indexOf( "link" , next);
        }
        return cssCount;
    }

    @Override
    public String getPageContents()
    {
        return super.getPageContents().substring(4);
    }
}