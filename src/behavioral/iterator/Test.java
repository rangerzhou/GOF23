package behavioral.iterator;

public class Test {
    public static void main(String[] args) {
        // 创建图书馆 (具体聚合)
        Library library = new Library();
        // 添加书籍
        library.addBook(new Book("七界传说", "心梦无痕"));
        library.addBook(new Book("诛仙", "萧鼎"));
        library.addBook(new Book("遮天", "辰东"));
        library.addBook(new Book("斗破苍穹", "天蚕土豆"));
        library.addBook(new Book("完美世界", "辰东"));
        library.addBook(new Book("斗罗大陆", "唐家三少"));

        // 客户端通过抽象聚合接口获取迭代器
        BookIterator bookIterator = library.creatIterator();
        // 客户端使用抽象迭代器接口遍历书籍
        while (bookIterator.hasNext()) {
            Book book = bookIterator.next();
            System.out.println(book.toString());
        }

    }
}
