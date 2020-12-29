package partA;

/**
 * This class creates a circle shape object
 * @author Turgut Alp Edis
 * date: 1/11/20
 */
public class Circle extends Shape
{
    //Properties
    int radius;
    boolean isSelected;

    //Constructors

    /**
     * This constructor creates a circle object with given radius
     * @param radius the radius of the circle
     * @param x the x location of circle
     * @param y the y location of circle
     */
    public Circle( int radius, int x, int y )
    {
        this.radius = radius;
        setLocation(x,y);
        isSelected = false;
    }

    //Methods

    @Override
    public double getArea() {
        return Math.PI * (radius * radius);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString()
    {
        return ("This circle has " + radius + " radius\nIt is at x:" + getX() + " and y: " + getY() + "\nTotal Area: " + getArea() + "\nTotal Perimeter: " + getPerimeter() + "\nSelected: " + isSelected );
    }

    @Override
    public boolean getSelected() {
        return isSelected;
    }

    @Override
    public void setSelected(boolean select) {
        isSelected = select;
    }

    @Override
    public Shape contains(int x, int y) {
        //If the length between given and center points will be less than or equal to radius, the point is in the circle.
        if(Math.pow(getX() - x , 2) + Math.pow(getY() - y, 2) <= Math.pow (radius, 2))
        {
            return this;
        }
        return null;
    }
}