package creational.singleton;

/**
 * 特点： 在 getInstance() 方法中使用两次 null 检查，并配合 synchronized 关键字和 volatile 关键字。
 * <p>
 * 优点：
 * 线程安全： 在多线程环境下安全。
 * 性能优化： 只有在第一次创建实例时才进行同步，后续获取实例时无需同步，避免了同步开销。
 * 懒加载： 依然保持了懒加载的特性。
 * <p>
 * 缺点：
 * 实现复杂： 需要 volatile 关键字来防止指令重排，确保正确性（在 Java 5 之前 DCL 有问题，Java 5 及之后 volatile 保证了其正确性）。
 * 可读性稍差： 相比饿汉式。
 */
public class DCLSingleton {
    // 使用 volatile 关键字，防止指令重排，确保多线程下 DCL 的正确性
    private static volatile DCLSingleton instance;

    private DCLSingleton() {
    }

    public static DCLSingleton getInstance() {
        if (instance == null) { // 第一次检查：避免不必要的同步
            synchronized (DCLSingleton.class) { // 同步块，只在第一次创建时进入
                if (instance == null) { // 第二次检查：确保在多线程环境下只创建一个实例
                    instance = new DCLSingleton();
                }
            }
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("DCLSingleton is created!");
    }
}
