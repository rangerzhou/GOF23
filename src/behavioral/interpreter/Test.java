package behavioral.interpreter;

public class Test {
    public static void main(String[] args) {
        Expression expression = new AddExpression(
                new NumberExpression(5),
                new SubtractExpression(
                        new NumberExpression(2),
                        new NumberExpression(3)));
        System.out.println("5 + 2 - 3 = " + expression.interpret());
    }
}
