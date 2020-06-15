import java.util.ArrayList;

public class Inheritance {
    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car(2017, "Honda", "Civic", 120, 2000);
        Vehicle car3 = new Car(2017, "Toyota", "Camry", 115, 2100); // dynamic binding

        Convertible convertible = new Convertible(2018, "Rolls-Royce", "Wraith", 150, 4000, false);
        System.out.println(convertible instanceof Convertible);
        System.out.println(convertible instanceof Car);
        System.out.println(convertible instanceof Vehicle);
        System.out.println(convertible instanceof Object);

        System.out.println(convertible.getClass().equals(Convertible.class));
        System.out.println(convertible.getClass().equals(Car.class));
        System.out.println(convertible.getClass().equals(Vehicle.class));
        System.out.println(convertible.getClass().equals(Object.class));

        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        vehicles.add(car1);
        vehicles.add(car2);
        vehicles.add(car3);
        vehicles.add(convertible);

        for(int i = 0; i < vehicles.size(); i++) {
            System.out.println(vehicles.get(i).toString());
        }
    }
}

class Vehicle {
    private double speed;
    private double weight;

    public Vehicle() { System.out.println("Vehicle()"); } // default constructor
    public Vehicle(double speed, double weight) {
        this.speed = speed;
        this.weight = weight;
        System.out.println("Vehicle(" + speed + "," + weight + ")");
    }

    public String toString() {
        return "speed = " + this.speed + ", weight = " + this.weight;
    }
}

class Car extends Vehicle {
    private int year;
    private String make;
    private String model;

    public Car() { System.out.println("Car()"); } // default constructor
    public Car(int year, String make, String model, double speed, double weight) {
        super(speed, weight);
        this.year = year;
        this.make = make;
        this.model = model;
        System.out.println("Car(" + year + "," + 
                                    make + "," +
                                    model + "," +
                                    speed + "," +
                                    weight + ")");   
    }

    public String toString() {
        return this.year + " " + this.make + " " + this.model + " (" + super.toString() + ")";
    }
}

final class Convertible extends Car {
    private boolean top;

    public Convertible(int year, String make, String model, double speed, double weight, boolean top) {
        super(year, make, model, speed, weight);
        this.top = top;
        System.out.println("Convertible(" + year + "," + 
                                    make + "," +
                                    model + "," +
                                    speed + "," +
                                    weight + "," +
                                    top + ")");   
    }

    public String toString() {
        if (top) {
            return super.toString() + " (top up)";
        };
        return super.toString() + " (top down)";
    }
}