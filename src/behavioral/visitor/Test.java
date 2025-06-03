package behavioral.visitor;

public class Test {
    public static void main(String[] args) {
        Salary salary = new Salary(30000);
        Bonus bonus = new Bonus(80000);

        TaxCalculatorVisitor visitor = new TaxCalculatorVisitor();
        salary.accept(visitor);
        bonus.accept(visitor);


    }
}
