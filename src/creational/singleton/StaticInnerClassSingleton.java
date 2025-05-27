package creational.singleton;

/**
 * 特点： 将单例实例的创建放在一个静态内部类中。
 * 优点：
 * 线程安全： JVM 确保了静态内部类在被加载时是线程安全的。
 * 懒加载： 只有在第一次调用 getInstance() 方法时，SingletonHolder 类才会被加载，从而创建实例。
 * 实现简洁高效： 兼具懒汉式的优点和饿汉式的简洁。
 * 缺点： 无明显缺点，被认为是最推荐的实现方式之一。
 */
public class StaticInnerClassSingleton {
    private StaticInnerClassSingleton() {

    }

    // 静态内部类，只有在第一次使用时才会被加载
    private static class SingletonHolder {
        private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void showMessage() {
        System.out.println("StaticInnerClassSingleton is created!");
    }
}
