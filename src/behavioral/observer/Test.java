package behavioral.observer;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        TencentVideoSubject subject = new TencentVideoSubject();

        ViewerObserver xiaoming = new ViewerObserver();
        subject.registerObserver(xiaoming);

        try {

            subject.releaseNewEpisode("凡人修仙传", "第175集");
            Thread.sleep(1000);
            subject.releaseNewEpisode("仙逆", "第103集");
            Thread.sleep(2000);
            subject.releaseNewEpisode("遮天", "第99集");
            Thread.sleep(1000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
