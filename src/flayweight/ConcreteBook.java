package structural.flayweight;

public class ConcreteBook implements BookFlyWeight {
    private final String bookName;

    public ConcreteBook(String bookName) {
        this.bookName = bookName;
        System.out.println("为《" + bookName + "》创建享元对象");
    }

    @Override
    public void locate(String location) {
        System.out.println("《" + bookName + "》位于 " + location);
    }
}
