package structural.composite;

public class Test {
    public static void main(String[] args) {
        File file1 = new File("文件1", 100);
        File file2 = new File("文件2", 200);
        File file3 = new File("文件3", 300);
        File file4 = new File("文件4", 400);
        File file5 = new File("文件5", 500);

        Folder downloads = new Folder("Downloads");
        downloads.add(file1);
        downloads.add(file2);

        Folder pictures = new Folder("Pictures");
        pictures.add(file3);
        pictures.add(file4);

        Folder root = new Folder("root");
        root.add(downloads);
        root.add(pictures);
        root.add(file5);

        System.out.println("文件系统结构：");
        root.showDetails();

        System.out.println("删除文件2");
        root.remove(file5);
        root.showDetails();
    }
}
