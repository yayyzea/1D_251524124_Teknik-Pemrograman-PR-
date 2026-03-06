package w4_2_inheritance_via_polymorphism_.painting_shapes;

/**
 *
 * @author ZAHRA
 */

//********************************************************************
// Cylinder.java
//
// Represents a cylinder shape. 
//********************************************************************

public class Cylinder extends Shape {
    private double radius, height;

    //-----------------------------------------------------------------
    // Sets up the cylinder with the specified radius and height.
    // Passes the shape name "Cylinder" to the parent constructor.
    //-----------------------------------------------------------------
    public Cylinder(double r, double h) {
        super("Cylinder");
        radius = r;
        height = h;
    }

    //-----------------------------------------------------------------
    // Returns the lateral surface area of this cylinder,
    //-----------------------------------------------------------------
    public double area() {
        return Math.PI * radius * radius * height;
    }

    //-----------------------------------------------------------------
    // Returns the cylinder as a string including its dimensions.
    //-----------------------------------------------------------------
    public String toString() {
        return super.toString() + " of radius " + radius + " and height " + height;
    }
}
