package partA;
/**
 * This class creates a triangle shape object
 * @author Turgut Alp Edis
 * date: 1/11/20
 */
public class Triangle extends Shape
{
    //Properties
    int a, b, c;
    double x1, y1, x2, y2, x3, y3;
    boolean isSelected;

    //Constructors

    /**
     * This constructor creates a triangle with given sides
     * @param a the one side of the triangle
     * @param b the one side of the triangle
     * @param c the one side of the triangle
     * @param x the x location of the triangle
     * @param y the y location of the triangle
     */
    public Triangle( int a, int b, int c, int x, int y )
    {
        this.a = a;
        this.b = b;
        this.c = c;
        setLocation(x,y);
        isSelected = false;
        x1 = 0;
        x2 = 0;
        x3 = 0;
        y1 = 0;
        y2 = 0;
        y3 = 0;
    }


    //Methods

    @Override
    public double getArea() {
        double halfP = getPerimeter() / 2;
        return Math.sqrt( halfP * (halfP - a) * (halfP - b) * (halfP - c));
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }

    @Override
    public String toString()
    {
        return ("This triangle has " + a + " " + b + " " + c + " sides\n It is at x:" + getX() + " and y: " + getY() + "\nTotal Area: " + getArea() + "\nTotal Perimeter: " + getPerimeter() + "\nSelected: " + isSelected );
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
        double radiusOfCircumscribed = a * b * c / (4 * getArea() );
        double distance = Math.sqrt( Math.pow( getY() - y , 2) + Math.pow( getX() - x, 2) );
        double area = Math.PI * Math.pow( radiusOfCircumscribed, 2);
        double disArea = Math.PI * Math.pow( distance, 2);
        if ( disArea <= getArea() )
            return this;
        else if ( disArea == area )
            return this;
        else
            return null;
    }
}