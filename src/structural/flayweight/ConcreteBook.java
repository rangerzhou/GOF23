package structural.flayweight;

public class ConcreteBook implements BookFlyWeight {
    // 内部状态
    private final String bookName;

    public ConcreteBook(String bookName) {
        this.bookName = bookName;
        System.out.println("为《" + bookName + "》创建享元对象");
    }

    @Override
    public void locate(String location) { // location 为外部状态
        System.out.println("《" + bookName + "》位于 " + location);
    }
}
