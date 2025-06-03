package behavioral.template_method;

public class Coffee extends Beverage {
    @Override
    protected void brew() {
        System.out.println("用沸水冲泡咖啡...");
    }

    @Override
    protected void addCondiments() {
        System.out.println("加糖和牛奶...");
    }
}
