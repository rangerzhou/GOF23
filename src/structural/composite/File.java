package structural.composite;

public class File implements FileSystemComponent {
    private final String fileName;
    private final int size;

    public File(String fileName, int size) {
        this.fileName = fileName;
        this.size = size;
    }

    @Override
    public void showDetails() {
        System.out.println("文件名：" + fileName + ", size: " + size + "KB");
    }

    @Override
    public int getSize() {
        return size;
    }

}
