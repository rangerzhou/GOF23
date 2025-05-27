package creational.singleton;

/**
 * 特点： 将单例实现为枚举类型。
 * 优点：
 * 最简洁： 代码非常简单。
 * 天然线程安全： 枚举的特性保证了其在多线程下的唯一性。
 * 防止反序列化创建新实例： 枚举类型在 Java 中是特殊的，JVM 会保证其单例性，即使通过反序列化也不会创建新的实例，这是其他方法难以做到的。
 * 防止反射攻击： 枚举类型没有公共构造函数，反射无法创建其实例。
 * 缺点：
 * 不适用于所有场景： 有些人认为枚举的语义更倾向于常量集合，而非单一对象。如果你的单例需要继承其他类（虽然通常不推荐单例继承），枚举就不适用。
 * 推荐程度： 被 Effective Java 的作者 Joshua Bloch 推荐为最佳实现方式之一
 */
public enum EnumSingleton {
    INSTANCE; // 唯一的实例

    public void showMessage() {
        System.out.println("EnumSingleton is created!");

    }
}
