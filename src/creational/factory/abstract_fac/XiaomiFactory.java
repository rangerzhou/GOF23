package creational.factory.abstract_fac;

public class XiaomiFactory implements IFactory {
    @Override
    public IPhone createPhone() {
        return new XiaomiPhone();
    }

    @Override
    public ICar createCar() {
        return new XiaomiCar();
    }
}
