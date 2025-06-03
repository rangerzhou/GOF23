package behavioral.state;

public class TVOffState implements TVState {
    @Override
    public void pressPowerButton(TVContext tvContext) {
        System.out.println("当前是关机状态，准备开机...");
        tvContext.setState(new TVOnState());
    }
}
