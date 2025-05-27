package structural.adapter;

/**
 * 适配器1：类适配器，实现目标接口并封装被适配者，转换接口以满足客户端需求
 */
public class SocketClassAdapter extends EuropeanSocket implements Charger {
    @Override
    public void provide12V() {
        System.out.println("类适配器：12V <---> 220V");
        provide220V();
    }
}
