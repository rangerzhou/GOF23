package structural.decorator;

public class Test {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + ", 价格：" + coffee.getCost());

        coffee = new Caramel(coffee);
        System.out.println(coffee.getDescription() + ", 价格：" + coffee.getCost());

        coffee = new MilkFoam(coffee);
        System.out.println(coffee.getDescription() + ", 价格：" + coffee.getCost());
    }
}
