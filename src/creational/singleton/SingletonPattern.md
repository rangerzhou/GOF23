## 1 饿汉式（类加载时初始化）

``` java
public class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
```

**特点**：

- 类加载时创建对象，不管用不用都会初始化
- 线程安全，简单直接
- 不适合资源占用大的对象

**是否懒加载**：否
**线程安全**：是
**推荐**：一般，适合不耗资源的单例对象

## 2 懒汉式（同步方法，线程安全但效率低）

``` java
public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

**特点**：

- 只有第一次调用时才创建对象（懒加载）
- 整个方法加锁，效率低

**是否懒加载**：是
**线程安全**：是（但性能差）
**推荐**：不推荐

## 3 双重检查锁（DCL, Double-Checked Locking）

``` java
public class Singleton {
    private static volatile Singleton instance; // 注意这里要添加 volatile

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```

**关键点**：

- `volatile` 防止指令重排
- 第一次检查避免无谓加锁，第二次检查保证安全

**是否懒加载**：是
**线程安全**：是
**推荐**：✅ 推荐，适合多线程环境

## 4 静态内部类（最推荐方式）

``` java
public class Singleton {
    private Singleton() {}

    private static class Holder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return Holder.INSTANCE;
    }
}
```

**特点**：

- 利用类加载机制保证线程安全
- 延迟加载 + 高性能 + 代码简洁
- 类加载是线程安全的，且只会加载一次

**是否懒加载**：是
**线程安全**：是
**推荐**：✅✅ 推荐

### a. 反射 & 反序列化破坏单例演示

- **序列化（Serialization）**：将对象转换成字节流（如 `.ser` 文件），便于保存或传输。
- **反序列化（Deserialization）**：将字节流恢复为 Java 对象。

什么是“反序列化攻击”？

攻击者构造恶意的字节流数据（伪造对象），在目标系统中进行 **反序列化操作** 时触发不安全逻辑，例如：

- **执行任意方法或代码（RCE）**
- **绕过权限验证**
- **修改对象状态（如单例破坏）**

**反射攻击代码**

``` shell
import java.lang.reflect.Constructor;

public class ReflectionAttack {
    public static void main(String[] args) throws Exception {
        Singleton instance1 = Singleton.getInstance();

        Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
        constructor.setAccessible(true); // 跳过检查：可以访问private构造器
        Singleton instance2 = constructor.newInstance();

        System.out.println("instance1 == instance2? " + (instance1 == instance2));
    }
}
```

输出结果：

``` java
Exception in thread "main" java.lang.RuntimeException: Already initialized
```

**反序列化攻击代码**

``` java
import java.io.*;

public class SerializationAttack {
    public static void main(String[] args) throws Exception {
        Singleton instance1 = Singleton.getInstance();

        // Serialize
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("singleton.ser"));
        out.writeObject(instance1);
        out.close();

        // Deserialize
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("singleton.ser"));
        Singleton instance2 = (Singleton) in.readObject();
        in.close();

        System.out.println("instance1 == instance2? " + (instance1 == instance2));
    }
}
```

加了 `readResolve()` 方法后，输出：

``` shell
instance1 == instance2? true
```



另外可以优化，防止反射攻击和反序列化攻击

``` java
import java.io.Serializable;

public class Singleton implements Serializable {
    private Singleton() {
        // 防反射攻击
        if (Holder.INSTANCE != null) {
            throw new RuntimeException("Already initialized");
        }
    }

    private static class Holder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return Holder.INSTANCE;
    }

    // 防止反序列化攻击
    protected Object readResolve() {
        return getInstance();
    }
}
```



## 5 枚举单例（极致简洁、安全）

``` java
public enum Singleton {
    INSTANCE;

    public void doSomething() {
        System.out.println("Doing something...");
    }
}
```

**特点**：

- 自动防止反射和反序列化攻击
- 极简、最安全
- 枚举本身是线程安全的

**是否懒加载**：是（在第一次使用时加载）
**线程安全**：是
**推荐**：✅ 推荐（尤其适合 Java 枚举场景）

❗ 什么时候不推荐枚举单例？

- 如果你需要延迟加载（懒初始化）**并且**构造函数非常重，例如启动加载配置、连接数据库等，**静态内部类**更合适；
- 如果你使用的是 Android，**枚举有额外开销**（虽然不大），且很多 Android 项目更倾向使用静态内部类方式。


## 6 总结对比

| 实现方式          | 懒加载 | 线程安全 | 性能   | 是否推荐    |
| ----------------- | ------ | -------- | ------ | ----------- |
| 饿汉式            | 否     | 是       | 高     | 一般        |
| 懒汉式（同步）    | 是     | 是       | 差     | ❌ 不推荐    |
| 双重检查锁（DCL） | 是     | 是       | 较高   | ✅ 推荐      |
| 静态内部类        | 是     | 是       | ✅ 极高 | ✅✅ 强烈推荐 |
| 枚举单例          | 是     | 是       | ✅ 极高 | ✅ 推荐      |
