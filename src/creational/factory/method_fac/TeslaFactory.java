package creational.factory.method_fac;

public class TeslaFactory implements ICarFactory {
    @Override
    public ICar getCar() {
        return new TeslaCar();
    }
}
