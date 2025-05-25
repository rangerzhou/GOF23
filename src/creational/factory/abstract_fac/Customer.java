package creational.factory.abstract_fac;

public class Customer {
    public static void main(String[] args) {
        System.out.println("=====小米系列产品=====");
        XiaomiFactory xiaomiFactory = new XiaomiFactory();

        ICarProduct xiaomiCar = xiaomiFactory.icarProduct();
        xiaomiCar.powerOn();
        xiaomiCar.navigation();
        xiaomiCar.powerOff();

        IPhoneProduct xiaomiPhone = xiaomiFactory.iphoneProduct();
        xiaomiPhone.powerOn();
        xiaomiPhone.sendSMS();
        xiaomiPhone.powerOff();

        System.out.println("=====华为系列产品=====");
        HuaweiFactory huaweiFactory = new HuaweiFactory();

        ICarProduct huaweiCar = huaweiFactory.icarProduct();
        huaweiCar.powerOn();
        huaweiCar.navigation();
        huaweiCar.powerOff();

        IPhoneProduct huaweiPhone = huaweiFactory.iphoneProduct();
        huaweiPhone.powerOn();
        huaweiPhone.sendSMS();
        huaweiPhone.powerOff();
    }

}
