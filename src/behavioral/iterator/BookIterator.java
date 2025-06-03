package behavioral.iterator;

/**
 * 2. 抽象迭代器 (Iterator Interface)
 */
public interface BookIterator {
    boolean hasNext();

    Book next();
}
