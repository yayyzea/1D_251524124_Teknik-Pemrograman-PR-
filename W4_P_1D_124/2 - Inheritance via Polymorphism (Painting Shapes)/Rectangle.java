package w4_2_inheritance_via_polymorphism_.painting_shapes;

/**
 *
 * @author ZAHRA
 */

//********************************************************************
// Rectangle.java
//
// Represents a rectangle shape.
//********************************************************************

public class Rectangle extends Shape {
    private double length, width;

    //-----------------------------------------------------------------
    // Sets up the rectangle with the specified length and width.
    // Passes the shape name "Rectangle" to the parent constructor.
    //-----------------------------------------------------------------
    public Rectangle(double l, double w) {
        super("Rectangle");
        length = l;
        width = w;
    }

    //-----------------------------------------------------------------
    // Returns the area of this rectangle, computed as length * width.
    //-----------------------------------------------------------------
    public double area() {
        return length * width;
    }

    //-----------------------------------------------------------------
    // Returns the rectangle as a string including its dimensions.
    //-----------------------------------------------------------------
    public String toString() {
        return super.toString() + " of length " + length + " and width " + width;
    }
}
