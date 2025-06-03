package behavioral.template_method;

public class Tea extends Beverage {
    @Override
    protected void brew() {
        System.out.println("用沸水浸泡茶叶...");
    }

    @Override
    protected void addCondiments() {
        System.out.println("加柠檬...");
    }
}
