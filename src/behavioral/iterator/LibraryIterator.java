package behavioral.iterator;

/**
 * 5. 具体迭代器 (Concrete Iterator) - 图书馆迭代器
 */
public class LibraryIterator implements BookIterator {
    private Library library; // 持有聚合对象的引用
    private int currentIndex; // 当前遍历的位置

    public LibraryIterator(Library library) {
        this.library = library;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < library.getNumberOfBooks();
    }

    @Override
    public Book next() {
        if (hasNext()) {
            return library.getBookAt(currentIndex++);
        } else {
            return null;
        }
    }

}
