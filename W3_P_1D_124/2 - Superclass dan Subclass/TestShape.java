package tugas2;

/**
 *
 * @author ZAHRA
 */

public class TestShape {
    public static void main(String[] args) {
        
        System.out.println("--- TEST SHAPE ---");
        Shape s1 = new Shape("blue", true);
        System.out.println("Shape 1:"
                + "\n color=" + s1.getColor()
                + "\n filled=" + s1.isFilled()
                + "\n toString=" + s1.toString());

        s1.setColor("orange");
        s1.setFilled(false);
        System.out.println("Shape 1 setelah setter:"
                + "\n color=" + s1.getColor()
                + "\n filled=" + s1.isFilled());
        
        System.out.println("\n--- TEST CIRCLE ---");
        Circle c1 = new Circle();
        System.out.println("Circle 1:"
                + "\n radius=" + c1.getRadius()
                + "\n color=" + c1.getColor()
                + "\n filled=" + c1.isFilled()
                + "\n area=" + c1.getArea()
                + "\n perimeter=" + c1.getPerimeter()
                + "\n toString=" + c1.toString());

        c1.setRadius(3.5);
        c1.setColor("purple");
        c1.setFilled(false);
        System.out.println("Circle 1 setelah setter:"
                + "\n radius=" + c1.getRadius()
                + "\n color=" + c1.getColor()
                + "\n filled=" + c1.isFilled());
        
        Circle c2 = new Circle(5.0, "red", false);
        System.out.println("Circle 2:"
                + "\n radius=" + c2.getRadius()
                + "\n color=" + c2.getColor()
                + "\n filled=" + c2.isFilled()
                + "\n area=" + c2.getArea()
                + "\n perimeter=" + c2.getPerimeter()
                + "\n toString=" + c2.toString());

        System.out.println("\n--- TEST RECTANGLE ---");
        Rectangle r1 = new Rectangle(4.0, 6.0);
        System.out.println("Rectangle 1:"
                + "\n width=" + r1.getWidth()
                + "\n length=" + r1.getLength()
                + "\n color=" + r1.getColor()
                + "\n filled=" + r1.isFilled()
                + "\n area=" + r1.getArea()
                + "\n perimeter=" + r1.getPerimeter()
                + "\n toString=" + r1.toString());

        r1.setWidth(7.0);
        r1.setLength(9.0);
        r1.setColor("green");
        r1.setFilled(false);
        System.out.println("Rectangle 1 setelah setter:"
                + "\n width=" + r1.getWidth()
                + "\n length=" + r1.getLength()
                + "\n color=" + r1.getColor()
                + "\n filled=" + r1.isFilled()
                + "\n area=" + r1.getArea()      // harus 63.0
                + "\n perimeter=" + r1.getPerimeter()); // harus 32.0
        
        Rectangle r2 = new Rectangle(3.0, 5.0, "yellow", false);
        System.out.println("Rectangle 2:"
                + "\n width=" + r2.getWidth()
                + "\n length=" + r2.getLength()
                + "\n color=" + r2.getColor()
                + "\n filled=" + r2.isFilled()
                + "\n area=" + r2.getArea()
                + "\n perimeter=" + r2.getPerimeter()
                + "\n toString=" + r2.toString());
    
        System.out.println("\n--- TEST SQUARE ---");
        Square sq1 = new Square();
        System.out.println("Square 1:"
                + "\n side=" + sq1.getSide()
                + "\n color=" + sq1.getColor()
                + "\n filled=" + sq1.isFilled()
                + "\n area=" + sq1.getArea()
                + "\n perimeter=" + sq1.getPerimeter()
                + "\n toString=" + sq1.toString());

        Square sq2 = new Square(4.0);
        System.out.println("Square 2:"
                + "\n side=" + sq2.getSide()
                + "\n color=" + sq2.getColor()
                + "\n filled=" + sq2.isFilled()
                + "\n area=" + sq2.getArea()        // harus 16.0
                + "\n perimeter=" + sq2.getPerimeter() // harus 16.0
                + "\n toString=" + sq2.toString());

        Square sq3 = new Square(5.0, "pink", true);
        System.out.println("Square 3:"
                + "\n side=" + sq3.getSide()
                + "\n color=" + sq3.getColor()
                + "\n filled=" + sq3.isFilled()
                + "\n area=" + sq3.getArea()        
                + "\n perimeter=" + sq3.getPerimeter() 
                + "\n toString=" + sq3.toString());

        sq2.setWidth(7.0);
        System.out.println("Square 2 setelah setWidth(7.0):"
                + "\n side=" + sq2.getSide()    
                + "\n width=" + sq2.getWidth()  
                + "\n length=" + sq2.getLength() 
                + "\n area=" + sq2.getArea()    
                + "\n perimeter=" + sq2.getPerimeter());

        sq2.setColor("navy");
        sq2.setFilled(false);
        System.out.println("Square 2 setelah setter color & filled:"
                + "\n color=" + sq2.getColor()
                + "\n filled=" + sq2.isFilled());
    }
}
