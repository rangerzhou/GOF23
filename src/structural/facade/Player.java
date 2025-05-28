package structural.facade;

public class Player {
    public void play(String title) {
        System.out.println("正在播放: " + title);
    }

    public void stop() {
        System.out.println("停止播放");
    }
}
