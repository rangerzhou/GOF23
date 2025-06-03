package behavioral.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * 4. 看管者 (Caretaker) - 存档管理器
 */
public class SaveLoadManager {
    private final List<GameMemento> savePoints = new ArrayList<>();

    // 保存一个存档点
    public void addSavePoint(GameMemento savePoint) {
        savePoints.add(savePoint);
        System.out.println("添加存档：" + savePoint.getTimestamp());
    }

    // 获取某个存档点
    public GameMemento getSavePoint(int index) {
        if (index >= 0 && index < savePoints.size()) {
            System.out.println("加载存档：" + savePoints.get(index).getTimestamp());
            return savePoints.get(index);
        }
        return null;
    }

    void showMementoPoints() {
        System.out.println("------------------当前存档列表------------------");
        for (GameMemento memento : savePoints) {
            System.out.println(memento.toString());
        }
    }

}
