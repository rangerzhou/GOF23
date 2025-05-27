package creational.prototype;

import java.util.List;

/**
 * 原型接口
 */
public interface CloneableProfile extends Cloneable {
    public CloneableProfile clone() throws CloneNotSupportedException;

    void setUsername(String username);

    void setAge(int age);

    void setSkills(List<String> skills);

    String getUsername();

    int getAge();

    List<String> getSkills();

}
