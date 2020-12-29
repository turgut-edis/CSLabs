package partA;
/**
 * This class creates a square shape object
 * @author Turgut Alp Edis
 * date: 1/11/2020
 */
public class Square extends Rectangle
{
    //Properties
    int side;
    //Constructors
    /**
     * This constructor creates a square object with given side
     * @param side the side of the square
     */
    public Square(int side, int x, int y) {
        super(side, side, x, y);
        this.side = side;
    }

    //Methods

    @Override
    public double getArea(){
        return super.getArea();
    }

    @Override
    public String toString()
    {
        return ("This square has " + side + " side\nIt is at x:" + getX() + " and y: " + getY() + "\nTotal Area: " + getArea() + "\nTotal Perimeter: " + getPerimeter() + "\nSelected: " + isSelected );
    }

}