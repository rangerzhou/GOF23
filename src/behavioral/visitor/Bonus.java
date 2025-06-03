package behavioral.visitor;

public class Bonus implements Taxable{
    private double amount;

    public Bonus(double amount) {
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
