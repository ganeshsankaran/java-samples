public class Classes {
    public static void main(String[] args) {
        Car car = new Car(2017, "Honda", "Accord", 120.0);
        System.out.println("=====Car 1=====");
        System.out.println(car.getN());
        System.out.println(car.speed);
        System.out.println(car.getMake() + ' ' + car.getModel());

        Car car2 = new Car(2012, "Toyota", "Camry", 115.0);
        System.out.println("=====Car 2=====");
        System.out.println(car2.getN());
        car2.setSpeed("100");
        System.out.println(car2.getSpeed());
        System.out.println(Car.speedKPH(car2.getSpeed()));

        Car car3 = new Car(2009, "Ford", "Taurus", 145.0);
        System.out.println("=====Car 3=====");
        System.out.println(car3.getSpeed());
        upgrade(car3);
        System.out.println(car3.getMake() + " " + car3.getModel());
        System.out.println(car3.getSpeed());

        Car car4 = new Car(2009, "Chevrolet", "Equinox", 170.0, new Engine("V8"));
        System.out.println("=====Car 4=====");
        System.out.println(car4.getEngine().getType());
        Car car4Copy = car4;
        System.out.println(car4Copy.getEngine().getType());

    }

    // pass reference to object by value
    public static void upgrade(Car car) {
        car.setSpeed(car.getSpeed() * 1.25); 
        car = new Car(2020, "Subaru", "Outback", 150.0);
    }
}

class Car {
    private int year;
    private String make;
    private String model;
    public double speed;

    private Engine engine;

    private static int n;

    // constructor
    public Car(int year, 
                String make, 
                String model, 
                double speed) {

        this.year = year;
        this.make = make;
        this.model = model;
        this.speed = speed;
        this.engine = new Engine("V6");
        n++;
    }

    public Car(int year, 
                String make, 
                String model, 
                double speed,
                Engine engine) {

        this.year = year;
        this.make = make;
        this.model = model;
        this.speed = speed;
        this.engine = engine;
        n++;
    }

    // copy constructor (deep copy)
    public Car(Car c) {
        this.year = c.year;
        this.make = c.make;
        this.model = c.model;
        this.speed = c.speed;
        this.engine = new Engine(c.getEngine().getType());
    }

    // getters
    public int getYear() { return this.year; }
    public String getMake() { return this.make; }
    public String getModel() { return this.model; }
    public double getSpeed() { return this.speed; }
    public Engine getEngine() { return this.engine; }

    // setters
    public void setYear(int year) { this.year = year; }
    public void setMake(String make) { this.make = make; }
    public void setModel(String model) { this.model = model; }
    public void setEngine(Engine engine) { this.engine = engine; }

    // overloading setSpeed
    public void setSpeed(double speed) { this.speed = speed; }
    public void setSpeed(int speed) { this.speed = (double) speed; }
    public void setSpeed(short speed) { this.speed = (double) speed; }
    public void setSpeed(String speed) { this.speed = (double) Integer.parseInt(speed); }

    // getters for static fields
    public int getN() { return n; }

    // static method
    public static double speedKPH(double speed) {
        return speed * 1.60934;
    }
}

class Engine {
    private String type;

    public Engine(String type) {
        this.type = type;
    }

    public String getType() { return this.type; }
    
    public void setType(String type) { this.type = type; }
}