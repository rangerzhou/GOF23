package behavioral.memento;

public class Test {
    public static void main(String[] args) {
        GameCharacter player = new GameCharacter(100, 0, 1, "Start");
        SaveLoadManager saveLoadManager = new SaveLoadManager();
        try {
            saveLoadManager.addSavePoint(player.createMemento());
            Thread.sleep(1000);

            player.playGame("run");
            saveLoadManager.addSavePoint(player.createMemento());
            Thread.sleep(1000);


            player.playGame("jump");
            saveLoadManager.addSavePoint(player.createMemento());
            Thread.sleep(1000);

            player.playGame("levelUp");
            saveLoadManager.addSavePoint(player.createMemento());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        player.printCurrentState();

        saveLoadManager.showMementoPoints();

        // 选择加载存档点 1
        System.out.println("\n--- 加载存档1 ---");
        GameMemento mementoToLoad = saveLoadManager.getSavePoint(1);
        player.restoreMemento(mementoToLoad);
        player.printCurrentState(); // 验证是否恢复到存档点 1 的状态

        // 加载初始存档点 0
        System.out.println("\n--- 加载存档0 ---");
        GameMemento initialMemento = saveLoadManager.getSavePoint(0);
        if (initialMemento != null) {
            player.restoreMemento(initialMemento);
        }
        player.printCurrentState(); // 验证是否恢复到初始状态

        System.out.println("\n--- 加载存档3 ---");
        GameMemento levelUpMemento = saveLoadManager.getSavePoint(3);
        if (levelUpMemento != null) {
            player.restoreMemento(levelUpMemento);
        }
        player.printCurrentState(); // 验证是否恢复到初始状态

    }
}
