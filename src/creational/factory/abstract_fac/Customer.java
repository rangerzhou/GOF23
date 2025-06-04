package creational.factory.abstract_fac;

public class Customer {
    public static void main(String[] args) {
        System.out.println("=====小米系列产品=====");
        IFactory xiaomiFactory = new XiaomiFactory();

        ICar xiaomiCar = xiaomiFactory.createCar();
        xiaomiCar.powerOn();
        xiaomiCar.navigation();
        xiaomiCar.powerOff();

        IPhone xiaomiPhone = xiaomiFactory.createPhone();
        xiaomiPhone.powerOn();
        xiaomiPhone.sendSMS();
        xiaomiPhone.powerOff();

        System.out.println("=====华为系列产品=====");
        IFactory huaweiFactory = new HuaweiFactory();

        ICar huaweiCar = huaweiFactory.createCar();
        huaweiCar.powerOn();
        huaweiCar.navigation();
        huaweiCar.powerOff();

        IPhone huaweiPhone = huaweiFactory.createPhone();
        huaweiPhone.powerOn();
        huaweiPhone.sendSMS();
        huaweiPhone.powerOff();
    }

}
