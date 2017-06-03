package shapes;

import static java.lang.Math.pow;


public class Square extends Shape{

    private double side;

    public Square(double length) {
        this.side = length;
    }
    
    @Override
    public double getArea() {
        double area = pow(side,2);
        return area;
    }
    
}
