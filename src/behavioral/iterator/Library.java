package behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 4. 具体聚合 (Concrete Aggregate) - 图书馆
 */
public class Library implements BookCollection {
    private final List<Book> bookList; // 内部使用ArrayList存储书籍

    public Library() {
        bookList = new ArrayList<>();
    }

    @Override
    public BookIterator creatIterator() {
        return new LibraryIterator(this); // 返回一个具体迭代器实例
    }

    @Override
    public void addBook(Book book) {
        bookList.add(book);
    }

    // 提供给迭代器访问内部元素的方法 (但客户端不直接调用)
    public Book getBookAt(int index) {
        if (index >= 0 && index < bookList.size()) {
            return bookList.get(index);
        }
        return null;
    }

    public int getNumberOfBooks() {
        return bookList.size();
    }
}
