package behavioral.template_method;

public class Test {
    public static void main(String[] args) {
        System.out.println("冲咖啡！");
        Beverage coffee = new Coffee();
        coffee.prepareRecipe();

        System.out.println("泡茶！");
        Beverage tea = new Tea();
        tea.prepareRecipe();
    }
}
