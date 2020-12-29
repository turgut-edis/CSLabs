package partA;
/**
 * This class creates a rectangle object with given side lengths
 * @author Turgut Alp Edis
 * date: 1/11/20
 */
public class Rectangle extends Shape
{
    //Properties
    int width, height;
    boolean isSelected;
    //Constructors

    /**
     * This constructor creates a rectangle object with given parameters
     * @param width the short side of the rectangle
     * @param height the long side of the rectangle
     * @param x the x location of the rectangle
     * @param y the y location of the rectangle
     */
    public Rectangle( int width, int height, int x, int y )
    {
        this.width = width;
        this.height = height;
        setLocation(x,y);
        isSelected = false;
    }
    //Methods

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * ( height + width );
    }

    @Override
    public String toString()
    {
        return ("This rectangle has " + width + " width and " + height + " height\nIt is at x:" + getX() + " and y: " + getY() + "\nTotal Area: " + getArea() + "\nTotal Perimeter: " + getPerimeter() + "\nSelected: " + isSelected);
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
        //If the axis of the points will be less than or equal to center + half of side length, the point is in the rectangle
        if(getX() - (width/2) <= x && x <= getX() + (width/2) && getY() - (height/2) <= y && y <= getY() + (height/2))
        {
            return this;
        }
        return null;
    }
}