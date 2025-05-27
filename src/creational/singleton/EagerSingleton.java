package creational.singleton;

/**
 * 特点： 在类加载时就立即创建并初始化单例实例。
 * 优点：
 * 线程安全： 由于实例在类加载时就创建，所以是天然线程安全的。不需要额外的同步机制。
 * 实现简单： 代码非常简洁。
 * 缺点：
 * 类加载时创建： 无论是否真正使用到这个单例实例，它都会在类加载时被创建。如果单例对象的创建开销很大，或者它不经常使用，这会造成资源浪费（没有达到懒加载的效果）。
 */
public class EagerSingleton {
    // 在类加载时立即创建实例
    private static final EagerSingleton INSTANCE = new EagerSingleton();

    // 私有化构造器，防止外部直接实例化
    private EagerSingleton() {
    }

    // 提供静态方法获取实例
    public static EagerSingleton getInstance() {
        return INSTANCE;
    }

    public void showMessage() {
        System.out.println("EagerSingleton is created!");
    }

}
