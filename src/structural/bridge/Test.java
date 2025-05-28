package structural.bridge;

public class Test {
    public static void main(String[] args) {
        Color red = new ColorRed();
        Color blue = new ColorBlue();

        Shape redCircle = new ShapeCircle(red);
        System.out.println(redCircle.draw());

        Shape blueCircle = new ShapeCircle(blue);
        System.out.println(blueCircle.draw());

        Shape redRectangle = new ShapeRectangle(red);
        System.out.println(redRectangle.draw());

        Shape blueRectangle = new ShapeRectangle(blue);
        System.out.println(blueRectangle.draw());
    }
}
