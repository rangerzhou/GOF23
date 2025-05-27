package creational.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体原型类：用户配置文件
 */
public class UserProfile implements CloneableProfile {
    private ArrayList<String> skills;
    private String username;
    private int age;

    public <E> UserProfile(String username, int age, List<String> skills) {
        this.username = username;
        this.age = age;
        this.skills = new ArrayList<>(skills);
    }

    @Override
    public CloneableProfile clone() {
        try {
            // 浅拷贝基本字段
            UserProfile clone = (UserProfile) super.clone();
            // 深拷贝技能列表
            clone.skills = new ArrayList<>(skills);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }

    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void setSkills(List<String> skills) {
        this.skills = new ArrayList<>(skills);
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public List<String> getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "skills=" + skills +
                ", username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
