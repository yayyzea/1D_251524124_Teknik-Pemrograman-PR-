package tugas2;

/**
 *
 * @author ZAHRA
 */
public class Square extends Rectangle {
    
    //1st constructor
    public Square() {
        super(1.0, 1.0);
    }
    
    //2nd constructor
    public Square(double side) {
        super(side, side); // Call superclass Rectangle(double, double)
    }
    
    //3rd constructor
    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }
    
    //Getter and setter
    public double getSide() { 
        return getWidth(); 
    }
    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }
    
    @Override
    public void setWidth(double side) {
        super.setWidth(side);
        super.setLength(side);
    }
    
    @Override
    public void setLength(double side) {
        super.setLength(side);
        super.setWidth(side); 
    }
    
    @Override
    public String toString() {
        return "A Square with side=" + getSide() + ", which is a subclass of " + super.toString();
    }
    
}
