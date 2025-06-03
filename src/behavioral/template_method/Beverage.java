package behavioral.template_method;

public abstract class Beverage {
    public final void prepareRecipe() {
        boilWater(); // 烧水，通用操作，父类实现
        brew(); // 冲泡，抽象类，子类实现
        pourInCup(); // 倒进杯子，通用操作，父类实现
        addCondiments(); // 加料，抽象类，子类实现
    }

    private void boilWater() {
        System.out.println("烧水...");
    }

    private void pourInCup() {
        System.out.println("倒进杯子...");
    }

    protected abstract void brew();

    protected abstract void addCondiments();
}
