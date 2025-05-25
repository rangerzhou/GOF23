package creational.factory.abstract_fac;

public class HuaweiFactory implements IProductFactory {
    @Override
    public IPhoneProduct iphoneProduct() {
        return new HuaweiPhone();
    }

    @Override
    public ICarProduct icarProduct() {
        return new HuaweiCar();
    }
}
