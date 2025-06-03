package behavioral.strategy;

public class TVOnState implements TVState {
    @Override
    public void pressPowerButton(TVContext tvContext) {
        System.out.println("当前是开机状态，准备关机...");
    }
}
