package behavioral.iterator;

/**
 * 3. 抽象聚合 (Aggregate Interface)
 */
public interface BookCollection {
    BookIterator creatIterator();
    void addBook(Book book);
}
