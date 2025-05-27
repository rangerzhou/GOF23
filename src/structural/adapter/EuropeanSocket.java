package structural.adapter;

/**
 * Adaptee：适配者，被适配的类，表示现有不兼容的接口
 */
public class EuropeanSocket {
    void provide220V(){
        System.out.println("欧洲提供220V");
    }
}
