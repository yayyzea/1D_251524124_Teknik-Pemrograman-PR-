package tugas2;

/**
 *
 * @author ZAHRA
 */
public class Circle extends Shape {
    private double radius;
    
    //1st constructor (inisialisasi radius 1.0)
    public Circle (){
        super ();
        this.radius = 1.0;
    }
    
    //2nd constructor 
    public Circle(double radius) {
        super(); 
        this.radius = radius;
    }
    
    //3rd consructor
    public Circle(double radius, String color, boolean filled) {
        super(color, filled); 
        this.radius = radius;
    }
    
    //Getter and setter for radius
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    public double getArea() {         
        return radius * radius * Math.PI; 
    } 
    
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
    
    @Override
    public String toString() {
        return "A Circle with radius=" + radius + ", which is a subclass of " + super.toString();
    }
}
