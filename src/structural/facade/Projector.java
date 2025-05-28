package structural.facade;

/**
 * 子系统类 1: 投影仪
 */
public class Projector {
    public void turnOn() {
        System.out.println("打开投影仪");
    }

    public void turnOff() {
        System.out.println("关闭投影仪");
    }

    public void setInputSource(String source) {
        System.out.println("设置投影仪输入源为 " + source);
    }
}
