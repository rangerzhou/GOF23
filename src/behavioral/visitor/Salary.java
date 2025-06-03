package behavioral.visitor;

public class Salary implements Taxable{
    private double amount;

    public Salary(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitor(this);
    }
}
