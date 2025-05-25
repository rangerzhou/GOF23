package creational.factory.method_fac;

public class XiaomiFactory implements ICarFactory {
    @Override
    public ICar getCar() {
        return new XiaomiCar();
    }
}
