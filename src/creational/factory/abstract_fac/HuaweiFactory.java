package creational.factory.abstract_fac;

public class HuaweiFactory implements IFactory {
    @Override
    public IPhone createPhone() {
        return new HuaweiPhone();
    }

    @Override
    public ICar createCar() {
        return new HuaweiCar();
    }
}
