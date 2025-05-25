package creational.factory.abstract_fac;

public class HuaweiPhone implements IPhoneProduct {
    @Override
    public void powerOn() {
        System.out.println("华为手机开机");
    }

    @Override
    public void powerOff() {
        System.out.println("华为手机关机");
    }

    @Override
    public void sendSMS() {
        System.out.println("华为手机发短信");
    }
}
