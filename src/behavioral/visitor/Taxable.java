package behavioral.visitor;

public interface Taxable {
    void accept(Visitor visitor);
}
