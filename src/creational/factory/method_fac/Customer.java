package creational.factory.method_fac;

public class Customer {
    public static void main(String[] args) {
        ICarFactory teslaFactory = new TeslaFactory();
        ICar teslaCar = teslaFactory.getCar();
        teslaCar.createCar();

        ICarFactory xiaomiFactory = new XiaomiFactory();
        ICar xiaomiCar = xiaomiFactory.getCar();
        xiaomiCar.createCar();
    }

}
