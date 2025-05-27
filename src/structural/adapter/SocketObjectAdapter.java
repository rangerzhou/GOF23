package structural.adapter;

/**
 * 适配器2：对象适配器，实现目标接口并封装被适配者，转换接口以满足客户端需求
 */
public class SocketObjectAdapter implements Charger {
    private final EuropeanSocket europeanSocket;

    public SocketObjectAdapter(EuropeanSocket europeanSocket) {
        this.europeanSocket = europeanSocket;
    }

    @Override
    public void provide12V() {
        System.out.println("对象适配器：12V <---> 220V");
        europeanSocket.provide220V();
    }
}
