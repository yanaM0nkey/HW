package shapes;


public class Rectangle extends Shape{
    private double side1;

    public Rectangle(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }
    private double side2;

    @Override
    public double getArea() {
        return side1*side2;
    }
    
    
    
    
}
