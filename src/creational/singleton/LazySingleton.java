package creational.singleton;

/**
 * 特点： 只有在第一次调用 getInstance() 方法时才创建单例实例。
 * 优点：
 * 懒加载： 实现了延迟加载，节省了资源，尤其适用于单例对象创建开销大且不常用时。
 * 缺点：
 * 线程不安全（初始版本）： 在多线程环境下，多个线程可能同时进入 if (instance == null) 判断，导致创建多个实例。
 * 同步开销： 为了解决线程安全问题，需要引入同步机制，但这会带来性能开销。
 */
public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
    }

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("LazySingleton is created!");
    }
}
