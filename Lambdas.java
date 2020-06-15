import java.util.ArrayList;
import java.util.Collections;

public class Lambdas {
    public static void main(String[] args) {
        // Animal dog = new Animal();
        Animal dog = new Animal() {
            public void speak() { System.out.println("Woof"); }
        };

        ArrayList<Animal> animals = new ArrayList<Animal>();
        animals.add(dog);
        animals.add(new Animal() {
            public void speak() { System.out.println("Meow"); }
        });

        for(Animal animal : animals) {
            animal.speak();
        }

        Animal cow = () -> { System.out.println("Moo"); };

        // sorting
        ArrayList<Square> squares = new ArrayList<Square>();
        squares.add(new Square(3));
        squares.add(new Square(1));
        squares.add(new Square(5));
        squares.add(new Square(2));
        
        Collections.sort(squares, (s1, s2) -> {
            if(s1.area() < s2.area()) return -1;
            else if(s1.area() > s2.area()) return 1;
            else return 0;
        });

        for(Square s : squares) {
            System.out.println(s.perimeter() + "," + s.area());
        }

        // threads
        Thread t1 = new Thread(() -> {
            System.out.println("Sleeping for 5 seconds...");
            try { Thread.sleep(5000); } catch(Exception e) {}
        });

        t1.start();
    }
}

// anonymous class
// must have only one abstract method
@FunctionalInterface
interface Animal {
    public void speak();
}

class Square {
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