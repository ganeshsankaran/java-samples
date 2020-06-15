public class AbstractClasses {
    public static void main(String[] args) {
        // Shape shape = new Shape();
        Shape square = new Square(5);
        Shape circle = new Circle(5);

        System.out.println(square.perimeter() + "," + square.area());
        System.out.println(circle.perimeter() + "," + circle.area());
    }
}

// abstract class
abstract class Shape {
    // abstract methods
    public abstract double perimeter();
    public abstract double area();
}

class Square extends Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double perimeter() {
        return 4 * this.side;
    }

    public double area() {
        return this.side * this.side;
    }
}

class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }

    public double perimeter() {
        return 2 * 3.14 * this.radius;
    }

    public double area() {
        return 3.14 * this.radius * this.radius;
    }
}