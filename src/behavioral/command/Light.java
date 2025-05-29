package behavioral.command;

/**
 * 请求的接收者
 */
public class Light {
    public void turnOn() {
        System.out.println("开灯");
    }

    public void turnOff() {
        System.out.println("关灯");
    }
}
