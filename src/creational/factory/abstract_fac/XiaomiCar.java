package creational.factory.abstract_fac;

public class XiaomiCar implements ICar {
    @Override
    public void powerOn() {
        System.out.println("小米汽车发动机启动");
    }

    @Override
    public void powerOff() {
        System.out.println("小米汽车发动机关闭");
    }

    @Override
    public void navigation() {
        System.out.println("小米汽车地图导航");
    }
}
