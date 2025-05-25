package creational.factory.abstract_fac;

public class XiaomiFactory implements IProductFactory{
    @Override
    public IPhoneProduct iphoneProduct() {
        return new XiaomiPhone();
    }

    @Override
    public ICarProduct icarProduct() {
        return new XiaomiCar();
    }
}
