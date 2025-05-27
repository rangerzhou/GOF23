package creational.prototype;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        // 创建原型对象
        UserProfile prototype = new UserProfile("John", 30, List.of("Java", "Spring", "C++"));
        System.out.println("Prototype: " + prototype);

        // 克隆并修改新对象
        UserProfile clone = (UserProfile) prototype.clone();
        clone.setUsername("Ranger");
        clone.setAge(18);
        clone.getSkills().add("Kotlin");

        System.out.println("Clone: " + clone);

    }
}
