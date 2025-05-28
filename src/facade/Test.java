package structural.facade;

public class Test {
    public static void main(String[] args) {
        // 创建子系统对象
        Projector projector = new Projector();
        SoundSystem soundSystem = new SoundSystem();
        Lights lights = new Lights();
        Player player = new Player();
        // 创建外观对象
        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(projector, soundSystem, lights, player);
        // 使用外观对象
        homeTheaterFacade.watchMovie("《星际穿越》");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\n3小时后电影播放完毕，准备退出观影模式...");
        homeTheaterFacade.endMovie();
    }
}
