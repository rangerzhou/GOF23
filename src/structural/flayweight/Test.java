package structural.flayweight;

import java.util.Random;

public class Test {
    public static final String[] books = {"红楼梦", "西游记", "三国演义", "水浒传", "金瓶梅", "封神演义"};
    public static final Random random = new Random();

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            String book = books[random.nextInt(books.length)];
            BookFlyWeight bookFlyWeight = BookFactory.getBook(book);
            bookFlyWeight.locate("书架-" + random.nextInt(1, 10));
        }

        System.out.println("\n总共创建了" + BookFactory.getBookCount() + "个享元对象");
    }
}
