package behavioral.state;

public class Test {
    public static void main(String[] args) {
        TVContext tvContext = new TVContext();
        tvContext.pressPowerButton(); // 第1次按，按下执行开机
        tvContext.pressPowerButton(); // 第2次按，按下执行关机
        tvContext.pressPowerButton(); // 第3次按，按下执行开机
        tvContext.pressPowerButton(); // 第4次按，按下执行关机
        tvContext.pressPowerButton(); // 第5次按，按下执行开机
    }
}
