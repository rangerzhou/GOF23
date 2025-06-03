package behavioral.visitor;

public class TaxCalculatorVisitor implements Visitor {
    @Override
    public void visitor(Salary salary) {
        System.out.println("计算工资税额：" + salary.getAmount() * 0.35);
    }

    @Override
    public void visitor(Bonus bonus) {
        System.out.println("计算奖金税额：" + bonus.getAmount() * 0.1);
    }
}
