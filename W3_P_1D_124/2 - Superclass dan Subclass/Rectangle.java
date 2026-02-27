package tugas2;

/**
 *
 * @author ZAHRA
 */
public class Rectangle extends Shape {
    private double width;
    private double length;
    
    //1st constructor
    public Rectangle(){
        super();
        this.width = 1.0;
        this.length = 1.0;
    }
    
    //2nd constructor
    public Rectangle (double width, double length){
        super();
        this.width = width;
        this.length = length;
    }
    
    //3rd constructor
    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);  
        this.width = width;
        this.length = length;
    }
    
    //Getter and setter
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }
    
    public double getArea() {         
        return width * length; 
    } 
    
    public double getPerimeter() {
        return 2 * (width + length);
    }
    
    @Override
    public String toString() {
        return "A Rectangle with width=" + width + " and length=" + length + ", which is a subclass of " + super.toString();
    }
    
}
