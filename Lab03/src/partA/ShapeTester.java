package partA;
import java.util.Scanner;

/**
 * This class tests the shapecontainer class
 * @author Turgut Alp Edis
 * date: 1/11/20
 */
public class ShapeTester
{
    public static void main( String[] args )
    {
        Scanner scan = new Scanner(System.in);
        //Constants

        //Variables
        //Sides are used for holding side values of the shapes
        //x and y are used to hold location values
        //selection is option in main menu
        //option is option in adding shape menu
        int side1, side2, side3, x, y, selection, option;
        //wrongSelection is used for holding mistyped characters
        String wrongSelection;
        //Shapes are created once and added to the shapeContainer
        Rectangle rectangle;
        Square square;
        Circle circle;
        Triangle triangle;
        //Shape is used for found shape and controlled if there is any nullPointer error
        Shape shape;
        ShapeContainer bag;
        //isCreated is used for controlling whether the shape container is created or not
        boolean isCreated;

        //Program Code

        //Initially, the bag, selection, option and isCreated assigned to avoid any error.
        bag = null;
        selection = 0;
        isCreated = false;
        option = 0;
        //The program menu starts and controlling the input in everywhere
        do {
            System.out.println(" Welcome to ShapeTester. Please Select One Number:");
            System.out.println("1 - Create new Shape Container");
            System.out.println("2 - Add shape");
            System.out.println("3 - Compute total area");
            System.out.println("4 - Compute total perimeter");
            System.out.println("5 - Print all information");
            System.out.println("6 - Find the shape from location");
            System.out.println("7 - Remove all selected shapes");
            System.out.println("8 - EXIT");
            if (scan.hasNextInt())
            {
                selection = scan.nextInt();
                if ( selection == 1 ) {
                    bag = new ShapeContainer();
                    isCreated = true;
                    System.out.println("Container is created");
                }
                else if ( selection == 2 && isCreated) {
                    do {
                        System.out.println("Please select one shape");
                        System.out.println("1 - Rectangle");
                        System.out.println("2 - Square");
                        System.out.println("3 - Circle");
                        System.out.println("4 - Triangle");
                        System.out.println("5 - Menu");
                        if (scan.hasNextInt())
                        {
                            option = scan.nextInt();
                            if ( option == 1 ) {
                                System.out.println("Please choose the width");
                                if (scan.hasNextInt())
                                {
                                    side1 = scan.nextInt();
                                    System.out.println("Please choose the height");
                                    if (scan.hasNextInt())
                                    {
                                        side2 = scan.nextInt();
                                        System.out.println("Please enter x location:");
                                        if ( scan.hasNextInt())
                                        {
                                            x = scan.nextInt();
                                            System.out.println("Please enter y location:");
                                            if ( scan.hasNextInt() )
                                            {
                                                y = scan.nextInt();
                                                rectangle = new Rectangle(side1, side2, x, y);
                                                bag.add(rectangle);
                                            }
                                            else
                                            {
                                                System.out.println("Please enter valid input");
                                                wrongSelection = scan.next();
                                            }
                                        }
                                        else
                                        {
                                            System.out.println("Please enter valid input");
                                            wrongSelection = scan.next();
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("Please enter valid input");
                                        wrongSelection = scan.next();
                                    }
                                }
                                else
                                {
                                    System.out.println("Please enter valid input");
                                    wrongSelection = scan.next();
                                }
                            }
                            else if ( option == 2 ) {
                                System.out.println("Please choose the side");
                                if (scan.hasNextInt())
                                {
                                    side1 = scan.nextInt();
                                    System.out.println("Please enter x location:");
                                    if ( scan.hasNextInt())
                                    {
                                        x = scan.nextInt();
                                        System.out.println("Please enter y location:");
                                        if (scan.hasNextInt())
                                        {
                                            y = scan.nextInt();
                                            square = new Square(side1, x, y);
                                            bag.add(square);
                                        }
                                        else
                                        {
                                            System.out.println("Please enter valid input");
                                            wrongSelection = scan.next();
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("Please enter valid input");
                                        wrongSelection = scan.next();
                                    }
                                }
                                else
                                {
                                    System.out.println("Please enter valid input");
                                    wrongSelection = scan.next();
                                }
                            }
                            else if ( option == 3 ) {
                                System.out.println("Please choose the radius");
                                if (scan.hasNextInt())
                                {
                                    side1 = scan.nextInt();
                                    System.out.println("Please enter x location:");
                                    if ( scan.hasNextInt())
                                    {
                                        x = scan.nextInt();
                                        System.out.println("Please enter y location:");
                                        if (scan.hasNextInt())
                                        {
                                            y = scan.nextInt();
                                            circle = new Circle(side1, x, y);
                                            bag.add(circle);
                                        }
                                        else
                                        {
                                            System.out.println("Please enter valid input");
                                            wrongSelection = scan.next();
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("Please enter valid input");
                                        wrongSelection = scan.next();
                                    }
                                }
                                else
                                {
                                    System.out.println("Please enter valid input");
                                    wrongSelection = scan.next();
                                }
                            }
                            else if ( option == 4 ) {
                                System.out.println("Please choose the side 1");
                                if (scan.hasNextInt())
                                {
                                    side1 = scan.nextInt();
                                    System.out.println("Please choose the side 2");
                                    if (scan.hasNextInt())
                                    {
                                        side2 = scan.nextInt();
                                        System.out.println("Please choose the side 3");
                                        if (scan.hasNextInt())
                                        {
                                            side3 = scan.nextInt();
                                            System.out.println("Please enter x location:");
                                            if ( scan.hasNextInt())
                                            {
                                                x = scan.nextInt();
                                                System.out.println("Please enter y location:");
                                                if (scan.hasNextInt())
                                                {
                                                    y = scan.nextInt();
                                                    triangle = new Triangle(side1, side2, side3, x, y);
                                                    bag.add(triangle);
                                                }
                                                else
                                                {
                                                    System.out.println("Please enter valid input");
                                                    wrongSelection = scan.next();
                                                }
                                            }
                                            else
                                            {
                                                System.out.println("Please enter valid input");
                                                wrongSelection = scan.next();
                                            }
                                        }
                                        else
                                        {
                                            System.out.println("Please enter valid input");
                                            wrongSelection = scan.next();
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("Please enter valid input");
                                        wrongSelection = scan.next();
                                    }
                                }
                                else
                                {
                                    System.out.println("Please enter valid input");
                                    wrongSelection = scan.next();
                                }
                            }
                        }
                        else
                        {
                            System.out.println("Please enter valid input");
                            wrongSelection = scan.next();
                        }
                    } while ( option != 5);

                }
                else if ( selection == 3 && isCreated) {
                    System.out.println("The total area of the shapes: " + bag.getArea());
                }
                else if ( selection == 4 && isCreated) {
                    System.out.println("The total perimeter of the shapes: " + bag.getPerimeter());
                }
                else if (  selection == 5 && isCreated) {
                    System.out.println(bag.toString());
                }
                else if ( selection == 6 && isCreated) {
                    System.out.println("Please enter x location:");
                    if (scan.hasNextInt())
                    {
                        x = scan.nextInt();
                        System.out.println("Please enter y location:");
                        if (scan.hasNextInt())
                        {
                            y = scan.nextInt();
                            shape = bag.findShape(x, y);
                            if ( shape != null )
                            {
                                System.out.println(shape.toString());
                            }
                            else {
                                System.out.println(" Program could not find any shapes in " + x + " " + y + " axis");
                            }


                        }
                        else
                        {
                            System.out.println("Please enter valid input");
                            wrongSelection = scan.next();
                        }
                    }
                    else
                    {
                        System.out.println("Please enter valid input");
                        wrongSelection = scan.next();
                    }
                }
                else if ( selection == 7 && isCreated) {
                    bag.removeSelected();
                    System.out.println("The removal has succeeded");
                    System.out.println(bag.toString());
                }
            }
            else
            {
                System.out.println("Please enter valid input");
                wrongSelection = scan.next();
            }
        }
        while ( selection != 8 );
    }
}