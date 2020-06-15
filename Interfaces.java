import java.util.ArrayList;
import java.util.Collections;

public class Interfaces {
    public static void main(String[] args) {
        ArrayList<Square> squares = new ArrayList<Square>();
        squares.add(new Square(3));
        squares.add(new Square(1));
        squares.add(new Square(5));
        squares.add(new Square(2));

        Collections.sort(squares);

        for(int i = 0; i < squares.size(); i++) {
            System.out.println(squares.get(i).perimeter() + "," + squares.get(i).area());
        }
    }
}

// abstract class
abstract class Shape {
    // abstract methods
    public abstract double perimeter();
    public abstract double area();
}

class Square extends Shape implements Comparable {
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

    // from Comparable interface
    public int compareTo(Object o) {
        Square s = (Square) o;
        if(this.side < s.side) return -1;
        else if(this.side > s.side) return 1;
        else return 0;
    }
}