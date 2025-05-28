package structural.bridge;

public class ShapeCircle extends Shape {
    public ShapeCircle(Color color) {
        super(color);
    }

    @Override
    public String draw() {
        return "画一个" + color.applyColor() + "的圆形";
    }
}
