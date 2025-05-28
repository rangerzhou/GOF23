package structural.decorator;

public abstract class DecorateCoffee implements Coffee{
    protected Coffee decorateCoffee;

    public DecorateCoffee(Coffee decorateCoffee) {
        this.decorateCoffee = decorateCoffee;
    }

    /*@Override
    public String description() {
        return decorateCoffee.description();
    }

    @Override
    public double cost() {
        return decorateCoffee.cost();
    }*/
}
