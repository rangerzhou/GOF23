package behavioral.strategy;

public class Test {
    public static void main(String[] args) {
        TVContext tvContext = new TVContext();

        tvContext.setState(new TVOffState()); // 设置为关机状态，按下则开机
        tvContext.pressPowerButton();
        tvContext.setState(new TVOnState()); // 设置为开机状态，按下则关机
        tvContext.pressPowerButton();
        tvContext.setState(new TVOnState());
        tvContext.pressPowerButton();
        tvContext.setState(new TVOffState());
        tvContext.pressPowerButton();
        tvContext.setState(new TVOnState());
        tvContext.pressPowerButton();
    }
}
