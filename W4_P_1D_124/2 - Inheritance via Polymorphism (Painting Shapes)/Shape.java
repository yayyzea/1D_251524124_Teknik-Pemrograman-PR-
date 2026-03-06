package w4_2_inheritance_via_polymorphism_.painting_shapes;

/**
 *
 * @author ZAHRA
 */

//********************************************************************
// Shape.java
//
// Represents a generic geometric shape. This is an abstract class
// that serves as the parent of all specific shape classes.
// Each derived class must implement the area() method.
//********************************************************************

public abstract class Shape {
    protected String shapeName;

    //-----------------------------------------------------------------
    // Sets up the shape with the given name. Called by constructors
    // of derived classes via super().
    //-----------------------------------------------------------------
    public Shape(String shapeName) {
        this.shapeName = shapeName;
    }

    //-----------------------------------------------------------------
    // Returns the area of this shape.
    //-----------------------------------------------------------------
    public abstract double area();

    //-----------------------------------------------------------------
    // Returns the name of this shape as a string.
    //-----------------------------------------------------------------
    public String toString() {
        return shapeName;
    }
}