package structural.decorator;

public class MilkFoam extends DecorateCoffee {
    public MilkFoam(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decorateCoffee.getDescription() + ", 加上奶泡";
    }

    @Override
    public double getCost() {
        return decorateCoffee.getCost() + 2.0;
    }
}
