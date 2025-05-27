package structural.adapter;

public class Test {
    public static void main(String[] args) {
        System.out.println("测试对象适配器--------------------------------");
        EuropeanSocket europeanSocket = new EuropeanSocket();
        Charger adapter = new SocketObjectAdapter(europeanSocket);
        MobilePhone mobilePhone = new MobilePhone(adapter);
        mobilePhone.connect();

        System.out.println("测试类适配器--------------------------------");
        adapter = new SocketClassAdapter();
        mobilePhone = new MobilePhone(adapter);
        mobilePhone.connect();
    }
}
