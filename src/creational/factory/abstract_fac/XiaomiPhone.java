package creational.factory.abstract_fac;

public class XiaomiPhone implements IPhoneProduct {
    @Override
    public void powerOn() {
        System.out.println("小米手机开机");
    }

    @Override
    public void powerOff() {
        System.out.println("小米手机关机");
    }

    @Override
    public void sendSMS() {
        System.out.println("小米手机发短信");
    }
}
