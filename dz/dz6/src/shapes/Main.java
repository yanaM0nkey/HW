package shapes;


public class Main {
    public static void main(String[] args) {
    
        Shape square = new Square(5);
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(5,5);
        System.out.println("Square ");
        printArea(square);
        System.out.println("Circle ");
        printArea(circle);
        System.out.println("Rectangle ");
        printArea(rectangle);
       
    }
    public static void printArea(Shape shape){
        System.out.println(shape.getArea());
              
    }
}
