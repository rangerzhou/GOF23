package structural.bridge;

public class ShapeRectangle extends Shape {
    public ShapeRectangle(Color color) {
        super(color);
    }

    @Override
    public String draw() {
        return "画一个" + color.applyColor() + "的矩形";
    }
}
