package behavioral.visitor;

public interface Visitor {
    void visitor(Salary salary); // 访问工资类
    void visitor(Bonus bonus); // 访问奖金类
}
