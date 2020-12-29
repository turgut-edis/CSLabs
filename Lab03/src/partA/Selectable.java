package partA;
/**
 * This interface gives oppotunity to select the shapes by location
 * @author Turgut Alp Edis
 * date: 1/11/20
 */
public interface Selectable
{
    /**
     * This method return current selected status of shape
     * @return the current status of the shape
     */
    boolean getSelected();

    /**
     * This method sets the status of the shape
     * @param select new selected status of the shape
     */
    void setSelected( boolean select );

    /**
     * This method returns first shape in given coordinates
     * @param x the given x location
     * @param y the given y location
     * @return the shape in x, y location if there is not, returns null
     */
    Shape contains( int x, int y );
}