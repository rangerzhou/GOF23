package creational.factory.method_fac;

public class TeslaCar implements ICar {
    @Override
    public void createCar() {
        System.out.println("创建特斯拉汽车");
    }
}
