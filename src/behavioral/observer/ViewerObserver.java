package behavioral.observer;

public class ViewerObserver implements Observer {
    private String title;
    private String episode;

    @Override
    public void update(String title, String episode) {
        this.title = title;
        this.episode = episode;
        System.out.println("收到通知：电视剧 《" + title + "》 更新 " + episode);
        pushWeChatNotify();
    }

    private void pushWeChatNotify() {
        System.out.println("推送微信通知：电视剧 《" + title + "》 更新 " + episode);
    }

}
