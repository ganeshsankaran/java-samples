public class DecoratorPattern {
    public static void main(String[] args) {
        Pizza pizza = new PanPizza(9);
        pizza = new Cheese(pizza);
        System.out.println(pizza.getType());
        System.out.println(pizza.cost());
        pizza = new Pepperoni(pizza);
        System.out.println(pizza.getType());
        System.out.println(pizza.cost());

    }
}

abstract class Pizza {
    private int size;
    private String type;

    public int getSize() { return size; }
    public String getType() { return type; }
    public void setSize(int size) { this.size = size; }
    public void setType(String type) { this.type = type; }
    
    public abstract double cost();
}

abstract class ToppingDecorator extends Pizza {
    public abstract String getType();
}

class PanPizza extends Pizza {
    public PanPizza(int size) {
        this.setSize(size);
        this.setType("Pan Pizza");
    }

    public double cost() {
        return this.getSize() * this.getSize() * 0.10;
    }
}
class Cheese extends ToppingDecorator {
    private Pizza pizza;

    public Cheese(Pizza pizza) {
        this.pizza = pizza;
        this.setSize(pizza.getSize());
        this.setType(pizza.getType());
    }

    public String getType() { return pizza.getType() + " (+ cheese)"; }

    public double cost() { return pizza.getSize() * pizza.getSize() * 0.10; }
}

class Vegetable extends ToppingDecorator {
    private Pizza pizza;

    public Vegetable(Pizza pizza) {
        this.pizza = pizza;
        this.setSize(pizza.getSize());
        this.setType(pizza.getType());
    }

    public String getType() { return pizza.getType() + " (+ vegetables)"; }

    public double cost() { return pizza.getSize() * pizza.getSize() * 0.25; }
}

class Pepperoni extends ToppingDecorator {
    private Pizza pizza;

    public Pepperoni(Pizza pizza) {
        this.pizza = pizza;
        this.setSize(pizza.getSize());
        this.setType(pizza.getType());
    }

    public String getType() { return pizza.getType() + " (+ pepperoni)"; }

    public double cost() { return pizza.getSize() * pizza.getSize() * 0.50; }
}