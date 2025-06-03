package behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class TencentVideoSubject implements Subject {
    private List<Observer> viewers;

    public TencentVideoSubject() {
        this.viewers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        if (!viewers.contains(observer)) {
            viewers.add(observer);
        } else {
            System.out.println("该订阅者已存在");
        }
    }

    @Override
    public void unRegisterObserver(Observer observer) {
        viewers.remove(observer);
    }

    @Override
    public void notifyObservers(String title, String episode) {
        for (Observer viewer :
                viewers) {
            viewer.update(title, episode);
        }
    }

    public void releaseNewEpisode(String title, String episode) {
        System.out.println("\n电视剧 《" + title + "》 更新 " + episode);
        notifyObservers(title, episode);
    }
}
