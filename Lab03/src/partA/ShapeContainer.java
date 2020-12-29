package partA;
import java.util.ArrayList;

/**
 * This class creates a shape container object that holds all shapes.
 * @author Turgut Alp Edis
 * date: 1/11/20
 */
public class ShapeContainer
{
    //Properties
    ArrayList<Shape> container;

    //Constructors

    /**
     * This constructor creates an empty list of shapes that hold shapes.
     */
    public ShapeContainer()
    {
        container = new ArrayList<>();
    }
    //Methods

    /**
     * This method adds shape to the list
     * @param s the shape added to the list
     */
    public void add(Shape s)
    {
        container.add(s);
    }

    /**
     * This method returns the total area of the list
     * @return the total area
     */
    public double getArea()
    {
        double total = 0;
        for ( Shape i : container)
            total = total + i.getArea();
        return total;
    }

    /**
     * This method returns the total perimeter of the list
     * @return the total perimeter
     */
    public double getPerimeter()
    {
        double total = 0;
        for (Shape s : container)
            total = total + s.getPerimeter();
        return total;
    }

    @Override
    public String toString()
    {
        String shapes = "";
        if (container.size() > 0)
        {
            for ( Shape s : container )
                shapes = shapes + s.toString() + "\n";
        }
        else
            shapes = "There is not any shape in the container";
        return shapes;
    }

    /**
     * This method finds the first shape of given location
     * @param x the x location
     * @param y the y location
     * @return the shape if there is any, otherwise returns null
     */
    public Shape findShape( int x, int y )
    {
        for (Shape s : container)
        {
            if (s.contains(x, y) != null)
            {
                s.contains(x,y).setSelected(!s.contains(x,y).getSelected());
                return s.contains(x, y);
            }

        }
        return null;
    }

    /**
     * This method removes all selected shapes
     */
    public void removeSelected()
    {
        for (int i  = container.size() - 1; i >= 0; i--)
        {
            if (container.get(i).getSelected())
                container.remove(i);
        }
    }
}