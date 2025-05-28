package structural.decorator;

public class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "普通咖啡";
    }

    @Override
    public double getCost() {
        return 5;
    }
}
