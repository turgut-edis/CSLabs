package partA;
/**
 * This interface gives shapes the location
 * @author Turgut Alp Edis
 * date: 1/11/20
 */
public interface Locatable
{
    /**
     * This method return x axis of the shape
     * @return the x axis of the shape
     */
    int getX();

    /**
     * This method returns y axis of the shape
     * @return the y axis of the shape
     */
    int getY();

    /**
     * This method sets new location for the shape
     * @param x the new x axis
     * @param y the new y axis
     */
    void setLocation(int x, int y);
}