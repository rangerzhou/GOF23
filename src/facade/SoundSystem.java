package structural.facade;

/**
 * 子系统类 2: 音响系统
 */
public class SoundSystem {
    public void turnOn() {
        System.out.println("打开音响");
    }

    public void turnOff() {
        System.out.println("关闭音响");
    }

    public void setVolume(int volume) {
        System.out.println("设置音响音量为 " + volume);
    }

    public void setMode(String mode) {
        System.out.println("设置音响模式为 " + mode);
    }
}
