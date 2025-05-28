package structural.flayweight;

import java.util.HashMap;
import java.util.Map;

public class BookFactory {
    public static final Map<String, BookFlyWeight> bookMap = new HashMap<>();

    public static BookFlyWeight getBook(String book) {
        // 使用 computeIfAbsent 方法来创建享元对象, 如果不存在则创建并放入 map 中
        bookMap.computeIfAbsent(book, ConcreteBook::new);
        return bookMap.get(book);
    }

    public static int getBookCount() {
        return bookMap.size();
    }
}
