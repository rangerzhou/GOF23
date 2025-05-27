package structural.adapter;

/**
 * 客户端：使用目标接口与适配器交互
 */
public class MobilePhone {
    Charger target;
    public MobilePhone(Charger target) {
        this.target = target;
    }

    void connect(){
        System.out.println("客户端请求：手机需要12V充电器");
        target.provide12V();
    }
}
