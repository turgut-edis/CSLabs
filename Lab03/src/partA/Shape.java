package partA;
/**
 * This abstract class used for all shapes and has two methods, which are getArea and getPerimeter
 * @author Turgut Alp Edis
 * date: 1/11/20
 */
public abstract class Shape implements Locatable, Selectable
{
    //Properties
    int x = 0;
    int y = 0;

    /**
     * This method returns the area of current shape.
     * @return the area of the shape
     */
    public abstract double getArea();

    /**
     * This method returns the circumference of the current shape.
     * @return circumference of the shape
     */
    public abstract double getPerimeter();

    /**
     * This method gives the x axis of the location
     * @return the x axis
     */
    public int getX()
    {
        return x;
    }

    /**
     * This method gives the y axis of the location
     * @return the y axis
     */
    public int getY()
    {
        return y;
    }

    /**
     * This method sets the new location of the shape
     * @param x the new x axis
     * @param y the new y axis
     */
    public void setLocation( int x, int y )
    {
        this.x = x;
        this.y = y;
    }

}