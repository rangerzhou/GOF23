package structural.proxy;

public class RealDoor implements Door {
    @Override
    public void open() {
        System.out.println("开门...");
    }

    @Override
    public void close() {
        System.out.println("关门...");
    }
}
