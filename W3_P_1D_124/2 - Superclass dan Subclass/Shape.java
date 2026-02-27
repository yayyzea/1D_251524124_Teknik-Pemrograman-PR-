package tugas2;

/**
 *
 * @author ZAHRA
 */
public class Shape {
    private String color; 
    private boolean filled;
    
    //1st constructor (default)
    public Shape() {
        this.color = "red";
        this.filled = true;
    }
    
    //2nd constructor (w parameter)
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }
    
    //Getter and setter
     public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public boolean isFilled() {
        return filled;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    
    @Override
    public String toString() {
        return "A Shape with color of " + color + " and " + (filled ? "filled" : "Not filled");
    }
    
}
