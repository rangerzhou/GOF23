package structural.decorator;

public class Caramel extends DecorateCoffee {
    public Caramel(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decorateCoffee.getDescription() + ", 加上焦糖";
    }

    @Override
    public double getCost() {
        return decorateCoffee.getCost() + 1.5;
    }
}
